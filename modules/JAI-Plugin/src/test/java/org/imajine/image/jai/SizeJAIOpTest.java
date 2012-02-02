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
package org.imajine.image.jai;

import java.io.IOException;
import org.openide.util.Lookup;
import org.imajine.image.BaseTestSupport;
import org.imajine.image.EditableImage;
import org.imajine.image.op.ForceRenderingOp;
import org.imajine.image.op.ReadOp;
import org.imajine.image.op.SizeOp;
import org.imajine.image.op.WriteOp;
import org.junit.Test;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
public class SizeJAIOpTest extends BaseTestSupport
  {
    @Test
    public void testExecute()
      throws IOException
      {
//        ImplementationFactoryJ2D.unregister(SizeOp.class);
        Lookup.getDefault().lookup(ImplementationFactoryJAI.class);
        final EditableImage image = EditableImage.create(new ReadOp(file_20030701_0043_jpg));
        
        for (float scale = 0.1f; scale <= 1.0f; scale += 0.1f)
          {            
            final EditableImage result = image.execute2(new SizeOp(scale));
            result.execute(new ForceRenderingOp());
            result.execute(new WriteOp("JPEG", "build/test/results/result-" + scale + ".jpg"));
          }
      }
  }
