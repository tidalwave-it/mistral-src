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
 * $Id: ViewerApplet.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.mistral.example.viewer;

import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JApplet;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ViewerApplet.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class ViewerApplet extends JApplet 
  {
    public void init() 
      {
        try 
          {
            EventQueue.invokeAndWait(new Runnable() 
              {
                public void run() 
                  {
                    try 
                      {
                        setLayout(new BorderLayout());
                        add(new ViewerPanel(), BorderLayout.CENTER);
                      } 
                    catch (IOException ex) 
                      {
                        ex.printStackTrace();
                      }
                  }
              });
          } 
        catch (Exception e) 
          {
            e.printStackTrace();
          }
      }
  }