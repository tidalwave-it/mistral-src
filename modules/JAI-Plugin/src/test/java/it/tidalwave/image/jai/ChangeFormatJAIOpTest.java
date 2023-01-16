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
package it.tidalwave.image.jai;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;
import java.io.IOException;
import it.tidalwave.image.ImageUtils;
import it.tidalwave.image.op.ChangeFormatOp;
import it.tidalwave.image.op.CreateOp;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.EditableImage.DataType;
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
