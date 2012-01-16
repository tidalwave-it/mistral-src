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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import it.tidalwave.image.ImageModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class ImplementationFactoryRegistry
  {
    private static final String CLASS = ImplementationFactoryRegistry.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);
    
    private static ImplementationFactoryRegistry instance;
    
    private final List<ImplementationFactory> factoryList = new ArrayList<ImplementationFactory>();

    /*******************************************************************************************************************
     *
     * Gets the singleton instance.
     *
     ******************************************************************************************************************/
    @Nonnull
    public static ImplementationFactoryRegistry getInstance ()
      {
        if (instance == null)
          {
            instance = new ImplementationFactoryRegistry();
          }

        return instance;
      }

    /*******************************************************************************************************************
     *
     * Registers a new ImplementationFactory.
     *
     * @param  factory  the factory to register
     *
     ******************************************************************************************************************/
    public void registerFactory (final @Nonnull ImplementationFactory factory)
      {
        factoryList.add(factory);
      }

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    @Nonnull
    public ImageModel createImageModel (final @Nonnull Object image)
      {
        for (final ImplementationFactory factory : factoryList)
          {
            if (factory.canConvertFrom(image.getClass()))
              {
                return factory.convertFrom(image);
              }
          }

        throw new IllegalArgumentException("Cannot create image model from " + image.getClass());
      }

    /*******************************************************************************************************************
     *
     * Finds the concrete implementation for a given operation. If canConvert is false, only the first strictly 
     * compatible implementations is returned; otherwise the first implementation that is compatible through a 
     * conversion is returned.
     *
     * @param operation   operation
     * @param imageModel  the imageModel
     * @param canConvert  is image conversion acceptable?
     * @return            the implementation
     * @throws UnsupportedOperationException  if no implementation has been found
     *
     ******************************************************************************************************************/
    @Nonnull
    public OperationImplementation findImplementation (final @Nonnull Operation operation,
                                                       final @Nonnull ImageModel imageModel,
                                                       final boolean canConvert)
      {
        logger.finer("findImplementation(" + operation + ", " + imageModel + " , canConvert: " + canConvert + ")");

        final Object image = (imageModel != null) ? imageModel.getImage() : null;

        for (final ImplementationFactory factory : factoryList)
          {
            final OperationImplementation implementation = factory.findImplementation(operation);

            if (implementation != null)
              {
                logger.finest(">>>> found implementation from " + factory);
                
                if (!implementation.canHandle(operation))
                  {
                    logger.finest(">>>> but can't handle this specific op, discarded");
                    continue;  
                  }  

                if (image == null) // createOp
                  {
                    return implementation;
                  }

                logger.finest(">>>> image class: " + image.getClass() + ", factory model class: "
                    + factory.getModelClass());

                if (factory.getModelClass().isAssignableFrom(image.getClass()))
                  {
                    return implementation;
                  }

                if (canConvert
                        && (factory.canConvertFrom(image.getClass())
                        || imageModel.getFactory().canConvertTo(factory.getModelClass())))
                  {
                    return implementation;
                  }

                logger.finest(">>>> but has been discarded");
              }
          }

        throw new UnsupportedOperationException("Not implemented " + operation + ", imageModel: " + imageModel
            + " factoryList: " + factoryList);
      }
  }
