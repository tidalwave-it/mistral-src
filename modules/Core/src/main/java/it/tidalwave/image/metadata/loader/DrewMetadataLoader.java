/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2012 by Tidalwave s.a.s.
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
package it.tidalwave.image.metadata.loader;

import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import org.w3c.dom.Node;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifReader;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.iptc.IptcDirectory;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
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
    @Override
    public Object findEXIF (final IIOMetadata metadata)
      {
        final Node node = metadata.getAsTree(metadata.getNativeMetadataFormatName());
        return getEXIFDirectory(node);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findIPTC (final IIOMetadata metadata)
      {
        final Node node = metadata.getAsTree(metadata.getNativeMetadataFormatName());
        return getIPTCDirectory(node);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findXMP (final IIOMetadata metadata)
      {
        return null;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findTIFF (final IIOMetadata metadata)   
      {
        return null;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Object findMakerNote (final IIOMetadata metadata) 
      {
        return null;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
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
                final Metadata metadata = new Metadata();
                new ExifReader().extract(data, metadata);
                return metadata.getDirectory(ExifSubIFDDirectory.class);
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
                final Metadata metadata = new Metadata();
                new ExifReader().extract(data, metadata);
                return metadata.getDirectory(IptcDirectory.class);
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
