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
import it.tidalwave.image.op.ScaleOp;
import it.tidalwave.image.op.WriteOp;
import it.tidalwave.image.util.Platform;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class ScaleJ2DOpTest extends BaseTestSupport
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
        notOptimized = Platform.isMacOSX() ? img20030701_0043_jpg : null;
        optimized = img20030701_0043_jpg.execute2(new OptimizeOp());
      }

    @Test
    public void testScale10()
      {
        runTest(notOptimized, 0.10, "ac0fe6d76a306a1a40592e507b42bc7d", 300, 200);
        runTest(optimized, 0.10, "49be2bb4ea4f1bf6918495f9fac3234f", 300, 200);
      }

    @Test
    public void testScale30()
      {
        runTest(notOptimized, 0.30, "df3c61d0aa182bc20e693e68b18015c4", 900, 599);
        runTest(optimized, 0.30, "4edb72a50bd41fc7fe68d0ede3dd3fe8", 900, 599);
      }

    @Test
    public void testScale50()
      {
        runTest(notOptimized, 0.50, "1542dabc6802b7216aaae6273e37f240", 1500, 998);
        runTest(optimized, 0.50, "78f7f3bac7d4684f51776d687fe42c6f", 1500, 998);
      }

    @Test
    public void testScale90()
      {
        runTest(notOptimized, 0.90, "4e0e331a5a4ecd7c9c9380bce7f10f2f", 2700, 1796);
        runTest(optimized, 0.90, "503be63f91ad6117e254b507b91bf035", 2700, 1796);
      }

    @Test
    public void testScale135()
      {
        runTest(notOptimized, 1.35, "c9b070063633e7250ec790630b5b0d3c", 4050, 2693);
        runTest(optimized, 1.35, "a4b449318eb07e481167a8a0e40f78be", 4050, 2693);
      }

    private void runTest (final EditableImage image,
                          final double scale,
                          final String checksum,
                          final int width,
                          final int height)
      {
        if (image != null)
          {
            final String suffix = image.getInnerProperty(SampleModel.class).getClass().getName();
            final EditableImage result = image.execute2(new ScaleOp(scale));
            final File f = (File)result.execute(new WriteOp("TIFF", tmp + "/" + scale + suffix + ".tif")).getOutput();
            assertChecksum(checksum, f);
            AssertJUnit.assertEquals(width, result.getWidth());
            AssertJUnit.assertEquals(height, result.getHeight());
          }
      }
  }
