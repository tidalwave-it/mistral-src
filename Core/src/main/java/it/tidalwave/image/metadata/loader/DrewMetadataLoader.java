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
 * $Id: DrewMetadataLoader.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.metadata.loader;

import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import org.w3c.dom.Node;
import com.drew.metadata.Directory;
import com.drew.metadata.exif.ExifDirectory;
import com.drew.metadata.exif.ExifReader;
import com.drew.metadata.iptc.IptcDirectory;
import com.drew.metadata.iptc.IptcReader;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: DrewMetadataLoader.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class DrewMetadataLoader implements MetadataLoader
  {
    public final static int EXIF = 0xE1;
    public final static int IPTC = 0xED;

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findEXIF (final IIOMetadata metadata)
      {
        final Node node = metadata.getAsTree(metadata.getNativeMetadataFormatName());
        return getEXIFDirectory(node);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findIPTC (final IIOMetadata metadata)
      {
        final Node node = metadata.getAsTree(metadata.getNativeMetadataFormatName());
        return getIPTCDirectory(node);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findTIFF (final IIOMetadata metadata)   
      {
        return null;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findMakerNote (final IIOMetadata metadata) 
      {
        return null;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findDNG (final IIOMetadata metadata) 
      {
        return null;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    private static Directory getEXIFDirectory (final Node node)
      {
        if (node.getNodeName().equals("unknown"))
          {
            if (Integer.parseInt(node.getAttributes().getNamedItem("MarkerTag").getNodeValue()) == EXIF)
              {
                final byte[] data = (byte[])((IIOMetadataNode)node).getUserObject();
                return new ExifReader(data).extract().getDirectory(ExifDirectory.class);
              }
          }

        Node child = node.getFirstChild();

        while (child != null)
          {
            final Directory directory = getEXIFDirectory(child);

            if (directory != null)
              {
                return directory;
              }

            child = child.getNextSibling();
          }

        return null;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    private static Directory getIPTCDirectory (final Node node)
      {
        if (node.getNodeName().equals("unknown"))
          {
            if (Integer.parseInt(node.getAttributes().getNamedItem("MarkerTag").getNodeValue()) == IPTC)
              {
                final byte[] data = (byte[])((IIOMetadataNode)node).getUserObject();
                return new IptcReader(data).extract().getDirectory(IptcDirectory.class);
              }
          }

        Node child = node.getFirstChild();

        while (child != null)
          {
            final Directory directory = getIPTCDirectory(child);

            if (directory != null)
              {
                return directory;
              }

            child = child.getNextSibling();
          }

        return null;
      }
  }
