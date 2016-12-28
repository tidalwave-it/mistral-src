/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2012 by Tidalwave s.a.s.
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
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.RotateQuadrantOp;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class RotateQuadrantJ2DOp extends OperationImplementation<RotateQuadrantOp, BufferedImage>
  {
    private static final String CLASS = RotateQuadrantJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    @Override
    protected BufferedImage execute (RotateQuadrantOp operation, final EditableImage image, BufferedImage bufferedImage)
      {
        int degrees = operation.getDegrees();
        logger.fine("rotateQuadrant(" + degrees + ")");
        Java2DUtils.logImage(logger, ">>>> source bufferedImage", bufferedImage);

        if (degrees == 0)
          {
            return bufferedImage;
          }

        int newWidth = bufferedImage.getWidth();
        int newHeight = bufferedImage.getHeight();

        SampleModel sampleModel = bufferedImage.getSampleModel();

        if ((degrees == 90) || (degrees == 270))
          {
//            newWidth = bufferedImage.getHeight();
//            newHeight = bufferedImage.getWidth();
            sampleModel = sampleModel.createCompatibleSampleModel(bufferedImage.getHeight(), bufferedImage.getWidth());
          }

        WritableRaster newRaster = Raster.createWritableRaster(sampleModel, null);
        ColorModel colorModel = bufferedImage.getColorModel();
        BufferedImage result = new BufferedImage(colorModel, newRaster, false, Java2DUtils.getProperties(bufferedImage));

//        BufferedImage result = Java2DUtils.createCompatibleImage(bufferedImage, newWidth, newHeight);
        Graphics2D g2d = (Graphics2D)result.getGraphics();

        try
          {
            double radians = Math.toRadians(degrees);
            g2d.transform(AffineTransform.getRotateInstance(radians));

            int x = 0;
            int y = 0;

            switch (degrees)
              {
                case 90:
                    y = -bufferedImage.getHeight();

                    break;

                case 180:
                    x = -bufferedImage.getWidth();
                    y = -bufferedImage.getHeight();

                    break;

                case 270:
                    x = -bufferedImage.getWidth();

                    break;
              }

            g2d.drawImage(bufferedImage, x, y, null);
          }

        finally
          {
            g2d.dispose();
          }

        Java2DUtils.logImage(logger, ">>>> rotateQuadrant() returning ", result);

        return result;
      }
  }
