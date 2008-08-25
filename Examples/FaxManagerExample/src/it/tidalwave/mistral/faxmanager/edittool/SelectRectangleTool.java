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
 * $Id: CropJ2DOp.java 47 2006-11-09 15:19:06Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.mistral.faxmanager.edittool;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.render.EditableImageRenderer;
import it.tidalwave.image.render.EditingTool;
import it.tidalwave.image.render.EditingTool.State;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: EditableImageRenderer.java 324 2006-12-21 22:22:23Z fabriziogiudici $
 *
 ******************************************************************************/
public abstract class SelectRectangleTool extends EditingTool
  {
    private final Rectangle bounds = new Rectangle();
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    class WaitFirstClickState extends State
      {
        @Override
        public void mousePressed (MouseEvent event) 
          {
            Point p = imageRenderer.getPositionOverImage(event.getPoint());
            
            if (p != null) // null means outside the image
              {
                bounds.x = (int)p.getX();
                bounds.y = (int)p.getY();
                setState(DrawRectangleState.class);
              }
          }
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    class DrawRectangleState extends State
      {
        @Override
        public void mouseDragged (final MouseEvent event) 
          {
            Point p = imageRenderer.getPositionOverImage(event.getPoint());
            
            if (p != null)
              {
                bounds.width  = (int)p.getX() - bounds.x;
                bounds.height = (int)p.getY() - bounds.y;
                repaint();
              }
          }
        
        @Override
        public void mouseReleased (final MouseEvent event) 
          {
            imageRenderer.getImage().setAttribute(CHANGED_ATTRIBUTE, true);
            execute(imageRenderer, imageRenderer.getImage());
            imageRenderer.flushAllCaches();
            reset();
          }
        
        @Override
        public final void paint (final Graphics2D g, final EditableImageRenderer imageRenderer) 
          {
            Point p1 = imageRenderer.convertImagePointToComponentPoint(bounds.getLocation());
            Point p2 = imageRenderer.convertImagePointToComponentPoint(new Point(bounds.x + bounds.width - 1, bounds.y + bounds.height - 1));
            g.setColor(Color.BLACK);
            float[] dash = new float[] { 0.5f, 0.5f };
            float phase = 0.5f;
            g.setStroke(new BasicStroke(0.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1.0f, dash, phase));
            g.drawRect(Math.min(p1.x, p2.x), 
                       Math.min(p1.y, p2.y), 
                       Math.abs(p2.x - p1.x) + 1, 
                       Math.abs(p2.y - p1.y) + 1);
          }
      }
    
    /***************************************************************************
     *
     * Creates a new instance of this class and attaches it to the given
     * EditableImageRenderer.
     *
     * @param   imageRenderer   the image renderer to attach to
     *
     **************************************************************************/
    public SelectRectangleTool (final EditableImageRenderer imageRenderer)  
      {
        super(imageRenderer);
        registerState(new WaitFirstClickState());
        registerState(new DrawRectangleState());
        setInitialState(WaitFirstClickState.class);
      }
    
    /***************************************************************************
     * 
     * This method is invoked at the end of the operation. Subclasses should
     * implement this method.
     *
     **************************************************************************/
    public abstract void execute (final EditableImageRenderer imageRenderer, final EditableImage image);
 
    /***************************************************************************
     *
     * Gets the currently selected bounds.
     *
     * @return  the bounds
     *
     **************************************************************************/
    protected Rectangle getBounds()
      {
        Point p1 = bounds.getLocation();
        Point p2 = new Point(bounds.x + bounds.width - 1, bounds.y + bounds.height - 1);
        return new Rectangle(Math.min(p1.x, p2.x), 
                             Math.min(p1.y, p2.y), 
                             Math.abs(p2.x - p1.x) + 1, 
                             Math.abs(p2.y - p1.y) + 1);        
      } 
  }
