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
package org.imajine.image.op;

import org.imajine.image.BaseTestSupport;
import org.junit.Test;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class PrintOpTest extends BaseTestSupport
  {
    @Test
    public void testPrint()
      throws Exception
      {
        // It works - commented out because it blocks and print...
//        final EditableImage image = EditableImage.create(new ReadOp(file_20030701_0043_jpg));
//        image.execute(new PrintOp());
      }
  }
