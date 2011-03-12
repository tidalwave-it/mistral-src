/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2011 by Tidalwave s.a.s.
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
 * SCM: https://kenai.com/hg/mistral~src
 *
 **********************************************************************************************************************/
package it.tidalwave.mistral.faxmanager.bd;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
class RealFaxServerBD extends FaxServerBD
  {
    private final String getDataURL;
    private final String getStampURL;
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    protected RealFaxServerBD (final String getDataURL, final String getStampURL)
      {
        this.getDataURL = getDataURL;
        this.getStampURL = getStampURL;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public byte[] getData() 
      throws IOException 
      {
        final URLConnection urlConnection = new URL(getDataURL).openConnection();
        final int size = urlConnection.getContentLength();
        System.err.println(">>>> content length: " + size);
        final byte[] buffer = new byte[size];
        final DataInputStream is = new DataInputStream(new BufferedInputStream(urlConnection.getInputStream()));
        is.readFully(buffer);
        is.close();
        return buffer;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public String retrieveStampCode ()
      {
        try
          {
            final URLConnection urlConnection = new URL(getStampURL).openConnection();
            final BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            final String s = br.readLine();
            br.close();

            return s;
          }
        catch (IOException e)
          {
            e.printStackTrace();
          }

        return "ERROR";
      }
  }