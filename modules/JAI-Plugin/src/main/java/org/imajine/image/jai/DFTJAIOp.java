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
package org.imajine.image.jai;

import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.PlanarImage;
import javax.media.jai.JAI;
import javax.media.jai.operator.DFTDescriptor;
import org.imajine.image.EditableImage;
import org.imajine.image.op.OperationImplementation;
import org.imajine.image.op.DFTOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class DFTJAIOp extends OperationImplementation<DFTOp, PlanarImage>
  {
//    private DFTScalingType scalingType;
//    
//    private DFTDataNature dataNature;
//    
//    private RenderingHints renderingHints;
            
    @Override
    protected PlanarImage execute (DFTOp operation, final EditableImage image, PlanarImage planarImage)
      {
//        planarImage = DFTDescriptor.create(planarImage, scalingType, dataNature, renderingHints);
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(planarImage);
        pb.add(DFTDescriptor.SCALING_UNITARY); // FIXME: get from parameters
        pb.add(DFTDescriptor.REAL_TO_COMPLEX); // FIXME: get from parameters
        planarImage = JAI.create("dft", pb);
        JAIUtils.logImage(log, ">>>> DFTJAIOp returning", planarImage);    
        
        return planarImage;
      }
  }
