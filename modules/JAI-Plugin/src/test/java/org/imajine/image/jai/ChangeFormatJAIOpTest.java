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
package org.imajine.image.jai;

import java.io.IOException;
import org.imajine.image.ImageUtils;
import org.imajine.image.op.ChangeFormatOp;
import org.imajine.image.op.CreateOp;
import org.imajine.image.BaseTestSupport;
import org.imajine.image.EditableImage;
import org.imajine.image.EditableImage.DataType;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openide.util.Lookup;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
public class ChangeFormatJAIOpTest extends BaseTestSupport
  {
    @Test
    public void testConvert_FLOAT_USHORT ()
      throws IOException
      {
        convert(DataType.FLOAT, DataType.UNSIGNED_SHORT);
      }
    
    // MST-103
    @Test
    public void testConvert_FLOAT_SHORT ()
      throws IOException
      {
        convert(DataType.FLOAT, DataType.SHORT);
      }
    
    private void convert (final DataType fromType, final DataType toType)
      {
        Lookup.getDefault().lookup(ImplementationFactoryJAI.class);
        final EditableImage image = EditableImage.create(new CreateOp(640, 480, fromType));
        assertEquals(fromType, image.getDataType());
        assertEquals("KODAK Grayscale Conversion - Gamma 1.0", ImageUtils.getICCProfileName(image.getICCProfile()));
        assertNotNull(image.getICCProfile());
        image.execute(new ChangeFormatOp(toType));
        assertEquals(toType, image.getDataType());
        assertNotNull(image.getICCProfile());
        assertEquals("KODAK Grayscale Conversion - Gamma 1.0", ImageUtils.getICCProfileName(image.getICCProfile()));
      }
  }
