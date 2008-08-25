/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2007 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
 *                        and Emmanuele Sordini (Emmanuele@Sordini.com)
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
 * $Id: ChangeBufferTypeJ2DOp.java 592 2007-04-07 19:10:17Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.java2d;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.ChangeBufferTypeOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ChangeBufferTypeJ2DOp.java 592 2007-04-07 19:10:17Z fabriziogiudici $
 *
 ******************************************************************************/
public class ChangeBufferTypeJ2DOp extends OperationImplementation<ChangeBufferTypeOp, BufferedImage>
  {
    protected BufferedImage execute (final ChangeBufferTypeOp operation, final EditableImage image, final BufferedImage bufferedImage) 
      {
        final int width = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();
        final BufferedImage result = new BufferedImage(width, height, operation.getBufferType());
        Graphics g = null;
        
        try 
          {
            g = result.createGraphics();
            g.drawImage(bufferedImage, 0, 0, null);
          } 
        finally 
          {
            if (g != null)
              {
                g.dispose();
              }
          }
        
        return result;
      }
  }
