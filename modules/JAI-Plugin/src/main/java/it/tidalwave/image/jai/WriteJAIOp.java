/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2023 by Tidalwave s.a.s.
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
package it.tidalwave.image.jai;

import java.io.File;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.PlanarImage;
import javax.media.jai.JAI;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.WriteOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Luca Forni
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class WriteJAIOp extends OperationImplementation<WriteOp, PlanarImage>
  {
    @Override
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
        JAIUtils.logImage(log, ">>>> WriteJAIOp returning", planarImage);
        
        return planarImage;
      }
  }
