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
 * $Id: FaxManager.java 530 2007-03-29 23:02:03Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.mistral.faxserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: FaxManager.java 530 2007-03-29 23:02:03Z fabriziogiudici $
 *
 ******************************************************************************/
public class FaxManager
  {
    public static class Fax
      {
        private final String name;
        private final String pages;

        public Fax (final String name, final String pages)
          {
            this.name = name;
            this.pages = pages;
          }

        public String getName ()
          {
            return name;
          }

        public String getPages ()
          {
            return pages;
          }
      }

    public final File inputFolder = new File(System.getProperty("java.io.tmpdir") + "/input");
    public final File outputFolder = new File(System.getProperty("java.io.tmpdir") + "/output");
    public static FaxManager instance;

    public static synchronized FaxManager getInstance ()
      {
        if (instance == null)
          {
            instance = new FaxManager();
          }

        return instance;
      }

    public InputStream getInputStream (final String faxName)
        throws FileNotFoundException
      {
        return new FileInputStream(new File(inputFolder, faxName));
      }

    public OutputStream getOutputStream (final String faxName)
        throws FileNotFoundException
      {
        return new FileOutputStream(new File(outputFolder, faxName));
      }

    public Fax[] getFaxes ()
      {
        final String[] files = inputFolder.list();
        final Fax[] faxes = new Fax[files.length];

        for (int i = 0; i < faxes.length; i++)
          {
            String pages = "1"; // for all faxes we see only page 1

            if (files[i].equals("fax000008945.tif"))
              {
                pages = "2,3"; // for this fax we see pages 2,3
              }

            faxes[i] = new Fax(files[i], pages);
          }

        return faxes;
      }
  }
