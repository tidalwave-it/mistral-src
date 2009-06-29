/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici
 *                        and Emmanuele Sordini
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 *******************************************************************************
 * 
 * $Id: ImagingTaskProcessorEvent.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.processor.event;

import java.util.EventObject;
import java.io.Serializable;
import it.tidalwave.image.processor.ImagingTask;
import it.tidalwave.image.processor.ImagingTaskProcessor;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ImagingTaskProcessorEvent.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class ImagingTaskProcessorEvent extends EventObject
  {
    private final ImagingTask task;
    
    private final Serializable workerId;
    
    public ImagingTaskProcessorEvent (final ImagingTaskProcessor imagingTaskProcessor, final Serializable workerId, final ImagingTask task)
      {
        super(imagingTaskProcessor);
        this.task = task;
        this.workerId = workerId;
      }
    
    public ImagingTask getTask()
      {
        return task;  
      }
    
    public Serializable getWorkerId()
      {
        return workerId;  
      }
  }
