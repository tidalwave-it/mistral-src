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
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import java.awt.RenderingHints;
import java.awt.image.Kernel;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.ConvolveDescriptor;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.ConvolveOp;

/***********************************************************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
public class ConvolveJAIOp extends OperationImplementation<ConvolveOp, PlanarImage>
  {
    private static final String CLASS = ConvolveJAIOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);
            
    protected PlanarImage execute (ConvolveOp operation, final EditableImage image, PlanarImage planarImage)
      {
        RenderingHints hints = null; // FIXME
        Kernel kernel = operation.getKernel();
        return ConvolveDescriptor.create(planarImage, new KernelJAI(kernel), hints);
      }
  }
