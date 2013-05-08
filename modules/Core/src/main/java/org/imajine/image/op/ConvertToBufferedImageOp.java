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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.image.op;

import java.awt.image.BufferedImage;


/*******************************************************************************
 *
 * This operation converts the image to a <code>BufferedImage</code>. The result
 * can be retrieved by calling <code>getBufferedImage</code>.
 * 
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ConvertToBufferedImageOp extends Operation
  {
    private BufferedImage bufferedImage;

    /*******************************************************************************
     *
     * DO NOT USE.
     *
     *******************************************************************************/
    public void setBufferedImage (final BufferedImage bufferedImage)
      {
        this.bufferedImage = bufferedImage;
      }

    /*******************************************************************************
     *
     * Returns the <code>BufferedImage</code>
     *
     *******************************************************************************/
    public BufferedImage getBufferedImage ()
      {
        return bufferedImage;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     *******************************************************************************/
    @Override
    public String toString ()
      {
        return "ConvertToBufferedImageOp()";
      }
  }
