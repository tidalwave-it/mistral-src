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

import java.util.NoSuchElementException;
import com.sun.media.imageio.plugins.tiff.TIFFField;
import com.sun.media.imageioimpl.plugins.tiff.TIFFIFD;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class DirectoryTIFFAdapter implements DirectoryAdapter
  {
    private final TIFFIFD ifd;

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public DirectoryTIFFAdapter (final Object ifd)
      {
        this.ifd = (TIFFIFD)ifd;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public int[] getTags()
      {
        final TIFFField[] fields = ifd.getTIFFFields();
        final int[] result = new int[fields.length];

        for (int i = 0; i < fields.length; i++)
          {
            result[i] = fields[i].getTagNumber();
          }

        return result;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public String[] getSubDirectoryNames()
      {
        return new String[0];
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public DirectoryAdapter getSubDirectory (final String name)
      {
        return null;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public String getTagName (final int tag)
      {
        return "TIFF#" + tag;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public boolean containsTag (final int tag)
      {
        return ifd.getTIFFField(tag) != null;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public boolean hasNext()
      {
        return false;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public DirectoryAdapter next()
      {
        throw new NoSuchElementException();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public Object getObject (final int tag)
      {
        return ifd.getTIFFField(tag).getData();
      }
  }
