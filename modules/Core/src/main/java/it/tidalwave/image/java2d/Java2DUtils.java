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

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferUShort;
import java.awt.image.DirectColorModel;
import java.awt.image.Kernel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import org.slf4j.Logger;
import it.tidalwave.image.ImageUtils;
import it.tidalwave.image.Kernel2;
import it.tidalwave.image.Quality;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class Java2DUtils
  {
    public static final Float ZERO = (float)0;
    private static final Map<Quality, Object> renderingHintsQualityMap =
            Map.of(Quality.FASTEST,
                   RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR,
                   Quality.INTERMEDIATE,
                   RenderingHints.VALUE_INTERPOLATION_BILINEAR,
                   Quality.BEST,
                   RenderingHints.VALUE_INTERPOLATION_BICUBIC);

    private static final Map<Quality, Integer> affineTransformQualityMap =
            Map.of(Quality.FASTEST,
                   AffineTransformOp.TYPE_NEAREST_NEIGHBOR,
                   Quality.INTERMEDIATE,
                   AffineTransformOp.TYPE_BILINEAR,
                   Quality.BEST,
                   AffineTransformOp.TYPE_BICUBIC);

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public static Properties getProperties (final BufferedImage image)
      {
        final Properties properties = new Properties();
        final String[] propertyNames = image.getPropertyNames();

        if (propertyNames != null)
          {
            for (final String propertyName : propertyNames)
              {
                final Object propertyValue = image.getProperty(propertyName);
                properties.setProperty(propertyName, propertyValue.toString());
              }
          }

        return properties;
      }

    /*******************************************************************************************************************
     *
     * @param width
     * @param height
     * @return
     *
     ******************************************************************************************************************/
    public static BufferedImage createOptimizedImage (final int width, final int height)
      {
        final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final GraphicsDevice gs = ge.getDefaultScreenDevice();
        final GraphicsConfiguration gc = gs.getDefaultConfiguration();

        return gc.createCompatibleImage(width, height);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public static GraphicsConfiguration getGraphicsConfiguration()
      {
        final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final GraphicsDevice[] gs = ge.getScreenDevices();
        final GraphicsDevice gd = gs[0]; // FIXME

        return gd.getDefaultConfiguration();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public static BufferedImage createSimilarImage (final BufferedImage bufferedImage,
                                                    final int newWidth,
                                                    final int newHeight)
      {
        final SampleModel sampleModel = bufferedImage.getSampleModel().createCompatibleSampleModel(newWidth, newHeight);
        final WritableRaster newRaster = Raster.createWritableRaster(sampleModel, null);
        final ColorModel colorModel = bufferedImage.getColorModel();

        return new BufferedImage(colorModel, newRaster, false, Java2DUtils.getProperties(bufferedImage));
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public static String getICCProfileName (final RenderedImage image)
      {
        final ICC_Profile iccProfile = ImageUtils.getICCProfile(image);

        if (iccProfile != null)
          {
            return ImageUtils.getICCProfileName(iccProfile);
          }

        else
          {
            return null;
          }
      }

    /*******************************************************************************************************************
     *
     * It seems that SinglePixelPackedSampleModel is the only fast mode when a
     * color profile is converted. This is probably a bug (that has nothing to do
     * with bugs 4886071 and 4705399).
     * Note that grayscale images (TYPE_GRAY) are not converted.
     *
     ******************************************************************************************************************/
    public static BufferedImage convertToSinglePixelPackedSampleModel (BufferedImage image)
      {
        log.debug("convertToSinglePixelPackedSampleModel(image: " + image + ")");
        Java2DUtils.logImage(log, ">>>> source bufferedImage", image);

        long time = System.currentTimeMillis();

        final WritableRaster sourceRaster = image.getRaster();
        ColorModel colorModel = image.getColorModel();
        ICC_ColorSpace colorSpace = (ICC_ColorSpace)colorModel.getColorSpace();
        final SampleModel ssmd = sourceRaster.getSampleModel();

        if (colorSpace.getType() == ColorSpace.TYPE_GRAY)
          {
            log.debug(">>>> TYPE_GRAY, not converting");
          }

        else if (!(ssmd instanceof PixelInterleavedSampleModel))
          {
            log.debug(">>>> sourceSampleModel is " + ssmd.getClass() + ", not converting");
          }

        else
          {
            final PixelInterleavedSampleModel sourceSampleModel = (PixelInterleavedSampleModel)ssmd;
            final int[] bitMasks = new int[]{0x00ff0000, 0x0000ff00, 0x000000ff};

            final SinglePixelPackedSampleModel sampleModel =
                    new SinglePixelPackedSampleModel(DataBuffer.TYPE_INT, image.getWidth(),
                                                     image.getHeight(), bitMasks);

            final WritableRaster destRaster = Raster.createWritableRaster(sampleModel, null);
            final DataBufferInt destDataBuffer = (DataBufferInt)destRaster.getDataBuffer();
            final int[] destBuffer = destDataBuffer.getData();
            final int[] bandOffsets = sourceSampleModel.getBandOffsets();

            for (int i = 0; i < bandOffsets.length; i++)
              {
                bandOffsets[i] += ((-sourceRaster.getSampleModelTranslateX() * sourceSampleModel.getPixelStride()) -
                                   (sourceRaster.getSampleModelTranslateY() * sourceSampleModel.getScanlineStride()));
              }

            final DataBuffer sourceDataBuffer = sourceRaster.getDataBuffer();

            if (sourceDataBuffer instanceof DataBufferUShort)
              {
                convertUShortDataBuffer(image,
                                        (DataBufferUShort)sourceDataBuffer,
                                        sourceSampleModel,
                                        bandOffsets,
                                        destBuffer);
              }

            else if (sourceDataBuffer instanceof DataBufferByte)
              {
                convertByteDataBuffer(image,
                                      (DataBufferByte)sourceDataBuffer,
                                      sourceSampleModel,
                                      bandOffsets,
                                      destBuffer);
              }

            else
              {
                throw new IllegalArgumentException("Cannot deal with " + sourceDataBuffer.getClass());
              }

            final String sourceProfileName = ImageUtils.getICCProfileName(colorSpace.getProfile());

            if (sourceProfileName.equals("Nikon sRGB 4.0.0.3001"))
              {
                log.warn(">>>> Workaround #1094403: using sRGB instead of " + sourceProfileName);
                colorSpace = new ICC_ColorSpace(ICC_Profile.getInstance(ColorSpace.CS_LINEAR_RGB));
              }

            colorModel = new DirectColorModel(colorSpace,
                                              24,
                                              bitMasks[0],
                                              bitMasks[1],
                                              bitMasks[2],
                                              0,
                                              false,
                                              DataBuffer.TYPE_INT);
            image = new BufferedImage(colorModel, destRaster, false, null);
          }

        time = System.currentTimeMillis() - time;
        Java2DUtils.logImage(log, ">>>> convertToSinglePixelPackedSampleModel() returning", image);
        log.debug(">>>> convertToSinglePixelPackedSampleModel() completed ok in " + time + " msec");

        return image;
      }

    /*******************************************************************************************************************
     *
     * Scales a <code>BufferedImage</code> by filtering with an
     * <code>AffineTransform</code>.
     *
     * @param   bufferedImage  the image to scale
     * @param   xScale         the horizontal scale
     * @param   yScale         the vertical scale
     * @param   quality        the quality
     *
     ******************************************************************************************************************/
    public static BufferedImage scaleWithAffineTransform (final BufferedImage bufferedImage,
                                                          final double xScale,
                                                          final double yScale,
                                                          final Quality quality)
            throws IllegalArgumentException
      {
        log.debug("scaleWithAffineTransform(" + xScale + ", " + yScale + ", " + quality);

        final AffineTransform transform = AffineTransform.getScaleInstance(xScale, yScale);
        final int interpolation = findAffineTransformInterpolation(quality);
        log.debug(">>>> AffineTransformOp(" + transform + ", " + interpolation + ")");

        final AffineTransformOp op = new AffineTransformOp(transform, interpolation);

        return op.filter(bufferedImage, null);
      }

    /*******************************************************************************************************************
     *
     * Scales a <code>BufferedImage</code> by redrawing it on a new bitmap.
     *
     * @param   bufferedImage  the image to scale
     * @param   xScale         the horizontal scale
     * @param   yScale         the vertical scale
     * @param   quality        the quality
     *
     ******************************************************************************************************************/
    public static BufferedImage scaleWithDrawImage (final BufferedImage bufferedImage,
                                                    final double xScale,
                                                    final double yScale,
                                                    final Quality quality)
            throws IllegalArgumentException
      {
        log.debug("scaleWithDrawImage(" + xScale + ", " + yScale + ", " + quality);

        final int newWidth = (int)Math.round(bufferedImage.getWidth() * xScale);
        final int newHeight = (int)Math.round(bufferedImage.getHeight() * yScale);
        final BufferedImage result = createSimilarImage(bufferedImage, newWidth, newHeight);

        final Graphics2D g2d = (Graphics2D)result.getGraphics();
        final Object interpolation = findRenderingHintsInterpolation(quality);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, interpolation);

        try
          {
            g2d.drawImage(bufferedImage, 0, 0, newWidth, newHeight, null);
          }
        finally
          {
            g2d.dispose();
          }

        return result;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public static BufferedImage rotateWithDrawImage (final BufferedImage bufferedImage,
                                                     final double degrees,
                                                     final Quality quality)
      {
        final double radians = Math.toRadians(degrees);
        final double cos = Math.cos(radians);
        final double sin = Math.sin(radians);
        final int width = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();
        final int newWidth = (int)Math.round(Math.abs(width * cos) + Math.abs(height * sin));
        final int newHeight = (int)Math.round(Math.abs(width * sin) + Math.abs(height * cos));
        final BufferedImage result = createSimilarImage(bufferedImage, newWidth, newHeight);
        final Graphics2D g2d = (Graphics2D)result.getGraphics();
        final Object interpolation = findRenderingHintsInterpolation(quality);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, interpolation);

        try
          {
            g2d.transform(AffineTransform.getTranslateInstance((newWidth - width) / 2, (newHeight - height) / 2));
            g2d.transform(AffineTransform.getRotateInstance(-radians, width / 2, height / 2));
            g2d.drawImage(bufferedImage, 0, 0, null);
          }

        finally
          {
            g2d.dispose();
          }

        return result;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected static String toString (final int[] array, final int radix)
      {
        final StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < array.length; i++)
          {
            buffer.append(Integer.toString(array[i], radix));

            if (i < (array.length - 1))
              {
                buffer.append(",");
              }
          }

        return buffer.toString();
      }

    /**
     * @param image
     */

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public static void logImage (final Logger log, final String prefix, final RenderedImage image)
      {
        if (Java2DUtils.log.isDebugEnabled())
          {
            if (image == null)
              {
                Java2DUtils.log.debug(prefix + "null image");
              }

            else
              {
//            image.getData(); THIS IS SLOW SLOW SLOW!!
                final ColorModel colorModel = image.getColorModel();
                Java2DUtils.log.debug(prefix + ".size:           " + image.getWidth() + ", " + image.getHeight());
                Java2DUtils.log.debug(prefix + ".tiles:          " + image.getNumXTiles() + " " + image.getNumYTiles());
                Java2DUtils.log.debug(prefix + ".class:          " + image.getClass().getName());
                Java2DUtils.log.debug(prefix + ".sampleModel:    " + toString(image.getSampleModel()));

                if (colorModel != null)
                  {
                    Java2DUtils.log.debug(
                            prefix + ".colorModel:     " + colorModel.getClass().getName() + " : " + colorModel);
                    Java2DUtils.log.debug(prefix + ".colorSpace:     " + toString(colorModel.getColorSpace()));
                  }
              }

            //      log.debug(">>>> iccProfile is now: " + getICCProfileName(bufferedImage));
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static String toString (final SampleModel sampleModel)
      {
        if (sampleModel instanceof SinglePixelPackedSampleModel)
          {
            return toString((SinglePixelPackedSampleModel)sampleModel);
          }

        else if (sampleModel instanceof PixelInterleavedSampleModel)
          {
            return toString((PixelInterleavedSampleModel)sampleModel);
          }

        else
          {
            return sampleModel.toString();
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static String toString (final ColorSpace colorSpace)
      {
        if (colorSpace instanceof ICC_ColorSpace)
          {
            return toString((ICC_ColorSpace)colorSpace);
          }

        else
          {
            return colorSpace.toString();
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static String toString (final ICC_ColorSpace colorSpace)
      {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(colorSpace.getClass().getName());
        buffer.append("[type: ");
        buffer.append(colorSpace.getType());
        buffer.append(", profile name: ");
        buffer.append(ImageUtils.getICCProfileName(colorSpace.getProfile()));
        buffer.append("]");

        return buffer.toString();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static String toString (final SinglePixelPackedSampleModel sampleModel)
      {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(sampleModel.getClass().getName());
        buffer.append("[width: ");
        buffer.append(sampleModel.getWidth());
        buffer.append(", height: ");
        buffer.append(sampleModel.getHeight());
        buffer.append(", numBands: ");
        buffer.append(sampleModel.getNumBands());
        buffer.append(", dataType: ");
        buffer.append(sampleModel.getDataType());
        buffer.append(", scanlineStride: ");
        buffer.append(sampleModel.getScanlineStride());
        buffer.append(", transferType: ");
        buffer.append(sampleModel.getTransferType());
        buffer.append(", numDataElements: ");
        buffer.append(sampleModel.getNumDataElements());
        buffer.append(", bitMasks: ");
        buffer.append(toString(sampleModel.getBitMasks(), 16));
        buffer.append(", bitOffsets: ");
        buffer.append(toString(sampleModel.getBitOffsets(), 10));
        buffer.append("]");

        return buffer.toString();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static String toString (final PixelInterleavedSampleModel sampleModel)
      {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(sampleModel.getClass().getName());
        buffer.append("[width: ");
        buffer.append(sampleModel.getWidth());
        buffer.append(", height: ");
        buffer.append(sampleModel.getHeight());
        buffer.append(", numBands: ");
        buffer.append(sampleModel.getNumBands());
        buffer.append(", dataType: ");
        buffer.append(sampleModel.getDataType());
        buffer.append(", scanlineStride: ");
        buffer.append(sampleModel.getScanlineStride());
        buffer.append(", transferType: ");
        buffer.append(sampleModel.getTransferType());
        buffer.append(", numDataElements: ");
        buffer.append(sampleModel.getNumDataElements());
        buffer.append(", bandOffsets: ");
        buffer.append(toString(sampleModel.getBandOffsets(), 10));
        buffer.append(", bankIndices: ");
        buffer.append(toString(sampleModel.getBankIndices(), 10));
        buffer.append("]");

        return buffer.toString();
      }

    /*******************************************************************************************************************
     *
     * @param image
     * @param sourceDataBuffer
     * @param sourceSampleModel
     * @param bandOffsets
     * @param destBuffer
     *
     ******************************************************************************************************************/
    private static void convertUShortDataBuffer (final BufferedImage image,
                                                 final DataBufferUShort sourceDataBuffer,
                                                 final PixelInterleavedSampleModel sourceSampleModel,
                                                 final int[] bandOffsets,
                                                 final int[] destBuffer)
      {
        int base = 0;
        int i = 0;
        final short[] sourceBuffer = sourceDataBuffer.getData();

        for (int y = 0; y < image.getHeight(); y++)
          {
            int j = base;

            for (int x = 0; x < image.getWidth(); x++)
              {
                final int r = (sourceBuffer[j + bandOffsets[0]] & 0xffff) >> 8;
                final int g = (sourceBuffer[j + bandOffsets[1]] & 0xffff) >> 8;
                final int b = (sourceBuffer[j + bandOffsets[2]] & 0xffff) >> 8;

                destBuffer[i++] = (r << 16) | (g << 8) | b;
                j += 3;
              }

            base += sourceSampleModel.getScanlineStride();
          }
      }

    /**
     * @param image
     * @param sourceDataBuffer
     * @param sourceSampleModel
     * @param bandOffsets
     * @param destBuffer
     */
    private static void convertByteDataBuffer (final BufferedImage image,
                                               final DataBufferByte sourceDataBuffer,
                                               final PixelInterleavedSampleModel sourceSampleModel,
                                               final int[] bandOffsets,
                                               final int[] destBuffer)
      {
        int base = 0;
        int i = 0;
        final byte[] sourceBuffer = sourceDataBuffer.getData();
        final int pixelStride = sourceSampleModel.getPixelStride();

        for (int y = 0; y < image.getHeight(); y++)
          {
            int j = base;

            for (int x = 0; x < image.getWidth(); x++)
              {
                final int r = (sourceBuffer[j + bandOffsets[0]] & 0xff);
                final int g = (sourceBuffer[j + bandOffsets[1]] & 0xff);
                final int b = (sourceBuffer[j + bandOffsets[2]] & 0xff);

                destBuffer[i++] = (r << 16) | (g << 8) | b;
                j += pixelStride;
              }

            base += sourceSampleModel.getScanlineStride();
          }
      }

    /*******************************************************************************************************************
     *
     * @param xScale
     * @param yScale
     * @param quality
     * @return
     *
     ******************************************************************************************************************/
    public static BufferedImage createOptimizedImage (final BufferedImage bufferedImage,
                                                      final double xScale,
                                                      final double yScale,
                                                      final Quality quality)
      {
        log.debug("createOptimizedImage(" + xScale + ", " + yScale + ", " + quality + ")");

        final int iw = (int)Math.round(xScale * bufferedImage.getWidth());
        final int ih = (int)Math.round(yScale * bufferedImage.getHeight());
        final BufferedImage image2 = createOptimizedImage(iw, ih);
        final Graphics2D g = (Graphics2D)image2.getGraphics();

        try
          {
            final Object interpolation = findRenderingHintsInterpolation(quality);

            // Workaround for bugs #4886071 and #4705399
            // See http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4886071
            // and http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4705399
            /*
             * FIXME: looks like we can avoid this now.
             if (!bufferedImage.getColorModel().getColorSpace().isCS_sRGB())
             {
             ICC_Profile iccProfile = ImageUtils.getICCProfile(bufferedImage);
             String iccProfileName = ImageUtils.getICCProfileName(iccProfile);
             if (ICC_PROFILES_WORKAROUND.contains(iccProfileName))
             {
             logger.info(">>>> applying workaround for bugs #4886071 and #4705399 - profile " + iccProfileName);

             BufferedImage tempImage = createOptimizedImage(bufferedImage.getWidth(), bufferedImage.getHeight());
             long time = System.currentTimeMillis();

             //BufferedImage image2 = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage
             * .TYPE_INT_RGB);
             Graphics g3 = tempImage.getGraphics();
             g3.drawImage(bufferedImage, 0, 0, null);
             g3.dispose();
             bufferedImage = tempImage;
             logger.info(">>>> workaround applied in " + (System.currentTimeMillis() - time) + " msec.");
             }
             }
             */
            log.debug(">>>> applying AffineTransform.getScaleInstance() with RenderingHint: " + interpolation);

            final Object renderingHintSave = g.getRenderingHint(RenderingHints.KEY_INTERPOLATION);
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, interpolation);

            final AffineTransform transform =
                    ((xScale == 1.0) && (yScale == 1.0)) ? null : AffineTransform.getScaleInstance(xScale, yScale);
            g.drawRenderedImage(bufferedImage, transform);

            if (renderingHintSave != null)
              {
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, renderingHintSave);
              }

            log.debug(">>>>>>>> iccProfile is now: " + Java2DUtils.getICCProfileName(image2));
          }

        finally
          {
            g.dispose();
          }

        return image2;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public static Object findRenderingHintsInterpolation (final Quality quality)
            throws IllegalArgumentException
      {
        if (!renderingHintsQualityMap.containsKey(quality))
          {
            throw new IllegalArgumentException(quality.toString());
          }

        return renderingHintsQualityMap.get(quality);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public static int findAffineTransformInterpolation (final Quality quality)
            throws IllegalArgumentException
      {
        if (!affineTransformQualityMap.containsKey(quality))
          {
            throw new IllegalArgumentException(quality.toString());
          }

        return affineTransformQualityMap.get(quality);
      }

    /*******************************************************************************************************************
     *
     * @param n
     * @return
     *
     ******************************************************************************************************************/
    public static Kernel getAveragingKernel (final int n)
      {
        Kernel kernel = null;

        if ((n & 1) == 1)
          {
            kernel = getOddAveragingKernel(n);
          }

        else
          {
            kernel = getEvenAveragingKernel(n);
          }

        //    log.debug(">>>>>>>> Kernel: " + kernel);
        return kernel;
      }

    /*******************************************************************************************************************
     *
     * @param n
     * @return
     *
     ******************************************************************************************************************/
    private static Kernel getEvenAveragingKernel (final int n)
      {
        final int r = n + 1;
        final int totalCount = r * r;
        final int coreCount = (r - 2) * (r - 2);
        final int extCount = totalCount - coreCount;
        final float a = 1.0f / ((coreCount * 2) + extCount); // core count double
        final float coreValue = a * 2;
        final float[] result = new float[totalCount];

        int j = 0;

        for (int i = 0; i < r; i++)
          {
            result[j++] = a;
          }

        for (int k = 0; k < (r - 2); k++)
          {
            result[j++] = a;

            for (int h = 0; h < (r - 2); h++)
              {
                result[j++] = coreValue;
              }

            result[j++] = a;
          }

        for (int i = 0; i < r; i++)
          {
            result[j++] = a;
          }
        assert j == totalCount;

        return new Kernel2(r, r, result);
      }

    /*******************************************************************************************************************
     *
     * @param n
     * @return
     *
     ******************************************************************************************************************/
    private static Kernel getOddAveragingKernel (final int n)
      {
        final int totalCount = n * n;
        final float v = 1.0f / (totalCount);
        final float[] result = new float[totalCount];
        Arrays.fill(result, v);

        return new Kernel2(n, n, result);
      }
  }
