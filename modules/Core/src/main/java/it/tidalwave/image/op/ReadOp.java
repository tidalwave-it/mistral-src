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
package it.tidalwave.image.op;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.net.URL;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;
import it.tidalwave.image.java2d.Java2DUtils;
import it.tidalwave.image.op.impl.FileChannelImageInputStream;
import it.tidalwave.image.util.Parameters;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@ToString(of = {"input", "imageIndex", "thumbnailIndex"}) @Slf4j
public class ReadOp extends Operation
  {
    /*******************************************************************************************************************
     *
     * A marker interface for allowable options for {@link ReadOp} constructor.
     *
     ******************************************************************************************************************/
    public static interface Options
      {
      }

    /*******************************************************************************************************************
     *
     * A container of plugin names that should not be used to load an image.
     *
     ******************************************************************************************************************/
    @ToString
    public static class PluginBlackList implements Options
      {
        public static final PluginBlackList DEFAULT = new PluginBlackList(
                // WRONG! These are the good ones! But keep for compability until you test everything.
                "com.sun.media.imageioimpl.plugins.jpeg.CLibJPEGImageReader",
                "com.sun.media.imageioimpl.plugins.jpeg.CLibJPEGImageWriter",
                //
                // Considered harmful on Mac OS X. For instance, can only deal with Mac OS X endianness.
                //
                "com.sun.imageio.plugins.tiff.TIFFImageReader"
        );

        private final Set<String> plugins;

        public PluginBlackList (@Nonnull final String... plugins)
          {
            this.plugins = new HashSet<>(Arrays.asList(plugins));
          }

        public boolean contains (@Nonnull final String pluginName)
          {
            return plugins.contains(pluginName);
          }
      }

    @Getter @Nonnull
    private final Object input;

    @Getter @Nonnull
    private final PluginBlackList pluginBlackList;

    @Getter @Nonnull
    private final Type type;

    @Getter @Nonnegative
    private final int imageIndex;

    @Getter @Nonnegative
    private final int thumbnailIndex;

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private abstract static class Reader
      {
        public static EditableImage read (@Nonnull final Object input,
                                          @Nonnull final Reader reader,
                                          @Nonnull final PluginBlackList pluginBlackList)
                throws IOException
          {
            return reader.run(input, pluginBlackList);
          }

        @Nonnull
        private EditableImage run (@Nonnull final Object input,
                                   @Nonnull final PluginBlackList pluginBlackList)
                throws IOException
          {
            Objects.requireNonNull(input, "input");

            if (input instanceof Path)
              {
                final ImageReader imageReader = createImageReader(((Path)input).toFile(), pluginBlackList);
                final EditableImage editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }

            else if (input instanceof File)
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
                final ImageReader imageReader =
                        createImageReader(new ByteArrayInputStream((byte[])input), pluginBlackList);
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

        protected abstract EditableImage read (@Nonnull ImageReader imageReader)
                throws IOException;

        private void setProperties (@Nonnull final EditableImage image, @Nonnull final ImageReader imageReader)
                throws IOException
          {
            image.setAttribute(EditableImage.PROP_FORMAT, imageReader.getFormatName());
            image.setAttribute(EditableImage.PROP_MIME_TYPE, imageReader.getOriginatingProvider().getMIMETypes()[0]);
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public static enum Type implements Options
      {
        /***************************************************************************************************************
         *
         *
         **************************************************************************************************************/
        IMAGE
                  {
                    @Nonnull
                    @Override
                    protected EditableImage read (@Nonnull final ReadOp readOp)
                            throws IOException
                      {
                        final Object input = readOp.getInput();
                        final int imageIndex = readOp.getImageIndex();
                        log.info("read({}, {})", input, imageIndex);

                        return Reader.read(input, new Reader()
                          {
                            @Override
                            protected EditableImage read (final ImageReader imageReader)
                                    throws IOException
                              {
                                final long time = System.currentTimeMillis();
                                final BufferedImage image = imageReader.read(imageIndex);
                                final EditableImage editableImage = create(image);
                                editableImage.loadMetadata(imageReader, imageIndex);
                                Java2DUtils.logImage(log, ">>>> Loaded image: ", image);
                                editableImage.latestOperationTime = System.currentTimeMillis() - time;
                                return editableImage;
                              }
                          }, readOp.getPluginBlackList());
                      }
                  },

        /***************************************************************************************************************
         *
         *
         **************************************************************************************************************/
        THUMBNAIL
                  {
                    @Nonnull
                    @Override
                    protected EditableImage read (@Nonnull final ReadOp readOp)
                            throws IOException
                      {
                        final Object input = readOp.getInput();
                        final int imageIndex = readOp.getImageIndex();
                        final int thumbnailIndex = readOp.getThumbnailIndex();
                        log.info("read({}, {}, {})", input, imageIndex, thumbnailIndex);

                        return Reader.read(input, new Reader()
                          {
                            @Nonnull
                            @Override
                            protected EditableImage read (@Nonnull final ImageReader imageReader)
                                    throws IOException
                              {
                                final long time = System.currentTimeMillis();
                                return create(imageReader.readThumbnail(imageIndex, thumbnailIndex),
                                              System.currentTimeMillis() - time);
                              }
                          }, readOp.getPluginBlackList());
                      }
                  },

        /***************************************************************************************************************
         *
         *
         **************************************************************************************************************/
        METADATA
                  {
                    @Nonnull
                    @Override
                    protected EditableImage read (@Nonnull final ReadOp readOp)
                            throws IOException
                      {
                        final Object input = readOp.getInput();
                        final int imageIndex = readOp.getImageIndex();
                        log.info("read({}, {})", input, imageIndex);

                        return Reader.read(input, new Reader()
                          {
                            @Nonnull
                            @Override
                            protected EditableImage read (@Nonnull final ImageReader imageReader)
                              {
                                final EditableImage editableImage = new EditableImage(null);
                                editableImage.loadMetadata(imageReader, imageIndex);
                                return editableImage;
                              }
                          }, readOp.getPluginBlackList());
                      }
                  };

        /***************************************************************************************************************
         *
         *
         **************************************************************************************************************/
        @Nonnull
        protected abstract EditableImage read (@Nonnull ReadOp readOp)
                throws IOException;

        /***************************************************************************************************************
         *
         *
         **************************************************************************************************************/
        @Nonnull
        private static EditableImage create (@Nonnull final BufferedImage image)
          {
            return new EditableImage(ImplementationFactoryJ2D.getDefault().createImageModel(image));
          }

        /***************************************************************************************************************
         *
         *
         **************************************************************************************************************/
        @Nonnull
        private static EditableImage create (@Nonnull final BufferedImage image, final long time)
          {
            final EditableImage editableImage = create(image);
            editableImage.latestOperationTime = time;
            return editableImage;
          }
      }

    /*******************************************************************************************************************
     *
     * @param  input          the input (an ImageReader or a File)
     *
     ******************************************************************************************************************/
    public ReadOp (@Nonnull final Object input)
      {
        this(input, 0, 0);
      }

    /*******************************************************************************************************************
     *
     * @param  input          the input (an ImageReader or a File)
     * @param  type           the type of read
     *
     ******************************************************************************************************************/
    public ReadOp (@Nonnull final Object input, @Nonnull final Options... options)
      {
        this(input, 0, 0, options);
      }

    /*******************************************************************************************************************
     *
     * @param  input          the input (an ImageReader or a File)
     * @param  type           the type of read
     * @param  imageIndex     the index of the image to read
     *
     ******************************************************************************************************************/
    public ReadOp (@Nonnull final Object input,
                   @Nonnegative final int imageIndex,
                   @Nonnull final Options... options)
      {
        this(input, imageIndex, 0, options);
      }

    /*******************************************************************************************************************
     *
     * @param  input          the input (an ImageReader or a File)
     * @param  type           the type of read
     * @param  imageIndex     the index of the image to read
     * @param  thumbnailIndex the index of the thumbnail to read
     *
     ******************************************************************************************************************/
    public ReadOp (@Nonnull final Object input,
                   @Nonnegative final int imageIndex,
                   @Nonnegative final int thumbnailIndex,
                   @Nonnull final Options... options)
      {
        this.input = input;
        this.type = Parameters.find(Type.class, Type.IMAGE, options);
        this.pluginBlackList = Parameters.find(PluginBlackList.class, PluginBlackList.DEFAULT, options);
        this.imageIndex = imageIndex;
        this.thumbnailIndex = thumbnailIndex;
        log.trace("ReadOp({}, {}, {}, {})", input, imageIndex, thumbnailIndex, options);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public EditableImage execute()
            throws IOException
      {
        return type.read(this);
      }

    /*******************************************************************************************************************
     *
     * Creates an ImageReader for the given File. Using a File as argument is 
     * important for photos that are stored in multiple files (e.g. Canon .CRW format).
     * This method supports files GZIP compression (but multiple file formats such
     * as .CRW aren't supported in this case).
     *
     * @throws IOException  if it is not possible
     *
     ******************************************************************************************************************/
    @Nonnull
    public static ImageReader createImageReader (@Nonnull final File file,
                                                 @Nonnull final PluginBlackList pluginBlackList)
            throws FileNotFoundException, IOException
      {
        log.trace("createImageReader({}, {})", file, pluginBlackList);

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
        final boolean gzipCompression = fileName.toLowerCase().endsWith(".gz");

        if (gzipCompression)
          {
            fileName = fileName.substring(0, fileName.length() - 3);
          }

        final int i = fileName.lastIndexOf('.');

        if (i > 0)
          {
            suffix = fileName.substring(i + 1);
          }

        log.trace(">>>> suffix is {}", suffix);
        ImageInputStream imageInputStream = null;

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
            final InputStream inputStream = new GZIPInputStream(Files.newInputStream(file.toPath()));
            imageInputStream = ImageIO.createImageInputStream(inputStream);
          }

        return createImageReader(imageInputStream, gzipCompression, suffix, pluginBlackList);
      }

    /*******************************************************************************************************************
     *
     * Returns a valid <code>ImageReader</code> for the given URL, or throw an
     * <code>IOException</code> if it's not possible.
     *
     * @param   url          the URL
     * @throws IOException  if it is not possible
     *
     ******************************************************************************************************************/
    @Nonnull
    public static ImageReader createImageReader (@Nonnull final URL url, @Nonnull final PluginBlackList pluginBlackList)
            throws IOException
      {
        log.trace("createImageReader({})", url);

        final String fileName = url.getPath();
        String suffix = "";
        final boolean gzipCompression = fileName.toLowerCase().endsWith(".gz");

        final int i = fileName.lastIndexOf('.');

        if (i > 0)
          {
            suffix = fileName.substring(i + 1);
          }

        log.trace(">>>> suffix is {}", suffix);
        ImageInputStream imageInputStream = null;
        //
        // This will not work with multiple-file formats such as Canon .CRW.
        //
        final InputStream inputStream = gzipCompression ? new GZIPInputStream(url.openStream()) : url.openStream();
        imageInputStream = ImageIO.createImageInputStream(inputStream);
        return createImageReader(imageInputStream, gzipCompression, suffix, pluginBlackList);
      }

    /*******************************************************************************************************************
     *
     * Returns a valid <code>ImageReader</code> for the given stream, or throw 
     * an <code>IOException</code> if it's not possible.
     *
     * @param   inputStream       the input stream
     * @throws IOException       if it is not possible
     *
     ******************************************************************************************************************/
    @Nonnull
    private static ImageReader createImageReader (@Nonnull final InputStream inputStream,
                                                  @Nonnull final PluginBlackList pluginBlackList)
            throws IOException
      {
        log.info("createImageReader({})", inputStream);
        final ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);
        final Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
        return createImageReader(imageInputStream, iterator, pluginBlackList);
      }

    /*******************************************************************************************************************
     *
     * Returns a valid <code>ImageReader</code> for the given stream, or throw 
     * an <code>IOException</code> if it's not possible.
     *
     * @param   imageInputStream  the input stream
     * @param   gzipCompression   if the stream is compressed
     * @param   suffix            the file format suffix (e.g. jpg, tiff,...)
     * @throws IOException       if it is not possible
     *
     ******************************************************************************************************************/
    private static ImageReader createImageReader (@Nonnull final ImageInputStream imageInputStream,
                                                  final boolean gzipCompression,
                                                  @Nonnull final String suffix,
                                                  @Nonnull final PluginBlackList pluginBlackList)
            throws IOException
      {
        log.info("createImageReader({}, {}, {})", imageInputStream, gzipCompression, suffix);
//        logger.finest(">>>> Suffixes: " + Arrays.asList(ImageIO.getReaderFileSuffixes()));
        final Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
        return createImageReader(imageInputStream, iterator, pluginBlackList);
      }

    /*******************************************************************************************************************
     *
     * Returns a valid <code>ImageReader</code> for the given stream, or throw 
     * an <code>IOException</code> if it's not possible.
     *
     * @param   imageInputStream  the input stream
     * @throws IOException       if it is not possible
     *
     ******************************************************************************************************************/
    @Nonnull
    private static ImageReader createImageReader (@Nonnull final ImageInputStream imageInputStream,
                                                  @Nonnull final Iterator<? extends ImageReader> iterator,
                                                  @Nonnull final PluginBlackList pluginBlackList)
            throws IOException
      {
        log.info("createImageReader({}, {})", imageInputStream, iterator);

        // See http://bluemarine.tidalwave.it/issues/browse/MST-137
        final List<ImageReader> readers = new ArrayList<>();
        final List<ImageReader> tiffReaders = new ArrayList<>();

        if (!iterator.hasNext())
          {
            log.warn("Iterator is empty");
          }

        while (iterator.hasNext())
          {
            final ImageReader reader = iterator.next();
            final String pluginClassName = reader.getOriginatingProvider().getPluginClassName();

            if (reader != null)
              {
                log.trace(">>>> pre-testing reader: {}, vendor: {}",
                          reader,
                          reader.getOriginatingProvider().getVendorName());

                if (pluginBlackList.contains(pluginClassName))
                  {
                    log.trace(">>>> {} discarded because it's in the black list", reader);
                  }
                else if (pluginClassName.indexOf("TIFF") <
                         0) // TODO: maybe is it better to test for supported extension or mime?
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
            log.trace(">>>> testing reader: {}, vendor: {}", reader, reader.getOriginatingProvider().getVendorName());

            if (!reader.getOriginatingProvider().canDecodeInput(imageInputStream))
              {
                log.trace(">>>> discarded because it can't decode the input");
                continue;
              }

            reader.setInput(imageInputStream);
            log.trace(">>>> returning reader: {}", reader);
            return reader;
          }

        throw new IOException("No ImageReader");
      }
  }
