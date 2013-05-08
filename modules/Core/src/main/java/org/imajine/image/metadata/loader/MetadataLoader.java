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
package org.imajine.image.metadata.loader;

import javax.imageio.metadata.IIOMetadata;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public interface MetadataLoader
  {
    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findTIFF (IIOMetadata iioMetadata);
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findEXIF (IIOMetadata iioMetadata);
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findIPTC (IIOMetadata iioMetadata);
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findXMP (IIOMetadata iioMetadata);
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findMakerNote (IIOMetadata iioMetadata);
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public Object findDNG (IIOMetadata iioMetadata);
  }
