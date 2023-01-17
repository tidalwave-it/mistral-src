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
package it.tidalwave.image.java2d;

import java.util.Arrays;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.CreateOp;
import it.tidalwave.image.op.OperationImplementation;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Emmanuele Sordini
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class CreateJ2DOp extends OperationImplementation<CreateOp, BufferedImage>
  {
    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public boolean canHandle (final CreateOp operation)
      {
        switch (operation.getDataType())
          {
            case BYTE:
              switch (operation.getFiller().length)
                {
                  case 1:
                  case 3:
                    return true;

                  default:
                    return false;
                }

            case UNSIGNED_SHORT:
              switch (operation.getFiller().length)
                {
                  case 1:
                    return true;

                  default:
                    return false;
                }

            default:
              return false;
          }
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    protected BufferedImage execute (final CreateOp operation,
                                     final EditableImage image,
                                     final BufferedImage bufferedImage)
      {
        log.info("CreateJ2DOp.execute(" + operation + ", " + image + ")");
        Java2DUtils.logImage(log, ">>>> bufferedImage: ", bufferedImage);

        final double[] filler = operation.getFiller();
        final int[] dims = new int[filler.length];

        for (int i = 0; i < filler.length; i++)
          {
            dims[i] = (int)filler[i];
          }

        int type = 0;

        switch (operation.getDataType())
          {
            case BYTE:

              switch (dims.length)
                {
                  case 1:
                    type = BufferedImage.TYPE_BYTE_GRAY;

                    break;

                  case 3:
                    type = BufferedImage.TYPE_3BYTE_BGR;

                    break;

                  default:
                    throw new IllegalArgumentException("Band count not supported (" + dims.length + ") for type " +
                                                       operation.getDataType());
                }

              break;

            case UNSIGNED_SHORT:

              switch (dims.length)
                {
                  case 1:
                    type = BufferedImage.TYPE_USHORT_GRAY;

                    break;

                  default:
                    throw new IllegalArgumentException("Band count not supported (" + dims.length + ") for type " +
                                                       operation.getDataType());
                }

              break;

            default:
              throw new IllegalArgumentException("Unsupported dataType: " + operation.getDataType());
          }

        final BufferedImage result = new BufferedImage(operation.getWidth(), operation.getHeight(), type);

        if (!isZero(dims))
          {
            if (operation.getDataType() == EditableImage.DataType.UNSIGNED_SHORT)
              {
                final int[] buffer = new int[operation.getWidth() * operation.getHeight()];
                final int value = dims[0];
                Arrays.fill(buffer, value);
                result.getRaster().setPixels(0, 0, operation.getWidth(), operation.getHeight(), buffer);
              }

            else
              {
                final Graphics2D g = result.createGraphics();

                try
                  {
                    g.setColor((dims.length == 1)
                               ? new Color(dims[0], dims[0], dims[0])
                               : new Color(dims[0], dims[1], dims[2]));
                    g.fillRect(0, 0, operation.getWidth(), operation.getHeight());
                  }
                finally
                  {
                    if (g != null)
                      {
                        g.dispose();
                      }
                  }
              }
          }

        Java2DUtils.logImage(log, ">>>> CreateJ2DOp returning", result);

        return result;
      }

    private boolean isZero (final int[] samples)
      {
        for (int sample : samples)
          {
            if (sample != 0)
              {
                return false;
              }
          }

        return true;
      }
  }
