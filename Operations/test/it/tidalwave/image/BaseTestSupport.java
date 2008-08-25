/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2006 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
 *                        and Emmanuele Sordini (Emmanuele@Sordini.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 *******************************************************************************
 * 
 * $Id: BaseTestSupport.java 481 2007-02-02 21:34:25Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import junit.framework.TestCase;
import it.tidalwave.image.op.ReadOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: BaseTestSupport.java 481 2007-02-02 21:34:25Z fabriziogiudici $
 *
 ******************************************************************************/
public abstract class BaseTestSupport extends TestCase 
  {
    protected static final Logger logger = Logger.getLogger("TEST");
    protected static final String tmp = System.getProperty("java.io.tmpdir");
    protected static final File imageFolder = new File(System.getProperty("test.photos.dir", ""));
    
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
    protected static final File file_20030701_0043_nef; 
    protected static final File file_L4840172_dng; 

    protected EditableImage img20030701_0043_jpg;
    
    static
      {
        if (!imageFolder.exists())
          {
            // if you see this error message running tests, read the comments above
            System.err.println("CANNOT RUN TESTS - please look at it.tidalwave.image.BaseTest! - " + imageFolder);
            System.exit(0);
          }
        
        file_20030701_0043_jpg = downloadFile("https://mistral.dev.java.net/images/20030701-0043.jpg"); 
        file_20030701_0043_nef = downloadFile("https://mistral.dev.java.net/images/20030701-0043.NEF"); 
        file_L4840172_dng      = downloadFile("http://www.digitalworld.com.bn/images/dmr_test/raw/L4840172.DNG");

        try 
          {
            InputStream is = BaseTestSupport.class.getResourceAsStream("log.properties");
            LogManager.getLogManager().readConfiguration(is);
            is.close();
            new File("log").mkdirs();
          } 
        catch (Exception e) 
          {
            e.printStackTrace();
          }
      }
    
    protected static File downloadFile (String urlString)
      {
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
            System.exit(0);
            return null; // never reached
          }
      }
    
    protected void setUp() 
      throws Exception 
      {
        assertEquals("Must set -Xmx512M", 532742144, Runtime.getRuntime().maxMemory());
        assertTrue(file_20030701_0043_jpg.exists());
        assertTrue(file_20030701_0043_nef.exists());
        img20030701_0043_jpg = EditableImage.create(new ReadOp(file_20030701_0043_jpg));
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
            assertEquals("Unxepected checksum for file " + file, expectedChecksum, checksum);
          } 
        catch (Exception e) 
          {
            throw new RuntimeException(e);
          }
      }
    
    protected void log (String message)
      {
        logger.info("**** " + message);
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
