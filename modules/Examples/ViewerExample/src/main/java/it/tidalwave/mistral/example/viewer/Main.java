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
package it.tidalwave.mistral.example.viewer;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.LogManager;
import java.security.AccessControlException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import it.tidalwave.image.util.Platform;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class Main
  {
    private static final Dimension WINDOW_SIZE = new Dimension(800, 600);
    
    public static void main (String[] args)
        throws Exception
      {
        configureLogging();
        createMainWindow();
      }

    private static void configureLogging ()
      {
        try
          {
            InputStream is = Main.class.getResourceAsStream("log.properties");
            LogManager.getLogManager().readConfiguration(is);
            is.close();
            new File("target/logs").mkdirs();
          }
        catch (SecurityException e)
          {
            e.printStackTrace();
          }
        catch (IOException e)
          {
            e.printStackTrace();
          }
      }

    private static void createMainWindow ()
        throws InvocationTargetException, HeadlessException, InterruptedException, IOException
      {
        if (!Platform.isMacOSX())
          {
            try 
              {
                System.setProperty("swing.aatext", "true");  
              } 
            catch (AccessControlException e)
              {
                System.err.println("Can't set anti-aliased text because of: " + e);
              }   
          }
        
        final ViewerPanel viewerPanel = new ViewerPanel();
        SwingUtilities.invokeAndWait(new Runnable()
              {
            @Override
                public void run ()
                  {
                    JFrame frame = new JFrame("Mistral Viewer example");
                    frame.getContentPane().add(viewerPanel);
                    frame.setSize(WINDOW_SIZE);

                    final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    frame.setLocation((screenSize.width - frame.getWidth()) / 2,
                        (screenSize.height - frame.getHeight()) / 2);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                  }
              });
      }
  }
