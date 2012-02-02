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
package org.imajine.image.op;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;
import org.imajine.image.ImageModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@RequiredArgsConstructor @ToString(of="modelClass") @Slf4j
public abstract class ImplementationFactory
  {
    @Getter @Nonnull
    private final Class modelClass;
    
    private final Map<Class<? extends Operation>, Class<? extends OperationImplementation>> implementationMapping =
            new HashMap<Class<? extends Operation>, Class<? extends OperationImplementation>>();

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void registerImplementation (final @Nonnull Class<? extends Operation> operationClass,
                                        final @Nonnull Class<? extends OperationImplementation> implementationClass)
      {
        implementationMapping.put(operationClass, implementationClass);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public void unregisterImplementation (final @Nonnull Class<? extends Operation> operationClass)
      {
        implementationMapping.remove(operationClass);
      }

    /*******************************************************************************************************************
     *
     * Finds the concrete implementation for a given operation.
     *
     * @param  operation  operation
     * @return            the implementation (null if not supported)
     *
     ******************************************************************************************************************/
    @Nonnull 
    public OperationImplementation<Operation, Object> findImplementation (final @Nonnull Operation operation)
      {
        final Class<OperationImplementation<Operation, Object>> implementationClass = 
                (Class<OperationImplementation<Operation, Object>>) implementationMapping.get(operation.getClass());

        if (implementationClass != null)
          {
            try
              {
                final OperationImplementation<Operation, Object> implementation = implementationClass.newInstance();
                // FIXME: drop these setters and pass to the constructor, so the object is truly immutable
                implementation.setFactory(this);
                implementation.bind(operation);

                return implementation;
              }
            catch (IllegalAccessException e)
              {
                log.error("findImplementation()", e);
              }
            catch (InstantiationException e)
              {
                log.error("findImplementation()", e);
              }
          }

        return null;
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull 
    public ImageModel createImageModel (final @Nonnull BufferedImage image)
      {
        throw new UnsupportedOperationException();
      }

    /*******************************************************************************************************************
     *
     * Return true if we can convert the given imageClass into our specific image
     * class.
     *
     ******************************************************************************************************************/
    public abstract boolean canConvertFrom (@Nonnull Class imageClass);

    /*******************************************************************************************************************
     *
     * Converts the given image into our specific image representation.
     *
     ******************************************************************************************************************/
    @Nonnull 
    public abstract ImageModel convertFrom (@Nonnull Object image);

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public abstract boolean canConvertTo (@Nonnull Class<?> imageClass);

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull 
    public abstract Object convertTo (@Nonnull Object image);
  }
