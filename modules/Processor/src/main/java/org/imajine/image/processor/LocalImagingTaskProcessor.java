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
package org.imajine.image.processor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class LocalImagingTaskProcessor extends ImagingTaskProcessor
  {
    private static final String CLASS = LocalImagingTaskProcessor.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
    
    private final Collection<PoolThread> workers = new ArrayList<PoolThread>();
    
    /***************************************************************************
     *
     *
     *
     **************************************************************************/
    protected class PoolThread extends Thread
      {
        public PoolThread (String name)
          {
            super(name);  
            setDaemon(true);
          }
        
        @Override
        public void run()
          {
            for (;;) // TODO: add a smart way to terminate
              {
                changeFreeWorkerCount(+1);
                ImagingTask task = getNextTask(getName(), false);
                changeFreeWorkerCount(-1);
                logger.fine(Thread.currentThread().getName() + " assigned to " + task.getName());
                
                try
                  {
                    task.prepare(LocalImagingTaskProcessor.this);
                    task.execute();
                  }
                catch (Throwable t) // prevents task errors to disrupt the worker
                  {
                    logger.severe("Exception while running task: " + t);
                    logger.throwing(CLASS, "run()", t);  
                  }
                
                notifyTaskCompleted(task);
              }
          }
      }
    
    /***************************************************************************
     *
     *
     *
     **************************************************************************/
    public LocalImagingTaskProcessor() 
      {
        for (int i = 0; i < Math.min(Runtime.getRuntime().availableProcessors(), maxWorkers); i++)
          {
            PoolThread worker = new PoolThread("PoolThread #" + i);
            workers.add(worker);
            worker.start();   
          }
        
        logger.info("Created " + workers.size() + " local workers");
      }

    /***************************************************************************
     *
     * @inheritDoc
     *
     **************************************************************************/
    @Override
    public boolean isDistributed() 
      {
        return false;
      }

    /***************************************************************************
     *
     * @inheritDoc
     *
     **************************************************************************/
    @Override
    public boolean hasFileAccess() 
      {
        return true;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public int getWorkerCount()
      {
        return workers.size();
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    @Override
    public Collection<Serializable> getWorkerIds()
      {
        Collection<Serializable> result = new ArrayList<Serializable>();
        
        for (PoolThread worker : workers)
          {
            result.add(worker.getName());
          }
        
        return result;
      }
  }
