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

import org.imajine.image.java2d.ConvertColorProfileJ2DOp;
import org.imajine.image.op.ApplyUnsharpMaskOp;
import org.imajine.image.op.AssignColorProfileOp;
import org.imajine.image.op.ConvertColorProfileOp;
import org.imajine.image.op.HistogramOp;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public final class AdditionalOperations
  {
    public static void register (final ImplementationFactoryJ2D factory)
      {
        factory.registerImplementation(ApplyUnsharpMaskOp.class, ApplyUnsharpMaskJ2DOp.class);
        factory.registerImplementation(AssignColorProfileOp.class, AssignColorProfileJ2DOp.class);
        factory.registerImplementation(ConvertColorProfileOp.class, ConvertColorProfileJ2DOp.class);
        factory.registerImplementation(HistogramOp.class, HistogramJ2DOp.class);
      }
  }
