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
import java.util.stream.Stream;
import java.io.Serializable;
import com.drew.metadata.StringValue;
import it.tidalwave.image.Rational;
import it.tidalwave.image.metadata.loader.DirectoryLoader;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @Immutable @RequiredArgsConstructor(staticName = "of") @Getter @ToString @EqualsAndHashCode
    public static class TagInfo
      {
        @Nonnull
        private final String name;

        @Nonnull
        private final Class<?> type;
      }

    private static final long serialVersionUID = 3088068666726854722L;

    private static final List<DateTimeFormatter> EXIF_DATE_TIME_FORMATTERS =
            Stream.of("yyyy:MM:dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss")
                  .map(DateTimeFormatter::ofPattern).collect(toList());;

    protected final static Map<String, TagInfo> mapTagInfo = new HashMap<>();

    private static int nextId = 1;

    private transient int idForToString;

    private final Map<Integer, Object> tagMap = new HashMap<>();

    private final Map<String, Directory> directoryMap = new HashMap<>();

    private Instant latestModificationTime = Instant.now();

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public Directory()
      {
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public Directory (final @Nonnull Instant latestModificationTime)
      {
        this.latestModificationTime = latestModificationTime;
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
            tagMap.put(tag, loader.getObject(tag));
          }

        for (final var directoryName : loader.getSubDirectoryNames())
          {
            final var directory = new Directory();
            directory.load(loader.getSubDirectory(directoryName));
            directoryMap.put(directoryName, directory);
          }

        // log.trace(">>>> tagMap: {}", tagMap);
        // log.trace(">>>> directoryMap: {}", directoryMap);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public int[] getTagCodes()
      {
        final var result = new int[tagMap.size()];

        var i = 0;
        for (final int tag : tagMap.keySet())
          {
            result[i++] = tag;
          }

        Arrays.sort(result);

        return result;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public Set<String> getSubDirectoryNames()
      {
        return new CopyOnWriteArraySet<>(directoryMap.keySet());
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public Directory getSubDirectory (final String name)
      {
        return directoryMap.get(name);
      }

    /*******************************************************************************************************************
     *
     * Returns the raw tag value (i.e. exactly as it is stored into the file).
     *
     * @param    tag      the tag to retrieve
     * @return            the value
     *
     ******************************************************************************************************************/
    public Object getRawObject (@Nonnegative final int tag)
      {
        return tagMap.get(tag);
      }

    /*******************************************************************************************************************
     *
     * Returns a tag value converted to the specified type.
     *
     * @param    tag      the tag to retrieve
     * @param    asType   the type to convert the value into
     * @return            the value
     *
     ******************************************************************************************************************/
    @Nonnull
    public <T> Optional<T> getObject (@Nonnegative final int tag, @Nonnull final Class<T> asType)
      {
        var value = tagMap.get(tag);

        if (value == null)
          {
            return Optional.empty();
          }

        if (value instanceof Number)
          {
            // Handle Enums
            try
              {
//                final String methodName = "get" + strip(getTagName(tag));
//                final Method getter = getClass().getMethod(methodName, new Class[0]);
//                final Class returnType = getter.getReturnType();

                if (asType.isEnum())
                  {
                    final var fromIntegerMethod = asType.getMethod("fromInteger", int.class);
                    value = fromIntegerMethod.invoke(null, value);
                  }
              }
            catch (Exception e)
              {
                throw new RuntimeException(e);
              }

            // Handle promotions
            if (((value instanceof Short) || (value instanceof Byte)) && asType.equals(Integer.class))
              {
                value = ((Number)value).intValue();
              }
            else if (((value instanceof Short) || (value instanceof Integer) || (value instanceof Byte)) &&
                     asType.equals(Long.class))
              {
                value = (long)((Number)value).intValue();
              }
          }

        if ((value instanceof long[][]) && Rational.class.equals(asType))
          {
            final var array = (long[][])value;
            value = Rational.of((int)array[0][0], (int)array[0][1]);
          }

        if (value instanceof StringValue)
          {
            value = ((StringValue)value).toString(UTF_8);
          }

        // If an array is asked and a scalar is available, convert it to an array[1]
        if (asType.isArray() && !value.getClass().isArray())
          {
            final var array = Array.newInstance(asType.getComponentType(), 1);
            Array.set(array, 0, value);
            value = array;
          }

        return Optional.ofNullable(asType.cast(value));
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setObject (final @Nonnegative int tag, Object value)
      {
        if ((value != null) && (value instanceof Optional))
          {
            value = ((Optional<?>)value).orElse(null);
          }

        if ((value != null) && value.getClass().isEnum())
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

        tagMap.put(tag, value);
        touch();
      }

    /*******************************************************************************************************************
     *
     * @param tag
     * @return
     *
     ******************************************************************************************************************/
    public boolean containsTag (final @Nonnegative int tag)
      {
        return tagMap.containsKey(tag);
      }

    /*******************************************************************************************************************
     *
     * @param tag
     *
     ******************************************************************************************************************/
    public void removeTag (final @Nonnegative int tag)
      {
        tagMap.remove(tag);
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
    public Optional<TagInfo> getTagInfo (@Nonnegative final int tag)
      {
        final var s = (getClass().getSimpleName() + "DirectoryGenerated").replaceAll("TIFF", "EXIF");
        return Optional.ofNullable(mapTagInfo.get(s + "." + tag));
      }

    /*******************************************************************************************************************
     *
     * Returns the name of a tag.
     *
     * @param     tag   the tag code
     * @return          the tag name
     *
     ******************************************************************************************************************/
    @Nonnull
    public Optional<String> getTagName (@Nonnegative final int tag)
      {
        return getTagInfo(tag).map(TagInfo::getName);
      }

    /*******************************************************************************************************************
     *
     * Returns the Java type of a tag.
     *
     * @param     tag   the tag code
     * @return          the tag Java type
     *
     ******************************************************************************************************************/
    @Nonnull
    public Optional<Class<?>> getTagType (@Nonnegative final int tag)
      {
        return getTagInfo(tag).map(TagInfo::getType);
      }

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    @Nonnull
    public Instant getLatestModificationTime()
      {
        return (latestModificationTime == null) ? null : latestModificationTime;
      }

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    public boolean isAvailable()
      {
        return !this.tagMap.isEmpty();
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

        return String.format("%s@%x[%d tags]", name, idForToString, tagMap.size());
      }

    /*******************************************************************************************************************
     *
     * @param array
     * @return
     *
     ******************************************************************************************************************/
    public String toString (final byte[] array)
      {
        if (array == null)
          {
            return "null";
          }

        if (array.length > 64)
          {
            return "" + array.length + " bytes";
          }

        final var buffer = new StringBuilder();

        for (var i = 0; i < array.length; i++)
          {
            if (i > 0)
              {
                buffer.append(",");
              }

            buffer.append(Integer.toHexString(array[i] & 0xff));
          }

        return buffer.toString();
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
            if (!equals(getRawObject(tag), other.getRawObject(tag)))
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

    private static boolean equals (final Object o1, final Object o2) // FIXME: check Objects.deepEquals()
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
            final var object = getRawObject(tag);
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
    public String toString (final Rational[] array)
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
    protected boolean isSubClass (Class aClass, final String ancestorClassName)
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
  }
