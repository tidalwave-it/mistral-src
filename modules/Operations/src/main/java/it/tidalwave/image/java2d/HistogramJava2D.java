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
package it.tidalwave.image.java2d;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import it.tidalwave.image.Histogram;
import it.tidalwave.image.render.PreviewSettings;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class HistogramJava2D extends Histogram
  {
    private RenderedImage renderedImage;
    private int[][] bandData;
    private int[] max;
    private int[] min;
    private int shift;

    /*******************************************************************************************************************
     *
     * @param image
     *
     ******************************************************************************************************************/

    /* package */ HistogramJava2D (final RenderedImage renderedImage)
      {
        super(renderedImage);
        this.renderedImage = renderedImage;
        compute();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public int[] getFrequencies (final int band)
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

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public int getMin (final int band)
      {
        validateBand(band);

        return min[band];
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public int getMax (final int band)
      {
        validateBand(band);

        return max[band];
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    private void compute()
      {
        log.info("compute()");
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
        log.info(">>>> Allocated bandData[" + bandData.length + "][" + bandData[0].length + "]");
        genericCompute();

        //DataBuffer dataBuffer = raster.getDataBuffer();
        //int dataBufferSize = DataBuffer.getDataTypeSize(dataBuffer.getDataType());
        //        if (dataBuffer instanceof DataBufferInt)
        //            DataBufferInt dbs = (DataBufferInt)dataBuffer;
        //            int[][] bankData = dbs.getBankData();
        //            log.info(">>>> bankData[" + bankData.length + "][" + bankData[0].length + "]");
        //            int[] offsets = dbs.getOffsets();
        //            int scanStride = w;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public it.tidalwave.image.Histogram getPreview (final PreviewSettings previewSetting)
      {
        final var previewHistogram = new HistogramJava2D(null);
        previewHistogram.bandCount = bandCount;
        previewHistogram.bandData = new int[bandCount][];

        final var lut8bit = previewSetting.getLookupTable8bit().getTable();
        final var lut16bit = previewSetting.getLookupTable16bit().getTable();

        for (var band = 0; band < bandCount; band++)
          {
            final var len = bandData[band].length;
            previewHistogram.bandData[band] = new int[len];

            for (var i = 0; i < len; i++)
              {
                final var dst = (len <= 256) ? (lut8bit[band][i] & 0xff) : (lut16bit[band][i] & 0xffff);
                previewHistogram.bandData[band][dst] += bandData[band][i];
              }
          }

        return previewHistogram;
      }

    /*******************************************************************************************************************
     *
     * Works with every kind of data buffer, but it's not fast.
     *
     * @param raster
     * @param shift
     * @param w
     * @param h
     * @param first
     *
     ******************************************************************************************************************/
    private void genericCompute()
      {
        final Raster raster = ((BufferedImage)image).getRaster();
        final var w = renderedImage.getWidth();
        final var h = renderedImage.getHeight();
        var first = true;

        for (var y = 0; y < h; y++)
          {
            for (var x = 0; x < w; x++)
              {
                for (var b = 0; b < bandCount; b++)
                  {
                    final var v = raster.getSample(x, y, b) >> shift;

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
