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
 * $Id: WriteJAIOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import java.io.File;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.PlanarImage;
import javax.media.jai.JAI;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.WriteOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: WriteJAIOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class WriteJAIOp extends OperationImplementation<WriteOp, PlanarImage>
  {
    private static final String CLASS = WriteJAIOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
            
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected PlanarImage execute (WriteOp operation, final EditableImage image, PlanarImage planarImage)
      {
        Object output = operation.getOutput();
        
        if (!(output instanceof File))
          {
            throw new UnsupportedOperationException("only File outputs are supported");  
          }
        
        // FIXME: should be using Image I/O instead of JAI
        
        File file = (File)output;
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(planarImage);
        pb.add(file.getAbsolutePath());
        // FIXME: file format?
        JAI.create("filestore", pb);
        JAIUtils.logImage(logger, ">>>> WriteJAIOp returning", planarImage);
        
        return planarImage;
      }
  }
