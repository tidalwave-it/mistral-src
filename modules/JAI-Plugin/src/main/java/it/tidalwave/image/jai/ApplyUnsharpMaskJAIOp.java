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

import javax.media.jai.PlanarImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.ApplyUnsharpMaskOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class ApplyUnsharpMaskJAIOp extends OperationImplementation<ApplyUnsharpMaskOp, PlanarImage>
  {
    @Override
    protected PlanarImage execute (ApplyUnsharpMaskOp operation, final EditableImage image,  PlanarImage planarImage)
      {
        double intensity = operation.getIntensity();
        double radius = operation.getRadius();
        double threshold = operation.getThreshold();
//        planarImage = UnsharpMaskDescriptor.create(planarImage, kernel, gain, renderingHints);
        log.warn(">>>> unsharpMask not implemented yet!");

        return planarImage;
      }
  }
