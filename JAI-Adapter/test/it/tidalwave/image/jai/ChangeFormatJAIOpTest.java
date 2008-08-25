/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2007 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
 *                        and Emmanuele Sordini (Emmanuele@Sordini.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 *******************************************************************************
 * 
 * $Id: ChangeFormatJAIOpTest.java 696 2007-06-16 15:24:40Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.jai;

import it.tidalwave.image.ImageUtils;
import java.awt.image.RenderedImage;
import java.io.IOException;
import it.tidalwave.image.op.ChangeFormatOp;
import it.tidalwave.image.op.CreateOp;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.EditableImage.DataType;
import junit.framework.Test;
import junit.framework.TestSuite;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ChangeFormatJAIOpTest.java 696 2007-06-16 15:24:40Z fabriziogiudici $
 *
 ******************************************************************************/
public class ChangeFormatJAIOpTest extends BaseTestSupport
  {
    public static Test suite() 
      {
        return new TestSuite(ChangeFormatJAIOpTest.class);
      }
    
    public ChangeFormatJAIOpTest (final String name)
      {
        super(name);  
      }

    public void testConvert_FLOAT_USHORT ()
        throws IOException
      {
        convert(DataType.FLOAT, DataType.UNSIGNED_SHORT);
      }
    
    // MST-103
    public void testConvert_FLOAT_SHORT ()
        throws IOException
      {
        convert(DataType.FLOAT, DataType.SHORT);
      }
    
    private void convert (final DataType fromType, final DataType toType)
      {
        ImplementationFactoryJAI.getInstance();
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
