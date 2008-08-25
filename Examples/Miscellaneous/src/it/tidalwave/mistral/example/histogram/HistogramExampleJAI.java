/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2006 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
 *                        and Emmanuele Sordini (Emmanuele@Sordini.com)
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
 * $Id: HistogramExampleJAI.java 181 2006-11-17 16:23:18Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.mistral.example.histogram;

import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.SampleModel;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.media.jai.Histogram;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedOp;
import javax.media.jai.operator.CropDescriptor;
import javax.media.jai.operator.FileLoadDescriptor;
import javax.media.jai.operator.HistogramDescriptor;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: HistogramExampleJAI.java 181 2006-11-17 16:23:18Z fabriziogiudici $
 *
 ******************************************************************************/
public class HistogramExampleJAI 
  {
    private static final String CLASS = HistogramExample.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
    
    public static void main (String[] args)
      throws IOException
      {
        HistogramExampleJAI e = new HistogramExampleJAI();
        e.process();
      }
    
    public void process() 
      throws IOException
      {
        //
        // Loads the image
        //
        File file = new File("../images/20030701-0043.NEF");
        //
        // Doesn't work: the TIFF plugin gets instantiated before the NEF one, and
        // only the thumbnail is loaded. Unfortunately FileLoadDescriptor does not give
        // enough control on the ImageReader.
        //
        //PlanarImage image = FileLoadDescriptor.create(file.getAbsolutePath(), null, true, null);
        ImageInputStream iis = ImageIO.createImageInputStream(file);
        ImageReader ir = ImageIO.getImageReadersBySuffix("NEF").next();
        ir.setInput(iis);
        BufferedImage bufferedImage = ir.read(0);
        iis.close();
        PlanarImage image = PlanarImage.wrapRenderedImage(bufferedImage);
        //
        // Crops the image
        //
        image = CropDescriptor.create(image, 10.0f, 10.0f, 600.0f, 400.0f, null);
        //
        // Computes the histogram
        //
        SampleModel sampleModel = image.getSampleModel();
        int bandCount = sampleModel.getNumBands();
        int bits = DataBuffer.getDataTypeSize(sampleModel.getDataType());
        int[] bins = new int[bandCount];
        double[] min = new double[bandCount];
        double[] max = new double[bandCount];
        int maxxx = 1 << bits;

        for (int i = 0; i < bandCount; i++)
          {
            bins[i] = maxxx;
            min[i] = 0;
            max[i] = maxxx;
          }

        RenderedOp op = HistogramDescriptor.create(image, null, 1, 1, bins, min, max, null);
        Histogram histogram = (Histogram)op.getProperty("histogram");
        //
        // Prints some information item from the histogram
        //
        for (int band = 0; band < bandCount; band++)
          {
            int[] frequencies = histogram.getBins(band);
            logger.info("band #" + band + ": min=" + histogram.getLowValue(band) + 
                                           " max=" + histogram.getHighValue(band) + " " + 
                                             frequencies.length + " samples");
          }
      }
  }
