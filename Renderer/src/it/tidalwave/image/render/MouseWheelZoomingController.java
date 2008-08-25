/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2006 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
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
 * $Id: MouseWheelZoomingController.java 516 2007-03-16 22:11:28Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.render;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/*******************************************************************************
 * 
 * This class zooms listening to the mouse wheel.
 *
 * @author  Fabrizio Giudici
 * @version $Id: MouseWheelZoomingController.java 516 2007-03-16 22:11:28Z fabriziogiudici $
 *
 ******************************************************************************/
public class MouseWheelZoomingController 
  {
    /** The attached renderer. */
    private final EditableImageRenderer imageRenderer;
    
    /** The controller for the scale operation. */
    private final ScaleController scaleController;
    
    /** The enablement state. */
    private boolean enabled;
    
    /** How fast the zoom acts with mouse clicks. */
    private double zoomFactor = 0.25;          
            
    /***************************************************************************
     * 
     * Listens to mouse clicks.
     * 
     **************************************************************************/
    private final MouseWheelListener mouseWheelListener = new MouseWheelListener() 
      {
        public void mouseWheelMoved (MouseWheelEvent event) 
          {
            final double changeScale = Math.pow(2, zoomFactor * event.getWheelRotation());
            scaleController.setScale(scaleController.getScale() * changeScale);
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
    public MouseWheelZoomingController (final ScaleController scaleController)
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
                imageRenderer.addMouseWheelListener(mouseWheelListener);  
              }

            else
              {
                imageRenderer.removeMouseWheelListener(mouseWheelListener);  
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
    public boolean isEnabled()
      {
        return enabled;  
      }
    
    public void setZoomFactor (final double zoomFactor)
      {
        this.zoomFactor = zoomFactor;  
      }

    public double getZoomFactor()
      {
        return zoomFactor;  
      }
  }
