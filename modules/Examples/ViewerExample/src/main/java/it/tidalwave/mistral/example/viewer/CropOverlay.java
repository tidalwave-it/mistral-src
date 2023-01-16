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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import it.tidalwave.image.render.EditableImageRenderer;
import it.tidalwave.image.render.Overlay;

/***********************************************************************************************************************
 *
 * An Overlay is something that is drawn over a rendered image.
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class CropOverlay implements Overlay
  {
    private boolean visible;

    private int left = 400;

    private int top = 300;

    private int width = 2000;

    private int height = 800;

    @Override
    public void paint (final Graphics2D g, final EditableImageRenderer imageRenderer)
      {
        final Rectangle bounds = imageRenderer.getBounds();
        final Color color = new Color(0, 0, 0, 128);
        g.setColor(color);
        final double scale = imageRenderer.getScale();
        final Point origin = imageRenderer.getOrigin();

        final int x1 = bounds.x + (int)Math.round((left - origin.x) * scale);
        final int y1 = bounds.y + (int)Math.round((top - origin.y) * scale);
        final int x2 = bounds.x + (int)Math.round((left + width - origin.x) * scale);
        final int y2 = bounds.y + (int)Math.round((top + height - origin.y) * scale);

        fillRect(g, bounds.x, bounds.y, bounds.x + bounds.width - 1, y1 - 1); // top
        fillRect(g, bounds.x, y1, x1 - 1, y2); // left
        fillRect(g, x2 + 1, y1, bounds.x + bounds.width - 1, y2); // right
        fillRect(g, bounds.x, y2 + 1, bounds.x + bounds.width - 1, bounds.y + bounds.height - 1); // bottom
      }

    public void setVisible (final boolean visible)
      {
        this.visible = visible;
      }

    @Override
    public boolean isVisible()
      {
        return visible;
      }

    private void fillRect (final Graphics2D g, final int x1, final int y1, final int x2, final int y2)
      {
        g.fillRect(x1, y1, x2 - x1 + 1, y2 - y1 + 1);
      }
  }
