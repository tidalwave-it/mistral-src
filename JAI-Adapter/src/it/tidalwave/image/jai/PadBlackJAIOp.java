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
 * $Id: PadBlackJAIOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.PlanarImage;
import javax.media.jai.BorderExtender;
import javax.media.jai.JAI;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.PadBlackOp;

/*******************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id: PadBlackJAIOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class PadBlackJAIOp extends OperationImplementation<PadBlackOp, PlanarImage>
  {
    private static final String CLASS = PadBlackJAIOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
            
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected PlanarImage execute (PadBlackOp operation, final EditableImage image, PlanarImage planarImage)
      {
        ParameterBlock pb = new ParameterBlock();

        int width = planarImage.getData().getWidth();
        int height = planarImage.getData().getHeight();

        int padx = width;
        int pady = height;

        pb.addSource(planarImage);
        pb.add(padx);
        pb.add(padx);
        pb.add(pady);
        pb.add(pady);
        pb.add(BorderExtender.createInstance(BorderExtender.BORDER_ZERO));    
        planarImage = JAI.create("border", pb);    
        JAIUtils.logImage(logger, ">>>> PadBlackOp returning", planarImage);
        
        return planarImage;
      }
  }
