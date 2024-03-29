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
package it.tidalwave.image.java2d;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.ImageUtils;
import it.tidalwave.image.op.AssignColorProfileOp;
import it.tidalwave.image.op.OperationImplementation;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Immutable @Slf4j
public class AssignColorProfileJ2DOp extends OperationImplementation<AssignColorProfileOp, BufferedImage>
  {
    @Override @Nonnull
    protected BufferedImage execute (@Nonnull final AssignColorProfileOp operation,
                                     @Nonnull final EditableImage image,
                                     @Nonnull final BufferedImage bufferedImage)
      {
        final var targetProfile = operation.getIccProfile();
        log.trace("assignColorProfile({})", ImageUtils.getICCProfileName(targetProfile));
        Java2DUtils.logImage(log, ">>>> source bufferedImage", bufferedImage);

        final ColorSpace colorSpace = new ICC_ColorSpace(targetProfile);
        final ColorModel colorModel = new ComponentColorModel(colorSpace, false, false, ColorModel.OPAQUE,
                                                              bufferedImage.getRaster().getDataBuffer().getDataType());
        final var result = new BufferedImage(colorModel,
                                             bufferedImage.getRaster(),
                                             false,
                                             Java2DUtils.getProperties(bufferedImage));
        Java2DUtils.logImage(log, ">>>> assignColorProfile() returning ", bufferedImage);

        return result;
      }
  }
