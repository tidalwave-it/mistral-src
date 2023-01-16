/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2023 by Tidalwave s.a.s.
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
package it.tidalwave.image;

import java.io.Serializable;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class DefaultImageModelCache extends ImageModelCache
  {
    @Override
    public void store (final ImageModel imageModel)
      {
        // does nothing 
      }

    @Override
    public void update (final ImageModel imageModel)
      {
        // does nothing 
      }

    @Override
    public void remove (final Serializable ic, final boolean remote)
      {
        // does nothing 
      }

    @Override
    public ImageModel retrieve (final Serializable id, final boolean remote)
      {
        throw new RuntimeException("Shouldn't get there");
      }

    @Override
    public boolean contains (final Serializable id) 
      {
        throw new RuntimeException("Shouldn't get there");
      }
  }
