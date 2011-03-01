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
package it.tidalwave.image.ij;

import java.util.logging.Logger;
import java.awt.RenderingHints;
import ij.ImagePlus;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.ConvolveOp;
import it.tidalwave.image.op.OperationImplementation;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ConvolveIJOp extends OperationImplementation<ConvolveOp, ImagePlus>
  {
    private static final String CLASS = ConvolveIJOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
            
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected ImagePlus execute (ConvolveOp operation, final EditableImage image, ImagePlus imagePlus)
      {
        RenderingHints hints = null; // FIXME
        throw new RuntimeException("Not implemented");
//        Kernel kernel = operation.getKernel();
//        return ConvolveDescriptor.create(ImagePlus, new KernelJAI(kernel), hints);
      }
  }
