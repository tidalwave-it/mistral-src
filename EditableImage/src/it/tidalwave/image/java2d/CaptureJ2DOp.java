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
 * $Id: CaptureJ2DOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.java2d;

import java.util.logging.Logger;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.CaptureOp;
import it.tidalwave.image.op.OperationImplementation;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: CaptureJ2DOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class CaptureJ2DOp extends OperationImplementation<CaptureOp, BufferedImage>
  {
    private static final String CLASS = CaptureJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected BufferedImage execute (final CaptureOp operation, final EditableImage image, BufferedImage bufferedImage) 
      {
        logger.info("CaptureJ2DOp.execute(" + operation + ")");
        Java2DUtils.logImage(logger, ">>>> bufferedImage: ", bufferedImage);
        final Component component = operation.getComponent();
        final int width = component.getWidth();
        final int height = component.getHeight();
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        final Graphics g = bufferedImage.createGraphics();
            
        try
          {
//            SwingUtilities.paintComponent(g, component, component.getParent(), 0, 0, component.getWidth(), component.getHeight());
            g.setColor(component.getBackground());
            g.fillRect(0, 0, width, height);
            component.paint(g);
          }
        finally
          {
            g.dispose();
          }
        
        return bufferedImage;
      }
  }
