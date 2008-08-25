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
 * $Id: CreateJAIOpTest.java 677 2007-06-15 13:35:23Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.jai;

import javax.media.jai.PlanarImage;
import java.awt.image.Raster;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.testsupport.CreateOpTestSupport;
import junit.framework.Test;
import junit.framework.TestSuite;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: CreateJAIOpTest.java 677 2007-06-15 13:35:23Z fabriziogiudici $
 *
 ******************************************************************************/
public class CreateJAIOpTest extends CreateOpTestSupport
  {
    public static Test suite() 
      {
        return new TestSuite(CreateJAIOpTest.class);
      }
    
    public CreateJAIOpTest (final String name)
      {
        super(name);  
      }

    public void setUp ()
        throws Exception
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
