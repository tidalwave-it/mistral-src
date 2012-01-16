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
package it.tidalwave.image.op;

import it.tidalwave.image.EditableImage;
import java.util.logging.Logger;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public abstract class OperationImplementation<O extends Operation, M extends Object>
  {
    private static final String CLASS = OperationImplementation.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /** The operation we are implementing. */
    private O operation;
    private ImplementationFactory factory;

    /***************************************************************************
     *
     *
     **************************************************************************/
    public void setFactory (ImplementationFactory factory)
      {
        this.factory = factory;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public ImplementationFactory getFactory ()
      {
        return factory;
      }

    /***************************************************************************
     *
     * Executes this operation on the given model.
     *
     * @param  model      the image representation
     *
     **************************************************************************/
    public final Object execute (final EditableImage image, Object model)
      {
        long now = System.currentTimeMillis();
        logger.fine("executing " + operation);
        model = execute(operation, image, (M)model);
        logger.finer(">>>> " + operation + " done in " + (System.currentTimeMillis() - now) + " msec");

        return model;
      }
    
    /***************************************************************************
     *
     * Sometimes an implementation can't handle a specific set of parameters.
     * In this case, this method must return false, so this implementation will
     * be discarded.
     * This method returns true by default, so subclasses with different
     * behaviours should override it.
     *
     **************************************************************************/
    public boolean canHandle (final O operation)
      {
        return true;  
      }
    
    /***************************************************************************
     *
     * The concrete implementation of this operation should be provided by
     * overriding this method.
     *
     * @param  operation  the operation to implement
     * @param  model      the image representation
     *
     **************************************************************************/
    protected abstract M execute (O operation, EditableImage image, M model);
    
    /***************************************************************************
     *
     *
     **************************************************************************/
    protected void bind (O operation)
      {
        this.operation = operation;
      }
  }
