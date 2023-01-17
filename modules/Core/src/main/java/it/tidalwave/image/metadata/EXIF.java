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
package it.tidalwave.image.metadata;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.awt.color.ICC_Profile;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class EXIF extends EXIFDirectoryGenerated
  {
    private static final long serialVersionUID = 3088068666726854799L;

    private static final String ASCII_PREFIX = "ASCII\u0000\u0000\u0000";

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public EXIF()
      {
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public EXIF (final Instant latestModificationTime)
      {
        super(latestModificationTime);
      }

    /*******************************************************************************************************************
     *
     * FIXME: this conversion could be generically be implemented in getObject().
     *
     ******************************************************************************************************************/
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

    /*******************************************************************************************************************
     *
     * The specification says it's an UNDEFINED[1], so some implementations
     * return an array of one byte instead of a single byte. This would cause
     * a ClassCastException in the generated code.
     *
     ******************************************************************************************************************/
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

    /*******************************************************************************************************************
     *
     * The specification says it's an UNDEFINED[1], so some implementations
     * return an array of one byte instead of a single byte. This would cause
     * a ClassCastException in the generated code.
     *
     ******************************************************************************************************************/
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

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public byte[] getUserComment()
      {
        try
          {
            return super.getUserComment();
          }
        catch (Exception e)
          {
            final int i = (Integer)getObject(37510); // flowers.jpeg does this strange thing

            return ("" + i).getBytes();
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
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

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setUserCommentAsString (final String string)
      {
        final String oldValue = getUserCommentAsString();
        final boolean oldAvailable = isUserCommentAsStringAvailable();
        setUserComment((string == null) ? null : (ASCII_PREFIX + string).getBytes());
        propertyChangeSupport.firePropertyChange("userCommentAsString", oldValue, getUserCommentAsString());
        propertyChangeSupport.firePropertyChange("userCommentAsStringAvailable",
                                                 oldAvailable,
                                                 isUserCommentAsStringAvailable());
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public boolean isUserCommentAsStringAvailable()
      {
        return isUserCommentAvailable();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setUserCommentAsStringAvailable (final boolean available)
      {
        final String oldValue = getUserCommentAsString();
        final boolean oldAvailable = isUserCommentAsStringAvailable();
        setUserCommentAvailable(available);
        propertyChangeSupport.firePropertyChange("userCommentAsString", oldValue, getUserCommentAsString());
        propertyChangeSupport.firePropertyChange("userCommentAsStringAvailable",
                                                 oldAvailable,
                                                 isUserCommentAsStringAvailable());
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
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

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    public ICC_Profile getICCProfile()
      {
        final byte[] iccBytes = getInterColourProfile();

        if (iccBytes == null)
          {
            return null;
          }

        return ICC_Profile.getInstance(iccBytes);
      }

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    public LocalDateTime getDateTimeAsDate()
      {
        LocalDateTime date = parseDate(getDateTime());

        if (isSubsecTimeAvailable())
          {
            date = adjust(date, getSubsecTime());
          }

        return date;
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public void setDateTimeAsDate (final LocalDateTime date)
      {
        setDateTime((date == null) ? null : formatDate(date));
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public boolean isDateTimeAsDateAvailable()
      {
        return isDateTimeAvailable();
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public void setDateTimeAsDateAvailable (final boolean available)
      {
        final LocalDateTime oldValue = getDateTimeAsDate();
        final boolean oldAvailable = isDateTimeAsDateAvailable();
        setDateTimeAvailable(available);
        propertyChangeSupport.firePropertyChange("dateTimeAsDate", oldValue, getDateTimeAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeAsDateAvailable", oldAvailable, isDateTimeAsDateAvailable());
      }

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    public LocalDateTime getDateTimeOriginalAsDate()
      {
        LocalDateTime date = parseDate(getDateTimeOriginal());

        if (isSubsecTimeOriginalAvailable())
          {
            date = adjust(date, getSubsecTimeOriginal());
          }

        return date;
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public void setDateTimeOriginalAsDate (final LocalDateTime date)
      {
        final LocalDateTime oldValue = getDateTimeOriginalAsDate();
        final boolean oldAvailable = isDateTimeOriginalAsDateAvailable();
        setDateTimeOriginal((date == null) ? null : formatDate(date));
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDate", oldValue, getDateTimeOriginalAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDateAvailable",
                                                 oldAvailable,
                                                 isDateTimeOriginalAsDateAvailable());
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public boolean isDateTimeOriginalAsDateAvailable()
      {
        return isDateTimeOriginalAvailable();
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public void setDateTimeOriginalAsDateAvailable (final boolean available)
      {
        final LocalDateTime oldValue = getDateTimeOriginalAsDate();
        final boolean oldAvailable = isDateTimeOriginalAsDateAvailable();
        setDateTimeOriginalAvailable(available);
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDate", oldValue, getDateTimeOriginalAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDateAvailable",
                                                 oldAvailable,
                                                 isDateTimeOriginalAsDateAvailable());
      }

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    public LocalDateTime getDateTimeDigitizedAsDate()
      {
        LocalDateTime date = parseDate(getDateTimeDigitized());

        if (isSubsecTimeDigitizedAvailable())
          {
            date = adjust(date, getSubsecTimeDigitized());
          }

        return date;
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public void setDateTimeDigitizedAsDate (final LocalDateTime date)
      {
        final LocalDateTime oldValue = getDateTimeDigitizedAsDate();
        final boolean oldAvailable = isDateTimeDigitizedAsDateAvailable();
        setDateTimeDigitized((date == null) ? null : formatDate(date));
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDate", oldValue, getDateTimeDigitizedAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDateAvailable",
                                                 oldAvailable,
                                                 isDateTimeDigitizedAsDateAvailable());
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public boolean isDateTimeDigitizedAsDateAvailable()
      {
        return isDateTimeDigitizedAvailable();
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public void setDateTimeDigitizedAsDateAvailable (final boolean available)
      {
        final LocalDateTime oldValue = getDateTimeDigitizedAsDate();
        final boolean oldAvailable = isDateTimeDigitizedAsDateAvailable();
        setDateTimeDigitizedAvailable(available);
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDate", oldValue, getDateTimeDigitizedAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDateAvailable",
                                                 oldAvailable,
                                                 isDateTimeDigitizedAsDateAvailable());
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Override
    public void setDateTime (final String dateTime)
      {
        final LocalDateTime oldValue = getDateTimeAsDate();
        final boolean oldAvailable = isDateTimeAsDateAvailable();
        super.setDateTime(dateTime);
        propertyChangeSupport.firePropertyChange("dateTimeAsDate", oldValue, getDateTimeAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeAsDateAvailable", oldAvailable, isDateTimeAsDateAvailable());
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Override
    public void setDateTimeDigitized (final String dateTimeDigitized)
      {
        final LocalDateTime oldValue = getDateTimeDigitizedAsDate();
        final boolean oldAvailable = isDateTimeDigitizedAsDateAvailable();
        super.setDateTimeDigitized(dateTimeDigitized);
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDate", oldValue, getDateTimeDigitizedAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAsDateAvailable",
                                                 oldAvailable,
                                                 isDateTimeDigitizedAsDateAvailable());
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Override
    public void setDateTimeOriginal (final String dateTimeOriginal)
      {
        final LocalDateTime oldValue = getDateTimeOriginalAsDate();
        final boolean oldAvailable = isDateTimeOriginalAsDateAvailable();
        super.setDateTimeOriginal(dateTimeOriginal);
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDate", oldValue, getDateTimeOriginalAsDate());
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAsDateAvailable",
                                                 oldAvailable,
                                                 isDateTimeOriginalAsDateAvailable());
      }

    /*******************************************************************************************************************
     *
     * @param date
     * @param subsec
     *
     ******************************************************************************************************************/
    private LocalDateTime adjust (final LocalDateTime date, final String subsec)
      {
        if (date == null)
          {
            return null;
          }

        return date.plus(Integer.parseInt(subsec) * 10, ChronoUnit.MILLIS);
      }
  }
