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
 * $Id: PaintOpTest.java 597 2007-04-08 17:22:42Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import java.awt.Graphics2D;
import javax.swing.JLabel;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: PaintOpTest.java 597 2007-04-08 17:22:42Z fabriziogiudici $
 *
 ******************************************************************************/
public class PaintOpTest extends TestCase 
  {
    private final static JLabel c = new JLabel();
    
    private final static Graphics2D g = (Graphics2D)c.getGraphics();
            
    public static Test suite() 
      {
        return new TestSuite(PaintOpTest.class);
      }

    /**
     * Test of getX method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testGetX1()  
      {
        System.out.println("getX1");
        PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        assertEquals(1, op.getX());
      }

    /**
     * Test of getX method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testGetX2()  
      {
        System.out.println("getX2");
        PaintOp op = new PaintOp(g, 1, 2, null, null);
        assertEquals(1, op.getX());
      }

    /**
     * Test of getY method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testGetY1() 
      {
        System.out.println("getY1");
        PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        assertEquals(2, op.getY());
      }

    /**
     * Test of getY method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testGetY2() 
      {
        System.out.println("getY2");
        PaintOp op = new PaintOp(g, 1, 2, null, null);
        assertEquals(2, op.getY());
      }

    /**
     * Test of getW method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testGetW1() 
      {
        System.out.println("getW1");
        PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        assertEquals(3, op.getW());
      }

    /**
     * Test of getW method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testGetW2() 
      {
        System.out.println("getW2");
        PaintOp op = new PaintOp(g, 1, 2, null, null);
        assertEquals(0, op.getW());
      }

    /**
     * Test of getH method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testGetH1() 
      {
        System.out.println("getH");
        PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        assertEquals(4, op.getH());
      }

    /**
     * Test of getH method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testGetH2() 
      {
        System.out.println("getH");
        PaintOp op = new PaintOp(g, 1, 2, null, null);
        assertEquals(0, op.getH());
      }

    /**
     * Test of getGraphics2D method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testGetGraphics2D1() 
      {
        System.out.println("getGraphics2D1");
        PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        assertEquals(g, op.getGraphics2D());
      }

    /**
     * Test of getGraphics2D method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testGetGraphics2D2() 
      {
        System.out.println("getGraphics2D2");
        PaintOp op = new PaintOp(g, 1, 2, null, null);
        assertEquals(g, op.getGraphics2D());
      }

    /**
     * Test of getPreviewSettings method, of class it.tidalwave.image.op.PaintOp.
     */
/*    public void testGetPreviewSettings() 
      {
        System.out.println("getPreviewSettings");
        fail("The test case is a prototype.");
      }*/

    /**
     * Test of toString method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testToString1()   
      {
        System.out.println("toString1");
        PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        op.toString();
      } 
    
    /**
     * Test of toString method, of class it.tidalwave.image.op.PaintOp.
     */
    public void testToString2()   
      {
        System.out.println("toString2");
        PaintOp op = new PaintOp(g, 1, 2, null, null);
        op.toString();
      } 
  }
