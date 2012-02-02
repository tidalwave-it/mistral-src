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
package org.imajine.image.jai;

import java.awt.RenderingHints;
import java.awt.image.Kernel;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.Interpolation;
import javax.media.jai.operator.ConvolveDescriptor;
import javax.media.jai.operator.ScaleDescriptor;
import org.imajine.image.EditableImage;
import org.imajine.image.Quality;
import org.imajine.image.op.OperationImplementation;
import org.imajine.image.op.SizeOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Luca Forni
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class SizeJAIOp extends OperationImplementation<SizeOp, PlanarImage>
  {
    @Override
    protected PlanarImage execute (final SizeOp operation, final EditableImage image, final PlanarImage planarImage)
      {
        final RenderingHints hints = null; // FIXME
        final float scale = (float)operation.getScale();
        final Quality quality = Quality.BEST;
        PlanarImage result = planarImage;

        float scaleX = scale;
        float widthScaled = result.getWidth() * scaleX;
        widthScaled = Math.round(widthScaled - 0.5f);
        scaleX = widthScaled / result.getWidth();

        float scaleY = scale;
        float heightScaled = result.getHeight() * scaleY;
        heightScaled = Math.round(heightScaled - 0.5f);
        scaleY = heightScaled / result.getHeight();

        if (scale > 1.0)
          {
            result = JAIUtils.jaiMagnification(planarImage, scale, quality, hints);
          }

        else if (scale < 1.0)
          {
//            result = JAIUtils.jaiReduction(planarImage, scale, quality, hints);
            final float ZERO = 0.0f;

            if (scale > 0.5)
              {
                final Interpolation interpolation = Interpolation.getInstance(Interpolation.INTERP_BILINEAR);
                log.debug(">>>>>>>> Scale({}, {})", scale, interpolation);
                result = ScaleDescriptor.create(planarImage, scaleX, scaleY, ZERO, ZERO, interpolation, hints);
              }

            else // scale <= 0.5
              {
            	int n = (int)Math.round(1.0 / scale);
            	n = (n > 3) ? 3 : n; //max valore per kernel = 3
                final Kernel averagingKernel = JAIUtils.getAveragingKernel(n);
                log.debug(">>>>>>>> Convolve() with averaging kernel: {}", averagingKernel);
                result = ConvolveDescriptor.create(planarImage, new KernelJAI(averagingKernel), hints);

                final Interpolation interpolation = Interpolation.getInstance(Interpolation.INTERP_NEAREST);
                log.debug(">>>>>>>> Scale({}, {})", scale, interpolation);
                result = ScaleDescriptor.create(result, scaleX, scaleY, ZERO, ZERO, interpolation, hints);
              }
          }

        JAIUtils.logImage(log, ">>>> SizeJAIOp returning", result);

        return result;
      }
  }

