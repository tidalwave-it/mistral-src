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
 * $Id: ReadOp.java 944 2008-09-02 15:58:32Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.Arrays;
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
import it.tidalwave.bluemarine.arguments.Arguments;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ReadOp.java 944 2008-09-02 15:58:32Z fabriziogiudici $
 *
 ******************************************************************************/
public class ReadOp extends Operation
  {
    private static final String CLASS = ReadOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);
    
    /***************************************************************************
     * 
     * A marker interface for allowable options for {@link ReadOp} constructor.
     * 
     **************************************************************************/
    public static interface Options
      {
      }
    
    /***************************************************************************
     * 
     * A container of plugin names that should not be used to load an image.
     * 
     **************************************************************************/
    public static class PluginBlackList implements Options 
      {
        public final static PluginBlackList DEFAULT = new PluginBlackList(
            // WRONG! These are the good ones! But keep for compability until you test everything.
            "com.sun.media.imageioimpl.plugins.jpeg.CLibJPEGImageReader",
            "com.sun.media.imageioimpl.plugins.jpeg.CLibJPEGImageWriter",
            //
            // Considered harmful on Mac OS X. For instance, can only deal with Mac OS X endianness.
            //
            "com.sun.imageio.plugins.tiff.TIFFImageReader"
            );
        
        private final Set<String> plugins;
        
        public PluginBlackList (@Nonnull final String ... plugins)
          {
            this.plugins = new HashSet<String>(Arrays.asList(plugins)); 
          }
        
        public boolean contains (@Nonnull final String pluginName)
          {
            return plugins.contains(pluginName);  
          }

        @Override
        public String toString() 
          {
            return String.format("PluginBlackList%s", plugins);
          }
      }
    
    @Nonnull
    private final Object input;
    
    @Nonnull
    private final PluginBlackList pluginBlackList;
    
    @Nonnull
    private final Type type;

    @Nonnegative
    private final int imageIndex;
    
    @Nonnegative
    private final int thumbnailIndex;

    private static abstract class Reader
      {
        public static EditableImage read (final Object input, 
                                          final Reader reader,
                                          final PluginBlackList pluginBlackList)
          throws IOException
          {
            if (input == null)
              {
                throw new IOException("Cannot read object, input is null");
              }
            
            return reader.run(input, pluginBlackList);
          }
        
        private EditableImage run (final Object input, final PluginBlackList pluginBlackList)
          throws IOException
          {
            if (input instanceof File)
              {
                final ImageReader imageReader = createImageReader((File)input, pluginBlackList);
                final EditableImage editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }

            else if (input instanceof URL)
              {
                final ImageReader imageReader = createImageReader((URL)input, pluginBlackList);
                final EditableImage editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }

            else if (input instanceof InputStream)
              {
                final ImageReader imageReader = createImageReader((InputStream)input, pluginBlackList);
                final EditableImage editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }
            
            else if (input instanceof byte[])
              {
                final ImageReader imageReader = createImageReader(new ByteArrayInputStream((byte[])input), pluginBlackList);
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

    /***************************************************************************
     * 
     * 
     **************************************************************************/
    public static enum Type implements Options
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
                  }, readOp.getPluginBlackList());
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
                  }, readOp.getPluginBlackList());
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
                  }, readOp.getPluginBlackList());
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
    public ReadOp (@Nonnull final Object input)
      {
        this(input, 0, 0);  
      }
    
    /***************************************************************************
     * 
     * @param  input          the input (an ImageReader or a File)
     * @param  type           the type of read
     *
     **************************************************************************/
    public ReadOp (@Nonnull final Object input, @Nonnull final Options ... options)
      {
        this(input, 0, 0, options);  
      }
    
    /***************************************************************************
     * 
     * @param  input          the input (an ImageReader or a File)
     * @param  type           the type of read
     * @param  imageIndex     the index of the image to read
     *
     **************************************************************************/
    public ReadOp (@Nonnull final Object input,
                   @Nonnegative final int imageIndex,
                   @Nonnull final Options ... options)
      {
        this(input, imageIndex, 0, options);  
      }
    
    /***************************************************************************
     * 
     * @param  input          the input (an ImageReader or a File)
     * @param  type           the type of read
     * @param  imageIndex     the index of the image to read
     * @param  thumbnailIndex the index of the thumbnail to read
     *
     **************************************************************************/
    public ReadOp (final @Nonnull Object input, 
                   final @Nonnegative int imageIndex, 
                   final @Nonnegative int thumbnailIndex,
                   final @Nonnull Options ... options)
      {
        if (input == null)
          {
            throw new IllegalArgumentException("null input");    
          }
        
        this.input = input;
        this.type = Arguments.find (Type.class, Type.IMAGE, options);
        this.pluginBlackList = Arguments.find(PluginBlackList.class, PluginBlackList.DEFAULT, options);
        this.imageIndex = imageIndex;
        this.thumbnailIndex = thumbnailIndex;
        logger.fine(String.format("ReadOp(%s, %d, %d, %s)", input, imageIndex, thumbnailIndex, Arrays.asList(options)));
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
    public static ImageReader createImageReader (final File file, final PluginBlackList pluginBlackList) 
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

            return createImageReader(imageInputStream, gzipCompression, suffix, pluginBlackList);
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
    public static ImageReader createImageReader (final URL url, final PluginBlackList pluginBlackList) 
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
            return createImageReader(imageInputStream, gzipCompression, suffix, pluginBlackList);
          }
        catch (IOException e)
          {
            logger.throwing(CLASS, "createImageReader()", e);
            safeClose(imageInputStream);
            throw e;
          }
      }

    @Nonnull
    private PluginBlackList getPluginBlackList() 
      {
        return pluginBlackList;
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
    private static ImageReader createImageReader (final InputStream inputStream,
                                                  final PluginBlackList pluginBlackList) 
      throws IOException 
      {
        logger.info("createImageReader(" + inputStream + ")");       
        final ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);
        final Iterator <ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
        return createImageReader(imageInputStream, iterator, pluginBlackList);
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
                                                  final String suffix,
                                                  final PluginBlackList pluginBlackList) 
      throws IOException                                                  
      {
        logger.info("createImageReader(" + imageInputStream + ", " + gzipCompression + ", " + suffix + ")");       
//        logger.finest(">>>> Suffixes: " + Arrays.asList(ImageIO.getReaderFileSuffixes()));
        final Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
        return createImageReader(imageInputStream, iterator, pluginBlackList);
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
                                                  final Iterator<ImageReader> iterator,
                                                  final PluginBlackList pluginBlackList) 
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
                    
                    if (pluginBlackList.contains(pluginClassName))
                      {
                        logger.finest(String.format(">>>> %s discarded because it's in the black list", reader));
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
