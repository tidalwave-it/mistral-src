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

import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.RotateOp;
import lombok.extern.slf4j.Slf4j;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
@Slf4j
public class RotateJ2DOp extends OperationImplementation<RotateOp, BufferedImage>
  {
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    @Override
    protected BufferedImage execute (final RotateOp operation, final EditableImage image, final BufferedImage bufferedImage)
      {
        final double degrees = operation.getDegrees();
        final Quality quality = operation.getQuality();
        log.debug("rotate(" + degrees + ", " + quality + ")");
        Java2DUtils.logImage(log, ">>>> source bufferedImage", bufferedImage);

        BufferedImage result = bufferedImage;

        if (degrees != 0)
          {
            result = Java2DUtils.rotateWithDrawImage(bufferedImage, degrees, quality);
          }

        Java2DUtils.logImage(log, ">>>> rotate() returning ", result);

        return result;
      }
  }
