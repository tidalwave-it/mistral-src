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
package it.tidalwave.image.metadata.loader;

import javax.annotation.Nonnull;
import java.util.Optional;
import javax.imageio.metadata.IIOMetadata;

/***********************************************************************************************************************
 *
 * Implementation of this interface are capable to extract metadata from an image by means of different adapters.
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public interface MetadataLoader
  {
    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Nonnull
    default public Optional<DirectoryLoader> getTiffLoader (@Nonnull final IIOMetadata iioMetadata)
      {
        return Optional.empty();
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Nonnull
    default public Optional<DirectoryLoader> getExifLoader (@Nonnull final IIOMetadata iioMetadata)
      {
        return Optional.empty();
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Nonnull
    default public Optional<DirectoryLoader> getIptcLoader (@Nonnull final IIOMetadata iioMetadata)
      {
        return Optional.empty();
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Nonnull
    default public Optional<DirectoryLoader> getXmpLoader (@Nonnull final IIOMetadata iioMetadata)
      {
        return Optional.empty();
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Nonnull
    default public Optional<DirectoryLoader> getMakerNoteLoader (@Nonnull final IIOMetadata iioMetadata)
      {
        return Optional.empty();
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Nonnull
    default public Optional<DirectoryLoader> getDngLoader (@Nonnull final IIOMetadata iioMetadata)
      {
        return Optional.empty();
      }
  }
