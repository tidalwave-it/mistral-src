/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici
 *                        and Emmanuele Sordini
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
 * $Id$
 *
 ******************************************************************************/
package it.tidalwave.image.metadata;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class IPTC extends IPTCDirectoryGenerated
  {
    private final static long serialVersionUID = 3033068666726854799L;
    private final static String CLASS = IPTC.class.getName();
    private final static Logger logger = Logger.getLogger(CLASS);

    // Not static since they are not thread safe
    private final SimpleDateFormat exifDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    private final SimpleDateFormat exifDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public IPTC()
      {
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public IPTC (final Date latestModificationTime)
      {
        super(latestModificationTime);
      }

    /***************************************************************************
     *
     * @return
     *
     **************************************************************************/
    public Date getDateCreatedAsDate()
      {
        return parseDate(getDateCreated());
      }

    /***************************************************************************
     *
     **************************************************************************/
    public void setDateCreatedAsDate (final Date date)
      {
        setDateCreated((date == null) ? null : formatDate(date));
      }

    /***************************************************************************
     *
     **************************************************************************/
    public boolean isDateCreatedAsDateAvailable()
      {
        return isDateCreatedAvailable();
      }

    /***************************************************************************
     *
     **************************************************************************/
    public void setDateCreatedAsDateAvailable (final boolean available)
      {
        final Date oldValue = getDateCreatedAsDate();
        final boolean oldAvailable = isDateCreatedAsDateAvailable();
        setDateCreatedAvailable(available);
        propertyChangeSupport.firePropertyChange("dateCreatedAsDate", oldValue, getDateCreatedAsDate());
        propertyChangeSupport.firePropertyChange("dateCreatedAsDateAvailable", oldAvailable, isDateCreatedAsDateAvailable());
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
