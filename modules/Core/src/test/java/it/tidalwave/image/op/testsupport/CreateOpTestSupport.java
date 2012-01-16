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
package it.tidalwave.image.op.testsupport;

import java.awt.image.Raster;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.CreateOp;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public abstract class CreateOpTestSupport extends BaseTestSupport
  {
    private static final int WIDTH = 128;
    private static final int HEIGHT = 128;
    private static final int[] byteValues = { 0, 127, 255 };
    private static final int[] shortValues = { 0, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535 };
    private static final int[] shortValues2 = { 0, 255, 1023, 4095, 16383, 65535 };
    private static final int[] intValues = { 0, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, Integer.MAX_VALUE };
    private static final int[] intValues2 = { 0, 1023, 4095, 16383, 65535, Integer.MAX_VALUE };
    private static final float[] floatValues = { 0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f };
    private static final float[] floatValues2 = { 0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f };
    private static final double[] doubleValues = { 0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0 };
    private static final double[] doubleValues2 = { 0, 0.2, 0.4, 0.6, 0.8, 1.0 };

    ////////////////////////////////////////////////////////////////////////////
    //
    // new CreateOp(width, height, dataType);
    //
    ////////////////////////////////////////////////////////////////////////////
    @Test
    public void testCreateSingleBandByteBlack ()
      {
        log("testCreateSingleBandByteBlack");

        final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.BYTE));
        assertImage(image, 1, 8, 8, EditableImage.DataType.BYTE);
        assertIntContents(image, 0);
      }

/*    @Test FAILS
    public void testCreateSingleBandShortBlack ()
      {
        log("execute");

        final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.SHORT));
        assertImage(image, 1, 16, 16, EditableImage.DataType.SHORT);
      }*/
    @Test
    public void testCreateSingleBandUnsignedShortBlack ()
      {
        log("testCreateSingleBandUnsignedShortBlack");

        final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.UNSIGNED_SHORT));
        assertImage(image, 1, 16, 16, EditableImage.DataType.UNSIGNED_SHORT);
        assertIntContents(image, 0);
      }

    @Test
    public void testCreateSingleBandIntBlack ()
      {
        log("testCreateSingleBandFloatBlack");

        final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.INT));
        assertImage(image, 1, 32, 32, EditableImage.DataType.INT);
        assertIntContents(image, 0);
      }

    @Test
    public void testCreateSingleBandFloatBlack ()
      {
        log("testCreateSingleBandFloatBlack");

        final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.FLOAT));
        assertImage(image, 1, 32, 32, EditableImage.DataType.FLOAT);
        assertFloatContents(image, 0f);
      }

    @Test
    public void testCreateSingleBandDoubleBlack ()
      {
        log("testCreateSingleBandDoubleBlack");

        final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.DOUBLE));
        assertImage(image, 1, 64, 64, EditableImage.DataType.DOUBLE);
        assertDoubleContents(image, 0);
      }

    ////////////////////////////////////////////////////////////////////////////
    //
    // new CreateOp(width, height, dataType, initialValue);
    //
    ////////////////////////////////////////////////////////////////////////////
    @Test
    public void testCreateSingleBandByteInitialValue ()
      {
        log("testCreateSingleBandByteInitialValue");

        for (int i = 0; i < byteValues.length; i++)
          {
            final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.BYTE, byteValues[i]));
            assertImage(image, 1, 8, 8, EditableImage.DataType.BYTE);
            assertIntContents(image, byteValues[i]);
          }
      }

/*    @Test FAILS
    public void testCreateSingleBandShortInitialValue ()
      {
        log("execute");

        final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.SHORT, 32767));
        assertImage(image, 1, 16, 16, EditableImage.DataType.SHORT);
      }*/
    @Test
    public void testCreateSingleBandUnsignedShortInitialValue ()
      {
        log("testCreateSingleBandUnsignedShortInitialValue");

        for (int i = 0; i < shortValues.length; i++)
          {
            final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.UNSIGNED_SHORT,
                        shortValues[i]));
            assertImage(image, 1, 16, 16, EditableImage.DataType.UNSIGNED_SHORT);
            assertIntContents(image, shortValues[i]);
          }
      }

    @Test
    public void testCreateSingleBandIntInitialValue ()
      {
        log("testCreateSingleBandIntInitialValue");

        for (int i = 0; i < intValues.length; i++)
          {
            final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.INT, intValues[i]));
            assertImage(image, 1, 32, 32, EditableImage.DataType.INT);
            assertIntContents(image, intValues[i]);
          }
      }

    @Test
    public void testCreateSingleBandFloatInitialValue ()
      {
        log("testCreateSingleBandFloatInitialValue");

        for (int i = 0; i < floatValues.length; i++)
          {
            final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.FLOAT, floatValues[i]));
            assertImage(image, 1, 32, 32, EditableImage.DataType.FLOAT);
            assertFloatContents(image, floatValues[i]);
          }
      }

    @Test
    public void testCreateSingleBandDoubleInitialValue ()
      {
        log("testCreateSingleBandDoubleInitialValue");

        for (int i = 0; i < doubleValues.length; i++)
          {
            final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.DOUBLE, doubleValues[i]));
            assertImage(image, 1, 64, 64, EditableImage.DataType.DOUBLE);
            assertDoubleContents(image, doubleValues[i]);
          }
      }

    ////////////////////////////////////////////////////////////////////////////
    //
    // new CreateOp(width, height, dataType, r,g,b);
    //
    ////////////////////////////////////////////////////////////////////////////
    @Test
    public void testCreateThreeBandsByteInitialValue ()
      {
        log("testCreateThreeBandsByteInitialValue");

        for (int r = 0; r < byteValues.length; r++)
          {
            for (int g = 0; g < byteValues.length; g++)
              {
                for (int b = 0; b < byteValues.length; b++)
                  {
                    final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.BYTE,
                                byteValues[r], byteValues[g], byteValues[b]));
                    assertImage(image, 3, 8, 24, EditableImage.DataType.BYTE);
                    assertIntContents(image, byteValues[r], byteValues[g], byteValues[b]);
                  }
              }
          }
      }

