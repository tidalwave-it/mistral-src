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
package it.tidalwave.mistral.example.histogramviewer;

import java.io.IOException;
import java.security.AccessControlException;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Histogram;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;
import it.tidalwave.image.op.HistogramOp;
import it.tidalwave.image.util.Platform;
import it.tidalwave.mistral.example.AbstractViewerPanel;
import org.openide.util.Lookup;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class Main 
  {
    private static boolean jai = false;
    
    public static void main (String [] args)
      throws IOException
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
        
        final JLabel statusBar = new JLabel(" ", SwingConstants.LEFT);
        statusBar.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        final JFrame frame = new JFrame("Mistral Histogram Viewer example");
        final JPanel p = new JPanel(new BorderLayout());
        p.add(statusBar, BorderLayout.SOUTH);
        frame.getContentPane().add(p);
        
        final HistogramRenderer histogramRenderer = new HistogramRenderer();
        histogramRenderer.setBounds(20, 20, 200, 150);
        final JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.add(histogramRenderer);
        frame.setGlassPane(panel);
        panel.setVisible(true);
        histogramRenderer.setBackground(new Color(0, 0, 0, 128));
        histogramRenderer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        histogramRenderer.showComputing();
        histogramRenderer.setVisible(true);
        
        final AbstractViewerPanel viewerPanel = new AbstractViewerPanel()
          {
            {
              setLayout(new BorderLayout());
              add(imageRenderer, BorderLayout.CENTER);
            }
            
            @Override
            protected void onImageLoaded (final EditableImage image)
              {
                imageRenderer.setFitToDisplaySize(true);
                //
                // HistogramOp can take some time to perform.
                //
                Thread thread = new Thread()
                  {
                    @Override
                    public void run()
                      {
                        histogramRenderer.start();
                        long time = System.currentTimeMillis();
                        Histogram histogram = image.execute(new HistogramOp()).getHistogram();
                        time = System.currentTimeMillis() - time;
                        histogramRenderer.setHistogram(histogram);
                        statusBar.setText("Computed in " + time + " msec " + (jai ? "with" : "without") + " JAI");
                      }
                  };

                thread.start();
              }
          };
          
        p.add(viewerPanel, BorderLayout.CENTER);
        viewerPanel.loadImage("20040103-0080.jpg");

        frame.setSize(800, 554);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //
        // Try to activate the JAI provider - if you manage, disable the Java2D
        // implementation of HistogramOp.
        //
        try 
          {
            Class.forName("it.tidalwave.image.jai.ImplementationFactoryJAI");
            Lookup.getDefault().lookup(ImplementationFactoryJ2D.class).unregisterImplementation(HistogramOp.class);
            jai = true;
          } 
        catch (Throwable e) 
          {
            System.err.println("JAI is not available");
          }
      }
  }
