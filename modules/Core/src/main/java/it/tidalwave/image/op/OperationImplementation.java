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

import javax.annotation.Nonnull;
import it.tidalwave.image.EditableImage;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public abstract class OperationImplementation<Op extends Operation, Model extends Object>
  {
    /** The operation we are implementing. */
    private Op operation;
    
    @Getter @Setter
    private ImplementationFactory factory;

    /*******************************************************************************************************************
     *
     * Executes this operation on the given model.
     *
     * @param  model      the image representation
     *
     ******************************************************************************************************************/
    @Nonnull
    public final Object execute (final @Nonnull EditableImage image, final @Nonnull Object model)
      {
        final long now = System.currentTimeMillis();
        log.trace("executing {}", operation);
        final Object result = execute(operation, image, (Model)model);
        log.trace(">>>> {} done in {} msec", operation, (System.currentTimeMillis() - now));

        return result;
      }
    
    /*******************************************************************************************************************
     *
     * Sometimes an implementation can't handle a specific set of parameters.
     * In this case, this method must return false, so this implementation will
     * be discarded.
     * This method returns true by default, so subclasses with different
     * behaviours should override it.
     *
     ******************************************************************************************************************/
    public boolean canHandle (final @Nonnull Op operation)
      {
        return true;  
      }
    
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    protected void bind (final @Nonnull Op operation)
      {
        this.operation = operation;
      }
    
    /*******************************************************************************************************************
     *
     * The concrete implementation of this operation should be provided by
     * overriding this method.
     *
     * @param  operation  the operation to implement
     * @param  model      the image representation
     *
     ******************************************************************************************************************/
    @Nonnull
    protected abstract Model execute (final @Nonnull Op operation, 
                                      final @Nonnull EditableImage image, 
                                      final @Nonnull Model model);
  }
