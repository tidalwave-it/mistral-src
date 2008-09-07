    /*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
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
 * $Id: TIFF.java 945 2008-09-07 09:37:16Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.metadata;

import java.util.Date;
import java.io.IOException;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: TIFF.java 945 2008-09-07 09:37:16Z fabriziogiudici $
 *
 ******************************************************************************/
public class TIFF extends EXIF // DirectoryGenerated
  {
    private WangAnnotations wangAnnotations;
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public TIFF()
      {
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public TIFF (final Date latestModificationTime)
      {
        super(latestModificationTime);
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public synchronized WangAnnotations getWangAnnotations2() 
      throws IOException
      {
        if (!isWangAnnotationAvailable())
          {
            return null;  
          }
        
        if (wangAnnotations == null)
          {
            wangAnnotations = new WangAnnotations(getWangAnnotation());
          }
        
        return wangAnnotations;
      }
  }
