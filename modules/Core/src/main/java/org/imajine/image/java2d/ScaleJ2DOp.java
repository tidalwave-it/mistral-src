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
package org.imajine.image.java2d;

import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import org.imajine.image.EditableImage;
import org.imajine.image.Quality;
import org.imajine.image.op.OperationImplementation;
import org.imajine.image.op.ScaleOp;
import org.imajine.image.util.Platform;
import java.util.Arrays;
import java.util.List;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ScaleJ2DOp extends OperationImplementation<ScaleOp, BufferedImage>
  {
    private static final String CLASS = ScaleJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    private static final List<String> BROKEN_LINUX_CLASSNAMES = Arrays.asList
      (
        "sun.awt.motif.X11RemoteOffScreenImage",
        "sun.java2d.x11.X11RemoteOffScreenImage" // Java 6 
      );
    
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    @Override
    protected BufferedImage execute (final ScaleOp operation, final EditableImage image, final BufferedImage bufferedImage)
      {
        final double xScale = operation.getXScale();
        final double yScale = operation.getYScale();
        final Quality quality = operation.getQuality();
        final SampleModel sampleModel = bufferedImage.getSampleModel();
        logger.fine("execute(" + xScale + ", " + yScale + ", " + quality);
        Java2DUtils.logImage(logger, ">>>> ", bufferedImage);
        final boolean optimizedImage = sampleModel.getClass().equals(SinglePixelPackedSampleModel.class);
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

        logger.fine(">>>> Scaled image size is: w=" + result.getWidth() + " h=" + result.getHeight());

        return result;
      }
  }
