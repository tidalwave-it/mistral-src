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
 * $Id: RotateQuadrantOpTest.java 180 2006-11-17 16:21:33Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: RotateQuadrantOpTest.java 180 2006-11-17 16:21:33Z fabriziogiudici $
 *
 ******************************************************************************/
public class RotateQuadrantOpTest extends TestCase 
  {
    public RotateQuadrantOpTest (String testName) 
      {
        super(testName);
      }

    public static Test suite()
      {
        return new TestSuite(RotateQuadrantOpTest.class);
      }

    /**
     * Test of getDegrees method, of class it.tidalwave.image.op.RotateQuadrantOp.
     */
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

    /**
     * Test of getDegrees method, of class it.tidalwave.image.op.RotateQuadrantOp.
     */
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

    /**
     * Test of toString method, of class it.tidalwave.image.op.RotateQuadrantOp.
     */
    public void testToString() 
      {
        System.out.println("toString");
        RotateQuadrantOp op = new RotateQuadrantOp(90);
        op.toString();
      }
  }
