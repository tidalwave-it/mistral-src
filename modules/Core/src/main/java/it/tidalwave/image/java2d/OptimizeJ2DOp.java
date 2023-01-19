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
package it.tidalwave.image.java2d;

import java.awt.image.BufferedImage;
import java.awt.image.SinglePixelPackedSampleModel;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.OptimizeOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class OptimizeJ2DOp extends OperationImplementation<OptimizeOp, BufferedImage>
  {
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    protected BufferedImage execute (final OptimizeOp operation, final EditableImage image, BufferedImage bufferedImage)
      {
        Java2DUtils.logImage(log, ">>>> source bufferedImage", bufferedImage);

        final var scale = operation.getScale();
        final var quality = operation.getQuality();
        final var sampleModel = bufferedImage.getSampleModel();

        if (!(sampleModel instanceof SinglePixelPackedSampleModel))
          {
            log.trace(">>>> calling convertToSinglePixelPackedSampleModel()");
            bufferedImage = Java2DUtils.convertToSinglePixelPackedSampleModel(bufferedImage);
            log.trace(">>>>>>>> iccProfile is now: " + Java2DUtils.getICCProfileName(bufferedImage));
          }

        final var result = Java2DUtils.createOptimizedImage(bufferedImage, scale, scale, quality);
        Java2DUtils.logImage(log, ">>>> createOptimizedScaledImage() returning ", result);

        return result;
      }
  }
