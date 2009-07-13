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
 * $Id: CreateJAIOpTest.java 1060 2009-07-13 12:01:32Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.jai;

import javax.media.jai.PlanarImage;
import java.awt.image.Raster;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.testsupport.CreateOpTestSupport;
import org.junit.Before;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: CreateJAIOpTest.java 1060 2009-07-13 12:01:32Z fabriziogiudici $
 *
 ******************************************************************************/
public class CreateJAIOpTest extends CreateOpTestSupport
  {
    @Before
    public void installJAIPlugin()
      {
        ImplementationFactoryJAI.getInstance();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    protected Raster getRaster (final EditableImage image)
      {
        return image.getInnerProperty(PlanarImage.class).getData();
      }
  }
