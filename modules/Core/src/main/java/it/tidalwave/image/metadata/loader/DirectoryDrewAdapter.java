/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2011 by Tidalwave s.a.s.
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
 * WWW: http://mistral.tidalwave.it
 * SCM: https://kenai.com/hg/mistral~src
 *
 **********************************************************************************************************************/
package it.tidalwave.image.metadata.loader;

import java.util.Iterator;
import java.util.NoSuchElementException;
import com.drew.metadata.Directory;
import com.drew.metadata.Tag;
import it.tidalwave.image.Rational;

/*******************************************************************************
 *
 * @author  fritz
 * @version $Id$
 *
 ******************************************************************************/
public class DirectoryDrewAdapter implements DirectoryAdapter
  {
    private final Directory directory;

    /***************************************************************************
     *
     *
     **************************************************************************/
    public DirectoryDrewAdapter (final Object directory)
      {
        this.directory = (Directory)directory;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @SuppressWarnings("unchecked")
    public int[] getTags ()
      {
        final int[] result = new int[directory.getTagCount()];
        int j = 0;

        for (final Iterator<Tag> i = directory.getTagIterator(); i.hasNext();)
          {
            final Tag tag = i.next();
            result[j++] = tag.getTagType();
          }

        return result;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public String[] getSubDirectoryNames()
      {
        // TODO Auto-generated method stub
        return new String[0];
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public DirectoryAdapter getSubDirectory (final String name)
      {
        // TODO Auto-generated method stub
        return null;
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
        throws NoSuchElementException
      {
        checkIfTagExists(tag);

        Object value = directory.getObject(tag);

        if (value instanceof com.drew.lang.Rational)
          {
            final com.drew.lang.Rational drewRational = (com.drew.lang.Rational) value;
            value = new Rational(drewRational.getNumerator(), drewRational.getDenominator());
          }

        else if (value instanceof com.drew.lang.Rational[])
          {
            value = convertRationalArray((com.drew.lang.Rational[])value);
          }

        return value;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public String getTagName (final int tag)
      {
        checkIfTagExists(tag);
        return directory.getTagName(tag);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public boolean containsTag (final int tag)
      {
        return (directory != null) ? directory.containsTag(tag) : false;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    private void checkIfTagExists (final int tag)
      throws NoSuchElementException
      {
        if (!containsTag(tag))
          {
            throw new NoSuchElementException("" + tag);
          }
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    private static Rational[] convertRationalArray (final com.drew.lang.Rational[] temp)
      {
        final Rational[] r = new Rational[temp.length];

        for (int i = 0; i < r.length; i++)
          {
            r[i] = new Rational(temp[i].getNumerator(), temp[i].getDenominator());
          }

        return r;
      }
  }
