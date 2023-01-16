/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2023 by Tidalwave s.a.s.
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
package it.tidalwave.image.render;

import java.awt.Point;


/*******************************************************************************
 *
 * The <code>ScaleController</code> makes it possible to control the scale of
 * the image in an <code>EditableImageRenderer</code>. In order to be used,
 * you just have to create a new instance passing the
 * <code>EditableImageRenderer</code> as a parameter:
 *
 * <pre>
 * EditableImageRenderer renderer = ...;
 * ScaleController scaleController = new ScaleController(renderer);
 * ...
 * scaleController.setScale(2.5);
 * </pre>
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ScaleController
  {
    /** The attached renderer. */
    protected final EditableImageRenderer imageRenderer;

    /** The zoom factor used by zoomIn() and zoomOut(). */
    private double zoomFactor = 1.5;

    /***************************************************************************
     *
     * Creates a new instance of this class, attached to the given renderer.
     *
     * @param  imageRenderer    the image renderer
     *
     **************************************************************************/
    public ScaleController (final EditableImageRenderer imageRenderer)
      {
        if (imageRenderer == null)
          {
            throw new IllegalArgumentException("imageRenderer is mandatory");
          }

        this.imageRenderer = imageRenderer;
      }

    /***************************************************************************
     *
     * Sets the scale.
     *
     * @param  scale  the new scale
     *
     **************************************************************************/
    public final void setScale (final double scale)
      {
        setScale(scale, null);
      }

    /***************************************************************************
     *
     * Sets the scale using a pivot point. A null pivot means that the pivot
     * will be placed on the center of the image.
     *
     * @param  scale  the new scale
     * @param  pivot  the pivot point (null means the center of the image)
     *
     **************************************************************************/
    public void setScale (final double scale, final Point pivot)
      {
        imageRenderer.setScale(scale, pivot);
      }

    /***************************************************************************
     *
     * Returns the current scale.
     *
     * @return  the current scale
     *
     **************************************************************************/
    public double getScale ()
      {
        return imageRenderer.getScale();
      }

    /***************************************************************************
     *
     * Sets the zoom factor that is used by <code>zoomIn()</code> and
     * <code>zoomOut</code>.
     *
     * @param  zoomFactor  the new zoom factor
     *
     **************************************************************************/
    public void setZoomFactor (final double zoomFactor)
      {
        this.zoomFactor = zoomFactor;
      }

    /***************************************************************************
     *
     * Returns the current zoom factor.
     *
     * @return  the currnet zoom factor
     *
     **************************************************************************/
    public double getZoomFactor ()
      {
        return zoomFactor;
      }

    /***************************************************************************
     *
     * Fits the image into the current view: the image is resized so it's not
     * clipped, and it's centered on the screen.
     *
     **************************************************************************/
    public void fitToView ()
      {
        fitToView(1.0);  
      }
    
    public void fitToView (final double factor)
      {
        imageRenderer.setRepaintEnabled(false);
        imageRenderer.centerImage();
        setScale(imageRenderer.getFitScale() * factor);
        imageRenderer.setRepaintEnabled(true);
        imageRenderer.repaint();
      }

    /***************************************************************************
     *
     * Zooms out.
     *
     **************************************************************************/
    public void zoomOut ()
      {
        setScale(imageRenderer.getScale() / zoomFactor);
      }

    /***************************************************************************
     *
     * Zooms in.
     *
     **************************************************************************/
    public void zoomIn ()
      {
        setScale(imageRenderer.getScale() * zoomFactor);
      }

    /***************************************************************************
     *
     * Sets the scale to 1:1.
     *
     **************************************************************************/
    public void showActualPixels ()
      {
        setScale(1.0);
      }

    /***************************************************************************
     *
     * @return  the image renderer
     *
     **************************************************************************/
    protected EditableImageRenderer getImageRenderer ()
      {
        return imageRenderer;
      }
  }
