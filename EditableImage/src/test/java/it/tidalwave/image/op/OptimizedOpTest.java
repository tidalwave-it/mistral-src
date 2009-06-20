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
 * $Id: OptimizedOpTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
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
 * @version $Id: OptimizedOpTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class OptimizedOpTest extends TestCase 
  {
    public OptimizedOpTest (String testName) 
      {
        super(testName);
      }

    public static Test suite()
      {
        return new TestSuite(OptimizedOpTest.class);
      }

    /**
     * Test of getScale method, of class it.tidalwave.image.op.CreateOptimizedImageOp.
     */
    public void testGetScale1() 
      {
        System.out.println("getScale1");
        OptimizeOp op = new OptimizeOp();
        assertEquals(1.0, op.getScale());
      }

    /**
     * Test of getScale method, of class it.tidalwave.image.op.CreateOptimizedImageOp.
     */
    public void testGetScale2() 
      {
        System.out.println("getScale2");
        OptimizeOp op = new OptimizeOp(17.0);
        assertEquals(17.0, op.getScale());
      }

    /**
     * Test of getScale method, of class it.tidalwave.image.op.CreateOptimizedImageOp.
     */
    public void testGetScale3() 
      {
        System.out.println("getScale3");
        OptimizeOp op = new OptimizeOp(13.0, Quality.INTERMEDIATE);
        assertEquals(13.0, op.getScale());
      }

    /**
     * Test of getQuality method, of class it.tidalwave.image.op.CreateOptimizedImageOp.
     */
    public void testGetQuality1() 
      {
        System.out.println("getQuality1");
        OptimizeOp op = new OptimizeOp();
        assertEquals(Quality.FASTEST, op.getQuality());
      }

    /**
     * Test of getQuality method, of class it.tidalwave.image.op.CreateOptimizedImageOp.
     */
    public void testGetQuality2() 
      {
        System.out.println("getQuality2");
        OptimizeOp op = new OptimizeOp(17.0);
        assertEquals(Quality.FASTEST, op.getQuality());
      }

    /**
     * Test of getQuality method, of class it.tidalwave.image.op.CreateOptimizedImageOp.
     */
    public void testGetQuality3() 
      {
        System.out.println("getQuality3");
        OptimizeOp op = new OptimizeOp(13.0, Quality.INTERMEDIATE);
        assertEquals(Quality.INTERMEDIATE, op.getQuality());
      }

    /**
     * Test of toString method, of class it.tidalwave.image.op.CreateOptimizedImageOp.
     */
    public void testToString() 
      {
        System.out.println("toString");
        OptimizeOp op = new OptimizeOp(13.0, Quality.INTERMEDIATE);
        op.toString();
      }    
  }
