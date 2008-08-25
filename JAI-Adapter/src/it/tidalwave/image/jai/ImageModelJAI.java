/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2007 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
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
 * $Id: ImageModelJAI.java 707 2007-06-17 12:50:04Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.jai;

import java.util.logging.Logger;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import javax.media.jai.PlanarImage;
import javax.media.jai.TiledImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.ImageModel;
import it.tidalwave.image.op.ImplementationFactory;

/*******************************************************************************
 *
 * @author Fabrizio Giudici
 * @version $Id: ImageModelJAI.java 707 2007-06-17 12:50:04Z fabriziogiudici $
 *
 ******************************************************************************/
public class ImageModelJAI extends ImageModel
  {
    private static final String CLASS = ImageModelJAI.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);

    static final long serialVersionUID = 4039150448239203504L;
    
    /*******************************************************************************
     *
     * Default constructor for serialization.
     *
     ******************************************************************************/
    public ImageModelJAI()
      {
      }
    
    /*******************************************************************************
     *
     ******************************************************************************/
    public ImageModelJAI (Object planarImage)
      {
        super(get(planarImage));
        
        if (!(get(planarImage) instanceof PlanarImage))
          {
            throw new IllegalArgumentException("planarImage is not an instance of PlanarImage or RenderedImage");  
          }
        
//        System.err.println("CREATED PlanarImage, id: " + getId() + ", planarImage: " + planarImage);
      }
    
    private PlanarImage getPlanarImage()
      {
        return (PlanarImage)model;  
      }

    private static Object get (Object planarImage)
      {
        if (planarImage instanceof RenderedImage)
          {
            planarImage = PlanarImage.wrapRenderedImage((RenderedImage)planarImage);
          }
          
        return planarImage;
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public ImplementationFactory getFactory()
      {
        return ImplementationFactoryJAI.getInstance();
      }

    /* FIXME: this is probably not the best way of working. You're reading a BufferedImage
     * by means of an ImageReader and later converting it to a PlanarImage. But
     * JAI has its own way to read images which is probably more efficient. You need
     * to change EditableImage read() methods to incapsulate ImageReaders and find a
     * way to preferably use JAI readers for supported file types, and ImageReaders
     * for other types.
     */
    public static EditableImage createImage (RenderedImage renderedImage)
      {
        return new EditableImage(new ImageModelJAI(renderedImage));
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public int getWidth()
      {
        return getPlanarImage().getWidth();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public int getHeight()
      {
        return getPlanarImage().getHeight();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public int getBandCount()
      {
        return getPlanarImage().getSampleModel().getNumBands();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public EditableImage.DataType getDataType()
      {
        return (getPlanarImage() == null) ? null : EditableImage.DataType.valueOf(getPlanarImage().getSampleModel().getDataType());
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    @Override
    public void dispose()
      {
        getPlanarImage().dispose();
        super.dispose();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public ColorModel getColorModel()
      {
        return getPlanarImage().getColorModel();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public EditableImage createCopy (boolean copyContents)
      {
        TiledImage image2 = new TiledImage(getPlanarImage(), false);

        if (copyContents)
          {
            image2.setData(getPlanarImage().getData()); // FIXME: getData() creates a copy!
          }

        return createImage(image2);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
/*    public void takeSnapshot ()
      {
        logger.fine("takeSnapshot()");

        long now = System.currentTimeMillis();
        planarImage = planarImage.createSnapshot();
        JAIUtils.logImage(logger, ">>>>   takeSnapshot() returning", planarImage);
        logger.finer(">>>> takeSnapshot() done in " + (System.currentTimeMillis() - now) + " msec");
      }
*/

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public <T> T getInnerProperty (Class<T> propertyClass) 
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

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    protected RenderedImage toRenderedImageForSerialization()
      {
        return getPlanarImage().getAsBufferedImage();    
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    protected Object toObjectForDeserialization (final RenderedImage renderedImage)
      {
        return PlanarImage.wrapRenderedImage(renderedImage);
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
//    public String toString ()
//      {
//        return "ImageModelJAI[id: " + getId() + ", model: " + model + "]";
//      }
  }
