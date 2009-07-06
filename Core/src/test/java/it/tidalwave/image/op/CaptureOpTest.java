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
 * $Id: CaptureOpTest.java 1028 2009-07-06 16:46:00Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.op;

import javax.swing.JLabel;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: CaptureOpTest.java 1028 2009-07-06 16:46:00Z fabriziogiudici $
 *
 ******************************************************************************/
public class CaptureOpTest 
  {
    @Test
    public void testGetComponent() 
      {
        final JLabel label = new JLabel("text");
        final CaptureOp captureOp = new CaptureOp(label);
        assertEquals(label, captureOp.getComponent());
      } 
  }
