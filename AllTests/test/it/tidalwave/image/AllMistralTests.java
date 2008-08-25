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
 * $Id: AllMistralTests.java 939 2008-08-25 19:50:05Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image;

import it.tidalwave.image.jai.AllJAITests;
import it.tidalwave.image.op.AllContributionsTests;
import junit.framework.Test;
import junit.framework.TestSuite;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: AllMistralTests.java 939 2008-08-25 19:50:05Z fabriziogiudici $
 *
 ******************************************************************************/
public class AllMistralTests extends TestSuite 
  {
    public static Test suite()
      {
        final TestSuite suite = new TestSuite();
//        suite.addTest(AllEditableImageTests.suite());
        suite.addTest(AllContributionsTests.suite());
        suite.addTest(AllJAITests.suite());
        return suite;
      }
  }
