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

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.util.Collections;
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
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Immutable @Slf4j
public class ConvertColorProfileJ2DOp extends OperationImplementation<ConvertColorProfileOp, BufferedImage>
  {
    @Override @Nonnull
    protected BufferedImage execute (@Nonnull final ConvertColorProfileOp operation,
                                     @Nonnull final EditableImage image,
                                     @Nonnull final BufferedImage bufferedImage)
      {
        final var targetProfile = operation.getIccProfile();
        log.debug("convertColorProfile({})", ImageUtils.getICCProfileName(targetProfile));
        Java2DUtils.logImage(log, ">>>> source bufferedImage", bufferedImage);

        final var sourceProfile = ImageUtils.getICCProfile(bufferedImage);
        final var sourceProfileName = ImageUtils.getICCProfileName(sourceProfile);
        log.debug(">>>> Converting profile from {}  to {}",
                  sourceProfileName,
                  ImageUtils.getICCProfileName(targetProfile));

        final var hints = new RenderingHints(Collections.emptyMap());
        hints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        final var ccOp = new ColorConvertOp(new ICC_Profile[]{targetProfile}, hints);

        // Strategy 1: it would be the best, but reduces depth to 8 bit and converts to PixelInterleavedRaster, which
        // is SLOW!
        //        image = ccOp.filter(image, null); // - produce PixelInt BYTE
        // Strategy 2: create a dest image which is already an 8-bit packed raster
        // FIXME: this reduces the depth to 8 bit, which we don't want!
        log.warn(">>>> **** WARNING: convertColorProfile() is reducing depth to 8 bit!");

        final var raster = Raster.createPackedRaster(DataBuffer.TYPE_INT,
                                                     bufferedImage.getWidth(),
                                                     bufferedImage.getHeight(),
                                                     3,
                                                     8,
                                                     null);
        final ColorSpace colorSpace = new ICC_ColorSpace(targetProfile);
        final ColorModel colorModel =
                new DirectColorModel(colorSpace, 24, 0x00ff0000, 0x0000ff00, 0x000000ff, 0, false, DataBuffer.TYPE_INT);

        final var image2 =
                new BufferedImage(colorModel, raster, false, Java2DUtils.getProperties(bufferedImage));
        final var result = ccOp.filter(bufferedImage, image2);

        // Strategy 3: work in place. It would be the best, but it does not work: produces a dark image.
        //        ccOp.filter(image, image);
        // Strategy 4: create an explicity destination image with the same SampleModel as the source, but produces a dark image
        //        BufferedImage image2 = createCopy2(false); // - stessa conseguenza dell'in place
        //        image = ccOp.filter(image, image2);
        Java2DUtils.logImage(log, ">>>> >>>> convertColorProfile() returning ", result);

        return result;
      }
  }
