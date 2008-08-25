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
 * $Id: ApplyUnsharpMaskOpTest.java 474 2007-02-02 19:27:36Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import it.tidalwave.image.op.ApplyUnsharpMaskOp;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ApplyUnsharpMaskOpTest.java 474 2007-02-02 19:27:36Z fabriziogiudici $
 *
 ******************************************************************************/
public class ApplyUnsharpMaskOpTest extends TestCase 
  {
    public ApplyUnsharpMaskOpTest(String testName) 
      {
        super(testName);
      }

    public static Test suite()
      {
        return new TestSuite(ApplyUnsharpMaskOpTest.class);
      }

    /**
     * Test of getIntensity method, of class it.tidalwave.image.op.ApplyUnsharpMaskOp.
     */
    public void testGetIntensity() 
      {
        System.out.println("getIntensity");
        ApplyUnsharpMaskOp op = new ApplyUnsharpMaskOp(12.34, 56.78, 90.12);
        assertEquals(12.34, op.getIntensity());
      }

    /**
     * Test of getRadius method, of class it.tidalwave.image.op.ApplyUnsharpMaskOp.
     */
    public void testGetRadius() 
      {
        System.out.println("getRadius");
        ApplyUnsharpMaskOp op = new ApplyUnsharpMaskOp(12.34, 56.78, 90.12);
        assertEquals(56.78, op.getRadius());
      }  

    /**
     * Test of getThreshold method, of class it.tidalwave.image.op.ApplyUnsharpMaskOp.
     */
    public void testGetThreshold() 
      {
        System.out.println("getThreshold");
        ApplyUnsharpMaskOp op = new ApplyUnsharpMaskOp(12.34, 56.78, 90.12);
        assertEquals(90.12, op.getThreshold());
      }

    /**
     * Test of toString method, of class it.tidalwave.image.op.ApplyUnsharpMaskOp.
     */
    public void testToString() 
      {
        System.out.println("toString");
        ApplyUnsharpMaskOp op = new ApplyUnsharpMaskOp(12.34, 56.78, 90.12);
        op.toString();
      }  
  }
