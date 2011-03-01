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
package it.tidalwave.image;

import java.util.logging.Logger;
import it.tidalwave.image.render.PreviewSettings;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public abstract class Histogram
  {
    private final static String CLASS = Histogram.class.getName();
    private final static Logger logger = Logger.getLogger(CLASS);
    protected Object image;
    protected int bandCount;
    protected int bitsPerBand;

    /*******************************************************************************
     *
     * @param image
     *
     *******************************************************************************/
    protected Histogram (Object image)
      {
        this.image = image;

//        bitsPerBand = image. getBitsPerBand();
      }

    /*******************************************************************************
     *
     * @param band
     * @return
     *
     *******************************************************************************/
    public abstract int[] getFrequencies (int band);

    /*******************************************************************************
     *
     * @param band
     * @return
     *
     *******************************************************************************/
    public abstract int getMin (int band);

    /*******************************************************************************
     *
     * @param band
     * @return
     *
     *******************************************************************************/
    public abstract int getMax (int band);

    /*******************************************************************************
     *
     * @return
     *
     *******************************************************************************/
    public int getBandCount ()
      {
        return bandCount;
      }

    /*******************************************************************************
     *
     * @param previewSetting
     * @return
     *
     *******************************************************************************/
    public abstract Histogram getPreview (PreviewSettings previewSetting);

    /*******************************************************************************
     *
     * @param band
     *
     *******************************************************************************/
    protected void validateBand (int band)
      {
        // if ((band < 0) || (band >= bandCount))
        //   {
        //     throw new IllegalArgumentException("band must be in range 0.." + (bandCount - 1));
        //   }
      }
  }
