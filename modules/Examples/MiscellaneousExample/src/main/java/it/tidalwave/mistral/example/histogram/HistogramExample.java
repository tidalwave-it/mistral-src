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
package it.tidalwave.mistral.example.histogram;

import it.tidalwave.image.op.ReadOp;
import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Histogram;
import it.tidalwave.image.op.CropOp;
import it.tidalwave.image.op.HistogramOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class HistogramExample 
  {
    private static final String CLASS = HistogramExample.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
    
    public static void main (String[] args)
      throws IOException
      {
        HistogramExample e = new HistogramExample();
        e.process();
      }
    
    public void process() 
      throws IOException
      {
        //
        // Loads the image
        //
        File file = new File("../images/20030701-0043.NEF");
        EditableImage image = EditableImage.create(new ReadOp(file));
        logger.info("Image loaded in " + image.getLatestOperationTime() + " msec");
        //
        // Crops the image
        //
        image.execute(new CropOp(10, 10, 600, 400));
        logger.info("Image cropped in " + image.getLatestOperationTime() + " msec");
        //
        // Computes the histogram
        //
        Histogram histogram = image.execute(new HistogramOp()).getHistogram();  
        logger.info("Histogram computed in " + image.getLatestOperationTime() + " msec");
        //
        // Prints some information item from the histogram
        //
        for (int band = 0; band < histogram.getBandCount(); band++)
          {
            int min = histogram.getMin(band);
            int max = histogram.getMax(band);
            int[] frequencies = histogram.getFrequencies(band);            
            logger.info("band #" + band + ": min=" + min + " max=" + max + " " + frequencies.length + " samples");
          }
      }
  }
