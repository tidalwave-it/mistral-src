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

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.java2d.ChangeBufferTypeJ2DOp;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ChangeBufferTypeJ2DOpTest extends BaseTestSupport
  {    
    @Test
    public void test1()
      throws IOException
      {
        ImplementationFactoryJ2D.getInstance().registerImplementation(ChangeBufferTypeOp.class, ChangeBufferTypeJ2DOp.class);
        
        EditableImage image = EditableImage.create(new ReadOp(file_timezones32_png));
        assertEquals(4, image.getBandCount());
        image.execute(new ScaleOp(0.5, Quality.BEST));
        assertEquals(4, image.getBandCount());
        image.execute(new ChangeBufferTypeOp(BufferedImage.TYPE_3BYTE_BGR));
        assertEquals(3, image.getBandCount());
        File file = new File(tmp + "/result.jpg");
        image.execute(new WriteOp("JPEG", file));
        assertChecksum("ec0149544e522dbbb441b4f83a358425", file);
      }
  }
