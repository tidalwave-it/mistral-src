/*
 * *********************************************************************************************************************
 *
 * Mistral: open source imaging engine
 * http://tidalwave.it/projects/mistral
 *
 * Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
 *
 * *********************************************************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * *********************************************************************************************************************
 *
 * git clone https://bitbucket.org/tidalwave/mistral-src
 * git clone https://github.com/tidalwave-it/mistral-src
 *
 * *********************************************************************************************************************
 */
package it.tidalwave.image.metadata;

import java.lang.reflect.Array;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.Serializable;
import com.drew.metadata.StringValue;
import it.tidalwave.image.Rational;
import it.tidalwave.image.metadata.loader.DirectoryLoader;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import static java.util.stream.Collectors.*;
import static java.nio.charset.StandardCharsets.UTF_8;

/***********************************************************************************************************************
 *
 * This class provides basic support for all kinds   of metadata such EXIF, IPTC or maker notes.
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class Directory extends JavaBeanSupport implements Serializable
  {
    /*******************************************************************************************************************
     *
     * A descriptor for a tag.
     *
     * @param <T>   the type of the tag
     *
     **********************************************************************************************************************/
    @Immutable @RequiredArgsConstructor(staticName = "of") @Getter @ToString @EqualsAndHashCode
    public static class Tag<T>
      {
        private final int code;

        @Nonnull
        private final String name;

        @Nonnull
        private final String propertyName;

        @Nonnull
        private final Class<T> type;
      }

    private static final long serialVersionUID = 308812466726854722L;
    private static final List<DateTimeFormatter> EXIF_DATE_TIME_FORMATTERS =
            Stream.of("yyyy:MM:dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss")
                  .map(DateTimeFormatter::ofPattern).collect(toList());;

    protected final static Map<String, Tag> tagMapByCode = new HashMap<>();

    private final Map<Integer, Object> valueMapByCode = new HashMap<>();

    private final Map<String, Directory> directoryMapByName = new HashMap<>();

    private Instant latestModificationTime = Instant.now();

    private static int nextId = 1;

    private transient int idForToString;

    /*******************************************************************************************************************
     *
     * Creates an empty directory.
     *
     ******************************************************************************************************************/
    public Directory()
      {
      }

    /*******************************************************************************************************************
     *
     * Creates an empty directory with a given latest modification time.
     *
     * @param     latestModificationTime    the latest modification time
     *
     ******************************************************************************************************************/
    public Directory (final @Nonnull Instant latestModificationTime)
      {
        this.latestModificationTime = latestModificationTime;
      }

    /*******************************************************************************************************************
     *
     * Returns a value given its tag. The result is converted to the standard type of the tag (e.g. an enum).
     *
     * @param     <T>     the static type of the tag
     * @param     tag     the tag to retrieve
     * @return            the value
     *
     ******************************************************************************************************************/
    @Nonnull
    public <T> Optional<T> get (@Nonnull final Tag<T> tag)
      {
        return get(tag, tag.getType());
      }

    /*******************************************************************************************************************
     *
     * Returns a value given its tag. The result is converted to the specified type, is possible.
     *
     * @param     <U>     the static type of the tag
     * @param     <T>     the static type of the type to convert
     * @param     tag     the tag to retrieve
     * @param     asType  the type to convert the value into
     * @return            the value
     *
     ******************************************************************************************************************/
    @Nonnull
    public <T, U> Optional<T> get (@Nonnull final Tag<U> tag, @Nonnull final Class<T> asType)
      {
        return get(tag.code, asType);
      }

    /*******************************************************************************************************************
     *
     * Returns a value given its tag. The result is converted to the specified type, is possible.
     *
     * @param     <T>     the static type of the type to convert
     * @param     code    the code of the tag to retrieve
     * @param     asType  the type to convert the value into
     * @return            the value
     *
     ******************************************************************************************************************/
    @Nonnull
    public <T> Optional<T> get (@Nonnegative final int code, @Nonnull final Class<T> asType)
      {
        return Optional.ofNullable(getRaw(code)).map(v -> cast(v, asType, code));
      }

    /*******************************************************************************************************************
     *
     * Returns a value given its tag code. No type conversion is applied.
     *
     * @param    code     the code of the tag to retrieve
     * @return            the value (can be null)
     *
     ******************************************************************************************************************/
    @CheckForNull
    public Object getRaw (@Nonnegative final int code)
      {
        return valueMapByCode.get(code);
      }

    /*******************************************************************************************************************
     *
     * Sets a value for a tag. {@code null} and {@link Optional} are accepted and
     * eventually unpacked: passing {@code null} or an empty {@code Optional} is equivalent to a call to
     * {@link #remove(int)}.
     *
     * If the value is different from the previous one, events are fired:
     *
     * <ul>
     *   <li>{@code the property name}</li>
     *   <li>{@code empty}</li>
     *   <li>{@code latestModificationTime}</li>
     * </ul>
     *
     * @param     tag       the tag to retrieve
     * @param     value     the new value
     *
     ******************************************************************************************************************/
    public void set (final @Nonnull Tag<?> tag, Object value)
      {
        final var oldValue = getRaw(tag.code);
        final var oldEmpty = isEmpty();
        final var oldLatestModificationTime = getLatestModificationTime();
        setRaw(tag.code, value); // FIXME: reverse cast
        pcs.firePropertyChange(tag.propertyName, oldValue, tag.propertyName);
        pcs.firePropertyChange("empty", oldEmpty, isEmpty());
        pcs.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    /*******************************************************************************************************************
     *
     * Sets a raw value, that is without converting any type. {@code null} and {@link Optional} are accepted and
     * eventually unpacked: passing {@code null} or an empty {@code Optional} is equivalent to a call to
     * {@link #remove(int)}.
     *
     * This method does not fire events.
     *
     * @param     code      the code of the tag to set
     * @param     value     the value
     *
     ******************************************************************************************************************/
    public void setRaw (final @Nonnegative int code, Object value)
      {
        if ((value != null) && (value instanceof Optional))
          {
            if (((Optional<?>)value).isEmpty())
              {
                remove(code);
                return;
              }

            value = ((Optional<?>)value).get();
          }

        if (value.getClass().isEnum())
          {
            try
              {
                final var getValueMethod = value.getClass().getMethod("getValue");
                value = getValueMethod.invoke(value);
              }
            catch (Exception e)
              {
                throw new RuntimeException(e);
              }
          }

        valueMapByCode.put(code, value);
        touch();
      }

    /*******************************************************************************************************************
     *
     * Verifies if a value is present.
     *
     * @param     code      the code of the tag
     * @return              if the value is present
     *
     ******************************************************************************************************************/
    public boolean contains (final @Nonnegative int code)
      {
        return valueMapByCode.containsKey(code);
      }

    /*******************************************************************************************************************
     *
     * Removes a value. This method does not fire events.
     *
     * @param     code      the code of the tag to remove
     * @return              if the value is present
     *
     ******************************************************************************************************************/
    public void remove (final @Nonnegative int code)
      {
        valueMapByCode.remove(code);
        touch();
      }

    /*******************************************************************************************************************
     *
     * Returns information about a tag.
     *
     * @param     tag   the tag code
     * @return          the tag info
     *
     ******************************************************************************************************************/
    @Nonnull
    public Optional<Tag<?>> getTagInfo (@Nonnegative final int tag)
      {
        final var s = (getClass().getSimpleName() + "DirectoryGenerated").replaceAll("TIFF", "EXIF");
        return Optional.ofNullable(tagMapByCode.get(s + "." + tag));
      }

    /*******************************************************************************************************************
     *
     * Returns the tag codes contained in this directory, sorted by code.
     *
     * @return    the tag codes
     *
     ******************************************************************************************************************/
    @Nonnull
    public int[] getTagCodes()
      {
        return valueMapByCode.keySet().stream().mapToInt(Integer::intValue).sorted().toArray();
      }

    /*******************************************************************************************************************
     *
     * Returns the tags contained in this directory. Tags are sorted by code.
     *
     * @return   the tags
     *
     ******************************************************************************************************************/
    @Nonnull
    public Tag[] getTags()
      {
        return valueMapByCode.keySet().stream().sorted().map(this::toTag).toArray(Tag[]::new);
      }

    /*******************************************************************************************************************
     *
     * Iterates through all the tags calling the provided action.
     *
     * @param     action    the action to call
     *
     ******************************************************************************************************************/
    public void forEachTag (@Nonnull final Consumer<Tag<?>> action)
      {
        IntStream.of(getTagCodes()).mapToObj(this::toTag).forEach(action);
      }

    /*******************************************************************************************************************
     *
     * Iterates through all the tags and related raw values calling the provided action.
     *
     * @param     action    the action to call
     *
     ******************************************************************************************************************/
    public void forEachTag (@Nonnull final BiConsumer<Tag<?>, Object> action)
      {
        IntStream.of(getTagCodes()).mapToObj(this::toTag).forEach(t -> action.accept(t, getRaw(t.getCode())));
      }

    /*******************************************************************************************************************
     *
     * Iterates through all the tag codes calling the provided action.
     *
     * @param     action    the action to call
     *
     ******************************************************************************************************************/
    public void forEachTagCode (@Nonnull final IntConsumer action)
      {
        IntStream.of(getTagCodes()).forEach(action);
      }

    /*******************************************************************************************************************
     *
     * Checks whether this directory is empty.
     *
     * @return    {@code true} if this directory doesn't contain any tag
     *
     ******************************************************************************************************************/
    public boolean isEmpty()
      {
        return this.valueMapByCode.isEmpty();
      }

    /*******************************************************************************************************************
     *
     * Returns the names of the available subdirectories.
     *
     * @return              the names of subdirectories
     *
     ******************************************************************************************************************/
    @Nonnull
    public Set<String> getSubDirectoryNames()
      {
        return new CopyOnWriteArraySet<>(directoryMapByName.keySet());
      }

    /*******************************************************************************************************************
     *
     * Returns a subdirectory given its name.
     *
     * @param     name      the name of the subdirectory
     * @return              the subdirectory
     *
     ******************************************************************************************************************/
    @Nonnull
    public Optional<Directory> getSubDirectory (final @Nonnull String name)
      {
        return Optional.ofNullable(directoryMapByName.get(name));
      }

    /*******************************************************************************************************************
     *
     * Returns the latest modification time of this object.
     *
     * @return    the latest modification time
     *
     ******************************************************************************************************************/
    @Nonnull
    public Instant getLatestModificationTime()
      {
        return latestModificationTime;
      }

    /*******************************************************************************************************************
     *
     * Loads tags and subdirectories from the given loader.
     *
     ******************************************************************************************************************/
    public void load (final @Nonnull DirectoryLoader loader)
      {
        log.debug("load({})", loader);

        for (final var tag : loader.getTags())
          {
            valueMapByCode.put(tag, loader.getObject(tag));
          }

        for (final var directoryName : loader.getSubDirectoryNames())
          {
            final var directory = new Directory();
            directory.load(loader.getSubDirectory(directoryName));
            directoryMapByName.put(directoryName, directory);
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public final boolean equals (final Object object)
      {
        if (object == null)
          {
            return false;
          }

        if (getClass() != object.getClass())
          {
            return false;
          }

        final var other = (Directory)object;
        final var myTags = getTagCodes();
        final var otherTags = other.getTagCodes();

        if (!Arrays.equals(myTags, otherTags))
          {
            return false;
          }

        for (final var tag : myTags)
          {
            if (!equals(getRaw(tag), other.getRaw(tag)))
              {
                return false;
              }
          }

//        if (this.tagMap != other.tagMap && (this.tagMap == null || !this.tagMap.equals(other.tagMap)))
//          {
//            return false;
//          }

// FIXME        if (this.directoryMap != other.directoryMap && (this.directoryMap == null || !this.directoryMap
//  .equals(other.directoryMap)))
//          {
//            return false;
//          }

// FIXME
//        if (this.latestModificationTime != other.latestModificationTime && (this.latestModificationTime == null ||
//        !this.latestModificationTime.equals(other.latestModificationTime)))
//          {
//            return false;
//          }

        return true;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override @Nonnull
    public final String toString()
      {
        synchronized (this)
          {
            if (idForToString == 0) // first time or just deserialized
              {
                idForToString = nextId++;
              }
          }

        var name = getClass().getSimpleName();

        if ("".equals(name))
          {
            name = getClass().getName().replaceAll("^.*\\.", "");
          }

        return String.format("%s@%x[%d tags]", name, idForToString, valueMapByCode.size());
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    protected synchronized void touch()
      {
//        latestModificationTime.setTime(System.currentTimeMillis()) breaks firePropertyChange()  
        latestModificationTime = Instant.now();
      }

    /*******************************************************************************************************************
     *
     * Tries to convert a value to the target type.
     *
     * @param     <T>     the static type to convert to
     * @param     value   the value to convert
     * @param     toType  the dynamic type to convert to
     * @param     code    the tag code
     * @return            the converted value
     *
     ******************************************************************************************************************/
    @Nonnull
    private <T> T cast (@Nonnull Object value, @Nonnull final Class<T> toType, @Nonnegative final int code)
      {
        if (toType.equals(Object.class))
          {
            return toType.cast(value);
          }

        if (value instanceof Number)
          {
            try
              {
                if (toType.isEnum())
                  {
                    final var fromIntegerMethod = toType.getMethod("fromInteger", int.class);
                    value = fromIntegerMethod.invoke(null, value);
                  }
              }
            catch (Exception e)
              {
                throw new RuntimeException(e);
              }

            // Handle promotions
            if (((value instanceof Short) || (value instanceof Byte)) && toType.equals(Integer.class))
              {
                value = ((Number)value).intValue();
              }
            else if (((value instanceof Short) || (value instanceof Integer) || (value instanceof Byte)) &&
                     toType.equals(Long.class))
              {
                value = (long)((Number)value).intValue();
              }
          }

        if ((value instanceof long[][]) && Rational.class.equals(toType))
          {
            final var array = (long[][])value;
            value = Rational.of((int)array[0][0], (int)array[0][1]);
          }

        if (value instanceof StringValue)
          {
            value = ((StringValue)value).toString(UTF_8);
          }

        // If an array is asked and a scalar is available, convert it to an array[1]
        if (toType.isArray() && !value.getClass().isArray())
          {
            final var array = Array.newInstance(toType.getComponentType(), 1);
            Array.set(array, 0, value);
            value = array;
          }

        return toType.cast(value);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static boolean equals (final Object o1, final Object o2) // FIXME: check if Objects.deepEquals() would do
      {
        if (o1 == null)
          {
            return o2 == null;
          }

        if (o1.getClass().isArray())
          {
            final var length = Array.getLength(o1);

            if (length != Array.getLength(o2))
              {
                return false;
              }

            for (var i = 0; i < length; i++)
              {
                return equals(Array.get(o1, i), Array.get(o2, i));
              }
          }

        return o1.equals(o2);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public final int hashCode()
      {
        var hash = 5;

        for (final var tag : getTagCodes())
          {
            final var object = getRaw(tag);
            hash = 67 * hash + (object != null ? object.hashCode() : 0);
          }

//        hash = 67 * hash + (this.tagMap != null ? this.tagMap.hashCode() : 0);
//        hash = 67 * hash + (this.directoryMap != null ? this.directoryMap.hashCode() : 0);
// FIXME        
//        hash = 67 * hash + (this.latestModificationTime != null ? this.latestModificationTime.hashCode() : 0);
        return hash;
      }

    /*******************************************************************************************************************
     *
     * @param array
     * @return
     *
     ******************************************************************************************************************/
    @Nonnull
    public String toHexString (final @Nonnull Rational[] array)
      {
        final var buffer = new StringBuilder();

        for (var i = 0; i < array.length; i++)
          {
            if (i > 0)
              {
                buffer.append(",");
              }

            buffer.append(array[i].toString());
          }

        return buffer.toString();
      }

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    protected boolean isSubClass (@Nonnull Class aClass, final @Nonnull String ancestorClassName)
      {
        for (; aClass != null; aClass = aClass.getSuperclass())
          {
            if (aClass.getName().equals(ancestorClassName))
              {
                return true;
              }
          }

        return false;
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    protected static String formatDateTime (final Instant date)
      {
        if (date == null)
          {
            return null;
          }

        return EXIF_DATE_TIME_FORMATTERS.get(0).format(date);
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    protected static Instant parseDateTime (final String string)
      {
        if (string == null)
          {
            return null;
          }

        final var defaultZoneOffset = ZoneOffset.UTC; // of(ZoneOffset.systemDefault().getId());

        final var instant = EXIF_DATE_TIME_FORMATTERS.stream().flatMap(f ->
          {
            try
              {
                return Stream.of(LocalDateTime.parse(string, f).toInstant(defaultZoneOffset));
              }
            catch (Exception e)
              {
                return Stream.empty();
              }
          }).findFirst();

        if (instant.isEmpty())
          {
            log.warn("*** BAD DATE " + string);
          }

        return instant.orElse(null);
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Nonnull
    private Tag<?> toTag (@Nonnegative final int code)
      {
        return getTagInfo(code).orElseGet(() -> Tag.of(code, "" + code, "" + code, Object.class));
      }
  }
