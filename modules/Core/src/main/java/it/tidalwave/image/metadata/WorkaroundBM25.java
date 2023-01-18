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

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.iptc.IptcDirectory;
import com.drew.metadata.xmp.XmpDirectory;
import it.tidalwave.image.metadata.loader.DirectoryDrewAdapter;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class WorkaroundBM25
  {
    public WorkaroundBM25()
      {
        JpegMetadataReader.class.getName(); // Check if Drew stuff is in the classpath 
      }

    public void loadExifAndIptcFromJpeg (@Nonnull final ImageReader reader,
                                         @Nonnull final TIFF tiff,
                                         @Nonnull final EXIF exif,
                                         @Nonnull final IPTC iptc,
                                         @Nonnull final XMP xmp)
            throws IOException, JpegProcessingException
      {
        // See http://bluemarine.tidalwave.it/issues/browse/BM-25 and http://bugs.sun.com/bugdatabase/view_bug
        // .do?bug_id=4924909
        log.info("Workaround for bug BM-25");

        final var iis = (ImageInputStream)reader.getInput();
        final var pos = iis.getStreamPosition();
        iis.seek(0);

        final var is = new InputStream()
          {
            @Override
            public int available()
                    throws IOException
              {
                var l = iis.length();

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

        final var metadata = JpegMetadataReader.readMetadata(is);
        final var exifAdapter =
                new DirectoryDrewAdapter(metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class));
        exif.loadFromAdapter(exifAdapter);
        final var iptcAdapter =
                new DirectoryDrewAdapter(metadata.getFirstDirectoryOfType(IptcDirectory.class));
        iptc.loadFromAdapter(iptcAdapter);

        final var xmpDirectory = metadata.getFirstDirectoryOfType(XmpDirectory.class);
        final var xmpAdapter = new DirectoryDrewAdapter(xmpDirectory);
        xmp.loadFromAdapter(xmpAdapter);
        xmp._setProperties(xmpDirectory.getXmpProperties()); // FIXME 18 e 19

        log.debug(">>>> TIFF metadata: {}", tiff);
        log.debug(">>>> EXIF metadata: {}", exif);
        log.debug(">>>> IPTC metadata: {}", iptc);
        log.debug(">>>> XMP metadata:  {}", xmp);
        is.close();
        iis.seek(pos);
      }
  }
