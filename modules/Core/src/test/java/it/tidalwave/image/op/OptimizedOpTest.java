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
public class OptimizedOpTest
  {
    @Test
    public void testGetScale1()
      {
        System.out.println("getScale1");
        final var op = new OptimizeOp();
        AssertJUnit.assertEquals(1.0, op.getScale(), 0.0);
      }

    @Test
    public void testGetScale2()
      {
        System.out.println("getScale2");
        final var op = new OptimizeOp(17.0);
        AssertJUnit.assertEquals(17.0, op.getScale(), 0.0);
      }

    @Test
    public void testGetScale3()
      {
        System.out.println("getScale3");
        final var op = new OptimizeOp(13.0, Quality.INTERMEDIATE);
        AssertJUnit.assertEquals(13.0, op.getScale(), 0.0);
      }

    @Test
    public void testGetQuality1()
      {
        System.out.println("getQuality1");
        final var op = new OptimizeOp();
        AssertJUnit.assertEquals(Quality.FASTEST, op.getQuality());
      }

    @Test
    public void testGetQuality2()
      {
        System.out.println("getQuality2");
        final var op = new OptimizeOp(17.0);
        AssertJUnit.assertEquals(Quality.FASTEST, op.getQuality());
      }

    @Test
    public void testGetQuality3()
      {
        System.out.println("getQuality3");
        final var op = new OptimizeOp(13.0, Quality.INTERMEDIATE);
        AssertJUnit.assertEquals(Quality.INTERMEDIATE, op.getQuality());
      }

    @Test
    public void testToString()
      {
        System.out.println("toString");
        final var op = new OptimizeOp(13.0, Quality.INTERMEDIATE);
        op.toString();
      }
  }
