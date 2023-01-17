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

import javax.annotation.Nonnull;
import java.time.Instant;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class IPTC extends IPTCDirectoryGenerated
  {
    private static final long serialVersionUID = 3033068666726854799L;

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
    public IPTC (@Nonnull final Instant latestModificationTime)
      {
        super(latestModificationTime);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public Optional<Instant> getDateCreatedAsDate()
      {
        return getDateCreated().map(IPTC::parseDateTime);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void setDateCreatedAsDate (@Nonnull final Instant date)
      {
        setDateCreated((date == null) ? null : formatDateTime(date));
      }
  }
