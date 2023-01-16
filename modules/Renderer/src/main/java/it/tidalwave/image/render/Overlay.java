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

import java.awt.Graphics2D;

/***********************************************************************************************************************
 *
 * An Overlay is something that is drawn over a rendered image.
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public interface Overlay
  {
    /*******************************************************************************************************************
     *
     * As the Graphics2D object passed is a copy of the original, this method
     * can change attributes (e.g. color, clip) without worrying about restoring
     * them to their original values.
     *
     ******************************************************************************************************************/
    public void paint (Graphics2D g, EditableImageRenderer imageRenderer);

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public boolean isVisible();
  }
