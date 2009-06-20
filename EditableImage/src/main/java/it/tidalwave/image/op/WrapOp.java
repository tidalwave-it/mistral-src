/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici
 *                        and Emmanuele Sordini
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *******************************************************************************
 *
 * $Id: CreateOp.java 769 2007-09-13 23:33:54Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.op;

import java.awt.Color;
import it.tidalwave.image.EditableImage;
import java.awt.image.BufferedImage;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: CreateOp.java 769 2007-09-13 23:33:54Z fabriziogiudici $
 *
 ******************************************************************************/
public class WrapOp extends AbstractCreateOp
  {
    private final BufferedImage sourceImage;

    /***************************************************************************
     *
     *
     **************************************************************************/
    public WrapOp (final BufferedImage sourceImage)
      {
        if (sourceImage == null)
          {
            throw new IllegalArgumentException("sourceImage is mandatory");  
          }
        
        this.sourceImage = sourceImage;
      }

    /***************************************************************************
     *
     * {@inheritDoc}
     *
     **************************************************************************/
    public BufferedImage getSourceImage() 
      {
        return sourceImage;
      }

    /***************************************************************************
     *
     * {@inheritDoc}
     *
     **************************************************************************/
    @Override
    public String toString()
      {
        return String.format("WrapOp(%s)", sourceImage);
      }
  }
