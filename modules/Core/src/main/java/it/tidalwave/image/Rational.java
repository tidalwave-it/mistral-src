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
package it.tidalwave.image;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Immutable @RequiredArgsConstructor(staticName = "of") @EqualsAndHashCode(callSuper = false)
public final class Rational extends Number
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
    public double doubleValue()
      {
        return (double)numerator / (double)denominator;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public float floatValue()
      {
        return (float)numerator / (float)denominator;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public byte byteValue()
      {
        return (byte)doubleValue();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public int intValue()
      {
        return (int)doubleValue();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public long longValue()
      {
        return (long)doubleValue();
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public short shortValue()
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
    public Rational divide (final double det)
      {
        return Rational.of(numerator, (int)Math.round(denominator * det));
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public Rational getReciprocal()
      {
        return Rational.of(denominator, numerator);
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public boolean isInteger()
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
    public String toString()
      {
        return numerator + "/" + denominator;
      }
  }
