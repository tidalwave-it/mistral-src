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
package it.tidalwave.image.java2d;

import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.CreateOp;

/*******************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class CreateJ2DOp extends OperationImplementation<CreateOp, BufferedImage>
  {
    private static final String CLASS = CreateJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
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
    
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected BufferedImage execute (final CreateOp operation, final EditableImage image, final BufferedImage bufferedImage)
      {
        logger.info("CreateJ2DOp.execute(" + operation + ", " + image + ")");
        Java2DUtils.logImage(logger, ">>>> bufferedImage: ", bufferedImage);

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

                for (int i = 0; i < buffer.length; i++)
                  {
                    buffer[i] = value;
                  }

                result.getRaster().setPixels(0, 0, operation.getWidth(), operation.getHeight(), buffer);
              }

            else
              {
                final Graphics2D g = result.createGraphics();

                try
                  {
                    g.setColor((dims.length == 1) ? new Color(dims[0], dims[0], dims[0]) : new Color(dims[0], dims[1], dims[2]));
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

        Java2DUtils.logImage(logger, ">>>> CreateJ2DOp returning", result);

        return result;
      }

    private boolean isZero (final int[] samples)
      {
        for (int i = 0; i < samples.length; i++)
          {
            if (samples[i] != 0)
              {
                return false;
              }
          }

        return true;
      }
  }
