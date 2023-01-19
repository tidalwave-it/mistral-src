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
package it.tidalwave.image;

import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nonnull;
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
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import it.tidalwave.util.Pair;
import it.tidalwave.image.metadata.Directory;
import it.tidalwave.image.metadata.EXIF;
import it.tidalwave.image.metadata.EXIFDirectoryGenerated;
import it.tidalwave.image.op.ReadOp;
import lombok.extern.slf4j.Slf4j;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
public abstract class BaseTestSupport
  {
    protected static final String P_TS_STOPPINGDOWN_100_20230116 = "testSet.stoppingdown_100_20230116.folder";
    protected static final Path TEST_SD100_FOLDER =
            Path.of(System.getProperty(P_TS_STOPPINGDOWN_100_20230116,
                    "(WARNING: property '" + P_TS_STOPPINGDOWN_100_20230116 + "' missing)"));

    protected static final String tmp = System.getProperty("java.io.tmpdir");
    protected static File imageFolder = new File(System.getProperty("it.tidalwave.image.test.folder", ""));
    protected static final File file_timezones32_png;
    /*
     * THIS INFO IS OBSOLETE.
     *
     * The images required for testing are not part of the distributions since they are several megabytes large.
     * You have to:
     *
     * 1. Create a new directory (outside of the project tree) that will contain all the test images.
     * 2. Edit the file 'nbproject/private/private.properties' and add the property:
     *      test-sys-prop.test.photos.dir=/full/absolute/path/to/the/new/directory
     *
     * The first test run will download once and for all the required test images.
     *
     */
    protected static final Path file_20030701_0043_jpg;
    protected static final Path file_20060603_0002_jpg;
    protected static final File file_20030701_0043_nef;
    protected static File file_L4840172_dng;
    protected static final File file_w1_tiff;
    protected static final File file_uncompressed_tiff;
    protected static final File file_fax1_tif;
    protected static final File file_IPTC1_jpg;

    protected EditableImage img20030701_0043_jpg;
    protected EditableImage img20060603_0002_jpg;
    protected EditableImage imgIPTC1_jpg;
    protected EditableImage fax1_tif;

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    static
      {
        if (!imageFolder.exists())
          {
            imageFolder = new File(tmp, "MistralTestFolder");

            System.err.printf("it.tidalwave.image.test.folder not defined, using %s\n", imageFolder);

            if (!imageFolder.exists())
              {
                imageFolder.mkdirs();
                System.err.printf("%s does not exist, creating it...\n", imageFolder);
              }
          }

        file_20030701_0043_jpg = TEST_SD100_FOLDER.resolve("20030701-0043.jpg");
        file_20060603_0002_jpg = TEST_SD100_FOLDER.resolve("20060603-0002.jpg");
        file_20030701_0043_nef = downloadFile("https://mistral.dev.java.net/images/20030701-0043.NEF");
//        file_L4840172_dng      = downloadFile("http://www.digitalworld.com.bn/images/dmr_test/raw/L4840172.DNG");
        file_timezones32_png = downloadFile("https://mistral.dev.java.net/images/timezones32.png");
        file_w1_tiff = downloadFile("https://mistral.dev.java.net/images/w1.tif");
        file_uncompressed_tiff = downloadFile("https://mistral.dev.java.net/images/uncompressed.tif");
        file_fax1_tif = downloadFile("https://mistral.dev.java.net/images/Fax_1.tif");
        file_IPTC1_jpg = downloadFile("https://mistral.dev.java.net/images/AgencyPhotographer-Example.jpg");
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    protected BaseTestSupport()
      {
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    protected static File downloadFile (final String urlString)
      {
        return null;
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @BeforeMethod
    public void setUp()
            throws Exception
      {
        /*
        final long maxMemory = Runtime.getRuntime().maxMemory();
        AssertJUnit.assertTrue("Must set -Xmx512M: " + maxMemory, maxMemory >= 500000000);
        imgIPTC1_jpg = EditableImage.create(new ReadOp(file_IPTC1_jpg));
        fax1_tif = EditableImage.create(new ReadOp(file_fax1_tif));
        */
        img20030701_0043_jpg = Files.exists(file_20030701_0043_jpg) ?
                               EditableImage.create(new ReadOp(file_20030701_0043_jpg)) : null;
        img20060603_0002_jpg = Files.exists(file_20060603_0002_jpg) ?
                               EditableImage.create(new ReadOp(file_20060603_0002_jpg)) : null;
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    protected void _testProperties (final Path file,
                                    final int expectedWidth,
                                    final int expectedHeight,
                                    final int expectedBandCount,
                                    final int expectedBitsPerBand,
                                    final int expectedBitsPerPixel,
                                    final EditableImage.DataType expectedDataType)
            throws IOException
      {
        final var image = EditableImage.create(new ReadOp(file));
        final var width = image.getWidth();
        final var height = image.getHeight();
        final var bandCount = image.getBandCount();
        final var bitsPerBand = image.getBitsPerBand();
        final var bitsPerPixel = image.getBitsPerPixel();
        final var dataType = image.getDataType();

        assertEquals(expectedWidth, width);
        assertEquals(expectedHeight, height);
        assertEquals(expectedBandCount, bandCount);
        assertEquals(expectedBitsPerBand, bitsPerBand);
        assertEquals(expectedBitsPerPixel, bitsPerPixel);
        assertEquals(expectedDataType, dataType);

        log.info(">>>> File:           " + file);
        log.info(">>>> Size:           " + width + " x " + height);
        log.info(">>>> Bands:          " + bandCount);
        log.info(">>>> Bits per bands: " + bitsPerBand);
        log.info(">>>> Bits per pixel: " + bitsPerPixel);
        log.info(">>>> Data type:      " + dataType);
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @DataProvider
    protected static Object[][] testSet_StoppingDown_100_20230116()
            throws IOException
      {
        if (!Files.exists(TEST_SD100_FOLDER))
          {
            log.warn("TEST SET PATH NOT FOUND: {}", TEST_SD100_FOLDER);
            return new Object[0][1];
          }

        final var limit = Boolean.getBoolean("it.tidalwave-ci.skipLongTests") ? 100 : 99999;

        try (final var s = Files.list(TEST_SD100_FOLDER))
          {
            return s.filter(p -> p.getFileName().toString().endsWith(".jpg"))
                    .sorted()
                    .limit(limit)
                    .map(p -> new Object[]{ "stoppingdown_100_20230116", TEST_SD100_FOLDER, p})
                    .toArray(Object[][]::new);
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
    protected static void dumpTags (@Nonnull final String directoryName,
                                    @Nonnull final Directory directory,
                                    @Nonnull final Consumer<String> consumer)
      {
        for (final var tag : directory.getTagCodes())
          {
            final var value = directory.getRawObject(tag);
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

            valueAsString += directory.getTagType(tag)
                                      .filter(Class::isEnum)
                                      .map(tagType -> toString(value, tagType))
                                      .orElse("");

            final var s = String.format("%s[%d%s]: %s",
                                        directoryName,
                                        tag,
                                        directory.getTagName(tag).map(n -> ", " + n).orElse(""),
                                        valueAsString);
            // log.info("{}", s);
            consumer.accept(s);
          }

        if (directory instanceof EXIF)
          {
            final var exif = (EXIF)directory;
            final List<Pair<String, Function<EXIF, Optional<Instant>>>> x = List.of(
                    Pair.of("dateTimeAsDate", EXIF::getDateTimeAsDate),
                    Pair.of("dateTimeOriginalAsDate", EXIF::getDateTimeOriginalAsDate),
                    Pair.of("dateTimeDigitizedAsDate", EXIF::getDateTimeDigitizedAsDate));
            x.forEach(p ->
                    p.b.apply(exif).ifPresent(i -> consumer.accept(String.format("%s %s: %s", directoryName, p.a, i))));
          }
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    protected static <T> void assertOptionalEquals (final T expected, final Optional<T> actual)
      {
        assertTrue("Empty optional", actual.isPresent());
        assertThat(actual.get(), is(expected));
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    protected static void assertOptionalEquals (final double expected, final Optional<Rational> actual)
      {
        assertTrue("Empty optional", actual.isPresent());
        assertThat(actual.get().doubleValue(), is(expected));
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    protected void assertChecksum (final String expectedChecksum, final File file)
      {
        try
          {
            final var messageDigest = MessageDigest.getInstance("MD5");
            final var buffer = new byte[128 * 1024];
            final InputStream is = new BufferedInputStream(Files.newInputStream(file.toPath()));

            for (; ; )
              {
                final var n = is.read(buffer);

                if (n <= 0)
                  {
                    break;
                  }

                messageDigest.update(buffer, 0, n);
              }

            is.close();
            final var digest = messageDigest.digest();
            final var checksum = toString(digest);
            AssertJUnit.assertEquals("Unxepected checksum for file " + file, expectedChecksum, checksum);
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
    private static String toString (@Nonnull final Object value, @Nonnull final Class<?> tagType)
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
    private static String toString (final byte[] bytes)
      {
        final var stringBuilder = new StringBuilder();

        for (var aByte : bytes)
          {
            final var s = Integer.toHexString(aByte & 0xff);

            if (s.length() < 2)
              {
                stringBuilder.append('0');
              }

            stringBuilder.append(s);
          }

        return stringBuilder.toString();
      }
  }
