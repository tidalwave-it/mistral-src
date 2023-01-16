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
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class RotateQuadrantJ2DOp extends OperationImplementation<RotateQuadrantOp, BufferedImage>
  {
    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    protected BufferedImage execute (final RotateQuadrantOp operation,
                                     final EditableImage image,
                                     final BufferedImage bufferedImage)
      {
        final int degrees = operation.getDegrees();
        log.debug("rotateQuadrant(" + degrees + ")");
        Java2DUtils.logImage(log, ">>>> source bufferedImage", bufferedImage);

        if (degrees == 0)
          {
            return bufferedImage;
          }

        final int newWidth = bufferedImage.getWidth();
        final int newHeight = bufferedImage.getHeight();

        SampleModel sampleModel = bufferedImage.getSampleModel();

        if ((degrees == 90) || (degrees == 270))
          {
//            newWidth = bufferedImage.getHeight();
//            newHeight = bufferedImage.getWidth();
            sampleModel = sampleModel.createCompatibleSampleModel(bufferedImage.getHeight(), bufferedImage.getWidth());
          }

        final WritableRaster newRaster = Raster.createWritableRaster(sampleModel, null);
        final ColorModel colorModel = bufferedImage.getColorModel();
        final BufferedImage result =
                new BufferedImage(colorModel, newRaster, false, Java2DUtils.getProperties(bufferedImage));

//        BufferedImage result = Java2DUtils.createCompatibleImage(bufferedImage, newWidth, newHeight);
        final Graphics2D g2d = (Graphics2D)result.getGraphics();

        try
          {
            final double radians = Math.toRadians(degrees);
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

        Java2DUtils.logImage(log, ">>>> rotateQuadrant() returning ", result);

        return result;
      }
  }
