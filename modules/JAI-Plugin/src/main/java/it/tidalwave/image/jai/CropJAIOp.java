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
package it.tidalwave.image.jai;

import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.CropOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class CropJAIOp extends OperationImplementation<CropOp, PlanarImage>
  {
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    @Override
    protected PlanarImage execute (CropOp operation, final EditableImage image, PlanarImage planarImage)
      {
        int x = operation.getX();
        int y = operation.getY();
        int w = operation.getW();
        int h = operation.getH();
        /*
        logger.fine("crop sampleMode: " + planarImage.getSampleModel());

        if ((x != 0) || (y != 0) || (w != planarImage.getWidth()) || (h != planarImage.getHeight()))
          {
            RenderingHints hints = null; // FIXME
            x += planarImage.getMinX();
            y += planarImage.getMinY();
            planarImage = CropDescriptor.create(planarImage, new Float(x), new Float(y), new Float(w), new Float(h), hints);
          }*/
        
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(planarImage);
        pb.add((float)x);
        pb.add((float)y);
        pb.add((float)w);
        pb.add((float)h);
        planarImage = JAI.create("crop", pb);

        JAIUtils.logImage(log, ">>>> crop() returning", planarImage);
        
        return planarImage;
      }
  }
