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
 * $Id: RotateJ2DOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.java2d;

import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.RotateOp;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: RotateJ2DOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class RotateJ2DOp extends OperationImplementation<RotateOp, BufferedImage>
  {
    private static final String CLASS = RotateQuadrantJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected BufferedImage execute (RotateOp operation, final EditableImage image, BufferedImage bufferedImage)
      {
        double degrees = operation.getDegrees();
        Quality quality = operation.getQuality();
        logger.fine("rotate(" + degrees + ", " + quality + ")");
        Java2DUtils.logImage(logger, ">>>> source bufferedImage", bufferedImage);

        BufferedImage result = bufferedImage;

        if (degrees != 0)
          {
            result = Java2DUtils.rotateWithDrawImage(bufferedImage, degrees, quality);
          }

        Java2DUtils.logImage(logger, ">>>> rotate() returning ", result);

        return result;
      }
  }
