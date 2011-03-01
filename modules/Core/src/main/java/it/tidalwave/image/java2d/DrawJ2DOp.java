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
package it.tidalwave.image.java2d;

import java.io.IOException;
import java.util.logging.Logger;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.DrawOp;
import it.tidalwave.image.op.OperationImplementation;
import java.io.File;
import javax.imageio.ImageIO;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class DrawJ2DOp extends OperationImplementation<DrawOp, BufferedImage>
  {
    private static final String CLASS = DrawJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected BufferedImage execute (final DrawOp operation, final EditableImage image, final BufferedImage bufferedImage)
      {
        Graphics2D g = null;

        try
          {
            g = bufferedImage.createGraphics();
//            g.drawImage(bufferedImage, 0, 0, null);
            operation.getExecutor().draw(g, image);
/*            try {
                ImageIO.write(bufferedImage, "JPEG", File.createTempFile("Draw2JDOp-Result", "jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }*/
          }
        finally
          {
            if (g != null)
              {
                g.dispose();
              }
          }

        return bufferedImage;
      }
  }
