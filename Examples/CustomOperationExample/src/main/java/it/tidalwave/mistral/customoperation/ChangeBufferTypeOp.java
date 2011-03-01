/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2011 by Tidalwave s.a.s.
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
 * SCM: https://kenai.com/hg/mistral~src
 *
 **********************************************************************************************************************/
package it.tidalwave.mistral.customoperation;

import it.tidalwave.image.op.Operation;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ChangeBufferTypeOp extends Operation
  {
    private final int bufferType;
    
    public ChangeBufferTypeOp (final int bufferType)
      {
        if ((bufferType <= 0) || (bufferType > 13))
          {
            throw new IllegalArgumentException("bufferType: " + bufferType);
          }
        
        this.bufferType = bufferType;
      }
    
    public int getBufferType()
      {
        return bufferType;  
      }
  }