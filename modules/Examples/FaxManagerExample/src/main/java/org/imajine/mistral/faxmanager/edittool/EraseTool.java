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
package org.imajine.mistral.faxmanager.edittool;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import org.imajine.image.EditableImage;
import org.imajine.image.op.DrawOp;
import org.imajine.image.render.EditableImageRenderer;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class EraseTool extends SelectRectangleTool
  {
    /***************************************************************************
     *
     *
     **************************************************************************/
    public EraseTool (final EditableImageRenderer imageRenderer)
      {
        super(imageRenderer);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public void execute (final EditableImageRenderer imageRenderer, final EditableImage image) 
      {
        image.execute(new DrawOp(new DrawOp.Executor() 
          {
            @Override
            public void draw (final Graphics2D g, final EditableImage image) 
              {
                Rectangle bounds = getBounds();
                g.setColor(Color.WHITE);
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
              }
          }));
      }
  }
