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
package it.tidalwave.mistral.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.ReadOp;
import it.tidalwave.image.render.EditableImageRenderer;
import it.tidalwave.image.render.Overlay;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class AbstractViewerPanel extends JPanel
  {
    protected final EditableImageRenderer imageRenderer = new EditableImageRenderer();

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void loadImage (final String fileName)
            throws MalformedURLException
      {
        try // used during development
          {
            final File file = new File("../../../www/images/" + fileName);

            if (file.exists() && file.canRead())
              {
                loadImage(file);
              }

            else
              {
                throw new FileNotFoundException(file.toString());
              }
          }
        catch (Exception e)
          {
            // used by the deployed examples
            loadImage(new URL("https://mistral.dev.java.net/images/" + fileName));
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected void loadImage (final Object input)
      {
        final JLabel label = new JLabel("Loading " + input + "...");
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("sansserif", Font.BOLD, 14));

        final Overlay overlay = new Overlay()
          {
            @Override
            public boolean isVisible()
              {
                return true;
              }

            @Override
            public void paint (final Graphics2D g, final EditableImageRenderer imageRenderer)
              {
                label.setBounds(imageRenderer.getBounds());
                label.paint(g);
              }
          };

//        final OverlaidPanel overlay = new OverlaidPanel();
//        overlay.setLayout(new BorderLayout());
//        overlay.add(label, BorderLayout.CENTER);

        imageRenderer.addOverlay(overlay);
        imageRenderer.repaint(); // FIXME: should not be needed

        // A SwingWorker would be good here
        final Thread loaderThread = new Thread(() ->
          {
            try
              {
                final EditableImage image = EditableImage.create(new ReadOp(input));

                SwingUtilities.invokeLater(() ->
                  {
                    imageRenderer.setImage(image);
                    imageRenderer.removeOverlay(overlay);
                    final int hMargin = image.getWidth() / 4;
                    final int vMargin = image.getHeight() / 4;
                    imageRenderer.setMargin(new Insets(vMargin, hMargin, vMargin, hMargin));
                    onImageLoaded(image);
                  });
              }
            catch (final Throwable e)
              {
                SwingUtilities.invokeLater(() ->
                  {
                    label.setText(e.toString());
                    imageRenderer.repaint(); // FIXME: should not be needed
                    //                            imageRenderer.removeOverlay(overlay);
                    e.printStackTrace();
                    final String message =
                    "<html>Cannot load the image.<br>An Internet connection is required.</html>";
                    final String title = "Error";
                    JOptionPane.showMessageDialog(AbstractViewerPanel.this,
                                    message,
                                    title,
                                    JOptionPane.ERROR_MESSAGE);
                  });
              }
          });

        loaderThread.start();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected void onImageLoaded (final EditableImage image)
      {
      }
  }
