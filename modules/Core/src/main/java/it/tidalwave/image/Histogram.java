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
package it.tidalwave.image;

import it.tidalwave.image.render.PreviewSettings;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public abstract class Histogram
  {
    protected Object image;
    protected int bandCount;
    protected int bitsPerBand;

    /*******************************************************************************************************************
     *
     * @param image
     *
     ******************************************************************************************************************/
    protected Histogram (final Object image)
      {
        this.image = image;

//        bitsPerBand = image. getBitsPerBand();
      }

    /*******************************************************************************************************************
     *
     * @param band
     * @return
     *
     ******************************************************************************************************************/
    public abstract int[] getFrequencies (int band);

    /*******************************************************************************************************************
     *
     * @param band
     * @return
     *
     ******************************************************************************************************************/
    public abstract int getMin (int band);

    /*******************************************************************************************************************
     *
     * @param band
     * @return
     *
     ******************************************************************************************************************/
    public abstract int getMax (int band);

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    public int getBandCount()
      {
        return bandCount;
      }

    /*******************************************************************************************************************
     *
     * @param previewSetting
     * @return
     *
     ******************************************************************************************************************/
    public abstract Histogram getPreview (PreviewSettings previewSetting);

    /*******************************************************************************************************************
     *
     * @param band
     *
     ******************************************************************************************************************/
    protected void validateBand (final int band)
      {
        // if ((band < 0) || (band >= bandCount))
        //   {
        //     throw new IllegalArgumentException("band must be in range 0.." + (bandCount - 1));
        //   }
      }
  }
