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
package it.tidalwave.image.op;

import it.tidalwave.image.op.ChangeBufferTypeOp;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import org.openide.util.Lookup;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.java2d.ChangeBufferTypeJ2DOp;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
public class ChangeBufferTypeJ2DOpTest extends BaseTestSupport
  {    
    @Test
    public void test1()
      throws IOException
      {
        Lookup.getDefault().lookup(ImplementationFactoryJ2D.class).registerImplementation(ChangeBufferTypeOp.class, ChangeBufferTypeJ2DOp.class);
        
        EditableImage image = EditableImage.create(new ReadOp(file_timezones32_png));
        AssertJUnit.assertEquals(4, image.getBandCount());
        image.execute(new ScaleOp(0.5, Quality.BEST));
        AssertJUnit.assertEquals(4, image.getBandCount());
        image.execute(new ChangeBufferTypeOp(BufferedImage.TYPE_3BYTE_BGR));
        AssertJUnit.assertEquals(3, image.getBandCount());
        File file = new File(tmp + "/result.jpg");
        image.execute(new WriteOp("JPEG", file));
        assertChecksum("ec0149544e522dbbb441b4f83a358425", file);
      }
  }
