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
 * $Id: CreateOpTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import java.awt.Color;
import it.tidalwave.image.EditableImage;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: CreateOpTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class CreateOpTest extends TestCase
  {
    public static Test suite ()
      {
        return new TestSuite(CreateOpTest.class);
      }

    public void testGetWidth ()
      {
        for (int w = 1; w < 1000; w += 10)
          {
            final CreateOp createOp1 = new CreateOp(w, 10, EditableImage.DataType.BYTE);
            assertEquals(w, createOp1.getWidth());

            final CreateOp createOp2 = new CreateOp(w, 10, EditableImage.DataType.BYTE, Color.BLACK);
            assertEquals(w, createOp2.getWidth());

            final CreateOp createOp3 = new CreateOp(w, 10, EditableImage.DataType.BYTE, 0);
            assertEquals(w, createOp3.getWidth());
          }
      }

    public void testGetHeight ()
      {
        for (int h = 1; h < 1000; h += 10)
          {
            final CreateOp createOp1 = new CreateOp(10, h, EditableImage.DataType.BYTE);
            assertEquals(h, createOp1.getHeight());

            final CreateOp createOp2 = new CreateOp(10, h, EditableImage.DataType.BYTE, Color.BLACK);
            assertEquals(h, createOp2.getHeight());

            final CreateOp createOp3 = new CreateOp(10, h, EditableImage.DataType.BYTE, 0);
            assertEquals(h, createOp3.getHeight());
          }
      }

    public void testGetDataType ()
      {
        for (EditableImage.DataType dataType : EditableImage.DataType.values())
          {
            if (dataType == EditableImage.DataType.UNDEFINED)
              {
                continue;
              }

            final CreateOp createOp1 = new CreateOp(10, 10, dataType);
            assertEquals(dataType, createOp1.getDataType());

            final CreateOp createOp2 = new CreateOp(10, 10, dataType, Color.BLACK);
            assertEquals(dataType, createOp2.getDataType());

            final CreateOp createOp3 = new CreateOp(10, 10, dataType, 0);
            assertEquals(dataType, createOp3.getDataType());
          }
      }

    public void testGetFiller1 ()
      {
        final CreateOp createOp = new CreateOp(10, 10, EditableImage.DataType.BYTE);
        final double[] filler = createOp.getFiller();
        assertEquals(1, filler.length);
        assertEquals(0.0, filler[0]);
      }

    public void testGetFiller2 ()
      {
        final Color color = new Color(63, 127, 255);
        checkColor(new CreateOp(10, 10, EditableImage.DataType.BYTE, color), color, 255);
        checkColor(new CreateOp(10, 10, EditableImage.DataType.SHORT, color), color, Math.pow(2, 15) - 1);
        checkColor(new CreateOp(10, 10, EditableImage.DataType.UNSIGNED_SHORT, color), color, Math.pow(2, 16) - 1);
        checkColor(new CreateOp(10, 10, EditableImage.DataType.INT, color), color, Math.pow(2, 31) - 1);
        checkColor(new CreateOp(10, 10, EditableImage.DataType.FLOAT, color), color, 1.0);
        checkColor(new CreateOp(10, 10, EditableImage.DataType.DOUBLE, color), color, 1.0);
      }

    public void testGetFiller3 ()
      {
        final CreateOp createOp = new CreateOp(10, 10, EditableImage.DataType.BYTE, 1, 2, 3, 4, 5, 6, 7);
        final double[] filler = createOp.getFiller();
        assertEquals(7, filler.length);
        assertEquals(1.0, filler[0]);
        assertEquals(2.0, filler[1]);
        assertEquals(3.0, filler[2]);
        assertEquals(4.0, filler[3]);
        assertEquals(5.0, filler[4]);
        assertEquals(6.0, filler[5]);
        assertEquals(7.0, filler[6]);
      }

    private void checkColor (final CreateOp createOp, final Color color, final double max)
      {
        final double scale = max / 255.0;
        assertEquals(3, createOp.getFiller().length);
        assertEquals(scale * color.getRed(), createOp.getFiller()[0]);
        assertEquals(scale * color.getGreen(), createOp.getFiller()[1]);
        assertEquals(scale * color.getBlue(), createOp.getFiller()[2]);
      }
  }
