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
package it.tidalwave.image;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.imageio.metadata.IIOMetadata;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import it.tidalwave.util.Key;
import it.tidalwave.util.TypeSafeMap;
import it.tidalwave.image.metadata.Directory;
import it.tidalwave.image.metadata.EXIF;
import it.tidalwave.image.metadata.IPTC;
import it.tidalwave.image.metadata.MakerNote;
import it.tidalwave.image.metadata.TIFF;
import it.tidalwave.image.metadata.XMP;
import it.tidalwave.image.op.AbstractCreateOp;
import it.tidalwave.image.op.AccessorOp;
import it.tidalwave.image.op.ImplementationFactoryRegistry;
import it.tidalwave.image.op.Operation;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.ReadOp;
import it.tidalwave.image.op.ScaleOp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * An opaque class which encapsulates all the image manipulation logics, and allows the implementation of these logics 
 * to be transparently changed (e.g. by using or not JAI, etc...)
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@ToString(of = {"imageModelHolder", "attributeMapByName"}) @Slf4j
public final class EditableImage implements Cloneable, Serializable // Externalizable
  {
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @RequiredArgsConstructor
    public static enum DataType
      {
        BYTE(DataBuffer.TYPE_BYTE),
        UNSIGNED_SHORT(DataBuffer.TYPE_USHORT),
        SHORT(DataBuffer.TYPE_SHORT),
        INT(DataBuffer.TYPE_INT),
        FLOAT(DataBuffer.TYPE_FLOAT),
        DOUBLE(DataBuffer.TYPE_DOUBLE),
        UNDEFINED(DataBuffer.TYPE_UNDEFINED);

        @Getter
        private final int value;

        /***************************************************************************************************************
         *
         * Returns the size in bits of this data type.
         *
         **************************************************************************************************************/
        @Nonnegative
        public int getSize()
          {
            return DataBuffer.getDataTypeSize(value);
          }

        /***************************************************************************************************************
         *
         *
         **************************************************************************************************************/
        @Nonnull
        public static DataType valueOf (final int value)
          {
            for (final var dataType : DataType.values())
              {
                if (dataType.value == value)
                  {
                    return dataType;
                  }
              }

            return EditableImage.DataType.UNDEFINED;
          }
      }

    @RequiredArgsConstructor
    public static class Accessor // FIXME: protected
      {
        @Nonnull
        private final EditableImage image;

        public void setIIOMetadata (@Nonnull final IIOMetadata iioMetadata)
          {
            image.iioMetadata = iioMetadata;
          }

        @Nonnull
        public Map<Class<? extends Directory>, List<Directory>> getMetadataMapByClass ()
          {
            return image.metadataMapByClass;
          }

        public void setLatestOperationDuration (@Nonnull final Duration latestOperationDuration)
          {
            image.latestOperationDuration = latestOperationDuration;
          }
      }

    private final AccessorOp accessor = new AccessorOp(this);

    private static final long serialVersionUID = -4524534539832240717L;
    private static final String CLASS = EditableImage.class.getName();

    public static final Key<String> PROP_FORMAT = Key.of(CLASS + ".format", String.class);

    public static final Key<String> PROP_MIME_TYPE = Key.of(CLASS + ".mimeType", String.class);

    /** The current image model. */
    private ImageModelHolder imageModelHolder;

    /** The metadata as it comes from Image I/O. */
    private transient IIOMetadata iioMetadata; // TODO make it serializable

    private final Map<Class<? extends Directory>, List<Directory>> metadataMapByClass = new HashMap<>();

    /** The attributes. */
    @Nonnull
    private TypeSafeMap attributeMapByName = TypeSafeMap.newInstance();

    private Duration latestOperationDuration;

    @Nonnegative
    private int latestSerializationSize;

    /*******************************************************************************************************************
     *
     * For serialization only. Do not use.
     *
     ******************************************************************************************************************/
    public EditableImage()
      {
        // By default put empty objects for which isAvailable() returns false
        metadataMapByClass.put(TIFF.class, List.of(new TIFF()));
        metadataMapByClass.put(EXIF.class, List.of(new EXIF()));
        metadataMapByClass.put(IPTC.class, List.of(new IPTC()));
        metadataMapByClass.put(XMP.class, List.of(new XMP()));
        metadataMapByClass.put(MakerNote.class, List.of(new MakerNote()));
      }

    /*******************************************************************************************************************
     *
     * For inner implementation only. Do not use.
     *
     ******************************************************************************************************************/
    public EditableImage (final ImageModel imageModel) // FIXME: try to make it protected
      {
        // null imageModel is accepted for instances carrying only metadata
        imageModelHolder = ImageModelHolder.wrap(imageModel);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setNickName (final @Nonnull String nickName)
      {
        if (imageModelHolder != null)
          {
            imageModelHolder.setNickName(nickName);
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public Optional<String> getNickName()
      {
        return (imageModelHolder != null) ? Optional.ofNullable(imageModelHolder.getNickName()) : Optional.empty();
      }

    /*******************************************************************************************************************
     *
     * Creates a new EditableImage as specified by the parameter
     *
     * @param   createOp  the way the image should be created
     * @return the image
     *
     ******************************************************************************************************************/
    @Nonnull
    public static EditableImage create (@Nonnull final AbstractCreateOp createOp)
      {
        final var editableImage = new EditableImage(null);
        final var image = editableImage.internalExecute(createOp);
        final var imageModel = ImplementationFactoryRegistry.getDefault().createImageModel(image);
        editableImage.imageModelHolder = ImageModelHolder.wrap(imageModel);

        return editableImage;
      }

    /*******************************************************************************************************************
     *
     * Reads a new EditableImage as specified by the parameter
     *
     * @param   readOp    the way the image should be read
     * @return the image
     *
     ******************************************************************************************************************/
    // FIXME: merge with create(AbstractCreateOp), introduce ReadJ2DOp
    @Nonnull
    public static EditableImage create (@Nonnull final ReadOp readOp)
            throws IOException
      {
        return readOp.execute();
      }

    /*******************************************************************************************************************
     *
     * Returns true if the image has a raster (EditableImages can be loaded with
     * metadata only).
     *
     * @return true if the image has a raster
     *
     ******************************************************************************************************************/
    public boolean hasRaster()
      {
        return imageModelHolder.get() != null;
      }

    /*******************************************************************************************************************
     *
     * DO NOT USE THIS. This method is only used by the module implementation.
     *
     ******************************************************************************************************************/
    public ImageModel getImageModel()
      {
        return imageModelHolder.get();
      }

    private static boolean availableExtensionsLogged;

    /*******************************************************************************************************************
     *
     * Returns all the file extensions of file formats that can be read into an
     * EditableImage. The <code>ImageIO</code> registry is called to retrieve the
     * requested information.
     *
     * @return an array of all file extensions
     *
     ******************************************************************************************************************/
    @Nonnull
    public static Collection<String> getAvailableExtensions()
      {
        final boolean logExtensions;

        synchronized (EditableImage.class)
          {
            logExtensions = !availableExtensionsLogged;
            availableExtensionsLogged = true;
          }

        if (logExtensions)
          {
            log.info("getAvailableExtensions()");
          }

        final Set<String> suffixList = new TreeSet<>();

        for (final var formatName : ImageIO.getReaderFormatNames())
          {
            for (final var i = ImageIO.getImageReadersByFormatName(formatName); i.hasNext(); )
              {
                final var imageReader = i.next();
                final var originatingProvider = imageReader.getOriginatingProvider();
                final var suffixes = originatingProvider.getFileSuffixes();
                final var suffixesAsList = Arrays.asList(suffixes);
                suffixList.addAll(suffixesAsList);

                if (logExtensions)
                  {
                    log.info(">>>> reader - format name: {} provider: {} supports {}",
                             formatName, originatingProvider.getPluginClassName(), suffixesAsList);
                  }
              }
          }

        if (logExtensions)
          {
            log.info(">>>> returning {}", suffixList);
          }

        return suffixList;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public <T extends Directory> Optional<T> getMetadata (final @Nonnull Class<T> metadataClass)
      {
        return getMetadata(metadataClass, 0);
      }

    /*******************************************************************************************************************
     *
     * Retrieve a metadata directory.
     *
     * @param     metadataClass   the type of the directory
     * @param     index           the index (in case of multiple items)
     * @return                    the metadata directory
     *
     ******************************************************************************************************************/
    public <T extends Directory> Optional<T> getMetadata (final @Nonnull Class<T> metadataClass, final @Nonnegative int index)
      {
        final var list = (List<T>)metadataMapByClass.get(metadataClass);
        return Optional.ofNullable(list).flatMap(l -> l.isEmpty() ? Optional.empty() : Optional.of(l.get(index)));
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnegative
    public int getMetadataCount (final @Nonnull Class<?> metadataClass)
      {
        return Optional.ofNullable(metadataMapByClass.get(metadataClass)).map(List::size).orElse(0);
      }

    /*******************************************************************************************************************
     *
     * Returns the width of this image.
     *
     * @return the width
     *
     ******************************************************************************************************************/
    @Nonnegative
    public int getWidth()
      {
        return imageModelHolder.get().getWidth();
      }

    /*******************************************************************************************************************
     *
     * Returns the height of this image.
     *
     * @return the height
     *
     ******************************************************************************************************************/
    @Nonnegative
    public int getHeight()
      {
        return imageModelHolder.get().getHeight();
      }

    /*******************************************************************************************************************
     *
     * Returns the dataType used by this image.
     *
     * @return the data type
     *
     ******************************************************************************************************************/
    @Nonnull
    public DataType getDataType()
      {
        return imageModelHolder.get().getDataType();
      }

    /*******************************************************************************************************************
     *
     * Returns the number of bands this EditableImage is composed of.
     *
     * @return the band count
     *
     ******************************************************************************************************************/
    @Nonnegative
    public int getBandCount()
      {
        return imageModelHolder.get().getBandCount();
      }

    /*******************************************************************************************************************
     *
     * Returns the number of sample bits for each band this EditableImage is
     * composed of.
     *
     * @return the number of bits
     *
     ******************************************************************************************************************/
    @Nonnegative
    public int getBitsPerBand()
      {
        return getDataType().getSize();
      }

    /*******************************************************************************************************************
     *
     * Returns the number of sample bits for each pixel this EditableImage is
     * composed of.
     *
     * @return the number of bits
     *
     ******************************************************************************************************************/
    @Nonnegative
    public int getBitsPerPixel()
      {
        return getBandCount() * getBitsPerBand();
      }

    /*******************************************************************************************************************
     *
     * Executes an operation. The original image is lost and replaced by results.
     *
     * @param  operation      the operation to perform
     * @return the operation (as a convenience in case it carries results)
     *
     ******************************************************************************************************************/
    @Nonnull
    public <T extends Operation> T executeInPlace (@Nonnull final T operation)
      {
        final var time = Instant.now();
        final var image = internalExecute(operation);
        imageModelHolder.get().setImage(image);
        latestOperationDuration = Duration.between(time, Instant.now());

        return operation;
      }

    /*******************************************************************************************************************
     *
     * Executes an operation. The original image is untouched as the results are placed in a brand-new instance of
     * EditableImage.
     *
     * @param  operation  the operation to perform
     * @return the result
     *
     ******************************************************************************************************************/
    @Nonnull
    public EditableImage execute (@Nonnull final Operation operation)
      {
        try
          {
            final var time = Instant.now();
            final var image = internalExecute(operation);
            final var modelClass = imageModelHolder.get().getClass();
            final var constructor = modelClass.getConstructor(Object.class);
            final var newModel = constructor.newInstance(image);
            final var result = new EditableImage(newModel);
            result.attributeMapByName = attributeMapByName; // immutable
            result.latestOperationDuration = Duration.between(time, Instant.now());;

            return result;
          }
        catch (Exception e)
          {
            throw new RuntimeException(e);
          }
      }

    /*******************************************************************************************************************
     *
     * Returns the elapsed time of the latest operation performed. Note that for
     * execute2() this value is available on the result. When an image is
     * deserialized, this method returns the serialization time (this relies upon
     * the fact that the clocks on all network nodes are synchronized).
     *
     * @return the latest operation elapsed time
     *
     ******************************************************************************************************************/
    @Nonnull
    public Duration getLatestOperationDuration()
      {
        return latestOperationDuration;
      }

    /*******************************************************************************************************************
     *
     * Creates a similar image, that is a blank image with the same characteristics
     * of this image (width, height, data type, color model).
     * @deprecated will be merged with create(AbstractCreateOp)
     *
     * @return a new, similar image
     *
     ******************************************************************************************************************/
    @Nonnull
    public EditableImage createSimilarImage()
      {
        final var imageCopy = imageModelHolder.get().createCopy(false);
        imageCopy.attributeMapByName = attributeMapByName; // immutable
        return imageCopy;
      }

    /*******************************************************************************************************************
     *
     * Clones this image.
     *
     ******************************************************************************************************************/
    @Nonnull
    public EditableImage cloneImage()
      {
        final var imageCopy = imageModelHolder.get().createCopy(true);
        imageCopy.attributeMapByName = attributeMapByName; // immutable
        return imageCopy;
      }

    /*******************************************************************************************************************
     *
     * Creates a resized image. - FIXME should be removed
     * @deprecated
     *
     ******************************************************************************************************************/
    @Nonnull
    public EditableImage createResizedImage (final @Nonnegative int width, final @Nonnegative int height)
      {
        return createResizedImage(width, height, Quality.FASTEST);
      }

    /*******************************************************************************************************************
     *
     * Creates a resized image. - FIXME move to a factory method for ScaleOp.
     * @deprecated
     *
     ******************************************************************************************************************/
    @Nonnull
    public EditableImage createResizedImage (final @Nonnegative int width,
                                             final @Nonnegative int height,
                                             final @Nonnull Quality quality)
      {
        final var hScale = (double)width / (double)getWidth();
        final var vScale = (double)height / (double)getHeight();
        final var scaleOp = new ScaleOp(hScale, vScale, quality);
        executeInPlace(scaleOp);

        return this;
      }

    /*******************************************************************************************************************
     *
     * Sets an attribute of this image. Attributes are user-specific name-value pairs.
     *
     * @param  key    the attribute name
     * @param  value  the attribute value
     *
     ******************************************************************************************************************/
    public <T> void setAttribute (final @Nonnull Key<T> key, final @Nonnull T value)
      {
        attributeMapByName = attributeMapByName.with(key, value);
      }

    /*******************************************************************************************************************
     *
     * Returns an attribute of this image.
     *
     * @param  key   the attribute name
     * @return the attribute value
     *
     ******************************************************************************************************************/
    @Nonnull
    public <T> Optional<T> getAttribute (final @Nonnull Key<T> key)
      {
        return attributeMapByName.getOptional(key);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setAttributes (final @Nonnull Map<Key<?>, Object> attributes)
      {
        attributeMapByName = TypeSafeMap.ofCloned(attributes);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public TypeSafeMap getAttributes()
      {
        return attributeMapByName; // immutable
      }

    /*******************************************************************************************************************
     *
     * Removes an attribute from this image.
     *
     * @param  name   the attribute name
     * @return the attribute value
     *
     ******************************************************************************************************************/
    @Nonnull
    public <T> T removeAttribute (final @Nonnull String name)
      {
        throw new UnsupportedOperationException(); // FIXME: need to add TypeSafeMap.without()
      }

    /*******************************************************************************************************************
     *
     * Removes all the resources bound to this image.
     *
     ******************************************************************************************************************/
    public void dispose()
      {
        imageModelHolder.get().dispose();
        imageModelHolder = null;
        attributeMapByName = TypeSafeMap.newInstance();
      }

    /*******************************************************************************************************************
     *
     * Returns an estimate of the memory allocated by this image.
     *
     * @return the memory allocated for this image
     *
     ******************************************************************************************************************/
    @Nonnegative
    public long getMemorySize()
      {
        final var imageModel = imageModelHolder.get();
        return (imageModel != null) ? imageModel.getMemorySize() : 0;
      }

    /*******************************************************************************************************************
     *
     * Returns the ColorModel of this image.
     *
     * @return the color model
     *
     ******************************************************************************************************************/
    @Nonnegative
    public ColorModel getColorModel() // FIXME: to be removed
      {
        return imageModelHolder.get().getColorModel();
      }

    /*******************************************************************************************************************
     *
     * Returns the ICC_Profile of this image (null will be returned if the ColorModel is not ICC-based). <i>Note that
     * this is the profile of the image as it is optimized for the display, which is almost surely sRGB; and <b>it's
     * probably different than the original image profile</b></i>.
     *
     * @return the color profile
     *
     ******************************************************************************************************************/
    @Nonnegative
    public ICC_Profile getICCProfile() // FIXME: to be removed
      {
        final var colorModel = getColorModel();

        if (colorModel != null)
          {
            final var colorSpace = colorModel.getColorSpace();

            if (colorSpace instanceof ICC_ColorSpace)
              {
                final var iccColorSpace = (ICC_ColorSpace)colorSpace;
                return iccColorSpace.getProfile();
              }
          }

        return null;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/

    /*
    private final static int COMPRESSED = 1;

    public void writeExternal (ObjectOutput out)
      throws IOException
      {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
    //        GZIPOutputStream gos = new GZIPOutputStream(baos);
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeUTF(imageModel.getClass().getName());
        imageModel.writeExternal(dos);
        dos.flush();
        dos.close();
        byte[] buffer = baos.toByteArray();

        out.writeLong(System.currentTimeMillis());
        out.writeInt(0);
        out.writeInt(buffer.length);
        out.write(buffer);
        out.flush();
      }*/

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/

    /*
    public void readExternal (ObjectInput in)
      throws IOException, ClassNotFoundException
      {
        long serializationTimeStamp = in.readLong();
        latestOperationTime = System.currentTimeMillis() - serializationTimeStamp;
        int mode = in.readInt();
        int bufferSize = in.readInt();
        byte[] buffer = new byte[bufferSize];
        in.readFully(buffer);
        InputStream is = new ByteArrayInputStream(buffer);

        if (mode == COMPRESSED)
          {
            is = new GZIPInputStream(is);
          }

        DataInputStream dis = new DataInputStream(is);
        String className = dis.readUTF();
        Class clazz = Class.forName(className);
        try
          {
            imageModel = (ImageModel)clazz.newInstance();
          }
        catch (InstantiationException e)
          {
            throw new RuntimeException(e);
          }
        catch (IllegalAccessException e)
          {
            throw new RuntimeException(e);
          }

        imageModel.readExternal(dis);
        dis.close();
        latestSerializationSize = bufferSize;
      }*/

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public long getLatestSerializationSize()
      {
        return latestSerializationSize;
      }

    /*******************************************************************************************************************
     *
     * DO NOT USE. This is only for implementation and testing purposes.
     *
     ******************************************************************************************************************/
    @Nonnull
    public <T> T getInnerProperty (final @Nonnull Class<T> propertyClass)
      {
        if (AccessorOp.class.equals(propertyClass))
          {
            return propertyClass.cast(accessor);
          }

        if (IIOMetadata.class.equals(propertyClass))
          {
            return propertyClass.cast(iioMetadata);
          }

        return imageModelHolder.get().getInnerProperty(propertyClass);
      }

    /*******************************************************************************************************************
     *
     * Executes an operation and return the raw result (the object to be wrapped by the ImageModel).
     *
     * @param   operation  the operation to perform
     * @return the result (the object wrapped by the ImageModel)
     *
     ******************************************************************************************************************/
    @Nonnull
    private Object internalExecute (final @Nonnull Operation operation)
            throws UnsupportedOperationException
      {
        final var implementationFactoryRegistry = ImplementationFactoryRegistry.getDefault();
        final var imageModel = imageModelHolder.get();
        var image = (imageModel != null) ? imageModel.getImage() : null;
        OperationImplementation implementation = null;

        if ((image == null) && !(operation instanceof AbstractCreateOp))
          {
            throw new RuntimeException("null image with an Op different that AbstractCreateOp");
          }

        try
          {
            implementation = implementationFactoryRegistry.findImplementation(operation, imageModelHolder.get(), false);
          }
        catch (UnsupportedOperationException e)
          {
            log.warn("No default implementation of {} for model: {}", operation, image);
            implementation = implementationFactoryRegistry.findImplementation(operation, imageModelHolder.get(), true);
            log.info("Found alternate implementation: {}", implementation);

            if (!(operation instanceof AbstractCreateOp))
              {
                if (implementation.getFactory().canConvertFrom(image.getClass()))
                  {
                    log.info(">>>> CONVERT FROM using {}", implementation.getFactory());
                    imageModelHolder = ImageModelHolder.wrap(implementation.getFactory().convertFrom(image));
                    image = imageModelHolder.get().getImage();
                  }

                else if (imageModelHolder.get().getFactory().canConvertTo(implementation.getFactory().getModelClass()))
                  {
                    log.info(">>>> CONVERT TO {}", implementation.getFactory().getModelClass());
                    image = imageModelHolder.get().getFactory().convertTo(implementation.getFactory().getModelClass());
                  }

                else
                  {
                    throw new RuntimeException("Shouldn't get here");
                  }

                log.info(">>>> NEW IMAGE {} NEW IMAGE MODEL {}", image, imageModelHolder);
              }
          }

        try
          {
            return implementation.execute(this, image);
          }
        catch (RuntimeException e)
          {
            log.error("Operation failed, offending image: {}", image);
            throw e;
          }
      }
  }
