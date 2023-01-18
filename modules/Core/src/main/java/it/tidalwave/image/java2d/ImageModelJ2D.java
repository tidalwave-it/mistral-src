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

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.awt.RenderingHints;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.ImageModel;
import it.tidalwave.image.InterpolationType;
import it.tidalwave.image.op.ImplementationFactory;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * An opaque class which encapsulates all the image manipulation logics,
 * and allows the implementation of these logics to be transparently changed
 * (e.g. by using or not JAI, etc...)
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@NoArgsConstructor /* for serialization */ @Slf4j
public class ImageModelJ2D extends ImageModel
  {
    private static final Map<InterpolationType, Object> interpolationMap = new HashMap<>();

    private static final Map<InterpolationType, Integer> interpolationMap2 = new HashMap<>();

//    private static final List<String> ICC_PROFILES_WORKAROUND = Arrays.asList(new String[]
//      {
//        "sRGB IEC61966-2.1", "Nikon sRGB 4.0.0.3000", "Nikon sRGB 4.0.0.3001"
//      });

    static
      {
        interpolationMap.put(InterpolationType.FASTEST, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        interpolationMap.put(InterpolationType.NEAREST_NEIGHBOR, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        interpolationMap.put(InterpolationType.BILINEAR, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        interpolationMap.put(InterpolationType.BICUBIC, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        interpolationMap.put(InterpolationType.BEST, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        interpolationMap2.put(InterpolationType.FASTEST, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        interpolationMap2.put(InterpolationType.NEAREST_NEIGHBOR, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        interpolationMap2.put(InterpolationType.BILINEAR, AffineTransformOp.TYPE_BILINEAR);
        interpolationMap2.put(InterpolationType.BICUBIC, AffineTransformOp.TYPE_BILINEAR);
        interpolationMap2.put(InterpolationType.BEST, AffineTransformOp.TYPE_BILINEAR);
      }

    /*******************************************************************************************************************
     *
     * Creates a new EditableImage given a BufferedImage
     *
     * @param  bufferedImage  the buffered image
     *
     ******************************************************************************************************************/
    public ImageModelJ2D (@Nonnull final Object bufferedImage)
      {
        super(bufferedImage);

        if (!(bufferedImage instanceof BufferedImage))
          {
            throw new IllegalArgumentException("bufferedImage is not an instance of BufferedImage");
          }
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnull
    @Override
    public ImplementationFactory getFactory()
      {
        return ImplementationFactoryJ2D.getDefault();
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public static EditableImage createImage (@Nonnull final BufferedImage bufferedImage) // FIXME: try to remove this
      {
        return new EditableImage(new ImageModelJ2D(bufferedImage));
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnegative
    @Override
    public int getWidth()
      {
        return getBufferedImage().getWidth();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnegative
    @Override
    public int getHeight()
      {
        return getBufferedImage().getHeight();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnull
    @Override
    public EditableImage.DataType getDataType()
      {
        return EditableImage.DataType.valueOf(getBufferedImage().getRaster().getDataBuffer().getDataType());
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnegative
    @Override
    public int getBandCount()
      {
        return getBufferedImage().getRaster().getNumBands();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnull
    @Override
    public ColorModel getColorModel()
      {
        return getBufferedImage().getColorModel();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    @Nonnegative
    public long getMemorySize()
      {
        return (getBufferedImage() == null) ? 0 : getBufferedImage().getRaster().getDataBuffer().getSize();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnull
    @Override
    public EditableImage createCopy (final boolean copyContents)
      {
        log.trace("createCopy({})", copyContents);

        final var time = System.currentTimeMillis();
        log.warn(">>>> **** WARNING CREATECOPY DISABLED");

        final var result = getBufferedImage(); // createCopy2(copyContents);
        log.trace(">>>> createCopy() completed ok in {} msec", (System.currentTimeMillis() - time));

        return createImage(result);
      }

    /*    private BufferedImage createCopy2 (boolean copyContents)
     {
     SampleModel sampleModel = image.getSampleModel();
     WritableRaster newRaster = Raster.createWritableRaster(sampleModel, null);
     ColorModel colorModel = image.getColorModel();
     BufferedImage result = new BufferedImage(colorModel, newRaster, false, getProperties(image));

     if (copyContents)
     copyDataBuffer(image.getRaster(), newRaster);

     return result;
     }*/

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @SuppressWarnings("unchecked")
    @Nonnull
    @Override
    public <T> T getInnerProperty (@Nonnull final Class<T> propertyClass)
      {
        if (propertyClass.equals(BufferedImage.class))
          {
            return (T)getBufferedImage();
          }

        if (propertyClass.equals(SampleModel.class))
          {
            return (T)getBufferedImage().getSampleModel();
          }

        if (propertyClass.equals(ColorModel.class))
          {
            return (T)getBufferedImage().getColorModel();
          }

        throw new IllegalArgumentException(propertyClass.getName());
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnull
    @Override
    protected RenderedImage toRenderedImageForSerialization()
      {
        return getBufferedImage();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnull
    @Override
    protected Object toObjectForDeserialization (@Nonnull final RenderedImage renderedImage)
      {
        return renderedImage;
      }

    @Nonnull
    private BufferedImage getBufferedImage()
      {
        return (BufferedImage)model;
      }

    /*
     private void copyDataBuffer (WritableRaster raster, WritableRaster newRaster)
     {
     int type = raster.getDataBuffer().getDataType();

     switch (type)
     {
     case DataBuffer.TYPE_BYTE:
     DataBufferByte sourceDataBuffer1 = (DataBufferByte)raster.getDataBuffer();
     DataBufferByte destDataBuffer1   = (DataBufferByte)newRaster.getDataBuffer();
     System.arraycopy(sourceDataBuffer1.getData(), 0,
     destDataBuffer1.getData(), 0,
     sourceDataBuffer1.getData().length);

     break;

     case DataBuffer.TYPE_USHORT:
     DataBufferUShort sourceDataBuffer2 = (DataBufferUShort)raster.getDataBuffer();
     DataBufferUShort destDataBuffer2   = (DataBufferUShort)newRaster.getDataBuffer();
     System.arraycopy(sourceDataBuffer2.getData(), 0,
     destDataBuffer2.getData(), 0,
     sourceDataBuffer2.getData().length);

     break;

     default:
     throw new IllegalArgumentException("Unsupported databuffer type: " + type);
     }
     }
     */
  }
