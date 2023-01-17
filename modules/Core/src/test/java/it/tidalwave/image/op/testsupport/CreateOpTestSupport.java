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
package it.tidalwave.image.op.testsupport;

import java.awt.image.Raster;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.CreateOp;
import lombok.extern.slf4j.Slf4j;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public abstract class CreateOpTestSupport extends BaseTestSupport
  {
    private static final int WIDTH = 128;
    private static final int HEIGHT = 128;
    private static final int[] byteValues = {0, 127, 255};
    private static final int[] shortValues = {0, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    private static final int[] shortValues2 = {0, 255, 1023, 4095, 16383, 65535};
    private static final int[] intValues =
            {0, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, Integer.MAX_VALUE};
    private static final int[] intValues2 = {0, 1023, 4095, 16383, 65535, Integer.MAX_VALUE};
    private static final float[] floatValues = {0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final float[] floatValues2 = {0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f};
    private static final double[] doubleValues = {0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
    private static final double[] doubleValues2 = {0, 0.2, 0.4, 0.6, 0.8, 1.0};

    ////////////////////////////////////////////////////////////////////////////
    //
    // new CreateOp(width, height, dataType);
    //
    ////////////////////////////////////////////////////////////////////////////
    @Test
    public void testCreateSingleBandByteBlack()
      {
        log.info("testCreateSingleBandByteBlack");

        final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.BYTE));
        assertImage(image, 1, 8, 8, EditableImage.DataType.BYTE);
        assertIntContents(image, 0);
      }

    /*    @Test FAILS
        public void testCreateSingleBandShortBlack()
          {
            log.info("execute");

            final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.SHORT));
            assertImage(image, 1, 16, 16, EditableImage.DataType.SHORT);
          }*/
    @Test
    public void testCreateSingleBandUnsignedShortBlack()
      {
        log.info("testCreateSingleBandUnsignedShortBlack");

        final EditableImage image =
                EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.UNSIGNED_SHORT));
        assertImage(image, 1, 16, 16, EditableImage.DataType.UNSIGNED_SHORT);
        assertIntContents(image, 0);
      }

    @Test
    public void testCreateSingleBandIntBlack()
      {
        log.info("testCreateSingleBandFloatBlack");

        final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.INT));
        assertImage(image, 1, 32, 32, EditableImage.DataType.INT);
        assertIntContents(image, 0);
      }

    @Test
    public void testCreateSingleBandFloatBlack()
      {
        log.info("testCreateSingleBandFloatBlack");

        final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.FLOAT));
        assertImage(image, 1, 32, 32, EditableImage.DataType.FLOAT);
        assertFloatContents(image, 0f);
      }

    @Test
    public void testCreateSingleBandDoubleBlack()
      {
        log.info("testCreateSingleBandDoubleBlack");

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
    public void testCreateSingleBandByteInitialValue()
      {
        log.info("testCreateSingleBandByteInitialValue");

        for (int byteValue : byteValues)
          {
            final EditableImage image =
                    EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.BYTE, byteValue));
            assertImage(image, 1, 8, 8, EditableImage.DataType.BYTE);
            assertIntContents(image, byteValue);
          }
      }

    /*    @Test FAILS
        public void testCreateSingleBandShortInitialValue()
          {
            log.info("execute");

            final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType
            .SHORT, 32767));
            assertImage(image, 1, 16, 16, EditableImage.DataType.SHORT);
          }*/
    @Test
    public void testCreateSingleBandUnsignedShortInitialValue()
      {
        log.info("testCreateSingleBandUnsignedShortInitialValue");

        for (int shortValue : shortValues)
          {
            final EditableImage image =
                    EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.UNSIGNED_SHORT,
                                                      shortValue));
            assertImage(image, 1, 16, 16, EditableImage.DataType.UNSIGNED_SHORT);
            assertIntContents(image, shortValue);
          }
      }

    @Test
    public void testCreateSingleBandIntInitialValue()
      {
        log.info("testCreateSingleBandIntInitialValue");

        for (int intValue : intValues)
          {
            final EditableImage image =
                    EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.INT, intValue));
            assertImage(image, 1, 32, 32, EditableImage.DataType.INT);
            assertIntContents(image, intValue);
          }
      }

    @Test
    public void testCreateSingleBandFloatInitialValue()
      {
        log.info("testCreateSingleBandFloatInitialValue");

        for (float floatValue : floatValues)
          {
            final EditableImage image =
                    EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.FLOAT, floatValue));
            assertImage(image, 1, 32, 32, EditableImage.DataType.FLOAT);
            assertFloatContents(image, floatValue);
          }
      }

    @Test
    public void testCreateSingleBandDoubleInitialValue()
      {
        log.info("testCreateSingleBandDoubleInitialValue");

        for (double doubleValue : doubleValues)
          {
            final EditableImage image =
                    EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.DOUBLE, doubleValue));
            assertImage(image, 1, 64, 64, EditableImage.DataType.DOUBLE);
            assertDoubleContents(image, doubleValue);
          }
      }

    ////////////////////////////////////////////////////////////////////////////
    //
    // new CreateOp(width, height, dataType, r,g,b);
    //
    ////////////////////////////////////////////////////////////////////////////
    @Test
    public void testCreateThreeBandsByteInitialValue()
      {
        log.info("testCreateThreeBandsByteInitialValue");

        for (int i : byteValues)
          {
            for (int value : byteValues)
              {
                for (int byteValue : byteValues)
                  {
                    final EditableImage image =
                            EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.BYTE,
                                                              i, value, byteValue));
                    assertImage(image, 3, 8, 24, EditableImage.DataType.BYTE);
                    assertIntContents(image, i, value, byteValue);
                  }
              }
          }
      }

    /*    @Test FAILS
        public void testCreateSingleBandShortInitialValue()
          {
            log.info("execute");

            final EditableImage image = EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType
            .SHORT, 32767));
            assertImage(image, 1, 16, 16, EditableImage.DataType.SHORT);
          }*/
    @Test
    public void testCreateThreeBandsUnsignedShortInitialValue()
      {
        log.info("testCreateThreeBandsUnsignedShortInitialValue");

        for (int k : shortValues2)
          {
            for (int j : shortValues2)
              {
                for (int i : shortValues2)
                  {
                    final EditableImage image =
                            EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.UNSIGNED_SHORT,
                                                              k, j, i));
                    assertImage(image, 3, 16, 48, EditableImage.DataType.UNSIGNED_SHORT);
                    assertIntContents(image, k, j, i);
                  }
              }
          }
      }

    @Test
    public void testCreateThreeBandsIntInitialValue()
      {
        log.info("testCreateThreeBandsIntInitialValue");

        for (int k : intValues2)
          {
            for (int j : intValues2)
              {
                for (int i : intValues2)
                  {
                    final EditableImage image =
                            EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.INT, k,
                                                              j, i));
                    assertImage(image, 3, 32, 96, EditableImage.DataType.INT);
                    assertIntContents(image, k, j, i);
                  }
              }
          }
      }

    @Test
    public void testCreateThreeBandsFloatInitialValue()
      {
        log.info("testCreateThreeBandsFloatInitialValue");

        for (float item : floatValues2)
          {
            for (float value : floatValues2)
              {
                for (float v : floatValues2)
                  {
                    final EditableImage image =
                            EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.FLOAT,
                                                              item, value, v));
                    assertImage(image, 3, 32, 96, EditableImage.DataType.FLOAT);
                    assertFloatContents(image, item, value, v);
                  }
              }
          }
      }

    @Test
    public void testCreateThreeBandsDoubleInitialValue()
      {
        log.info("testCreateThreeBandsDoubleInitialValue");

        for (double item : doubleValues2)
          {
            for (double value : doubleValues2)
              {
                for (double v : doubleValues2)
                  {
                    final EditableImage image =
                            EditableImage.create(new CreateOp(WIDTH, HEIGHT, EditableImage.DataType.DOUBLE,
                                                              item, value, v));
                    assertImage(image, 3, 64, 192, EditableImage.DataType.DOUBLE);
                    assertDoubleContents(image, item, value, v);
                  }
              }
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected abstract Raster getRaster (final EditableImage image);

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private void assertIntContents (final EditableImage image, final int... filler)
      {
        final Raster raster = getRaster(image);

        for (int b = 0; b < image.getBandCount(); b++)
          {
            for (int y = 0; y < image.getHeight(); y++)
              {
                for (int x = 0; x < image.getWidth(); x++)
                  {
                    final int sample = raster.getSample(x, y, b);
                    AssertJUnit.assertEquals(filler[b], sample);
                  }
              }
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private void assertFloatContents (final EditableImage image, final float... filler)
      {
        final Raster raster = getRaster(image);

        for (int b = 0; b < image.getBandCount(); b++)
          {
            for (int y = 0; y < image.getHeight(); y++)
              {
                for (int x = 0; x < image.getWidth(); x++)
                  {
                    final float sample = raster.getSampleFloat(x, y, b);
                    AssertJUnit.assertEquals(filler[b], sample);
                  }
              }
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private void assertDoubleContents (final EditableImage image, final double... filler)
      {
        final Raster raster = getRaster(image);

        for (int b = 0; b < image.getBandCount(); b++)
          {
            for (int y = 0; y < image.getHeight(); y++)
              {
                for (int x = 0; x < image.getWidth(); x++)
                  {
                    final double sample = raster.getSampleDouble(x, y, b);
                    AssertJUnit.assertEquals(filler[b], sample);
                  }
              }
          }
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private void assertImage (final EditableImage image,
                              final int bandCount,
                              final int bitsPerBand,
                              final int bitsPerPixel,
                              final EditableImage.DataType dataType)
      {
        AssertJUnit.assertEquals(WIDTH, image.getWidth());
        AssertJUnit.assertEquals(HEIGHT, image.getHeight());
        AssertJUnit.assertEquals(bandCount, image.getBandCount());
        AssertJUnit.assertEquals(bitsPerBand, image.getBitsPerBand());
        AssertJUnit.assertEquals(bitsPerPixel, image.getBitsPerPixel());
        AssertJUnit.assertEquals(dataType, image.getDataType());
      }
  }
