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
package it.tidalwave.image.op;

import java.awt.Color;
import it.tidalwave.image.EditableImage;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class CreateOp extends AbstractCreateOp
  {
    private final int width;
    private final int height;
    private final EditableImage.DataType dataType;
    private final double[] filler;

    /*******************************************************************************
     *
     * Create a black monochromatic image (i.e. made of a single band) with the
     * specified data type.
     *
     * @param  width     the image width
     * @param  height    the image height
     * @param  dataType  the data type
     *
     *******************************************************************************/
    public CreateOp (final int width, final int height, final EditableImage.DataType dataType)
      {
        this(width, height, dataType, 0f);
      }

    /*******************************************************************************
     *
     * Create an RGB image with the specified data type.
     *
     * @param  width     the image width
     * @param  height    the image height
     * @param  dataType  the data type
     * @param  color     the filler color
     *
     *******************************************************************************/
    public CreateOp (final int width, final int height, final EditableImage.DataType dataType, final Color color)
      {
        this(width, height, dataType, toDoubles(color, dataType));
      }

    /*******************************************************************************
     *
     * Create a multi-band image with the specified data type. Ploase note that 
     * while the <code>filler</code> param is <code>double</code>, its valid 
     * range depends on the <code>dataType</code>. For instance, while for
     * <code>FLOAT</code> and <code>DOUBLE</code> types the range is 0.0..1.0,
     * for <code>BYTE<code> is 0..255, for <code>UNSIGNED_SHORT</code> is 
     * 0..65535 and so on.
     *
     * @param  width     the image width
     * @param  height    the image height
     * @param  dataType  the data type
     * @param  filler    the filler values
     *
     *******************************************************************************/
    public CreateOp (final int width, final int height, final EditableImage.DataType dataType, final double... filler)
      {
        if (width <= 0)
          {
            throw new IllegalArgumentException("width must be positive");
          }

        if (height <= 0)
          {
            throw new IllegalArgumentException("height must be positive");
          }

        if (dataType == null)
          {
            throw new IllegalArgumentException("dataType cannot be null");
          }

        if ((filler == null) || (filler.length == 0))
          {
            throw new IllegalArgumentException("filler cannot be null or 0-sized");
          }

        this.width = width;
        this.height = height;
        this.dataType = dataType;
        this.filler = filler;
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public int getWidth ()
      {
        return width;
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public int getHeight ()
      {
        return height;
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public EditableImage.DataType getDataType ()
      {
        return dataType;
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public double[] getFiller ()
      {
        return filler;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     *******************************************************************************/
    @Override
    public String toString ()
      {
        return "CreateOp(" + width + ", " + height + ", " + dataType + ", " + filler + ")";
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    private static double[] toDoubles (final Color color, final EditableImage.DataType dataType)
      {
        final double[] result = { color.getRed(), color.getGreen(), color.getBlue() };
        double scale = 1;
        final double F = 1.0 / 255.0;

        switch (dataType)
          {
            case BYTE:
                break;

            case SHORT:
                scale = F * (Math.pow(2, 15) - 1);

                break;

            case UNSIGNED_SHORT:
                scale = F * (Math.pow(2, 16) - 1);

                break;

            case INT:
                scale = F * (Math.pow(2, 31) - 1);

                break;

            case FLOAT:
            case DOUBLE:
                scale = F;
                break;

            default:
                throw new IllegalArgumentException("toDoubles: " + dataType);
          }

        for (int i = 0; i < result.length; i++)
          {
            result[i] *= scale;
          }

        return result;
      }
  }
