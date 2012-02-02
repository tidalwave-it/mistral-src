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
package org.imajine.image.jai;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import javax.media.jai.PlanarImage;
import javax.media.jai.TiledImage;
import org.openide.util.Lookup;
import org.imajine.image.EditableImage;
import org.imajine.image.ImageModel;
import org.imajine.image.op.ImplementationFactory;
import lombok.NoArgsConstructor;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@NoArgsConstructor // for serialization
public class ImageModelJAI extends ImageModel
  {
    private static final long serialVersionUID = 4039150448239203504L;
    
    /*******************************************************************************************************************
     *
     * 
     * 
     ******************************************************************************************************************/
    public ImageModelJAI (final @Nonnull Object planarImage)
      {
        super(get(planarImage));
        
        if (!(get(planarImage) instanceof PlanarImage))
          {
            throw new IllegalArgumentException("planarImage is not an instance of PlanarImage or RenderedImage");  
          }
        
//        System.err.println("CREATED PlanarImage, id: " + getId() + ", planarImage: " + planarImage);
      }
    
    /*******************************************************************************************************************
     *
     * 
     * 
     ******************************************************************************************************************/
    @Nonnull
    private PlanarImage getPlanarImage()
      {
        return (PlanarImage)model;  
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
        return Lookup.getDefault().lookup(ImplementationFactoryJAI.class);
      }

    /*******************************************************************************************************************
     *
     * FIXME: this is probably not the best way of working. You're reading a BufferedImage by means of an ImageReader 
     * and later converting it to a PlanarImage. But JAI has its own way to read images which is probably more 
     * efficient. You need to change EditableImage read() methods to incapsulate ImageReaders and find a way to 
     * preferably use JAI readers for supported file types, and ImageReaders for other types.
     *
     ******************************************************************************************************************/
    @Nonnull
    public static EditableImage createImage (final @Nonnull RenderedImage renderedImage)
      {
        return new EditableImage(new ImageModelJAI(renderedImage));
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
        return getPlanarImage().getWidth();
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
        return getPlanarImage().getHeight();
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
        return getPlanarImage().getSampleModel().getNumBands();
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
        return (getPlanarImage() == null) ? null : EditableImage.DataType.valueOf(getPlanarImage().getSampleModel().getDataType());
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public void dispose()
      {
        getPlanarImage().dispose();
        super.dispose();
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
        return getPlanarImage().getColorModel();
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
        final TiledImage image2 = new TiledImage(getPlanarImage(), false);

        if (copyContents)
          {
            image2.setData(getPlanarImage().getData()); // FIXME: getData() creates a copy!
          }

        return createImage(image2);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
/*    public void takeSnapshot ()
      {
        logger.fine("takeSnapshot()");

        long now = System.currentTimeMillis();
        planarImage = planarImage.createSnapshot();
        JAIUtils.logImage(logger, ">>>>   takeSnapshot() returning", planarImage);
        logger.finer(">>>> takeSnapshot() done in " + (System.currentTimeMillis() - now) + " msec");
      }
*/

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnull
    @Override
    public <T> T getInnerProperty (final @Nonnull Class<T> propertyClass) 
      {
        if (propertyClass.equals(PlanarImage.class))
          {
            return (T)getPlanarImage();  
          }
        
        if (propertyClass.equals(SampleModel.class))
          {
            return (T)getPlanarImage().getSampleModel();  
          }
        
        if (propertyClass.equals(ColorModel.class))
          {
            return (T)getPlanarImage().getColorModel();  
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
        return getPlanarImage().getAsBufferedImage();    
      }
    
    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnull
    @Override
    protected Object toObjectForDeserialization (final @Nonnull RenderedImage renderedImage)
      {
        return PlanarImage.wrapRenderedImage(renderedImage);
      }

    /*******************************************************************************************************************
     *
     * 
     * 
     ******************************************************************************************************************/
    @Nonnull
    private static Object get (final @Nonnull Object planarImage)
      {
        Object result = planarImage;
        
        if (planarImage instanceof RenderedImage)
          {
            result = PlanarImage.wrapRenderedImage((RenderedImage)planarImage);
          }
          
        return result;
      }
    
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
//    public String toString ()
//      {
//        return "ImageModelJAI[id: " + getId() + ", model: " + model + "]";
//      }
  }
