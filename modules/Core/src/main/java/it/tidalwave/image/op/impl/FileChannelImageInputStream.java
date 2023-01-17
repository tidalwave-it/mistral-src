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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tidalwave.image.op.impl;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.MappedByteBuffer;
import java.nio.ShortBuffer;
import java.nio.channels.FileChannel;
import javax.imageio.stream.ImageInputStreamImpl;

// ADAPTED from com.sun.media.imageio.stream.FileChannelImageInputStream, this also
// closes the RandomAccessFile and the channel.

/**
 * A class which implements <code>ImageInputStream</code> using a
 * <code>FileChannel</code> as the eventual data source. The channel
 * contents are assumed to be stable during the lifetime of the object.
 *
 * <p>Memory mapping and new I/O view <code>Buffer</code>s are used to
 * read the data. Only methods which provide significant performance improvement with respect to the superclass
 * implementation are overridden. Overridden methods are not commented individually unless some noteworthy aspect of the
 * implementation must be described.</p>
 *
 * <p>The methods of this class are <b>not</b> synchronized.</p>
 *
 * @see javax.imageio.stream.ImageInputStream
 * @see java.nio
 * @see java.nio.channels.FileChannel
 */
public class FileChannelImageInputStream extends ImageInputStreamImpl
  {

    private final RandomAccessFile raf;

    /**
     * The <code>FileChannel</code> data source.
     */
    private FileChannel channel;
    /**
     * A memory mapping of all or part of the channel.
     */
    private MappedByteBuffer mappedBuffer;
    /**
     * The stream position of the mapping.
     */
    private long mappedPos;
    /**
     * The stream position least upper bound of the mapping.
     */
    private long mappedUpperBound;

    /**
     * Constructs a <code>FileChannelImageInputStream</code> from a
     * <code>FileChannel</code>.  The initial position of the stream
     * stream is taken to be the position of the <code>FileChannel</code> parameter when this constructor is invoked.
     * The
     * stream and flushed positions are therefore both initialized to
     * <code>channel.position()</code>.
     *
     * @param channel the source <code>FileChannel</code>.
     * @throws IllegalArgumentException if <code>channel</code> is
     *                                  <code>null</code> or is not open.
     * @throws IOException              if a method invoked on <code>channel</code> throws an <code>IOException</code>.
     */
    public FileChannelImageInputStream (final File file)
            throws IOException
      {
        raf = new RandomAccessFile(file, "r");
        this.channel = raf.getChannel();
        final long channelPosition = channel.position();
        this.streamPos = this.flushedPos = channelPosition;
        final long fullSize = channel.size() - channelPosition;
        final long mappedSize = Math.min(fullSize, Integer.MAX_VALUE);
        this.mappedPos = 0;
        this.mappedUpperBound = mappedPos + mappedSize;
        this.mappedBuffer = channel.map(FileChannel.MapMode.READ_ONLY, channelPosition, mappedSize);
      }

    /**
     * Returns a <code>MappedByteBuffer</code> which memory maps at least from the channel position corresponding to the
     * current stream position to <code>len</code> bytes beyond. A new buffer is created only if necessary.
     *
     * @param len The number of bytes required beyond the current stream position.
     */
    private MappedByteBuffer getMappedBuffer (final int len)
            throws IOException
      {
        // If request is outside mapped region, map a new region.
        if (streamPos < mappedPos || streamPos + len >= mappedUpperBound)
          {

            // Set the map position.
            mappedPos = streamPos;

            // Determine the map size.
            final long mappedSize = Math.min(channel.size() - mappedPos,
                                             Integer.MAX_VALUE);

            // Set the mapped upper bound.
            mappedUpperBound = mappedPos + mappedSize;

            // Map the file.
            mappedBuffer = channel.map(FileChannel.MapMode.READ_ONLY,
                                       mappedPos, mappedSize);

            mappedBuffer.order(super.getByteOrder());

          }

        return mappedBuffer;
      }

    // --- Implementation of superclass abstract methods. ---
    @Override
    public int read()
            throws IOException
      {
        checkClosed();
        bitOffset = 0;

        // Get the mapped buffer.
        final ByteBuffer byteBuffer = getMappedBuffer(1);

        // Check number of bytes left.
        if (byteBuffer.remaining() < 1)
          {
            // Return EOF.
            return -1;
          }

        // Get the byte from the buffer.
        final int value = byteBuffer.get() & 0xff;

        // Increment the stream position.
        streamPos++;

        //System.out.println("value = "+value);

        return value;
      }

    @Override
    public int read (final byte[] b, final int off, int len)
            throws IOException
      {
        if (off < 0 || len < 0 || off + len > b.length)
          {
            // NullPointerException will be thrown before this if b is null.
            throw new IndexOutOfBoundsException(
                    "off < 0 || len < 0 || off + len > b.length");
          }
        else if (len == 0)
          {
            return 0;
          }

        checkClosed();
        bitOffset = 0;

        // Get the mapped buffer.
        final ByteBuffer byteBuffer = getMappedBuffer(len);

        // Get the number of bytes remaining.
        final int numBytesRemaining = byteBuffer.remaining();

        // Check number of bytes left.
        if (numBytesRemaining < 1)
          {
            // Return EOF.
            return -1;
          }
        else if (len > numBytesRemaining)
          {
            // Clamp 'len' to number of bytes in Buffer. Apparently some
            // readers (JPEG) request data beyond the end of the file.
            len = numBytesRemaining;
          }

        // Read the data from the buffer.
        byteBuffer.get(b, off, len);

        // Increment the stream position.
        streamPos += len;

        return len;
      }

    // --- Overriding of superclass methods. ---

    /**
     * Invokes the superclass method and sets the internal reference to the source <code>FileChannel</code> to
     * <code>null</code>. The source <code>FileChannel</code> is not closed.
     *
     * @throws IOException if an error occurs.
     */
    @Override
    public void close()
            throws IOException
      {
        super.close();
        channel.close();
        raf.close();
        channel = null;
      }

    @Override
    public void readFully (final char[] c, final int off, final int len)
            throws IOException
      {
        if (off < 0 || len < 0 || off + len > c.length)
          {
            // NullPointerException will be thrown before this if c is null.
            throw new IndexOutOfBoundsException(
                    "off < 0 || len < 0 || off + len > c.length");
          }
        else if (len == 0)
          {
            return;
          }

        // Determine the requested length in bytes.
        final int byteLen = 2 * len;

        // Get the mapped buffer.
        final ByteBuffer byteBuffer = getMappedBuffer(byteLen);

        // Ensure enough bytes remain.
        if (byteBuffer.remaining() < byteLen)
          {
            throw new EOFException();
          }

        // Get the view Buffer.
        final CharBuffer viewBuffer = byteBuffer.asCharBuffer();

        // Get the chars.
        viewBuffer.get(c, off, len);

        // Update the position.
        seek(streamPos + byteLen);
      }

    @Override
    public void readFully (final short[] s, final int off, final int len)
            throws IOException
      {
        if (off < 0 || len < 0 || off + len > s.length)
          {
            // NullPointerException will be thrown before this if s is null.
            throw new IndexOutOfBoundsException(
                    "off < 0 || len < 0 || off + len > s.length");
          }
        else if (len == 0)
          {
            return;
          }

        // Determine the requested length in bytes.
        final int byteLen = 2 * len;

        // Get the mapped buffer.
        final ByteBuffer byteBuffer = getMappedBuffer(byteLen);

        // Ensure enough bytes remain.
        if (byteBuffer.remaining() < byteLen)
          {
            throw new EOFException();
          }

        // Get the view Buffer.
        final ShortBuffer viewBuffer = byteBuffer.asShortBuffer();

        // Get the shorts.
        viewBuffer.get(s, off, len);

        // Update the position.
        seek(streamPos + byteLen);
      }

    @Override
    public void readFully (final int[] i, final int off, final int len)
            throws IOException
      {
        if (off < 0 || len < 0 || off + len > i.length)
          {
            // NullPointerException will be thrown before this if i is null.
            throw new IndexOutOfBoundsException(
                    "off < 0 || len < 0 || off + len > i.length");
          }
        else if (len == 0)
          {
            return;
          }

        // Determine the requested length in bytes.
        final int byteLen = 4 * len;

        // Get the mapped buffer.
        final ByteBuffer byteBuffer = getMappedBuffer(byteLen);

        // Ensure enough bytes remain.
        if (byteBuffer.remaining() < byteLen)
          {
            throw new EOFException();
          }

        // Get the view Buffer.
        final IntBuffer viewBuffer = byteBuffer.asIntBuffer();

        // Get the ints.
        viewBuffer.get(i, off, len);

        // Update the position.
        seek(streamPos + byteLen);
      }

    @Override
    public void readFully (final long[] l, final int off, final int len)
            throws IOException
      {
        if (off < 0 || len < 0 || off + len > l.length)
          {
            // NullPointerException will be thrown before this if l is null.
            throw new IndexOutOfBoundsException(
                    "off < 0 || len < 0 || off + len > l.length");
          }
        else if (len == 0)
          {
            return;
          }

        // Determine the requested length in bytes.
        final int byteLen = 8 * len;

        // Get the mapped buffer.
        final ByteBuffer byteBuffer = getMappedBuffer(byteLen);

        // Ensure enough bytes remain.
        if (byteBuffer.remaining() < byteLen)
          {
            throw new EOFException();
          }

        // Get the view Buffer.
        final LongBuffer viewBuffer = byteBuffer.asLongBuffer();

        // Get the longs.
        viewBuffer.get(l, off, len);

        // Update the position.
        seek(streamPos + byteLen);
      }

    @Override
    public void readFully (final float[] f, final int off, final int len)
            throws IOException
      {
        if (off < 0 || len < 0 || off + len > f.length)
          {
            // NullPointerException will be thrown before this if f is null.
            throw new IndexOutOfBoundsException(
                    "off < 0 || len < 0 || off + len > f.length");
          }
        else if (len == 0)
          {
            return;
          }

        // Determine the requested length in bytes.
        final int byteLen = 4 * len;

        // Get the mapped buffer.
        final ByteBuffer byteBuffer = getMappedBuffer(byteLen);

        // Ensure enough bytes remain.
        if (byteBuffer.remaining() < byteLen)
          {
            throw new EOFException();
          }

        // Get the view Buffer.
        final FloatBuffer viewBuffer = byteBuffer.asFloatBuffer();

        // Get the floats.
        viewBuffer.get(f, off, len);

        // Update the position.
        seek(streamPos + byteLen);
      }

    @Override
    public void readFully (final double[] d, final int off, final int len)
            throws IOException
      {
        if (off < 0 || len < 0 || off + len > d.length)
          {
            // NullPointerException will be thrown before this if d is null.
            throw new IndexOutOfBoundsException(
                    "off < 0 || len < 0 || off + len > d.length");
          }
        else if (len == 0)
          {
            return;
          }

        // Determine the requested length in bytes.
        final int byteLen = 8 * len;

        // Get the mapped buffer.
        final ByteBuffer byteBuffer = getMappedBuffer(byteLen);

        // Ensure enough bytes remain.
        if (byteBuffer.remaining() < byteLen)
          {
            throw new EOFException();
          }

        // Get the view Buffer.
        final DoubleBuffer viewBuffer = byteBuffer.asDoubleBuffer();

        // Get the doubles.
        viewBuffer.get(d, off, len);

        // Update the position.
        seek(streamPos + byteLen);
      }

    /**
     * Returns the number of bytes currently in the <code>FileChannel</code>. If an <code>IOException</code> is
     * encountered when querying the channel's size, -1L will be returned.
     *
     * @return The number of bytes in the channel -1L to indicate unknown length.
     */
    @Override
    public long length()
      {
        // Initialize to value indicating unknown length.
        long length = -1L;

        // Set length to current size with respect to initial position.
        try
          {
            length = channel.size();
          }
        catch (IOException e)
          {
            // Default to unknown length.
          }

        return length;
      }

    /**
     * Invokes the superclass method and sets the position within the memory mapped buffer.  A new region is mapped if
     * necessary.  The position of the source <code>FileChannel</code> is not changed, i.e.,
     * {@link java.nio.channels.FileChannel#position(long)} is not invoked.
     */
    @Override
    public void seek (final long pos)
            throws IOException
      {
        super.seek(pos);

        if (pos >= mappedPos && pos < mappedUpperBound)
          {
            // Seeking to location within mapped buffer: set buffer position.
            mappedBuffer.position((int)(pos - mappedPos));
          }
        else
          {
            // Seeking to location outside mapped buffer: get a new mapped
            // buffer at current position with maximal size.
            final int len = (int)Math.min(channel.size() - pos,
                                          Integer.MAX_VALUE);
            mappedBuffer = getMappedBuffer(len);
          }
      }

    @Override
    public void setByteOrder (final ByteOrder networkByteOrder)
      {
        super.setByteOrder(networkByteOrder);
        mappedBuffer.order(networkByteOrder);
      }

    @Override
    public String toString()
      {
        return String.format("FileChannelImageInputStream@%x", System.identityHashCode(this));
      }
  }
