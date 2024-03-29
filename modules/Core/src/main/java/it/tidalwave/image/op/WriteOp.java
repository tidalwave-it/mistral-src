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
package it.tidalwave.image.op;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Path;
import javax.imageio.ImageWriteParam;
import javax.imageio.metadata.IIOMetadata;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class WriteOp extends Operation
  {
    private final String format;
    private final Object output;
    private final ImageWriteParam imageWriteParam;
    private final IIOMetadata iioMetadata;

    /*******************************************************************************************************************
     *
     * Writes the image to a file.
     *
     * @param  format    the image format
     * @param  fileName  the file name
     *
     ******************************************************************************************************************/
    public WriteOp (final String format, final String fileName)
      {
        this(format, Path.of(fileName));
      }

    /*******************************************************************************************************************
     *
     * Writes the image to a file.
     *
     * @param  format           the image format
     * @param  fileName         the file name
     * @param  imageWriteParam  the write parameters
     *
     ******************************************************************************************************************/
    public WriteOp (final String format, final String fileName, final ImageWriteParam imageWriteParam)
      {
        this(format, Path.of(fileName), imageWriteParam);
      }

    /*******************************************************************************************************************
     *
     * Writes the image to a Path or a OutputStream. In the latter case, note that
     * the OutputStream is not closed.
     *
     * @param  format    the image format
     * @param  output    the output object
     *
     ******************************************************************************************************************/
    public WriteOp (final String format, final Object output)
      {
        this(format, output, null);
      }

    /*******************************************************************************************************************
     *
     * Writes the image to a Path or a OutputStream. In the latter case, note that
     * the OutputStream is not closed.
     *
     * @param  format           the image format
     * @param  output           the output object
     * @param  imageWriteParam  the write parameters
     *
     ******************************************************************************************************************/
    public WriteOp (final String format, final Object output, final ImageWriteParam imageWriteParam)
      {
        this(format, output, imageWriteParam, null);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public WriteOp (final String format,
                    Object output,
                    final ImageWriteParam imageWriteParam,
                    final IIOMetadata iioMetadata)
      {
        if (format == null)
          {
            throw new IllegalArgumentException("null format");
          }

        if (output == null)
          {
            throw new IllegalArgumentException("null output");
          }

        if (!(output instanceof File) && !(output instanceof Path) && !(output instanceof OutputStream))
          {
            throw new IllegalArgumentException("output must be a File, a Path or a OutputStream");
          }

        if (output instanceof Path)
          {
            output = ((Path)output).toFile();
          }

        this.format = format;
        this.output = output;
        this.imageWriteParam = imageWriteParam;
        this.iioMetadata = iioMetadata;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public String getFormat()
      {
        return format;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public Object getOutput()
      {
        return output;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public ImageWriteParam getImageWriteParam()
      {
        return imageWriteParam;
      }

    /*******************************************************************************************************************
     *
     * Please note that this method is unsupported.
     *
     ******************************************************************************************************************/
    public IIOMetadata getIIOMetadata()
      {
        return iioMetadata;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public String toString()
      {
        return "WriteOp(" + format + ", " + ((output instanceof OutputStream) ? output.getClass() : output) + ", " +
               imageWriteParam + ")";
      }
  }
