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
package it.tidalwave.image.java2d;

import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.OptimizeOp;
import it.tidalwave.image.op.OperationImplementation;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class OptimizeJ2DOp extends OperationImplementation<OptimizeOp, BufferedImage>
  {
    private static final String CLASS = OptimizeJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    @Override
    protected BufferedImage execute (OptimizeOp operation, final EditableImage image, BufferedImage bufferedImage)
      {
        Java2DUtils.logImage(logger, ">>>> source bufferedImage", bufferedImage);

        double scale = operation.getScale();
        Quality quality = operation.getQuality();
        SampleModel sampleModel = bufferedImage.getSampleModel();

        if (!(sampleModel instanceof SinglePixelPackedSampleModel))
          {
            logger.finer(">>>> calling convertToSinglePixelPackedSampleModel()");
            bufferedImage = Java2DUtils.convertToSinglePixelPackedSampleModel(bufferedImage);
            logger.finer(">>>>>>>> iccProfile is now: " + Java2DUtils.getICCProfileName(bufferedImage));
          }

        BufferedImage result = Java2DUtils.createOptimizedImage(bufferedImage, scale, scale, quality);
        Java2DUtils.logImage(logger, ">>>> createOptimizedScaledImage() returning ", result);

        return result;
      }
  }
