/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici
 *                        and Emmanuele Sordini
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *******************************************************************************
 *
 * $Id: CreateJ2DOpTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.java2d;

import it.tidalwave.image.op.testsupport.CreateOpTestSupport;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.testsupport.CreateOpTestSupport;
import junit.framework.Test;
import junit.framework.TestSuite;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: CreateJ2DOpTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class CreateJ2DOpTest extends CreateOpTestSupport
  {
    public static Test suite ()
      {
        return new TestSuite(CreateJ2DOpTest.class);
      }

    public CreateJ2DOpTest (final String name)
      {
        super(name);  
      }
    
    @Override
    public void testCreateSingleBandIntBlack ()
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
    public void testCreateSingleBandFloatBlack ()
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
    public void testCreateSingleBandDoubleBlack ()
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
    public void testCreateSingleBandIntInitialValue ()
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
    public void testCreateSingleBandFloatInitialValue ()
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
    public void testCreateSingleBandDoubleInitialValue ()
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
    public void testCreateThreeBandsUnsignedShortInitialValue ()
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
    public void testCreateThreeBandsIntInitialValue ()
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
    public void testCreateThreeBandsFloatInitialValue ()
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
    public void testCreateThreeBandsDoubleInitialValue ()
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

    protected Raster getRaster (final EditableImage image)
      {
        return image.getInnerProperty(BufferedImage.class).getRaster();
      }
  }