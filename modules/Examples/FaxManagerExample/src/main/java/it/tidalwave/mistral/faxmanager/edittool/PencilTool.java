/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2012 by Tidalwave s.a.s.
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
package it.tidalwave.mistral.faxmanager.edittool;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.DrawOp;
import it.tidalwave.image.render.EditableImageRenderer;
import it.tidalwave.image.render.EditingTool;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class PencilTool extends EditingTool
  {
    /** The current color. */
    private Color color;
    
    /** The current stroke. */
    private Stroke stroke;
    
    /** The current thickness. */
    private int thickness;
    
    /** The previous drawn point. */
    private Point previousPoint;
    
    /** The current drawn point. */
    private Point currentPoint;
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    class PaintState extends State
      {        
        @Override
        public void mouseMoved (final MouseEvent event)
          {
            currentPoint = event.getPoint();
            repaint();
          }

        @Override
        public void start() 
          {
            super.start();
            previousPoint = null;
          }
        
        @Override
        public void mousePressed (final MouseEvent event)
          {
            operation(event); 
          }
        
        @Override
        public void mouseDragged (final MouseEvent event)
          {
            operation(event); 
          }
        
        @Override
        public void mouseReleased (final MouseEvent event)
          {
//            previousPoint = null;
          }
        
        @Override
        public void paint (Graphics2D g, EditableImageRenderer imageRenderer) 
          {
            if (currentPoint != null)
              {
                g.setColor(color);
                g.drawOval(currentPoint.x - thickness / 2, currentPoint.y - thickness / 2, thickness, thickness);
              }
          }
        
        private void operation (final MouseEvent event) 
          {
            final Point p = imageRenderer.getPositionOverImage(event.getPoint());
            
            if (p != null)
              {
                imageRenderer.getImage().setAttribute(CHANGED_ATTRIBUTE, true);
                imageRenderer.getImage().execute(new DrawOp(new DrawOp.Executor()
                  {
                    @Override
                    public void draw (final Graphics2D g, final EditableImage image) 
                      {
                        g.setColor(color);
                        g.setStroke(stroke);

                        if (previousPoint == null)
                          {
                            g.drawLine(p.x, p.y, p.x, p.y); 
                          }

                        else
                          {
                            g.drawLine(previousPoint.x, previousPoint.y, p.x, p.y); 
                          }
                      }
                  }));
    
                imageRenderer.flushAllCaches();
                imageRenderer.repaint();
              }
              
            previousPoint = p;
          }
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public PencilTool (final EditableImageRenderer imageRenderer)
      {
        super(imageRenderer);
        registerState(new PaintState());
        setInitialState(PaintState.class);
        setColor(Color.BLACK);
        setThickness(10);
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void setColor (final Color color)
      {
        this.color = color;  
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public Color getColor()
      {
        return color;   
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void setThickness (int thickness)
      {
        this.thickness = thickness;
        stroke = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public int getThickness()
      {
        return thickness;  
      }
  }
