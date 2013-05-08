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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.image.jai;

import javax.annotation.Nonnull;
import javax.media.jai.PlanarImage;
import java.awt.image.Raster;
import org.openide.util.Lookup;
import org.imajine.image.EditableImage;
import org.imajine.image.op.testsupport.CreateOpTestSupport;
import org.junit.Before;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
public class CreateJAIOpTest extends CreateOpTestSupport
  {
    @Before
    public void installJAIPlugin()
      {
        Lookup.getDefault().lookup(ImplementationFactoryJAI.class);
      }

    @Override @Nonnull
    protected Raster getRaster (final @Nonnull EditableImage image)
      {
        return image.getInnerProperty(PlanarImage.class).getData();
      }
  }
