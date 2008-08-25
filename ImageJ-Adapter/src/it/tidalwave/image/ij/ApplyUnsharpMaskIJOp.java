/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2007 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
 *                        and Emmanuele Sordini (Emmanuele@Sordini.com)
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
 * $Id: ApplyUnsharpMaskIJOp.java 592 2007-04-07 19:10:17Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.ij;

import java.util.logging.Logger;
import ij.ImagePlus;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.ApplyUnsharpMaskOp;
import it.tidalwave.image.op.OperationImplementation;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ApplyUnsharpMaskIJOp.java 592 2007-04-07 19:10:17Z fabriziogiudici $
 *
 ******************************************************************************/
public class ApplyUnsharpMaskIJOp extends OperationImplementation<ApplyUnsharpMaskOp, ImagePlus>
  {
    private static final String CLASS = ApplyUnsharpMaskIJOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
            
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected ImagePlus execute (ApplyUnsharpMaskOp operation, final EditableImage image, ImagePlus imagePlus)
      {
        double intensity = operation.getIntensity();
        double radius = operation.getRadius();
        double threshold = operation.getThreshold();
        throw new RuntimeException("Not implemented");
//        ImagePlus = UnsharpMaskDescriptor.create(ImagePlus, kernel, gain, renderingHints);
//        return ImagePlus;
      }
  }
