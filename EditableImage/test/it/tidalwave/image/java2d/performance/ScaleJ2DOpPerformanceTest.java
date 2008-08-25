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
 * $Id: ScaleJ2DOpPerformanceTest.java 688 2007-06-16 13:38:50Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.java2d.performance;

import junit.framework.Test;
import junit.framework.TestSuite;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.ScaleOp;
import it.tidalwave.image.java2d.performance.BasePerformanceTestSupport;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ScaleJ2DOpPerformanceTest.java 688 2007-06-16 13:38:50Z fabriziogiudici $
 *
 ******************************************************************************/
public class ScaleJ2DOpPerformanceTest extends BasePerformanceTestSupport 
  {
    public static Test suite()
      {
        return new TestSuite(ScaleJ2DOpPerformanceTest.class);
      }

    public ScaleJ2DOpPerformanceTest (final String name)
      {
        super(name);  
      }
    
    protected long runTest (EditableImage image)
      {
        long accTime = 0;
        
        for (double scale = 0.1; scale <= 1; scale += 0.1)
          {
            log(">>>> scale: " + scale);
            EditableImage image2 = image.execute2(new ScaleOp(scale, Quality.INTERMEDIATE));
            accTime += image2.getLatestOperationTime();
          }
        
        return accTime;
      }
  }
