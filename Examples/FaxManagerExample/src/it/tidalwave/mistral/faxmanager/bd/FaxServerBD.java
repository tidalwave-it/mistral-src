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
 * $Id: FaxServerBD.java 757 2007-07-18 17:08:09Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.mistral.faxmanager.bd;

import java.io.IOException;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: FaxServerBD.java 757 2007-07-18 17:08:09Z fabriziogiudici $
 *
 ******************************************************************************/
public abstract class FaxServerBD 
  {
    protected FaxServerBD() 
      {
      }

    public abstract byte[] getData()
      throws IOException;
    
    public abstract String retrieveStampCode ();
    
    public static FaxServerBD getInstance (final String getDataURL, final String getStampURL)
      {
        return ((getDataURL != null) || (getStampURL != null)) ? new RealFaxServerBD(getDataURL, getStampURL) : new TestFaxServerBD(); 
      }
  }