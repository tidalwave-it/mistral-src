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
public class RotateOp extends Operation
  {
    private final double degrees;
    private final Quality quality;

    /*******************************************************************************************************************
     *
     * Rotates the image. The angle is expressed in degrees. Rotation is
     * counterclockwise. Quality is FASTEST.
     *
     * @param  degree  the rotation angle in degrees
     *
     ******************************************************************************************************************/
    public RotateOp (final double degrees)
      {
        this(degrees, Quality.FASTEST);
      }

    /*******************************************************************************************************************
     *
     * Rotates the image. The angle is expressed in degrees. Rotation is
     * counterclockwise.
     *
     * @param  degree   the rotation angle in degrees
     * @param  quality  the quality of the operation
     *
     ******************************************************************************************************************/
    public RotateOp (double degrees, final Quality quality)
      {
        while (degrees < 0)
          {
            degrees += 360;
          }

        while (degrees >= 360)
          {
            degrees -= 360;
          }

        this.degrees = degrees;
        this.quality = quality;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public double getDegrees()
      {
        return degrees;
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
        return "RotateOp(" + degrees + ")";
      }
  }
