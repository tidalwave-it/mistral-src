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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.mistral.faxmanager;

import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import org.imajine.image.EditableImage;
import org.imajine.image.op.ConvertToBufferedImageOp;
import org.imajine.image.op.DrawOp;
import org.imajine.image.op.ScaleOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ThumbnailListCellRenderer extends DefaultListCellRenderer
  {
    public static enum Mode
      {
        WITH_THUMBNAILS
          {
            @Override
            public void setListItem (final JList list, final int pageNumber, final JLabel label, final EditableImage page, final Map<EditableImage, Icon> thumbnailCache)
              {
                Icon thumbnail = thumbnailCache.get(page);

                if (thumbnail == null)
                  {
                    final int width = list.getWidth() - 40;
                    final double scale = (double)width / Math.max(page.getWidth(), page.getHeight());
                    final EditableImage temp = page.execute2(new ScaleOp(scale));
                    temp.execute(new DrawOp(new DrawOp.Executor()
                      {
                        @Override
                        public void draw (final Graphics2D g, final EditableImage image) 
                          {
                            g.setColor(Color.RED);
                            g.drawRect(0, 0, temp.getWidth() - 1, temp.getHeight() - 1);
                          }
                      }));

                    thumbnail = new ImageIcon(temp.execute(new ConvertToBufferedImageOp()).getBufferedImage());
                    thumbnailCache.put(page, thumbnail);
                  }

                label.setIcon(thumbnail);
                label.setText("# " + pageNumber);
              }
          },
        WITHOUT_THUMBNAILS
          {
            @Override
            public void setListItem (final JList list, final int pageNumber, final JLabel label, final EditableImage page, final Map<EditableImage, Icon> thumbnailCache)
              {
                label.setText("Pag. " + pageNumber);
              }
          };
          
        public abstract void setListItem (final JList list, final int index, final JLabel label, final EditableImage page, final Map<EditableImage, Icon> thumbnailCache);
      };
      
    private final Mode mode;
    private PageManager pageManager;
    private final Map<EditableImage, Icon> thumbnailCache = new HashMap<EditableImage, Icon>();
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public ThumbnailListCellRenderer (final Mode mode)
      {
        this.mode = mode;
      }
    
    public void setPageManager (final PageManager pageManager)
      {
        this.pageManager = pageManager;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void clear()
      {
        thumbnailCache.clear();  
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override    
    public Component getListCellRendererComponent (final JList list,
                                                   final Object value, 
                                                   final int index,
                                                   final boolean isSelected, 
                                                   final boolean cellHasFocus) 
      {
        final JLabel label = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        final EditableImage page = (EditableImage)value;
        mode.setListItem(list, pageManager.getVisiblePageNumbers().get(index) + 1, label, page, thumbnailCache);
        return label;
      }
  }
