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

import javax.annotation.Nonnull;
import java.util.Date;
import java.text.SimpleDateFormat;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class IPTC extends IPTCDirectoryGenerated
  {
    private final static long serialVersionUID = 3033068666726854799L;

    // Not static since they are not thread safe
    private final SimpleDateFormat exifDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    private final SimpleDateFormat exifDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public IPTC()
      {
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public IPTC (final @Nonnull Date latestModificationTime)
      {
        super(latestModificationTime);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull 
    public Date getDateCreatedAsDate()
      {
        return parseDate(getDateCreated());
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setDateCreatedAsDate (final @Nonnull Date date)
      {
        setDateCreated((date == null) ? null : formatDate(date));
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public boolean isDateCreatedAsDateAvailable()
      {
        return isDateCreatedAvailable();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setDateCreatedAsDateAvailable (final boolean available)
      {
        final Date oldValue = getDateCreatedAsDate();
        final boolean oldAvailable = isDateCreatedAsDateAvailable();
        setDateCreatedAvailable(available);
        propertyChangeSupport.firePropertyChange("dateCreatedAsDate", oldValue, getDateCreatedAsDate());
        propertyChangeSupport.firePropertyChange("dateCreatedAsDateAvailable", oldAvailable, isDateCreatedAsDateAvailable());
      }

    /*******************************************************************************************************************
     *
     * synchronized since SimpleDateFormat is not thread-safe.
     *
     ******************************************************************************************************************/
    private synchronized String formatDate (final @Nonnull Date date)
      {
        if (date == null)
          {
            return null;
          }

        return exifDateFormat.format(date);
      }

    /*******************************************************************************************************************
     *
     * synchronized since SimpleDateFormat is not thread-safe.
     *
     ******************************************************************************************************************/
    @Nonnull 
    private synchronized Date parseDate (final @Nonnull String string)
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
                log.warn("*** BAD DATE {}", string);
                return null;
              }
          }
      }
  }
