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
package org.imajine.image;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.Kernel;
import java.awt.image.RenderedImage;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public final class ImageUtils
  {
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public static ICC_Profile getICCProfile (RenderedImage image)
      {
        ColorSpace colorSpace = image.getColorModel().getColorSpace();

        if (colorSpace instanceof ICC_ColorSpace)
          {
            ICC_ColorSpace iccColorSpace = (ICC_ColorSpace)colorSpace;

            return iccColorSpace.getProfile();
          }

        return null;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public static String getICCProfileName (ICC_Profile profile)
      {
        if (profile == null)
          {
            return null;
          }

        byte[] xx = profile.getData(ICC_Profile.icSigProfileDescriptionTag);
        int offset = 12;
        int count;

        for (count = 1; xx[offset + count] != 0; count++)
          {
            ;
          }

        return new String(xx, 0, offset, count);
      }
    
    /*******************************************************************************
     * Generate a square gaussian blur kernel to be used with the convolve Op
     * 
     * @param sigma standard deviation of gaussian bell
     * @param size size (in pixels) of the square filter; if it's an even number,
     *             it is set to the closest greater odd number
     * @return gaussian blur kernel
     ******************************************************************************/    
    public static Kernel gaussianBlurKernel(double sigma, int size)
      {
        // Size od kernel must be an odd number
        if (size%2 == 0)
        {
          size += 1;
        }

        float[] matrix = new float[size*size];
        double sum = 0.0;

        for (int x=-size/2; x <=size/2; x++)
        {
          for (int y=-size/2; y<=size/2; y++)
          {
            double rsq = x*x + y*y;
            double gauss = 1/(Math.sqrt(2*Math.PI)*sigma) * Math.exp(-rsq/(2*sigma*sigma));
            sum += gauss;

            int index = size*(y+size/2) + (x+size/2);
            matrix[index] = (float) gauss;        
          }
        }

        // Normalize the kernel
        for (int i=0; i<matrix.length; i++)
        {
          matrix[i] /= (float) sum;

          System.out.print(matrix[i]);
          if (i%size == 0  && i!=0)
            System.out.println();
          else
            System.out.print(" ");
        }

        return new Kernel(size, size, matrix);
      }

    /*******************************************************************************
     * Generate a square gaussian blur kernel to be used with the JAI
     * convolve operation. The kernel size is calculated automatically based
     * on the standard deviation parameter, so as to comprise a +/- 3*sigma
     * bell around the center
     *
     * @param sigma standard deviation of gaussian bell
     * @return gaussian blur kernel
     ******************************************************************************/    
    public static Kernel gaussianBlurKernel(double sigma)
      {
        int size = 0;    

        if (sigma < 0.5)
          size = 3;
        else if (sigma >= 0.5 && sigma < (5.0/6.0))
          size = 5;
        else if (sigma >= (5.0/6.0) && sigma < (7.0/6.0))
          size = 7;
        else if (sigma >= (7.0/6.0) && sigma < 1.5)
          size = 9;
        else if (sigma >= 1.5 && sigma < (11.0/6.0))
          size = 11;
        else if (sigma >= (11.0/6.0) && sigma < (13.0/6.0))
          size = 13;
        else if (sigma >= (13.0/6.0))
          size = 15;

        Kernel result = gaussianBlurKernel(sigma, size);

        return result;
      }
  
  
}
