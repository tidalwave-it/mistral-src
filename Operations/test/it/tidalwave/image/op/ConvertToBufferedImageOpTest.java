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
 * $Id: ConvertToBufferedImageOpTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import it.tidalwave.image.EditableImage;
import java.awt.image.BufferedImage;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ConvertToBufferedImageOpTest.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class ConvertToBufferedImageOpTest extends TestCase 
  {
    public ConvertToBufferedImageOpTest (String testName) 
      {
        super(testName);
      }

    public static Test suite() 
      {
        return new TestSuite(ConvertToBufferedImageOpTest.class);
      }

    /**
     * Test of getBufferedImage method, of class it.tidalwave.image.op.ConvertToBufferedImageOp.
     */
    public void testGetBufferedImage() 
      {
        System.out.println("getBufferedImage");
        ConvertToBufferedImageOp op = new ConvertToBufferedImageOp();
        
//        EditableImage image;
//        BufferedImage bufferedImage = image.execute(new ConvertToBufferedImageOp()).getBufferedImage();
      }

    /**
     * Test of toString method, of class it.tidalwave.image.op.ConvertToBufferedImageOp.
     */
    public void testToString() 
      {
        System.out.println("toString");
        ConvertToBufferedImageOp instance = new ConvertToBufferedImageOp();
        instance.toString();
      }  
  }
