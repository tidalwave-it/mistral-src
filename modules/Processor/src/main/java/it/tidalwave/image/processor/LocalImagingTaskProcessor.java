/*
 * *********************************************************************************************************************
 *
 * Mistral: open source imaging engine
 * http://tidalwave.it/projects/mistral
 *
 * Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
 *
 * *********************************************************************************************************************
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
 * *********************************************************************************************************************
 *
 * git clone https://bitbucket.org/tidalwave/mistral-src
 * git clone https://github.com/tidalwave-it/mistral-src
 *
 * *********************************************************************************************************************
 */
package it.tidalwave.image.processor;

import java.util.ArrayList;
import java.util.Collection;
import java.io.Serializable;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class LocalImagingTaskProcessor extends ImagingTaskProcessor
  {
    private final Collection<PoolThread> workers = new ArrayList<PoolThread>();

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    protected class PoolThread extends Thread
      {
        public PoolThread (final String name)
          {
            super(name);
            setDaemon(true);
          }

        @Override
        public void run()
          {
            for (; ; ) // TODO: add a smart way to terminate
              {
                changeFreeWorkerCount(+1);
                final ImagingTask task = getNextTask(getName(), false);
                changeFreeWorkerCount(-1);
                log.debug(Thread.currentThread().getName() + " assigned to " + task.getName());

                try
                  {
                    task.prepare(LocalImagingTaskProcessor.this);
                    task.execute();
                  }
                catch (Throwable t) // prevents task errors to disrupt the worker
                  {
                    log.error("Exception while running task: " + t);
                    log.error("run()", t);
                  }

                notifyTaskCompleted(task);
              }
          }
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public LocalImagingTaskProcessor()
      {
        for (int i = 0; i < Math.min(Runtime.getRuntime().availableProcessors(), maxWorkers); i++)
          {
            final PoolThread worker = new PoolThread("PoolThread #" + i);
            workers.add(worker);
            worker.start();
          }

        log.info("Created " + workers.size() + " local workers");
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public boolean isDistributed()
      {
        return false;
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public boolean hasFileAccess()
      {
        return true;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public int getWorkerCount()
      {
        return workers.size();
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Override
    public Collection<Serializable> getWorkerIds()
      {
        final Collection<Serializable> result = new ArrayList<Serializable>();

        for (final PoolThread worker : workers)
          {
            result.add(worker.getName());
          }

        return result;
      }
  }
