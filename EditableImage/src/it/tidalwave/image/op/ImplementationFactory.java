/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2006 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
 *                        and Emmanuele Sordini (Emmanuele@Sordini.com)
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
 * $Id: ImplementationFactory.java 429 2007-02-01 11:40:11Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.op;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import it.tidalwave.image.ImageModel;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ImplementationFactory.java 429 2007-02-01 11:40:11Z fabriziogiudici $
 *
 ******************************************************************************/
public abstract class ImplementationFactory
  {
    private static final String CLASS = ImplementationFactory.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);
    private Class modelClass;
    private Map<Class, Class> implementationMapping = new HashMap<Class, Class>();

    /***************************************************************************
     *
     *
     **************************************************************************/
    public ImplementationFactory (Class modelClass)
      {
        this.modelClass = modelClass;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public Class getModelClass ()
      {
        return modelClass;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public void registerImplementation (Class operationClass, Class implementationClass)
      {
        implementationMapping.put(operationClass, implementationClass);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public void unregisterImplementation (Class operationClass)
      {
        implementationMapping.remove(operationClass);
      }

    /***************************************************************************
     *
     * Finds the concrete implementation for a given operation.
     *
     * @param  operation  operation
     * @return            the implementation (null if not supported)
     *
     **************************************************************************/
    public OperationImplementation findImplementation (Operation operation)
      {
        Class<OperationImplementation<Operation, Object>> clazz = implementationMapping.get(operation.getClass());

        if (clazz != null)
          {
            try
              {
                OperationImplementation<Operation, Object> implementation = (OperationImplementation<Operation, Object>)clazz
                    .newInstance();
                implementation.setFactory(this);
                implementation.bind(operation);

                return implementation;
              }
            catch (IllegalAccessException e)
              {
                logger.throwing(CLASS, "findImplementation()", e);
              }
            catch (InstantiationException e)
              {
                logger.throwing(CLASS, "findImplementation()", e);
              }
          }

        return null;
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public ImageModel createImageModel (BufferedImage image)
      {
        throw new UnsupportedOperationException();
      }

    /***************************************************************************
     *
     * Return true if we can convert the given imageClass into our specific image
     * class.
     *
     **************************************************************************/
    public abstract boolean canConvertFrom (Class imageClass);

    /***************************************************************************
     *
     * Converts the given image into our specific image representation.
     *
     **************************************************************************/
    public abstract ImageModel convertFrom (Object image);

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public abstract boolean canConvertTo (Class imageClass);

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public abstract Object convertTo (Object image);

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public String toString ()
      {
        return "ImplementationFactory[" + modelClass + "]";
      }
  }
