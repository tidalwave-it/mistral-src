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
 * $Id: TestFaxServerBD.java 902 2008-04-08 06:20:02Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.mistral.faxmanager.bd;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: TestFaxServerBD.java 902 2008-04-08 06:20:02Z fabriziogiudici $
 *
 ******************************************************************************/
class TestFaxServerBD extends FaxServerBD
  {
    public byte[] getData() 
      throws IOException 
      {        
//        final File file = new File("/Users/fritz/Business/Tidalwave/Projects/Mistral/Nextre/1020656.tif");
//        final File file = new File("/Users/fritz/Business/Tidalwave/Projects/Mistral/Nextre/Fax_Image_1.tif");
        final File file = new File("/Users/fritz/Business/Tidalwave/Projects/Mistral/Nextre/Fax_1.tif");
//        final File file = new File("C:/Documents and Settings/fritz/Desktop/faxes/309282.tif");
//        final File file = new File("/Users/fritz/Business/Tidalwave/Projects/Mistral/Nextre/broken.tif");
//        final File file = new File("/Users/fritz/Business/Tidalwave/Projects/Mistral/Nextre/72.tif");
//        final File file = new File("../../../../Nextre/9.tif");
        final int size = (int)file.length();
        final byte[] buffer = new byte[size];
        final InputStream is = new BufferedInputStream(new FileInputStream(file));
        is.read(buffer);
        is.close();
        
        return buffer;
      }

    public String retrieveStampCode() 
      {
        return "DUMMY";
      }
  }