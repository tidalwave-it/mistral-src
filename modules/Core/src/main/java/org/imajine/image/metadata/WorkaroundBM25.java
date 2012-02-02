/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2012 by Tidalwave s.a.s.
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
package org.imajine.image.metadata;

import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifDirectory;
import org.imajine.image.metadata.loader.DirectoryDrewAdapter;
import org.imajine.image.metadata.loader.DrewMetadataLoader;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class WorkaroundBM25
  {
    private static final String CLASS = WorkaroundBM25.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    public WorkaroundBM25()
      {
        JpegMetadataReader.class.getName(); // Check if Drew stuff is in the classpath 
      }

    /*******************************************************************************
     *
     * @param reader
     * @throws IOException
     * @throws JpegProcessingException
     *
     *******************************************************************************/
    public void loadEXIFFromJPEGFile (final ImageReader reader, final EXIF exif)
        throws IOException, JpegProcessingException
      {
        // See http://bluemarine.tidalwave.it/issues/browse/BM-25
        logger.warning("Workaround for bug BM-25");

        final ImageInputStream iis = (ImageInputStream)reader.getInput();
        final long pos = iis.getStreamPosition();
        iis.seek(0);

        final InputStream is = new InputStream()
          {
            @Override
            public int available ()
              throws IOException
              {
                long l = iis.length();

                if (l < 0) // sometimes returns -1 and getDirectory() fails
                  {
                    l = 100 * 1024; // FIXME: it's soo dirty...
                  }

                return (int)l;
              }

            @Override
            public int read ()
                throws IOException
              {
                return iis.read();
              }
          };

        final Metadata metadata = JpegMetadataReader.readMetadata(is);
        final DirectoryDrewAdapter adapter = new DirectoryDrewAdapter(metadata.getDirectory(ExifDirectory.class));
        exif.loadFromAdapter(adapter);
        logger.fine(">>>> EXIF metadata: " + exif);
        is.close();
        iis.seek(pos);
      }
  }
