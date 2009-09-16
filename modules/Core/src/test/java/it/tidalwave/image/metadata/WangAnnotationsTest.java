/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.tidalwave.image.metadata;

import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.ReadOp;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

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
        assertNotNull(image);
        final TIFF tiff = image.getMetadata(TIFF.class);
        assertNotNull(tiff);
//        final EXIF exif = image.getMetadata(EXIF.class);
//        assertNotNull(exif);
        System.err.println("TAGS: " + Arrays.toString(tiff.getTagCodes()));
//        assertTrue(tiff.containsTag(32934));
        assertTrue(tiff.isWangAnnotationAvailable());
        final WangAnnotations wangAnnotations = tiff.getWangAnnotations2();
      }
  }