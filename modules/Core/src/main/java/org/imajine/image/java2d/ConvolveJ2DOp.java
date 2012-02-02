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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.image.java2d;

import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import java.awt.image.Kernel;
import org.imajine.image.EditableImage;
import org.imajine.image.op.ConvolveOp;
import org.imajine.image.op.OperationImplementation;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ConvolveJ2DOp extends OperationImplementation<ConvolveOp, BufferedImage>
  {
    private static final String CLASS = ConvolveJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    @Override
    protected BufferedImage execute (ConvolveOp operation, final EditableImage image, BufferedImage bufferedImage)
      {
        Kernel kernel = operation.getKernel();
        java.awt.image.ConvolveOp convolveOp = new java.awt.image.ConvolveOp(kernel);

        return convolveOp.filter(bufferedImage, null);
      }
  }
