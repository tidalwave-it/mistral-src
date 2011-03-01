/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici
 *                        and Emmanuele Sordini
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
 * $Id$
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ReadOpTest extends BaseTestSupport
  {
    static
      {
        
        final String[] mimeTypes = ImageIO.getReaderMIMETypes();
        logger.info("MIME TYPES for PHOTODATALOADER: " + Arrays.asList(mimeTypes));
        
        for (final String mimeType : mimeTypes)
          {
            for (final Iterator<ImageReader> i = ImageIO.getImageReadersByMIMEType(mimeType); i.hasNext(); )
              {
                final ImageReader imageReader = i.next();
                logger.info(">>>> " + mimeType + " -> " + imageReader.getOriginatingProvider().getClass().getName());
              }
          }
      }
    
    @Test
    public void testReadJPG1() 
      throws FileNotFoundException, IOException
      {
        File file = file_20030701_0043_jpg;
        assertTrue(file.exists());
        final EditableImage image = EditableImage.create(new ReadOp(file));
        assertEquals("JPEG", image.getAttribute(EditableImage.PROP_FORMAT));
        assertEquals("image/jpeg", image.getAttribute(EditableImage.PROP_MIME_TYPE));
      }
    
    @Test
    public void testReadTIFF1() 
      throws FileNotFoundException, IOException
      {
        File file = file_uncompressed_tiff;
        assertTrue(file.exists());
        final EditableImage image = EditableImage.create(new ReadOp(file));
        assertEquals("tif", image.getAttribute(EditableImage.PROP_FORMAT));
        assertEquals("image/tiff", image.getAttribute(EditableImage.PROP_MIME_TYPE));
      }
    
    @Test
    public void testReadTIFF2() 
      throws FileNotFoundException, IOException
      {
        File file = file_w1_tiff;
        assertTrue(file.exists());
        final EditableImage image = EditableImage.create(new ReadOp(file));
        assertEquals("tif", image.getAttribute(EditableImage.PROP_FORMAT));
        assertEquals("image/tiff", image.getAttribute(EditableImage.PROP_MIME_TYPE));
      }
  }
