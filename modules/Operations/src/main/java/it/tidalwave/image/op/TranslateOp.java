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

import it.tidalwave.image.op.Operation;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class TranslateOp extends Operation
  {
    private float deltaX;
    private float deltaY;
    private InterpolationType interpolationType;
    public static enum InterpolationType // TODO: merge with global InterpolationType
      {
        NEAREST,
        BICUBIC;
      }
    ;

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public TranslateOp (float deltaX, float deltaY, InterpolationType interpolationType)
      {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.interpolationType = interpolationType;
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public float getDeltaX ()
      {
        return deltaX;
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public float getDeltaY ()
      {
        return deltaY;
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public InterpolationType getInterpolationType ()
      {
        return interpolationType;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     *******************************************************************************/
    @Override
    public String toString ()
      {
        return "TranslateOp(" + deltaX + ", " + deltaY + ", " + interpolationType + ")";
      }
  }
