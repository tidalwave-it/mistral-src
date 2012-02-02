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
package org.imajine.image.metadata.loader;

import javax.imageio.metadata.IIOMetadata;
import it.tidalwave.imageio.tiff.TIFFMetadataSupport;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class RAWMetadataLoader implements MetadataLoader
  {
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findEXIF (final IIOMetadata metadata)
      {
        return ((TIFFMetadataSupport)metadata).getExifIFD();
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
    public Object findTIFF (final IIOMetadata metadata) 
      {
        return ((TIFFMetadataSupport)metadata).getPrimaryIFD();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findMakerNote (final IIOMetadata metadata) 
      {
        return ((TIFFMetadataSupport)metadata).getMakerNote();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findDNG (final IIOMetadata metadata)  
      {
        return null;
      }
  }
