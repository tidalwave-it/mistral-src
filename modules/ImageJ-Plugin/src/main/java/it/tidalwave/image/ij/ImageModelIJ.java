/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici
 *                        and Emmanuele Sordini
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
 * $Id$
 * 
 ******************************************************************************/
package it.tidalwave.image.ij;

import java.util.logging.Logger;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import ij.ImagePlus;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.ImageModel;
import it.tidalwave.image.op.ImplementationFactory;

/*******************************************************************************
 *
 * @author Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ImageModelIJ extends ImageModel
  {
    private static Logger logger = Logger.getLogger(ImageModelIJ.class.getName());

    /*******************************************************************************
     *
     * Default constructor for serialization. DO NOT USE
     *
     ******************************************************************************/
    public ImageModelIJ()
      {
      }
    
    /*******************************************************************************
     *
     ******************************************************************************/
    public ImageModelIJ (final Object imagePlus)
      {
        super(imagePlus);
        
        if (imagePlus instanceof RenderedImage)
          {
            throw new RuntimeException("Not implemented");
//            imagePlus = ImagePlus.wrapRenderedImage((RenderedImage)imagePlus);
          }
        
        if (!(imagePlus instanceof ImagePlus))
          {
            throw new IllegalArgumentException("imagePlus is not an instance of ImagePlus or RenderedImage");  
          }
      }

    private ImagePlus getImagePlus()
      {
        return (ImagePlus)model;  
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public ImplementationFactory getFactory()
      {
        return ImplementationFactoryIJ.getInstance();
      }

    /* FIXME: this is probably not the best way of working. You're reading a BufferedImage
     * by means of an ImageReader and later converting it to a ImagePlus. But
     * JAI has its own way to read images which is probably more efficient. You need
     * to change EditableImage read() methods to incapsulate ImageReaders and find a
     * way to preferably use JAI readers for supported file types, and ImageReaders
     * for other types.
     */
    public static EditableImage createImage (RenderedImage renderedImage)
      {
        return new EditableImage(new ImageModelIJ(renderedImage));
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public int getWidth()
      {
        return getImagePlus().getWidth();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public int getHeight()
      {
        return getImagePlus().getHeight();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public int getBandCount()
      {
        throw new RuntimeException("Not implemented");
//        return imagePlus.getImageStack().getSampleModel().getNumBands();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public EditableImage.DataType getDataType()
      {
        throw new RuntimeException("Not implemented");
//        return imagePlus.getImageStack().getSampleModel().getDataType();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public ColorModel getColorModel()
      {
        return getImagePlus().getImageStack().getColorModel();
      }

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    public EditableImage createCopy (boolean copyContents)
      {
        throw new RuntimeException("Not implemented");
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
/*    public void takeSnapshot ()
      {
        logger.fine("takeSnapshot()");

        long now = System.currentTimeMillis();
        imagePlus = imagePlus.createSnapshot();
        JAIUtils.logImage(logger, ">>>>   takeSnapshot() returning", imagePlus);
        logger.finer(">>>> takeSnapshot() done in " + (System.currentTimeMillis() - now) + " msec");
      }
*/

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public <T> T getInnerProperty (Class<T> propertyClass) 
      {
        throw new IllegalArgumentException(propertyClass.getName());
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    protected RenderedImage toRenderedImageForSerialization()
      {
        throw new RuntimeException("Not implemented");
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    protected Object toObjectForDeserialization (final RenderedImage renderedImage)
      {
        throw new RuntimeException("Not implemented");
      }
    

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public void writeExternal (DataOutputStream out)
      throws IOException 
      {
        throw new RuntimeException("Not implemented");
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public void readExternal (DataInputStream in) 
      throws IOException 
      {
        throw new RuntimeException("Not implemented");
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
//    public String toString ()
//      {
//        return "ImageModelIJ[id:"  + getId() + ", image: " + model + "]";
//      }
  }
