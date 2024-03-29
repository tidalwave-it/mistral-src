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

import java.nio.file.Path;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.RotateQuadrantOp;
import it.tidalwave.image.op.WriteOp;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class RotateQuadrantOpJ2DTest extends BaseTestSupport
  {
    @Test
    public void testRotate0a()
      {
        testRotate(img20030701_0043_jpg, 0, "img20030701_0043_jpg", "b49272bff3e945d32ad9b617a17829ae");
      }

    @Test
    public void testRotate0b()
      {
        testRotate(fax1_tif, 0, "fax1_tif", "89530dab29cd3dea744020810a1f9dca");
      }

    @Test
    public void testRotate90a()
      {
        testRotate(img20030701_0043_jpg, 90, "img20030701_0043_jpg", "b2b2432780aead324896a36882af272e");
      }

    @Test
    public void testRotate90b()
      {
        testRotate(fax1_tif, 90, "fax1_tif", "7c46bab02429779a3f7a8dddccb303c1");
      }

    @Test
    public void testRotate180a()
      {
        testRotate(img20030701_0043_jpg, 180, "img20030701_0043_jpg", "d0667cc17ba3b61f5885c212ab93117b");
      }

    @Test
    public void testRotate180b()
      {
        testRotate(fax1_tif, 180, "fax1_tif", "54e51bf0ba8f6657a0d0bd702e12cd3c");
      }

    @Test
    public void testRotate270a()
      {
        testRotate(img20030701_0043_jpg, 270, "img20030701_0043_jpg", "56a902cb6cf0bae7965a9f12b4104cf3");
      }

    @Test
    public void testRotate270b()
      {
        testRotate(fax1_tif, 270, "fax1_tif", "945269cef6b91c25896167dd2a3f4fed");
      }

    @Test
    public void testRotate (final EditableImage image, final int angle, final String prefix, final String hash)
      {
        final var result = image.execute(new RotateQuadrantOp(angle));
        final var f = (Path)result.executeInPlace(new WriteOp("TIFF", tmp + "/" + prefix + "-" + angle + ".tif")).getOutput();
        assertChecksum(hash, f);

        if ((angle / 90) % 2 == 0)
          {
            AssertJUnit.assertEquals(image.getWidth(), result.getWidth());
            AssertJUnit.assertEquals(image.getHeight(), result.getHeight());
          }
        else
          {
            AssertJUnit.assertEquals(image.getWidth(), result.getHeight());
            AssertJUnit.assertEquals(image.getHeight(), result.getWidth());
          }
      }
  }
