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

import java.io.IOException;
import java.nio.file.Path;
import java.awt.image.BufferedImage;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.java2d.ChangeBufferTypeJ2DOp;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class ChangeBufferTypeJ2DOpTest extends BaseTestSupport
  {
    @Test
    public void test1()
            throws IOException
      {
        ImplementationFactoryJ2D.getDefault().registerImplementation(ChangeBufferTypeOp.class, ChangeBufferTypeJ2DOp.class);

        final var image = EditableImage.create(new ReadOp(file_timezones32_png));
        AssertJUnit.assertEquals(4, image.getBandCount());
        image.executeInPlace(new ScaleOp(0.5, Quality.BEST));
        AssertJUnit.assertEquals(4, image.getBandCount());
        image.executeInPlace(new ChangeBufferTypeOp(BufferedImage.TYPE_3BYTE_BGR));
        AssertJUnit.assertEquals(3, image.getBandCount());
        final var file = Path.of(tmp + "/result.jpg");
        image.executeInPlace(new WriteOp("JPEG", file));
        assertChecksum("ec0149544e522dbbb441b4f83a358425", file);
      }
  }
