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
package it.tidalwave.image.processor;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import it.tidalwave.image.processor.event.ImagingTaskProcessorEvent;
import it.tidalwave.image.processor.event.ImagingTaskProcessorListener;
import lombok.extern.slf4j.Slf4j;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
@Slf4j
/* package */ class ImagingTaskProcessorEventManager 
  {
    private ImagingTaskProcessor processor;
 
    private List<ImagingTaskProcessorListener> listeners = new ArrayList<ImagingTaskProcessorListener>();
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public ImagingTaskProcessorEventManager (ImagingTaskProcessor processor)
      {
        this.processor = processor;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void addListener (ImagingTaskProcessorListener listener)
      {
        listeners.add(listener);  
      } 
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void removeListener (ImagingTaskProcessorListener listener)
      {
        listeners.remove(listener);  
      } 
    
    /***************************************************************************
     *
     * Guarantees that the controller is invoked in thread-safe mode and that
     * the counters are not changed while the controller is running.
     *
     **************************************************************************/
    public void fireNotifyTaskPosted (ImagingTask task) 
      {
        synchronized (processor.lock)
          {
            ImagingTaskProcessorEvent event = new ImagingTaskProcessorEvent(processor, Thread.currentThread().getName(), task);

            for (final ImagingTaskProcessorListener listener : new ArrayList<ImagingTaskProcessorListener>(listeners))
              {
                try
                  {
                    listener.notifyTaskPosted(event);
                  }
                catch (Throwable t)
                  {
                    log.warn("Exception in fireNotifyTaskPosted(): " + t);
                    log.warn("fireNotifyTaskPosted()", t);
                  }
              }
          }
      }
    
    /***************************************************************************
     *
     * Guarantees that the controller is invoked in thread-safe mode and that
     * the counters are not changed while the controller is running.
     *
     **************************************************************************/
    public void fireNotifyTaskStarted (ImagingTask task, Serializable workerId) 
      {
        synchronized (processor.lock)
          {
            ImagingTaskProcessorEvent event = new ImagingTaskProcessorEvent(processor, workerId, task);

            for (final ImagingTaskProcessorListener listener : new ArrayList<ImagingTaskProcessorListener>(listeners))
              {
                try
                  {
                    listener.notifyTaskStarted(event);
                  }
                catch (Throwable t)
                  {
                    log.warn("Exception in fireNotifyTaskStarted(): " + t);
                    log.warn("fireNotifyTaskStarted()", t);
                  }
              }
          }
      }

    /***************************************************************************
     *
     * Guarantees that the controller is invoked in thread-safe mode and that
     * the counters are not changed while the controller is running.
     *
     **************************************************************************/
    public void fireNotifyTaskCompleted (ImagingTask task) 
      {
        synchronized (processor.lock)
          {
            ImagingTaskProcessorEvent event = new ImagingTaskProcessorEvent(processor, Thread.currentThread().getName(), task);

            for (final ImagingTaskProcessorListener listener : new ArrayList<ImagingTaskProcessorListener>(listeners))
              {
                try
                  {
                    listener.notifyTaskCompleted(event);
                  }
                catch (Throwable t)
                  {
                    log.warn("Exception in fireNotifyTaskCompleted(): " + t);
                    log.warn("fireNotifyTaskCompleted()", t);
                  }
              }
          }
      }
    
    /***************************************************************************
     *
     * Guarantees that the controller is invoked in thread-safe mode and that
     * the counters are not changed while the controller is running.
     *
     **************************************************************************/
    public void fireNotifyTaskPopped (ImagingTask task) 
      {
        synchronized (processor.lock)
          {
            ImagingTaskProcessorEvent event = new ImagingTaskProcessorEvent(processor, Thread.currentThread().getName(), task);

            for (final ImagingTaskProcessorListener listener : new ArrayList<ImagingTaskProcessorListener>(listeners))
              {
                try
                  {
                    listener.notifyTaskPopped(event);
                  }
                catch (Throwable t)
                  {
                    log.warn("Exception in fireNotifyTaskPopped(): " + t);
                    log.warn("fireNotifyTaskPopped()", t);
                  }
              }
          }
      }
  }
