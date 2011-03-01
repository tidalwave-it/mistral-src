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
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import java.awt.RenderingHints;
import javax.media.jai.PlanarImage;
import javax.media.jai.Interpolation;
import javax.media.jai.operator.ScaleDescriptor;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.ScaleOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ScaleJAIOp extends OperationImplementation<ScaleOp, PlanarImage>
  {
    private static final String CLASS = ScaleJAIOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
            
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected PlanarImage execute (ScaleOp operation, final EditableImage image, PlanarImage planarImage)
      {
        RenderingHints hints = null; // FIXME
        Interpolation interpolation = Interpolation.getInstance(Interpolation.INTERP_BILINEAR);
        logger.warning(">>>> ScaleJAIOp is not optimized");
        logger.finer(">>>> interpolation: " + interpolation);

        double xScale = operation.getXScale();
        double yScale = operation.getYScale();
        planarImage = ScaleDescriptor.create(planarImage, 
                                             new Float(xScale), new Float(yScale),
                                             new Float(0), new Float(0), 
                                             interpolation, hints);
        JAIUtils.logImage(logger, ">>>> ScaleJAIOp returning", planarImage);
        
        return planarImage;
      }
  }
