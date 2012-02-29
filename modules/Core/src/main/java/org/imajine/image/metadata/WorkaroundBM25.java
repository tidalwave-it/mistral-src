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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.image.metadata;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifDirectory;
import com.drew.metadata.iptc.IptcDirectory;
import lombok.extern.slf4j.Slf4j;
import org.imajine.image.metadata.loader.DirectoryDrewAdapter;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class WorkaroundBM25
  {
    public WorkaroundBM25()
      {
        JpegMetadataReader.class.getName(); // Check if Drew stuff is in the classpath 
      }

    public void loadExifAndIptcFromJpeg (final @Nonnull ImageReader reader, 
                                         final @Nonnull EXIF exif, 
                                         final @Nonnull IPTC iptc)
      throws IOException, JpegProcessingException
      {
        // See http://bluemarine.tidalwave.it/issues/browse/BM-25 and http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4924909
        log.info("Workaround for bug BM-25");

        final ImageInputStream iis = (ImageInputStream)reader.getInput();
        final long pos = iis.getStreamPosition();
        iis.seek(0);

        final InputStream is = new InputStream()
          {
            @Override
            public int available()
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
            public int read()
              throws IOException
              {
                return iis.read();
              }
          };

        final Metadata metadata = JpegMetadataReader.readMetadata(is);
        final DirectoryDrewAdapter exifAdatpter = new DirectoryDrewAdapter(metadata.getDirectory(ExifDirectory.class));
        exif.loadFromAdapter(exifAdatpter);
        final DirectoryDrewAdapter iptcAdatpter = new DirectoryDrewAdapter(metadata.getDirectory(IptcDirectory.class));
        iptc.loadFromAdapter(iptcAdatpter);
        log.debug(">>>> EXIF metadata: {}", exif);
        log.debug(">>>> IPTC metadata: {}", iptc);
        is.close();
        iis.seek(pos);
      }
  }
