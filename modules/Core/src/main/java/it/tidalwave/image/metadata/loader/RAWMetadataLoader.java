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
import it.tidalwave.imageio.tiff.TIFFMetadataSupport;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class RAWMetadataLoader implements MetadataLoader
  {
    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override
    public Optional<DirectoryLoader> getExifLoader (@Nonnull final IIOMetadata iioMetadata)
      {
        return Optional.of(new DirectoryRawLoader(((TIFFMetadataSupport)iioMetadata).getExifIFD()));
//        final IFD newEXIFIFD = new IFD();
//
///*
//        for (Iterator j = rawMetadata.getPrimaryIFD().tags().iterator(); j.hasNext();)
//          {
//            newEXIFIFD.addTag((AbstractTag)j.next());
//          }
//*/
//        final IFD exif = ((TIFFMetadataSupport)metadata).getExifIFD();
//
//        if (exif != null)
//          {
//            for (final Iterator j = exif.tags().iterator(); j.hasNext();)
//              {
//                newEXIFIFD.addTag((AbstractTag)j.next());
//              }
//          }
//
//        return newEXIFIFD;
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override
    public Optional<DirectoryLoader> getTiffLoader (@Nonnull final IIOMetadata iioMetadata)
      {
        return Optional.of(new DirectoryRawLoader(((TIFFMetadataSupport)iioMetadata).getPrimaryIFD()));
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override
    public Optional<DirectoryLoader> getMakerNoteLoader (@Nonnull final IIOMetadata iioMetadata)
      {
        return Optional.of(new DirectoryRawLoader(((TIFFMetadataSupport)iioMetadata).getMakerNote()));
      }
  }
