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
 * $Id: RotateQuadrantIJOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.ij;

import java.util.logging.Logger;
import ij.ImagePlus;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.RotateQuadrantOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: RotateQuadrantIJOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class RotateQuadrantIJOp extends OperationImplementation<RotateQuadrantOp, ImagePlus>
  {
    private static final String CLASS = RotateQuadrantIJOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
            
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected ImagePlus execute (RotateQuadrantOp operation, final EditableImage image, ImagePlus imagePlus)
      {
        int degrees = operation.getDegrees();
        logger.fine("rotateQuadrant(" + degrees + ")");

            throw new RuntimeException("Not implemented");
//            IJUtils.logImage(logger, ">>>>   rotateQuadrant() returning", ImagePlus);

//        return ImagePlus;
      }
  }