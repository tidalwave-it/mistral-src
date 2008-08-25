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
 * $Id: ReadOp.java 926 2008-08-21 22:32:12Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;
import it.tidalwave.image.java2d.Java2DUtils;
import it.tidalwave.image.op.impl.FileChannelImageInputStream;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ReadOp.java 926 2008-08-21 22:32:12Z fabriziogiudici $
 *
 ******************************************************************************/
public class ReadOp extends Operation
  {
    private static final String CLASS = ReadOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);

    private static final Set<String> unwantedPlugins = new HashSet<String>();
    
    private final Object input;
    
    private final Type type;
    
    private final int imageIndex;
    
    private final int thumbnailIndex;

    static
      {
        // WRONG! These are the good ones!
        // In any case, find a way for apps to customize the list of unwanted plugins
        unwantedPlugins.add("com.sun.media.imageioimpl.plugins.jpeg.CLibJPEGImageReader");
        unwantedPlugins.add("com.sun.media.imageioimpl.plugins.jpeg.CLibJPEGImageWriter");
        //
        // Considered harmful on Mac OS X. For instance, can only deal with Mac OS X endianness.
        //
        unwantedPlugins.add("com.sun.imageio.plugins.tiff.TIFFImageReader");
      }
    
    private static abstract class Reader
      {
        public static EditableImage read (final Object input, final Reader reader)
          throws IOException
          {
            if (input == null)
              {
                throw new IOException("Cannot read object");
              }
            
            return reader.run(input);
          }
        
        private EditableImage run (final Object input)
          throws IOException
          {
            if (input instanceof File)
              {
                final ImageReader imageReader = createImageReader((File)input);
                final EditableImage editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }

            else if (input instanceof URL)
              {
                final ImageReader imageReader = createImageReader((URL)input);
                final EditableImage editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }

            else if (input instanceof InputStream)
              {
                final ImageReader imageReader = createImageReader((InputStream)input);
                final EditableImage editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }
            
            else if (input instanceof byte[])
              {
                final ImageReader imageReader = createImageReader(new ByteArrayInputStream((byte[])input));
                final EditableImage editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }
            
            else if (input instanceof ImageReader)
              {
                final EditableImage editableImage = read((ImageReader)input);
                setProperties(editableImage, (ImageReader)input);
                return editableImage;
                // don't dispose the ImageReader in this case
              }
            
            else
              {
                throw new IllegalArgumentException("Bad input type: " + input.getClass());
              }
          }

        protected abstract EditableImage read (ImageReader imageReader)
          throws IOException;
        
        private final void setProperties (final EditableImage image, final ImageReader imageReader)
          throws IOException
          {
            image.setAttribute(EditableImage.PROP_FORMAT, imageReader.getFormatName());
            image.setAttribute(EditableImage.PROP_MIME_TYPE, imageReader.getOriginatingProvider().getMIMETypes()[0]);
          }
      }

    public static enum Type
      {
        /***********************************************************************
         * 
         * 
         **********************************************************************/
        IMAGE
          {
            protected EditableImage read (final ReadOp readOp)
              throws IOException
              {
                final Object input = readOp.getInput();
                final int imageIndex = readOp.getImageIndex();
                logger.info("read(" + input + ", " + imageIndex + ")");
                
                return Reader.read(input, new Reader()
                  {
                    protected EditableImage read (final ImageReader imageReader)
                      throws IOException
                      {
                        final long time = System.currentTimeMillis();
                        final BufferedImage image = imageReader.read(imageIndex);
                        final EditableImage editableImage = create(image);
                        editableImage.loadMetadata(imageReader, imageIndex);
                        Java2DUtils.logImage(logger, ">>>> Loaded image: ", image);
                        editableImage.latestOperationTime = System.currentTimeMillis() - time;
                        return editableImage;
                      }
                  });
              }
          },
          
        /***********************************************************************
         * 
         * 
         **********************************************************************/
        THUMBNAIL
          {
            protected EditableImage read (final ReadOp readOp)
              throws IOException
              {
                final Object input = readOp.getInput();
                final int imageIndex = readOp.getImageIndex();
                final int thumbnailIndex = readOp.getThumbnailIndex();
                logger.info("readThumbnail(" + input + ", " + imageIndex + ", " + thumbnailIndex + ")");

                return Reader.read(input, new Reader()
                  {
                    protected EditableImage read (final ImageReader imageReader)
                      throws IOException
                      {
                        long time = System.currentTimeMillis();
                        return create(imageReader.readThumbnail(imageIndex, thumbnailIndex), System.currentTimeMillis() - time);
                      }
                  });
              }
          },
          
        /***********************************************************************
         * 
         * 
         **********************************************************************/
        METADATA
          {
            protected EditableImage read (final ReadOp readOp)
              throws IOException
              {
                final Object input = readOp.getInput();
                final int imageIndex = readOp.getImageIndex();
                logger.info("readMetadata(" + input + ", " + imageIndex + ")");

                return Reader.read(input, new Reader()
                  {
                    protected EditableImage read (final ImageReader imageReader)
                      throws IOException
                      {
                        final EditableImage editableImage = new EditableImage(null);
                        editableImage.loadMetadata(imageReader, imageIndex);
                        return editableImage;
                      }
                  });
              }
          };
          
        /***********************************************************************
         * 
         * 
         **********************************************************************/
        protected abstract EditableImage read (ReadOp readOp)
          throws IOException;
        
        /***********************************************************************
         * 
         * 
         **********************************************************************/
        private static EditableImage create (final BufferedImage image)
          {
            return new EditableImage(ImplementationFactoryJ2D.getInstance().createImageModel(image));
          }
        
        /***********************************************************************
         * 
         * 
         **********************************************************************/
        private static EditableImage create (final BufferedImage image, final long time)
          {
            final EditableImage editableImage = create(image);
            editableImage.latestOperationTime = time;
            return editableImage;
          }
      }

    /***************************************************************************
     * 
     * @param  input          the input (an ImageReader or a File)
     *
     **************************************************************************/
    public ReadOp (final Object input)
      {
        this(input, Type.IMAGE, 0, 0);  
      }
    
    /***************************************************************************
     * 
     * @param  input          the input (an ImageReader or a File)
     * @param  type           the type of read
     *
     **************************************************************************/
    public ReadOp (final Object input, final Type type)
      {
        this(input, type, 0, 0);  
      }
    
    /***************************************************************************
     * 
     * @param  input          the input (an ImageReader or a File)
     * @param  type           the type of read
     * @param  imageIndex     the index of the image to read
     *
     **************************************************************************/
    public ReadOp (final Object input, final Type type, final int imageIndex)
      {
        this(input, type, imageIndex, 0);  
      }
    
    /***************************************************************************
     * 
     * @param  input          the input (an ImageReader or a File)
     * @param  type           the type of read
     * @param  imageIndex     the index of the image to read
     * @param  thumbnailIndex the index of the thumbnail to read
     *
     **************************************************************************/
    public ReadOp (final Object input, final Type type, final int imageIndex, final int thumbnailIndex)
      {
        if (input == null)
          {
            throw new IllegalArgumentException("null input");    
          }
        
        if (type == null)
          {
            throw new IllegalArgumentException("Type is mandatory");  
          }

        this.input = input;
        this.type = type;
        this.imageIndex = imageIndex;
        this.thumbnailIndex = thumbnailIndex;
      }
    
    /***************************************************************************
     * 
     * 
     **************************************************************************/
    public Object getInput()
      {
        return input;  
      }
    
    /***************************************************************************
     * 
     * 
     **************************************************************************/
    public int getImageIndex()
      {
        return imageIndex;  
      }

    /***************************************************************************
     * 
     * 
     **************************************************************************/
    public int getThumbnailIndex()
      {
        return thumbnailIndex;  
      }

    /***************************************************************************
     * 
     * 
     **************************************************************************/
    public EditableImage execute()
      throws IOException
      {
        return type.read(this);
      }
     
    /***************************************************************************
     *
     * Creates an ImageReader for the given File. Using a File as argument is 
     * important for photos that are stored in multiple files (e.g. Canon .CRW format).
     * This method supports files GZIP compression (but multiple file formats such
     * as .CRW aren't supported in this case).
     *
     * @throws  IOException  if it is not possible
     *
     **************************************************************************/
    public static ImageReader createImageReader (final File file) 
      throws FileNotFoundException, IOException
      {
        logger.fine("createImageReader(" + file + ")");

        if (!file.exists())
          {
            throw new FileNotFoundException(file.getAbsolutePath());
          }
        
        if (!file.canRead())
          {
            throw new IOException("Cannot read " + file.getAbsolutePath());
          }
            
        String fileName = file.getName();
        String suffix = "";
        boolean gzipCompression = fileName.toLowerCase().endsWith(".gz");
        
        if (gzipCompression)
          {
            fileName = fileName.substring(0, fileName.length() - 3);  
          }

        int i = fileName.lastIndexOf('.');

        if (i > 0)
          {
            suffix = fileName.substring(i + 1);
          }

        logger.finer(">>>> suffix is " + suffix);
        ImageInputStream imageInputStream = null;

        try
          {
            //
            // For reasons stated in the javadoc comment of this method, it's better
            // to create the ImageInputStream by passing a File.
            //
            if (!gzipCompression)
              {
                imageInputStream = new FileChannelImageInputStream(file);
//                imageInputStream = ImageIO.createImageInputStream(file);
              }
            //
            // This will not work with multiple-file formats such as Canon .CRW.
            //
            else
              {
                InputStream inputStream = new GZIPInputStream(new FileInputStream(file));
                imageInputStream = ImageIO.createImageInputStream(inputStream);
              }

            return createImageReader(imageInputStream, gzipCompression, suffix);
          }
        catch (IOException e)
          {
            logger.throwing(CLASS, "getImageReader()", e);
            safeClose(imageInputStream);
            throw e;
          }
      }

    /***************************************************************************
     *
     * Returns a valid <code>ImageReader</code> for the given URL, or throw an
     * <code>IOException</code> if it's not possible.
     *
     * @param   url          the URL
     * @throws  IOException  if it is not possible
     *
     **************************************************************************/
    public static ImageReader createImageReader (final URL url) 
      throws IOException
      {
        logger.fine("createImageReader(" + url + ")");

        String fileName = url.getPath();
        String suffix = "";
        boolean gzipCompression = fileName.toLowerCase().endsWith(".gz");
        
        int i = fileName.lastIndexOf('.');

        if (i > 0)
          {
            suffix = fileName.substring(i + 1);
          }

        logger.finer(">>>> suffix is " + suffix);
        ImageInputStream imageInputStream = null;

        try
          {
            //
            // This will not work with multiple-file formats such as Canon .CRW.
            //
            InputStream inputStream = gzipCompression ? new GZIPInputStream(url.openStream()) : url.openStream();
            imageInputStream = ImageIO.createImageInputStream(inputStream);
            return createImageReader(imageInputStream, gzipCompression, suffix);
          }
        catch (IOException e)
          {
            logger.throwing(CLASS, "createImageReader()", e);
            safeClose(imageInputStream);
            throw e;
          }
      }

    /***************************************************************************
     *
     * Returns a valid <code>ImageReader</code> for the given stream, or throw 
     * an <code>IOException</code> if it's not possible.
     *
     * @param   inputStream       the input stream
     * @throws  IOException       if it is not possible
     *
     **************************************************************************/
    private static ImageReader createImageReader (final InputStream inputStream) 
      throws IOException 
      {
        logger.info("createImageReader(" + inputStream + ")");       
        final ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);
        final Iterator <ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
        return createImageReader(imageInputStream, iterator);
      }
        
    /***************************************************************************
     *
     * Returns a valid <code>ImageReader</code> for the given stream, or throw 
     * an <code>IOException</code> if it's not possible.
     *
     * @param   imageInputStream  the input stream
     * @param   gzipCompression   if the stream is compressed
     * @param   suffix            the file format suffix (e.g. jpg, tiff,...)
     * @throws  IOException       if it is not possible
     *
     **************************************************************************/
    private static ImageReader createImageReader (final ImageInputStream imageInputStream, 
                                                  final boolean gzipCompression, 
                                                  final String suffix) 
      throws IOException                                                  
      {
        logger.info("createImageReader(" + imageInputStream + ", " + gzipCompression + ", " + suffix + ")");       
//        logger.finest(">>>> Suffixes: " + Arrays.asList(ImageIO.getReaderFileSuffixes()));
        final Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
        return createImageReader(imageInputStream, iterator);
      }
    
    /***************************************************************************
     *
     * Returns a valid <code>ImageReader</code> for the given stream, or throw 
     * an <code>IOException</code> if it's not possible.
     *
     * @param   imageInputStream  the input stream
     * @throws  IOException       if it is not possible
     *
     **************************************************************************/
    private static ImageReader createImageReader (final ImageInputStream imageInputStream, 
                                                  final Iterator<ImageReader> iterator) 
      throws IOException                                                  
      {
        logger.info("createImageReader(" + imageInputStream + ", " + iterator + ")");
        
        try
          {
            // See http://bluemarine.tidalwave.it/issues/browse/MST-137
            final List<ImageReader> readers = new ArrayList<ImageReader>();
            final List<ImageReader> tiffReaders = new ArrayList<ImageReader>();
            
            while (iterator.hasNext())
              {
                final ImageReader reader = iterator.next();
                final String pluginClassName = reader.getOriginatingProvider().getPluginClassName();

                if (reader != null)
                  {
                    logger.finer(">>>> pre-testing reader: " + reader + ", vendor: " + reader.getOriginatingProvider().getVendorName());
                    
                    if (unwantedPlugins.contains(pluginClassName))
                      {
                        logger.finest(">>>> discarded because it's in the black list");
                        continue;  
                      }
                    else if (pluginClassName.indexOf("TIFF") < 0) // TODO: maybe is it better to test for supported extension or mime?
                      {
                        readers.add(reader);  
                      }
                    else
                      {
                        tiffReaders.add(reader);  
                      }
                  }
              }
            
            readers.addAll(tiffReaders);
            
            for (final ImageReader reader : readers)
              {
                logger.finer(">>>> testing reader: " + reader + ", vendor: " + reader.getOriginatingProvider().getVendorName());

                if (!reader.getOriginatingProvider().canDecodeInput(imageInputStream))
                  {
                    logger.finest(">>>> discarded because it can't decode the input");
                    continue;  
                  }

                reader.setInput(imageInputStream);
                logger.finer(">>>> returning reader: " + reader);
                return reader;
              }
                
            throw new IOException("No ImageReader");
          }
        catch (IOException e)
          {
            logger.throwing(CLASS, "getImageReader()", e);
            logger.finer(">>>> returning null");
            safeClose(imageInputStream);
            throw e;
          }
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    private static void safeClose (final ImageInputStream imageInputStream)
      {
        try
          {
            if (imageInputStream != null)
              {
                imageInputStream.close();
              }
          }
        catch (IOException e)
          {
            logger.throwing(CLASS, "safeClose()", e);
          }
      }
    
    /***************************************************************************
     * 
     * @inheritDoc
     * 
     **************************************************************************/
    @Override
    public String toString()
      {
        return "ReadOp(" + input + ", " + imageIndex + ", " + thumbnailIndex + ")";
      }
  }
