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
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Immutable @RequiredArgsConstructor @EqualsAndHashCode(callSuper=false)
public class ConvertColorProfileOp extends Operation
  {
    @Getter @Nonnull
    private final ICC_Profile iccProfile;
    
    @Override @Nonnull
    public String toString()
      {
        return String.format("ConvertColorProfileOp(%s)", ImageUtils.getICCProfileName(iccProfile));
      }
  }
