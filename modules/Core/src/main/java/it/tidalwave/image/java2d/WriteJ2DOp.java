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
package it.tidalwave.image.java2d;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.WriteOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class WriteJ2DOp extends OperationImplementation<WriteOp, BufferedImage>
  {
    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    protected BufferedImage execute (final WriteOp operation,
                                     final EditableImage image,
                                     final BufferedImage bufferedImage)
      {
        final var format = operation.getFormat();
        final var output = operation.getOutput();
        final var outputForLog = (output instanceof OutputStream) ? output.getClass() : output;
        final var imageWriteParam = operation.getImageWriteParam();
        log.info("Write2DOp(" + format + ", " + outputForLog + ", " + imageWriteParam + ")");

        ImageOutputStream stream = null;
        var shouldClose = true;

        try
          {
            if (output instanceof OutputStream)
              {
                stream = ImageIO.createImageOutputStream(output);
                shouldClose = false;
              }

            else if (output instanceof File)
              {
                stream =
                        ImageIO.createImageOutputStream(new BufferedOutputStream(Files.newOutputStream(((File)output).toPath())));
                shouldClose = true;
              }

            else if (output instanceof ImageOutputStream)
              {
                stream = (ImageOutputStream)output;
              }

            final var writers = ImageIO.getImageWritersByFormatName(format);
            ImageWriter selectedWriter = null;
            log.debug("Available writers for format: " + format);

            while (writers.hasNext())
              {
                final var writer = writers.next();
                log.debug(">>>> writer: " + writer);

                if (selectedWriter == null) // keep the first one, keep on logging the others
                  {
                    selectedWriter = writer;
                  }
              }

            if (selectedWriter == null)
              {
                throw new IOException("No writers for format: " + format);
              }

            selectedWriter.setOutput(stream);
            selectedWriter.write(null, new IIOImage(bufferedImage, null, null), imageWriteParam);
            stream.flush();
            selectedWriter.dispose();

            return bufferedImage;
          }

        catch (IOException e)
          {
            throw new RuntimeException(e);
          }

        finally
          {
            if ((stream != null) && shouldClose)
              {
                try
                  {
                    stream.close();
                  }
                catch (IOException e)
                  {
                    log.warn("execute()", e);
                  }
              }
          }
      }
  }
