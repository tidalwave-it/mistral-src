/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2011 by Tidalwave s.a.s.
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
 * SCM: https://kenai.com/hg/mistral~src
 *
 **********************************************************************************************************************/
package it.tidalwave.image.java2d.performance;

import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.ScaleOp;
import static org.junit.Assert.*;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ScaleJ2DOpPerformanceTest extends BasePerformanceTestSupport 
  {
    protected long runTest (EditableImage image)
      {
        fail("disabled because it takes forever");
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
