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
 * $Id: HistogramJava2D.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.java2d;

import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import it.tidalwave.image.Histogram;
import it.tidalwave.image.render.PreviewSettings;


/*******************************************************************************
 *
 * @author  fritz
 * @version CVS $Id: HistogramJava2D.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class HistogramJava2D extends Histogram
  {
    private final static String CLASS = HistogramJava2D.class.getName();
    private final static Logger logger = Logger.getLogger(CLASS);
    private RenderedImage renderedImage;
    private int[][] bandData;
    private int[] max;
    private int[] min;
    private int shift;

    /*******************************************************************************
     *
     * @param image
     *
     *******************************************************************************/

    /* package */ HistogramJava2D (RenderedImage renderedImage)
      {
        super(renderedImage);
        this.renderedImage = renderedImage;
        compute();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     *******************************************************************************/
    public int[] getFrequencies (int band)
      {
        validateBand(band);

        synchronized (this)
          {
            if (bandData == null)
              {
                compute();
              }
          }

        return bandData[band];
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     *******************************************************************************/
    public int getMin (int band)
      {
        validateBand(band);

        return min[band];
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     *******************************************************************************/
    public int getMax (int band)
      {
        validateBand(band);

        return max[band];
      }

    /*******************************************************************************
     *
     *******************************************************************************/
    private void compute ()
      {
        logger.info("compute()");
        bandCount = renderedImage.getSampleModel().getNumBands();
        bitsPerBand = renderedImage.getSampleModel().getSampleSize(0);
        shift = 0;

        if (bitsPerBand == 16)
          {
            shift = 16 - 8; // FIXME: should be only for 12bbp files such as NEF 
          }

        bandData = new int[bandCount][1 << (bitsPerBand - shift)];
        min = new int[bandCount];
        max = new int[bandCount];
        logger.info(">>>> Allocated bandData[" + bandData.length + "][" + bandData[0].length + "]");
        genericCompute();

        //DataBuffer dataBuffer = raster.getDataBuffer();
        //int dataBufferSize = DataBuffer.getDataTypeSize(dataBuffer.getDataType());
        //        if (dataBuffer instanceof DataBufferInt)
        //            DataBufferInt dbs = (DataBufferInt)dataBuffer;
        //            int[][] bankData = dbs.getBankData();
        //            logger.info(">>>> bankData[" + bankData.length + "][" + bankData[0].length + "]");
        //            int[] offsets = dbs.getOffsets();
        //            int scanStride = w;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     *******************************************************************************/
    public it.tidalwave.image.Histogram getPreview (PreviewSettings previewSetting)
      {
        HistogramJava2D previewHistogram = new HistogramJava2D(null);
        previewHistogram.bandCount = bandCount;
        previewHistogram.bandData = new int[bandCount][];

        byte[][] lut8bit = previewSetting.getLookupTable8bit().getTable();
        short[][] lut16bit = previewSetting.getLookupTable16bit().getTable();

        for (int band = 0; band < bandCount; band++)
          {
            int len = bandData[band].length;
            previewHistogram.bandData[band] = new int[len];

            for (int i = 0; i < len; i++)
              {
                int dst = (len <= 256) ? (lut8bit[band][i] & 0xff) : (lut16bit[band][i] & 0xffff);
                previewHistogram.bandData[band][dst] += bandData[band][i];
              }
          }

        return previewHistogram;
      }

    /*******************************************************************************
     *
     * Works with every kind of data buffer, but it's not fast.
     *
     * @param raster
     * @param shift
     * @param w
     * @param h
     * @param first
     *
     *******************************************************************************/
    private void genericCompute ()
      {
        Raster raster = ((BufferedImage)image).getRaster();
        int w = renderedImage.getWidth();
        int h = renderedImage.getHeight();
        boolean first = true;

        for (int y = 0; y < h; y++)
          {
            for (int x = 0; x < w; x++)
              {
                for (int b = 0; b < bandCount; b++)
                  {
                    int v = raster.getSample(x, y, b) >> shift;

                    bandData[b][v]++;

                    if (first)
                      {
                        min[b] = max[b] = v;
                      }

                    else
                      {
                        if (v < min[b])
                          {
                            min[b] = v;
                          }

                        else if (v > max[b])
                          {
                            max[b] = v;
                          }
                      }
                  }

                first = false;
              }
          }
      }
  }
