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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.image.util;

import javax.annotation.Nonnull;
import javax.annotation.CheckForNull;
import java.util.ArrayList;
import java.util.Collection;

/*******************************************************************************
 *
 * This class provides a few static utility methods to extracts parameters from
 * an array.
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public final class Parameters
  {
    private Parameters()
      {
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public static void checkNonNull (@CheckForNull final Object parameter,
                                     @Nonnull final String name)
      throws IllegalArgumentException
      {
        if (parameter == null)
          {
            throw new IllegalArgumentException(String.format("%s is mandatory", name));
          }
      }

    /***************************************************************************
     *
     * Extracts a singled-value parameter of the given type from an array. If the
     * parameter is not found, the default value is passed. If more than a single
     * parameter is found, an {@link IllegalparameterException} is thrown.
     *
     * @param  parameterClass           the class of the parameter to retrieve
     * @param  defaultOption            the default value of the parameter
     * @param  parameters                the array of parameters
     * @throws IllegalparameterException if more than a single value is found
     *
     **************************************************************************/
    @CheckForNull
    public static <T,O> T find (@Nonnull final Class<T> parameterClass,
                                @CheckForNull final T defaultOption,
                                @Nonnull final O ... parameters)
      throws IllegalArgumentException
      {
        final Collection<T> c = find(parameterClass, parameters);

        if (c.size() > 1)
          {
            throw new IllegalArgumentException(String.format("Multiple values for %s have been specified",
                                                             parameterClass.getSimpleName()));
          }

        return c.isEmpty() ? defaultOption : c.iterator().next();
      }

    /***************************************************************************
     *
     * Extracts multiple-value parameters of the given type from an array. If the
     * parameter is not found, an empty collection is returned.
     *
     * @param  parameterClass            the class of the parameter to retrieve
     * @param  parameters                the array of parameters
     *
     **************************************************************************/
    @Nonnull
    public static <T,O> Collection<T> find (@Nonnull final Class<T> parameterClass,
                                            @Nonnull final O ... parameters)
      {
        final Collection<T> result = new ArrayList<T>();

        for (final Object parameter : parameters)
          {
            if (parameterClass.isAssignableFrom(parameter.getClass()))
              {
                result.add((T)parameter);
              }
          }

        return result;
      }
  }
