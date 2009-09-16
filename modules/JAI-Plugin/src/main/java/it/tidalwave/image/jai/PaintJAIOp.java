/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici
 *                        and Emmanuele Sordini
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
 * $Id$
 * 
 ******************************************************************************/
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import javax.media.jai.PlanarImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.render.PreviewSettings;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.PaintOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class PaintJAIOp extends OperationImplementation<PaintOp, PlanarImage>
  {
    private static final String CLASS = PaintJAIOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
            
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected PlanarImage execute (PaintOp operation, final EditableImage image, PlanarImage planarImage)
      {
        int x = operation.getX();
        int y = operation.getY();
        int w = operation.getW();
        int h = operation.getH();
        Graphics2D g2 = operation.getGraphics2D();
        PreviewSettings previewSettings = operation.getPreviewSettings();
        ImageObserver imageObserver = operation.getImageObserver();
        
        // TODO: doesn't manage tiles
        
        if (w != 0)
          {
            // TODO: doesn't deal with quality (resampling)
            // http://www.informit.com/articles/article.asp?p=23668&seqNum=3
            double scaleX = (double)w / planarImage.getWidth();
            double scaleY = (double)h / planarImage.getHeight();
            AffineTransform xform = AffineTransform.getTranslateInstance(x, y); 
            xform.concatenate(AffineTransform.getScaleInstance(scaleX, scaleY));
            g2.drawRenderedImage(planarImage, xform);
          }
        
        else
          {
            // http://www.informit.com/articles/article.asp?p=23668&seqNum=3
            AffineTransform xform = AffineTransform.getTranslateInstance(x, y);
            g2.drawRenderedImage(planarImage, xform);
          }
        
        return planarImage;
      }
  }
