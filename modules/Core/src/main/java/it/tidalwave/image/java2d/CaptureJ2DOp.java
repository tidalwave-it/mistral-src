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

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.CaptureOp;
import it.tidalwave.image.op.OperationImplementation;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class CaptureJ2DOp extends OperationImplementation<CaptureOp, BufferedImage>
  {
    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    protected BufferedImage execute (final CaptureOp operation, final EditableImage image, BufferedImage bufferedImage)
      {
        log.info("CaptureJ2DOp.execute(" + operation + ")");
        Java2DUtils.logImage(log, ">>>> bufferedImage: ", bufferedImage);
        final var component = operation.getComponent();
        final var width = component.getWidth();
        final var height = component.getHeight();
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        final Graphics g = bufferedImage.createGraphics();

        try
          {
//            SwingUtilities.paintComponent(g, component, component.getParent(), 0, 0, component.getWidth(),
//            component.getHeight());
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
