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
 * $Id: OmissisTool.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.mistral.faxmanager.edittool;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.DrawOp;
import it.tidalwave.image.render.EditableImageRenderer;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: OmissisTool.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class OmissisTool extends SelectRectangleTool
  {
    /***************************************************************************
     *
     *
     **************************************************************************/
    public OmissisTool (final EditableImageRenderer imageRenderer)
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
                Rectangle bounds = getBounds();
                g.setColor(Color.BLACK);
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
              }
          }));
      }
  }
