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
package it.tidalwave.mistral.example.viewer;

import java.text.MessageFormat;
import java.io.IOException;
import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.metadata.Directory;
import it.tidalwave.image.metadata.EXIF;
import it.tidalwave.image.metadata.MakerNote;
import it.tidalwave.image.render.AnimatedScaleController;
import it.tidalwave.image.render.DragPanningController;
import it.tidalwave.image.render.MouseClickZoomingController;
import it.tidalwave.image.render.MouseWheelZoomingController;
import it.tidalwave.image.render.RotationController;
import it.tidalwave.image.render.ScaleController;
import it.tidalwave.image.render.event.EditableImageRendererAdapter;
import it.tidalwave.image.render.event.EditableImageRendererEvent;
import it.tidalwave.image.render.event.EditableImageRendererListener;
import it.tidalwave.mistral.example.AbstractViewerPanel;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class ViewerPanel extends AbstractViewerPanel
  {
    private static final DefaultComboBoxModel QUALITY_MODEL = new DefaultComboBoxModel()
      {{
        addElement(Quality.FASTEST);
        addElement(Quality.INTERMEDIATE);
        addElement(Quality.BEST);
      }};

    private final ScaleController scaleController = new AnimatedScaleController(imageRenderer);

    private final RotationController rotationController = new RotationController(imageRenderer);

    private final MouseClickZoomingController mouseClickZoomingController =
            new MouseClickZoomingController(scaleController);

    /**
     * The zooming controller that runs with the mouse wheel.
     */
    private final MouseWheelZoomingController mouseWheelZoomingController =
            new MouseWheelZoomingController(scaleController);

    private final DragPanningController panningController = new DragPanningController(imageRenderer);

    private final CropOverlay cropOverlay = new CropOverlay();

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private final EditableImageRendererListener scaleListener = new EditableImageRendererAdapter()
      {
        private static final String PHOTO_SIZE_PATTERN = "{0,number,#####}x{1,number,#####}x{2,number,##}";

        private static final String SCALE_PATTERN = "{0,number,percent}";

        @Override
        public void scaleChanged (final EditableImageRendererEvent event)
          {
            final var image = imageRenderer.getImage();
            final var width = image.getWidth();
            final var height = image.getHeight();
            final var depth = image.getBitsPerPixel();
            lbSize.setText(MessageFormat.format(PHOTO_SIZE_PATTERN, width, height, depth));
            lbScaleValue.setText(MessageFormat.format(SCALE_PATTERN, imageRenderer.getScale()));
          }

        @Override
        public void angleChanged (final EditableImageRendererEvent event)
          {
            lbAngleValue.setText("" + imageRenderer.getAngle());
          }
      };

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public ViewerPanel()
            throws IOException
      {
        initComponents();
        cbQuality.setModel(QUALITY_MODEL);
        cbQuality.setSelectedItem(Quality.INTERMEDIATE);
        imageRenderer.setOptimizedImageEnabled(true);
        imageRenderer.addImageRendererListener(scaleListener);
//        imageRenderer.setScaledImageCachingEnabled(true); FIXME - doesn't work
        pnViewer.setLayout(new BorderLayout());
        pnViewer.add(imageRenderer, BorderLayout.CENTER);
        mouseClickZoomingController.setClickCountToZoom(2);
        mouseClickZoomingController.setEnabled(true);
        mouseWheelZoomingController.setEnabled(true);
        panningController.setEnabled(true);
        imageRenderer.addOverlay(cropOverlay);
        loadImage("20030701-0043.jpg");
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    protected void onImageLoaded (final EditableImage image)
      {
        final Directory exifDirectory = image.getMetadata(EXIF.class).get();
        final Directory makerNoteDirectory = image.getMetadata(MakerNote.class).get();
        final var exif = createTable(exifDirectory);
        final var makerNote = createTable(makerNoteDirectory);
        lbMetadata.setText(exif);
        scaleController.fitToView();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private String createTable (final Directory directory)
      {
        final var sb = new StringBuilder();
        sb.append("<html>");

        if (directory != null)
          {
            sb.append("<table>");

            for (final var code : directory.getTagCodes())
              {
                final var tagName = directory.getTagInfo(code).get().getName();
                final var tagValue = directory.getRaw(code);
                sb.append("<tr><td>");
                sb.append(Integer.toString(code));
                sb.append("</td><td>");
                sb.append(tagName);
                sb.append("</td><td>");
                sb.append(tagValue);
                sb.append("</td></tr>");
              }

            sb.append("</table>");
          }

        sb.append("</html>");
        return sb.toString();
      }

    /*******************************************************************************************************************
     *
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     *
     ******************************************************************************************************************/
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
      {

        pnStatusBar = new javax.swing.JPanel();
        lbScale = new javax.swing.JLabel();
        lbScaleValue = new javax.swing.JLabel();
        lbSize = new javax.swing.JLabel();
        lbAngle = new javax.swing.JLabel();
        lbAngleValue = new javax.swing.JLabel();
        pnViewer = new javax.swing.JPanel();
        spMetadata = new javax.swing.JScrollPane();
        lbMetadata = new javax.swing.JLabel();
        pnToolBar = new javax.swing.JPanel();
        btZoomIn = new javax.swing.JButton();
        btActualPixels = new javax.swing.JButton();
        btZoomOut = new javax.swing.JButton();
        btFitToWindow = new javax.swing.JButton();
        slRotation = new javax.swing.JSlider();
        cbCrop = new javax.swing.JCheckBox();
        btResetRotation = new javax.swing.JButton();
        lbQuality = new javax.swing.JLabel();
        cbQuality = new javax.swing.JComboBox();
        cbScrollBars = new javax.swing.JCheckBox();

        pnStatusBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

        lbScale.setText("Scale:");

        lbScaleValue.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbScaleValue.setText("0%");

        lbSize.setText(" ");

        lbAngle.setText("Angle:");

        lbAngleValue.setText("0");

        final var pnStatusBarLayout = new org.jdesktop.layout.GroupLayout(pnStatusBar);
        pnStatusBar.setLayout(pnStatusBarLayout);
        pnStatusBarLayout.setHorizontalGroup(
                pnStatusBarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                 .add(pnStatusBarLayout.createSequentialGroup()
                                                       .add(lbSize,
                                                            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                            181,
                                                            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                       .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                       .add(lbScale)
                                                       .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                       .add(lbScaleValue,
                                                            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                            54,
                                                            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                       .add(24, 24, 24)
                                                       .add(lbAngle)
                                                       .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                       .add(lbAngleValue)
                                                       .addContainerGap(460, Short.MAX_VALUE))
        );
        pnStatusBarLayout.setVerticalGroup(
                pnStatusBarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                 .add(pnStatusBarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                       .add(lbScale)
                                                       .add(lbSize)
                                                       .add(lbScaleValue)
                                                       .add(lbAngleValue)
                                                       .add(lbAngle))
        );

        final var pnViewerLayout = new org.jdesktop.layout.GroupLayout(pnViewer);
        pnViewer.setLayout(pnViewerLayout);
        pnViewerLayout.setHorizontalGroup(
                pnViewerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                              .add(0, 631, Short.MAX_VALUE)
        );
        pnViewerLayout.setVerticalGroup(
                pnViewerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                              .add(0, 308, Short.MAX_VALUE)
        );

        spMetadata.setMinimumSize(new java.awt.Dimension(200, 8));

        lbMetadata.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        lbMetadata.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        spMetadata.setViewportView(lbMetadata);

        pnToolBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

        btZoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/it/tidalwave/mistral/example/viewer/icons/viewmag+.png"))); // NOI18N
        btZoomIn.addActionListener(this::btZoomInActionPerformed);

        btActualPixels.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/it/tidalwave/mistral/example/viewer/icons/viewmag1.png"))); // NOI18N
        btActualPixels.addActionListener(this::btActualPixelsActionPerformed);

        btZoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/it/tidalwave/mistral/example/viewer/icons/viewmag-.png"))); // NOI18N
        btZoomOut.addActionListener(this::btZoomOutActionPerformed);

        btFitToWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/it/tidalwave/mistral/example/viewer/icons/viewmagfit.png"))); // NOI18N
        btFitToWindow.addActionListener(this::btFitToWindowActionPerformed);

        slRotation.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        slRotation.setMajorTickSpacing(90);
        slRotation.setMaximum(180);
        slRotation.setMinimum(-180);
        slRotation.setMinorTickSpacing(10);
        slRotation.setPaintTicks(true);
        slRotation.addChangeListener(this::slRotationStateChanged);

        cbCrop.setText("Crop");
        cbCrop.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cbCrop.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cbCrop.addChangeListener(this::cbCropStateChanged);

        btResetRotation.setText("Level");
        btResetRotation.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btResetRotation.addActionListener(this::btResetRotationActionPerformed);

        lbQuality.setText("Quality:");

        cbQuality.addActionListener(this::cbQualityActionPerformed);

        cbScrollBars.setText("Scroll bars");
        cbScrollBars.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cbScrollBars.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cbScrollBars.addActionListener(this::cbScrollBarsActionPerformed);

        final var pnToolBarLayout = new org.jdesktop.layout.GroupLayout(pnToolBar);
        pnToolBar.setLayout(pnToolBarLayout);
        pnToolBarLayout.setHorizontalGroup(
                pnToolBarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                               .add(pnToolBarLayout.createSequentialGroup()
                                                   .add(btZoomIn)
                                                   .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                   .add(btZoomOut)
                                                   .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                   .add(btFitToWindow)
                                                   .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                   .add(btActualPixels)
                                                   .add(10, 10, 10)
                                                   .add(cbScrollBars)
                                                   .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                   .add(slRotation,
                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                        143,
                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                   .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                   .add(btResetRotation)
                                                   .add(18, 18, 18)
                                                   .add(lbQuality)
                                                   .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                   .add(cbQuality,
                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                        145,
                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                   .add(11, 11, 11)
                                                   .add(cbCrop)
                                                   .addContainerGap(144, Short.MAX_VALUE))
        );
        pnToolBarLayout.setVerticalGroup(
                pnToolBarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                               .add(pnToolBarLayout.createSequentialGroup()
                                                   .add(pnToolBarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                       .add(pnToolBarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                                                           .add(btZoomIn,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                                                21,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                                           .add(btZoomOut,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                                                21,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                                           .add(btFitToWindow,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                                                21,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                                           .add(btActualPixels,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                                                21,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                                           .add(cbScrollBars))
                                                                       .add(slRotation,
                                                                            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                            21,
                                                                            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                       .add(pnToolBarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                                                           .add(btResetRotation,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                                                21,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                                           .add(cbQuality,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                                           .add(cbCrop)
                                                                                           .add(lbQuality)))
                                                   .addContainerGap())
        );

        final var layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                      .add(pnStatusBar,
                           org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                           org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                           Short.MAX_VALUE)
                      .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                                           .add(pnViewer,
                                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                           .add(4, 4, 4)
                                                                           .add(spMetadata,
                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                                200,
                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                      .add(org.jdesktop.layout.GroupLayout.TRAILING,
                           pnToolBar,
                           org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                           org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                           Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                      .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                                           .add(pnToolBar,
                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                           .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                           .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                                                      .add(pnViewer,
                                                                                           org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                                           org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                                           Short.MAX_VALUE)
                                                                                      .add(spMetadata,
                                                                                           org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                                           308,
                                                                                           Short.MAX_VALUE))
                                                                           .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                           .add(pnStatusBar,
                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
      }// </editor-fold>//GEN-END:initComponents

    private void cbScrollBarsActionPerformed (final java.awt.event.ActionEvent evt)
      {//GEN-FIRST:event_cbScrollBarsActionPerformed
        imageRenderer.setScrollBarsVisible(cbScrollBars.isSelected());
      }//GEN-LAST:event_cbScrollBarsActionPerformed

    private void cbQualityActionPerformed (final java.awt.event.ActionEvent evt)
      {//GEN-FIRST:event_cbQualityActionPerformed
        final var quality = (Quality)cbQuality.getSelectedItem();
        imageRenderer.setScaleQuality(quality);
        imageRenderer.setRotateQuality(quality);
        repaint();
      }//GEN-LAST:event_cbQualityActionPerformed

    private void btResetRotationActionPerformed (final java.awt.event.ActionEvent evt)
      {//GEN-FIRST:event_btResetRotationActionPerformed
        slRotation.setValue(0);
      }//GEN-LAST:event_btResetRotationActionPerformed

    private void cbCropStateChanged (final javax.swing.event.ChangeEvent evt)
      {//GEN-FIRST:event_cbCropStateChanged
        cropOverlay.setVisible(cbCrop.isSelected());
        imageRenderer.repaint();
      }//GEN-LAST:event_cbCropStateChanged

    private void slRotationStateChanged (final javax.swing.event.ChangeEvent evt)
      {//GEN-FIRST:event_slRotationStateChanged
        rotationController.setAngle(slRotation.getValue());
      }//GEN-LAST:event_slRotationStateChanged

    private void btFitToWindowActionPerformed (final java.awt.event.ActionEvent event)//GEN-FIRST:event_btFitToWindowActionPerformed
    {//GEN-HEADEREND:event_btFitToWindowActionPerformed
      scaleController.fitToView();
    }//GEN-LAST:event_btFitToWindowActionPerformed

    private void btActualPixelsActionPerformed (final java.awt.event.ActionEvent event)//GEN-FIRST:event_btActualPixelsActionPerformed
    {//GEN-HEADEREND:event_btActualPixelsActionPerformed
      scaleController.showActualPixels();
    }//GEN-LAST:event_btActualPixelsActionPerformed

    private void btZoomOutActionPerformed (final java.awt.event.ActionEvent event)//GEN-FIRST:event_btZoomOutActionPerformed
    {//GEN-HEADEREND:event_btZoomOutActionPerformed
      scaleController.zoomOut();
    }//GEN-LAST:event_btZoomOutActionPerformed

    private void btZoomInActionPerformed (final java.awt.event.ActionEvent event)//GEN-FIRST:event_btZoomInActionPerformed
    {//GEN-HEADEREND:event_btZoomInActionPerformed
      scaleController.zoomIn();
    }//GEN-LAST:event_btZoomInActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualPixels;
    private javax.swing.JButton btFitToWindow;
    private javax.swing.JButton btResetRotation;
    private javax.swing.JButton btZoomIn;
    private javax.swing.JButton btZoomOut;
    private javax.swing.JCheckBox cbCrop;
    private javax.swing.JComboBox cbQuality;
    private javax.swing.JCheckBox cbScrollBars;
    private javax.swing.JLabel lbAngle;
    private javax.swing.JLabel lbAngleValue;
    private javax.swing.JLabel lbMetadata;
    private javax.swing.JLabel lbQuality;
    private javax.swing.JLabel lbScale;
    private javax.swing.JLabel lbScaleValue;
    private javax.swing.JLabel lbSize;
    private javax.swing.JPanel pnStatusBar;
    private javax.swing.JPanel pnToolBar;
    private javax.swing.JPanel pnViewer;
    private javax.swing.JSlider slRotation;
    private javax.swing.JScrollPane spMetadata;
    // End of variables declaration//GEN-END:variables
  }
