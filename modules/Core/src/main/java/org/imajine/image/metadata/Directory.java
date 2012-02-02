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
package org.imajine.image.metadata;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.io.Serializable;
import org.imajine.image.Rational;
import org.imajine.image.metadata.loader.DirectoryAdapter;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/***************************************************************************
 *
 * This class provides basic support for all of kind of metadata such EXIF, IPTC
 * or maker notes. 
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class Directory extends JavaBeanSupport implements Serializable
  {
    private final static long serialVersionUID = 3088068666726854722L;
    
    private static int nextId = 1;
    
    private transient int idForToString;
            
    private final Map<Integer, Object> tagMap = new HashMap<Integer, Object>();
    
    private final Map<String, Directory> directoryMap = new HashMap<String, Directory>();
    
    private Date latestModificationTime;
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public Directory()
      {
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Directory (final Date latestModificationTime)
      {
        this.latestModificationTime = (Date)latestModificationTime.clone();
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void loadFromAdapter (final DirectoryAdapter adapter)
      {
        for (int tag : adapter.getTags())
          {
            tagMap.put(tag, adapter.getObject(tag));  
          }

        for (final String directoryName : adapter.getSubDirectoryNames())
          {
            final Directory directory = new Directory();
            directory.loadFromAdapter(adapter.getSubDirectory(directoryName));
            directoryMap.put(directoryName, directory);
          }
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public int[] getTagCodes()
      {
        final int[] result = new int[tagMap.size()];
        
        int i = 0;
        for (int tag : tagMap.keySet())
          {
            result[i++] = tag;
          }
        
        Arrays.sort(result);
        
        return result;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Set<String> getSubDirectoryNames()
      {
        return new CopyOnWriteArraySet<String>(directoryMap.keySet());
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Directory getSubDirectory (final String name)
      {
        return directoryMap.get(name);
      }

    /***************************************************************************
     *
     * Returns an original tag value (i.e. exactly as it is stored into the
     * file).
     * 
     * @param    tag    the tag to retrieve
     * @return          the value
     *
     **************************************************************************/
    public Object getObject (final int tag)
      {
        return tagMap.get(tag);
      }
    
    /***************************************************************************
     *
     * Returns a tag value converted to the specified type.
     * 
     * @param    tag    the tag to retrieve
     * @param    asType the type to convert the value into
     * @return          the value
     *
     **************************************************************************/
    @CheckForNull
    public <T> T getObject (final int tag, @Nonnull final Class<T> asType)
      {
        Object value = tagMap.get(tag);

        if (value == null)
          {
            return null;
          }

        if (value instanceof Number)
          {
            // Handle Enums
            try
              {
//                final String methodName = "get" + strip(getTagName(tag));
//                final Method getter = getClass().getMethod(methodName, new Class[0]);
//                final Class returnType = getter.getReturnType();
                
                if (asType.isEnum())
                  {
                    final Method fromIntegerMethod = asType.getMethod("fromInteger", int.class);
                    value = fromIntegerMethod.invoke(null, value);
                  }
              }
            catch (Exception e)
              {
                throw new RuntimeException(e);
              }

            // Handle promotions
            if (((value instanceof Short) || (value instanceof Byte)) && asType.equals(Integer.class))
              {
                value = Integer.valueOf(((Number)value).intValue());
              }
            else if (((value instanceof Short) || (value instanceof Integer) || (value instanceof Byte)) && asType.equals(Long.class))
              {
                value = Long.valueOf(((Number)value).intValue());
              }
          }
        
        if ((value instanceof long[][]) && Rational.class.equals(asType))
          {
            final long[][] array = (long[][])value;
            value = new Rational((int)array[0][0], (int)array[0][1]);
          }

        // If an array is asked and a scalar is available, convert it to an array[1]
        if (asType.isArray() && !value.getClass().isArray())
          {
            final Object array = Array.newInstance(asType.getComponentType(), 1);
            Array.set(array, 0, value);
            value = array;
          }
        
        return (T)value;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void setObject (final int tag, Object value)
      {
        if ((value != null) && value.getClass().isEnum())
          {
            try
              {
                final Method getValueMethod = value.getClass().getMethod("getValue");
                value = getValueMethod.invoke(value);
              }
            catch (Exception e)
              {
                throw new RuntimeException(e);
              }
          }
        
        tagMap.put(tag, value);
        touch();
      }

    /***************************************************************************
     *
     * @param tag
     * @return
     *
     **************************************************************************/
    public boolean containsTag (final int tag)
      {
        return tagMap.containsKey(tag);
      }
        
    /***************************************************************************
     *
     * @param tag
     *
     **************************************************************************/
    public void removeTag (final int tag)
      {
        tagMap.remove(tag);
        touch();
      }
        
    /***************************************************************************
     *
     * @param tag
     * @return
     *
     **************************************************************************/
    public String getTagName (final int tag)
      {
        return null; // TODO
//        return strategy.getTagName(tag);
      }

    public Date getLatestModificationTime() 
      {
        return (latestModificationTime == null) ? null : (Date)latestModificationTime.clone();
      }
    
    protected synchronized void touch()
      {
//        latestModificationTime.setTime(System.currentTimeMillis()) breaks firePropertyChange()  
        latestModificationTime = new Date(); 
      }

    /***************************************************************************
     *
     * @inheritdocs
     *
     **************************************************************************/
    @Override
    public final String toString()
      {
        synchronized (this)
          {
            if (idForToString == 0) // first time or just deserialized
              {
                idForToString = nextId++;  
              }
          }
        
        String name = getClass().getSimpleName();
        
        if ("".equals(name))
          {
            name = getClass().getName().replaceAll("^.*\\.", "");  
          }
        
        return String.format("%s@%x[%d tags]", name, idForToString, tagMap.size());
      }
    
    /***************************************************************************
     *
     * @param array
     * @return
     *
     **************************************************************************/
    public String toString (final byte[] array)
      {
        if (array == null)
          {
            return "null";
          }

        if (array.length > 64)
          {
            return "" + array.length + " bytes";
          }

        final StringBuffer buffer = new StringBuffer("");

        for (int i = 0; i < array.length; i++)
          {
            if (i > 0)
              {
                buffer.append(",");
              }

            buffer.append(Integer.toHexString(array[i] & 0xff));
          }

        return buffer.toString();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public final boolean equals (final Object object) 
      {
        if (object == null) 
          {
            return false;
          }
        
        if (getClass() != object.getClass()) 
          {
            return false;
          }
        
        final Directory other = (Directory)object;
        final int[] myTags = getTagCodes();
        final int[] otherTags = other.getTagCodes();
        
        if (!myTags.equals(otherTags))
          {
            return false;
          }
        
        for (final int tag : myTags)
          {
            if (!equals(getObject(tag), other.getObject(tag)))
              {
                return false;  
              }
          }
        
//        if (this.tagMap != other.tagMap && (this.tagMap == null || !this.tagMap.equals(other.tagMap)))
//          {
//            return false;
//          }
        
// FIXME        if (this.directoryMap != other.directoryMap && (this.directoryMap == null || !this.directoryMap.equals(other.directoryMap))) 
//          {
//            return false;
//          }

// FIXME        
//        if (this.latestModificationTime != other.latestModificationTime && (this.latestModificationTime == null || !this.latestModificationTime.equals(other.latestModificationTime))) 
//          {
//            return false;
//          }
        
        return true;
      }

    private static boolean equals (final Object o1, final Object o2)
      {
        if (o1 == null)
          {
            return o2 == null;  
          }
        
        if (o1.getClass().isArray())
          {
            final int length = Array.getLength(o1);
            
            if (length != Array.getLength(o2))
              {
                return false;  
              }
            
            for (int i = 0; i < length; i++)
              {
                return equals(Array.get(o1, i), Array.get(o2, i));  
              }
          }
        
        return o1.equals(o2);
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public final int hashCode() 
      {
        int hash = 5;
        
        for (int tag : getTagCodes())
          {
            final Object object = getObject(tag);
            hash = 67 * hash + (object != null ? object.hashCode() : 0);
          }
        
//        hash = 67 * hash + (this.tagMap != null ? this.tagMap.hashCode() : 0);
//        hash = 67 * hash + (this.directoryMap != null ? this.directoryMap.hashCode() : 0);
// FIXME        
//        hash = 67 * hash + (this.latestModificationTime != null ? this.latestModificationTime.hashCode() : 0);
        return hash;
      }

    /***************************************************************************
     *
     * @param array
     * @return
     *
     **************************************************************************/
    public String toString (final Rational[] array)
      {
        final StringBuffer buffer = new StringBuffer("");

        for (int i = 0; i < array.length; i++)
          {
            if (i > 0)
              {
                buffer.append(",");
              }

            buffer.append(array[i].toString());
          }

        return buffer.toString();
      }

    /***************************************************************************
     *
     * @return
     *
     **************************************************************************/
    protected boolean isSubClass (Class aClass, final String ancestorClassName)
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

    /***************************************************************************
     *
     * @param s
     * @return
     *
     **************************************************************************/
//    private static String strip (final String string)
//      {
//        final StringBuffer result = new StringBuffer();
//
//        for (int i = 0; i < string.length(); i++)
//          {
//            char c = string.charAt(i);
//
//            if (Character.isJavaIdentifierPart(c))
//              {
//                result.append(c);
//              }
//          }
//
//        return result.toString();
//      }
  }
