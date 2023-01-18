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
import java.util.NoSuchElementException;
import java.util.Objects;
import it.tidalwave.imageio.raw.Directory;
import it.tidalwave.imageio.raw.TagRational;
import it.tidalwave.image.Rational;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class DirectoryRawLoader implements DirectoryLoader
  {
    private final Directory directory;
    private Directory nextDirectory;

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public DirectoryRawLoader (final @Nonnull Directory directory)
      {
        Objects.requireNonNull(directory, "directory");
        this.directory = (Directory)directory;
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @SuppressWarnings("unchecked")
    @Override @Nonnull
    public int[] getTags()
      {
        final var tags = directory.getTags();
        final var result = new int[tags.size()];
        var j = 0;

        for (final var tag : tags)
          {
            result[j++] = tag.getCode();
          }

        return result;
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public String[] getSubDirectoryNames()
      {
        return directory.getSubDirectoryNames();
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public DirectoryLoader getSubDirectory (final String name)
      {
        final var subDirectory = directory.getNamedDirectory(name);
        return (subDirectory != null) ? new DirectoryRawLoader(subDirectory) : null;
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
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

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public DirectoryLoader next()
      {
        if (nextDirectory == null)
          {
            nextDirectory = directory.getNextDirectory();
          }

        return (nextDirectory == null) ? null : new DirectoryRawLoader(nextDirectory);
      }

    /*******************************************************************************************************************
     * {@inheritDoc}
     ******************************************************************************************************************/
    @Override @Nonnull
    public Object getObject (final int tag)
            throws NoSuchElementException
      {
        checkIfTagExists(tag);
        final var value = directory.getObject(tag);

        if (value instanceof TagRational)
          {
            final var rational = (TagRational)value;
            return Rational.of(rational.getNumerator(), rational.getDenominator());
          }

        else if (value instanceof TagRational[])
          {
            return convertRationalArray((TagRational[])value);
          }

        return value;
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
        return directory != null && directory.containsTag(tag);
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
    private static Rational[] convertRationalArray (final TagRational[] temp)
      {
        final var r = new Rational[temp.length];

        for (var i = 0; i < r.length; i++)
          {
            r[i] = Rational.of(temp[i].getNumerator(), temp[i].getDenominator());
          }

        return r;
      }
  }
