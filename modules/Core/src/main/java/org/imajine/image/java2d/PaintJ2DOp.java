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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.image.java2d;

import java.util.logging.Logger;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.ImageObserver;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import org.imajine.image.EditableImage;
import org.imajine.image.Quality;
import org.imajine.image.render.PreviewSettings;
import org.imajine.image.op.OperationImplementation;
import org.imajine.image.op.PaintOp;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class PaintJ2DOp extends OperationImplementation<PaintOp, BufferedImage>
  {
    private static final String CLASS = PaintJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    @Override
    protected BufferedImage execute (final PaintOp operation, final EditableImage image, final BufferedImage bufferedImage)
      {
        int x = operation.getX();
        int y = operation.getY();
        int w = operation.getW();
        int h = operation.getH();
        Graphics2D g2 = operation.getGraphics2D();
        PreviewSettings previewSettings = operation.getPreviewSettings();
        ImageObserver imageObserver = operation.getImageObserver();
        Quality quality = operation.getQuality();
        logger.fine("execute(" + x + ", " + y + ", " + w + ", " + h + ", " + quality + ")");

        if (w != 0)
          {
            Object saveRenderingHints = g2.getRenderingHint(RenderingHints.KEY_INTERPOLATION);
            Object interpolation = Java2DUtils.findRenderingHintsInterpolation(quality);
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

    /*******************************************************************************
     *
     *
     ******************************************************************************/

    // FIXME: ottimizzalo, fallo lavorare solo sulla subimage visualizzata
    // FIXME: aggiungi un parametro sulla qualita', da mettere dentro PreviewSettings
    private BufferedImage applyPreviewSettings (BufferedImage image, PreviewSettings previewSettings)
      {
        BufferedImage theImage = image;

        if (previewSettings != null)
          {
            int size = DataBuffer.getDataTypeSize(image.getSampleModel().getDataType());
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
                LookupOp lOp = new LookupOp(lookupTable, null); // FIXME: hints
                Java2DUtils.logImage(logger, "applyPreviewSettings: ", image);
                theImage = lOp.filter(image, null);
              }
          }

        return theImage;
      }
  }
