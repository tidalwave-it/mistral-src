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

import javax.annotation.Nonnull;
import java.awt.image.Kernel;

/***********************************************************************************************************************
 *
 * This class just adds to the standard Kernel the toString() implementation.
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class Kernel2 extends Kernel
  {
//    private float[] data;

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public Kernel2 (final int width, final int height, final float[] data)
      {
        super(width, height, data);
//        this.data = new float[data.length];
//        System.arraycopy(data, 0, this.data, 0, data.length);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    @Nonnull
    public String toString()
      {
        final var buffer = new StringBuilder("Kernel2[");
        buffer.append(getWidth());
        buffer.append("x");
        buffer.append(getHeight());
        buffer.append(", ");

        buffer.append(getXOrigin());
        buffer.append(";");
        buffer.append(getYOrigin());

        final var data = getKernelData(null);

        for (var i = 0; i < data.length; i++)
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
