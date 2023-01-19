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

import java.security.MessageDigest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import it.tidalwave.image.metadata.MetadataTestUtils;
import it.tidalwave.image.op.ReadOp;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import static it.tidalwave.image.metadata.MetadataTestUtils.*;
import static org.testng.AssertJUnit.*;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public abstract class BaseTestSupport
  {
    protected static final String tmp = System.getProperty("java.io.tmpdir");
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
    protected static final Path file_timezones32_png;
    protected static final Path file_20030701_0043_jpg;
    protected static final Path file_20060603_0002_jpg;
    protected static final Path file_20030701_0043_nef;
    protected static Path file_L4840172_dng;
    protected static final Path file_w1_tiff;
    protected static final Path file_uncompressed_tiff;
    protected static final Path file_fax1_tif;
    protected static final Path file_IPTC1_jpg;

    protected EditableImage img20030701_0043_jpg;
    protected EditableImage img20060603_0002_jpg;
    protected EditableImage imgIPTC1_jpg;
    protected EditableImage fax1_tif;

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    static
      {
        try
          {
            MetadataTestUtils.createTestImageFolder();
            file_20030701_0043_jpg = TEST_SD100_FOLDER.resolve("20030701-0043.jpg");
            file_20060603_0002_jpg = TEST_SD100_FOLDER.resolve("20060603-0002.jpg");
            file_20030701_0043_nef = downloadFile("https://mistral.dev.java.net/images/20030701-0043.NEF");
//        file_L4840172_dng      = downloadFile("http://www.digitalworld.com.bn/images/dmr_test/raw/L4840172.DNG");
            file_timezones32_png = downloadFile("https://mistral.dev.java.net/images/timezones32.png");
            file_w1_tiff = downloadFile("https://mistral.dev.java.net/images/w1.tif");
            file_uncompressed_tiff = downloadFile("https://mistral.dev.java.net/images/uncompressed.tif");
            file_fax1_tif = downloadFile("https://mistral.dev.java.net/images/Fax_1.tif");
            file_IPTC1_jpg = downloadFile("https://mistral.dev.java.net/images/AgencyPhotographer-Example.jpg");          }
        catch (IOException e)
          {
            throw new ExceptionInInitializerError(e);
          }
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

        log.info(">>>> Path:           " + file);
        log.info(">>>> Size:           " + width + " x " + height);
        log.info(">>>> Bands:          " + bandCount);
        log.info(">>>> Bits per bands: " + bitsPerBand);
        log.info(">>>> Bits per pixel: " + bitsPerPixel);
        log.info(">>>> Data type:      " + dataType);
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    protected void assertChecksum (final String expectedChecksum, final Path file)
      {
        try
          {
            final var messageDigest = MessageDigest.getInstance("MD5");
            final var buffer = new byte[128 * 1024];
            final InputStream is = new BufferedInputStream(Files.newInputStream(file));

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
            final var checksum = toHexString(digest);
            assertEquals("Unxepected checksum for file " + file, expectedChecksum, checksum);
          }
        catch (Exception e)
          {
            throw new RuntimeException(e);
          }
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @DataProvider
    protected static Object[][] testSet_StoppingDown_100_20230116()
            throws IOException
      {
        return MetadataTestUtils.testSet_StoppingDown_100_20230116().stream()
              .map(p -> new Object[]{ "stoppingdown_100_20230116", TEST_SD100_FOLDER, p})
              .toArray(Object[][]::new);
      }
  }
