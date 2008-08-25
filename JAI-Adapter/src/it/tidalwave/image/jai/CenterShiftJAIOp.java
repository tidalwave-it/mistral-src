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
 * $Id: CenterShiftJAIOp.java 592 2007-04-07 19:10:17Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.PlanarImage;
import javax.media.jai.JAI;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.CenterShiftOp;

/*******************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id: CenterShiftJAIOp.java 592 2007-04-07 19:10:17Z fabriziogiudici $
 *
 ******************************************************************************/
public class CenterShiftJAIOp extends OperationImplementation<CenterShiftOp, PlanarImage>
  {
    private static final String CLASS = CenterShiftJAIOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
            
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected PlanarImage execute (CenterShiftOp operation, final EditableImage image, PlanarImage planarImage)
      {
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(planarImage);
        pb.addSource(planarImage.getWidth() / 2);
        pb.addSource(planarImage.getHeight() / 2);
        planarImage = JAI.create("periodicshift", pb);
        JAIUtils.logImage(logger, ">>>> CenterShiftJAIOp returning", planarImage);
        
        return planarImage;
      }
  }
