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
package it.tidalwave.image.java2d;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
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
import it.tidalwave.image.op.ImplementationFactoryRegistry;
import org.openide.util.Lookup;

/*******************************************************************************
 *
 * An opaque class which encapsulates all the image manipulation logics,
 * and allows the implementation of these logics to be transparently changed
 * (e.g. by using or not JAI, etc...)
 *
 * @author Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ImageModelJ2D extends ImageModel
  {
    private static final String CLASS = ImageModelJ2D.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
    
    private static Map<InterpolationType, Object> interpolationMap = new HashMap<InterpolationType, Object>();
    private static Map<InterpolationType, Integer> interpolationMap2 = new HashMap<InterpolationType, Integer>();
    private static final List<String> ICC_PROFILES_WORKAROUND = Arrays.asList(new String[]
            {
                "sRGB IEC61966-2.1", "Nikon sRGB 4.0.0.3000", "Nikon sRGB 4.0.0.3001"
            });

    static
      {
        interpolationMap.put(InterpolationType.FASTEST, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        interpolationMap.put(InterpolationType.NEAREST_NEIGHBOR, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        interpolationMap.put(InterpolationType.BILINEAR, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        interpolationMap.put(InterpolationType.BICUBIC, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        interpolationMap.put(InterpolationType.BEST, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        interpolationMap2.put(InterpolationType.FASTEST, new Integer(AffineTransformOp.TYPE_NEAREST_NEIGHBOR));
        interpolationMap2.put(InterpolationType.NEAREST_NEIGHBOR, new Integer(AffineTransformOp.TYPE_NEAREST_NEIGHBOR));
        interpolationMap2.put(InterpolationType.BILINEAR, new Integer(AffineTransformOp.TYPE_BILINEAR));
        interpolationMap2.put(InterpolationType.BICUBIC, new Integer(AffineTransformOp.TYPE_BILINEAR));
        interpolationMap2.put(InterpolationType.BEST, new Integer(AffineTransformOp.TYPE_BILINEAR));
      }

    /*******************************************************************************
     *
     * Default constructor for serialization. DO NOT USE
     *
     ******************************************************************************/
    public ImageModelJ2D()
      {
      }

    /*******************************************************************************
     *
     * Creates a new EditableImage given a BufferedImage
     *
     * @param  bufferedImage  the buffered image
     *
     ******************************************************************************/
    public ImageModelJ2D (final Object bufferedImage)
      {
        super(bufferedImage);
        
        if (!(bufferedImage instanceof BufferedImage))
          {
            throw new IllegalArgumentException("bufferedImage is not an instance of BufferedImage");
          }
      }
    
    private BufferedImage getBufferedImage()
      {
        return (BufferedImage)model;  
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public ImplementationFactory getFactory()
      {
        return Lookup.getDefault().lookup(ImplementationFactoryJ2D.class);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public static EditableImage createImage (final BufferedImage bufferedImage) // FIXME: try to remove this
      {
        assert bufferedImage != null : "bufferedImage is null";

        return new EditableImage(new ImageModelJ2D(bufferedImage));
      }

    /*******************************************************************************
     *
     * Returns the width of this image.
     *
     * @return  the width
     *
     ******************************************************************************/
    public int getWidth()
      {
        return getBufferedImage().getWidth();
      }

    /*******************************************************************************
     *
     * Returns the height of this image.
     *
     * @return  the height
     *
     ******************************************************************************/
    public int getHeight()
      {
        return getBufferedImage().getHeight();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public EditableImage.DataType getDataType()
      {
        return EditableImage.DataType.valueOf(getBufferedImage().getRaster().getDataBuffer().getDataType());
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public int getBandCount()
      {
        return getBufferedImage().getRaster().getNumBands();
      }

    /*******************************************************************************
     *
     * Returns the ColorModel of this image.
     *
     * @return  the color model
     *
     ******************************************************************************/
    public ColorModel getColorModel()
      {
        return getBufferedImage().getColorModel();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    @Override
    public long getMemorySize()
      {
        return (getBufferedImage() == null) ? 0 : getBufferedImage().getRaster().getDataBuffer().getSize();
      }
    
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public EditableImage createCopy (boolean copyContents)
      {
        logger.fine("createCopy(" + copyContents + ")");

        long time = System.currentTimeMillis();
        logger.warning(">>>> **** WARNING CREATECOPY DISABLED");

        BufferedImage result = getBufferedImage(); // createCopy2(copyContents);
        logger.fine(">>>> createCopy() completed ok in " + (System.currentTimeMillis() - time) + " msec");

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

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    @SuppressWarnings("unchecked")
    public <T> T getInnerProperty (Class<T> propertyClass)
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

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    protected RenderedImage toRenderedImageForSerialization()
      {
        return getBufferedImage();    
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    protected Object toObjectForDeserialization (final RenderedImage renderedImage)
      {
        return renderedImage;
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/

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
