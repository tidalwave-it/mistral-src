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

import it.tidalwave.mistral.faxmanager.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.CropOp;
import it.tidalwave.image.render.EditableImageRenderer;
import it.tidalwave.image.render.EditingTool;
import it.tidalwave.image.render.EditingTool.State;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: EditableImageRenderer.java 324 2006-12-21 22:22:23Z fabriziogiudici $
 *
 ******************************************************************************/
public class CutterTool extends EditingTool
  {
    private Point latestPosition;
    
    private final List<Integer> cuttingPoints = new ArrayList<Integer>();
    
    private final PageManager pageManager;
    
    private final ListSelectionModel pageSelectionModel;
    
    private Color cutterColor = Color.RED;
    
    private Stroke strokeColor = new BasicStroke(2.0f);
    
    private Color mobileColor = Color.RED;
    
    private Stroke mobileStroke = new BasicStroke(2.0f);
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    private final Action endCutterAction = new AbstractAction() 
      {
        public void actionPerformed (final ActionEvent event) 
          {
            final String title = "Conferma";
            final String message = "Vuoi veramente ritagliare il documento?";
            int r = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);

            if (r == JOptionPane.OK_OPTION)
              {
                execute();
              }

            if (isActive())
              {
                deactivate();
              }
          }
      };
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    class PlaceCutterState extends State
      {
        /***********************************************************************
         * 
         * 
         **********************************************************************/
        @Override
        public void start() 
          {
            cuttingPoints.clear();
            endCutterAction.setEnabled(true);
          }
        
        /***********************************************************************
         * 
         * Record the latest position.
         * 
         **********************************************************************/
        @Override
        public void mouseMoved (final MouseEvent event) 
          {
            latestPosition = imageRenderer.getPositionOverImage(event.getPoint());
            repaint(); // FIXME: should be not needed
          }
        
        /***********************************************************************
         * 
         * On double click, add the current position to the list of cutting
         * points.
         * 
         **********************************************************************/
        @Override
        public void mouseClicked (final MouseEvent event) 
          {
            if (event.getClickCount() == 2)
              {
                latestPosition = imageRenderer.getPositionOverImage(event.getPoint());
                
                if (latestPosition != null)
                  {
                    cuttingPoints.add((int)latestPosition.getY());
                    repaint(); // FIXME: should be not needed
                  }
              }
          }
        
        /***********************************************************************
         * 
         * Paints both the cutting points and the current position.
         * 
         **********************************************************************/
        @Override
        public final void paint (final Graphics2D g, final EditableImageRenderer imageRenderer) 
          {
            if (latestPosition != null)
              {
                g.setColor(mobileColor);
                g.setStroke(mobileStroke);
                drawCutterLine(g, (int)latestPosition.getY());
              }
            
            g.setColor(cutterColor);
            g.setStroke(strokeColor);
            
            for (int y : cuttingPoints)
              {
                drawCutterLine(g, y);
              }
          }

        /***********************************************************************
         * 
         * Draws a cutter line.
         * 
         **********************************************************************/
        private void drawCutterLine (final Graphics2D g, final int y) 
          {
            int width = imageRenderer.getImage().getWidth();
            Point p1 = imageRenderer.convertImagePointToComponentPoint(new Point(0, y));
            Point p2 = imageRenderer.convertImagePointToComponentPoint(new Point(width - 1, y));
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
          }
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public CutterTool (final EditableImageRenderer imageRenderer, 
                       final PageManager pageManager,
                       final ListSelectionModel pageSelectionModel)  
      {
        super(imageRenderer);
        registerState(new PlaceCutterState());
        setInitialState(PlaceCutterState.class);
        this.pageManager = pageManager;
        this.pageSelectionModel = pageSelectionModel;
        endCutterAction.setEnabled(false);
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void addEndActionButton (final JButton button) 
      {
        button.setAction(endCutterAction);
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void setEndActionIcon (final Icon icon)
      {
        endCutterAction.putValue(Action.SMALL_ICON, icon);
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public void deactivate()
      {
        super.deactivate();
        endCutterAction.setEnabled(false);
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void execute()
      {
        List<EditableImage> result = new ArrayList<EditableImage>();  
        EditableImage originalImage = imageRenderer.getImage();
        int prevY = 0;
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        
        for (int y : cuttingPoints)
          {
            result.add(originalImage.execute2(new CropOp(0, prevY, width, y - prevY)));
            prevY = y;
          }
        
        result.add(originalImage.execute2(new CropOp(0, prevY, width, height - prevY)));     
        
        // replace the current image with the first cut
        int pageNumber = pageManager.getPageNumber();
        pageManager.storeImage(result.get(0), pageNumber++);
        imageRenderer.setImage(result.get(0));
        pageManager.forceSelectedImage(result.get(0));
        // insert new pages
                
        for (EditableImage image2 : result.subList(1, result.size()))
          {
            pageManager.insertImage(image2, pageNumber++);
            image2.dispose();
          } 
      }
  }
