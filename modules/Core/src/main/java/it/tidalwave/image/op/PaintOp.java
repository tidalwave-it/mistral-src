/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2011 by Tidalwave s.a.s.
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
 * SCM: https://kenai.com/hg/mistral~src
 *
 **********************************************************************************************************************/
package it.tidalwave.image.op;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.awt.Point;
import it.tidalwave.image.Quality;
import it.tidalwave.image.render.PreviewSettings;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class PaintOp extends Operation
  {
    private final int x;
    private final int y;
    private final int w;
    private final int h;
    private final Graphics2D g2;
    private final Quality quality;
    private final PreviewSettings previewSettings;
    private final ImageObserver imageObserver;

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public PaintOp (final Graphics2D g2, final int x, final int y, final int w, final int h, final Quality quality,
        final PreviewSettings previewSettings, final ImageObserver imageObserver)
      {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.g2 = g2;
        this.quality = quality;
        this.previewSettings = previewSettings;
        this.imageObserver = imageObserver;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public PaintOp (final Graphics2D g2, final int x, final int y, final int w, final int h,
        final PreviewSettings previewSettings, final ImageObserver imageObserver)
      {
        this(g2, x, y, w, h, Quality.FASTEST, previewSettings, imageObserver);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public PaintOp (final Graphics2D g2, final int x, final int y, final PreviewSettings previewSettings,
        final ImageObserver imageObserver)
      {
        this(g2, x, y, 0, 0, previewSettings, imageObserver);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public PaintOp (final Graphics2D g2, final int x, final int y, final PreviewSettings previewSettings)
      {
        this(g2, x, y, 0, 0, previewSettings, null);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public PaintOp (final Graphics2D g2, final Point position, final PreviewSettings previewSettings)
      {
        this(g2, position.x, position.y, previewSettings);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public PaintOp (final Graphics2D g2, final int x, final int y)
      {
        this(g2, x, y, 0, 0, null, null);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public PaintOp (final Graphics2D g2, final Point position)
      {
        this(g2, position.x, position.y);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public int getX ()
      {
        return x;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public int getY ()
      {
        return y;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public int getW ()
      {
        return w;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public int getH ()
      {
        return h;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public Graphics2D getGraphics2D ()
      {
        return g2;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public Quality getQuality ()
      {
        return quality;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public PreviewSettings getPreviewSettings ()
      {
        return previewSettings;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public ImageObserver getImageObserver ()
      {
        return imageObserver;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public String toString ()
      {
        return "PaintOp(x:" + x + ", y:" + y + ", w:" + w + ", h:" + h + ", " + quality + ")";
      }
  }
