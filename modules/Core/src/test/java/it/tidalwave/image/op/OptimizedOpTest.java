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

import it.tidalwave.image.op.OptimizeOp;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import it.tidalwave.image.Quality;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class OptimizedOpTest 
  {
    @Test
    public void testGetScale1() 
      {
        System.out.println("getScale1");
        OptimizeOp op = new OptimizeOp();
        AssertJUnit.assertEquals(1.0, op.getScale(), 0.0);
      }

    @Test
    public void testGetScale2() 
      {
        System.out.println("getScale2");
        OptimizeOp op = new OptimizeOp(17.0);
        AssertJUnit.assertEquals(17.0, op.getScale(), 0.0);
      }

    @Test
    public void testGetScale3() 
      {
        System.out.println("getScale3");
        OptimizeOp op = new OptimizeOp(13.0, Quality.INTERMEDIATE);
        AssertJUnit.assertEquals(13.0, op.getScale(), 0.0);
      }

    @Test
    public void testGetQuality1() 
      {
        System.out.println("getQuality1");
        OptimizeOp op = new OptimizeOp();
        AssertJUnit.assertEquals(Quality.FASTEST, op.getQuality());
      }

    @Test
    public void testGetQuality2() 
      {
        System.out.println("getQuality2");
        OptimizeOp op = new OptimizeOp(17.0);
        AssertJUnit.assertEquals(Quality.FASTEST, op.getQuality());
      }

    @Test
    public void testGetQuality3() 
      {
        System.out.println("getQuality3");
        OptimizeOp op = new OptimizeOp(13.0, Quality.INTERMEDIATE);
        AssertJUnit.assertEquals(Quality.INTERMEDIATE, op.getQuality());
      }

    @Test
    public void testToString() 
      {
        System.out.println("toString");
        OptimizeOp op = new OptimizeOp(13.0, Quality.INTERMEDIATE);
        op.toString();
      }    
  }
