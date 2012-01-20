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

import javax.annotation.Nonnull;
import java.awt.color.ICC_Profile;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.ColorConvertDescriptor;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.ConvertColorProfileOp;
import it.tidalwave.image.op.OperationImplementation;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class ConvertColorProfileJAIOp extends OperationImplementation<ConvertColorProfileOp, PlanarImage>
  {
    @Nonnull
    protected PlanarImage execute (final @Nonnull ConvertColorProfileOp operation, 
                                   final @Nonnull EditableImage image,
                                   final @Nonnull PlanarImage planarImage)
      {
        log.info("execute({}) - {} ", operation, planarImage.getSampleModel());
        
        final ICC_Profile iccProfile = operation.getIccProfile();      
        final PlanarImage result = ColorConvertDescriptor.create(planarImage, JAIUtils.getColorModel(planarImage, iccProfile), null); // FIXME: RenderingHints
        JAIUtils.logImage(log, ">>>> returning", planarImage);
        
        return result;
      }
  }
