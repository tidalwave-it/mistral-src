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
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import java.net.URL;
import java.awt.image.BufferedImage;
import it.tidalwave.util.Parameters;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;
import it.tidalwave.image.java2d.Java2DUtils;
import it.tidalwave.image.metadata.Directory;
import it.tidalwave.image.metadata.EXIF;
import it.tidalwave.image.metadata.IPTC;
import it.tidalwave.image.metadata.MakerNote;
import it.tidalwave.image.metadata.TIFF;
import it.tidalwave.image.metadata.XMP;
import it.tidalwave.image.metadata.loader.DirectoryLoader;
import it.tidalwave.image.metadata.loader.DrewMetadataLoader;
import it.tidalwave.image.metadata.loader.JpegDrewMetadataLoader;
import it.tidalwave.image.metadata.loader.MetadataLoader;
import it.tidalwave.image.metadata.loader.RAWMetadataLoader;
import it.tidalwave.image.metadata.loader.TIFFMetadataLoader;
import it.tidalwave.image.op.impl.FileChannelImageInputStream;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import static it.tidalwave.util.FunctionalCheckedExceptionWrappers.*;

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
                final var imageReader = createImageReader(((Path)input), pluginBlackList);
                final var editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }

            else if (input instanceof File)
              {
                final var imageReader = createImageReader(((File)input).toPath(), pluginBlackList);
                final var editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }

            else if (input instanceof URL)
              {
                final var imageReader = createImageReader((URL)input, pluginBlackList);
                final var editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }

            else if (input instanceof InputStream)
              {
                final var imageReader = createImageReader((InputStream)input, pluginBlackList);
                final var editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }

            else if (input instanceof byte[])
              {
                final var imageReader = createImageReader(new ByteArrayInputStream((byte[])input), pluginBlackList);
                final var editableImage = read(imageReader);
                setProperties(editableImage, imageReader);
                imageReader.dispose();
                return editableImage;
              }

            else if (input instanceof ImageReader)
              {
                final var editableImage = read((ImageReader)input);
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
                    @Override @Nonnull
                    protected EditableImage read (@Nonnull final ReadOp readOp)
                            throws IOException
                      {
                        final var input = readOp.getInput();
                        final var imageIndex = readOp.getImageIndex();
                        log.info("read({}, {})", input, imageIndex);

                        return Reader.read(input, new Reader()
                          {
                            @Override
                            protected EditableImage read (final ImageReader imageReader)
                                    throws IOException
                              {
                                final var time = Instant.now();
                                final var image = imageReader.read(imageIndex);
                                final var editableImage = create(image);
                                loadMetadata(editableImage, imageReader, imageIndex);
                                Java2DUtils.logImage(log, ">>>> Loaded image: ", image);
                                editableImage.getInnerProperty(AccessorOp.class).setLatestOperationDuration(Duration.between(Instant.now(), time));
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
                    @Override @Nonnull
                    protected EditableImage read (@Nonnull final ReadOp readOp)
                            throws IOException
                      {
                        final var input = readOp.getInput();
                        final var imageIndex = readOp.getImageIndex();
                        final var thumbnailIndex = readOp.getThumbnailIndex();
                        log.info("read({}, {}, {})", input, imageIndex, thumbnailIndex);

                        return Reader.read(input, new Reader()
                          {
                            @Nonnull
                            @Override
                            protected EditableImage read (@Nonnull final ImageReader imageReader)
                                    throws IOException
                              {
                                final var time = Instant.now();
                                return create(imageReader.readThumbnail(imageIndex, thumbnailIndex),
                                              Duration.between(Instant.now(), time));
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
                    @Override @Nonnull
                    protected EditableImage read (@Nonnull final ReadOp readOp)
                            throws IOException
                      {
                        final var input = readOp.getInput();
                        final var imageIndex = readOp.getImageIndex();
                        log.info("read({}, {})", input, imageIndex);

                        return Reader.read(input, new Reader()
                          {
                            @Nonnull
                            @Override
                            protected EditableImage read (@Nonnull final ImageReader imageReader)
                              {
                                final var editableImage = new EditableImage(null);
                                loadMetadata(editableImage, imageReader, imageIndex);
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
        private static EditableImage create (@Nonnull final BufferedImage image,
                                             @Nonnull final Duration latestOperationDuration)
          {
            final var editableImage = create(image);
            editableImage.getInnerProperty(AccessorOp.class).setLatestOperationDuration(latestOperationDuration);
            return editableImage;
          }
      }

    /*******************************************************************************************************************
     *
     * @param  input          the input (an ImageReader or a Path)
     *
     ******************************************************************************************************************/
    public ReadOp (@Nonnull final Object input)
      {
        this(input, 0, 0);
      }

    /*******************************************************************************************************************
     *
     * @param  input          the input (an ImageReader or a Path)
     * @param  type           the type of read
     *
     ******************************************************************************************************************/
    public ReadOp (@Nonnull final Object input, @Nonnull final Options... options)
      {
        this(input, 0, 0, options);
      }

    /*******************************************************************************************************************
     *
     * @param  input          the input (an ImageReader or a Path)
     * @param  type           the type of read
     * @param  imageIndex     the index of the image to read
     *
     ******************************************************************************************************************/
    public ReadOp (@Nonnull final Object input, @Nonnegative final int imageIndex, @Nonnull final Options... options)
      {
        this(input, imageIndex, 0, options);
      }

    /*******************************************************************************************************************
     *
     * @param  input          the input (an ImageReader or a Path)
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
     * Creates an ImageReader for the given Path. Using a Path as argument is
     * important for photos that are stored in multiple files (e.g. Canon .CRW format).
     * This method supports files GZIP compression (but multiple file formats such
     * as .CRW aren't supported in this case).
     *
     * @throws IOException  if it is not possible
     *
     ******************************************************************************************************************/
    @Nonnull
    public static ImageReader createImageReader (@Nonnull final Path file,
                                                 @Nonnull final PluginBlackList pluginBlackList)
            throws IOException
      {
        log.trace("createImageReader({}, {})", file, pluginBlackList);

        if (!Files.exists(file))
          {
            throw new FileNotFoundException(file.toAbsolutePath().toString());
          }

        if (!Files.isReadable(file))
          {
            throw new IOException("Cannot read " + file.toAbsolutePath());
          }

        var fileName = file.getFileName().toString();
        var suffix = "";
        final var gzipCompression = fileName.toLowerCase().endsWith(".gz");

        if (gzipCompression)
          {
            fileName = fileName.substring(0, fileName.length() - 3);
          }

        final var i = fileName.lastIndexOf('.');

        if (i > 0)
          {
            suffix = fileName.substring(i + 1);
          }

        log.trace(">>>> suffix is {}", suffix);
        ImageInputStream imageInputStream = null;

        //
        // For reasons stated in the javadoc comment of this method, it's better
        // to create the ImageInputStream by passing a Path.
        //
        if (!gzipCompression)
          {
            imageInputStream = new FileChannelImageInputStream(file.toFile());
//                imageInputStream = ImageIO.createImageInputStream(file);
          }
        //
        // This will not work with multiple-file formats such as Canon .CRW.
        //
        else
          {
            final InputStream inputStream = new GZIPInputStream(Files.newInputStream(file));
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

        final var fileName = url.getPath();
        var suffix = "";
        final var gzipCompression = fileName.toLowerCase().endsWith(".gz");

        final var i = fileName.lastIndexOf('.');

        if (i > 0)
          {
            suffix = fileName.substring(i + 1);
          }

        log.trace(">>>> suffix is {}", suffix);
        ImageInputStream imageInputStream = null;
        //
        // This will not work with multiple-file formats such as Canon .CRW.
        //
        final var inputStream = gzipCompression ? new GZIPInputStream(url.openStream()) : url.openStream();
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
        final var imageInputStream = ImageIO.createImageInputStream(inputStream);
        final var iterator = ImageIO.getImageReaders(imageInputStream);
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
        final var iterator = ImageIO.getImageReaders(imageInputStream);
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
            final var reader = iterator.next();
            final var pluginClassName = reader.getOriginatingProvider().getPluginClassName();

            if (reader != null)
              {
                log.trace(">>>> pre-testing reader: {}, vendor: {}",
                          reader,
                          reader.getOriginatingProvider().getVendorName());

                if (pluginBlackList.contains(pluginClassName))
                  {
                    log.trace(">>>> {} discarded because it's in the black list", reader);
                  }
                else if (!pluginClassName.contains("TIFF")) // TODO: maybe is it better to test for supported extension or mime?
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

        for (final var reader : readers)
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

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static void loadMetadata (final @Nonnull EditableImage image,
                                      final @Nonnull ImageReader reader,
                                      final @Nonnegative int imageIndex)
      {
        log.trace("loadMetadata({}, {})", reader, imageIndex);
        var accessor = image.getInnerProperty(AccessorOp.class);
        var metadataMapByClass = accessor.getMetadataMapByClass();
        final IIOMetadata iioMetadata;

        try
          {
            iioMetadata = reader.getImageMetadata(imageIndex);
          }
        catch (Exception e)
          {
            throw new RuntimeException(e);
            /*
            if ("ICC APP2 encountered without prior JFIF!".equals(e.getMessage()) && (workaroundBM25 != null))
              {
                try
                  {
                    var tiff = new TIFF();
                    var exif = new EXIF();
                    var iptc = new IPTC();
                    var xmp = new XMP();
                    workaroundBM25.loadExifAndIptcFromJpeg(reader, tiff, exif, iptc, xmp);
                    metadataMapByClass.put(TIFF.class, List.of(tiff));
                    metadataMapByClass.put(EXIF.class, List.of(exif));
                    metadataMapByClass.put(IPTC.class, List.of(iptc));
                    metadataMapByClass.put(XMP.class, List.of(xmp));
                  }
                catch (Exception e1)
                  {
                    log.error("Cannot load EXIF/IPTC metadata: ", e1);
                  }
              }
            else
              {
                log.error("Cannot load EXIF/IPTC metadata: ", e);
              }

            return;
             */
          }

        if (iioMetadata == null)
          {
            log.warn(">>>> null imagemetadata");
            return;
          }

        accessor.setIIOMetadata(iioMetadata);

        var iioMetadataClass = iioMetadata.getClass();
        final MetadataLoader metadataLoader;

        if (isSubClass(iioMetadataClass, "com.sun.imageio.plugins.jpeg.JPEGMetadata"))
          {
            metadataLoader = new JpegDrewMetadataLoader(reader);
          }
        else if (isSubClass(iioMetadataClass, "com.sun.media.imageio.plugins.tiff.TIFFImageMetadata"))
          {
            metadataLoader = new TIFFMetadataLoader();
          }
        else if (isSubClass(iioMetadataClass, "it.tidalwave.imageio.raw.RAWMetadataSupport"))
          {
            metadataLoader = new RAWMetadataLoader();
          }
        else
          {
            metadataLoader = new DrewMetadataLoader();
          }

        log.debug(">>>> iioMetadata class: {}, using metadata loader: {}", iioMetadataClass, metadataLoader.getClass());

        try
          {
            List.of(TIFF.class, EXIF.class, MakerNote.class, IPTC.class, XMP.class)
                .forEach(_c(t -> metadataMapByClass.put(t, loadDirectories(iioMetadata, metadataLoader, t))));
          }
        catch (Exception e)
          {
            log.error("loadMetadata()", e);
          }
      }

    /*******************************************************************************************************************
     *
     * Loads directories of metadata by means of a loader.
     *
     * @param   iioMetadata
     * @param   metadataLoader    the metadata loader
     * @param   directoryClass    the type of the directory to laod
     * @return                    the loaded items
     *
     ******************************************************************************************************************/
    private static <T extends Directory> List<Directory> loadDirectories (final @Nonnull IIOMetadata iioMetadata,
                                                                          final @Nonnull MetadataLoader metadataLoader,
                                                                          final @Nonnull Class<T> directoryClass)
      {
        log.debug("loadDirectories({}, {}, {})", iioMetadata, metadataLoader, directoryClass);
        final var items = new ArrayList<Directory>();
        Optional<DirectoryLoader> loader = Optional.empty();

        // FIXME: get rid of the if chain
        if (TIFF.class.equals(directoryClass))
          {
            loader = metadataLoader.getTiffLoader(iioMetadata);
          }
        else if (EXIF.class.equals(directoryClass))
          {
            loader = metadataLoader.getExifLoader(iioMetadata);
          }
        else if (IPTC.class.equals(directoryClass))
          {
            loader = metadataLoader.getIptcLoader(iioMetadata);
          }
        else if (XMP.class.equals(directoryClass))
          {
            loader = metadataLoader.getXmpLoader(iioMetadata);
          }
        else if (MakerNote.class.equals(directoryClass))
          {
            loader = metadataLoader.getMakerNoteLoader(iioMetadata);
          }

        loader.ifPresentOrElse(_c(a -> items.addAll(loadDirectories(a, directoryClass))),
                               () -> log.warn("No loader for {}", directoryClass));
        return items;
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    private static List<Directory> loadDirectories (@Nonnull DirectoryLoader loader,
                                                    final @Nonnull Class<? extends Directory> itemClass)
            throws InstantiationException, IllegalAccessException
      {
        var result = new ArrayList<Directory>();

        for (; ; loader = loader.next())
          {
            final var item = itemClass.newInstance();
            item.load(loader);
            result.add(item);

            if (!loader.hasNext())
              {
                break;
              }
          }

        return result;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static boolean isSubClass (@Nonnull Class<?> aClass, final @Nonnull String ancestorClassName)
      {
        for (; aClass != null; aClass = aClass.getSuperclass())
          {
            if (aClass.getName().equals(ancestorClassName))
              {
                return true;
              }
          }

        return false;
      }
  }
