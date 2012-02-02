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
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import java.awt.GraphicsConfiguration;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.SampleModel;
import javax.media.jai.ImageLayout;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.java2d.Java2DUtils;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.OptimizeOp;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
public class OptimizeJAIOp extends OperationImplementation<OptimizeOp, PlanarImage>
  {
    private static final String CLASS = OptimizeJAIOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);
            
    protected PlanarImage execute (OptimizeOp operation, final EditableImage image, PlanarImage planarImage)
      {
        Java2DUtils.logImage(logger, ">>>> source planarImage", planarImage);
        double scale = operation.getScale();
        Quality quality = operation.getQuality();

        PlanarImage result = null;
        ColorSpace sRGBColorSpace = new ICC_ColorSpace(ICC_Profile.getInstance(ColorSpace.CS_sRGB));
        GraphicsConfiguration gc = Java2DUtils.getGraphicsConfiguration();
        int width = (int)Math.round(scale * planarImage.getWidth()); // FIXME: round(), ceil() or floor()?
        int height = (int)Math.round(scale * planarImage.getHeight());
        BufferedImage targetBufferedImage = gc.createCompatibleImage(width, height);
        Java2DUtils.logImage(logger, ">>>>  targetBufferedImage", targetBufferedImage);

        ColorModel colorModel = targetBufferedImage.getColorModel();
        SampleModel sampleModel = targetBufferedImage.getSampleModel();
        ImageLayout imageLayout = new ImageLayout(0, 0, width, height, sampleModel, colorModel);
        RenderingHints hints = new RenderingHints(JAI.KEY_IMAGE_LAYOUT, imageLayout);

        // We should study to arrange operations for best performance.
        // E.g. scaling reduces the number of pixels, and converting to 8 bits maybe allows the use
        // of faster routines.
        // FIXME: the first operation also converts to sRGB color space since it's in the hints (ColorModel).
        // I'm not sure if it's really converting the colorspace if the source isn't, and if it does I'm not
        // sure it's the fastest way. And if it does, the final jaiConvertToRGBColorProfile() is useless.
        PlanarImage pImage = JAIUtils.jaiConvertTo8Bits(planarImage, hints);

        if (scale > 1.0)
          {
            pImage = JAIUtils.jaiMagnification(pImage, scale, quality, hints);
          }

        else if (scale < 1.0)
          {
            pImage = JAIUtils.jaiReduction(pImage, scale, quality, hints);
          }

        pImage = JAIUtils.jaiConvertTosRGBColorProfile(pImage, colorModel, hints);

//        boolean returnATiledImage = false;

//        if (!returnATiledImage)
//          {
//            JAIUtils.jaiCopyToBufferedImage(pImage, targetBufferedImage);
//            result = ImageModelJ2D.createImage(targetBufferedImage);
//            JAIUtils.logImage(logger, ">>>> createOptimizedImage() returning", targetBufferedImage);
//          }

//        else
          {
            // FIXME: would be nice to return a new TiledImage, but I'm not able yet to have it working quickly
            // In facts, it takes several seconds to paint and this method returns too quickly, so it appears that
            // the snapshot does not work
            planarImage = pImage.createSnapshot();
            JAIUtils.logImage(logger, ">>>> optimizeJAIOp() returning", planarImage);
          }

        /*
         if (strategy == 1) // FIXME: this will cause each next paint() to last about 25 secs...
         {
         result = createScaledImage(scale, scale, interpolationType);
         result.convertColorProfile(sRGBProfile);
         result.takeSnapshot();
         }
         */
        return planarImage;
      }
  }
