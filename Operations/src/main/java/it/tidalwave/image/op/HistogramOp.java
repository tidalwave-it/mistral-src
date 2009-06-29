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
 * $Id: HistogramOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.op;

import it.tidalwave.image.op.*;
import it.tidalwave.image.Histogram;
import it.tidalwave.image.java2d.HistogramJava2D;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: HistogramOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class HistogramOp extends Operation
  {
    private Histogram histogram;

    /*******************************************************************************
     *
     * Remember that this operation can take a relatively long time, so don't call
     * it from threads that can't be blocked.
     *
     ******************************************************************************/
    public HistogramOp ()
      {
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public void setHistogram (Histogram histogram)
      {
        this.histogram = histogram;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public Histogram getHistogram ()
      {
        return histogram;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public String toString ()
      {
        return "HistogramOp()";
      }
  }
