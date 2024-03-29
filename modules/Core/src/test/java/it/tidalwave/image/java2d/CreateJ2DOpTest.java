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
package it.tidalwave.image.java2d;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.testsupport.CreateOpTestSupport;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class CreateJ2DOpTest extends CreateOpTestSupport
  {
    @Override
    @Test
    public void testCreateSingleBandIntBlack()
      {
        try
          {
            super.testCreateSingleBandIntBlack();
            fail("Should be unsupported...");
          }
        catch (UnsupportedOperationException e)
          {
            // ok
          }
      }

    @Override
    @Test
    public void testCreateSingleBandFloatBlack()
      {
        try
          {
            super.testCreateSingleBandFloatBlack();
            fail("Should be unsupported...");
          }
        catch (UnsupportedOperationException e)
          {
            // ok
          }
      }

    @Override
    @Test
    public void testCreateSingleBandDoubleBlack()
      {
        try
          {
            super.testCreateSingleBandDoubleBlack();
            fail("Should be unsupported...");
          }
        catch (UnsupportedOperationException e)
          {
            // ok
          }
      }

    @Override
    @Test
    public void testCreateSingleBandIntInitialValue()
      {
        try
          {
            super.testCreateSingleBandIntInitialValue();
            fail("Should be unsupported...");
          }
        catch (UnsupportedOperationException e)
          {
            // ok
          }
      }

    @Override
    @Test
    public void testCreateSingleBandFloatInitialValue()
      {
        try
          {
            super.testCreateSingleBandFloatInitialValue();
            fail("Should be unsupported...");
          }
        catch (UnsupportedOperationException e)
          {
            // ok
          }
      }

    @Override
    @Test
    public void testCreateSingleBandDoubleInitialValue()
      {
        try
          {
            super.testCreateSingleBandDoubleInitialValue();
            fail("Should be unsupported...");
          }
        catch (UnsupportedOperationException e)
          {
            // ok
          }
      }

    @Override
    @Test
    public void testCreateThreeBandsUnsignedShortInitialValue()
      {
        try
          {
            super.testCreateThreeBandsUnsignedShortInitialValue();

            fail("Should be unsupported...");
          }
        catch (UnsupportedOperationException e)
          {
            // ok
          }
      }

    @Override
    @Test
    public void testCreateThreeBandsIntInitialValue()
      {
        try
          {
            super.testCreateThreeBandsIntInitialValue();

            fail("Should be unsupported...");
          }
        catch (UnsupportedOperationException e)
          {
            // ok
          }
      }

    @Override
    @Test
    public void testCreateThreeBandsFloatInitialValue()
      {
        try
          {
            super.testCreateThreeBandsFloatInitialValue();

            fail("Should be unsupported...");
          }
        catch (UnsupportedOperationException e)
          {
            // ok
          }
      }

    @Override
    @Test
    public void testCreateThreeBandsDoubleInitialValue()
      {
        try
          {
            super.testCreateThreeBandsDoubleInitialValue();

            fail("Should be unsupported...");
          }
        catch (UnsupportedOperationException e)
          {
            // ok
          }
      }

    @Override
    protected Raster getRaster (final EditableImage image)
      {
        return image.getInnerProperty(BufferedImage.class).getRaster();
      }
  }
