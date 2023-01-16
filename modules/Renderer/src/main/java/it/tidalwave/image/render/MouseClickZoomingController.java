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

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import it.tidalwave.image.render.event.EditableImageRendererAdapter;
import it.tidalwave.image.render.event.EditableImageRendererEvent;


/*******************************************************************************
 *
 * This class activates zoom-by-click, that is the capability of zooming in and
 * out on the image by clicking with the mouse over it. The click toggles the
 * zoom between the 1:1 and the 'fit to view' values. The actual zooming
 * behaviour is delegated to a <code>ScaleController</code>, which allows to
 * plug different implementations (e.g. animations).
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class MouseClickZoomingController
  {
    /** The attached renderer. */
    private final EditableImageRenderer imageRenderer;

    /** The controller for the scale operation. */
    private final ScaleController scaleController;

    /** The enablement state. */
    private boolean enabled;

    /** The number of clicks requested to trigger the zoom. */
    private int clickCountToZoom = 2;
    
    private double factor = 1.0;

    /***************************************************************************
     *
     * Tracks scale changes and select a different cursor.
     *
     **************************************************************************/
    private final EditableImageRendererAdapter scaleListener = new EditableImageRendererAdapter()
          {
        @Override
            public void scaleChanged (final EditableImageRendererEvent editableImageRendererEvent)
              {
                final double scale = imageRenderer.getScale();
                imageRenderer.setCursor(Cursor.getPredefinedCursor((scale != imageRenderer.getFitScale()) ? Cursor.HAND_CURSOR
                                                                                                          : Cursor.CROSSHAIR_CURSOR));
              }
          };

    /***************************************************************************
     *
     * Listens to mouse clicks.
     *
     **************************************************************************/
    private final MouseListener clickListener = new MouseAdapter()
          {
            @Override
            public void mouseClicked (final MouseEvent event)
              {
                if ((event.getClickCount() == clickCountToZoom) && (imageRenderer.getPositionOverImage(event.getPoint()) != null))
                  {
                    final double scale = imageRenderer.getScale();
                    scaleController.setScale((scale == 1) ? imageRenderer.getFitScale() * factor : 1, event.getPoint());
                  }
              }
          };

    /***************************************************************************
     *
     * Creates a new instance of this class, attached to a
     * <code>ScaleController</code>. This controller must be
     * activated with <code>setEnabled(true)</code> in order to be used.
     *
     * @param  scaleController  the scale controller
     *
     **************************************************************************/
    public MouseClickZoomingController (final ScaleController scaleController)
      {
        if (scaleController == null)
          {
            throw new IllegalArgumentException("scaleController is mandatory");
          }

        this.scaleController = scaleController;
        this.imageRenderer = scaleController.getImageRenderer();
      }

    /***************************************************************************
     *
     * Sets the number of clicks requested to trigger the zooming.
     *
     * @param  clickCountToZoom  the number of clicks
     *
     **************************************************************************/
    public void setClickCountToZoom (final int clickCountToZoom)
      {
        this.clickCountToZoom = clickCountToZoom;
      }

    /***************************************************************************
     *
     * Returns the number of clicks requested to trigger the zooming.
     *
     **************************************************************************/
    public int getClickCountToZoom ()
      {
        return clickCountToZoom;
      }

    /***************************************************************************
     *
     * Enables or disables this controller. As this class attaches some
     * listeners to the image renderer component, it's advisable to disable it
     * when it's not needed, in order to facilitate garbage collection.
     *
     * @param  enabled  true if must be enabled, false otherwise
     *
     **************************************************************************/
    public void setEnabled (final boolean enabled)
      {
        if (this.enabled != enabled)
          {
            this.enabled = enabled;

            if (enabled)
              {
                imageRenderer.addMouseListener(clickListener);
                imageRenderer.addImageRendererListener(scaleListener);
              }

            else
              {
                imageRenderer.removeMouseListener(clickListener);
                imageRenderer.removeImageRendererListener(scaleListener);
                imageRenderer.setCursor(Cursor.getDefaultCursor());
              }
          }
      }

    /***************************************************************************
     *
     * Returns true if the controller is enabled.
     *
     * @return  true  if enabled
     *
     **************************************************************************/
    public boolean isEnabled ()
      {
        return enabled;
      }
    
    public void setFactor (final double factor)
      {
        this.factor = factor;    
      }
    
    public double getFactor()
      {
        return factor;    
      }
  }
