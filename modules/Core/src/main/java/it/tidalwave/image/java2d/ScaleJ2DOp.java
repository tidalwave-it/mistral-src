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

import java.util.Arrays;
import java.util.List;
import java.awt.image.BufferedImage;
import java.awt.image.SinglePixelPackedSampleModel;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.ScaleOp;
import it.tidalwave.image.util.Platform;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class ScaleJ2DOp extends OperationImplementation<ScaleOp, BufferedImage>
  {
    private static final List<String> BROKEN_LINUX_CLASSNAMES = Arrays.asList
                                                                              (
                                                                                      "sun.awt.motif" +
                                                                                      ".X11RemoteOffScreenImage",
                                                                                      "sun.java2d.x11" +
                                                                                      ".X11RemoteOffScreenImage"
                                                                                      // Java 6
                                                                              );

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    protected BufferedImage execute (final ScaleOp operation,
                                     final EditableImage image,
                                     final BufferedImage bufferedImage)
      {
        final var xScale = operation.getXScale();
        final var yScale = operation.getYScale();
        final var quality = operation.getQuality();
        final var sampleModel = bufferedImage.getSampleModel();
        log.debug("execute(" + xScale + ", " + yScale + ", " + quality);
        Java2DUtils.logImage(log, ">>>> ", bufferedImage);
        final var optimizedImage = sampleModel.getClass().equals(SinglePixelPackedSampleModel.class);
        final BufferedImage result;
        //
        // On Mac OS X AffineTransform is extremely slow with non optimized images; but it's faster with optimized ones.
        //
        if ((Platform.isMacOSX() && (quality == Quality.INTERMEDIATE)) && !optimizedImage)
          {
            result = Java2DUtils.scaleWithDrawImage(bufferedImage, xScale, yScale, quality);
          }
        //
        // On Linux AffineTransform fails if the underlying class is X11RemoteOffScreenImage.
        // See http://bluemarine.tidalwave.it/issues/browse/MST-62
        //
        else if ((Platform.isLinux() && BROKEN_LINUX_CLASSNAMES.contains(bufferedImage.getClass().getName())))
          {
            result = Java2DUtils.scaleWithDrawImage(bufferedImage, xScale, yScale, quality);
          }

        else
          {
            result = Java2DUtils.scaleWithAffineTransform(bufferedImage, xScale, yScale, quality);
          }

        log.debug(">>>> Scaled image size is: w=" + result.getWidth() + " h=" + result.getHeight());

        return result;
      }
  }
