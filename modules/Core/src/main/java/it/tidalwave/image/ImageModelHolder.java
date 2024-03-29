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
package it.tidalwave.image;

import java.io.Serializable;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public abstract class ImageModelHolder implements Serializable
  {
    private static Class<? extends ImageModelHolder> defaultClass = SerializableImageModelHolder.class;

    public abstract void set (ImageModel imageModel);

    public abstract ImageModel get();

    public static void setDefault (final Class<? extends ImageModelHolder> defaultClass)
      {
        ImageModelHolder.defaultClass = defaultClass;
      }

    public void setNickName (final String nickName)
      {
        get().setNickName(nickName);
      }

    public String getNickName()
      {
        return get().getNickName();
      }

    public static ImageModelHolder wrap (final ImageModel imageModel)
      {
        try
          {
//            System.err.println("Wrapping ImageModel into a " + defaultClass.getName());
            final var holder = defaultClass.newInstance();
            holder.set(imageModel);

            return holder;
          }
        catch (Exception e)
          {
            throw new RuntimeException(e);
          }
      }

    @Override
    public String toString()
      {

        final var buffer = new StringBuilder(getClass().getName() + "[");
        final var model = get();
        buffer.append((model != null) ? model.getId() : "null");

        if (model != null)
          {
            final var nickName = getNickName();

            if (nickName != null)
              {
                buffer.append(", " + nickName);
              }
          }

        buffer.append("]");

        return buffer.toString();
      }
  }
