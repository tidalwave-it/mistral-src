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
