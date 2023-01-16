/*
 * *********************************************************************************************************************
 *
 * Mistral: open source imaging engine
 * http://tidalwave.it/projects/mistral
 *
 * Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
 *
 * *********************************************************************************************************************
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
 * *********************************************************************************************************************
 *
 * git clone https://bitbucket.org/tidalwave/mistral-src
 * git clone https://github.com/tidalwave-it/mistral-src
 *
 * *********************************************************************************************************************
 */
package it.tidalwave.mistral.customoperation;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import org.openide.util.Lookup;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;
import it.tidalwave.image.op.ReadOp;
import it.tidalwave.image.op.WriteOp;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class Main
  {
    public static void main (final String[] args)
            throws IOException
      {
        //
        // Register the custom operation and its implementation.
        //
        Lookup.getDefault()
              .lookup(ImplementationFactoryJ2D.class)
              .registerImplementation(ChangeBufferTypeOp.class, ChangeBufferTypeJ2DOp.class);

        final File file = new File("20030701-0043.jpg");
        final EditableImage image = EditableImage.create(new ReadOp(file));
        image.execute(new ChangeBufferTypeOp(BufferedImage.TYPE_3BYTE_BGR));
        image.execute(new WriteOp("JPEG", new File("/tmp/Result.tif")));
      }
  }
