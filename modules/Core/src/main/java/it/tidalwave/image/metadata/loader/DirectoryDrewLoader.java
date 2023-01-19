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

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.NoSuchElementException;
import com.drew.metadata.Directory;
import it.tidalwave.image.Rational;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class DirectoryDrewLoader implements DirectoryLoader
  {
    @Nonnull
    private final List<? extends Directory> directories;

    private final Directory directory;

    @Nonnegative
    private final int index;

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    public DirectoryDrewLoader (@Nonnull final List<? extends Directory> directories, @Nonnegative int index)
      {
        this.directories = directories;
        this.index = index;
        this.directory = directories.get(index);
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @SuppressWarnings("unchecked")
    @Override @Nonnull
    public int[] getTags()
      {
        final var result = new int[directory.getTagCount()];
        var j = 0;

        for (final var tag : directory.getTags())
          {
            result[j++] = tag.getTagType();
          }

        return result;


        /** TODO
         var xmp = new XMP();
         xmp.loadFromAdapter(xmpAdapter);
         xmp._setProperties(xmpDirectory.getXmpProperties()); // FIXME 18 e 19
         return xmp;
         */
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public Object getObject (final int tag)
            throws NoSuchElementException
      {
        checkIfTagExists(tag);
        return convertType(directory.getObject(tag));
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public String getTagName (final int tag)
      {
        checkIfTagExists(tag);
        return directory.getTagName(tag);
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override
    public boolean containsTag (final int tag)
      {
        return directory.containsTag(tag);
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public DirectoryLoader next()
      {
        return new DirectoryDrewLoader(directories, index + 1);
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override
    public boolean hasNext()
      {
        return index + 1 < directories.size();
      }

    /*******************************************************************************************************************
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
     ******************************************************************************************************************/
    @Nonnull
    private static Object convertType (final @Nonnull Object value)
      {
        if (value instanceof com.drew.lang.Rational)
          {
            final var drewRational = (com.drew.lang.Rational)value;
            return Rational.of((int)drewRational.getNumerator(), (int)drewRational.getDenominator());
          }
        else if (value instanceof com.drew.lang.Rational[])
          {
            return convertType((com.drew.lang.Rational[])value);
          }

        return value;
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    @Nonnull
    private static Rational[] convertType (final @Nonnull com.drew.lang.Rational[] temp)
      {
        final var r = new Rational[temp.length];

        for (var i = 0; i < r.length; i++)
          {
            r[i] = Rational.of((int)temp[i].getNumerator(), (int)temp[i].getDenominator());
          }

        return r;
      }
  }
