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
import com.drew.metadata.Directory;
import com.drew.metadata.Tag;
import it.tidalwave.image.Rational;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class DirectoryDrewAdapter implements DirectoryAdapter
  {
    private final Directory directory;

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public DirectoryDrewAdapter (final Object directory)
      {
        this.directory = (Directory)directory;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @SuppressWarnings("unchecked")
    @Override
    public int[] getTags()
      {
        final var result = new int[directory.getTagCount()];
        var j = 0;

        for (final var tag : directory.getTags())
          {
            result[j++] = tag.getTagType();
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
        // TODO Auto-generated method stub
        return new String[0];
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public DirectoryAdapter getSubDirectory (final String name)
      {
        // TODO Auto-generated method stub
        return null;
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
            throws NoSuchElementException
      {
        checkIfTagExists(tag);

        var value = directory.getObject(tag);

        if (value instanceof com.drew.lang.Rational)
          {
            final var drewRational = (com.drew.lang.Rational)value;
            value = Rational.of((int)drewRational.getNumerator(), (int)drewRational.getDenominator());
          }

        else if (value instanceof com.drew.lang.Rational[])
          {
            value = convertRationalArray((com.drew.lang.Rational[])value);
          }

        return value;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public String getTagName (final int tag)
      {
        checkIfTagExists(tag);
        return directory.getTagName(tag);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public boolean containsTag (final int tag)
      {
        return directory != null && directory.containsTag(tag);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private void checkIfTagExists (final int tag)
            throws NoSuchElementException
      {
        if (!containsTag(tag))
          {
            throw new NoSuchElementException("" + tag);
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static Rational[] convertRationalArray (final com.drew.lang.Rational[] temp)
      {
        final var r = new Rational[temp.length];

        for (var i = 0; i < r.length; i++)
          {
            r[i] = Rational.of((int)temp[i].getNumerator(), (int)temp[i].getDenominator());
          }

        return r;
      }
  }
