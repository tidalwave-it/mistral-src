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
package org.imajine.image.java2d;

import java.util.Iterator;
import java.util.logging.Logger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.imageio.IIOImage;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import org.imajine.image.EditableImage;
import org.imajine.image.op.OperationImplementation;
import org.imajine.image.op.WriteOp;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class WriteJ2DOp extends OperationImplementation<WriteOp, BufferedImage>
  {
    private static final String CLASS = WriteJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    @Override
    protected BufferedImage execute (final WriteOp operation, final EditableImage image, final BufferedImage bufferedImage)
      {
        final String format = operation.getFormat();
        final Object output = operation.getOutput();
        final Object outputForLog = (output instanceof OutputStream) ? output.getClass() : output;
        final ImageWriteParam imageWriteParam = operation.getImageWriteParam();
        logger.info("Write2DOp(" + format + ", " + outputForLog + ", " + imageWriteParam + ")");

        ImageOutputStream stream = null;
        boolean shouldClose = true;

        try
          {
            if (output instanceof OutputStream)
              {
                stream = ImageIO.createImageOutputStream((OutputStream)output);
                shouldClose = false;
              }

            else if (output instanceof File)
              {
                stream = ImageIO.createImageOutputStream(new BufferedOutputStream(new FileOutputStream((File)output)));
                shouldClose = true;
              }
            
            else if (output instanceof ImageOutputStream)
              {
                stream = (ImageOutputStream)output;
              }

            final Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(format);
            ImageWriter selectedWriter = null;
            logger.fine("Available writers for format: " + format);

            while (writers.hasNext())
              {
                final ImageWriter writer = writers.next();
                logger.fine(">>>> writer: " + writer);

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
                    logger.throwing(CLASS, "execute()", e);
                  }
              }
          }
      }
  }
