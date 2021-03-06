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
 * WWW: http://mistral.tidalwave.it
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package it.tidalwave.image.metadata.loader;

import java.util.Collection;
import java.util.NoSuchElementException;
import it.tidalwave.imageio.raw.AbstractTag;
import it.tidalwave.imageio.raw.Directory;
import it.tidalwave.imageio.raw.TagRational;
import it.tidalwave.image.Rational;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class DirectoryRawAdapter implements DirectoryAdapter
  {
    private final Directory directory;
    private Directory nextDirectory;

    /***************************************************************************
     *
     *
     **************************************************************************/
    public DirectoryRawAdapter (final Object directory)
      {
        if (directory == null)
          {
            throw new IllegalArgumentException();
          }

        this.directory = (Directory)directory;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @SuppressWarnings("unchecked")
    @Override
    public int[] getTags()
      {
        final Collection<AbstractTag> tags = directory.getTags();
        final int[] result = new int[tags.size()];
        int j = 0;

        for (final AbstractTag tag : tags)
          {
            result[j++] = tag.getCode();
          }

        return result;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public String[] getSubDirectoryNames()
      {
        return directory.getSubDirectoryNames();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public DirectoryAdapter getSubDirectory (final String name)
      {
        final Directory subDirectory = directory.getNamedDirectory(name);
        return (subDirectory != null) ? new DirectoryRawAdapter(subDirectory) : null;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public boolean hasNext() 
      {
        try
          {
            return next() != null;
          }
        catch (NoSuchElementException e)
          {
            return false;
          }
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public DirectoryAdapter next() 
      {
        if (nextDirectory == null)
          {
            nextDirectory = directory.getNextDirectory();
          }
        
        return  (nextDirectory == null) ? null : new DirectoryRawAdapter(nextDirectory);
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object getObject (final int tag)
      throws NoSuchElementException
      {
        checkIfTagExists(tag);
        final Object value = directory.getObject(Integer.valueOf(tag));

        if (value instanceof TagRational)
          {
            final TagRational rational = (TagRational)value;
            return new Rational(rational.getNumerator(), rational.getDenominator());
          }

        else if (value instanceof TagRational[])
          {
            return convertRationalArray((TagRational[])value);
          }

        return value;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public String getTagName (final int tag)
      {
        checkIfTagExists(tag);
        return directory.getTagName(Integer.valueOf(tag));
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public boolean containsTag (final int tag)
      {
        return (directory != null) ? directory.containsTag(Integer.valueOf(tag)) : false;
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
    private static Rational[] convertRationalArray (final TagRational[] temp)
      {
        final Rational[] r = new Rational[temp.length];

        for (int i = 0; i < r.length; i++)
          {
            r[i] = new Rational(temp[i].getNumerator(), temp[i].getDenominator());
          }

        return r;
      }
  }
