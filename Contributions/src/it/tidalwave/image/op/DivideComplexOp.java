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
 * $Id: DivideComplexOp.java 625 2007-04-09 10:02:01Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.op;

import it.tidalwave.image.op.*;
import it.tidalwave.image.EditableImage;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: DivideComplexOp.java 625 2007-04-09 10:02:01Z fabriziogiudici $
 *
 ******************************************************************************/
public class DivideComplexOp extends Operation
  {
    private EditableImage operand;

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public DivideComplexOp (EditableImage operand)
      {
        if (operand == null)
          {
            throw new IllegalArgumentException("null operand");
          }

        this.operand = operand;
      }

    /*******************************************************************************
     *
     *
     *******************************************************************************/
    public EditableImage getOperand ()
      {
        return operand;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     *******************************************************************************/
    public String toString ()
      {
        return "DivideComplexOp(" + operand + ")";
      }
  }
