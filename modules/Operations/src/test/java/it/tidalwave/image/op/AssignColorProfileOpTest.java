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
 * $Id$
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class AssignColorProfileOpTest 
  {
    @Test
    public void testGetICCProfile()   
      {
        System.out.println("getICCProfile");
        
        ICC_Profile iccProfile = ICC_Profile.getInstance(ColorSpace.CS_sRGB);
        AssignColorProfileOp op = new AssignColorProfileOp(iccProfile);
        assertEquals(iccProfile, op.getICCProfile());
      }

    @Test
    public void testToString() 
      {
        System.out.println("toString");
        ICC_Profile iccProfile = ICC_Profile.getInstance(ColorSpace.CS_sRGB);
        AssignColorProfileOp op = new AssignColorProfileOp(iccProfile);
        op.toString();
      }  
  }