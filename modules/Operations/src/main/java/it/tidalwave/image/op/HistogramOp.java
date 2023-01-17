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
package it.tidalwave.image.op;

import it.tidalwave.image.Histogram;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class HistogramOp extends Operation
  {
    private Histogram histogram;

    /*******************************************************************************************************************
     *
     * Remember that this operation can take a relatively long time, so don't call
     * it from threads that can't be blocked.
     *
     ******************************************************************************************************************/
    public HistogramOp()
      {
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setHistogram (final Histogram histogram)
      {
        this.histogram = histogram;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public Histogram getHistogram()
      {
        return histogram;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public String toString()
      {
        return "HistogramOp()";
      }
  }
