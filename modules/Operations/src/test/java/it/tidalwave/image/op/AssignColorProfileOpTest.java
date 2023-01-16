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
package it.tidalwave.image.op;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class AssignColorProfileOpTest
  {
    @Test
    public void testGetICCProfile()
      {
        System.out.println("getICCProfile");

        final ICC_Profile iccProfile = ICC_Profile.getInstance(ColorSpace.CS_sRGB);
        final AssignColorProfileOp op = new AssignColorProfileOp(iccProfile);
        AssertJUnit.assertEquals(iccProfile, op.getIccProfile());
      }

    @Test
    public void testToString()
      {
        System.out.println("toString");
        final ICC_Profile iccProfile = ICC_Profile.getInstance(ColorSpace.CS_sRGB);
        final AssignColorProfileOp op = new AssignColorProfileOp(iccProfile);
        op.toString();
      }
  }
