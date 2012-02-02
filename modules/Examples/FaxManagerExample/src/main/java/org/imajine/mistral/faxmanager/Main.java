/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2012 by Tidalwave s.a.s.
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
/*
 * Main.java
 *
 * Created on November 10, 2006, 9:00 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.imajine.mistral.faxmanager;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author fritz
 */
public class Main
  {
    /** Creates a new instance of Main */
    public Main()
      {
      }
    
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) 
      throws IOException
      {
        JFrame frame = new JFrame();
        FaxApplet applet = new FaxApplet();
        applet.init();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(applet);
        frame.setSize(800, 600);
        frame.setVisible(true);
        applet.start();
      }
  }
