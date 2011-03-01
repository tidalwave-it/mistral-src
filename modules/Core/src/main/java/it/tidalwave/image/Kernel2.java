/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2011 by Tidalwave s.a.s.
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
 * SCM: https://kenai.com/hg/mistral~src
 *
 **********************************************************************************************************************/
package it.tidalwave.image;

import java.awt.image.Kernel;


/*******************************************************************************
 *
 * This class just adds to the standard Kernel the toString() implementation.
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class Kernel2 extends Kernel
  {
    private float[] data;

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public Kernel2 (int width, int height, float[] data)
      {
        super(width, height, data);
        this.data = new float[data.length];
        System.arraycopy(data, 0, this.data, 0, data.length);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public String toString ()
      {
        StringBuffer buffer = new StringBuffer("Kernel2[");
        buffer.append(getWidth());
        buffer.append("x");
        buffer.append(getHeight());
        buffer.append(", ");

        buffer.append(getXOrigin());
        buffer.append(";");
        buffer.append(getYOrigin());

        for (int i = 0; i < data.length; i++)
          {
            if ((i % getWidth()) == 0)
              {
                buffer.append("\n    ");
              }

            else if (i > 0)
              {
                buffer.append(", ");
              }

            buffer.append(data[i]);
          }

        buffer.append("]");

        return buffer.toString();
      }
  }
