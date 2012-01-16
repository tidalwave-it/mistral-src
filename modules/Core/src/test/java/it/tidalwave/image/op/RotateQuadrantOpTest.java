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

import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class RotateQuadrantOpTest
  {
    @Test
    public void testGetDegrees1()
      {
        System.out.println("getDegrees1");
        RotateQuadrantOp op = new RotateQuadrantOp(0);
        assertEquals(0, op.getDegrees());
        op = new RotateQuadrantOp(90);
        assertEquals(90, op.getDegrees());
        op = new RotateQuadrantOp(180);
        assertEquals(180, op.getDegrees());
        op = new RotateQuadrantOp(270);
        assertEquals(270, op.getDegrees());
      }

    @Test
    public void testGetDegreesBadValues()
      {
        System.out.println("getDegreesBadValues");
        
        for (int degrees = 0; degrees < 360; degrees++)
          {
            if ((degrees % 90) != 0)  
              {
                try 
                  {
                    RotateQuadrantOp op = new RotateQuadrantOp(degrees);
                  } 
                catch (IllegalArgumentException e) 
                  {
                    continue;
                  }
                fail("IllegalArgumentException expected for degrees=" + degrees);
              }
          }
      }

    @Test
    public void testToString() 
      {
        System.out.println("toString");
        RotateQuadrantOp op = new RotateQuadrantOp(90);
        op.toString();
      }
  }
