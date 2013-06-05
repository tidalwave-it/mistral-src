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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.image.java2d;

import org.testng.annotations.Test;
import java.io.File;
import org.imajine.image.BaseTestSupport;
import org.imajine.image.EditableImage;
import org.imajine.image.op.WriteOp;
import org.imajine.image.op.OptimizeOp;

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
        File f = (File)img20030701_0043_jpg.execute(new WriteOp("JPEG", tmp + "/written.jpg")).getOutput();
//        assertChecksum("b49272bff3e945d32ad9b617a17829ae", f);
      }

    @Test
    public void testWriteOptimizedJPEG()
      {
        EditableImage result = img20030701_0043_jpg.execute2(new OptimizeOp(0.5));
        File f = (File)result.execute(new WriteOp("JPEG", tmp + "/written-optimized.jpg")).getOutput();
//        assertChecksum("b49272bff3e945d32ad9b617a17829ae", f);
      }
  }
