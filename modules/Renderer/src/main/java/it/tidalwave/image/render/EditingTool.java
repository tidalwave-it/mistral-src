/*
 * *********************************************************************************************************************
 *
 * Mistral: open source imaging engine
 * http://tidalwave.it/projects/mistral
 *
 * Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
 *
 * *********************************************************************************************************************
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
 * *********************************************************************************************************************
 *
 * git clone https://bitbucket.org/tidalwave/mistral-src
 * git clone https://github.com/tidalwave-it/mistral-src
 *
 * *********************************************************************************************************************
 */
package it.tidalwave.image.render;

import java.util.HashMap;
import java.util.Map;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class EditingTool implements MouseListener, MouseMotionListener, KeyListener, Overlay
  {
    public static final String CHANGED_ATTRIBUTE = EditingTool.class.getName() + ".changed";

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public class State // implements MouseListener, MouseMotionListener
      {
        public void mouseClicked (final MouseEvent event)
          {
          }

        public void mousePressed (final MouseEvent event)
          {
          }

        public void mouseReleased (final MouseEvent event)
          {
          }

        public void mouseEntered (final MouseEvent event)
          {
          }

        public void mouseExited (final MouseEvent event)
          {
          }

        public void mouseDragged (final MouseEvent event)
          {
          }

        public void mouseMoved (final MouseEvent event)
          {
          }

        public void keyTyped (final KeyEvent event)
          {
          }

        public void keyPressed (final KeyEvent event)
          {
            if (event.getKeyCode() == KeyEvent.VK_ESCAPE)
              {
                deactivate();
              }
          }

        public void keyReleased (final KeyEvent event)
          {
            System.err.println("EVENT " + event);
          }

        public void paint (final Graphics2D g, final EditableImageRenderer imageRenderer)
          {
          }

        public void start()
          {
          }

        public void stop()
          {
          }
      }

    protected final EditableImageRenderer imageRenderer;

    private final Map<Class<? extends State>, State> stateMap = new HashMap<Class<? extends State>, State>();

    private final State NULL_STATE = new State();

    private State state = NULL_STATE;

    private Class<? extends State> initialState;

    private boolean active = false;

    private boolean oneShot = false;

    private Icon icon;

    private final JToggleButton.ToggleButtonModel buttonModel = new JToggleButton.ToggleButtonModel();

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private final Action action = new AbstractAction()
      {
        @Override
        public void actionPerformed (final ActionEvent event)
          {
            if (!active)
              {
                activate();
              }

            else
              {
                deactivate();
              }
          }
      };

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected EditingTool (final EditableImageRenderer imageRenderer)
      {
        this.imageRenderer = imageRenderer;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setEnabled (final boolean enabled)
      {
        action.setEnabled(enabled);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public boolean isEnabled()
      {
        return action.isEnabled();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public boolean isActive()
      {
        return active;
      }

    /*******************************************************************************************************************
     *
     * Programmatically commits the changes. E.g. called by the save of an image
     * editor when a tools is currently on.
     *
     ******************************************************************************************************************/
    public void commitChanges()
      {
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void activate()
      {
        if (active)
          {
            throw new IllegalStateException("Already active");
          }

        if (imageRenderer.editingTool != null)
          {
            imageRenderer.editingTool.deactivate();
          }

        active = true;
        buttonModel.setSelected(true);
        setState(initialState);
        imageRenderer.addMouseListener(this);
        imageRenderer.addMouseMotionListener(this);
        imageRenderer.addKeyListener(this);
        imageRenderer.addOverlay(this);
        imageRenderer.setCursor(makeCursor(icon, "xxx"));
        imageRenderer.fireEditingToolActivated(this);
        imageRenderer.editingTool = this;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void deactivate()
      {
        if (!active)
          {
            throw new IllegalStateException("Not active");
          }

        active = false;
        buttonModel.setSelected(false);
        imageRenderer.removeMouseListener(this);
        imageRenderer.removeMouseMotionListener(this);
        imageRenderer.removeKeyListener(this);
        imageRenderer.removeOverlay(this);
        imageRenderer.repaint();
        imageRenderer.setCursor(null);
        imageRenderer.fireEditingToolDeactivated(this);
        imageRenderer.editingTool = null;
      }

    /*******************************************************************************************************************
     *
     * Invoked when the renderer changes the image being edited by this tool.
     * By default, the tool is deactivated (by invoking 
     * <code>deactivate()</code>), but you can change the default behaviour by
     * overriding this method (for instance, committing changes).
     *
     ******************************************************************************************************************/
    public void imageChanged()
      {
        deactivate();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void reset()
      {
        if (oneShot)
          {
            deactivate();
          }

        else
          {
            imageRenderer.repaint();
            setState(initialState);
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setIcon (final Icon icon)
      {
        this.icon = icon;
        action.putValue(Action.SMALL_ICON, icon);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public final boolean isVisible()
      {
        return true;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void connectButton (final JToggleButton button)
      {
        action.putValue(Action.SHORT_DESCRIPTION, button.getToolTipText());
        button.setAction(action);
        button.setModel(buttonModel);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected void setInitialState (final Class<? extends State> initialStateClass)
      {
        this.initialState = initialStateClass;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected void setState (final Class<? extends State> newStateClass)
      {
        if (state != null)
          {
            state.stop();
          }

        final State newState = stateMap.get(newStateClass);

        if (newState == null)
          {
            throw new IllegalArgumentException("Invalid or unregistered state: " + newStateClass);
          }

        this.state = newState;
        state.start();
        System.err.println("CURRENT STATE: " + this.state);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected State getCurrentState()
      {
        return state;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected void registerState (final State state)
      {
        stateMap.put(state.getClass(), state);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected void repaint()
      {
        imageRenderer.repaint();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected Cursor makeCursor (final Icon icon, final String name)
      {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Image image = ((ImageIcon)icon).getImage();
        return toolkit.createCustomCursor(image, new Point(0, 0), name);
      }

    //// The following methods just delegate to the current State

    @Override
    public final void mouseClicked (final MouseEvent event)
      {
        state.mouseClicked(event);
      }

    @Override
    public final void mousePressed (final MouseEvent event)
      {
        state.mousePressed(event);
      }

    @Override
    public final void mouseReleased (final MouseEvent event)
      {
        state.mouseReleased(event);
      }

    @Override
    public final void mouseEntered (final MouseEvent event)
      {
        state.mouseEntered(event);
      }

    @Override
    public final void mouseExited (final MouseEvent event)
      {
        state.mouseExited(event);
      }

    @Override
    public final void mouseDragged (final MouseEvent event)
      {
        state.mouseDragged(event);
      }

    @Override
    public final void mouseMoved (final MouseEvent event)
      {
        state.mouseMoved(event);
      }

    @Override
    public final void keyTyped (final KeyEvent event)
      {
        state.keyTyped(event);
      }

    @Override
    public final void keyPressed (final KeyEvent event)
      {
        state.keyPressed(event);
      }

    @Override
    public final void keyReleased (final KeyEvent event)
      {
        state.keyReleased(event);
      }

    @Override
    public final void paint (final Graphics2D g, final EditableImageRenderer imageRenderer)
      {
        state.paint(g, imageRenderer);
      }
  }