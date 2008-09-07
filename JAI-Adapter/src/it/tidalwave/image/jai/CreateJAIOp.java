/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici
 *                        and Emmanuele Sordini
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
 * $Id: CreateJAIOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.ConstantDescriptor;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.CreateOp;


/*******************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id: CreateJAIOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class CreateJAIOp extends OperationImplementation<CreateOp, PlanarImage>
  {
    private static final String CLASS = CreateJAIOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected PlanarImage execute (final CreateOp operation, final EditableImage image, final PlanarImage planarImage)
      {
        final double[] filler = operation.getFiller();
        Number[] dims = null;

        switch (operation.getDataType())
          {
            case BYTE:
                dims = new Byte[filler.length];

                for (int i = 0; i < filler.length; i++)
                  {
                    dims[i] = (byte)filler[i];
                  }

                break;

            case SHORT:
                dims = new Short[filler.length];

                for (int i = 0; i < filler.length; i++)
                  {
                    dims[i] = (short)filler[i];
                  }

                break;

            case UNSIGNED_SHORT:
                dims = new Short[filler.length];

                for (int i = 0; i < filler.length; i++)
                  {
                    dims[i] = (short)filler[i];
                  }

                break;

            case INT:
                dims = new Integer[filler.length];

                for (int i = 0; i < filler.length; i++)
                  {
                    dims[i] = (int)filler[i];
                  }

                break;

            case FLOAT:
                dims = new Float[filler.length];

                for (int i = 0; i < filler.length; i++)
                  {
                    dims[i] = (float)filler[i];
                  }

                break;

            case DOUBLE:
                dims = new Double[filler.length];

                for (int i = 0; i < filler.length; i++)
                  {
                    dims[i] = (double)filler[i];
                  }

                break;

            default:
                throw new IllegalArgumentException("Unsupported dataType: " + operation.getDataType());
          }

        final PlanarImage result = ConstantDescriptor.create((float)operation.getWidth(), (float)operation.getHeight(), dims, null).createInstance();
        JAIUtils.logImage(logger, ">>>> CreateJAIOp returning", result);

        return result;
      }
  }
