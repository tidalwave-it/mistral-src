/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2012 by Tidalwave s.a.s.
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
package org.imajine.image.op;

import org.imajine.image.op.*;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class CropOp extends Operation
  {
    private int x;
    private int y;
    private int w;
    private int h;

    /*******************************************************************************
     *
     * Crops this image, without allocating new memory for the data.
     *
     * @param  x  the x-coordinate of the crop
     * @param  y  the y-coordinate of the crop
     * @param  w  the width of the crop
     * @param  h  the height of the crop
     *
     ******************************************************************************/
    public CropOp (int x, int y, int w, int h)
      {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public int getX ()
      {
        return x;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public int getY ()
      {
        return y;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public int getW ()
      {
        return w;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public int getH ()
      {
        return h;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    @Override
    public String toString ()
      {
        return "CropOp(x:" + x + ", y:" + y + ", w:" + w + ", h:" + h + ")";
      }
  }
