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
    public ScaleOp (double xScale, double yScale, Quality quality)
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
    public ScaleOp (double scale)
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
    public ScaleOp (double hScale, double vScale)
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
    public ScaleOp (double scale, Quality quality)
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
    public String toString ()
      {
        return "ScaleOp(xScale:" + xScale + ", yScale:" + yScale + ", quality:" + quality + ")";
      }
  }
