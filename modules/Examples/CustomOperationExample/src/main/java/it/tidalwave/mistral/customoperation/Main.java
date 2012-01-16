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
package it.tidalwave.mistral.customoperation;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.WriteOp;
import it.tidalwave.image.op.ReadOp;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;
import org.openide.util.Lookup;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
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
        Lookup.getDefault().lookup(ImplementationFactoryJ2D.class).registerImplementation(ChangeBufferTypeOp.class, ChangeBufferTypeJ2DOp.class);
        
        File file = new File("20030701-0043.jpg");
        EditableImage image = EditableImage.create(new ReadOp(file));
        image.execute(new ChangeBufferTypeOp(BufferedImage.TYPE_3BYTE_BGR));
        image.execute(new WriteOp("JPEG", new File("/tmp/Result.tif")));
      }
  }
