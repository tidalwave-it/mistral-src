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
/*
 * OverlaidPanel.java
 *
 * Created on January 28, 2007, 5:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package it.tidalwave.mistral.example.viewer;

import java.awt.Graphics2D;
import javax.swing.JPanel;
import it.tidalwave.image.render.EditableImageRenderer;
import it.tidalwave.image.render.Overlay;

/**
 *
 * Doesn't work (yet).
 * @author fritz
 */
public class OverlaidPanel extends JPanel implements Overlay
  {
    public OverlaidPanel()
      {  
        setOpaque(false);
        setVisible(true);
      }
    
    public final void paint (final Graphics2D g, final EditableImageRenderer imageRenderer) 
      {
        setBounds(imageRenderer.getBounds());
        validate();
        System.err.println(this);
        paintComponents(g);
      }
  }
