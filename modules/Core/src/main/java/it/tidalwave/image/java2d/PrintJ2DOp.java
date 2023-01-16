/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2023 by Tidalwave s.a.s.
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
package it.tidalwave.image.java2d;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.PaintOp;
import it.tidalwave.image.op.PrintOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class PrintJ2DOp extends OperationImplementation<PrintOp, BufferedImage>
  {
    public PrintJ2DOp()
      {
      }

    @Override
    protected BufferedImage execute (final PrintOp operation, final EditableImage image, final BufferedImage model) 
      {
        final Printable printable = new Printable()
          {
            @Override
            public int print (final Graphics graphics, final PageFormat pageFormat, final int pageIndex) 
              throws PrinterException 
              {
                if (pageIndex > 0)
                  {
                    return Printable.NO_SUCH_PAGE;
                  }

                Graphics2D g2d = (Graphics2D)graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                final double xScale = pageFormat.getImageableWidth() / image.getWidth();
                final double yScale = pageFormat.getImageableHeight() / image.getHeight();
                final double aspectScale = Math.min(xScale, yScale);
                final int width = (int)Math.round(image.getWidth() * aspectScale);
                final int height = (int)Math.round(image.getHeight() * aspectScale);
                image.execute(new PaintOp(g2d, 0, 0, width, height, null, null));
                return Printable.PAGE_EXISTS;
              }  
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
