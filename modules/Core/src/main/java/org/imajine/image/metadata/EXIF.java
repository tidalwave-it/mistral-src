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
package org.imajine.image.metadata;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.awt.color.ICC_Profile;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class EXIF extends EXIFDirectoryGenerated
  {
    private final static String CLASS = EXIF.class.getName();
    private final static Logger logger = Logger.getLogger(CLASS);
    private final static long serialVersionUID = 3088068666726854799L;
    
    private final static String ASCII_PREFIX = "ASCII\u0000\u0000\u0000";

    // Not static since they are not thread safe
    private final SimpleDateFormat exifDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    private final SimpleDateFormat exifDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    /***************************************************************************
     *
     *
     **************************************************************************/
    public EXIF()
      {
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public EXIF (final Date latestModificationTime)
      {
        super(latestModificationTime);
      }
    
    /***************************************************************************
     *
     * FIXME: this conversion could be generically be implemented in getObject().
     *
     **************************************************************************/
    @Override
    public int[] getBitsPerSample()
      {
        Object object = getObject(BITS_PER_SAMPLE);
        
        if (object instanceof short[])
          {
            final short[] shorts = (short[])object;
            final int[] result = new int[shorts.length];
            
            for (int i = 0; i < shorts.length; i++)
              {
                result[i] = shorts[i];  
              }
            
            object = result;
          }
        
        return (int[])object;
      }

    /***************************************************************************
     *
     * The specification says it's an UNDEFINED[1], so some implementations 
     * return an array of one byte instead of a single byte. This would cause
     * a ClassCastException in the generated code. 
     *
     **************************************************************************/
    @Override
    public FileSource getFileSource()
      {
        Object object = getObject(FILE_SOURCE);
        
        if (object instanceof byte[])
          {
            object = FileSource.fromInteger(((byte[])object)[0]);  
          }

        else if (object instanceof Integer)
          {
            object = FileSource.fromInteger(((Integer)object));  
          }
        
        return (FileSource)object;
      }

    /***************************************************************************
     *
     * The specification says it's an UNDEFINED[1], so some implementations 
     * return an array of one byte instead of a single byte. This would cause
     * a ClassCastException in the generated code. 
     *
     **************************************************************************/
    @Override
    public SceneType getSceneType() 
      {
        Object object = getObject(SCENE_TYPE);
        
        if (object instanceof byte[])
          {
            object = SceneType.fromInteger(((byte[])object)[0]);  
          }

        else if (object instanceof Integer)
          {
            object = SceneType.fromInteger(((Integer)object));  
          }
        
        return (SceneType)object;
      }

    /***************************************************************************
     *
     * @inheritDoc
     *
     **************************************************************************/
    @Override
    public byte[] getUserComment()
      {
        try
          {
            return super.getUserComment();
          }
        catch (Exception e)
          {
            int i = (Integer)getObject(37510); // flowers.jpeg does this strange thing

            return ("" + i).getBytes();
          }
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public String getUserCommentAsString()
      {
        String string = null;
        final byte[] bytes = getUserComment();
        
        if (bytes != null)
          {
            string = new String(bytes);

            if (string.startsWith(ASCII_PREFIX))
              {
                return string.substring(ASCII_PREFIX.length());
              }
          }
        
        return string; 
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public void setUserCommentAsString (final String string)
      {
        final String oldValue = getUserCommentAsString();
        final boolean oldAvailable = isUserCommentAsStringAvailable();
        setUserComment((string == null) ? null : (ASCII_PREFIX + string).getBytes());
        propertyChangeSupport.firePropertyChange("userCommentAsString", oldValue, getUserCommentAsString());
        propertyChangeSupport.firePropertyChange("userCommentAsStringAvailable", oldAvailable, isUserCommentAsStringAvailable());
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public boolean isUserCommentAsStringAvailable()
      {
        return isUserCommentAvailable();    
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void setUserCommentAsStringAvailable (final boolean available)
      {
        final String oldValue = getUserCommentAsString();
        final boolean oldAvailable = isUserCommentAsStringAvailable();
        setUserCommentAvailable(available);
        propertyChangeSupport.firePropertyChange("userCommentAsString", oldValue, getUserCommentAsString());
        propertyChangeSupport.firePropertyChange("userCommentAsStringAvailable", oldAvailable, isUserCommentAsStringAvailable());
      }
    
    /***************************************************************************
     *
     * @inheritDoc
     *
     **************************************************************************/
    @Override
    public String getOriginalRawFileName()
      {
        Object value = getObject(ORIGINAL_RAW_FILE_NAME);
        
        if (value instanceof byte[])
          {
            value = new String((byte[])value);
          }  
        
        return (String)value;
      }

    /***************************************************************************
     *
     * @return
     *
     **************************************************************************/
    public ICC_Profile getICCProfile()
      {
        final byte[] iccBytes = getInterColourProfile();

        if (iccBytes == null)
          {
            return null;
          }

        return ICC_Profile.getInstance(iccBytes);
      }

    /***************************************************************************
     *
     * @return
     *
     **************************************************************************/
    public Date getDateTimeAsDate()
      {
        Date date = parseDate(getDateTime());

        if (isSubsecTimeAvailable())
          {
            date = adjust(date, getSubsecTime());
          }

        return date;
      }
    
    /***************************************************************************
     *
     **************************************************************************/
    public void setDateTimeAsDate (final Date date)
      {
        setDateTime((date == null) ? null : formatDate(date));
      }
    
    /***************************************************************************
     *
     **************************************************************************/
    public boolean isDateTimeAsDateAvailable()
      {
        return isDateTimeAvailable();    
      }
    
    /***************************************************************************
     *
     **************************************************************************/
    public void setDateTimeAsDateAvailable (final boolean available)
      {
        final Date oldValue = getDateTimeAsDate();
        final boolean oldAvailable = isDateTimeAsDateAvailable();
        setDateTimeAvailable(available);    
        propertyChangeSupport.firePropertyChange("dateTimeAsDate", oldValue, getDateTimeAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeAsDateAvailable", oldAvailable, isDateTimeAsDateAvailable());
      }

    /***************************************************************************
     *
     * @return
     *
     **************************************************************************/
    public Date getDateTimeOriginalAsDate()
      {
        Date date = parseDate(getDateTimeOriginal());

        if (isSubsecTimeOriginalAvailable())
          {
            date = adjust(date, getSubsecTimeOriginal());
          }

        return date;
      }

    /***************************************************************************
     *
     **************************************************************************/
    public void setDateTimeOriginalAsDate (final Date date)
      {
        final Date oldValue = getDateTimeOriginalAsDate();
        final boolean oldAvailable = isDateTimeOriginalAsDateAvailable();
        setDateTimeOriginal((date == null) ? null : formatDate(date));
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDate", oldValue, getDateTimeOriginalAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDateAvailable", oldAvailable, isDateTimeOriginalAsDateAvailable());
      }

    /***************************************************************************
     *
     **************************************************************************/
    public boolean isDateTimeOriginalAsDateAvailable()
      {
        return isDateTimeOriginalAvailable();    
      }
    
    /***************************************************************************
     *
     **************************************************************************/
    public void setDateTimeOriginalAsDateAvailable (final boolean available)
      {
        final Date oldValue = getDateTimeOriginalAsDate();
        final boolean oldAvailable = isDateTimeOriginalAsDateAvailable();
        setDateTimeOriginalAvailable(available);    
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDate", oldValue, getDateTimeOriginalAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDateAvailable", oldAvailable, isDateTimeOriginalAsDateAvailable());
      }

    /***************************************************************************
     *
     * @return
     *
     **************************************************************************/
    public Date getDateTimeDigitizedAsDate()
      {
        Date date = parseDate(getDateTimeDigitized());

        if (isSubsecTimeDigitizedAvailable())
          {
            date = adjust(date, getSubsecTimeDigitized());
          }

        return date;
      }

    /***************************************************************************
     *
     **************************************************************************/
    public void setDateTimeDigitizedAsDate (final Date date)
      {
        final Date oldValue = getDateTimeDigitizedAsDate();
        final boolean oldAvailable = isDateTimeDigitizedAsDateAvailable();
        setDateTimeDigitized((date == null) ? null : formatDate(date));
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDate", oldValue, getDateTimeDigitizedAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDateAvailable", oldAvailable, isDateTimeDigitizedAsDateAvailable());
      }

    /***************************************************************************
     *
     **************************************************************************/
    public boolean isDateTimeDigitizedAsDateAvailable()
      {
        return isDateTimeDigitizedAvailable();    
      }
    
    /***************************************************************************
     *
     **************************************************************************/
    public void setDateTimeDigitizedAsDateAvailable (final boolean available)
      {
        final Date oldValue = getDateTimeDigitizedAsDate();
        final boolean oldAvailable = isDateTimeDigitizedAsDateAvailable();
        setDateTimeDigitizedAvailable(available);    
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDate", oldValue, getDateTimeDigitizedAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDateAvailable", oldAvailable, isDateTimeDigitizedAsDateAvailable());
      }

    /***************************************************************************
     *
     **************************************************************************/
    @Override
    public void setDateTime (final String dateTime) 
      {
        final Date oldValue = getDateTimeAsDate();
        final boolean oldAvailable = isDateTimeAsDateAvailable();
        super.setDateTime(dateTime);
        propertyChangeSupport.firePropertyChange("dateTimeAsDate", oldValue, getDateTimeAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeAsDateAvailable", oldAvailable, isDateTimeAsDateAvailable());
      }

    /***************************************************************************
     *
     **************************************************************************/
    @Override
    public void setDateTimeDigitized (final String dateTimeDigitized) 
      {
        final Date oldValue = getDateTimeDigitizedAsDate();
        final boolean oldAvailable = isDateTimeDigitizedAsDateAvailable();
        super.setDateTimeDigitized(dateTimeDigitized);
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDate", oldValue, getDateTimeDigitizedAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDateAvailable", oldAvailable, isDateTimeDigitizedAsDateAvailable());
      }

    /***************************************************************************
     *
     **************************************************************************/
    @Override
    public void setDateTimeOriginal (final String dateTimeOriginal) 
      {
        final Date oldValue = getDateTimeOriginalAsDate();
        final boolean oldAvailable = isDateTimeOriginalAsDateAvailable();
        super.setDateTimeOriginal(dateTimeOriginal);
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDate", oldValue, getDateTimeOriginalAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDateAvailable", oldAvailable, isDateTimeOriginalAsDateAvailable());
      }
    
    /***************************************************************************
     *
     * @param date
     * @param subsec
     *
     **************************************************************************/
    private Date adjust (final Date date, final String subsec)
      {
        if (date == null)
          {
            return null;
          }
        
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, Integer.parseInt(subsec) * 10);
        return calendar.getTime();
      }

    /***************************************************************************
     *
     * synchronized since SimpleDateFormat is not thread-safe.
     * 
     **************************************************************************/
    private synchronized String formatDate (final Date date)
      {
        if (date == null)
          {
            return null;
          }

        return exifDateFormat.format(date);
      }
    
    /***************************************************************************
     *
     * synchronized since SimpleDateFormat is not thread-safe.
     * 
     **************************************************************************/
    private synchronized Date parseDate (final String string)
      {
        if (string == null)
          {
            return null;
          }

        try
          {
            return exifDateFormat.parse(string);
          }

        catch (Exception e)
          {
            try
              {
                return exifDateFormat2.parse(string);
              }

            catch (Exception e1)
              {
                logger.warning("*** BAD DATE " + string);
                return null;
              }
          }
      }
  }
