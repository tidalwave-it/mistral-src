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
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.ImageObserver;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.PaintOp;
import it.tidalwave.image.render.PreviewSettings;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class PaintJ2DOp extends OperationImplementation<PaintOp, BufferedImage>
  {
    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    protected BufferedImage execute (final PaintOp operation,
                                     final EditableImage image,
                                     final BufferedImage bufferedImage)
      {
        final int x = operation.getX();
        final int y = operation.getY();
        final int w = operation.getW();
        final int h = operation.getH();
        final Graphics2D g2 = operation.getGraphics2D();
        final PreviewSettings previewSettings = operation.getPreviewSettings();
        final ImageObserver imageObserver = operation.getImageObserver();
        final Quality quality = operation.getQuality();
        log.debug("execute(" + x + ", " + y + ", " + w + ", " + h + ", " + quality + ")");

        if (w != 0)
          {
            final Object saveRenderingHints = g2.getRenderingHint(RenderingHints.KEY_INTERPOLATION);
            final Object interpolation = Java2DUtils.findRenderingHintsInterpolation(quality);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, interpolation);
            g2.drawImage(applyPreviewSettings(bufferedImage, previewSettings), x, y, w, h, imageObserver);

            if (saveRenderingHints != null)
              {
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, saveRenderingHints);
              }
          }

        else
          {
            g2.drawImage(applyPreviewSettings(bufferedImage, previewSettings), x, y, imageObserver);
          }

        return bufferedImage;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/

    // FIXME: ottimizzalo, fallo lavorare solo sulla subimage visualizzata
    // FIXME: aggiungi un parametro sulla qualita', da mettere dentro PreviewSettings
    private BufferedImage applyPreviewSettings (final BufferedImage image, final PreviewSettings previewSettings)
      {
        BufferedImage theImage = image;

        if (previewSettings != null)
          {
            final int size = DataBuffer.getDataTypeSize(image.getSampleModel().getDataType());
            LookupTable lookupTable = null;

            switch (size)
              {
                case 8:
                case 32: // packed model
                  lookupTable = previewSettings.getLookupTable8bit();

                  break;

                case 16:
                  lookupTable = previewSettings.getLookupTable16bit();

                  break;

                default:
                  throw new IllegalArgumentException("DataSize is " + size);
              }

            if (lookupTable != null)
              {
                final LookupOp lOp = new LookupOp(lookupTable, null); // FIXME: hints
                Java2DUtils.logImage(log, "applyPreviewSettings: ", image);
                theImage = lOp.filter(image, null);
              }
          }

        return theImage;
      }
  }
