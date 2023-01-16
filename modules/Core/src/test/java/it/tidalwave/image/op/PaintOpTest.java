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

import java.awt.Graphics2D;
import javax.swing.JLabel;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class PaintOpTest
  {
    private static final JLabel c = new JLabel();

    private static final Graphics2D g = (Graphics2D)c.getGraphics();

    @Test
    public void testGetX1()
      {
        System.out.println("getX1");
        final PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        AssertJUnit.assertEquals(1, op.getX());
      }

    @Test
    public void testGetX2()
      {
        System.out.println("getX2");
        final PaintOp op = new PaintOp(g, 1, 2, null, null);
        AssertJUnit.assertEquals(1, op.getX());
      }

    @Test
    public void testGetY1()
      {
        System.out.println("getY1");
        final PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        AssertJUnit.assertEquals(2, op.getY());
      }

    @Test
    public void testGetY2()
      {
        System.out.println("getY2");
        final PaintOp op = new PaintOp(g, 1, 2, null, null);
        AssertJUnit.assertEquals(2, op.getY());
      }

    @Test
    public void testGetW1()
      {
        System.out.println("getW1");
        final PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        AssertJUnit.assertEquals(3, op.getW());
      }

    @Test
    public void testGetW2()
      {
        System.out.println("getW2");
        final PaintOp op = new PaintOp(g, 1, 2, null, null);
        AssertJUnit.assertEquals(0, op.getW());
      }

    @Test
    public void testGetH1()
      {
        System.out.println("getH");
        final PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        AssertJUnit.assertEquals(4, op.getH());
      }

    @Test
    public void testGetH2()
      {
        System.out.println("getH");
        final PaintOp op = new PaintOp(g, 1, 2, null, null);
        AssertJUnit.assertEquals(0, op.getH());
      }

    @Test
    public void testGetGraphics2D1()
      {
        System.out.println("getGraphics2D1");
        final PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        AssertJUnit.assertEquals(g, op.getGraphics2D());
      }

    @Test
    public void testGetGraphics2D2()
      {
        System.out.println("getGraphics2D2");
        final PaintOp op = new PaintOp(g, 1, 2, null, null);
        AssertJUnit.assertEquals(g, op.getGraphics2D());
      }

    /**
     * Test of getPreviewSettings method, of class it.tidalwave.image.op.PaintOp.
     */
/*    public void testGetPreviewSettings()
      {
        System.out.println("getPreviewSettings");
        fail("The test case is a prototype.");
      }*/
    @Test
    public void testToString1()
      {
        System.out.println("toString1");
        final PaintOp op = new PaintOp(g, 1, 2, 3, 4, null, null);
        op.toString();
      }

    @Test
    public void testToString2()
      {
        System.out.println("toString2");
        final PaintOp op = new PaintOp(g, 1, 2, null, null);
        op.toString();
      }
  }
