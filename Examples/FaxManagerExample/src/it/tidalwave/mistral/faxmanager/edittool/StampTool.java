/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2007 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
 *                        and Emmanuele Sordini (Emmanuele@Sordini.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *******************************************************************************
 *
 * $Id: StampTool.java 834 2008-01-31 11:10:25Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.mistral.faxmanager.edittool;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.DrawOp;
import it.tidalwave.image.render.EditableImageRenderer;
import it.tidalwave.image.render.EditingTool;
import it.tidalwave.image.render.EditingTool.State;
import it.tidalwave.mistral.faxmanager.bd.FaxServerBD;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: StampTool.java 834 2008-01-31 11:10:25Z fabriziogiudici $
 *
 ******************************************************************************/
public class StampTool extends EditingTool
  {
    public static final String PUNCHED = "punched";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    private static final int STAMP_WIDTH = 300;
    private static final int STAMP_HEIGHT = 130;
    private static final int STAMP_FONT_SIZE = 32;
    
    private Point point;
    private String code;
    private final FaxServerBD faxServerBD;

    /***************************************************************************
     *
     *
     **************************************************************************/
    class WaitFirstClickState extends State
      {
        @Override
        public void mouseMoved (final MouseEvent event)
          {
            point = event.getPoint();
            repaint();
          }

        @Override
        public void mousePressed (final MouseEvent event)
          {
            point = imageRenderer.getPositionOverImage(event.getPoint());
//            deactivate();

            if (point != null)
              {
                imageRenderer.getImage().setAttribute(CHANGED_ATTRIBUTE, true);
                imageRenderer.getImage().execute(new DrawOp(new DrawOp.Executor()
                      {
                        public void draw (final Graphics2D g, final EditableImage image)
                          {
                            paintStamp(g, point.x, point.y, 1.0);
                            image.setAttribute(PUNCHED, true);
                          }
                      }));

                imageRenderer.flushAllCaches();
                imageRenderer.repaint();
              }
          }

        @Override
        public final void paint (final Graphics2D g, final EditableImageRenderer imageRenderer)
          {
            paintStamp(g, point.x, point.y, imageRenderer.getScale());
          }
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public StampTool (final EditableImageRenderer imageRenderer, final FaxServerBD faxServerBD)
        throws IOException
      {
        super(imageRenderer);
        registerState(new WaitFirstClickState());
        setInitialState(WaitFirstClickState.class);
        this.faxServerBD = faxServerBD;
      }
    
    /***************************************************************************
     *
     * Prepares for using a new code next time.
     *
     **************************************************************************/
    public void prepareForNewCode()
      {
        code = null;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public void activate ()
      {
        super.activate();
        
        if (code == null)
          {
            code = faxServerBD.retrieveStampCode();
          }
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public void imageChanged()
      {
        // do nothing, superclass deactivates the tool    
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    protected void paintStamp (final Graphics2D g, final int x, final int y, final double scale)
      {
//        final int arc = (int)Math.round(scale * 30);
        final int width = (int)Math.round(scale * STAMP_WIDTH);
        final int height = (int)Math.round(scale * STAMP_HEIGHT);
//        g.setTransform(AffineTransform.getRotateInstance(-0.3));
        g.setColor(Color.BLUE);
        g.setStroke(new BasicStroke((int)Math.round(scale * 10)));
//        g.drawRoundRect(point.x, point.y, width, height, arc, arc);
        g.drawRect(point.x, point.y, width, height);

        g.setFont(new Font("sans-serif", Font.BOLD, (int)Math.round(scale * STAMP_FONT_SIZE)));

        final int stringHeight = g.getFontMetrics().getHeight();
        int yy = point.y + ((height - stringHeight * 3) / 2) + g.getFontMetrics().getAscent();
        drawString(g, point.x, yy, width, "RICEVUTO");
        yy += stringHeight;
        drawString(g, point.x, yy, width, DATE_FORMAT.format(new Date()));
        yy += stringHeight;
        drawString(g, point.x, yy, width, "N\u00b0 " + code);
      }
    
    private void drawString (final Graphics2D g, final int x, final int y, final int width, final String string)
      {
        final int stringWidth = g.getFontMetrics().stringWidth(string);
        g.drawString(string, x + ((width - stringWidth) / 2), y);
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public String getStampCode()
      {
        return code;  
      }
  }
