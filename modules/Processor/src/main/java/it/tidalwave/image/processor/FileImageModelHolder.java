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
package it.tidalwave.image.processor;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import it.tidalwave.image.ImageModel;
import it.tidalwave.image.ImageModelHolder;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
/* package */ class FileImageModelHolder extends ImageModelHolder
  {
    private Serializable id;

    private File file;

    private transient ImageModel imageModel;

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public FileImageModelHolder()
      {
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public synchronized ImageModel get()
      {
        if (imageModel == null)
          {
            try
              {
                final ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
                imageModel = (ImageModel)ois.readObject();
                ois.close();
              }
            catch (Exception e)
              {
                throw new RuntimeException(e);
              }
          }

        return imageModel;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public void set (final ImageModel imageModel)
      {
        this.imageModel = imageModel;
        this.id = imageModel.getId();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void writeExternal (final ObjectOutput out)
            throws IOException
      {
        if (file == null)
          {
            file = new File("HOLDER-" + id);
            // FIXME: be sure to create the file in a place where it will not be added in
            // the job result .zip. But I don't know if /tmp is shared among nodes in the grid.
            final ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            oos.writeObject(imageModel);
            oos.close();
          }

        out.writeObject(id);
        out.writeObject(file);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void readExternal (final ObjectInput in)
            throws IOException, ClassNotFoundException
      {
        id = (Serializable)in.readObject();
        file = (File)in.readObject();
      }
  }
