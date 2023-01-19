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

import java.lang.reflect.InvocationTargetException;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.security.MessageDigest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import it.tidalwave.util.Pair;
import it.tidalwave.image.Rational;
import lombok.extern.slf4j.Slf4j;
import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertThat;
import static org.testng.AssertJUnit.*;
import static org.hamcrest.CoreMatchers.*;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class MetadataTestUtils
  {
    public static final String P_IMAGE_TEST_FOLDER = "it.tidalwave.image.test.folder";
    public static final String P_TS_STOPPINGDOWN_100_20230116 = "testSet.stoppingdown_100_20230116.folder";
    public static Path imageFolder = Path.of(System.getProperty(P_IMAGE_TEST_FOLDER, ""));
    public static final Path TEST_SD100_FOLDER =
            Path.of(System.getProperty(P_TS_STOPPINGDOWN_100_20230116,
                                       "(WARNING: property '" + P_TS_STOPPINGDOWN_100_20230116 + "' missing)"));

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public static File downloadFile (final String urlString)
      {
        return null;
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public static void createTestImageFolder()
            throws IOException
      {
        if (!Files.exists(imageFolder))
          {
            imageFolder = Files.createTempDirectory("MistralTestFolder");

            log.warn("{} not defined, using {}", P_IMAGE_TEST_FOLDER, imageFolder.toAbsolutePath());

            if (!Files.exists(imageFolder))
              {
                Files.createDirectories(imageFolder);
                log.info("{} does not exist, creating it...", imageFolder.toAbsolutePath());
              }
          }
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public static List<Path> testSet_StoppingDown_100_20230116()
            throws IOException
      {
        if (!Files.exists(TEST_SD100_FOLDER))
          {
            log.warn("TEST SET PATH NOT FOUND: {}", TEST_SD100_FOLDER);
            return List.of();
          }

        final var limit = Boolean.getBoolean("it.tidalwave-ci.skipLongTests") ? 100 : 99999;

        try (final var s = Files.list(TEST_SD100_FOLDER))
          {
            return s.filter(p -> p.getFileName().toString().endsWith(".jpg"))
                    .sorted()
                    .limit(limit)
                    .collect(toList());
          }
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    /*
    private void dump (final Directory directory)
            throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
      {
        final String name = directory.getClass().getSimpleName();

        for (final int tag : directory.getTagCodes())
          {
            String string = "???";
            String type = "???";
            final Object value = directory.getObject(tag);

            if (value == null)
              {
                string = "null";
                type = "null";
              }
            else if (!value.getClass().isArray())
              {
                string = value.toString();
                type = value.getClass().getSimpleName();
              }
            else
              {
                string = (String)Arrays.class.getMethod("toString", value.getClass()).invoke(null, value);
                type = value.getClass().getSimpleName();
              }

            System.err.printf("%5d %-10s %-30s %-10s %s\n", tag, name, directory.getTagName(tag), type, string);
          }
      }
    */

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public static void dumpTags (@Nonnull final String directoryName,
                                 @Nonnull final Directory directory,
                                 @Nonnull final Consumer<String> consumer)
      {
        for (final var tag : directory.getTagCodes())
          {
            final var value = directory.getRaw(tag);
            var valueAsString = value;

            if (value instanceof byte[])
              {
                valueAsString = Arrays.toString((byte[])value);
              }
            else if (value instanceof Rational)
              {
                valueAsString = value.toString() + " - " + ((Rational)value).doubleValue();
              }
            else if (value instanceof Rational[])
              {
                var rationals = (Rational[])value;
                valueAsString = Arrays.toString(rationals) + " - "
                                + Stream.of(rationals).map(Rational::doubleValue).collect(toList());
              }
            else if (value instanceof Object[])
              {
                valueAsString = Arrays.toString((Object[])value);
              }
            else if (value instanceof Date)
              {
                valueAsString = ((Date)value).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                                             .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
              }

            valueAsString += directory.getTagInfo(tag)
                                      .map(Directory.Tag::getType)
                                      .filter(Class::isEnum)
                                      .map(tagType -> toString(value, tagType))
                                      .orElse("");

            final var s = String.format("%s[%d%s]: %s",
                                        directoryName,
                                        tag,
                                        directory.getTagInfo(tag).map(n -> ", " + n.getName()).orElse(""),
                                        valueAsString);
            consumer.accept(s);
          }

        if (directory instanceof EXIF)
          {
            final var exif = (EXIF)directory;
            final List<Pair<String, Function<EXIF, Optional<Instant>>>> x = List.of(
                    Pair.of("dateTimeAsDate", EXIF::getDateTimeAsDate),
                    Pair.of("dateTimeOriginalAsDate", EXIF::getDateTimeOriginalAsDate),
                    Pair.of("dateTimeDigitizedAsDate", EXIF::getDateTimeDigitizedAsDate));
            x.forEach(p -> p.b.apply(exif).ifPresent(i -> consumer.accept(
                    String.format("%s %s: %s", directoryName, p.a, i))));
          }
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public static <T> void assertOptionalEquals (final T expected, final Optional<T> actual)
      {
        assertTrue("Empty optional", actual.isPresent());
        assertThat(actual.get(), is(expected));
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public static void assertOptionalEquals (final double expected, final Optional<Rational> actual)
      {
        assertTrue("Empty optional", actual.isPresent());
        assertThat(actual.get().doubleValue(), is(expected));
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public void assertChecksum (final @Nonnull String expectedChecksum, final @Nonnull Path file)
      {
        try
          {
            final var messageDigest = MessageDigest.getInstance("MD5");
            final var buffer = new byte[128 * 1024];

            try (var is = new BufferedInputStream(Files.newInputStream(file)))
              {
                for (;;)
                  {
                    final var n = is.read(buffer);

                    if (n <= 0)
                      {
                        break;
                      }

                    messageDigest.update(buffer, 0, n);
                  }
              }

            final var digest = messageDigest.digest();
            final var checksum = toHexString(digest);
            assertEquals("Unexpected checksum for file " + file, expectedChecksum, checksum);
          }
        catch (Exception e)
          {
            throw new RuntimeException(e);
          }
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Nonnull
    public static String toString (@Nonnull final Object value, @Nonnull final Class<?> tagType)
      {
        try
          {
            var method = tagType.getDeclaredMethod("fromInteger", int.class);
            return " - " + method.invoke(null, Integer.parseInt(value.toString()));
          }
        catch (NumberFormatException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
          {
            log.warn("Can't get enum for: {} {} because of {}", value, tagType, e.toString());
            return "";
          }
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @CheckForNull
    public static String toHexString (final @Nullable byte[] array)
      {
        return toHexString(array, Integer.MAX_VALUE, "");
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @CheckForNull
    public static String toHexString (final @Nullable byte[] array,
                                      final @Nonnegative int maxLength,
                                      final @Nonnull String separator)
      {
        if (array == null)
          {
            return "null";
          }

        if (array.length > maxLength)
          {
            return "" + array.length + " bytes";
          }

        final var buffer = new StringBuilder();

        for (var i = 0; i < array.length; i++)
          {
            if (i > 0)
              {
                buffer.append(separator);
              }

            final var s = Integer.toHexString(array[i] & 0xff);
            buffer.append(s);

            if (s.length() < 2)
              {
                buffer.append('0');
              }
          }

        return buffer.toString();
      }
  }
