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
package it.tidalwave.image.op;

import it.tidalwave.image.Quality;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ScaleOp extends Operation
  {
    private final double xScale;
    private final double yScale;
    private final Quality quality;

    /*******************************************************************************
     *
     * Creates a scaled image. This method allows to choose the desired interpolation
     * algorithm.
     *
     * @param   xScale   the horizontal scale
     * @param   yScale   the vertical scale
     * @param   quality  the quality
     *
     *******************************************************************************/
    public ScaleOp (final double xScale, final double yScale, final Quality quality)
      {
        this.xScale = xScale;
        this.yScale = yScale;
        this.quality = quality;
      }

    /*******************************************************************************
     *
     * Creates a scaled image. The quality is the fastest.
     *
     * @param   scale               the scale
     * @return  the scaled image
     *
     ******************************************************************************/
    public ScaleOp (final double scale)
      {
        this(scale, scale, Quality.FASTEST);
      }

    /*******************************************************************************
     *
     * Creates a scaled image. The quality is the fastest.
     *
     * @param   hScale               the horizontal scale
     * @param   vScale               the vertical scale
     * @return  the scaled image
     *
     ******************************************************************************/
    public ScaleOp (final double hScale, final double vScale)
      {
        this(hScale, vScale, Quality.FASTEST);
      }

    /*******************************************************************************
     *
     * Creates a scaled image. This method allows to choose the desired interpolation
     * algorithm.
     *
     * @param   scale              the scale
     * @param   quality                                the quality
     * @return  the scaled image
     *
     ******************************************************************************/
    public ScaleOp (final double scale, final Quality quality)
      {
        this(scale, scale, quality);
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public double getXScale ()
      {
        return xScale;
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public double getYScale ()
      {
        return yScale;
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public Quality getQuality ()
      {
        return quality;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     *******************************************************************************/
    @Override
    public String toString ()
      {
        return "ScaleOp(xScale:" + xScale + ", yScale:" + yScale + ", quality:" + quality + ")";
      }
  }
