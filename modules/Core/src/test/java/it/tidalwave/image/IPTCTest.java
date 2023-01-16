/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2023 by Tidalwave s.a.s.
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.tidalwave.image;

import it.tidalwave.image.EditableImage;
import org.testng.annotations.Test;
import it.tidalwave.image.metadata.IPTC;
import it.tidalwave.image.op.ReadOp;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author fritz
 */
public class IPTCTest
  {
    @Test
    public void testEmbeddedIPTC()
      throws IOException
      {
        EditableImage image = EditableImage.create(new ReadOp(new File("/Users/fritz/Desktop/TEST/BaragliEtruscan181.jpg")));
        IPTC iptc = image.getMetadata(IPTC.class);
        System.err.println(iptc);
      }
  }
