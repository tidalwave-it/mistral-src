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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class HistogramGrid
  {
    private Color color;

    private XYPlotter histogramPlotter;

    private int hSteps = 2;

    /*******************************************************************************************************************
     *
     * @param histogramPlotter
     *
     ******************************************************************************************************************/
    public void sethistogramPlotter (final XYPlotter histogramPlotter)
      {
        this.histogramPlotter = histogramPlotter;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/

    public void setColor (final Color color)
      {
        this.color = color;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public Color getColor()
      {
        return color;
      }

    /*******************************************************************************************************************
     *
     * @param hSteps
     *
     ******************************************************************************************************************/
    public void setHSteps (final int hSteps)
      {
        this.hSteps = hSteps;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void paint (final Graphics g, final Rectangle bounds)
      {
        final var g2 = (Graphics2D)g;
        g2.setColor(getColor());
        final var x = bounds.x;
        final var y = bounds.y;
        final var w = bounds.width;
        final var h = bounds.height;

        for (var i = 1; i <= hSteps - 1; i++)
          {
            var x0 = 0;

            if (histogramPlotter.isXAxisLogarithmic())
              {
                x0 = x + (i * w) / hSteps;
              }

            else
              {
                x0 = x + w / (int)(Math.pow(2, i));
              }

            g2.drawLine(x0, y, x0, y + h - 1);
          }

        g2.drawLine(x, y + h / 2, x + w - 1, y + h / 2);
      }
  }
