/***********************************************************************************************************************
 *
 * PROJECT NAME
 * PROJECT COPYRIGHT
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
 * WWW: PROJECT URL
 * SCM: PROJECT SCM
 *
 **********************************************************************************************************************/
package org.imajine.image.metadata;

import java.util.HashMap;
import javax.annotation.Nonnull;
import java.util.Map;
import lombok.Getter;

/***********************************************************************************************************************
 *
 * @author  fritz
 * @version $Id$
 *
 **********************************************************************************************************************/
public class XMP extends Directory
  {
    private final static long serialVersionUID = 84768464253462456L;
    
    @Getter 
    private final Map<String, String> xmpProperties = new HashMap<String, String>();

    void _setProperties (final @Nonnull Map<String, String> xmpProperties)
      {
        this.xmpProperties.clear();
        this.xmpProperties.putAll(xmpProperties);
      }
  }
