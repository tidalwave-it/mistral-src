/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2006 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
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
 * $Id: Main.java 432 2007-02-01 18:39:08Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.mistral.customoperation;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.WriteOp;
import it.tidalwave.image.op.ReadOp;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: Main.java 432 2007-02-01 18:39:08Z fabriziogiudici $
 *
 ******************************************************************************/
public class Main 
  {
    public static void main (String[] args)
      throws IOException
      {
        //
        // Register the custom operation and its implementation.
        //
        ImplementationFactoryJ2D.getInstance().registerImplementation(ChangeBufferTypeOp.class, ChangeBufferTypeJ2DOp.class);
        
        File file = new File("20030701-0043.jpg");
        EditableImage image = EditableImage.create(new ReadOp(file));
        image.execute(new ChangeBufferTypeOp(BufferedImage.TYPE_3BYTE_BGR));
        image.execute(new WriteOp("JPEG", new File("/tmp/Result.tif")));
      }
  }
