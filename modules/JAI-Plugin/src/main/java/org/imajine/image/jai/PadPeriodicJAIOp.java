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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.image.jai;

import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.BorderExtender;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedOp;
import org.imajine.image.EditableImage;
import org.imajine.image.op.OperationImplementation;
import org.imajine.image.op.PadPeriodicOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class PadPeriodicJAIOp extends OperationImplementation<PadPeriodicOp, PlanarImage>
  {
    @Override
    protected PlanarImage execute (PadPeriodicOp operation, final EditableImage image, PlanarImage planarImage)
      {
        int oldWidth = planarImage.getData().getWidth();
        int oldHeight = planarImage.getData().getHeight();

        int newWidth = JAIUtils.closestPower2Size(oldWidth);
        int newHeight = JAIUtils.closestPower2Size(oldHeight);
        int padx = (newWidth - oldWidth) / 2;
        int pady = (newHeight - oldHeight) / 2;
        log.debug(">>>> pad: {}, {}", padx, pady);

        ParameterBlock pb = new ParameterBlock();
        pb.addSource(planarImage);
        pb.add((float)padx);
        pb.add((float)pady);
        RenderedOp trans = JAI.create("translate", pb);

        pb = new ParameterBlock();
        pb.addSource(trans);
        pb.add(padx);
        pb.add(padx);
        pb.add(pady);
        pb.add(pady);
        pb.add(BorderExtender.createInstance(BorderExtender.BORDER_WRAP));
        planarImage = JAI.create("border", pb);
        
        JAIUtils.logImage(log, ">>>> PadPeriodicJAIOp returning", planarImage);
        
        return planarImage;
      }
  }
