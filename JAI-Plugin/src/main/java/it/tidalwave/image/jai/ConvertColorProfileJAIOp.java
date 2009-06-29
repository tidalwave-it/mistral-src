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
 * $Id: ConvertColorProfileJAIOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import java.awt.color.ICC_Profile;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.ColorConvertDescriptor;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.ImageUtils;
import it.tidalwave.image.op.ConvertColorProfileOp;
import it.tidalwave.image.op.OperationImplementation;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ConvertColorProfileJAIOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class ConvertColorProfileJAIOp extends OperationImplementation<ConvertColorProfileOp, PlanarImage>
  {
    private static final String CLASS = ConvertColorProfileJAIOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
            
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected PlanarImage execute (ConvertColorProfileOp operation, final EditableImage image, PlanarImage planarImage)
      {
        ICC_Profile iccProfile = operation.getICCProfile();      
        logger.fine("convertColorProfile(" + ImageUtils.getICCProfileName(iccProfile) + ") - " + planarImage.getSampleModel());
        planarImage = ColorConvertDescriptor.create(planarImage, JAIUtils.getColorModel(planarImage, iccProfile), null); // FIXME: RenderingHints
        JAIUtils.logImage(logger, ">>>>   convertColorProfile() returning", planarImage);
        
        return planarImage;
      }
  }