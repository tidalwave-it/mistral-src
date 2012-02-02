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
package it.tidalwave.image;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class Rational extends Number
  {
    private final int numerator;
    private final int denominator;

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Rational (final int i, final int j)
      {
        numerator = i;
        denominator = j;
      }

    /***************************************************************************
     *
     * @param d
     *
     **************************************************************************/
    public Rational (final double d)
      {
        denominator = 100000;
        numerator = (int)Math.round(d * denominator);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public final double doubleValue()
      {
        return (double)numerator / (double)denominator;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public final float floatValue()
      {
        return (float)numerator / (float)denominator;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public final byte byteValue()
      {
        return (byte)doubleValue();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public final int intValue()
      {
        return (int)doubleValue();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public final long longValue()
      {
        return (long)doubleValue();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public final short shortValue()
      {
        return (short)doubleValue();
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public final int getDenominator()
      {
        return denominator;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public final int getNumerator()
      {
        return numerator;
      }

    /*******************************************************************************
     *
     * @param det
     * @return
     *
     *******************************************************************************/
    public final Rational divide (final double det)
      {
        return new Rational(numerator, (int)Math.round(denominator * det));
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public final Rational getReciprocal()
      {
        return new Rational(denominator, numerator);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public final boolean isInteger()
      {
        return (denominator == 1) || ((denominator != 0) && ((numerator % denominator) == 0))
        || ((denominator == 0) && (numerator == 0));
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public final String toString ()
      {
        return numerator + "/" + denominator;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public final boolean equals (final Object object)
      {
        if (!(object instanceof Rational))
          {
            return false;
          }

        final Rational rational = (Rational)object;

        return (denominator == rational.denominator) && (numerator == rational.numerator);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public final int hashCode ()
      {
        return numerator ^ denominator;
      }
  }
