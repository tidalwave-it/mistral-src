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

import java.util.logging.Logger;
import java.io.Serializable;
import org.imajine.image.EditableImage;
import org.imajine.image.op.Operation;

/*******************************************************************************
 *
 * Encapsulates an unit of image processing.
 *
 * Concrete implementations of this class MUST BE serializable.
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
abstract public class ImagingTask implements Serializable
  {
    static final long serialVersionUID = 8564150248239203504L;
    
    private static final String CLASS = ImagingTask.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
    
    private final static long MEGA = 1024 * 1024;
        
    private static int uniqueIdCounter;
    
    /** The name of this task. */
    private String name;
    
    private EditableImage result;
    
    /** The unique id of this task. It's used for implementing equals() and
        hashcode() as in a distributed environment every sort of things can
        happen to an ImagingTask, as they are possibly created on different
        computing nodes and serialized back and forth. */
    private Serializable uniqueId;
    
    /** This id is used only for logging. */
    private int loggingId;
    
    /** The statistics of this task. */
    private Statistics statistics = new Statistics();
    
    /** A throwable if the task ended with an error. */
    private Throwable throwable;
    
    public long latestExecutionTime; // FIXME
    
    private boolean serializeByFile;
    
    /***************************************************************************
     *
     * For serialization.
     *
     **************************************************************************/
    public ImagingTask()
      {
      } 
    
    /***************************************************************************
     *
     * Creates a new instance of ImagingTask. Subclasses must *not* perform
     * any initialization here: they should use <code>prepare()</code> instead.
     * This constructor must return very quickly.
     *
     **************************************************************************/
    public ImagingTask (final String name, final int loggingId)
      {
        serializeByFile = false; // ImagingTaskProcessor.getInstance().hasFileAccess();
        this.name = name; 
        this.loggingId = loggingId;
        this.uniqueId = Long.toHexString(System.currentTimeMillis()) 
                        + "-" + Long.toHexString(uniqueIdCounter++); // FIXME: use a UUID instead
      }
    
    /***************************************************************************
     *
     * Returns the name of this task.
     *
     * @return  the task name
     *
     **************************************************************************/
    public String getName()
      {
        return name + " #" + loggingId;  
      }
    
    /***************************************************************************
     *
     * Returns the unique id of this task.
     *
     * @return  the task id
     *
     **************************************************************************/
    public Serializable getId()
      {
        return uniqueId;  
      }
    
    /***************************************************************************
     *
     * This method is performed <i>in a local context</i> before the task is 
     * scheduled to run - that is, this method is performed in a serialized 
     * fashion, possibly on a single computing node (depending on the processing
     * engine). Subclasses can override this method for customizing
     * the behaviour (that must not be computing intensive).
     *
     * The <code>processor</code> parameter can be used to query some properties
     * of the <code>ImagingTaskProcessor</code> that could be used for alternate
     * preparing strategies.
     *
     * The <code>super</code> method must be always called.
     *
     * @param  processor  the processor
     *
     **************************************************************************/
    public void prepare (ImagingTaskProcessor processor)
      throws Exception
      {
      }
    
    /***************************************************************************
     *
     * Concrete implementations should provide the task core in this method.
     * This method is performed in a distributed context, if available.
     *
     **************************************************************************/
    abstract protected void run()
      throws Exception;
    
    /***************************************************************************
     *
     * Returns the result of this task. Must be implemented by subclasses.
     *
     * @return  the result
     *
     **************************************************************************/
    public final EditableImage getResult()
      {
        return result;  
      }
    
    protected final void setResult (EditableImage result)
      {
        this.result = result;  
      }
    
    /***************************************************************************
     *
     * If the task ended with an error, a Throwable is returned by this method.
     *
     * @return  the throwable
     *
     **************************************************************************/
    public Throwable getThrowable()
      {
        return throwable;
      }
    
    public void setThrowable (Throwable throwable)
      {
        this.throwable = throwable;  
      }
    
    /***************************************************************************
     *
     * If this method return <code>true</code> (the default), this task can be
     * executed remotely. Otherwise it will be scheduled on the local node.
     * Usually tasks which computation time is very quick and much shorter than
     * the overhead to serialize data back and forth should return 
     * <code>false</code>.
     *
     * @return  true  if the task can be scheduled remotely
     *
     **************************************************************************/
    public boolean isRemoteExecutionOk()
      {
        return true;  
      }
    
    /***************************************************************************
     *
     * Returns the statistics collected by this task.
     *
     * @return  the statistics
     *
     **************************************************************************/
    public Statistics getStatistics()
      {
        return statistics;  
      }
    
    /***************************************************************************
     *
     * Subclasses should release all the allocated resources when this method
     * is called.
     *
     **************************************************************************/
    public void dispose()
      {
        result = null;
        // DO NOT dispose() result as it could be used by others!
      }
    
    /***************************************************************************
     *
     * @inheritDoc
     *
     **************************************************************************/
    @Override
    public final String toString() 
      {
        return getName() + " [" + uniqueId + "]";
      }

    /***************************************************************************
     *
     * See the comment about uniqueId.
     *
     **************************************************************************/
    @Override
    public final int hashCode() 
      {
        return uniqueId.hashCode();
      }

    /***************************************************************************
     *
     * See the comment about uniqueId.
     *
     **************************************************************************/
    @Override
    public final boolean equals (final Object object) 
      {
        if (!(object instanceof ImagingTask))
          {
            return false;  
          }
        
        final ImagingTask task = (ImagingTask)object;
        return this.uniqueId.equals(task.uniqueId);
      }
    
    /***************************************************************************
     *
     * Executes the task. This method is only called by the framework.
     *
     **************************************************************************/
    public final void execute()
      {
        try
          {
            logger.info("Starting " + name);
            long time = System.currentTimeMillis();

            try
              {
                run();
              }
            finally
              {
                time = System.currentTimeMillis() - time;
                addStatisticsSample("TOTAL", time);    
                logger.info("STATS: " + getName() + " completed in " + time + " msec");
                
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();
                long usedMemory = totalMemory - freeMemory;
                logger.info("STATS: memory " + "used: " + mega(usedMemory) 
                                             + ", total: " + mega(totalMemory) 
                                             + ", max: " + mega(runtime.maxMemory()) 
                                             + ", free: " + mega(freeMemory));
              }
           }
        catch (Throwable e)
          {
            throwable = e;
            logger.severe("Task failed: " + getName() + ", " + e);
            logger.throwing(CLASS, "execute()", e);
            e.printStackTrace(System.err);
          }
        
        logger.info("Completed " + getName());
      }

    /***************************************************************************
     *
     *
     *
     **************************************************************************/
    public void addStatisticsSample (String name, long value)
      {
        statistics.addSample(this.name + "." + name, value);
      }
    
    /***************************************************************************
     *
     * Updates statistics about execution time, about the latest performed 
     * operation on the given image.
     *
     * @param  name   the statistics name
     * @param  image  the image
     *
     **************************************************************************/
    protected void registerTime (String name, EditableImage image)
      {
        addStatisticsSample(name, image.getLatestOperationTime());
      }
    
    /*******************************************************************************
     *
     * Executes an operation adding the elapsed time to the statistics.
     *
     * @param  image          the image to process
     * @param  operation      the operation to execute
     * @param  operationName  the name used for the statistics
     * @return                the operation (as a convenience in case it carries 
     *                        results)
     *  
     *******************************************************************************/
    protected <T extends Operation> T execute (EditableImage image, T operation, String operationName)
      {
        image.execute(operation);
        image.setNickName(operationName);
        registerTime(operationName, image);
        return operation;
      }
    
    /*******************************************************************************
     *
     * The same as execute(), but the operand image is disposed before returning.
     *
     * @param  image          the image to process
     * @param  operation      the operation to execute
     * @param  operationName  the name used for the statistics
     * @return                the operation (as a convenience in case it carries 
     *                        results)
     *  
     *******************************************************************************/
    protected <T extends Operation> T executeAndDispose (EditableImage image, T operation, String operationName)
      {
        final T result = execute(image, operation, operationName);
        image.dispose();
        return result;
      }
    
    /*******************************************************************************
     *
     * Executes an operation adding the elapsed time to the statistics.
     *
     * @param  image          the image to process
     * @param  operation      the operation to execute
     * @param  operationName  the name used for the statistics
     * @return                the result
     *  
     *******************************************************************************/
    protected EditableImage execute2 (EditableImage image, Operation operation, String operationName)
      {
        final EditableImage result = image.execute2(operation);
        result.setNickName(operationName);
        registerTime(operationName, result);
        return result;
      }
    
    /*******************************************************************************
     *
     * The same as execute2(), but the operand image is disposed before returning.
     *
     * @param  image          the image to process
     * @param  operation      the operation to execute
     * @param  operationName  the name used for the statistics
     * @return                the result
     *  
     *******************************************************************************/
    protected EditableImage execute2AndDispose (EditableImage image, Operation operation, String operationName)
      {
        final EditableImage result = execute2(image, operation, operationName);
        image.dispose();
        result.setNickName(operationName);
        return result;
      }
    
    /*******************************************************************************
     *
     *
     *******************************************************************************/
    private static String mega (long l)
      {
        return "" + ((l + MEGA / 2) / MEGA) + "M";
      }
  }
