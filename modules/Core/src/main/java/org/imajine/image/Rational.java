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
package org.imajine.image;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Immutable @RequiredArgsConstructor @EqualsAndHashCode(callSuper=false)
public class Rational extends Number
  {
    @Getter
    private final int numerator;
    
    @Getter
    private final int denominator;

    /*******************************************************************************************************************
     *
     * @param d
     *
     ******************************************************************************************************************/
    public Rational (final double d)
      {
        denominator = 100000;
        numerator = (int)Math.round(d * denominator);
        // TODO: normalize
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public final double doubleValue()
      {
        return (double)numerator / (double)denominator;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public final float floatValue()
      {
        return (float)numerator / (float)denominator;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public final byte byteValue()
      {
        return (byte)doubleValue();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public final int intValue()
      {
        return (int)doubleValue();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public final long longValue()
      {
        return (long)doubleValue();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public final short shortValue()
      {
        return (short)doubleValue();
      }

    /*******************************************************************************************************************
     *
     *
     * @param det
     * @return
     *
     ******************************************************************************************************************/
    @Nonnull
    public final Rational divide (final double det)
      {
        return new Rational(numerator, (int)Math.round(denominator * det));
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public final Rational getReciprocal()
      {
        return new Rational(denominator, numerator);
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public final boolean isInteger()
      {
        return (denominator == 1) || ((denominator != 0) && ((numerator % denominator) == 0))
        || ((denominator == 0) && (numerator == 0));
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override @Nonnull
    public final String toString()
      {
        return numerator + "/" + denominator;
      }
  }
