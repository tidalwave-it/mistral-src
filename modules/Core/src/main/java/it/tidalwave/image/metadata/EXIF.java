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

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
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
    @Override @Nonnull
    public Optional<int[]> getBitsPerSample()
      {
        Object object = getRaw(C_BITS_PER_SAMPLE);

        if (object instanceof short[])
          {
            final var shorts = (short[])object;
            final var result = new int[shorts.length];

            for (var i = 0; i < shorts.length; i++)
              {
                result[i] = shorts[i];
              }

            object = result;
          }

        return Optional.ofNullable((int[])object);
      }

    /*******************************************************************************************************************
     *
     * The specification says it's an UNDEFINED[1], so some implementations
     * return an array of one byte instead of a single byte. This would cause
     * a ClassCastException in the generated code.
     *
     ******************************************************************************************************************/
    @Override @Nonnull
    public Optional<FileSource> getFileSource()
      {
        Object object = getRaw(C_FILE_SOURCE);

        if (object instanceof byte[])
          {
            object = FileSource.fromInteger(((byte[])object)[0]);
          }

        else if (object instanceof Integer)
          {
            object = FileSource.fromInteger(((Integer)object));
          }

        return Optional.ofNullable((FileSource)object);
      }

    /*******************************************************************************************************************
     *
     * The specification says it's an UNDEFINED[1], so some implementations
     * return an array of one byte instead of a single byte. This would cause
     * a ClassCastException in the generated code.
     *
     ******************************************************************************************************************/
    @Override @Nonnull
    public Optional<SceneType> getSceneType()
      {
        Object object = getRaw(C_SCENE_TYPE);

        if (object instanceof byte[])
          {
            object = SceneType.fromInteger(((byte[])object)[0]);
          }

        else if (object instanceof Integer)
          {
            object = SceneType.fromInteger(((Integer)object));
          }

        return Optional.ofNullable((SceneType)object);
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override @Nonnull
    public Optional<byte[]> getUserComment()
      {
        try
          {
            return super.getUserComment();
          }
        catch (Exception e)
          {
            final int i = (Integer)getRaw(37510); // flowers.jpeg does this strange thing

            return Optional.ofNullable(("" + i).getBytes());
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public Optional<String> getUserCommentAsString()
      {
        String string = null;
        final var bytes = getUserComment().orElse(null);

        if (bytes != null)
          {
            string = new String(bytes);

            if (string.startsWith(ASCII_PREFIX))
              {
                return Optional.of(string.substring(ASCII_PREFIX.length()));
              }
          }

        return Optional.ofNullable(string);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setUserCommentAsString (@Nonnull final String string)
      {
        setUserComment((string == null) ? null : (ASCII_PREFIX + string).getBytes());
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override @Nonnull
    public Optional<String> getOriginalRawFileName()
      {
        var value = getRaw(C_ORIGINAL_RAW_FILE_NAME);

        if (value instanceof byte[])
          {
            value = new String((byte[])value);
          }

        return Optional.ofNullable((String)value);
      }

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    @Nonnull
    public Optional<ICC_Profile> getICCProfile()
      {
        return getInterColourProfile().map(ICC_Profile::getInstance);
      }

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    @Nonnull
    public Optional<Instant> getDateTimeAsDate()
      {
        return getDateTime().map(EXIF::parseDateTime).flatMap(d -> getSubsecTime().map(s -> adjust(d, s)));
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public void setDateTimeAsDate (@Nonnull final Instant date)
      {
        setDateTime((date == null) ? null : formatDateTime(date));
      }

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    @Nonnull
    public Optional<Instant> getDateTimeOriginalAsDate()
      {
        return getDateTimeOriginal().map(EXIF::parseDateTime)
                                    .flatMap(d -> getSubsecTimeOriginal().map(s -> adjust(d, s)));
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public void setDateTimeOriginalAsDate (@Nonnull final Instant date)
      {
        setDateTimeOriginal((date == null) ? null : formatDateTime(date));
      }

    /*******************************************************************************************************************
     *
     * @return
     *
     ******************************************************************************************************************/
    @Nonnull
    public Optional<Instant> getDateTimeDigitizedAsDate()
      {
        return getDateTimeDigitized().map(EXIF::parseDateTime).flatMap(d -> getSubsecTimeDigitized().map(s -> adjust(d,
                                                                                                                  s)));
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public void setDateTimeDigitizedAsDate (@Nonnull final Instant date)
      {
        setDateTimeDigitized((date == null) ? null : formatDateTime(date));
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Override
    public void setDateTime (@Nonnull final String dateTime)
      {
        super.setDateTime(dateTime);
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Override
    public void setDateTimeDigitized (@Nonnull final String dateTimeDigitized)
      {
        super.setDateTimeDigitized(dateTimeDigitized);
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Override
    public void setDateTimeOriginal (@Nonnull final String dateTimeOriginal)
      {
        super.setDateTimeOriginal(dateTimeOriginal);
      }

    /*******************************************************************************************************************
     *
     * @param instant
     * @param subsec
     *
     ******************************************************************************************************************/
    @Nonnull
    private Instant adjust (@CheckForNull final Instant instant, @Nonnull final String subsec)
      {
        if (instant == null)
          {
            return null;
          }

        return instant.plus(Integer.parseInt(subsec) * 10, ChronoUnit.MILLIS);
      }
  }
