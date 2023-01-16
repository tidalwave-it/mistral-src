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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;


/*******************************************************************************
 *
 * This class activated panning-by-dragging, that is the capability of moving the
 * photo in the viewport by dragging with the mouse.
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class DragPanningController
  {
    /** The attached renderer. */
    private final EditableImageRenderer imageRenderer;

    /** The enablement state. */
    private boolean enabled;

    /** The previous mouse position is used to compute the delta motion. */
    private Point previousMousePosition;

    /***************************************************************************
     *
     *
     **************************************************************************/
    private final MouseListener mouseListener = new MouseAdapter()
          {
            @Override
            public void mousePressed (final MouseEvent event)
              {
                previousMousePosition = event.getPoint();
              }

            @Override
            public void mouseReleased (final MouseEvent event)
              {
                previousMousePosition = null;
              }
          };

    /***************************************************************************
     *
     *
     **************************************************************************/
    private final MouseMotionListener dragListener = new MouseMotionAdapter()
          {
            @Override
            public void mouseDragged (final MouseEvent event)
              {
                final Point newMousePosition = event.getPoint();

                if (previousMousePosition != null)
                  {
                    final int deltaX = (int)(newMousePosition.getX() - previousMousePosition.getX());
                    final int deltaY = (int)(newMousePosition.getY() - previousMousePosition.getY());
                    final double scale = imageRenderer.getScale();
                    imageRenderer.moveOrigin(-(int)Math.round(deltaX / scale), -(int)Math.round(deltaY / scale));
                  }

                previousMousePosition = newMousePosition;
              }
          };

    /***************************************************************************
     *
     * Creates a new instance of this class, attached to the given renderer.
     * This controller must be activated with <code>setEnabled(true)</code> in
     * order to be used.
     *
     * @param  imageRenderer    the image renderer
     *
     **************************************************************************/
    public DragPanningController (final EditableImageRenderer imageRenderer)
      {
        if (imageRenderer == null)
          {
            throw new IllegalArgumentException("imageRenderer is mandatory");
          }

        this.imageRenderer = imageRenderer;
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
    public void setEnabled (boolean enabled)
      {
        if (this.enabled != enabled)
          {
            this.enabled = enabled;

            if (enabled)
              {
                imageRenderer.addMouseListener(mouseListener);
                imageRenderer.addMouseMotionListener(dragListener);
              }

            else
              {
                imageRenderer.removeMouseListener(mouseListener);
                imageRenderer.removeMouseMotionListener(dragListener);
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

    /***************************************************************************
     *
     * Centers the image on the screen, keeping the current scale.
     *
     **************************************************************************/
    public void centerImage ()
      {
        imageRenderer.centerImage();
      }
  }
