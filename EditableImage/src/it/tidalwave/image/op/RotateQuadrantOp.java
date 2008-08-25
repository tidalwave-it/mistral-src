/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2006 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
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
 * $Id: RotateQuadrantOp.java 429 2007-02-01 11:40:11Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.op;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: RotateQuadrantOp.java 429 2007-02-01 11:40:11Z fabriziogiudici $
 *
 ******************************************************************************/
public class RotateQuadrantOp extends Operation
  {
    private final int degrees;

    /*******************************************************************************
     *
     * Rotates the image by a quadrant. The angle is expressed in degress and can
     * only be a multiple of 90. Rotation is counterclockwise.
     *
     * @param  degree  the rotation angle in degrees
     * @throws         IllegalArgumentException  if degrees is not a multiple of 90
     *
     ******************************************************************************/
    public RotateQuadrantOp (int degrees)
      {
        while (degrees < 0)
          {
            degrees += 360;
          }

        degrees %= 360;

        if ((degrees % 90) != 0)
          {
            throw new IllegalArgumentException("degrees should be a multiple of 90");
          }

        this.degrees = degrees;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public int getDegrees ()
      {
        return degrees;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public String toString ()
      {
        return "RotateQuadrantOp(" + degrees + ")";
      }
  }
