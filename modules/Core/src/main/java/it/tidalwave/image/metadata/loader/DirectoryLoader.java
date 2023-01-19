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
import java.util.Iterator;
import java.util.NoSuchElementException;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public interface DirectoryLoader extends Iterator<DirectoryLoader>
  {
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    default public String[] getSubDirectoryNames()
      {
        return new String[0];
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    default public int[] getTags()
      {
        return new int[0];
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    default public DirectoryLoader getSubDirectory (String name)
      {
        return null;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    default public boolean hasNext()
      {
        return false;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    default public DirectoryLoader next()
      {
        throw new NoSuchElementException();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public String getTagName (int tag);

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public boolean containsTag (int tag);

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public Object getObject (int tag)
            throws NoSuchElementException;
  }
