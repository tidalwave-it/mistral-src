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

import it.tidalwave.image.Quality;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class ScaleOpTest
  {
    @Test
    public void testGetXScale1()
      {
        System.out.println("getXScale1");
        final ScaleOp op = new ScaleOp(17.0);
        AssertJUnit.assertEquals(17.0, op.getXScale(), 0.0);
      }

    @Test
    public void testGetXScale2()
      {
        System.out.println("getXScale2");
        final ScaleOp op = new ScaleOp(17.0, 13.0);
        AssertJUnit.assertEquals(17.0, op.getXScale(), 0.0);
      }

    @Test
    public void testGetXScale3()
      {
        System.out.println("getXScale3");
        final ScaleOp op = new ScaleOp(17.0, Quality.INTERMEDIATE);
        AssertJUnit.assertEquals(17.0, op.getXScale(), 0.0);
      }

    @Test
    public void testGetXScale4()
      {
        System.out.println("getXScale4");
        final ScaleOp op = new ScaleOp(17.0, 13.0, Quality.INTERMEDIATE);
        AssertJUnit.assertEquals(17.0, op.getXScale(), 0.0);
      }

    @Test
    public void testGetYScale1()
      {
        System.out.println("getYScale1");
        final ScaleOp op = new ScaleOp(17.0);
        AssertJUnit.assertEquals(17.0, op.getYScale(), 0.0);
      }

    @Test
    public void testGetYScale2()
      {
        System.out.println("getYScale2");
        final ScaleOp op = new ScaleOp(17.0, 13.0);
        AssertJUnit.assertEquals(13.0, op.getYScale(), 0.0);
      }

    @Test
    public void testGetYScale3()
      {
        System.out.println("getYScale3");
        final ScaleOp op = new ScaleOp(17.0, Quality.INTERMEDIATE);
        AssertJUnit.assertEquals(17.0, op.getYScale(), 0.0);
      }

    @Test
    public void testGetYScale4()
      {
        System.out.println("getYScale4");
        final ScaleOp op = new ScaleOp(17.0, 13.0, Quality.INTERMEDIATE);
        AssertJUnit.assertEquals(13.0, op.getYScale(), 0.0);
      }

    @Test
    public void testGetQuality1()
      {
        System.out.println("getQuality1");
        final ScaleOp op = new ScaleOp(17.0);
        AssertJUnit.assertEquals(Quality.FASTEST, op.getQuality());
      }

    /**
     * Test of getQuality method, of class it.tidalwave.image.op.ScaleOp.
     */
    @Test
    public void testGetQuality2()
      {
        System.out.println("getQuality2");
        final ScaleOp op = new ScaleOp(17.0, 13.0);
        AssertJUnit.assertEquals(Quality.FASTEST, op.getQuality());
      }

    /**
     * Test of getQuality method, of class it.tidalwave.image.op.ScaleOp.
     */
    @Test
    public void testGetQuality3()
      {
        System.out.println("getQuality3");
        final ScaleOp op = new ScaleOp(17.0, Quality.INTERMEDIATE);
        AssertJUnit.assertEquals(Quality.INTERMEDIATE, op.getQuality());
      }

    @Test
    public void testGetQuality4()
      {
        System.out.println("getQuality4");
        final ScaleOp op = new ScaleOp(17.0, 13.0, Quality.INTERMEDIATE);
        AssertJUnit.assertEquals(Quality.INTERMEDIATE, op.getQuality());
      }

    @Test
    public void testToString()
      {
        System.out.println("toString");
        final ScaleOp op = new ScaleOp(17.0, 13.0, Quality.INTERMEDIATE);
        op.toString();
      }
  }
