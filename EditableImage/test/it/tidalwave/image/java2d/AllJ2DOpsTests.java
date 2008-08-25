/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2007 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
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
 * $Id: AllJ2DOpsTests.java 764 2007-07-22 20:47:54Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.java2d;

import junit.framework.Test;
import junit.framework.TestSuite;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: AllJ2DOpsTests.java 764 2007-07-22 20:47:54Z fabriziogiudici $
 *
 ******************************************************************************/
public class AllJ2DOpsTests extends TestSuite 
  {
    public static Test suite()
      {
        TestSuite suite = new TestSuite();
        suite.addTest(CaptureJ2DOpTest.suite());
        suite.addTest(CreateJ2DOpTest.suite());
        suite.addTest(RotateJ2DOpTest.suite());
        suite.addTest(RotateQuadrantOpJ2DTest.suite());
        suite.addTest(ScaleJ2DOpTest.suite());
        suite.addTest(WriteJ2DOpTest.suite());
        return suite;
      }
  }
