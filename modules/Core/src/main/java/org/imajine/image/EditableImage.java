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

import javax.annotation.Nonnull;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.spi.ImageReaderSpi;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import org.openide.util.Lookup;
import org.imajine.image.op.AbstractCreateOp;
import org.imajine.image.op.ImplementationFactoryRegistry;
import org.imajine.image.op.Operation;
import org.imajine.image.op.OperationImplementation;
import org.imajine.image.op.ReadOp;
import org.imajine.image.op.ScaleOp;
import org.imajine.image.metadata.Directory;
import org.imajine.image.metadata.EXIF;
import org.imajine.image.metadata.IPTC;
import org.imajine.image.metadata.MakerNote;
import org.imajine.image.metadata.TIFF;
import org.imajine.image.metadata.WorkaroundBM25;
import org.imajine.image.metadata.loader.DirectoryAdapter;
import org.imajine.image.metadata.loader.DirectoryDrewAdapter;
import org.imajine.image.metadata.loader.DirectoryRawAdapter;
import org.imajine.image.metadata.loader.DirectoryTIFFAdapter;
import org.imajine.image.metadata.loader.DrewMetadataLoader;
import org.imajine.image.metadata.loader.MetadataLoader;
import org.imajine.image.metadata.loader.RAWMetadataLoader;
import org.imajine.image.metadata.loader.TIFFMetadataLoader;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * An opaque class which encapsulates all the image manipulation logics, and allows the implementation of these logics 
 * to be transparently changed (e.g. by using or not JAI, etc...)
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@ToString(of={"imageModelHolder", "attributeMapByName"}) @Slf4j
public class EditableImage implements Cloneable, Serializable // Externalizable
  {
    private static final String CLASS = EditableImage.class.getName();
    private static final long serialVersionUID = -4527258052032240717L;
    
    private static WorkaroundBM25 workaroundBM25;
    
    public static final String PROP_FORMAT = CLASS + ".format";
    public static final String PROP_MIME_TYPE = CLASS + ".mimeType";

    /** The current image model. */
    private ImageModelHolder imageModelHolder;

    /** The metadata as it comes from Image I/O. */
    private transient IIOMetadata iioMetadata; // TODO make it serializable

    private final Map<Class<? extends Directory>, List<? extends Directory>> metadataMapByClass = 
            new HashMap<Class<? extends Directory>, List<? extends Directory>>();
    
    /** The attributes, */
    private Map<String, Object> attributeMapByName = new HashMap<String, Object>();
    
    public /*FIXME*/ long latestOperationTime;

    private int latestSerializationSize;

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public static enum DataType
      {
        BYTE(DataBuffer.TYPE_BYTE),
        UNSIGNED_SHORT(DataBuffer.TYPE_USHORT),
        SHORT(DataBuffer.TYPE_SHORT),
        INT(DataBuffer.TYPE_INT),
        FLOAT(DataBuffer.TYPE_FLOAT),
        DOUBLE(DataBuffer.TYPE_DOUBLE),
        UNDEFINED(DataBuffer.TYPE_UNDEFINED);

        private final int value;

        /***********************************************************************
         *
         *
         **********************************************************************/
        DataType (int value)
          {
            this.value = value;
          }

        /***********************************************************************
         *
         * Returns the int value of this type, according to DataType constants.
         *
         **********************************************************************/
        public int value()
          {
            return value;
          }

        /***********************************************************************
         *
         * Returns the size in bits of this data type.
         *
         **********************************************************************/
        public int getSize()
          {
            return DataBuffer.getDataTypeSize(value);
          }

        /***********************************************************************
         *
         *
         **********************************************************************/
        public static DataType valueOf (final int value)
          {
            for (final EditableImage.DataType dataType : DataType.values())
              {
                if (dataType.value() == value)
                  {
                    return dataType;
                  }
              }

            return EditableImage.DataType.UNDEFINED;
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    static
      {
//        ImplementationFactoryJ2D.getInstance();

        try
          {
            workaroundBM25 = new WorkaroundBM25();
          }
        catch (Throwable e)
          {
            log.warn("Workaround for BM25 not enabled because of: {}", e.toString());
          }
      }

    /*******************************************************************************************************************
     *
     * For serialization only. Do not use.
     *
     ******************************************************************************************************************/
    public EditableImage()
      {
        // By default put empty objects for which isAvailable() returns false
        metadataMapByClass.put(TIFF.class, Arrays.asList(new TIFF()));
        metadataMapByClass.put(EXIF.class, Arrays.asList(new EXIF()));
        metadataMapByClass.put(IPTC.class, Arrays.asList(new IPTC()));
        metadataMapByClass.put(MakerNote.class, Arrays.asList(new MakerNote()));
      }

    /*******************************************************************************************************************
     *
     * For inner implementation only. Do not use.
     *
     ******************************************************************************************************************/
    public EditableImage (final ImageModel imageModel) // FIXME: try to make it protected
      {
        this();
        // null imageModel is accepted for instances carrying only metadata
        imageModelHolder = ImageModelHolder.wrap(imageModel);
      }
    
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setNickName (final String nickName)
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
    public String getNickName()
      {
        return (imageModelHolder != null) ? imageModelHolder.getNickName() : null;  
      }

    /*******************************************************************************************************************
     *
     * Creates a new EditableImage as specified by the parameter
     *
     * @param   createOp  the way the image should be created
     * @return            the image
     *
     ******************************************************************************************************************/
    @Nonnull
    public static EditableImage create (final @Nonnull AbstractCreateOp createOp)
      {
        final EditableImage editableImage = new EditableImage(null);
        final Object image = editableImage.internalExecute(createOp);
        final ImageModel imageModel = Lookup.getDefault().lookup(ImplementationFactoryRegistry.class).createImageModel(image);
        editableImage.imageModelHolder = ImageModelHolder.wrap(imageModel);

        return editableImage;
      }

    /*******************************************************************************************************************
     *
     * Reads a new EditableImage as specified by the parameter
     *
     * @param   readOp    the way the image should be read
     * @return            the image
     *
     ******************************************************************************************************************/
    // FIXME: merge with create(AbstractCreateOp), introduce ReadJ2DOp
    @Nonnull
    public static EditableImage create (final @Nonnull ReadOp readOp)
        throws IOException
      {
        return readOp.execute();
      }

    /*******************************************************************************************************************
     *
     * Returns true if the image has a raster (EditableImages can be loaded with
     * metadata only).
     *
     * @return  true if the image has a raster
     *
     ******************************************************************************************************************/
    public final boolean hasRaster()
      {
        return imageModelHolder.get() != null;
      }

    /*******************************************************************************************************************
     *
     * DO NOT USE THIS. This method is only used by the module implementation.
     *
     ******************************************************************************************************************/
    public final ImageModel getImageModel()
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
     * @return  an array of all file extensions
     *
     ******************************************************************************************************************/
    public static Collection<String> getAvailableExtensions()
      {
        boolean logExtensions;
        
        synchronized (EditableImage.class)
          {
            logExtensions = !availableExtensionsLogged;
            availableExtensionsLogged = true;
          }

        if (logExtensions)
          {
            log.info("getAvailableExtensions()");
          }

        Set<String> suffixList = new TreeSet<String>();

        for (String formatName : ImageIO.getReaderFormatNames())
          {
            for (Iterator<ImageReader> i = ImageIO.getImageReadersByFormatName(formatName); i.hasNext();)
              {
                ImageReader imageReader = i.next();
                ImageReaderSpi originatingProvider = imageReader.getOriginatingProvider();
                String[] suffixes = originatingProvider.getFileSuffixes();
                List<String> suffixesAsList = Arrays.asList(suffixes);
                suffixList.addAll(suffixesAsList);
                
                if (logExtensions)
                  {
                    log.info(">>>> reader - format name: {} provider: {} supports {}", 
                             new Object[] { formatName, originatingProvider.getPluginClassName(), suffixesAsList });
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
    public final <T> T getMetadata (final Class<T> metadataClass)
      {
        return getMetadata(metadataClass, 0);
      }
    
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public final <T> T getMetadata (final Class<T> metadataClass, final int index)
      {
        final List<T> objects = (List<T>)metadataMapByClass.get(metadataClass);
        return objects.get(index);
      }
    
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public final int getMetadataCount (final Class<?> metadataClass)
      {
        final List<?> objects = metadataMapByClass.get(metadataClass);
        return objects.size();
      }
    
    /*******************************************************************************************************************
     *
     * @deprecated Use getMetadata(EXIF.class) instead.
     *
     ******************************************************************************************************************/
    @Deprecated
    public final EXIF getEXIFDirectory()
      {
        return getMetadata(EXIF.class);
      }

    /*******************************************************************************************************************
     *
     * @deprecated Use getMetadata(MakerNote.class) instead.
     *
     ******************************************************************************************************************/
    @Deprecated
    public final MakerNote getMakerNote()
      {
        return getMetadata(MakerNote.class);
      }

    /*******************************************************************************************************************
     *
     * Returns the width of this image.
     *
     * @return  the width
     *
     ******************************************************************************************************************/
    public final int getWidth()
      {
        return imageModelHolder.get().getWidth();
      }

    /*******************************************************************************************************************
     *
     * Returns the height of this image.
     *
     * @return  the height
     *
     ******************************************************************************************************************/
    public final int getHeight()
      {
        return imageModelHolder.get().getHeight();
      }

    /*******************************************************************************************************************
     *
     * Returns the dataType used by this image.
     *
     * @return  the data type
     *
     ******************************************************************************************************************/
    public final DataType getDataType()
      {
        return imageModelHolder.get().getDataType();
      }

    /*******************************************************************************************************************
     *
     * Returns the number of bands this EditableImage is composed of.
     *
     * @return  the band count
     *
     ******************************************************************************************************************/
    public final int getBandCount()
      {
        return imageModelHolder.get().getBandCount();
      }

    /*******************************************************************************************************************
     *
     * Returns the number of sample bits for each band this EditableImage is
     * composed of.
     *
     * @return  the number of bits
     *
     ******************************************************************************************************************/
    public final int getBitsPerBand()
      {
        return getDataType().getSize();
      }

    /*******************************************************************************************************************
     *
     * Returns the number of sample bits for each pixel this EditableImage is
     * composed of.
     *
     * @return  the number of bits
     *
     ******************************************************************************************************************/
    public final int getBitsPerPixel()
      {
        return getBandCount() * getBitsPerBand();
      }

    /*******************************************************************************************************************
     *
     * Executes an operation. The original image is lost and replaced by results.
     *
     * @param  operation      the operation to perform
     * @return                the operation (as a convenience in case it carries
     *                        results)
     *
     ******************************************************************************************************************/
    @Nonnull
    public final <T extends Operation> T execute (final @Nonnull T operation)
      {
        long time = System.currentTimeMillis();
        Object image = internalExecute(operation);
        imageModelHolder.get().setImage(image);
        latestOperationTime = System.currentTimeMillis() - time;

        return operation;
      }

    /*******************************************************************************************************************
     *
     * Executes an operation. The original image is untouched as the results are
     * placed in a brand new instance of EditableImage.
     *
     * @param  operation  the operation to perform
     * @return            the result
     *
     ******************************************************************************************************************/
    @Nonnull
    public final EditableImage execute2 (final @Nonnull Operation operation)
      {
        try
          {
            long time = System.currentTimeMillis();
            Object image = internalExecute(operation);
            Class modelClass = imageModelHolder.get().getClass();
            Constructor constructor = modelClass.getConstructor(Object.class);
            ImageModel newModel = (ImageModel)constructor.newInstance(image);
            EditableImage result = new EditableImage(newModel);
            result.attributeMapByName = new HashMap<String, Object>(attributeMapByName);
            result.latestOperationTime = System.currentTimeMillis() - time;

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
     * @return  the latest operation elapsed time
     *
     ******************************************************************************************************************/
    public final long getLatestOperationTime ()
      {
        return latestOperationTime;
      }

    /*******************************************************************************************************************
     *
     * Creates a similar image, that is a blank image with the same characteristics
     * of this image (width, height, data type, color model).
     * @deprecated will be merged with create(AbstractCreateOp)
     *
     * @return  a new, similar image
     *
     ******************************************************************************************************************/
    public final EditableImage createSimilarImage()
      {
        final EditableImage imageCopy = imageModelHolder.get().createCopy(false);
        imageCopy.attributeMapByName = new HashMap<String, Object>(attributeMapByName);

        return imageCopy;
      }

    /*******************************************************************************************************************
     *
     * Clones this image.
     *
     ******************************************************************************************************************/
    public final EditableImage cloneImage()
      {
        final EditableImage imageCopy = imageModelHolder.get().createCopy(true);
        imageCopy.attributeMapByName = new HashMap<String, Object>(attributeMapByName);

        return imageCopy;
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Override
    public Object clone()
      {
        return cloneImage();
      }

    /*******************************************************************************************************************
     *
     * Creates a resized image. - FIXME should be removed
     * @deprecated
     *
     ******************************************************************************************************************/
    public final EditableImage createResizedImage (final int width, final int height)
      {
        return createResizedImage(width, height, Quality.FASTEST);
      }

    /*******************************************************************************************************************
     *
     * Creates a resized image. - FIXME should be removed
     * @deprecated
     *
     ******************************************************************************************************************/
    public final EditableImage createResizedImage (final int width, final int height, final Quality quality)
      {
        double hScale = (double)width / (double)getWidth();
        double vScale = (double)height / (double)getHeight();
        ScaleOp scaleOp = new ScaleOp(hScale, vScale, quality);
        execute(scaleOp);

        return this;
      }

    /*******************************************************************************************************************
     *
     * Sets an attribute of this image. Attributes are user-specific name-value pairs.
     *
     * @param  name   the attribute name
     * @param  value  the attribute value
     *
     ******************************************************************************************************************/
    public final void setAttribute (final String name, final Object value)
      {
        attributeMapByName.put(name, value);
      }

    /*******************************************************************************************************************
     *
     * Returns an attribute of this image.
     *
     * @param  name   the attribute name
     * @return        the attribute value
     *
     ******************************************************************************************************************/
    public final Object getAttribute (final String name)
      {
        return attributeMapByName.get(name);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public final void setAttributes (final Map<String, Object> attributes)
      {
        attributeMapByName.clear();
        attributeMapByName.putAll(attributes);
      }
    
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public final Map<String, Object> getAttributes()
      {
        // FIXME: no such a thing as CopyOnWriteHashMap
        final Map<String, Object> result = new HashMap<String, Object>();
        result.putAll(attributeMapByName);
        return result;
      }
                
    /*******************************************************************************************************************
     *
     * Removes an attribute from this image.
     *
     * @param  name   the attribute name
     * @return        the attribute value
     *
     ******************************************************************************************************************/
    public final Object removeAttribute (final String name)
      {
        return attributeMapByName.remove(name);
      }

    /*******************************************************************************************************************
     *
     * Removes all the resources bound to this image.
     *
     ******************************************************************************************************************/
    public final void dispose()
      {
        imageModelHolder.get().dispose();
        imageModelHolder = null;
        attributeMapByName.clear();
      }

    /*******************************************************************************************************************
     *
     * Returns an estimate of the memory allocated by this image.
     * 
     * @return  the memory allocated for this image
     *
     ******************************************************************************************************************/
    public final long getMemorySize()
      {
        final ImageModel imageModel = imageModelHolder.get();
        return (imageModel != null) ? imageModel.getMemorySize() : 0;
      }
    
    /*******************************************************************************************************************
     *
     * Returns the ColorModel of this image.
     *
     * @return  the color model
     *
     ******************************************************************************************************************/
    public final ColorModel getColorModel() // FIXME: to be removed
      {
        return imageModelHolder.get().getColorModel();
      }

    /*******************************************************************************************************************
     *
     * Returns the ICC_Profile of this image (null will be returned if the
     * ColorModel is not ICC-based). <i>Note that this is the profile of the image as
     * it is optimized for the display, which is almost surely sRGB; and <b>it's
     * probably different than the original image profile</b></i>.
     *
     * @return  the color profile
     *
     ******************************************************************************************************************/
    public final ICC_Profile getICCProfile() // FIXME: to be removed
      {
        final ColorModel colorModel = getColorModel();
        
        if (colorModel != null)
          {
            final ColorSpace colorSpace = colorModel.getColorSpace();

            if (colorSpace instanceof ICC_ColorSpace)
              {
                ICC_ColorSpace iccColorSpace = (ICC_ColorSpace)colorSpace;

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
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    public int getLatestSerializationSize ()
      {
        return latestSerializationSize;
      }

    /*******************************************************************************************************************
     *
     * This is only for testing purposes.
     *
     ******************************************************************************/
    public final <T> T getInnerProperty (final Class<T> propertyClass)
      {
        if (IIOMetadata.class.equals(propertyClass))
          {
            return (T)iioMetadata;
          }

        return imageModelHolder.get().getInnerProperty(propertyClass);
      }

    /*******************************************************************************************************************
     *
     * Executes an operation and return the raw result (the object to be wrapped by
     * the ImageModel).
     *
     * @param   operation  the operation to perform
     * @return             the result (the object wrapped by the ImageModel)
     *
     ******************************************************************************/
    private Object internalExecute (final Operation operation)
        throws UnsupportedOperationException
      {
        final ImplementationFactoryRegistry implementationFactoryRegistry = Lookup.getDefault().lookup(ImplementationFactoryRegistry.class);
        final ImageModel imageModel = imageModelHolder.get();
        Object image = (imageModel != null) ? imageModel.getImage() : null;
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

    /*******************************************************************************************************************
     *
     * Don't use it. Only for internal implementation.
     *
     ******************************************************************************************************************/
    public /*FIXME*/ void loadMetadata (final ImageReader reader, final int imageIndex)
      {
        log.trace("loadMetadata({}, {})", reader, imageIndex);

        try
          {
            iioMetadata = reader.getImageMetadata(imageIndex);
          }
        catch (Exception e)
          {
            if ("ICC APP2 encountered without prior JFIF!".equals(e.getMessage()) && (workaroundBM25 != null))
              {
                try
                  {
                    workaroundBM25.loadExifAndIptcFromJpeg(reader, getMetadata(EXIF.class), getMetadata(IPTC.class));
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
          }

        if (iioMetadata == null)
          {
            log.trace(">>>> null imagemetadata");
            return;
          }

        log.trace(">>>> metadata class: {}", iioMetadata.getClass());
        MetadataLoader metadataLoader = null;

        if (isSubClass(iioMetadata.getClass(), "com.sun.media.imageioimpl.plugins.tiff.TIFFImageMetadata"))
          {
            metadataLoader = new TIFFMetadataLoader();
          }
        else if (isSubClass(iioMetadata.getClass(), "it.tidalwave.imageio.raw.RAWMetadataSupport"))
          {
            metadataLoader = new RAWMetadataLoader();
          }
        else
          {
            metadataLoader = new DrewMetadataLoader();
          }

        if (metadataLoader != null)
          {
            try
              {
                loadItem(metadataLoader, TIFF.class);
                loadItem(metadataLoader, EXIF.class);
                loadItem(metadataLoader, MakerNote.class);
                loadItem(metadataLoader, IPTC.class);
              }
            catch (Exception e)
              {
                log.error("loadMetadata()", e);
              }
          }
      }
    
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private <T extends Directory> void loadItem (final MetadataLoader metadataLoader, final Class<T> itemClass)
      throws InstantiationException, IllegalAccessException 
      {
        final List<T> items = new ArrayList<T>();
        Object node = null;
        
        // FIXME: get rid of the if chain
        if (TIFF.class.equals(itemClass))
          {
            node = metadataLoader.findTIFF(iioMetadata);
          }
        else if (EXIF.class.equals(itemClass))
          {
            node = metadataLoader.findEXIF(iioMetadata);
          }
        else if (IPTC.class.equals(itemClass))
          {
            node = metadataLoader.findIPTC(iioMetadata);
          }
        else if (MakerNote.class.equals(itemClass))
          {
            node = metadataLoader.findMakerNote(iioMetadata);
          }

        if (node != null) 
          {
            for (DirectoryAdapter adapter = findAdapter(node);;) 
              {
                final T item = itemClass.newInstance();
                item.loadFromAdapter(adapter);
                items.add(item);

                if (adapter.hasNext()) // FIXME: put in the for (;;)
                  {
                    adapter = adapter.next();
                  }
                else 
                  {
                    break;
                  }
              }

            metadataMapByClass.put(itemClass, items);
          }
      }
    
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private DirectoryAdapter findAdapter (final Object object)
      {
        DirectoryAdapter adapter = null;
        
        // TODO: use a smarterdesign, remove if-else
        if (isSubClass(object.getClass(), "com.sun.media.imageioimpl.plugins.tiff.TIFFIFD"))
          {
            adapter = new DirectoryTIFFAdapter(object);
          }

        else if (isSubClass(object.getClass(), "com.drew.metadata.Directory"))
          {
            adapter = new DirectoryDrewAdapter(object);
          }

        else if (isSubClass(object.getClass(), "com.drew.metadata.exif.ExifDirectory"))
          {
            adapter = new DirectoryDrewAdapter(object);
          }

        else if (isSubClass(object.getClass(), "it.tidalwave.imageio.raw.Directory"))
          {
            adapter = new DirectoryRawAdapter(object);
          }
        
        return adapter;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static boolean isSubClass (Class<?> aClass, final String ancestorClassName)
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
