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
package it.tidalwave.image.metadata.loader;

import javax.imageio.metadata.IIOMetadata;
import com.sun.media.imageio.plugins.tiff.EXIFParentTIFFTagSet;
import com.sun.media.imageio.plugins.tiff.TIFFField;
import com.sun.media.imageioimpl.plugins.tiff.TIFFIFD;
import com.sun.media.imageioimpl.plugins.tiff.TIFFImageMetadata;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class TIFFMetadataLoader implements MetadataLoader
  {
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findEXIF (final IIOMetadata iioMetadata)
      {
        final TIFFIFD rootIFD = ((TIFFImageMetadata)iioMetadata).getRootIFD();
//         logger.finer(">>>> rootIFD: " + rootIFD);
        final TIFFField field = rootIFD.getTIFFField(EXIFParentTIFFTagSet.TAG_EXIF_IFD_POINTER);
        return (field == null) ? null : (TIFFIFD)field.getData();
//         logger.finer(">>>> exifIFD: " + exifIFD);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findIPTC (final IIOMetadata iioMetadata) 
      { 
        return null;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findXMP (final IIOMetadata iioMetadata) 
      { 
        return null;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findTIFF (final IIOMetadata iioMetadata) 
      {
        return ((TIFFImageMetadata)iioMetadata).getRootIFD();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findMakerNote (final IIOMetadata iioMetadata) 
      {
        return null;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findDNG (final IIOMetadata iioMetadata) 
      {
        return null;
      }
  }
