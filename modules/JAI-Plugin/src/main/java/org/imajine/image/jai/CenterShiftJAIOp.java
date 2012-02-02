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

import javax.annotation.Nonnull;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.PlanarImage;
import javax.media.jai.JAI;
import org.imajine.image.EditableImage;
import org.imajine.image.op.OperationImplementation;
import org.imajine.image.op.CenterShiftOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class CenterShiftJAIOp extends OperationImplementation<CenterShiftOp, PlanarImage>
  {
    @Override @Nonnull
    protected PlanarImage execute (final @Nonnull CenterShiftOp operation, 
                                   final @Nonnull EditableImage image, 
                                   final @Nonnull PlanarImage planarImage)
      {
        final ParameterBlock pb = new ParameterBlock();
        pb.addSource(planarImage);
        pb.addSource(planarImage.getWidth() / 2);
        pb.addSource(planarImage.getHeight() / 2);
        final PlanarImage result = JAI.create("periodicshift", pb);
        JAIUtils.logImage(log, ">>>> CenterShiftJAIOp returning", result);
        
        return result;
      }
  }
