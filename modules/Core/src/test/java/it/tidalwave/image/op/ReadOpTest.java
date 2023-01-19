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
package it.tidalwave.image.op;

import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import lombok.extern.slf4j.Slf4j;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class ReadOpTest extends BaseTestSupport
  {
    static
      {
        final var mimeTypes = ImageIO.getReaderMIMETypes();
        log.info("MIME TYPES for PHOTODATALOADER: " + Arrays.asList(mimeTypes));

        for (final var mimeType : mimeTypes)
          {
            for (final var i = ImageIO.getImageReadersByMIMEType(mimeType); i.hasNext(); )
              {
                final var imageReader = i.next();
                log.info(">>>> " + mimeType + " -> " + imageReader.getOriginatingProvider().getClass().getName());
              }
          }
      }

    @Test
    public void testReadJPG1()
            throws IOException
      {
        final var file = file_20030701_0043_jpg;
        AssertJUnit.assertTrue(file.toFile().exists());
        final var image = EditableImage.create(new ReadOp(file));
        AssertJUnit.assertEquals("JPEG", image.getAttribute(EditableImage.PROP_FORMAT));
        AssertJUnit.assertEquals("image/jpeg", image.getAttribute(EditableImage.PROP_MIME_TYPE));
      }

    @Test
    public void testReadTIFF1()
            throws IOException
      {
        final var file = file_uncompressed_tiff;
        AssertJUnit.assertTrue(Files.exists(file));
        final var image = EditableImage.create(new ReadOp(file));
        AssertJUnit.assertEquals("tif", image.getAttribute(EditableImage.PROP_FORMAT));
        AssertJUnit.assertEquals("image/tiff", image.getAttribute(EditableImage.PROP_MIME_TYPE));
      }

    @Test
    public void testReadTIFF2()
            throws IOException
      {
        final var file = file_w1_tiff;
        AssertJUnit.assertTrue(Files.exists(file));
        final var image = EditableImage.create(new ReadOp(file));
        AssertJUnit.assertEquals("tif", image.getAttribute(EditableImage.PROP_FORMAT));
        AssertJUnit.assertEquals("image/tiff", image.getAttribute(EditableImage.PROP_MIME_TYPE));
      }
  }
