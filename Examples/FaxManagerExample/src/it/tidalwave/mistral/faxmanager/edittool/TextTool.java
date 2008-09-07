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

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.DrawOp;
import it.tidalwave.image.render.EditableImageRenderer;
import it.tidalwave.image.render.EditingTool;
import java.awt.event.KeyListener;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: EditableImageRenderer.java 324 2006-12-21 22:22:23Z fabriziogiudici $
 *
 ******************************************************************************/
public class TextTool extends EditingTool
  {
    private static final int SCALE = 5;
    private Color color;
    
    private Font font = new Font("sans-serif", Font.PLAIN, 9);
    
    private Point textLocationInImageCoordinates = new Point();
    
    private Point textLocationInViewerCoordinates = new Point();
    
    private final JTextField textField = new JTextField("    ");
    
    private EditableImage image;
    
    /***************************************************************************
     *
     * The textField, when activated, grabs all the key events. This listener
     * still delivers them to the current state.
     *
     **************************************************************************/
    private final KeyListener keyListener = new KeyListener() 
      {
        public void keyTyped (final KeyEvent event) 
          {
            final State state = getCurrentState();
            
            if (state != null)
              {
                state.keyTyped(event);
              }
          }  

        public void keyPressed (final KeyEvent event) 
          {
            final State state = getCurrentState();
            
            if (state != null)
              {
                state.keyPressed(event);
              }
          }

        public void keyReleased (final KeyEvent event)
          {
            final State state = getCurrentState();
            
            if (state != null)
              {
                state.keyReleased(event);
              }
          }
      };
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    class BasicState extends State
      {
        public void changeFont()
          {
          }
        
        protected void setupFont()
          {
            final Font font2 = font.deriveFont((float)(imageRenderer.getScale() * font.getSize2D()) * SCALE);
            final FontMetrics fontMetrics = imageRenderer.getFontMetrics(font2);
            textField.setMargin(new Insets(0, 0, 0, 0));
            final Insets border = textField.getBorder().getBorderInsets(textField);
            final int left = textLocationInViewerCoordinates.x - border.left;
            final int top = textLocationInViewerCoordinates.y - fontMetrics.getAscent() - border.top;
            textField.setBounds(left, top, imageRenderer.getWidth() - left, fontMetrics.getHeight() + border.top + border.bottom);
            textField.setFont(font2);
          }
        
        /***************************************************************************
         *
         *
         **************************************************************************/
        protected void setPosition (final Point point) 
          {
            textLocationInViewerCoordinates = point;
            textLocationInImageCoordinates = imageRenderer.getPositionOverImage(textLocationInViewerCoordinates);
            TextTool.this.image = imageRenderer.getImage();
            setupFont();
            textField.setOpaque(false);
            textField.setText("");
            textField.setMinimumSize(new Dimension(200, 0));
            imageRenderer.add(textField);
            imageRenderer.revalidate();
            imageRenderer.repaint();
            textField.grabFocus();
            setState(EnterTextState.class);
          }
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    class WaitFirstClickState extends BasicState
      {
        @Override
        public void mousePressed (final MouseEvent event) 
          {
            setPosition(event.getPoint());
          }
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    class EnterTextState extends BasicState implements ActionListener
      {
        @Override
        public void start()
          {
            textField.addActionListener(this);
          }
        
        @Override
        public void changeFont()
          {
            setupFont();
//            textField.repaint();
          }

        @Override
        public void mouseClicked (final MouseEvent event) 
          {
            final String text = textField.getText();
            reset();
            setPosition(event.getPoint());
            textField.setText(text);
          }

        @Override
        public void keyTyped (final KeyEvent event)   
          {
            System.err.println("KEY TYPED BEGIN ");
            super.keyTyped(event);
            imageRenderer.getImage().setAttribute(CHANGED_ATTRIBUTE, true);
            System.err.println("KEY TYPED END ");
          }
        
        public void actionPerformed (final ActionEvent event)
          {
            commitChanges();
          }
      }
    
    private final EnterTextState enterTextState = new EnterTextState();
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public TextTool (final EditableImageRenderer imageRenderer)
      {
        super(imageRenderer);
        registerState(new WaitFirstClickState());
        registerState(enterTextState);
        setInitialState(WaitFirstClickState.class);
        setColor(Color.BLACK);
        textField.addKeyListener(keyListener);
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
    public void setFont (final Font font)
      {
        this.font = font;  
        final State state = getCurrentState();
        
        if (state instanceof BasicState)
          {
            ((BasicState)state).changeFont();
          }
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public Font getFont()
      {
        return font;  
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public void deactivate()
      {
        imageRenderer.remove(textField);
        super.deactivate();
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public void imageChanged()
      {
        commitChanges(); 
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public void reset()
      {
        imageRenderer.remove(textField);
        imageRenderer.flushAllCaches();
        image = null;
        super.reset();
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public void commitChanges()
      {
        if (image != null)
          {
            image.setAttribute(CHANGED_ATTRIBUTE, true);
            textField.removeActionListener(enterTextState);
            final String text = textField.getText();
            image.execute(new DrawOp(new DrawOp.Executor()
              {
                public void draw (final Graphics2D g, final EditableImage image) 
                  {
                    g.setColor(Color.BLACK);
                    g.setFont(font.deriveFont((float)(font.getSize2D()) * SCALE));
                    g.drawString(text,textLocationInImageCoordinates.x,textLocationInImageCoordinates.y);
                  }
              }));
              
            reset();
          }
      }
  }
