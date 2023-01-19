/*
 * *********************************************************************************************************************
 *
 * Mistral: open source imaging engine
 * http://tidalwave.it/projects/mistral
 *
 * Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
 *
 * *********************************************************************************************************************
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
 * *********************************************************************************************************************
 *
 * git clone https://bitbucket.org/tidalwave/mistral-src
 * git clone https://github.com/tidalwave-it/mistral-src
 *
 * *********************************************************************************************************************
 */
package it.tidalwave.image.metadata.loader;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import com.drew.lang.ByteArrayReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifReader;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.iptc.IptcDirectory;
import org.w3c.dom.Node;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class DrewMetadataLoader implements MetadataLoader
  {
    public static final int EXIF = 0xE1;
    public static final int IPTC = 0xED;

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public Optional<DirectoryLoader> getExifLoader (@Nonnull final IIOMetadata iioMetadata)
      {
        final var node = iioMetadata.getAsTree(iioMetadata.getNativeMetadataFormatName());
        return Optional.of(new DirectoryDrewLoader(new ArrayList<>(getEXIFDirectories(node)), 0));
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public Optional<DirectoryLoader> getIptcLoader (@Nonnull final IIOMetadata iioMetadata)
      {
        final var node = iioMetadata.getAsTree(iioMetadata.getNativeMetadataFormatName());
        return Optional.of(new DirectoryDrewLoader(new ArrayList<>(getIPTCDirectories(node)), 0));
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static Collection<ExifSubIFDDirectory> getEXIFDirectories (final Node node)
      {
        if (node.getNodeName().equals("unknown"))
          {
            if (Integer.parseInt(node.getAttributes().getNamedItem("MarkerTag").getNodeValue()) == EXIF)
              {
                final var data = (byte[])((IIOMetadataNode)node).getUserObject();
                final var metadata = new Metadata();
                new ExifReader().extract(new ByteArrayReader(data), metadata);
                return metadata.getDirectoriesOfType(ExifSubIFDDirectory.class);
              }
          }

        var child = node.getFirstChild();

        while (child != null)
          {
            final var directory = getEXIFDirectories(child);

            if (directory != null)
              {
                return directory;
              }

            child = child.getNextSibling();
          }

        return null;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    private static Collection<IptcDirectory> getIPTCDirectories (final Node node)
      {
        if (node.getNodeName().equals("unknown"))
          {
            if (Integer.parseInt(node.getAttributes().getNamedItem("MarkerTag").getNodeValue()) == IPTC)
              {
                final var data = (byte[])((IIOMetadataNode)node).getUserObject();
                final var metadata = new Metadata();
                new ExifReader().extract(new ByteArrayReader(data), metadata);
                return metadata.getDirectoriesOfType(IptcDirectory.class);
              }
          }

        var child = node.getFirstChild();

        while (child != null)
          {
            final var directory = getIPTCDirectories(child);

            if (directory != null)
              {
                return directory;
              }

            child = child.getNextSibling();
          }

        return null;
      }
  }
