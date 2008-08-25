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
 * $Id: JAIUtils.java 591 2007-04-06 20:48:00Z esordini $
 * 
 ******************************************************************************/
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;
import javax.media.jai.BorderExtender;
import javax.media.jai.Interpolation;
import javax.media.jai.KernelJAI;
import javax.media.jai.LookupTableJAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.TiledImage;
import javax.media.jai.operator.BorderDescriptor;
import javax.media.jai.operator.ColorConvertDescriptor;
import javax.media.jai.operator.ConvolveDescriptor;
import javax.media.jai.operator.LookupDescriptor;
import javax.media.jai.operator.ScaleDescriptor;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.java2d.Java2DUtils;
import java.awt.image.Raster;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @author  Emmanuele Sordini
 * @version $Id: JAIUtils.java 591 2007-04-06 20:48:00Z esordini $
 *
 ******************************************************************************/
public class JAIUtils extends Java2DUtils
  {
    private static final String CLASS = JAIUtils.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
    
    private static final int[] POWER2_SIZES = 
      {
        32, 64, 128, 256, 512, 1024, 2048, 4096, 8192
      };  
         
    /*******************************************************************************
     *
     * Apply a JAI Scale operation.
     *
     * @param scale     the scale
     * @param quality   the quality
     * @param hints     the RenderingHints
     *
     ******************************************************************************/
    public static PlanarImage jaiMagnification (final PlanarImage source,
                                                final double scale,
                                                final Quality quality,
                                                final RenderingHints hints)
      {
        assert scale >= 1;

        PlanarImage result = source;

        if (scale != 1)
          {
            logger.finer(">>>> jaiMagnification(" + scale + ", " + quality + ")");

            final Float fScale = new Float(scale);
            final Float fZero = new Float(0);
            Interpolation interpolation = null;

            switch (quality)
              {
                case BEST:
                    interpolation = Interpolation.getInstance(Interpolation.INTERP_BICUBIC_2);
                    break;
                   
                case FASTEST:
                    interpolation = Interpolation.getInstance(Interpolation.INTERP_NEAREST);
                    break;
                    
                default:
                    throw new IllegalArgumentException(quality.toString());
              }
            
            logger.finer(">>>> Scale(" + scale + ", " + interpolation + ")");

            result = ScaleDescriptor.create(source, fScale, fScale, fZero, fZero, interpolation, hints);
            logImage(logger, ">>>>>>>>    planarImage", result);
          }

        return result;
      }

    /*******************************************************************************
     *
     * Reduces the size of the given PlanarImage. This method applies distinct
     * strategies in function of the scale and the quality. They are described in
     * http://archives.java.sun.com/cgi-bin/wa?A2=ind0311&L=jai-interest&P=R9579&I=-3
     *
     * If quality == Quality.FASTEST, a JAI Scale operation is performed with
     * nearest neighbor interpolation. This gives poor results but it's fast.
     *
     * If quality == Quality.BEST, we choose in function of the scale.
     * If scale is in the range (0.5, 1), only a JAI Scale operation is applied with
     * bilinear interpolation.
     * If scale is in the range (0, 0.5], a low pass filter is first applied. Then
     * a Scale operation is performed with nearest neighbor interpolation.
     *
     * This is probably what SubsampleAverage would do in a single pass, but it
     * does not work in JAI 1.1.2_01 (will throw an ArrayIndexOutOfBoundsException
     * when operation are committed such as in getAsBufferedImage()) - bug #4857245.
     * FIXME: convert to SubsampleAverage when the bug will be fixed.
     *
     * In any case, if scale == 1, no operation is performed.
     *
     * @param source    the source image
     * @param scale     the scale (must be < 1)
     * @param quality   the quality of the operation (Quality.FASTEST or Quality.BEST)
     * @param hints     the RenderingHints
     * @return          the processed image
     *
     ******************************************************************************/
    public static PlanarImage jaiReduction (final PlanarImage source,
                                            final double scale,
                                            final Quality quality,
                                            final RenderingHints hints)
      {
        assert scale <= 1;

        PlanarImage result = source;

        if (scale != 1)
          {
            Float fScale = new Float(scale);
            logger.finer(">>>> jaiReduction(" + scale + ")");

            Integer iPad = new Integer(10); // FIXME
            BorderExtender borderExtender = BorderExtender.createInstance(BorderExtender.BORDER_COPY);
            logger.finer(">>>>>>>> Border(" + iPad + ")");
            result = BorderDescriptor.create(result, iPad, iPad, iPad, iPad, borderExtender, hints);

            switch (quality)
              {
                case FASTEST:
                    Interpolation interpolation = Interpolation.getInstance(Interpolation.INTERP_NEAREST);
                    logger.finer(">>>>>>>> Scale(" + scale + ", " + interpolation + ")");
                    result = ScaleDescriptor.create(result, fScale, fScale, ZERO, ZERO, interpolation, hints);
                    break;
                  
                case BEST:
                    if (scale > 0.5)
                      {
                        interpolation = Interpolation.getInstance(Interpolation.INTERP_BILINEAR);
                        logger.finer(">>>>>>>> Scale(" + scale + ", " + interpolation + ")");
                        result = ScaleDescriptor.create(result, fScale, fScale, ZERO, ZERO, interpolation, hints);
                      }

                    else // scale <= 0.5
                      {
                        final Kernel averagingKernel = getAveragingKernel((int)Math.round(1.0 / scale));
                        logger.finer(">>>>>>>> Convolve() with averaging kernel: " + averagingKernel);
                        result = ConvolveDescriptor.create(result, new KernelJAI(averagingKernel), hints);

                        interpolation = Interpolation.getInstance(Interpolation.INTERP_NEAREST);
                        logger.finer(">>>>>>>> Scale(" + scale + ", " + interpolation + ")");
                        result = ScaleDescriptor.create(result, fScale, fScale, ZERO, ZERO, interpolation, hints);
                      }
                    
                    break;
                  
                default:
                    throw new IllegalArgumentException(quality.toString());
              }

                //                log.finer(">>>> jaiSubsampleAverage(" + scale + ")");
                //                Double dScale = new Double(scale);
                //                planarImage = SubsampleAverageDescriptor.create(planarImage, dScale, dScale, hints);

            logImage(logger, ">>>>>>>> jaiReduction returning planarImage", result);
          }

        return result;
      }

    /*******************************************************************************
     *
     * The copy is performed by copying rasters. This obviously presumes that the
     * colorspaces are the same, otherwise a required conversion would be missing.
     *
     * BufferedImages returned by PlanarImage.getAsBufferedImage() are not processable
     * by an AffineTransform, that could be use in future on the result. So we are
     * creating an optimized BufferedImage with the same size and then we will copy
     * the raster on it. See for instance
     * http://www.javadesktop.org/forums/thread.jspa?messageID=8941
     *
     * @param destination  the target BufferedImage
     *
     ******************************************************************************/
    public static void jaiCopyToBufferedImage (final PlanarImage source,
                                               final BufferedImage destination)
      {
        logger.finer(">>>> jaiCopyToBufferedImage()");

        long now = System.currentTimeMillis();

        int strategy = 1;

        if (strategy == 1)
          {
            BufferedImage bufferedImage2 = source.getAsBufferedImage();
            destination.getRaster().setRect(bufferedImage2.getRaster());
          }

        //      FIXME: maybe this is faster, since it surely doesn't change any pixel, but we have more than a single tile here
        else if (strategy == 2)
          {
            destination.getRaster().setRect(getRaster(source));
          }

        logger.finer(">>>> bufferedImage:     " + destination.getColorModel());
        logger.finer(">>>> jaiCopyToBufferedImage() done in " + (System.currentTimeMillis() - now) + " msec");
      }

    /*******************************************************************************
     *
     * If the current image is not sRGB, apply a ColorConvert operation to convert
     * it to sRGB.
     *
     * @param colorModel    the target color model (must be a sRGB color space)
     * @param hints         the RenderingHints
     *
     ******************************************************************************/
    public static PlanarImage jaiConvertTosRGBColorProfile (final PlanarImage source,
                                                            final ColorModel colorModel,
                                                            final RenderingHints hints)
      {
        boolean is_sRGB = source.getColorModel().getColorSpace().isCS_sRGB();
        logger.finer(">>>> planarImage.is_sRGB: " + is_sRGB);

        if (!is_sRGB)
          {
            // Convert color as last, since if the image has been scaled there are less pixels to convert
            logger.finer(">>>> Applying ColorConvertDescriptor");

            PlanarImage result = ColorConvertDescriptor.create(source, colorModel, hints);
            logImage(logger, ">>>>>>>>    planarImage", result);

            return result;
          }

        else
          {
            return source;
          }
      }

    /*******************************************************************************
     *
     * Converts the current image to a 8 bit representation by applying a Lookup
     * operation. It's supposed that hints contains a proper target ImageLayout.
     *
     * The best way is to go with a Lookup operation since it's faster and allows you
     * to specify the new target ImageLayout in a single step.
     *
     * @param hints         the RenderingHints
     *
     ******************************************************************************/
    public static PlanarImage jaiConvertTo8Bits (final PlanarImage source, final RenderingHints hints)
      {
        final int TARGET_BIT_COUNT = 8;

        int bitsPerPixel = source.getSampleModel().getSampleSize(0);
        logger.finer(">>>> planarImage.bitsPerPixel: " + bitsPerPixel);

        if (bitsPerPixel > TARGET_BIT_COUNT)
          {
            byte[] tableData = new byte[1 << bitsPerPixel];

            for (int i = 0; i < tableData.length; i++)
              {
                tableData[i] = (byte)(i >> (bitsPerPixel - 8));
              }

            logger.finer(">>>> Applying LookupDescriptor");

            LookupTableJAI lut = new LookupTableJAI(tableData);
            PlanarImage result = LookupDescriptor.create(source, lut, hints);
            logImage(logger, ">>>>>>>>    planarImage", result);

            return result;
          }

        else
          {
            return source;
          }
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public static WritableRaster getRaster (final PlanarImage source)
      {
        assert source.getNumXTiles() == 1 : "getNumXTiles is " + source.getNumXTiles();
        assert source.getNumYTiles() == 1 : "getNumYTiles is " + source.getNumYTiles();

        TiledImage tiledImage = new TiledImage(source, true);

        return tiledImage.getWritableTile(0, 0);

        // FIXME: in realta' per le TiledImage non esiste: ci sono tanti raster, uno
        // per ogni tile, e quindi richiederne uno solo implica un bel po' di lavoro
        // Verificare invece se si puo' eliminare questo metodo
        // Si potrebbe eliminare se il demosaicing venisse implementato come un'operazione JAI.
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public static ColorModel getColorModel (PlanarImage planarImage, ICC_Profile colorProfile)
      {
        ColorSpace colorSpace = new ICC_ColorSpace(colorProfile);
        return new ComponentColorModel(colorSpace, false, false, ColorModel.OPAQUE, planarImage.getSampleModel().getDataType());
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public static PlanarImage getPlanarImage (EditableImage editableImage) 
      {
        return (PlanarImage)editableImage.getImageModel().getImage();
      }

    /*******************************************************************************
     * Calculates the average pixel value of a given image. Only band 0 of the 
     * image is used, and the result is always of <code>double</code> type 
     * regardless of image source pixel base type
     *
     * @param source source image
     * @return average pixel value
     ******************************************************************************/
    public static double jaiAverageValue(PlanarImage source)
      {
        Raster raster = source.getData();
        double result = 0.0;

        for (int x=0; x<raster.getWidth(); x++)
        {
          for (int y=0; y<raster.getHeight(); y++)
          {
            result += raster.getSampleDouble(x, y, 0);
          }
        }

        result /= (raster.getWidth() * raster.getHeight());

        return result;            
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public static int closestPower2Size(int size)
    {
      boolean foundFlag = false;
      int index = -1, result = -1;

      for (int i=0; i<POWER2_SIZES.length && !foundFlag; i++)
      {
        if (POWER2_SIZES[i] >= size)
        {
          foundFlag = true;
          index = i;
        }
      }

      if (foundFlag)
      {
        result = POWER2_SIZES[index];
      }

      return result;
    }

  }
