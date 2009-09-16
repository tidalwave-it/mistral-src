/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.tidalwave.image;

import it.tidalwave.image.metadata.IPTC;
import it.tidalwave.image.op.ReadOp;
import java.io.File;
import java.io.IOException;
import org.junit.Test;

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
