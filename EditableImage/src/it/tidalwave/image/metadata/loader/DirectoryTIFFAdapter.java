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
 * $Id: DirectoryTIFFAdapter.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.metadata.loader;

import java.util.NoSuchElementException;
import com.sun.media.imageio.plugins.tiff.TIFFField;
import com.sun.media.imageioimpl.plugins.tiff.TIFFIFD;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: DirectoryTIFFAdapter.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class DirectoryTIFFAdapter implements DirectoryAdapter
  {
    private final TIFFIFD ifd;

    /***************************************************************************
     *
     *
     **************************************************************************/
    public DirectoryTIFFAdapter (final Object ifd)
      {
        this.ifd = (TIFFIFD)ifd;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public int[] getTags ()
      {
        TIFFField[] fields = ifd.getTIFFFields();
        int[] result = new int[fields.length];

        for (int i = 0; i < fields.length; i++)
          {
            result[i] = fields[i].getTagNumber();
          }

        return result;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public String[] getSubDirectoryNames ()
      {
        return new String[0];
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public DirectoryAdapter getSubDirectory (final String name)
      {
        return null;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public String getTagName (final int tag)
      {
        return "TIFF#" + tag;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public boolean containsTag (final int tag)
      {
        return ifd.getTIFFField(tag) != null;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public boolean hasNext() 
      {
        return false;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public DirectoryAdapter next() 
      {
        throw new NoSuchElementException();
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object getObject (final int tag)
      {
        return ifd.getTIFFField(tag).getData();
      }
  }
