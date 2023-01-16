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
package it.tidalwave.image.op;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.awt.color.ICC_Profile;
import it.tidalwave.image.ImageUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/***********************************************************************************************************************
 *
 * Converts to a color profile. This means that the new color profile of this image will be the given one, and pixel 
 * data will be converted.
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Immutable @RequiredArgsConstructor @EqualsAndHashCode(callSuper = false)
public class ConvertColorProfileOp extends Operation
  {
    public static enum RenderingIntent
      {
        ABSOLUTE,
        RELATIVE_COLORIMETRIC,
        PERCEPTUAL,
        SATURATION
      }

    @Getter @Nonnull
    private final ICC_Profile iccProfile;

    @Getter @Nonnull
    private final RenderingIntent renderingIntent;

    public ConvertColorProfileOp (@Nonnull final ICC_Profile iccProfile)
      {
        this(iccProfile, RenderingIntent.PERCEPTUAL);
      }

    @Override
    @Nonnull
    public String toString()
      {
        return String.format("ConvertColorProfileOp(%s, %s)",
                             ImageUtils.getICCProfileName(iccProfile),
                             renderingIntent);
      }
  }
