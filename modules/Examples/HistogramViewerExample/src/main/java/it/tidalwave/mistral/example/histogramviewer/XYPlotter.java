/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2023 by Tidalwave s.a.s.
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
package it.tidalwave.mistral.example.histogramviewer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import it.tidalwave.image.render.Overlay;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class XYPlotter extends JComponent
  {
    class DataBundle
      {
        private int[] data;

        private Color color;

        public DataBundle (int[] data, Color color)
          {
            this.data = data;
            this.color = color;
          }

        public int[] getData ()
          {
            return data;
          }

        public Color getColor ()
          {
            return color;
          }
      }

    private Map dataMap = new HashMap();

    private List dataList = new ArrayList(); // needed to keep the order

    private int max;

    private int min;

    private BufferedImage buffer;

    private Overlay overlay;

    public final static int LINEAR = 0;

    public final static int LOG = 1;

    private int xMode = LINEAR;

    private int logXBands = 2;

    private boolean area = false;

    public XYPlotter()
      {
        setOpaque(false);
      }
    
    /*******************************************************************************
     * 
     * 
     * 
     *******************************************************************************/
    public void setXAxisLinear ()
      {
        this.xMode = LINEAR;
      }

    /*******************************************************************************
     * 
     * @param logXBands
     * 
     *******************************************************************************/
    public void setXAxisLogarithmic (int logXBands)
      {
        this.logXBands = logXBands;
        this.xMode = LOG;
      }

    /*******************************************************************************
     * 
     * 
     * 
     *******************************************************************************/
    public void setAreaPlot ()
      {
        area = true;
      }

    /*******************************************************************************
     * 
     * @return
     * 
     *******************************************************************************/
    public boolean isXAxisLogarithmic ()
      {
        return xMode == LOG;
      }

    /*******************************************************************************
     * 
     * 
     * 
     *******************************************************************************/
    public void clearData ()
      {
        dataList.clear();
        dataMap.clear();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        buffer = null;
      }

    /*******************************************************************************
     * 
     * @param key
     * @param data
     * @param color
     * 
     *******************************************************************************/
    public void addUnsignedData (Object key, short[] data, Color color)
      {
        int[] data2 = new int[data.length];

        for (int i = 0; i < data.length; i++)
          {
            data2[i] = data[i] & 0xffff;
          }

        addData(key, data2, color);
      }

    /*******************************************************************************
     * 
     * @param key
     * @param data
     * @param color
     * 
     *******************************************************************************/
    public void addData (Object key, int[] data, Color color)
      {
        buffer = null;
        int[] myData = new int[data.length];
        System.arraycopy(data, 0, myData, 0, data.length);

        for (int i = 0; i < myData.length; i++)
          {
            int d = myData[i];
            max = Math.max(max, d);
            min = Math.min(min, d);
          }

        dataMap.put(key, new DataBundle(myData, color));
        dataList.add(key);

        if (isVisible())
          repaint();

        //        System.err.println("Data: " + data.length + " max: " + max + " min: " + min);
      }

    /*******************************************************************************
     * 
     * @inheritDoc
     * 
     *******************************************************************************/
    @Override
    public void paint (Graphics g)
      {
        if ((buffer == null) || (buffer.getWidth() != getWidth()) || (buffer.getHeight() != getHeight()))
          {
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = null;

            try
              {
                g2 = (Graphics2D)buffer.getGraphics();

                if (!area)
                  {
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                  }

                else
                  {
                    //g2.setComposite(AlphaComposite.Xor);
                  }

                plot(g2);
              }

            finally
              {
                g2.dispose();
              }
          }

        if (buffer != null)
          {
            g.drawImage(buffer, 0, 0, null);
          }

        else
          plot(g);
      }

    /*******************************************************************************
     *
     * Sets an overlay to overimpose to the image.
     *
     * @param  overlay  the overlay
     *
     ******************************************************************************/
    public void setOverlay (Overlay overlay)
      {
        this.overlay = overlay;
      }

    /*******************************************************************************
     * 
     * @param g
     * 
     *******************************************************************************/
    private void plot (Graphics g)
      {
        Graphics2D g2 = (Graphics2D)g.create();

        try
          {
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(new Color(0, 0, 0, 0));
            g.fillRect(0, 0, width, height);

            if (overlay != null)
              {
//                overlay.paint(g, getBounds());
              }

            int xMin = 0;
            double f = 0;

            if (xMode == LOG)
              {
                double xMinNorm = 1 / Math.pow(2, logXBands);
                f = 1.0 / (logXBands * Math.log(2));
                xMin = (int)Math.round(xMinNorm * width);
              }

            else if (xMode == LINEAR)
              {
                xMin = 0;
              }

            int yMax = Integer.MIN_VALUE;

            for (Iterator j = dataList.iterator(); j.hasNext();)
              {
                Object key = j.next();
                DataBundle dataBundle = (DataBundle)dataMap.get(key);
                int[] data = dataBundle.getData();

                for (int i = xMin; i < data.length; i++)
                  {
                    yMax = Math.max(yMax, data[i]);
                  }
              }

            double yScale = (double)height / (double)yMax;

            for (Iterator j = dataMap.values().iterator(); j.hasNext();)
              {
                DataBundle dataBundle = (DataBundle)j.next();
                g.setColor(dataBundle.getColor());
                int[] data = dataBundle.getData();
                int mask = dataBundle.getColor().getRGB();

                boolean first = true;
                int length = data.length;
                double xScale = (double)width / (double)length;
                int prevX = 0, prevY = 0;

                for (int i = xMin; i < length; i++)
                  {
                    int x = 0;

                    if (xMode == LINEAR)
                      {
                        x = (int)Math.round(i * xScale);
                      }

                    else if (xMode == LOG)
                      {
                        double xNorm = (double)i / (double)length;
                        xNorm = 1 + Math.log(xNorm) * f;
                        x = (int)Math.round(xNorm * width);
                      }

                    int y = height - (int)Math.round(data[i] * yScale);

                    if (!first)
                      {
                        if (!area)
                          {
                            g.drawLine(prevX, prevY, x, y);
                          }

                        else
                          {
                            for (int xx = prevX; xx < x; xx++)
                              {
                                for (int yy = y; yy < height; yy++)
                                  {
                                    int rgb = buffer.getRGB(xx, yy);
                                    buffer.setRGB(xx, yy, rgb | mask);
                                  }

                                //g.drawLine(x, height, x, y);
                              }
                          }
                      }

                    prevX = x;
                    prevY = y;
                    first = false;
                  }
              }
          }

        finally
          {
            g2.dispose();
          }
      }
  }
