/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2006 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
 *                        and Emmanuele Sordini (Emmanuele@Sordini.com)
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
 * $Id: ConvolvedOpTest.java 474 2007-02-02 19:27:36Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import it.tidalwave.image.op.ConvolveOp;
import java.awt.image.Kernel;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ConvolvedOpTest.java 474 2007-02-02 19:27:36Z fabriziogiudici $
 *
 ******************************************************************************/
public class ConvolvedOpTest extends TestCase 
  {
    public ConvolvedOpTest (String testName) 
      {
        super(testName);
      }

    public static Test suite() 
      {
        return new TestSuite(ConvolvedOpTest.class);
      }

    /**
     * Test of getKernel method, of class it.tidalwave.image.op.CreateConvolvedImageOp.
     */
    public void testGetKernel() 
      {
        System.out.println("getKernel");
        
        Kernel kernel = new Kernel(3, 3, new float[]{1,2,3,4,5,6,7,8,9});
        ConvolveOp op = new ConvolveOp(kernel);
        assertEquals(kernel, op.getKernel());
      }

    /**
     * Test of toString method, of class it.tidalwave.image.op.CreateConvolvedImageOp.
     */
    public void testToString() 
      {
        System.out.println("toString");
        
        Kernel kernel = new Kernel(3, 3, new float[]{1,2,3,4,5,6,7,8,9});
        ConvolveOp op = new ConvolveOp(kernel);
        op.toString();
      }    
  }
