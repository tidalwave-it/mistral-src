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

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import it.tidalwave.image.Histogram;
import lombok.extern.slf4j.Slf4j;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
@Slf4j
public class HistogramRenderer extends JPanel
  {
    private static final String COMPUTING = "COMPUTING";

    private static final String EMPTY = "EMPTY";

    private static final String HISTOGRAM = "HISTOGRAM";

    private final JLabel lbComputing = new JLabel("", JLabel.CENTER);

    private final JLabel lbEmpty = new JLabel();

    private final XYPlotter histogramPlotter = new XYPlotter();

    private final HistogramGrid grid = new HistogramGrid();

    private Histogram histogram;

    private final CardLayout cardLayout = new CardLayout();

    /*******************************************************************************
     * 
     * 
     * 
     *******************************************************************************/
    public HistogramRenderer ()
      {
        build();
        lbEmpty.setOpaque(false);
        lbComputing.setOpaque(false);
        histogramPlotter.setOpaque(false);
        clear();
      }

    /*******************************************************************************
     * 
     * @return Returns the histogram.
     * 
     *******************************************************************************/
    public Histogram getHistogram()
      {
        return histogram;
      }

    /*******************************************************************************
     * 
     * 
     * 
     *******************************************************************************/
    public void start()
      {
        lbComputing.setText("Computing histogram...");
      }
    
    /*******************************************************************************
     * 
     * 
     * 
     *******************************************************************************/
    public void clear()
      {
        cardLayout.show(this, EMPTY);
      }
    
    /*******************************************************************************
     * 
     * 
     * 
     *******************************************************************************/
    public void showComputing()
      {
        cardLayout.show(this, COMPUTING);
      }

    /*******************************************************************************
     * 
     * @param histogram
     * 
     *******************************************************************************/
    public void setHistogram (final Histogram histogram)
      {
        this.histogram = histogram;

        SwingUtilities.invokeLater(new Runnable()
          {
            @Override
            public void run ()
              {
                log.trace(">>>> histogram ready...");
                histogramPlotter.clearData();
                //histogramPlotter.setXAxisLogarithmic(6);
                histogramPlotter.setXAxisLinear();
                grid.setHSteps(6);

                final int bandCount = histogram.getBandCount();

                if (bandCount == 1)
                  {
                    histogramPlotter.addData("GRAY", histogram.getFrequencies(0), Color.WHITE);
                  }

                else if (bandCount == 3)
                  {
                    histogramPlotter.addData("RED", histogram.getFrequencies(0), Color.RED);
                    histogramPlotter.addData("GREEN", histogram.getFrequencies(1), Color.GREEN);
                    histogramPlotter.addData("BLUE", histogram.getFrequencies(2), Color.BLUE);
                  }

                cardLayout.show(HistogramRenderer.this, HISTOGRAM);
                log.trace(">>>> showing histogram...");
              }
          });
      }
    
    /*******************************************************************************
     * 
     * 
     * 
     *******************************************************************************/
    private void build()
      {
        setLayout(cardLayout);
        setBackground(Color.GRAY);
        setForeground(Color.LIGHT_GRAY);
        lbComputing.setBackground(getBackground());
        lbComputing.setForeground(getForeground());
        lbComputing.setOpaque(true);
        lbEmpty.setBackground(getBackground());
        lbEmpty.setForeground(getForeground());
        lbEmpty.setOpaque(true);
        histogramPlotter.setBackground(getBackground());
        histogramPlotter.setAreaPlot();
        grid.setColor(Color.DARK_GRAY);
////        histogramPlotter.setOverlay(grid);
        grid.sethistogramPlotter(histogramPlotter);
        add(lbEmpty, EMPTY);
        add(lbComputing, COMPUTING);
        add(histogramPlotter, HISTOGRAM);
        final Dimension dimension = new Dimension(340, 80);
        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setSize(dimension);
      }
  }
