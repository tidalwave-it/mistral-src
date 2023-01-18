/*
 * *********************************************************************************************************************
 *
 * Mistral: open source imaging engine
 * http://tidalwave.it/projects/mistral
 *
 * Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
 *
 * *********************************************************************************************************************
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
 * *********************************************************************************************************************
 *
 * git clone https://bitbucket.org/tidalwave/mistral-src
 * git clone https://github.com/tidalwave-it/mistral-src
 *
 * *********************************************************************************************************************
 */
package it.tidalwave.mistral.example.histogramviewer;

import java.security.AccessControlException;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;
import it.tidalwave.image.op.HistogramOp;
import it.tidalwave.image.util.Platform;
import it.tidalwave.mistral.example.AbstractViewerPanel;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class Main
  {
    private static boolean jai = false;

    public static void main (final String[] args)
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

        final var statusBar = new JLabel(" ", SwingConstants.LEFT);
        statusBar.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        final var frame = new JFrame("Mistral Histogram Viewer example");
        final var p = new JPanel(new BorderLayout());
        p.add(statusBar, BorderLayout.SOUTH);
        frame.getContentPane().add(p);

        final var histogramRenderer = new HistogramRenderer();
        histogramRenderer.setBounds(20, 20, 200, 150);
        final var panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.add(histogramRenderer);
        frame.setGlassPane(panel);
        panel.setVisible(true);
        histogramRenderer.setBackground(new Color(0, 0, 0, 128));
        histogramRenderer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        histogramRenderer.showComputing();
        histogramRenderer.setVisible(true);

        final var viewerPanel = new AbstractViewerPanel()
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
                final var thread = new Thread(() ->
                   {
                     histogramRenderer.start();
                   var time = System.currentTimeMillis();
                     final var histogram = image.executeInPlace(new HistogramOp()).getHistogram();
                     time = System.currentTimeMillis() - time;
                     histogramRenderer.setHistogram(histogram);
                     statusBar.setText("Computed in " + time + " msec " + (jai ? "with" : "without") + " JAI");
                   });

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
            ImplementationFactoryJ2D.getDefault().unregisterImplementation(HistogramOp.class);
            jai = true;
          }
        catch (Throwable e)
          {
            System.err.println("JAI is not available");
          }
      }
  }
