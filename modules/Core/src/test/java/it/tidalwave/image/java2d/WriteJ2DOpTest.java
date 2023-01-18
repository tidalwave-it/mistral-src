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
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OptimizeOp;
import it.tidalwave.image.op.WriteOp;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class WriteJ2DOpTest extends BaseTestSupport
  {
    private static final String tmp = System.getProperty("java.io.tmpdir");

    @Test
    public void testWriteJPEG()
      {
        final var f = (File)img20030701_0043_jpg.execute(new WriteOp("JPEG", tmp + "/written.jpg")).getOutput();
//        assertChecksum("b49272bff3e945d32ad9b617a17829ae", f);
      }

    @Test
    public void testWriteOptimizedJPEG()
      {
        final var result = img20030701_0043_jpg.execute2(new OptimizeOp(0.5));
        final var f = (File)result.execute(new WriteOp("JPEG", tmp + "/written-optimized.jpg")).getOutput();
//        assertChecksum("b49272bff3e945d32ad9b617a17829ae", f);
      }
  }
