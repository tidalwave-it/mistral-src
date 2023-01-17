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
package it.tidalwave.image.java2d;

import java.io.File;
import java.awt.image.SampleModel;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OptimizeOp;
import it.tidalwave.image.op.RotateOp;
import it.tidalwave.image.op.WriteOp;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class RotateJ2DOpTest extends BaseTestSupport
  {
    private EditableImage notOptimized;
    private EditableImage optimized;

    @BeforeMethod
    @Override
    public void setUp()
            throws Exception
      {
        super.setUp();
        // otherwise it's too slow!
        notOptimized = null; // Platform.isMacOSX() ? img20030701_0043_jpg : null;
        optimized = img20030701_0043_jpg.execute2(new OptimizeOp());
      }

    @Test
    public void testRotate0()
      {
        runTest(notOptimized, 0, "1576efb70f8679e0e15e4a873a8dc25b", 3000, 1995);
        runTest(optimized, 0, "1576efb70f8679e0e15e4a873a8dc25b", 3000, 1995);
      }

    @Test
    public void testRotate30()
      {
        runTest(notOptimized, 30, "47ef978c05a33d70e067158f5cf96807", 3596, 3228);
        runTest(optimized, 30, "47ef978c05a33d70e067158f5cf96807", 3596, 3228);
      }

    @Test
    public void testRotate60()
      {
        runTest(notOptimized, 60, "a6dfb566750623a772411de5f832ad12", 3228, 3596);
        runTest(optimized, 60, "a6dfb566750623a772411de5f832ad12", 3228, 3596);
      }

    @Test
    public void testRotate90()
      {
        runTest(notOptimized, 90, "36ff8f240ce58d27ba12eb96cbab48d7", 1995, 3000);
        runTest(optimized, 90, "36ff8f240ce58d27ba12eb96cbab48d7", 1995, 3000);
      }

    @Test
    public void testRotate135()
      {
        runTest(notOptimized, 135, "0a663493c1c29b4f4ce06a1a31b25b9a", 3532, 3532);
        runTest(optimized, 135, "0a663493c1c29b4f4ce06a1a31b25b9a", 3532, 3532);
      }

    private void runTest (final EditableImage image,
                          final double angle,
                          final String checksum,
                          final int width,
                          final int height)
      {
        if (image != null)
          {
            final EditableImage result = image.execute2(new RotateOp(angle));
            final String suffix = image.getInnerProperty(SampleModel.class).getClass().getName();
            final File f = (File)result.execute(new WriteOp("TIFF", tmp + "/" + angle + suffix + ".tif")).getOutput();
            assertChecksum(checksum, f);
            AssertJUnit.assertEquals(width, result.getWidth());
            AssertJUnit.assertEquals(height, result.getHeight());
          }
      }
  }
