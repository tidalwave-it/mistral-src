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
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.op.CaptureOp;
import lombok.extern.slf4j.Slf4j;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class CaptureJ2DOpTest extends BaseTestSupport
  {
    @Test
    public void testOp()
            throws Exception
      {
        log.info("CaptureJ2DOpTest");
        final var label = new JLabel("text");
        final var frame = new JFrame();
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
        Thread.sleep(2000);
        final var operation = new CaptureOp(label);
        final var instance = new CaptureJ2DOp();
        final var result = instance.execute(operation, null, null);

        final var f = new File(tmp + "/CaptureOp.tif");
        ImageIO.write(result, "TIFF", f);
        AssertJUnit.assertEquals(label.getWidth(), result.getWidth());
        AssertJUnit.assertEquals(label.getHeight(), result.getHeight());
        assertChecksum("5bd101c6e9b6d3901b1eb7a0e5f98d64", f);
      }
  }
