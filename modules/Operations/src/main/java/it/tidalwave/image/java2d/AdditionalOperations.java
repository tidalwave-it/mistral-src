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

import it.tidalwave.image.op.ApplyUnsharpMaskOp;
import it.tidalwave.image.op.AssignColorProfileOp;
import it.tidalwave.image.op.ConvertColorProfileOp;
import it.tidalwave.image.op.HistogramOp;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
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
