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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.io.Serializable;
import it.tidalwave.image.processor.event.ImagingTaskProcessorListener;
import lombok.extern.slf4j.Slf4j;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
@Slf4j
public abstract class ImagingTaskProcessor // NOT Serializable
  {
    /** The singleton instance. */
    private static ImagingTaskProcessor instance;
    
    /** The class to be used for the concrete implementation. */
    private static Class<? extends ImagingTaskProcessor> defaultClass = LocalImagingTaskProcessor.class;

    private static int eventNotifierCounter;
    
    /** The max number of workers. */
    protected static int maxWorkers = Integer.MAX_VALUE;
  
    /** The current number of free workers. */
    protected int freeWorkers;
    
    /** A lock used to manipulate the inner state. */
    protected final Object lock = new Object();
    
    /** The list of pending tasks. */
    private final List<ImagingTask> pendingTasks = Collections.synchronizedList(new ArrayList<ImagingTask>());
    
    /** The list of running tasks. */
    private final List<ImagingTask> runningTasks = Collections.synchronizedList(new ArrayList<ImagingTask>());
    
    /** The list of completed tasks. */
    private final List<ImagingTask> completedTasks = Collections.synchronizedList(new ArrayList<ImagingTask>());
    
    private final Statistics statistics = new Statistics();
    
    private final ImagingTaskProcessorEventManager eventManager = new ImagingTaskProcessorEventManager(this); 
    
    /***************************************************************************
     *
     *
     *
     **************************************************************************/
    protected ImagingTaskProcessor() 
      {
      }

    /***************************************************************************
     *
     * Gets the singleton instance of the processor.
     *
     * @return  the ImagingTaskProcessor
     *
     **************************************************************************/
    // change getInstance()->getDefault() since this is no more a singleton
    public synchronized static ImagingTaskProcessor getInstance() 
      {
        if (instance == null)
          {
            try
              {
                instance = defaultClass.newInstance();
              }
            catch (Exception e)
              {
                throw new RuntimeException(e); // FIXME  
              }
          }
        
        return instance;
      }
    
    /***************************************************************************
     *
     * Sets the default implementation of the ImagingTaskProcessor
     *
     * @param  defaultClass  the implementation class
     *
     **************************************************************************/
    public static void setDefault (final Class<? extends ImagingTaskProcessor> defaultClass)
      {
        ImagingTaskProcessor.defaultClass = defaultClass;
        instance = null; // force a creation of new instance next time
      }
    
    /***************************************************************************
     *
     * Sets a limit to the number of concurrent workers.
     *
     * @param  maxWorkers  the max. number of workers
     *
     **************************************************************************/
    public static void setMaxWorkers (final int maxWorkers)
      {
        ImagingTaskProcessor.maxWorkers = maxWorkers;  
      }
     
    /***************************************************************************
     *
     *
     **************************************************************************/
    public int getMaxWorkers() 
      {
        return maxWorkers;
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public abstract int getWorkerCount();
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public abstract Collection<Serializable> getWorkerIds();
    
    /***************************************************************************
     *
     * Returns true if the tasks will be executed in a distributed context
     * (i.e. with different physical nodes - in single-node, multi-core contexts
     * this method returns false.
     *
     **************************************************************************/
    public abstract boolean isDistributed();
    
    /***************************************************************************
     *
     * Returns true if the tasks will be executed in a distributed context
     * with the support of a distributed file system - that is, if each task
     * is guaranteed to have a File access to the same set of data. Or if
     * the context is a single-node, multi-core system, which of course has a
     * single filesystem.
     *
     **************************************************************************/
    public abstract boolean hasFileAccess();
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void addListener (final ImagingTaskProcessorListener listener)
      {
        eventManager.addListener(listener);
      }
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    public void removeListener (final ImagingTaskProcessorListener listener)
      {
        eventManager.removeListener(listener);
      }
    
    /***************************************************************************
     *
     *
     *
     **************************************************************************/
    public boolean processingResourcesAvailable()
      {
        synchronized (lock)
          {
            return freeWorkers > 0;
          }
      }

    /***************************************************************************
     *
     * Posts a new task into the queue. The task will be scheduled later as soon
     * there are favorable conditions. This method returns immediately.
     *
     * @param  task  the ImagingTask to post
     *
     **************************************************************************/
    public void post (final Collection<? extends ImagingTask> tasks) 
      {
        log.info(String.format("post(%s) - free workers: %d", tasks, freeWorkers));
        
        synchronized (lock)
          {
            pendingTasks.addAll(tasks);
            lock.notify();
            
            for (final ImagingTask task : tasks)
              {
                log.info(String.format(">>>> %s added to pending task list", task.getName()));
                eventManager.fireNotifyTaskPosted(task);
              }
          }
      }

    /***************************************************************************
     *
     * Posts a new task into the queue. The task will be scheduled later as soon
     * there are favorable conditions. This method returns immediately.
     *
     * @param  task  the ImagingTask to post
     *
     **************************************************************************/
    public void post (final ImagingTask task) 
      {
        post(Collections.singletonList(task));
      }

    /***************************************************************************
     *
     * @param  task  the ImagingTask to post
     *
     **************************************************************************/
    public void postWithPriority (final Collection<? extends ImagingTask> tasks) 
      {
        log.info(String.format("postWithPriority(%s) - free workers: %d", tasks, freeWorkers));
        
        synchronized (lock)
          {
            pendingTasks.addAll(0, tasks);
            lock.notify();
            
            for (final ImagingTask task : tasks)
              {
                log.info(String.format(">>>> %s added to pending task list", task.getName()));
                eventManager.fireNotifyTaskPosted(task);
              }
          }
      }
    
    /***************************************************************************
     *
     * @param  task  the ImagingTasks to post
     *
     **************************************************************************/
    public void postWithPriority (final ImagingTask task) 
      {
        postWithPriority(Collections.singletonList(task));
      }
    
    /***************************************************************************
     *
     * Cancels all the pending tasks of the given type. This method returns 
     * immediately. Tasks in running state will be completed.
     *
     * @param  taskClass  the kind of task to remove (null means all)
     * @return            the list of completed tasks
     *
     **************************************************************************/
    public final <T extends ImagingTask> Collection<T> cancellPendingTasks (final Class<T> taskClass)
      {
        log.info("cancellPendingTasks(" + taskClass.getName() + ")");
        final List<T> result = new ArrayList<T>();
        
        synchronized (lock)
          {
            for (final Iterator<? extends ImagingTask> i = pendingTasks.iterator(); i.hasNext(); )
              {
                final ImagingTask task = i.next();
//                if ((taskClass == null) || taskClass.equals(task.getClass()))
                if ((taskClass == null) || taskClass.getName().equals(task.getClass().getName()))
                  {
                    i.remove();
                    result.add((T)task);
                  }
              }
          }
        
        return result;
      }

    /***************************************************************************
     *
     * Returns the number of pending tasks of the given class.
     *
     * @param  taskClass  the class of the task (null for any class)
     * @return            the task count
     *
     **************************************************************************/
    public int getPendingTaskCount (final Class<? extends ImagingTask> taskClass)
      {
        return getTaskCount(taskClass, pendingTasks);
      }
    
    /***************************************************************************
     *
     * Returns the number of running tasks of the given class.
     *
     * @param  taskClass  the class of the task (null for any class)
     * @return            the task count
     *
     **************************************************************************/
    public int getRunningTaskCount (final Class<? extends ImagingTask> taskClass)
      {
        return getTaskCount(taskClass, runningTasks);
      }
    
    /***************************************************************************
     *
     * Returns the number of completed tasks of the given class. This number is
     * decreased as popCompletedTask() is called.
     *
     * @param  taskClass  the class of the task (null for any class)
     * @return            the task count
     *
     **************************************************************************/
    public int getCompletedTaskCount (final Class<? extends ImagingTask> taskClass)
      {
        return getTaskCount(taskClass, completedTasks);
      }
    
    /***************************************************************************
     *
     * Pops a completed task out of the list. This will decrease the count of
     * completed task. This operation is usually performed by the controller to
     * consume the task result and eventually schedule a new task.
     *
     * @param  taskClass  the class of the task
     * @return            the completed task
     * @throws            NoSuchElementException if no tasks of the given class
     *                    is available
     *
     **************************************************************************/
    @SuppressWarnings("unchecked")
    public <T extends ImagingTask> T popCompletedTask (final Class<T> taskClass)
      {
        synchronized (lock)
          {
            for (final ImagingTask task : completedTasks)
              {
//                if ((taskClass == null) || taskClass.equals(task.getClass()))
                if ((taskClass == null) || taskClass.getName().equals(task.getClass().getName()))
                  {
                    completedTasks.remove(task);
                    eventManager.fireNotifyTaskPopped(task);
                    return (T)task;
                  }
              }
          }
        
        throw new NoSuchElementException("No completed task of class " + taskClass);
      }
    
    /***************************************************************************
     *
     *
     *
     **************************************************************************/
    public Statistics getStatistics()
      {
        return statistics;    
      }
    
    /***************************************************************************
     *
     *
     *
     **************************************************************************/
//    protected boolean canScheduleMore()
//      {
//        return freeWorkers > 0;
//      }
    
    /***************************************************************************
     *
     *
     *
     **************************************************************************/
    protected void changeFreeWorkerCount (final int delta)
      {
        synchronized (lock)
          {
            freeWorkers += delta;
            lock.notify();
          }
      }
            
    /***************************************************************************
     *
     * Returns the next pending task to execute. This method blocks until a
     * pending task is available.
     *
     * @return  the task to execute
     *
     **************************************************************************/
    protected final ImagingTask getNextTask (final Serializable workerId, final boolean remoteExecution)
      {
        ImagingTask task = null;

        while (task == null)
          {
            synchronized (lock)
              {
                while (pendingTasks.isEmpty())
                  {
                    try 
                      {
                        lock.wait();
                      }
                    catch (InterruptedException e) 
                      {
                        return null; // FIXME: better to relaunch InterruptedException
                      }
                  }

                for (final Iterator<ImagingTask> i = pendingTasks.iterator(); i.hasNext(); )
                  {
                    final ImagingTask task2 = i.next();

                    if (!remoteExecution || task2.isRemoteExecutionOk())
                      {
                        i.remove();
                        task = task2;
                        break;
                      }
                  }
              }

            if (task != null)
              {
                synchronized (lock)
                  {
                    runningTasks.add(task);
                  } 
                
                eventManager.fireNotifyTaskStarted(task, workerId);
              }

            else
              {
                try 
                  {
                    Thread.sleep(100); // Don't go CPU-bound
                  }
                catch (InterruptedException e) 
                  {
                 // FIXME: better to relaunch InterruptedException
                  }
              }
          }
        
        return task;
      }
    
    /***************************************************************************
     *
     * <p>Notifies that a task has been completed. The task is removed from the
     * list of running tasks and added into the list of completed tasks. If 
     * an ImagingTaskProcessorController has been specified, it is notified too.
     * </p>
     *
     * <p>This method is able to filter out duplicated tasks (that could occur
     * with some distributed implementations.</p>
     *
     * <p>It is important that this method blocks until the controller has been 
     * invoked - otherwise e.g. the Computer Server implementation could fail,
     * for instance if there are no running tasks and the controller has not 
     * been able to post new tasks yet. In this circumstances, the facility 
     * erroneously thinks that everything is over and quits.</p>
     * 
     * @param  task  the completed task
     *
     **************************************************************************/
    protected final void notifyTaskCompleted (final ImagingTask task)
      {
        log.info("notifyTaskCompleted(" + task + ")");        
        boolean duplicate = false;
        
        synchronized (lock)
          {
            duplicate = !runningTasks.contains(task);
            
            if (!duplicate)
              {
                runningTasks.remove(task);
                completedTasks.add(task);
              }
          }
        
        if (duplicate)
          {
            log.warn("Filtering out duplicated task: " + task);
          }
        
        else
          {
            statistics.merge(task.getStatistics());
            eventManager.fireNotifyTaskCompleted(task);
          }
      }

    /***************************************************************************
     *
     *
     *
     **************************************************************************/
    private int getTaskCount (final Class taskClass, final Collection<? extends ImagingTask> taskCollection)
      {
        int count = 0;
        
        synchronized (lock) // implement in a smarter way
          {
            for (final ImagingTask task : taskCollection)
              {
//                if ((taskClass == null) || taskClass.equals(task.getClass()))
                if ((taskClass == null) || taskClass.getName().equals(task.getClass().getName()))
                  {
                    count++;  
                  }
              }
          }
        
        return count;
      }
  }
