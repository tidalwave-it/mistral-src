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
package it.tidalwave.image.java2d.performance;

import it.tidalwave.image.EditableImage;
import it.tidalwave.image.java2d.Java2DUtils;
import java.awt.image.BufferedImage;
import lombok.extern.slf4j.Slf4j;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
@Slf4j
public class LoggerPerformanceTest extends BasePerformanceTestSupport
  {
    @Override
    protected long runTest (EditableImage image)
      {
        long accTime = 0;
        
        for (int i = 0; i < 10; i++)
          {
            long time = System.currentTimeMillis();
            Java2DUtils.logImage(log, "test", image.getInnerProperty(BufferedImage.class));
            accTime += System.currentTimeMillis() - time;
          }
        
        return accTime;
      }
  }
