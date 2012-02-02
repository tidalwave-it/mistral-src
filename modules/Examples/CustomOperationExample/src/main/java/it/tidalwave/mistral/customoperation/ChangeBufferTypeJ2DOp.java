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
package it.tidalwave.mistral.customoperation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ChangeBufferTypeJ2DOp extends OperationImplementation<ChangeBufferTypeOp, BufferedImage>
  {
    @Override
    protected BufferedImage execute (final ChangeBufferTypeOp operation, final EditableImage image, final BufferedImage bufferedImage) 
      {
        final int width = image.getWidth();
        final int height = image.getHeight();
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
