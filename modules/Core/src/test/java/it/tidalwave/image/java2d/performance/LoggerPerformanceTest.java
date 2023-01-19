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

import javax.annotation.Nonnull;
import java.time.Duration;
import java.time.Instant;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.java2d.Java2DUtils;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class LoggerPerformanceTest extends BasePerformanceTestSupport
  {
    @Override @Nonnull
    protected Duration runTest (final @Nonnull EditableImage image)
      {
        var accTime = Duration.ZERO;

        for (var i = 0; i < 10; i++)
          {
            final var time = Instant.now();
            Java2DUtils.logImage(log, "test", image.getInnerProperty(BufferedImage.class));
            accTime = accTime.plus(Duration.between(Instant.now(), time));
          }

        return accTime;
      }
  }
