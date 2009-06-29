/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici
 *                        and Emmanuele Sordini
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
 * $Id: RAWMetadataLoader.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.metadata.loader;

import javax.imageio.metadata.IIOMetadata;
import it.tidalwave.imageio.tiff.TIFFMetadataSupport;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: RAWMetadataLoader.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class RAWMetadataLoader implements MetadataLoader
  {
    /***************************************************************************
     *
     *
     **************************************************************************/
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
    public Object findIPTC (final IIOMetadata iioMetadata) 
      { 
        return null;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findTIFF (final IIOMetadata metadata) 
      {
        return ((TIFFMetadataSupport)metadata).getPrimaryIFD();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findMakerNote (final IIOMetadata metadata) 
      {
        return ((TIFFMetadataSupport)metadata).getMakerNote();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findDNG (final IIOMetadata metadata)  
      {
        return null;
      }
  }