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

package it.tidalwave.image.metadata;

import it.tidalwave.image.metadata.TIFF;
import it.tidalwave.image.metadata.WangAnnotations;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.ReadOp;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author fritz
 */
public class WangAnnotationsTest extends BaseTestSupport
  {
    @Test
    public void testLoadWangAnnotations()
      throws IOException
      {
        final String fax = "/Users/fritz/Business/Tidalwave/Projects/Mistral/Nextre/Fax_Image_1.tif";
        final EditableImage image = EditableImage.create(new ReadOp(new File(fax)));
        AssertJUnit.assertNotNull(image);
        final TIFF tiff = image.getMetadata(TIFF.class);
        AssertJUnit.assertNotNull(tiff);
//        final EXIF exif = image.getMetadata(EXIF.class);
//        assertNotNull(exif);
        System.err.println("TAGS: " + Arrays.toString(tiff.getTagCodes()));
//        assertTrue(tiff.containsTag(32934));
        AssertJUnit.assertTrue(tiff.isWangAnnotationAvailable());
        final WangAnnotations wangAnnotations = tiff.getWangAnnotations2();
      }
  }