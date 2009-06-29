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
 * $Id: AssignColorProfileOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.op;

import it.tidalwave.image.op.*;
import java.awt.color.ICC_Profile;
import it.tidalwave.image.ImageUtils;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: AssignColorProfileOp.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class AssignColorProfileOp extends Operation
  {
    private ICC_Profile iccProfile;

    /*******************************************************************************
     *
     * Assigns a color profile. This means that the new color profile of this image
     * will be the given one, and no pixel data conversion will be performed.
     *
     * @param  iccProfile  the new ColorProfile
     *
     ******************************************************************************/
    public AssignColorProfileOp (ICC_Profile iccProfile)
      {
        this.iccProfile = iccProfile;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public ICC_Profile getICCProfile ()
      {
        return iccProfile;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public String toString ()
      {
        return "AssignColorProfileOp(" + ImageUtils.getICCProfileName(iccProfile) + ")";
      }
  }
