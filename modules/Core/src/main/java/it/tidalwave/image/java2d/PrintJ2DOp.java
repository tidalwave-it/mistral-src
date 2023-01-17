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
import java.awt.image.BufferedImage;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.PaintOp;
import it.tidalwave.image.op.PrintOp;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class PrintJ2DOp extends OperationImplementation<PrintOp, BufferedImage>
  {
    public PrintJ2DOp()
      {
      }

    @Override
    protected BufferedImage execute (final PrintOp operation, final EditableImage image, final BufferedImage model)
      {
        final Printable printable = (graphics, pageFormat, pageIndex) ->
          {
            if (pageIndex > 0)
              {
                return Printable.NO_SUCH_PAGE;
              }

            final Graphics2D g2d = (Graphics2D)graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            final double xScale = pageFormat.getImageableWidth() / image.getWidth();
            final double yScale = pageFormat.getImageableHeight() / image.getHeight();
            final double aspectScale = Math.min(xScale, yScale);
            final int width = (int)Math.round(image.getWidth() * aspectScale);
            final int height = (int)Math.round(image.getHeight() * aspectScale);
            image.execute(new PaintOp(g2d, 0, 0, width, height, null, null));
            return Printable.PAGE_EXISTS;
          };

        final PrinterJob pj = operation.getPrinterJob();
        pj.setPrintable(printable);

        if (operation.confirmPrint())
          {
            try
              {
                pj.print(operation.getPrintRequestAttributeSet());
              }
            catch (PrinterException e)
              {
                throw new RuntimeException(e);
              }
          }

        return model;
      }
  }
