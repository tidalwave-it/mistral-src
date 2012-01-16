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

import java.awt.image.Kernel;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ConvolvedOpTest 
  {
    @Test
    public void testGetKernel() 
      {
        System.out.println("getKernel");
        
        Kernel kernel = new Kernel(3, 3, new float[]{1,2,3,4,5,6,7,8,9});
        ConvolveOp op = new ConvolveOp(kernel);
        assertEquals(kernel, op.getKernel());
      }

    @Test
    public void testToString() 
      {
        System.out.println("toString");
        
        Kernel kernel = new Kernel(3, 3, new float[]{1,2,3,4,5,6,7,8,9});
        ConvolveOp op = new ConvolveOp(kernel);
        op.toString();
      }    
  }
