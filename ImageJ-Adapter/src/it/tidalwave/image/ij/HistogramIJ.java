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
 * $Id: HistogramIJ.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.ij;

import java.util.logging.Logger;
import ij.ImagePlus;
import ij.plugin.Histogram;
import it.tidalwave.image.render.PreviewSettings;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: HistogramIJ.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class HistogramIJ extends it.tidalwave.image.Histogram
  {
    private final static String CLASS = HistogramIJ.class.getName();
    
    private final static Logger logger = Logger.getLogger(CLASS);

    private Histogram delegate;

    private double[] max;

    private double[] min;

    /*******************************************************************************
     * 
     * @param image
     * 
     *******************************************************************************/
    /* package */HistogramIJ (ImagePlus imagePlus)
      {
        super(imagePlus);
      }

    /*******************************************************************************
     * 
     * @inheritDoc
     * 
     *******************************************************************************/
    public int[] getFrequencies (int band)
      {
        validateBand(band);
        ensureDataComputed();
        
        throw new RuntimeException("Not implemented");
//        return delegate.getBins(band);
      }

    /*******************************************************************************
     * 
     * @inheritDoc
     * 
     *******************************************************************************/
    public int getMin (int band)
      {
        validateBand(band);
        ensureDataComputed();

        return (int)min[band];
      }

    /*******************************************************************************
     * 
     * @inheritDoc
     * 
     *******************************************************************************/
    public int getMax (int band)
      {
        validateBand(band);
        ensureDataComputed();

        return (int)max[band];
      }

    /*******************************************************************************
     * 
     * 
     * 
     *******************************************************************************/
    private void ensureDataComputed ()
      {
        synchronized (this)
          {
            if (delegate == null)
              {
                compute();
              }
          }
      }

    /*******************************************************************************
     * 
     * @inheritDoc
     * 
     *******************************************************************************/
    public void compute()
      {
        throw new RuntimeException("Not implemented");
      }

    /*******************************************************************************
     * 
     * @inheritDoc
     * 
     *******************************************************************************/
    public it.tidalwave.image.Histogram getPreview (PreviewSettings previewSetting)
      {
        throw new RuntimeException("NOT IMPLEMENTED YET!");
      }
  }
