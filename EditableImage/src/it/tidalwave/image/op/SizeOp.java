/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2006 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
 *                        and Emmanuele Sordini (Emmanuele@Sordini.com)
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
 * $Id: SizeOp.java 493 2007-03-15 16:16:28Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.op;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: SizeOp.java 493 2007-03-15 16:16:28Z fabriziogiudici $
 *
 ******************************************************************************/
public class SizeOp extends Operation
  {
    private final double scale;

    /*******************************************************************************
     *
     * Changes the size of the image by a given scale.
     *
     * @param   scale     the scale
     *
     ******************************************************************************/
    public SizeOp (double scale)
      {
        this.scale = scale;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public double getScale ()
      {
        return scale;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public String toString ()
      {
        return "SizeOp(scale:" + scale + ")";
      }
  }
