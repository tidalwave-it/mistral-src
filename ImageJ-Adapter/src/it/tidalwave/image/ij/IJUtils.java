/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2006 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
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
 * $Id: IJUtils.java 136 2006-11-16 10:31:59Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.ij;

import java.util.logging.Logger;
import it.tidalwave.image.java2d.Java2DUtils;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @author  Emmanuele Sordini
 * @version $Id: IJUtils.java 136 2006-11-16 10:31:59Z fabriziogiudici $
 *
 ******************************************************************************/
public class IJUtils extends Java2DUtils
  {
    private static final String CLASS = IJUtils.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
    
    private static final int[] POWER2_SIZES = 
      {
        32, 64, 128, 256, 512, 1024, 2048, 4096, 8192
      };  
         
  /**
   *
   */
  public static int closestPower2Size(int size)
  {
    boolean foundFlag = false;
    int index = -1, result = -1;
    
    for (int i=0; i<POWER2_SIZES.length && !foundFlag; i++)
    {
      if (POWER2_SIZES[i] >= size)
      {
        foundFlag = true;
        index = i;
      }
    }
    
    if (foundFlag)
    {
      result = POWER2_SIZES[index];
    }
    
    return result;
  }

  }
