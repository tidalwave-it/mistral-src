/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2023 by Tidalwave s.a.s.
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

import org.testng.annotations.Test;
import java.io.File;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.WriteOp;
import it.tidalwave.image.op.OptimizeOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class WriteJ2DOpTest extends BaseTestSupport 
  {
    private final static String tmp = System.getProperty("java.io.tmpdir");

    @Test
    public void testWriteJPEG()
      {
        final File f = (File)img20030701_0043_jpg.execute(new WriteOp("JPEG", tmp + "/written.jpg")).getOutput();
//        assertChecksum("b49272bff3e945d32ad9b617a17829ae", f);
      }

    @Test
    public void testWriteOptimizedJPEG()
      {
        final EditableImage result = img20030701_0043_jpg.execute2(new OptimizeOp(0.5));
        final File f = (File)result.execute(new WriteOp("JPEG", tmp + "/written-optimized.jpg")).getOutput();
//        assertChecksum("b49272bff3e945d32ad9b617a17829ae", f);
      }
  }
