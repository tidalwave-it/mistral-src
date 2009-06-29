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
 * $Id: DFTJAIOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import java.awt.RenderingHints;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.PlanarImage;
import javax.media.jai.JAI;
import javax.media.jai.operator.DFTDataNature;
import javax.media.jai.operator.DFTDescriptor;
import javax.media.jai.operator.DFTScalingType;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.DFTOp;

/*******************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id: DFTJAIOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class DFTJAIOp extends OperationImplementation<DFTOp, PlanarImage>
  {
    private static final String CLASS = DFTJAIOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
    
    private DFTScalingType scalingType;
    
    private DFTDataNature dataNature;
    
    private RenderingHints renderingHints;
            
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected PlanarImage execute (DFTOp operation, final EditableImage image, PlanarImage planarImage)
      {
//        planarImage = DFTDescriptor.create(planarImage, scalingType, dataNature, renderingHints);
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(planarImage);
        pb.add(DFTDescriptor.SCALING_UNITARY); // FIXME: get from parameters
        pb.add(DFTDescriptor.REAL_TO_COMPLEX); // FIXME: get from parameters
        planarImage = JAI.create("dft", pb);
        JAIUtils.logImage(logger, ">>>> DFTJAIOp returning", planarImage);    
        
        return planarImage;
      }
  }