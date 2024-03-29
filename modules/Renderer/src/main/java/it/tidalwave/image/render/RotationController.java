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
package it.tidalwave.image.render;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class RotationController
  {
    /**
     * The attached renderer.
     */
    protected final EditableImageRenderer imageRenderer;

    /*******************************************************************************************************************
     *
     * Creates a new instance of this class, attached to the given renderer.
     *
     * @param  imageRenderer    the image renderer
     *
     ******************************************************************************************************************/
    public RotationController (final EditableImageRenderer imageRenderer)
      {
        if (imageRenderer == null)
          {
            throw new IllegalArgumentException("imageRenderer is mandatory");
          }

        this.imageRenderer = imageRenderer;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public final void setAngle (final double angle)
      {
        imageRenderer.setAngle(angle);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public double getAngle()
      {
        return imageRenderer.getAngle();
      }
  }
