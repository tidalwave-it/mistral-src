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
package it.tidalwave.image.metadata.loader;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.iptc.IptcDirectory;
import com.drew.metadata.xmp.XmpDirectory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class JpegDrewMetadataLoader implements MetadataLoader
  {
    @Nonnull
    private final Metadata metadata;

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @RequiredArgsConstructor
    static class InputStreamAdapter extends InputStream
      {
        @Nonnull
        private final ImageInputStream iis;

        @Override
        public int available()
                throws IOException
          {
            var l = (int)iis.length(); // sometimes returns -1 and getDirectory() fails
            return l < 0 ? Integer.MAX_VALUE : l;
          }

        @Override
        public int read()
                throws IOException
          {
            return iis.read();
          }
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public JpegDrewMetadataLoader (@Nonnull final ImageReader reader)
      {
        try
          {
            final var iis = (ImageInputStream)reader.getInput();
            final var pos = iis.getStreamPosition();
            iis.seek(0);
            final var is = new InputStreamAdapter(iis);
            metadata = ImageMetadataReader.readMetadata(is);

            // OTHER DIRECTORIES: JPEG JFIF
/*
            for (var directory : metadata.getDirectories())
              {
                for (var tag : directory.getTags())
                  {
                    log.debug("[{}] - {} = {}",
                                      directory.getName(), tag.getTagName(), tag.getDescription());
                  }
                if (directory.hasErrors())
                  {
                    for (var error : directory.getErrors())
                      {
                        log.warn("ERROR: {}", error);
                      }
                  }
              }
 */

            iis.seek(pos);
          }
        catch (IOException | ImageProcessingException e)
          {
            throw new RuntimeException(e);
          }
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public Optional<DirectoryLoader> getTiffLoader (IIOMetadata iioMetadata)
      {
        return Optional.of(new DirectoryDrewLoader(list(metadata.getDirectoriesOfType(ExifIFD0Directory.class)), 0));
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public Optional<DirectoryLoader> getExifLoader (IIOMetadata iioMetadata)
      {
        return Optional.of(new DirectoryDrewLoader(list(metadata.getDirectoriesOfType(ExifSubIFDDirectory.class)), 0));
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public Optional<DirectoryLoader> getIptcLoader (IIOMetadata iioMetadata)
      {
        return Optional.of(new DirectoryDrewLoader(list(metadata.getDirectoriesOfType(IptcDirectory.class)), 0));
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public Optional<DirectoryLoader> getXmpLoader (IIOMetadata iioMetadata)
      {
        return Optional.of(new DirectoryDrewLoader(list(metadata.getDirectoriesOfType(XmpDirectory.class)), 0));
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Nonnull
    private static <T> List<T> list (@Nonnull final Collection<T> collection)
      {
        return new ArrayList<>(collection);
      }
  }