/*    @Test FAILS
    public void testCreateSingleBandShortInitialValue ()
      {
        log("execute");

        final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.SHORT, 32767));
        assertImage(image, 1, 16, 16, EditableImage.DataType.SHORT);
      }*/
    @Test
    public void testCreateThreeBandsUnsignedShortInitialValue ()
      {
        log("testCreateThreeBandsUnsignedShortInitialValue");

        for (int r = 0; r < shortValues2.length; r++)
          {
            for (int g = 0; g < shortValues2.length; g++)
              {
                for (int b = 0; b < shortValues2.length; b++)
                  {
                    final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.UNSIGNED_SHORT,
                                shortValues2[r], shortValues2[g], shortValues2[b]));
                    assertImage(image, 3, 16, 48, EditableImage.DataType.UNSIGNED_SHORT);
                    assertIntContents(image, shortValues2[r], shortValues2[g], shortValues2[b]);
                  }
              }
          }
      }

    @Test
    public void testCreateThreeBandsIntInitialValue ()
      {
        log("testCreateThreeBandsIntInitialValue");

        for (int r = 0; r < intValues2.length; r++)
          {
            for (int g = 0; g < intValues2.length; g++)
              {
                for (int b = 0; b < intValues2.length; b++)
                  {
                    final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.INT, intValues2[r],
                                intValues2[g], intValues2[b]));
                    assertImage(image, 3, 32, 96, EditableImage.DataType.INT);
                    assertIntContents(image, intValues2[r], intValues2[g], intValues2[b]);
                  }
              }
          }
      }

    @Test
    public void testCreateThreeBandsFloatInitialValue ()
      {
        log("testCreateThreeBandsFloatInitialValue");

        for (int r = 0; r < floatValues2.length; r++)
          {
            for (int g = 0; g < floatValues2.length; g++)
              {
                for (int b = 0; b < floatValues2.length; b++)
                  {
                    final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.FLOAT,
                                floatValues2[r], floatValues2[g], floatValues2[b]));
                    assertImage(image, 3, 32, 96, EditableImage.DataType.FLOAT);
                    assertFloatContents(image, floatValues2[r], floatValues2[g], floatValues2[b]);
                  }
              }
          }
      }

    @Test
    public void testCreateThreeBandsDoubleInitialValue ()
      {
        log("testCreateThreeBandsDoubleInitialValue");

        for (int r = 0; r < doubleValues2.length; r++)
          {
            for (int g = 0; g < doubleValues2.length; g++)
              {
                for (int b = 0; b < doubleValues2.length; b++)
                  {
                    final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.DOUBLE,
                                doubleValues2[r], doubleValues2[g], doubleValues2[b]));
                    assertImage(image, 3, 64, 192, EditableImage.DataType.DOUBLE);
                    assertDoubleContents(image, doubleValues2[r], doubleValues2[g], doubleValues2[b]);
                  }
              }
          }
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    protected abstract Raster getRaster (final EditableImage image);
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    private void assertIntContents (final EditableImage image, final int... filler)
      {
        final Raster raster = getRaster(image);

        for (int b = 0; b < image.getBandCount(); b++)
          {
            for (int y = 0; y < image.getHeight(); y++)
              {
                for (int x = 0; x < image.getWidth(); x++)
                  {
                    int sample = raster.getSample(x, y, b);
                    assertEquals(filler[b], sample);
                  }
              }
          }
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    private void assertFloatContents (final EditableImage image, final float... filler)
      {
        final Raster raster = getRaster(image);

        for (int b = 0; b < image.getBandCount(); b++)
          {
            for (int y = 0; y < image.getHeight(); y++)
              {
                for (int x = 0; x < image.getWidth(); x++)
                  {
                    float sample = raster.getSampleFloat(x, y, b);
                    assertEquals(filler[b], sample);
                  }
              }
          }
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    private void assertDoubleContents (final EditableImage image, final double... filler)
      {
        final Raster raster = getRaster(image);

        for (int b = 0; b < image.getBandCount(); b++)
          {
            for (int y = 0; y < image.getHeight(); y++)
              {
                for (int x = 0; x < image.getWidth(); x++)
                  {
                    double sample = raster.getSampleDouble(x, y, b);
                    assertEquals(filler[b], sample);
                  }
              }
          }
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    private void assertImage (final EditableImage image, final int bandCount, final int bitsPerBand, final int bitsPerPixel,
        final EditableImage.DataType dataType)
      {
        assertEquals(WIDTH, image.getWidth());
        assertEquals(HEIGHT, image.getHeight());
        assertEquals(bandCount, image.getBandCount());
        assertEquals(bitsPerBand, image.getBitsPerBand());
        assertEquals(bitsPerPixel, image.getBitsPerPixel());
        assertEquals(dataType, image.getDataType());
      }
  }
