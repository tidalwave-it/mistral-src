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
 * $Id$
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class CropOpTest  
  {
    @Test
    public void testGetX()  
      {
        System.out.println("getX");
        CropOp op = new CropOp(1, 2, 3, 4);
        assertEquals(1, op.getX());
      }

    @Test
    public void testGetY()   
      {
        System.out.println("getY");
        CropOp op = new CropOp(1, 2, 3, 4);
        assertEquals(2, op.getY());
      }

    @Test
    public void testGetW() 
      {
        System.out.println("getW");
        CropOp op = new CropOp(1, 2, 3, 4);
        assertEquals(3, op.getW());
      }

    @Test
    public void testGetH() 
      {
        System.out.println("getH");
        CropOp op = new CropOp(1, 2, 3, 4);
        assertEquals(4, op.getH());
      }

    @Test
    public void testToString() 
      {
        System.out.println("toString");
        CropOp op = new CropOp(1, 2, 3, 4);
        op.toString();
      }  
  }
