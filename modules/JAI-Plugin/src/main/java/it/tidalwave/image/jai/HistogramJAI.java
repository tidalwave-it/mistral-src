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
package it.tidalwave.image.jai;

import java.awt.RenderingHints;
import java.awt.image.DataBuffer;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import javax.media.jai.Histogram;
import javax.media.jai.ROI;
import javax.media.jai.RenderedOp;
import javax.media.jai.operator.HistogramDescriptor;
import it.tidalwave.image.render.PreviewSettings;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class HistogramJAI extends it.tidalwave.image.Histogram
  {
    private RenderedImage renderedImage;
    
    private Histogram delegate;

    private double[] max;

    private double[] min;

    /*******************************************************************************
     * 
     * @param image
     * 
     *******************************************************************************/
    /* package */HistogramJAI (RenderedImage renderedImage)
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
    @Override
    public int[] getFrequencies (int band)
      {
        validateBand(band);
        ensureDataComputed();

        return delegate.getBins(band);
      }

    /*******************************************************************************
     * 
     * @inheritDoc
     * 
     *******************************************************************************/
    @Override
    public int getMin (int band)
      {
        validateBand(band);
        ensureDataComputed();

        return (int)min[band];
      }

    /*******************************************************************************
     * 
     * @inheritDoc
     * 
     *******************************************************************************/
    @Override
    public int getMax (int band)
      {
        validateBand(band);
        ensureDataComputed();

        return (int)max[band];
      }

    /*******************************************************************************
     * 
     * 
     * 
     *******************************************************************************/
    private void ensureDataComputed ()
      {
        synchronized (this)
          {
            if (delegate == null)
              {
                compute();
              }
          }
      }

    /*******************************************************************************
     * 
     * @inheritDoc
     * 
     *******************************************************************************/
    private void compute()
      {
        SampleModel sampleModel = renderedImage.getSampleModel();
        bandCount = sampleModel.getNumBands();

        int bits = DataBuffer.getDataTypeSize(sampleModel.getDataType());

        ROI roi = null;
        int[] bins = new int[bandCount];
        min = new double[bandCount];
        max = new double[bandCount];
        int maxxx = 1 << bits;

        for (int i = 0; i < bandCount; i++)
          {
            bins[i] = maxxx;
            min[i] = 0;
            max[i] = maxxx;
          }

        RenderingHints renderingHints = null;
        Integer xPeriod = new Integer(1);
        Integer yPeriod = new Integer(1);
        RenderedOp op = HistogramDescriptor.create(renderedImage, roi, xPeriod, yPeriod, bins, min, max, renderingHints);
        delegate = (Histogram)op.getProperty("histogram");
      }

    /*******************************************************************************
     * 
     * @inheritDoc
     * 
     *******************************************************************************/
    @Override
    public it.tidalwave.image.Histogram getPreview (PreviewSettings previewSetting)
      {
        throw new RuntimeException("NOT IMPLEMENTED YET!");
      }
  }
