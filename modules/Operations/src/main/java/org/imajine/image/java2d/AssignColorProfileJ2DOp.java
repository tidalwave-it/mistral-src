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
package org.imajine.image.java2d;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import org.imajine.image.EditableImage;
import org.imajine.image.ImageUtils;
import org.imajine.image.op.AssignColorProfileOp;
import org.imajine.image.op.OperationImplementation;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Immutable @Slf4j
public class AssignColorProfileJ2DOp extends OperationImplementation<AssignColorProfileOp, BufferedImage>
  {
    @Nonnull
    @Override
    protected BufferedImage execute (final @Nonnull AssignColorProfileOp operation,
                                     final @Nonnull EditableImage image,
                                     final @Nonnull BufferedImage bufferedImage)
      {
        final ICC_Profile targetProfile = operation.getIccProfile();
        log.trace("assignColorProfile({})", ImageUtils.getICCProfileName(targetProfile));
        Java2DUtils.logImage(log, ">>>> source bufferedImage", bufferedImage);

        final ColorSpace colorSpace = new ICC_ColorSpace(targetProfile);
        final ColorModel colorModel = new ComponentColorModel(colorSpace, false, false, ColorModel.OPAQUE,
                                                              bufferedImage.getRaster().getDataBuffer().getDataType());
        final BufferedImage result = new BufferedImage(colorModel, bufferedImage.getRaster(), false, Java2DUtils.getProperties(bufferedImage));
        Java2DUtils.logImage(log, ">>>> assignColorProfile() returning ", bufferedImage);

        return result;
      }
  }
