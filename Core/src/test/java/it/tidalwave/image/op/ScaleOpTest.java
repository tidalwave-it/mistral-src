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
 * $Id: ScaleOpTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import it.tidalwave.image.Quality;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ScaleOpTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class ScaleOpTest extends TestCase 
  {
    public ScaleOpTest(String testName) 
      {
        super(testName);
      }

    public static Test suite() 
      {
        return new TestSuite(ScaleOpTest.class);
      }

    /**
     * Test of getXScale method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetXScale1() 
      {
        System.out.println("getXScale1");
        ScaleOp op = new ScaleOp(17.0);
        assertEquals(17.0, op.getXScale());
      }

    /**
     * Test of getXScale method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetXScale2() 
      {
        System.out.println("getXScale2");
        ScaleOp op = new ScaleOp(17.0, 13.0);
        assertEquals(17.0, op.getXScale());
      }

    /**
     * Test of getXScale method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetXScale3() 
      {
        System.out.println("getXScale3");
        ScaleOp op = new ScaleOp(17.0, Quality.INTERMEDIATE);
        assertEquals(17.0, op.getXScale());
      }

    /**
     * Test of getXScale method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetXScale4() 
      {
        System.out.println("getXScale4");
        ScaleOp op = new ScaleOp(17.0, 13.0, Quality.INTERMEDIATE);
        assertEquals(17.0, op.getXScale());
      }

    /**
     * Test of getYScale method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetYScale1() 
      {
        System.out.println("getYScale1");
        ScaleOp op = new ScaleOp(17.0);
        assertEquals(17.0, op.getYScale());
      }

    /**
     * Test of getYScale method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetYScale2() 
      {
        System.out.println("getYScale2");
        ScaleOp op = new ScaleOp(17.0, 13.0);
        assertEquals(13.0, op.getYScale());
      }

    /**
     * Test of getYScale method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetYScale3() 
      {
        System.out.println("getYScale3");
        ScaleOp op = new ScaleOp(17.0, Quality.INTERMEDIATE);
        assertEquals(17.0, op.getYScale());
      }

    /**
     * Test of getYScale method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetYScale4() 
      {
        System.out.println("getYScale4");
        ScaleOp op = new ScaleOp(17.0, 13.0, Quality.INTERMEDIATE);
        assertEquals(13.0, op.getYScale());
      }

    /**
     * Test of getQuality method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetQuality1() 
      {
        System.out.println("getQuality1");
        ScaleOp op = new ScaleOp(17.0);
        assertEquals(Quality.FASTEST, op.getQuality());
      }

    /**
     * Test of getQuality method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetQuality2() 
      {
        System.out.println("getQuality2");
        ScaleOp op = new ScaleOp(17.0, 13.0);
        assertEquals(Quality.FASTEST, op.getQuality());
      }

    /**
     * Test of getQuality method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetQuality3() 
      {
        System.out.println("getQuality3");
        ScaleOp op = new ScaleOp(17.0, Quality.INTERMEDIATE);
        assertEquals(Quality.INTERMEDIATE, op.getQuality());
      }

    /**
     * Test of getQuality method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testGetQuality4() 
      {
        System.out.println("getQuality4");
        ScaleOp op = new ScaleOp(17.0, 13.0, Quality.INTERMEDIATE);
        assertEquals(Quality.INTERMEDIATE, op.getQuality());
      }

    /**
     * Test of toString method, of class it.tidalwave.image.op.ScaleOp.
     */
    public void testToString() 
      {
        System.out.println("toString");
        ScaleOp op = new ScaleOp(17.0, 13.0, Quality.INTERMEDIATE);
        op.toString();
      }
  }
