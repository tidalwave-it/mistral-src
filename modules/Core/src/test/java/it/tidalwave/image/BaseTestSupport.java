/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2023 by Tidalwave s.a.s.
 *
 ***********************************************************************************************************************
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
 ***********************************************************************************************************************
 *
 * WWW: http://mistral.tidalwave.it
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package it.tidalwave.image;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import it.tidalwave.image.op.ReadOp;
import lombok.extern.slf4j.Slf4j;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
@Slf4j
public abstract class BaseTestSupport
  {
    protected static final Path PATH_TEST_SETS = Paths.get(System.getProperty("imageTestSets.folder",
                                                                           "(WARNING: imageTestSets.folder property " +
                                                                           "missing)"));
    protected static final Path TEST_SD100_FOLDER = PATH_TEST_SETS.resolve("StoppingDown_100_2023-01-16");

    protected static final String tmp = System.getProperty("java.io.tmpdir");
    protected static File imageFolder = new File(System.getProperty("it.tidalwave.image.test.folder", ""));
    protected static final File file_timezones32_png;
    /*
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
    protected static final File file_20030701_0043_jpg;
    protected static final File file_20060603_0002_jpg;
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

        file_20030701_0043_jpg = downloadFile("https://mistral.dev.java.net/images/20030701-0043.jpg");
        file_20060603_0002_jpg = downloadFile("https://mistral.dev.java.net/images/20060603-0002.jpg");
        file_20030701_0043_nef = downloadFile("https://mistral.dev.java.net/images/20030701-0043.NEF");
//        file_L4840172_dng      = downloadFile("http://www.digitalworld.com.bn/images/dmr_test/raw/L4840172.DNG");
        file_timezones32_png   = downloadFile("https://mistral.dev.java.net/images/timezones32.png");
        file_w1_tiff           = downloadFile("https://mistral.dev.java.net/images/w1.tif");
        file_uncompressed_tiff = downloadFile("https://mistral.dev.java.net/images/uncompressed.tif");
        file_fax1_tif          = downloadFile("https://mistral.dev.java.net/images/Fax_1.tif");
        file_IPTC1_jpg         = downloadFile("https://mistral.dev.java.net/images/AgencyPhotographer-Example.jpg");
      }

    protected BaseTestSupport()
      {
      }

    protected static File downloadFile (String urlString)
      {
        return null;
        /*
        try
          {
            URL url = new URL(urlString);
            File file = new File(imageFolder, "From The Web/" + url.getHost() + "/" + url.getPath());

            if (!file.exists())
              {
                System.err.println("Downloading test file from " + url + " - I'll do this only once");
                URLConnection connection = url.openConnection();
                int contentLenght = connection.getContentLength();
                System.err.println("    " + contentLenght + " bytes");
                InputStream is = connection.getInputStream();
                file.getParentFile().mkdirs();
                OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
                byte[] buffer = new byte[512 * 1024];
                int done = 0;
                int previousPerc = 0;

                for (;;)
                  {
                    int n = is.read(buffer);

                    if (n <= 0)
                      {
                        break;
                      }

                    os.write(buffer, 0, n);
                    done += n;
                    int perc = (100 * done) / contentLenght;

                    if (perc != previousPerc)
                      {
                        previousPerc = perc;
                        System.err.print("Downloading test file from " + url + " - " + perc + "%...\n");
                      }
                  }

                System.err.println("Downloading test file from " + url + " - done");
                is.close();
                os.close();
              }

            return file;
          }
        catch (IOException e)
          {
            e.printStackTrace();
            return null;
          }
         */
      }

    @BeforeMethod
	public void setUp()
      throws Exception
      {
        /*
        final long maxMemory = Runtime.getRuntime().maxMemory();
        AssertJUnit.assertTrue("Must set -Xmx512M: " + maxMemory, maxMemory >= 500000000);
        AssertJUnit.assertTrue(file_20030701_0043_jpg.exists());
        AssertJUnit.assertTrue(file_20060603_0002_jpg.exists());
        AssertJUnit.assertTrue(file_20030701_0043_nef.exists());
        img20030701_0043_jpg = EditableImage.create(new ReadOp(file_20030701_0043_jpg));
        img20060603_0002_jpg = EditableImage.create(new ReadOp(file_20060603_0002_jpg));
        imgIPTC1_jpg = EditableImage.create(new ReadOp(file_IPTC1_jpg));
        fax1_tif = EditableImage.create(new ReadOp(file_fax1_tif));
        */
      }

    protected void assertChecksum (String expectedChecksum, File file)
      {
        try
          {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[128 * 1024];
            InputStream is = new BufferedInputStream(new FileInputStream(file));

            for (;;)
              {
                int n = is.read(buffer);

                if (n <= 0)
                  {
                    break;
                  }

                messageDigest.update(buffer, 0, n);
              }

            is.close();
            byte[] digest = messageDigest.digest();
            String checksum = toString(digest);
            AssertJUnit.assertEquals("Unxepected checksum for file " + file, expectedChecksum, checksum);
          }
        catch (Exception e)
          {
            throw new RuntimeException(e);
          }
      }

    private static String toString (byte[] bytes)
      {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < bytes.length; i++)
          {
            String s = Integer.toHexString(bytes[i] & 0xff);

            if (s.length() < 2)
              {
                stringBuilder.append('0');
              }

            stringBuilder.append(s);
          }

        return stringBuilder.toString();
      }
  }
