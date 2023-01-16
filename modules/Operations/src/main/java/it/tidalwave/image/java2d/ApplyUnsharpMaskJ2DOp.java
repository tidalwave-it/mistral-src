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
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.ApplyUnsharpMaskOp;
import it.tidalwave.image.op.OperationImplementation;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ApplyUnsharpMaskJ2DOp extends OperationImplementation<ApplyUnsharpMaskOp, BufferedImage>
  {
    private static final String CLASS = ApplyUnsharpMaskJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    @Override
    protected BufferedImage execute (ApplyUnsharpMaskOp operation, final EditableImage image, BufferedImage model)
      {
        double intensity = operation.getIntensity();
        double radius = operation.getRadius();
        double threshold = operation.getThreshold();
        logger.warning(">>>> unsharpMask not implemented yet!");

        return model;
      }
  }
