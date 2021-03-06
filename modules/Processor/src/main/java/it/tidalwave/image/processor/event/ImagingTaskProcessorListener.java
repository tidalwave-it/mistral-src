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
package it.tidalwave.image.processor.event;

import it.tidalwave.image.processor.ImagingTask;

/*******************************************************************************
 * 
 * This class allows to implement multi-phase policies with the 
 * <code>ImagingTaskProcessor</code>.
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public interface ImagingTaskProcessorListener 
  {
    public void notifyTaskPosted (ImagingTaskProcessorEvent event);
    
    public void notifyTaskStarted (ImagingTaskProcessorEvent event);
    
    /***************************************************************************
     *
     * Receives notification that a task has been completed.
     * It is guaranteed that this method is called in thread-safe mode - that is
     * it won't be called again before it completes, and the state of the 
     * ImagingTaskProcessor won't change until it completes. 
     * 
     * This method should complete quickly - should be only used for creating
     * next-phase tasks.
     * 
     * @param  task  the completed task
     *
     **************************************************************************/
    public void notifyTaskCompleted (ImagingTaskProcessorEvent event);
    
    public void notifyTaskPopped (ImagingTaskProcessorEvent event);
  }
