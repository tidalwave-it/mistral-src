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

import it.tidalwave.image.Quality;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class OptimizeOp extends Operation
  {
    private double scale;
    private Quality quality;

    /*******************************************************************************************************************
     *
     * Creates a version of this image which is optimized for bit-blit operations
     * on the current display. This usually means that the image is reduced to
     * 8-bits-per-sample, converted to the sRGB color profile and changed to the
     * proper ColorModel and SampleModel.
     *
     * @param   scale     the scale
     * @param   quality   the quality
     *
     ******************************************************************************************************************/
    public OptimizeOp (final double scale, final Quality quality)
      {
        this.scale = scale;
        this.quality = quality;
      }

    /*******************************************************************************************************************
     *
     * See {@link #CreateOptimizedImageOp(double, Quality)}.
     * The used interpolation type is the fastest possible, usually nearest neighbor.
     *
     ******************************************************************************************************************/
    public OptimizeOp()
      {
        this(1.0, Quality.FASTEST);
      }

    /*******************************************************************************************************************
     *
     * See {@link #CreateOptimizedImageOp(double, Quality)}.
     * The used interpolation type is the fastest possible, usually nearest neighbor.
     *
     * @param   scale the scale
     *
     ******************************************************************************************************************/
    public OptimizeOp (final double scale)
      {
        this(scale, Quality.FASTEST);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public double getScale()
      {
        return scale;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public Quality getQuality()
      {
        return quality;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public String toString()
      {
        return "OptimizeOp(scale:" + scale + ", quality:" + quality + ")";
      }
  }
