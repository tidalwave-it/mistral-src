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
package it.tidalwave.image.metadata;

import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import javax.imageio.ImageIO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.DrawOp;

/***********************************************************************************************************************
 *
 * http://support.global360.com/content/I4W/documentation/annospec.htm
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class WangAnnotations
  {
    public static class Attributes
      {
        // http://msdn2.microsoft.com/en-us/library/ms533931(VS.85).aspx
        public static class LogFont
          {
            private final int height;
            private final int width;
            private final int escapement;
            private final int orientation;
            private final int weight;
            private final byte italic;
            private final byte underline;
            private final byte strikeout;
            private final byte charset;
            private final byte outprec;
            private final byte clipprec;
            private final byte quality;
            private final byte pitch;
            private final String faceName;

            protected LogFont (final byte[] buffer)
                    throws IOException
              {
                final var iis = ImageIO.createImageInputStream(new ByteArrayInputStream(buffer));
                iis.setByteOrder(ByteOrder.LITTLE_ENDIAN);
                height = iis.readInt();
                width = iis.readInt();
                escapement = iis.readInt();
                orientation = iis.readInt();
                weight = iis.readInt();
                italic = iis.readByte();
                underline = iis.readByte();
                strikeout = iis.readByte();
                charset = iis.readByte();
                outprec = iis.readByte();
                clipprec = iis.readByte();
                quality = iis.readByte();
                pitch = iis.readByte();
                final var bytes = new byte[16]; // FIXME
                iis.read(bytes);
                faceName = new String(bytes);
                iis.close();
              }

            public Font createFont()
              {
                return new Font(faceName, (weight < 700) ? Font.PLAIN : Font.BOLD, 40 * height / 15); // FIXME
              }

            @Override
            public String toString()
              {
                return String.format("LogFont[height: %d, weight: %d, face: %s]", height, weight, faceName);
              }
          }

        private final int type;
        private final int x1;
        private final int y1;
        private final int x2;
        private final int y2;
        private final byte highlight;
        private final byte transparent;
        private final int lineSize;
        private final LogFont logFont;
        private final int timeStamp;
        private final byte visible;

        protected Attributes (final byte[] buffer)
                throws IOException
          {
            final var iis = ImageIO.createImageInputStream(new ByteArrayInputStream(buffer));
            iis.setByteOrder(ByteOrder.LITTLE_ENDIAN);
            type = iis.readInt();
            x1 = iis.readInt();
            y1 = iis.readInt();
            x2 = iis.readInt();
            y2 = iis.readInt();

            iis.skipBytes(3); // color1
            iis.skipBytes(3); // color2
            highlight = iis.readByte();
            transparent = iis.readByte();
            lineSize = iis.readInt();

            iis.readLong(); // reserved 1
            iis.readLong(); // reserved 2
            final var logFontBuffer = new byte[64];
            iis.read(logFontBuffer);
            logFont = new LogFont(logFontBuffer);
            timeStamp = iis.readInt();
            visible = iis.readByte();
            iis.skipBytes(8); // reserved 4
            iis.close();
          }

        public int getType()
          {
            return type;
          }

        public void drawString (final Graphics2D g, final EditableImage image, final String text)
          {
            g.setColor(Color.BLACK);
//            g.setStroke(new BasicStroke(3));
//            drawRectangle(g, image);
            g.setFont(logFont.createFont());
            g.drawString(text, (float)x1, (float)y1 + g.getFontMetrics().getAscent());
//            System.err.println(String.format("Rendered %s at %d, %d", text, xx, yy));
          }

        public void drawRectangle (final Graphics2D g, final EditableImage image)
          {
            final var ww = Math.abs(x2 - x1);
            final var hh = Math.abs(y2 - y1);
//            g.setColor(Color.WHITE);
//            g.fillRect(xx2, yy2, ww, hh);
            g.setStroke(new BasicStroke(3));
            g.setColor(Color.BLACK);
            g.drawRect(x1, y1, ww, hh);
            System.err.println(String.format(">>>> Rendered rectangle: %d,%d,%d,%d - %dx%d", x1, y1, x2, y2, ww, hh));
//            System.err.println(String.format("Rendered %s at %f, %f", text, xx, yy));
          }

        @Override
        public String toString()
          {
            return String.format("Attributes [%d %d,%d,%d,%d visible: %d font: %s]",
                                 type,
                                 x1,
                                 y1,
                                 x2,
                                 y2,
                                 visible,
                                 logFont);
          }
      }

    public abstract static class Internal
      {
        protected final Attributes attributes;

        public Internal (final Attributes attributes)
          {
            this.attributes = attributes;
          }

        public abstract void render (EditableImage image);
      }

    public static class OiAnText extends Internal
      {
        private final double orientation;
        private final double resolution;
        private final String text;

        protected OiAnText (final Attributes attributes, final byte[] buffer)
                throws IOException
          {
            super(attributes);
            final var iis = ImageIO.createImageInputStream(new ByteArrayInputStream(buffer));
            iis.setByteOrder(ByteOrder.LITTLE_ENDIAN);
            orientation = iis.readInt() / 10.0;
            final var d1000 = iis.readInt();
            resolution = 72000.0 / iis.readInt();
            final var len = iis.readInt();
            final var bytes = new byte[len];
            iis.read(bytes);
            final var stringLength = (bytes[len - 1]) == 0 ? len - 1 : len;
            text = new String(bytes, 0, stringLength, "CP1252");
            iis.close();
          }

        @Override
        public void render (final EditableImage image)
          {
            image.execute(new DrawOp((g, image1) -> attributes.drawString(g, image1, text)));
          }

        @Override
        public String toString()
          {
            return String.format("OiAnText[angle: %f resolution: %f text: %s, %s]",
                                 orientation,
                                 resolution,
                                 text,
                                 attributes);
          }
      }

    public static class OiHilite extends Internal
      {
        protected OiHilite (final Attributes attributes)
          {
            super(attributes);
            System.err.println(String.format("OiHilite"));
          }

        @Override
        public void render (final EditableImage image)
          {
            image.execute(new DrawOp(attributes::drawRectangle));
          }

        @Override
        public String toString()
          {
            return String.format("OiHilite[%s]", attributes);
          }
      }

    private final List<Internal> internals = new ArrayList<>();

    public WangAnnotations (final byte[] buffer)
            throws IOException
      {
        final var bais = new ByteArrayInputStream(buffer);
        final var iis = ImageIO.createImageInputStream(bais);
        iis.setByteOrder(ByteOrder.LITTLE_ENDIAN);

        final var header = iis.readInt();
        final var intSize = iis.readInt();
        assert intSize == 1;
        Attributes attributes = null;

        while (iis.getStreamPosition() < buffer.length)
          {
            final var dataType = iis.readInt();
            final var dataSize = iis.readInt();
//            System.err.println(String.format("dataType: %d size: %d", dataType, dataSize));

            if ((dataType == 2) || (dataType == 6))
              {
                System.err.println((dataType == 2) ? "DEFAULT NAMED BLOCK" : "PART OF PRECEDING");
                final var bytes = new byte[8];
                iis.read(bytes);
                final var name = new String(bytes);
//                System.err.println(String.format("named block: %s", name));
                final var size = iis.readInt();
                final var block = new byte[size];
                iis.read(block);

                if (name.startsWith("OiAnText"))
                  {
                    internals.add(new OiAnText(attributes, block));
                  }
                if (name.startsWith("OiHilite"))
                  {
                    internals.add(new OiHilite(attributes));
                  }
                else
                  {
                    System.err.println(String.format("unmanaged named block: %s", name));
                  }
              }

            else if (dataType == 5)
              {
                final var block = new byte[dataSize];
                iis.read(block);
                attributes = new Attributes(block);
              }
          }

        System.err.println(internals);
      }

    public void render (final EditableImage image)
      {
        for (final var internal : internals)
          {
            internal.render(image);
          }
      }
  }
