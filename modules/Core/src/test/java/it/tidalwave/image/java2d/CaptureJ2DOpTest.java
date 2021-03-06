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
package it.tidalwave.image.java2d;

import it.tidalwave.image.java2d.CaptureJ2DOp;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JFrame;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.op.CaptureOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class CaptureJ2DOpTest extends BaseTestSupport 
  {
    @Test
    public void testOp() 
      throws Exception
      {
        log("CaptureJ2DOpTest");
        final JLabel label = new JLabel("text");
        JFrame frame = new JFrame();
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
        Thread.sleep(2000);
        final CaptureOp operation = new CaptureOp(label);
        final CaptureJ2DOp instance = new CaptureJ2DOp();
        final BufferedImage result = instance.execute(operation, null, null);
        
        final File f = new File(tmp + "/CaptureOp.tif");
        ImageIO.write(result, "TIFF", f);
        AssertJUnit.assertEquals(label.getWidth(),  result.getWidth());
        AssertJUnit.assertEquals(label.getHeight(), result.getHeight());
        assertChecksum("5bd101c6e9b6d3901b1eb7a0e5f98d64", f);
      }     
  }
