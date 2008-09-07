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
 * $Id: RotateQuadrantJ2DTest.java 225 2006-11-18 22:51:50Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.java2d;

import java.io.File;
import junit.framework.Test;
import junit.framework.TestSuite;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.WriteOp;
import it.tidalwave.image.op.OptimizeOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: RotateQuadrantJ2DTest.java 225 2006-11-18 22:51:50Z fabriziogiudici $
 *
 ******************************************************************************/
public class WriteJ2DOpTest extends BaseTestSupport 
  {
    private final static String tmp = System.getProperty("java.io.tmpdir");
    
    public static Test suite()
      {
        return new TestSuite(WriteJ2DOpTest.class);
      }

    public WriteJ2DOpTest (final String name)
      {
        super(name);  
      }
    
    public void testWriteJPEG()
      {
        File f = (File)img20030701_0043_jpg.execute(new WriteOp("JPEG", tmp + "/written.jpg")).getOutput();
//        assertChecksum("b49272bff3e945d32ad9b617a17829ae", f);
      }
    
    public void testWriteOptimizedJPEG()
      {
        EditableImage result = img20030701_0043_jpg.execute2(new OptimizeOp(0.5));
        File f = (File)result.execute(new WriteOp("JPEG", tmp + "/written-optimized.jpg")).getOutput();
//        assertChecksum("b49272bff3e945d32ad9b617a17829ae", f);
      }
  }
