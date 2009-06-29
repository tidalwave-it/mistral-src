/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici
 *                        and Emmanuele Sordini
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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import it.tidalwave.image.op.DrawOp;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.render.EditableImageRenderer;
import java.awt.AlphaComposite;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: EditableImageRenderer.java 324 2006-12-21 22:22:23Z fabriziogiudici $
 *
 ******************************************************************************/
public class MarkerTool extends SelectRectangleTool
  {
    private static final Color COLOR = new Color(255, 255, 0);
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public MarkerTool (final EditableImageRenderer imageRenderer)
      {
        super(imageRenderer);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public void execute (final EditableImageRenderer imageRenderer, final EditableImage image) 
      {
        image.execute(new DrawOp(new DrawOp.Executor() 
          {
            public void draw (final Graphics2D g, final EditableImage image) 
              {
                final Rectangle bounds = getBounds();
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                g.setColor(COLOR);
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
              }
          }));
      }
  }
