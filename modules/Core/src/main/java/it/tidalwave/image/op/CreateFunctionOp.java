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

import it.tidalwave.image.EditableImage;
import it.tidalwave.image.ImageFunction;

/***********************************************************************************************************************
 *
 * This operation creates a new image with the specified size and data type,
 * whose pixel values are computed by a given function.
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class CreateFunctionOp extends CreateOp
  {
    private final ImageFunction function;

    /*******************************************************************************************************************
     *
     * Creates a new operation which will create an image. AT THE MOMENT ONLY
     * MONOCHROMATIC IMAGES (MADE BY A SINGLE BAND) ARE SUPPORTED.
     *
     * @param  width     the image width
     * @param  height    the image height
     * @param  function  the function which computes the pixel values
     * @param  dataType  the data type
     *
     ******************************************************************************************************************/
    public CreateFunctionOp (final int width,
                             final int height,
                             final ImageFunction function,
                             final EditableImage.DataType dataType)
      {
        super(width, height, dataType);
        this.function = function;

        if (function == null)
          {
            throw new IllegalArgumentException("function cannot be null");
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public ImageFunction getImageFunction()
      {
        return function;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public String toString()
      {
        return "CreateFunctionOp(" + getWidth() + ", " + getHeight() + ", " + function + ", " + getDataType() + ")";
      }
  }
