/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2007 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
 *                        and Emmanuele Sordini (Emmanuele@Sordini.com)
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
 * $Id: ConvertColorProfileJ2DOp.java 592 2007-04-07 19:10:17Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.java2d;

import java.util.logging.Logger;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.ImageUtils;
import it.tidalwave.image.op.ConvertColorProfileOp;
import it.tidalwave.image.op.OperationImplementation;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ConvertColorProfileJ2DOp.java 592 2007-04-07 19:10:17Z fabriziogiudici $
 *
 ******************************************************************************/
public class ConvertColorProfileJ2DOp extends OperationImplementation<ConvertColorProfileOp, BufferedImage>
  {
    private static final String CLASS = ConvertColorProfileJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/

    // FIXME: pass another parameter to specify the quality of the operation
    protected BufferedImage execute (ConvertColorProfileOp operation, final EditableImage image, BufferedImage bufferedImage)
      {
        ICC_Profile colorProfile = operation.getICCProfile();
        logger.fine("convertColorProfile(" + ImageUtils.getICCProfileName(colorProfile) + ")");
        Java2DUtils.logImage(logger, ">>>> source bufferedImage", bufferedImage);

        ICC_Profile sourceProfile = ImageUtils.getICCProfile(bufferedImage);
        String sourceProfileName = ImageUtils.getICCProfileName(sourceProfile);
        logger.finer(">>>> Converting profile from " + sourceProfileName + " to "
            + ImageUtils.getICCProfileName(colorProfile));

        RenderingHints hints = null; // FIXME
        ColorConvertOp ccOp = new ColorConvertOp(new ICC_Profile[] { colorProfile }, hints);

        // Strategy 1: it would be the best, but reduces depth to 8 bit and converts to PixelInterleavedRaster, which is SLOW!
        //        image = ccOp.filter(image, null); // - produce PixelInt BYTE
        // Strategy 2: create a dest image which is already an 8-bit packed raster
        // FIXME: this reduces the depth to 8 bit, which we don't want!
        logger.warning(">>>> **** WARNING: convertColorProfile() is reducing depth to 8 bit!");

        WritableRaster raster = Raster.createPackedRaster(DataBuffer.TYPE_INT, bufferedImage.getWidth(),
                bufferedImage.getHeight(), 3, 8, null);
        ColorSpace colorSpace = new ICC_ColorSpace(colorProfile);
        ColorModel colorModel = new DirectColorModel(colorSpace, 24, 0x00ff0000, 0x0000ff00, 0x000000ff, 0, false,
                DataBuffer.TYPE_INT);

        BufferedImage image2 = new BufferedImage(colorModel, raster, false, Java2DUtils.getProperties(bufferedImage));
        bufferedImage = ccOp.filter(bufferedImage, image2);

        // Strategy 3: work in place. It would be the best, but it does not work: produces a dark image.
        //        ccOp.filter(image, image);
        // Strategy 4: create an explicity destination image with the same SampleModel as the source, but produces a dark image
        //        BufferedImage image2 = createCopy2(false); // - stessa conseguenza dell'in place
        //        image = ccOp.filter(image, image2);
        Java2DUtils.logImage(logger, ">>>> >>>> convertColorProfile() returning ", bufferedImage);

        return bufferedImage;
      }
  }
