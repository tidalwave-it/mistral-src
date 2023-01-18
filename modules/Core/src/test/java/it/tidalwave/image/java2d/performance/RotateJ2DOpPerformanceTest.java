/*
 * *********************************************************************************************************************
 *
 * Mistral: open source imaging engine
 * http://tidalwave.it/projects/mistral
 *
 * Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
 *
 * *********************************************************************************************************************
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
 * *********************************************************************************************************************
 *
 * git clone https://bitbucket.org/tidalwave/mistral-src
 * git clone https://github.com/tidalwave-it/mistral-src
 *
 * *********************************************************************************************************************
 */
package it.tidalwave.image.java2d.performance;

//~--- non-JDK imports --------------------------------------------------------

import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.RotateOp;
import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.fail;

/**
 * @author Fabrizio Giudici
 */
@Slf4j
public class RotateJ2DOpPerformanceTest extends BasePerformanceTestSupport
  {
    @Override
    protected long runTest (final EditableImage image)
      {
        fail("disabled because it takes forever");

        long accTime = 0;

        for (double angle = 0; angle < 360; angle += 10)
          {
            log.info(">>>> angle: " + angle);

            final var image2 = image.execute2(new RotateOp(angle, Quality.INTERMEDIATE));

            accTime += image2.getLatestOperationTime();
          }

        return accTime;
      }
  }


//~ Formatted by Jindent --- http://www.jindent.com
