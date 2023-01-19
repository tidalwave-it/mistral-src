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
import java.util.Optional;
import javax.imageio.metadata.IIOMetadata;
import com.sun.media.imageio.plugins.tiff.EXIFParentTIFFTagSet;
import com.sun.media.imageioimpl.plugins.tiff.TIFFIFD;
import com.sun.media.imageioimpl.plugins.tiff.TIFFImageMetadata;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class TIFFMetadataLoader implements MetadataLoader
  {
    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public Optional<DirectoryLoader> getExifLoader (final IIOMetadata iioMetadata)
      {
        final var rootIFD = ((TIFFImageMetadata)iioMetadata).getRootIFD();
//         logger.finer(">>>> rootIFD: " + rootIFD);
        final var field = rootIFD.getTIFFField(EXIFParentTIFFTagSet.TAG_EXIF_IFD_POINTER);
        return (field == null) ?
               Optional.empty() :
               Optional.of(new DirectoryTIFFLoader((TIFFIFD)field.getData()));
//         logger.finer(">>>> exifIFD: " + exifIFD);
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public Optional<DirectoryLoader> getTiffLoader (final IIOMetadata iioMetadata)
      {
        return Optional.of(new DirectoryTIFFLoader(((TIFFImageMetadata)iioMetadata).getRootIFD()));
      }
  }
