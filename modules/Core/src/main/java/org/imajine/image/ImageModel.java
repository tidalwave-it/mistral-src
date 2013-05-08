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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.image;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.awt.image.ColorModel;
import org.imajine.image.op.ImplementationFactory;
import java.awt.image.RenderedImage;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;

/*******************************************************************************
 *
 * @author Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public abstract class ImageModel implements Externalizable
  {
    private Serializable id;
    private String nickName;
    protected transient Object model;

    /*******************************************************************************
     *
     * Default constructor for serialization. DO NOT CALL.
     *
     ******************************************************************************/
    public ImageModel()
      {
        // Just deserialized. There's no model, so it should not go in cache
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public ImageModel (final Object model)
      {
        if (model == null)
          {
            throw new IllegalArgumentException("model is null");  
          }
        
        id = "" + (System.nanoTime() - 1182021416080087000L); // FIXME: use UUID
//        System.err.println("CREATED ImageModel " + id);
        this.model = model;
//        ImageModelCache.getInstance().add(this);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public void dispose()
      {
        ImageModelCache.getInstance().remove(id, true);
        // model = null; FIXME??
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public final Serializable getId()
      {
        return id;
      }

    public void setNickName (final String nickName)
      {
        this.nickName = nickName;
      }
    
    public String getNickName()
      {
        return nickName;
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    @Override
    public final int hashCode()
      {
        return (id != null) ? id.hashCode() : 0;
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    @Override
    public final boolean equals (final Object object)
      {
        if (!(object instanceof ImageModel))
          {
            return false;
          }  
        
        final ImageModel imageModel = (ImageModel)object;
        
        if ((id == null) || (imageModel.id == null))
          {
            return false;  
          }
        
        return id.equals(imageModel.id);
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public void setImage (final Object image)
      {
        ImageModelCache.getInstance().update(this);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public final Object getImage ()
      {
        return model;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public abstract int getWidth();

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public abstract int getHeight();

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public abstract EditableImage.DataType getDataType();

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public abstract int getBandCount();

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public abstract ImplementationFactory getFactory();

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public abstract ColorModel getColorModel();

    /*******************************************************************************
     *
     * Creates a similar image, that is a blank image with the same characteristics
     * of this image (width, height, data type, sample model, color model).
     *
     * @return  a new, similar image
     *
     ******************************************************************************/
    public abstract EditableImage createCopy (boolean copyContents);

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public abstract <T> T getInnerProperty (Class<T> propertyClass);
    
    /*******************************************************************************
     *
     * Returns an estimate of the memory allocated by this image. The default
     * implementation returns the number of pixels multiplied by the number of bands
     * multiplied the size in bytes of each pixel. Can be overridden for more 
     * accurate implementations.
     * 
     * @return  the memory allocated for this image
     *
     ******************************************************************************/
    public long getMemorySize()
      {
        final EditableImage.DataType dataType = getDataType();
        return (dataType == null) ? 0 : ((long)dataType.getSize() * getWidth() * getHeight() * getBandCount()) / 8;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    @Override
    public final void writeExternal (final ObjectOutput out)
        throws IOException
      {
        out.writeObject(id);
        out.writeObject((nickName != null) ? nickName : "NULL"); // FIXME: needed? Can writeObject(null)?
        
        final boolean notNull = model != null;
        out.writeBoolean(notNull);

        if (notNull)
          {
            writeRaster(new OutputStream() 
              {
                @Override
                public void write (byte buffer[], int off, int len) throws IOException 
                  {
                    out.write(buffer, off, len);
                  }
                
                @Override
                public void write (int b) throws IOException 
                  {
                    out.write(b);
                  }
              });
          }
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    @Override
    public final void readExternal (final ObjectInput in)
        throws IOException, ClassNotFoundException
      {
        id = (Serializable)in.readObject();
        nickName = (String)in.readObject();
        
        if (nickName.equals("NULL"))
          {
            nickName = null;
          }

        if (in.readBoolean())
          {
            readRaster(new InputStream() 
              {
                @Override
                public int read(byte b[], int off, int len) throws IOException 
                  {
                    return in.read(b, off, len);
                  }
                
                @Override
                public int read() throws IOException 
                  {
                    return in.read();
                  }
            });
          }
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    protected abstract RenderedImage toRenderedImageForSerialization();

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    protected abstract Object toObjectForDeserialization (final RenderedImage renderedImage);
    
    /*******************************************************************************
     *
     * TODO: check performance
     *
     ******************************************************************************/
    protected void writeRaster (final OutputStream out)
        throws IOException
      {
//        System.err.println(CLASS + ".writeExternal() - model: " + model);
/*            ImageWriter imageWriter = null;
            
            for (final Iterator<ImageWriter> i = ImageIO.getImageWritersByFormatName("TIFF"); i.hasNext(); )
              {
                final ImageWriter testImageWriter = i.next();
                
                if ((testImageWriter != null) && testImageWriter.getClass().getName().equals("com.sun.media.imageioimpl.plugins.tiff.TIFFImageWriter"))
                  {
                    imageWriter = testImageWriter;
                    break;  
                  }
              }
            
            if (imageWriter == null)
              {
                throw new RuntimeException("No JAI ImageIO ImageWriter for TIFF format! Can't serialize ImageModel");  
              }  
            
            System.err.println("SERIALIZING WITH " + imageWriter);
            final ImageOutputStream ios = ImageIO.createImageOutputStream(out);
            imageWriter.setOutput(ios);
            imageWriter.write(toRenderedImageForSerialization());
            imageWriter.dispose();*/
        ImageIO.write(toRenderedImageForSerialization(), "TIFF", out);
      }

    /*******************************************************************************
     *
     * TODO: check performance
     *
     ******************************************************************************/
    protected void readRaster (final InputStream in)
        throws IOException
      {
        try 
          {
            Class.forName("com.sun.media.imageioimpl.plugins.tiff.TIFFImageWriter");
          } 
        catch (ClassNotFoundException ex) 
          {
            throw new RuntimeException("Can't deserialize ImageModels since JAI ImageIO is not in the classpath");
          }
        
        model = toObjectForDeserialization(ImageIO.read(in));
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    @Override
    public final String toString ()
      {
        return getClass().getName() + "[id: " + getId() + 
               ((nickName != null) ? (", nickName: " + nickName) : "") +
               //", model: " + model +
                "]";
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    @Override
    protected void finalize()
      {
        // FIXME: not sure about this - for sure should only remove from the local cache
      }
  }
