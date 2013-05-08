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
package org.imajine.image.render;

import java.awt.image.ByteLookupTable;
import java.awt.image.ShortLookupTable;


/*******************************************************************************
 *
 * This class holds preview settings for displaying an image.
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class PreviewSettings
  {
    private byte[] redCurve8bit = new byte[256];
    private byte[] greenCurve8bit = new byte[256];
    private byte[] blueCurve8bit = new byte[256];
    private byte[] alphaCurve8bit = new byte[256];
    private ShortLookupTable lookupTable16bit;
    private ByteLookupTable lookupTable8bit;

    /*******************************************************************************
     *
     * TODO: it would be event better to pass abstract curves and leave to this
     * class the responsibility of sampling them. Check out performances.
     *
     ******************************************************************************/
    public void setLookupTable (short[] redCurve, short[] greenCurve, short[] blueCurve, short[] alphaCurve)
      {
        lookupTable16bit = new ShortLookupTable(0, new short[][] { redCurve, greenCurve, blueCurve, alphaCurve });

        // FIXME: use a better interpolation
        for (int i = 0; i < redCurve8bit.length; i++)
          {
            int j = (i << 8) | (i & 0xff);
            redCurve8bit[i] = (byte)(redCurve[j] >>> 8);
            greenCurve8bit[i] = (byte)(greenCurve[j] >>> 8);
            blueCurve8bit[i] = (byte)(blueCurve[j] >>> 8);
            alphaCurve8bit[i] = (byte)(alphaCurve[j] >>> 8);
          }

        lookupTable8bit = new ByteLookupTable(0,
                new byte[][] { redCurve8bit, greenCurve8bit, blueCurve8bit, alphaCurve8bit });
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public ShortLookupTable getLookupTable16bit ()
      {
        return lookupTable16bit;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public ByteLookupTable getLookupTable8bit ()
      {
        return lookupTable8bit;
      }
  }
