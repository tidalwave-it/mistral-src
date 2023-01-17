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

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class ApplyUnsharpMaskOpTest
  {
    @Test
    public void testGetIntensity()
      {
        System.out.println("getIntensity");
        final ApplyUnsharpMaskOp op = new ApplyUnsharpMaskOp(12.34, 56.78, 90.12);
        AssertJUnit.assertEquals(12.34, op.getIntensity(), 0.0);
      }

    @Test
    public void testGetRadius()
      {
        System.out.println("getRadius");
        final ApplyUnsharpMaskOp op = new ApplyUnsharpMaskOp(12.34, 56.78, 90.12);
        AssertJUnit.assertEquals(56.78, op.getRadius(), 0.0);
      }

    @Test
    public void testGetThreshold()
      {
        System.out.println("getThreshold");
        final ApplyUnsharpMaskOp op = new ApplyUnsharpMaskOp(12.34, 56.78, 90.12);
        AssertJUnit.assertEquals(90.12, op.getThreshold(), 0.0);
      }

    @Test
    public void testToString()
      {
        System.out.println("toString");
        final ApplyUnsharpMaskOp op = new ApplyUnsharpMaskOp(12.34, 56.78, 90.12);
        op.toString();
      }
  }
