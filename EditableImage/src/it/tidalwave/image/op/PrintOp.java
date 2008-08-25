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
 * $Id: PrintOp.java 864 2008-02-13 13:41:02Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.op;

import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: PrintOp.java 864 2008-02-13 13:41:02Z fabriziogiudici $
 *
 ******************************************************************************/
public class PrintOp extends Operation
  {
    private final PrinterJob printerJob;
    private final PrintRequestAttributeSet attributeSet;
    private boolean printDialogDone = false;
    private boolean printDialogResult = false;
    private final boolean suppressDialog;
    
    public PrintOp()
      {
        this(null);
      }

    public PrintOp (final PrinterJob printerJob)
      {
        this(printerJob, null);
      }

    public PrintOp (final PrinterJob printerJob, final PrintRequestAttributeSet attributeSet)
      {
        this(printerJob, attributeSet, false);
      }
    
    public PrintOp (final PrinterJob printerJob, final PrintRequestAttributeSet attributeSet, final boolean suppressDialog)
      {
        this.printerJob = (printerJob != null) ? printerJob : PrinterJob.getPrinterJob();
        this.attributeSet = (attributeSet != null) ? attributeSet : new HashPrintRequestAttributeSet();
        this.suppressDialog = suppressDialog;
      }

    public PrinterJob getPrinterJob()
      {
        return printerJob;  
      } 
    
    public PrintRequestAttributeSet getPrintRequestAttributeSet()
      {
        return attributeSet;  
      }
    
    /** Internal use only, don't call! */
    public boolean confirmPrint() 
      {
        if (!printDialogDone)
          {
            if (!suppressDialog)
              {
                printDialogResult = printerJob.printDialog(attributeSet);
              }
            else
              {
                printDialogResult = true;  
              }
            
            printDialogDone = true;
          }
        
        return printDialogResult;
      }
    
    @Override
    public String toString()
      {
        return "PrintOp[printerJob: " + printerJob + 
                      ", attributeSet: " + attributeSet +
                      ", printDialogDone: " + printDialogDone +
                      ", printDialogResult: " + printDialogResult + "]";
      }
  }
