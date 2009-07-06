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
 * $Id: J2DUtilsScaleWithDrawImagePerformanceTest.java 1028 2009-07-06 16:46:00Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.java2d.performance;

import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.java2d.Java2DUtils;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: J2DUtilsScaleWithDrawImagePerformanceTest.java 1028 2009-07-06 16:46:00Z fabriziogiudici $
 *
 ******************************************************************************/
public class J2DUtilsScaleWithDrawImagePerformanceTest extends BasePerformanceTestSupport 
  {
    protected long runTest (EditableImage image)
      {
        long accTime = 0;
        
        for (double scale = 0.1; scale <= 1; scale += 0.1)
          {
            log(">>>> scale: " + scale);
            long time = System.currentTimeMillis();
            BufferedImage bufferedImage = image.getInnerProperty(BufferedImage.class);
            Java2DUtils.scaleWithDrawImage(bufferedImage, scale, scale, Quality.INTERMEDIATE);
            accTime += System.currentTimeMillis() - time;
          }
        
        return accTime;
      }
  }
