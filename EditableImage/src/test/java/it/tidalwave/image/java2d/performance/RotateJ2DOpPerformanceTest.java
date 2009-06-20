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
 * $Id: RotateJ2DOpPerformanceTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.java2d.performance;

import junit.framework.Test;
import junit.framework.TestSuite;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.RotateOp;
import it.tidalwave.image.java2d.performance.BasePerformanceTestSupport;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: RotateJ2DOpPerformanceTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class RotateJ2DOpPerformanceTest extends BasePerformanceTestSupport 
  {
    public static Test suite()
      {
        return new TestSuite(RotateJ2DOpPerformanceTest.class);
      }

    public RotateJ2DOpPerformanceTest (final String name)
      {
        super(name);  
      }
    
    protected long runTest (EditableImage image)
      {
        long accTime = 0;
      
        for (double angle = 0; angle < 360; angle += 10)
          {
            log(">>>> angle: " + angle);
            EditableImage image2 = image.execute2(new RotateOp(angle, Quality.INTERMEDIATE));
            accTime += image2.getLatestOperationTime();
          }
    
        return accTime;
      }
  }
