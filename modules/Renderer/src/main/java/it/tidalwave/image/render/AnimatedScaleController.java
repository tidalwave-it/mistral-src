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

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import it.tidalwave.image.Quality;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * A special <code>ScaleController</code> which performs smooth scale transitions.
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class AnimatedScaleController extends ScaleController
  {
    private static final int DEFAULT_FRAMES_PER_SECOND = 20;
    private static final int DEFAULT_DURATION = 150;
    private int framesPerSecond = DEFAULT_FRAMES_PER_SECOND;
    private int duration = DEFAULT_DURATION;

    /**
     * When a zoom is performed, keep the following image point fixed.
     */
    private Point pivot;
    private double startScale;
    private double targetScale;
    private long startTime;
    private Timer timer;

    /**
     * The scale quality saved at the start of the animation.
     */
    private Quality scaleQualitySave;

    /**
     * The rotate quality saved at the start of the animation.
     */
    private Quality rotateQualitySave;

    /*******************************************************************************************************************
     *
     * Creates a new instance of this class, attached to the given renderer.
     *
     * @param  imageRenderer    the image renderer
     *
     ******************************************************************************************************************/
    public AnimatedScaleController (final EditableImageRenderer imageRenderer)
      {
        super(imageRenderer);
      }

    /*******************************************************************************************************************
     *
     * Returns true if the zoom animation is running.
     *
     * @return true if animation running
     *
     ******************************************************************************************************************/
    public synchronized boolean isRunning()
      {
        return timer != null;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public void setScale (final double scale, Point pivot)
      {
        log.debug("setScale(" + scale + ", " + pivot + ")");

        if (pivot == null)
          {
            pivot = new Point(imageRenderer.getWidth() / 2, imageRenderer.getHeight() / 2);
          }

        this.pivot = pivot;
        startScale = imageRenderer.getScale();
        targetScale = scale;
        startTime = System.currentTimeMillis();

        synchronized (this)
          {
            if (timer == null)
              {
                //
                // During animation is useless to waste time for high quality.
                // The original quality will be restored at the end of the animation.
                //
                scaleQualitySave = imageRenderer.getScaleQuality();
                rotateQualitySave = imageRenderer.getRotateQuality();
                log.debug(">>>> scale quality:  " + imageRenderer.getScaleQuality());
                log.debug(">>>> rotate quality: " + imageRenderer.getRotateQuality());
                log.debug(">>>> temporarily setting quality to FASTEST");
                imageRenderer.setScaleQuality(Quality.FASTEST);
                imageRenderer.setRotateQuality(Quality.FASTEST);

                timer = new Timer(1000 / framesPerSecond,
                                  e -> changeScale());

                timer.setRepeats(true);
                timer.setInitialDelay(0);
                timer.start();
              }
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private void changeScale()
      {
        log.debug("changeScale()");

        final long deltaTime = System.currentTimeMillis() - startTime;
        final double scale = bound(startScale + (((targetScale - startScale) * deltaTime) / duration));
        imageRenderer.setScale(Math.max(Math.min(scale, EditableImageRenderer.MAX_SCALE),
                                        EditableImageRenderer.MIN_SCALE), pivot);
        log.debug(">>>> scale: " + scale + ", targetScale: " + targetScale);

        if (Math.abs(scale - targetScale) < 1E-3)
          {
            //
            // If this is the last operation in the sequence, restore original quality.
            //
            log.debug(">>>> scale quality:  save: " + scaleQualitySave + " /// current: " +
                      imageRenderer.getScaleQuality());
            log.debug(">>>> rotate quality: save: " + rotateQualitySave + " /// current: " +
                      imageRenderer.getRotateQuality());

            if ((scaleQualitySave != imageRenderer.getScaleQuality()) ||
                (rotateQualitySave != imageRenderer.getRotateQuality()))
              {
                //
                // A higher quality rendering can take too long and thus disrupt the smoothness of the animated zoom.
                // For this reason, we have first rendered the image with the target scale in FASTEST mode, and now
                // we schedule the final, high-quality rendering with invokeLater() - even though we already
                // are in the Event Thread.
                //
                SwingUtilities.invokeLater(() ->
                                             {
                                               imageRenderer.setScaleQuality(scaleQualitySave);
                                               imageRenderer.setRotateQuality(rotateQualitySave);
                                               log.debug(">>>> quality restored to " + scaleQualitySave + ", " + rotateQualitySave);
                                               imageRenderer.flushScaledImageCache();
                                               imageRenderer.repaint();
                                               log.debug(">>>> scale: " + scale + ", targetScale: " + targetScale);
                                             });
              }

            synchronized (this)
              {
                if (timer != null)
                  {
                    log.debug(">>>> timer stopped");
                    timer.stop();
                    timer = null;
                    pivot = null;
                  }
              }
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private double bound (final double scale)
      {
        return Math.max(Math.min(scale, Math.max(startScale, targetScale)), Math.min(startScale, targetScale));
      }
  }
