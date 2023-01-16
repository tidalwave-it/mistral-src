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
package it.tidalwave.image.render;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.OptimizeOp;
import it.tidalwave.image.op.PaintOp;
import it.tidalwave.image.op.RotateOp;
import it.tidalwave.image.op.ScaleOp;
import it.tidalwave.image.render.event.EditableImageRendererEvent;
import it.tidalwave.image.render.event.EditableImageRendererListener;
import it.tidalwave.image.util.Platform;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * This class is a pipe which adds to SimpleEditableImageRenderer scrolling
 * capabilities and a fit-to-size feature.
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class EditableImageRenderer extends JComponent
  {
    /**
     * The maximum allowed value for scale.
     */
    public static final double MAX_SCALE = 40;

    /**
     * The maximum allowed value for scale.
     */
    public static final double MIN_SCALE = 0.01;

    /**
     * Over this image size the scaled image caching is always disabled.
     */
    private static final int MAX_SIZE_FOR_SCALED_CACHING = 8000;

    /**
     * The default background color for parts not covered by the image.
     */
    private static final Color DEFAULT_BACKGROUND = Color.DARK_GRAY;

    /**
     * An empty margin.
     */
    private static final Insets NULL_MARGIN = new Insets(0, 0, 0, 0);

    /**
     * The original image to be displayed.
     */
    protected EditableImage image;

    /**
     * A display-optimized copy of the image. If optimizedImageEnabled is false, it just references the original image.
     */
    private EditableImage optimizedImage;

    /**
     * A scaled-down version of the image to fit the actual rendering settings.
     */
    private EditableImage scaledImage;

    /**
     * True if a local optimized copy of the image should be used.
     */
    private boolean optimizedImageEnabled;

    /**
     * True if use a scaled local copy of the image for faster rendering.
     */
    private boolean scaledImageCachingEnabled;

    /**
     * The current scale.
     */
    protected double scale = 1;

    private double minScale = MIN_SCALE;

    private double maxScale = MAX_SCALE;

    /**
     * The current rotation.
     */
    protected double angle = 0;

    /**
     * The image coordinates of the pixel shown in the top left corner of the component.
     */
    private Point origin = new Point(0, 0);

    /**
     * The current preview settings.
     */
    private PreviewSettings previewSettings;

    /**
     * The coordinates of the photo origin relative to the component location.
     */
    private int shownImageX;

    /**
     * The coordinates of the photo origin relative to the component location.
     */
    private int shownImageY;

    /**
     * The scaled photo dimension in pixels.
     */
    private int shownImageWidth;

    /**
     * The scaled photo dimension in pixels.
     */
    private int shownImageHeight;

    /**
     * The maximum margin that can be shown around the image.
     */
    private Insets margin = new Insets(0, 0, 0, 0);

    /**
     * If not null, the image rendering will be clipped against this shape.
     */
    private Shape clippingShape;

    /**
     * The quality used for scale.
     */
    private Quality scaleQuality = Quality.INTERMEDIATE;

    /**
     * The quality used for rotate.
     */
    private Quality rotateQuality = Quality.INTERMEDIATE;

    /**
     * Overlays will be drawn over the image.
     */
    private final List<Overlay> overlayList = new ArrayList<>();

    /**
     * If true, the image always fits the component size.
     */
    private boolean fitToDisplaySize;

    /**
     * The list of listeners.
     */
    private final List<EditableImageRendererListener> listenerList = new ArrayList<>();

    /**
     * True if repaint is currently enabled.
     */
    private boolean repaintEnabled = true;

    /**
     * The current EditingTool.
     */
    protected EditingTool editingTool;

    /**
     * The vertical scrollbar.
     */
    private final JScrollBar horizontalScrollBar = new JScrollBar(JScrollBar.HORIZONTAL);

    /**
     * The horizontal scrollbar.
     */
    private final JScrollBar verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL);

    private final JPanel filler = new JPanel();

    /**
     * True if scrollbars should be visible.
     */
    private boolean scrollBarsVisible = false;

    /**
     * A border to be rendered around the image.
     */
    private Border imageBorder;

    /**
     * Width of the renderer before the latest resize, used to layout scrollbars.
     */
    private int previousWidth;

    /**
     * Height of the renderer before the latest resize, used to layout scrollbars.
     */
    private int previohsHeight;

    /**
     * The thickness of scrollbars.
     */
    private int scrollbarThickness = 16;

    /*******************************************************************************************************************
     *
     * The scrollbar listener. 
     *
     ******************************************************************************************************************/
    private final AdjustmentListener scrollbarListener =
            event -> setOrigin(new Point(horizontalScrollBar.getValue(), verticalScrollBar.getValue()));

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public EditableImageRenderer()
      {
        setBackground(DEFAULT_BACKGROUND);
        setLayout(null);
        setOpaque(false);

        final boolean workaroundMST63 = !Platform.isMacOSX();

        if (workaroundMST63)
          {
            log.warn("Enabled workaround for MST-63");
          }

        setScaledImageCachingEnabled(workaroundMST63);
        setOptimizedImageEnabled(workaroundMST63);

        add(horizontalScrollBar);
        add(verticalScrollBar);
        add(filler);
        horizontalScrollBar.addAdjustmentListener(scrollbarListener);
        verticalScrollBar.addAdjustmentListener(scrollbarListener);
        horizontalScrollBar.setVisible(scrollBarsVisible);
        verticalScrollBar.setVisible(scrollBarsVisible);
        filler.setVisible(scrollBarsVisible);
      }

    /*******************************************************************************************************************
     *
     * Sets the image to display. The image is internally cloned, so any further
     * operation performed on the same source (that could cause a model switch) won't
     * affect the rendering.
     *
     * @param  image  the image
     *
     ******************************************************************************************************************/
    public void setImage (final EditableImage image)
      {
        log.info("setImage(" + image + ")");

        if (image == null)
          {
            this.image = null;
            log.warn("setImage(null)");
          }

        else
          {
            this.image = image; // image.cloneImage();
          }

        if (editingTool != null)
          {
            editingTool.imageChanged();
          }

        flushAllCaches();
        updateScrollBars();

        if (fitToDisplaySize)
          {
            fitToDisplaySize();
          }
        else
          {
            repaint();
          }
      }

    /*******************************************************************************************************************
     *
     * Returns the displayed image.
     *
     * @return the image
     *
     ******************************************************************************************************************/
    public EditableImage getImage()
      {
        return image;
      }

    /*******************************************************************************************************************
     *
     * Returns a possibly optimized version of the image. If useOptimizedImage is
     * false, this method returns the original image.
     *
     * @return the image
     *
     ******************************************************************************************************************/

    // useful for the loupe, to prevent it from recomputing the optimized version
    public EditableImage getOptimizedImage()
      {
        return optimizedImage;
      }

    /*******************************************************************************************************************
     *
     * Turns on/off repaint. It's advisable to turn repainting off before a sequence
     * of operations, and turning it on again only at the end of the sequence.
     *
     * @param  repaintEnabled  the new setting
     *
     ******************************************************************************************************************/
    public void setRepaintEnabled (final boolean repaintEnabled)
      {
        log.info("setRepaintEnabled(" + repaintEnabled + ")");
        this.repaintEnabled = repaintEnabled;
      }

    /*******************************************************************************************************************
     *
     * Returns the state of repaint.
     *
     * @return the repaint state
     *
     ******************************************************************************************************************/
    public boolean isRepaintEnabled()
      {
        return repaintEnabled;
      }

    /*******************************************************************************************************************
     *
     * Sets the image point which is displayed in the top left corner (coordinates
     * are in actual image pixels).
     *
     * @param    origin  the origin
     *
     ******************************************************************************************************************/
    public void setOrigin (final Point origin)
      {
        log.info("setOrigin(" + origin + ")");

        if ((image != null) && (image.getWidth() > 0) && (image.getHeight() > 0))
          {
            internalSetOrigin(origin);
            updateScrollBars();
            repaint();
          }
      }

    private void internalSetOrigin (final Point origin)
      {
        log.info("internalSetOrigin(" + origin + ")");
        //
        // No margin with the scroll bars.
        //
//        final Insets margin = scrollBarsVisible ? NULL_MARGIN : this.margin;
        //
        // The size of the largest image displayable with no clipping at the current zoom.
        //
        final int maxWidth = (int)Math.round(getAvailableWidth() / scale);
        final int maxHeight = (int)Math.round(getAvailableHeight() / scale);

        //
        // The size of the image including the margin.
        //
        final int widthWithMargin = image.getWidth() + margin.left + margin.right;
        final int heightWithMargin = image.getHeight() + margin.top + margin.bottom;

        //
        // The bounds for the origin to keep the margin within its bounds.
        //
        final int xMin = -margin.left;
        final int yMin = -margin.top;
        final int xMax = (image.getWidth() + margin.right) - maxWidth;
        final int yMax = (image.getHeight() + margin.bottom) - maxHeight;
        //
        // If there's more room to display the image with its margin, center it.
        //
        this.origin.x = (maxWidth <= widthWithMargin)
                        ? Math.min(Math.max(xMin, origin.x), xMax)
                        : (-(maxWidth - image.getWidth()) / 2);
        this.origin.y = (maxHeight <= heightWithMargin)
                        ? Math.min(Math.max(yMin, origin.y), yMax)
                        : (-(maxHeight - image.getHeight()) / 2);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public Point getOrigin()
      {
        return origin;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public double getScale()
      {
        return scale;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setAngle (final double angle)
      {
        log.info("setAngle(" + angle + ")");

        if (this.angle != angle)
          {
            this.angle = angle;
            flushScaledImageCache();
            repaint();
            fireAngleChangedEvent();
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public double getAngle()
      {
        return angle;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public EditingTool getEditingTool()
      {
        return editingTool;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setImageBorder (final Border imageBorder)
      {
        this.imageBorder = imageBorder;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public Border getImageBorder()
      {
        return imageBorder;
      }

    /*******************************************************************************************************************
     *
     * Given a point in component coordinates, returns the coordinates of the
     * image pixel rendered at that point. If the point is outside of the image
     * rendering areas, returns null.
     *
     * @param  componentPoint  the point in relative coordinates
     * @return the image pixel coordinates (null if none)
     *
     ******************************************************************************************************************/
    public Point getPositionOverImage (final Point componentPoint)
      {
        if (image == null)
          {
            return null;
          }

        final int imageWidth = image.getWidth();
        final int imageHeight = image.getHeight();

        if ((imageWidth == 0) || (imageHeight == 0)) // can happen if metadata is not loaded yet
          {
            return null;
          }

        if ((shownImageWidth == 0) || (shownImageHeight == 0))
          {
            log.error("Image size: " + shownImageHeight + " x " + shownImageHeight);
            return null;
          }

        final int x = ((componentPoint.x - shownImageX) * imageWidth) / shownImageWidth;
        final int y = ((componentPoint.y - shownImageY) * imageHeight) / shownImageHeight;

        if ((x >= 0) && (y >= 0) && (x < imageWidth) && (y < imageHeight))
          {
            return new Point(x, y);
          }

        else
          {
            return null;
          }
      }

    /*******************************************************************************************************************
     *
     * Given a point in image coordinates, returns the coordinates of the
     * component point which renders that image point.
     *
     * @param  imagePoint  the point in image coordinates
     * @return the point coordinates
     *
     ******************************************************************************************************************/
    public Point convertImagePointToComponentPoint (final Point imagePoint)
      {
        if (image == null)
          {
            return null;
          }

        final int imageWidth = image.getWidth();
        final int imageHeight = image.getHeight();

        if ((imageWidth == 0) || (imageHeight == 0)) // can happen if metadata is not loaded yet
          {
            return null;
          }

        if ((shownImageWidth == 0) || (shownImageHeight == 0))
          {
            log.error("Image size: " + shownImageHeight + " x " + shownImageHeight);

            return null;
          }

        final int x = ((imagePoint.x * shownImageWidth) / imageWidth) + shownImageX;
        final int y = ((imagePoint.y * shownImageHeight) / imageHeight) + shownImageY;

        return new Point(x, y);

/*        if ((x >= 0) && (y >= 0) && (x < imageWidth) && (y < imageHeight))
          {
            return new Point(x, y);
          }

        else
          {
            return null;
          }*/
      }

    /*******************************************************************************************************************
     *
     * Ensures that the given image pixel is shown at the given component
     * coordinates.
     *
     * @param   imagePoint     the coordinates of the image pixel
     * @param   componentPoint the relative coordinates where to show imagePoint
     *
     ******************************************************************************************************************/
    public void setPositionOverImage (final Point imagePoint, final Point componentPoint)
      {
        log.info("setPositionOverImage(" + imagePoint + ", " + componentPoint + ")");
        final Point newOrigin = computeOrigin(imagePoint, componentPoint, scale);

        if (newOrigin != null)
          {
            setOrigin(newOrigin);
          }
      }

    /*******************************************************************************************************************
     *
     * Sets the maximum margin that can be shown around the image. The number of
     * pixels is in image scale.
     *
     * Please note that the margin is ignored when the scroll bars are visible.
     *
     * @param   margin  the new margin
     *
     ******************************************************************************************************************/
    public void setMargin (final Insets margin)
      {
        log.info("setMargin(" + margin + ")");
        this.margin = (Insets)margin.clone();
      }

    /*******************************************************************************************************************
     *
     * Returns the maximum margin that can be shown around the image.
     *
     * @return the margin
     *
     ******************************************************************************************************************/
    public Insets getMargin()
      {
        return (Insets)margin.clone();
      }

    /*******************************************************************************************************************
     *
     * Sets the scrollbars visible or not.
     *
     * @param  scrollBarsVisible  the new setting
     *
     ******************************************************************************************************************/
    public void setScrollBarsVisible (final boolean scrollBarsVisible)
      {
        log.info("setScrollBarsVisible(" + scrollBarsVisible + ")");

        if (this.scrollBarsVisible != scrollBarsVisible)
          {
            this.scrollBarsVisible = scrollBarsVisible;

            if (scrollBarsVisible)
              {
                previousWidth = previohsHeight = -1;
                updateScrollBars();
              }

            horizontalScrollBar.setVisible(scrollBarsVisible);
            verticalScrollBar.setVisible(scrollBarsVisible);
            filler.setVisible(scrollBarsVisible);
            repaint();
          }
      }

    /*******************************************************************************************************************
     *
     * Return true if the scrollbars are visible.
     *
     * @return true if the scrollbars are visible
     *
     ******************************************************************************************************************/
    public boolean isScrollBarsVisible()
      {
        return scrollBarsVisible;
      }

    /*******************************************************************************************************************
     *
     * Computes a new origin so that the given image point is shown at the given
     * relative coordinates.
     *
     * @param   imagePoint     the coordinates of the image pixel
     * @param   componentPoint the relative coordinates where to show imagePoint
     * @return the new origin
     *
     ******************************************************************************************************************/
    protected Point computeOrigin (final Point imagePoint, final Point componentPoint, final double scale)
      {
        if (image == null)
          {
            return null;
          }

        final int imageWidth = image.getWidth();
        final int imageHeight = image.getHeight();

        if ((imageWidth == 0) || (imageHeight == 0)) // can happen if metadata is not loaded yet
          {
            return null;
          }

        return new Point((int)Math.round(imagePoint.x - (componentPoint.x / scale)),
                         (int)Math.round(imagePoint.y - (componentPoint.y / scale)));
      }

    /*******************************************************************************************************************
     *
     * Sets the quality used for scale operations. This operation doesn't force a
     * <code>repaint()</code>, so it must be explicitly invoked if you want to see
     * immediately the quality change.
     *
     * @param  quality  the quality
     *
     ******************************************************************************************************************/
    public void setScaleQuality (final Quality scaleQuality)
      {
        log.info("setScaleQuality(" + scaleQuality + ")");

        if (this.scaleQuality != scaleQuality)
          {
            this.scaleQuality = scaleQuality;
            flushScaledImageCache();
          }
      }

    /*******************************************************************************************************************
     *
     * Returns the quality used for scale operations.
     *
     * @return the quality
     *
     ******************************************************************************************************************/
    public Quality getScaleQuality()
      {
        return scaleQuality;
      }

    /*******************************************************************************************************************
     *
     * Sets the quality used for rotate operations. This operation doesn't force a
     * <code>repaint()</code>, so it must be explicitly invoked if you want to see
     * immediately the quality change.
     *
     * @param  quality  the quality
     *
     ******************************************************************************************************************/
    public void setRotateQuality (final Quality rotateQuality)
      {
        log.info("setRotateQuality(" + rotateQuality + ")");

        if (this.rotateQuality != rotateQuality)
          {
            this.rotateQuality = rotateQuality;
            flushScaledImageCache();
          }
      }

    /*******************************************************************************************************************
     *
     * Returns the quality used for scale operations.
     *
     * @return the quality
     *
     ******************************************************************************************************************/
    public Quality getRotateQuality()
      {
        return rotateQuality;
      }

    /*******************************************************************************************************************
     *
     * Enables or disables the caching of a scaled image for faster speed.
     *
     * @param  cacheScaleImageEnabled  the switch for this property
     *
     ******************************************************************************************************************/
    public void setScaledImageCachingEnabled (final boolean scaledImageCachingEnabled)
      {
        log.info("setScaledImageCachingEnabled(" + scaledImageCachingEnabled + ")");
        this.scaledImageCachingEnabled = scaledImageCachingEnabled;

        if (!scaledImageCachingEnabled)
          {
            flushScaledImageCache();
          }
      }

    /*******************************************************************************************************************
     *
     * Returns the status of the caching of a scaled image for faster speed.
     *
     * @return the status of this feature
     *
     ******************************************************************************************************************/
    public boolean isScaledImageCachingEnabled()
      {
        return scaledImageCachingEnabled;
      }

    /*******************************************************************************************************************
     *
     * Enables or disables the use of an optimized copy of the image.
     *
     * @param  optimizedImageEnabled  the switch for this property
     *
     ******************************************************************************************************************/
    public void setOptimizedImageEnabled (final boolean optimizedImageEnabled)
      {
        log.info("setOptimizedImageEnabled(" + optimizedImageEnabled + ")");
        this.optimizedImageEnabled = optimizedImageEnabled;
      }

    /*******************************************************************************************************************
     *
     * Returns the status of the rgb image caching feature.
     *
     * @return the status of this feature
     *
     ******************************************************************************************************************/
    public boolean isOptimizedImageEnabled()
      {
        return optimizedImageEnabled;
      }

    /*******************************************************************************************************************
     *
     * Sets a shape to clip rendering against.
     *
     * @param  clippingShape  the clipping shape
     *
     ******************************************************************************************************************/
    public void setClippingShape (final Shape clippingShape)
      {
        this.clippingShape = clippingShape;
      }

    /*******************************************************************************************************************
     *
     * Adds an overlay to be shown over the image.
     *
     * @param  overlay  the overlay
     *
     ******************************************************************************************************************/
    public void addOverlay (final Overlay overlay)
      {
        overlayList.add(overlay);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void removeOverlay (final Overlay overlay)
      {
        overlayList.remove(overlay);
      }

    /*******************************************************************************************************************
     *
     * Sets the preview settings.
     *
     ******************************************************************************************************************/
    public void setPreviewSettings (final PreviewSettings previewSettings)
      {
        this.previewSettings = previewSettings;
        repaint();
      }

    /*******************************************************************************************************************
     *
     * Gets the preview settings.
     *
     ******************************************************************************************************************/
    public PreviewSettings getPreviewSettings()
      {
        return previewSettings;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public void update (final Graphics g)
      {
        paint(g); // don't waste time on the background
      }

    /*******************************************************************************************************************
     *
     * Renders this component.
     *
     ******************************************************************************************************************/
    @Override
    public void paint (final Graphics g)
      {
        log.info("paint()");

        if (!repaintEnabled)
          {
            return;
          }

        if (fitToDisplaySize)
          {
            internalSetScale(getFitScale());
            internalSetOrigin(computeCenterPoint());
//            fitToDisplaySize();
          }

        layoutScrollBars();

        final int myWidth = getWidth();
        final int myHeight = getHeight();
        //if (image == null) // FIXME: this can be optimized
        {
          g.setColor(getBackground());
          g.fillRect(0, 0, myWidth, myHeight);
        }

        Graphics2D g2 = null;

        try
          {
            if (image != null)
              {
                EditableImage imageToDraw = null;
                final double maxSize = scale * Math.max(image.getWidth(), image.getHeight());
                boolean needScaling = true;
                int rotationDeltaX = 0;
                int rotationDeltaY = 0;

                //
                // If scaled image caching is enabled, create a scaled image and then
                // render it 1:1. Don't use a scaled image if it is too big!
                //
                if (((scaledImageCachingEnabled && (maxSize < MAX_SIZE_FOR_SCALED_CACHING)) || (angle != 0)))
                  {
                    if (scaledImage == null)
                      {
                        log.debug(">>>> computing scaled image");
                        scaledImage = optimizedImage.execute2(new ScaleOp(scale, getScaleQuality()));

                        final int prevWidth = scaledImage.getWidth();
                        final int prevHeight = scaledImage.getHeight();
                        scaledImage.execute(new RotateOp(angle, getRotateQuality()));
                        //
                        // Rotating the image could have make it bigger (to avoid truncation).
                        // Adjust the origin in order to compensate for it.
                        //
                        rotationDeltaX = (prevWidth - scaledImage.getWidth()) / 2;
                        rotationDeltaY = (prevHeight - scaledImage.getHeight()) / 2;
                      }

                    imageToDraw = scaledImage;
                    shownImageWidth = scaledImage.getWidth();
                    shownImageHeight = scaledImage.getHeight();
                    needScaling = false;
                  }

                //
                // Otherwise scale the image on-the-fly.
                //
                else
                  {
                    imageToDraw = optimizedImage;
                    shownImageWidth = (int)Math.round(scale * optimizedImage.getWidth());
                    shownImageHeight = (int)Math.round(scale * optimizedImage.getHeight());
                  }

                shownImageX = -(int)Math.round(scale * origin.x) + rotationDeltaX;
                shownImageY = -(int)Math.round(scale * origin.y) + rotationDeltaY;

                g2 = (Graphics2D)g.create(); // make a copy since you're changing hints

                if (clippingShape != null)
                  {
                    g2.clip(clippingShape);
                  }

                //
                // Don't pass 'this' as an observer, it could trigger paint() twice (FIXME: check if it's true)
                //
                final PaintOp paintOp = needScaling
                                        ? new PaintOp(g2,
                                                      shownImageX,
                                                      shownImageY,
                                                      shownImageWidth,
                                                      shownImageHeight,
                                                      scaleQuality,
                                                      previewSettings,
                                                      null)
                                        : new PaintOp(g2, shownImageX, shownImageY, previewSettings, null);

                imageToDraw.execute(paintOp);

                if (imageBorder != null)
                  {
                    imageBorder.paintBorder(this, g2, shownImageX, shownImageY, shownImageWidth, shownImageHeight);
                  }
              } // if image != null

            if (g2 == null)
              {
                g2 = (Graphics2D)g;
              }

            for (final Overlay overlay : overlayList)
              {
                if (overlay.isVisible())
                  {
                    final Graphics2D g2Copy = (Graphics2D)g2.create();

                    try
                      {
                        overlay.paint(g2Copy, this);
                      }
                    catch (Throwable t)
                      {
                        log.warn("Exception in Overlay: " + t);
                        log.warn("paint()", t);
                      }

                    g2Copy.dispose();
                  }
              }
          }

        catch (Throwable t)
          {
            log.warn("paint()", t);
          }

        finally
          {
            if (g2 != null)
              {
                g2.dispose();
              }
          }

        paintComponents(g);
      }

    /*******************************************************************************************************************
     *
     * Flush all image caches.
     *
     ******************************************************************************************************************/
    public void flushAllCaches()
      {
        log.info("flushAllCaches()");
        log.info(">>>> all caches will be recomputed from: " + image);
        flushScaledImageCache();

        if (image != null)
          {
            optimizedImage = optimizedImageEnabled ? image.execute2(new OptimizeOp()) : image;
          }

        else
          {
            optimizedImage = null;
          }
      }

    /*******************************************************************************************************************
     *
     * Flush the cached scaled image.
     *
     ******************************************************************************************************************/
    public void flushScaledImageCache()
      {
        log.info("flushScaledImageCache()");
        scaledImage = null;
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public void moveOrigin (final int deltaX, final int deltaY)
      {
        log.info("moveOrigin(" + deltaX + "," + deltaY + ")");
        final Point position = getOrigin();
        position.setLocation(position.getX() + deltaX, position.getY() + deltaY);
        setOrigin(position);
      }

    /*******************************************************************************************************************
     *
     * Sets the explicit scale for displaying the current image. This disables the
     * fit-to-display-size feature.
     *
     * @param  scale   the new scale
     *
     ******************************************************************************************************************/
    public void setScale (final double scale)
      {
        log.info("setScale(" + scale + ")");
        setScale(scale, null);
      }

    /*******************************************************************************************************************
     *
     * Sets the explicit scale for displaying the current image. This disables the
     * fit-to-display-size feature. A pivot point is specified: the contents under
     * the pivot point don't move during the zoom.
     *
     * @param  scale       the new scale
     * @param  pivotPoint  the pivot point (if null, the center of the renderer
     *                     is used)
     *
     ******************************************************************************************************************/
    public void setScale (double scale, final Point pivotPoint)
      {
        log.info("setScale(" + scale + ", " + pivotPoint + ")");
        scale = Math.min(Math.max(scale, minScale), maxScale);

//        if ((scale < MIN_SCALE) || (scale > MAX_SCALE))
//          {
//            throw new IllegalArgumentException("scale: " + scale);
//          }

        final boolean repaintEnabledSave = repaintEnabled;
        repaintEnabled = false;
        setFitToDisplaySize(false);
        internalSetScale(scale);

        if (pivotPoint != null)
          {
            final Point imagePivotPoint = getPositionOverImage(pivotPoint);

            if (imagePivotPoint != null)
              {
                final Point newOrigin = computeOrigin(imagePivotPoint, pivotPoint, scale);

                if (newOrigin != null)
                  {
                    setOrigin(newOrigin);
                  }
              }
          }

//        internalSetScale(scale);
        repaintEnabled = repaintEnabledSave;
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public void setMaxScale (final double maxScale)
      {
        this.maxScale = Math.min(MAX_SCALE, maxScale);
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public double getMaxScale()
      {
        return maxScale;
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public void setMinScale (final double minScale)
      {
        this.minScale = Math.max(MIN_SCALE, minScale);
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public double getMinScale()
      {
        return minScale;
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public double getFitScale()
      {
        final double hScale = (double)getAvailableWidth() / image.getWidth();
        final double vScale = (double)getAvailableHeight() / image.getHeight();

        return Math.min(hScale, vScale);

//        if (this.scale < 0)
//          {
//            log.info("SCALE < 0: w:" + w + " h:" + h + " iw:" + iw + " ih:" + ih);
//          }
      }

    /*******************************************************************************************************************
     *
     * Centers the image on the renderer, keeping the current scale.
     *
     ******************************************************************************************************************/
    public void centerImage()
      {
        log.info("centerImage()");
        setOrigin(computeCenterPoint());
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public void fitToDisplaySize()
      {
        log.info("fitToDisplaySize()");

        if (image != null)
          {
            final boolean saveRepaintEnabled = repaintEnabled;
            repaintEnabled = false;
            internalSetScale(getFitScale());
            centerImage();
            repaintEnabled = saveRepaintEnabled;
            repaint();
          }
      }

    /*******************************************************************************************************************
     *
     * Enables or disables the fit-to-display-size feature.
     *
     ******************************************************************************************************************/
    public void setFitToDisplaySize (final boolean fitToDisplaySize)
      {
        log.info("setFitToDisplaySize(" + fitToDisplaySize + ")");
        this.fitToDisplaySize = fitToDisplaySize;

        if (fitToDisplaySize)
          {
            fitToDisplaySize();
          }
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public void addImageRendererListener (final EditableImageRendererListener listener)
      {
        listenerList.add(listener);
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public void removeImageRendererListener (final EditableImageRendererListener listener)
      {
        listenerList.remove(listener);
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    private void internalSetScale (final double scale)
      {
        if (this.scale != scale)
          {
            this.scale = scale;
            flushScaledImageCache();
            repaint();
          }

        fireScaleChangedEvent();
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    private Point computeCenterPoint()
      {
        return new Point(-(int)Math.round(((getAvailableWidth() / scale) - image.getWidth()) / 2),
                         -(int)Math.round(((getAvailableHeight() / scale) - image.getHeight()) / 2));
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    private void fireScaleChangedEvent()
      {
        final EditableImageRendererEvent event = new EditableImageRendererEvent(this);

        for (final EditableImageRendererListener listener : new ArrayList<>(listenerList))
          {
            try
              {
                listener.scaleChanged(event);
              }
            catch (Throwable t)
              {
                log.warn("Exception in listener: " + t);
                log.warn("fireScaleChangedEvent()", t);
              }
          }
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    private void fireAngleChangedEvent()
      {
        final EditableImageRendererEvent event = new EditableImageRendererEvent(this);

        for (final EditableImageRendererListener listener : new ArrayList<>(listenerList))
          {
            try
              {
                listener.angleChanged(event);
              }
            catch (Throwable t)
              {
                log.warn("Exception in listener: " + t);
                log.warn("fireAngleChangedEvent()", t);
              }
          }
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    protected void fireEditingToolActivated (final EditingTool editingTool)
      {
        final EditableImageRendererEvent event = new EditableImageRendererEvent(this, editingTool);

        for (final EditableImageRendererListener listener : new ArrayList<>(listenerList))
          {
            try
              {
                listener.toolActivated(event);
              }
            catch (Throwable t)
              {
                log.warn("Exception in listener: " + t);
                log.warn("fireEditingToolActivated()", t);
              }
          }
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    protected void fireEditingToolDeactivated (final EditingTool editingTool)
      {
        final EditableImageRendererEvent event = new EditableImageRendererEvent(this, editingTool);

        for (final EditableImageRendererListener listener : new ArrayList<>(listenerList))
          {
            try
              {
                listener.toolDeactivated(event);
              }
            catch (Throwable t)
              {
                log.warn("Exception in listener: " + t);
                log.warn("fireEditingToolDeactivated()", t);
              }
          }
      }

    /*******************************************************************************************************************
     *
     * Updates the scrollbar cursors positions.
     *
     ******************************************************************************************************************/
    private void updateScrollBars()
      {
        if (scrollBarsVisible)
          {
            horizontalScrollBar.setValues(this.origin.x,
                                          (int)Math.round(getAvailableWidth() / scale),
                                          0,
                                          image.getWidth());
            verticalScrollBar.setValues(this.origin.y,
                                        (int)Math.round(getAvailableHeight() / scale),
                                        0,
                                        image.getHeight());
          }
      }

    /*******************************************************************************************************************
     *
     * Lays out the scrollbars in their correct position.
     *
     ******************************************************************************************************************/
    private void layoutScrollBars()
      {
        if (scrollBarsVisible && ((previousWidth != getWidth()) || (previohsHeight != getHeight())))
          {
            horizontalScrollBar.setBounds(0,
                                          getHeight() - scrollbarThickness,
                                          getWidth() - scrollbarThickness,
                                          scrollbarThickness);
            verticalScrollBar.setBounds(getWidth() - scrollbarThickness,
                                        0,
                                        scrollbarThickness,
                                        getHeight() - scrollbarThickness);
            filler.setBounds(getWidth() - scrollbarThickness,
                             getHeight() - scrollbarThickness,
                             scrollbarThickness,
                             scrollbarThickness);
            previousWidth = getWidth();
            previohsHeight = getHeight();
          }
      }

    /*******************************************************************************************************************
     *
     * Returns the available width for rendering the image.
     *
     ******************************************************************************************************************/
    private int getAvailableWidth()
      {
        return getWidth() - (scrollBarsVisible ? scrollbarThickness : 0);
      }

    /*******************************************************************************************************************
     *
     * Returns the available height for rendering the image.
     *
     ******************************************************************************************************************/
    private int getAvailableHeight()
      {
        return getHeight() - (scrollBarsVisible ? scrollbarThickness : 0);
      }
  }
