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
package org.imajine.image.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.io.Serializable;
import org.imajine.image.processor.event.ImagingTaskProcessorEvent;
import org.imajine.image.processor.event.ImagingTaskProcessorListener;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
/* package */ class ImagingTaskProcessorEventManager 
  {
    private static final String CLASS = ImagingTaskProcessorEventManager.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
    
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
                    logger.warning("Exception in fireNotifyTaskPosted(): " + t);
                    logger.throwing(CLASS, "fireNotifyTaskPosted()", t);
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
                    logger.warning("Exception in fireNotifyTaskStarted(): " + t);
                    logger.throwing(CLASS, "fireNotifyTaskStarted()", t);
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
                    logger.warning("Exception in fireNotifyTaskCompleted(): " + t);
                    logger.throwing(CLASS, "fireNotifyTaskCompleted()", t);
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
                    logger.warning("Exception in fireNotifyTaskPopped(): " + t);
                    logger.throwing(CLASS, "fireNotifyTaskPopped()", t);
                  }
              }
          }
      }
  }
