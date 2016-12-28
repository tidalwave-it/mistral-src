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

import java.awt.RenderingHints;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.ImageLayout;
import javax.media.jai.PlanarImage;
import javax.media.jai.JAI;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.ChangeFormatOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class ChangeFormatJAIOp extends OperationImplementation<ChangeFormatOp, PlanarImage>
  {
    @Override
    protected PlanarImage execute (final ChangeFormatOp operation, final EditableImage image, PlanarImage planarImage)
      {
        final ParameterBlock pb = new ParameterBlock();
        pb.addSource(planarImage);
        pb.add(operation.getType().value());

        RenderingHints hints = null;
        final EditableImage.DataType dataType = operation.getType();
        
        if (dataType == EditableImage.DataType.SHORT)
          {
            final ImageLayout imageLayout = new ImageLayout();
            imageLayout.setColorModel(planarImage.getColorModel());
            hints = new RenderingHints(JAI.KEY_IMAGE_LAYOUT, imageLayout);   
            log.info(">>>> using hints: {}", hints);
          }
        
        planarImage = JAI.create("format", pb, hints);
        JAIUtils.logImage(log, ">>>> ChangeFormatJAIOp returning {}", planarImage);
        
        return planarImage;
      }
  }
