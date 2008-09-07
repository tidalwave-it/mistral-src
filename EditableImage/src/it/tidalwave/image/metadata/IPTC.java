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
 * $Id: IPTC.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.metadata;

import java.util.Date;
import java.util.logging.Logger;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: IPTC.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class IPTC extends IPTCDirectoryGenerated
  {
    private final static long serialVersionUID = 3033068666726854799L;
    private final static String CLASS = IPTC.class.getName();
    private final static Logger logger = Logger.getLogger(CLASS);

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
  }
