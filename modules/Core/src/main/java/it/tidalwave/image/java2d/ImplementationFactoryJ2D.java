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
package it.tidalwave.image.java2d;

import javax.annotation.Nonnull;
import java.lang.reflect.Method;
import java.awt.image.BufferedImage;
import org.openide.util.lookup.ServiceProvider;
import it.tidalwave.image.ImageModel;
import it.tidalwave.image.op.CaptureOp;
import it.tidalwave.image.op.ConvertToBufferedImageOp;
import it.tidalwave.image.op.ConvolveOp;
import it.tidalwave.image.op.CreateOp;
import it.tidalwave.image.op.CropOp;
import it.tidalwave.image.op.DrawOp;
import it.tidalwave.image.op.ImplementationFactory;
import it.tidalwave.image.op.OptimizeOp;
import it.tidalwave.image.op.PaintOp;
import it.tidalwave.image.op.PrintOp;
import it.tidalwave.image.op.RotateOp;
import it.tidalwave.image.op.RotateQuadrantOp;
import it.tidalwave.image.op.ScaleOp;
import it.tidalwave.image.op.WrapOp;
import it.tidalwave.image.op.WriteOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@ServiceProvider(service=ImplementationFactory.class) @Slf4j
public class ImplementationFactoryJ2D extends ImplementationFactory
  {
    private Class<?> planarImageClass;

    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public ImplementationFactoryJ2D()
      {
        super(BufferedImage.class);
        registerImplementation(CaptureOp.class, CaptureJ2DOp.class);
        registerImplementation(CreateOp.class, CreateJ2DOp.class);
        registerImplementation(ConvolveOp.class, ConvolveJ2DOp.class);
        registerImplementation(CropOp.class, CropJ2DOp.class);
        registerImplementation(ConvertToBufferedImageOp.class, ConvertToBufferedImageJ2DOp.class);
        registerImplementation(DrawOp.class, DrawJ2DOp.class);
        registerImplementation(OptimizeOp.class, OptimizeJ2DOp.class);
        registerImplementation(PaintOp.class, PaintJ2DOp.class);
        registerImplementation(PrintOp.class, PrintJ2DOp.class);
        registerImplementation(RotateQuadrantOp.class, RotateQuadrantJ2DOp.class);
        registerImplementation(RotateOp.class, RotateJ2DOp.class);
        registerImplementation(ScaleOp.class, ScaleJ2DOp.class);
        registerImplementation(WrapOp.class, WrapJ2DOp.class);
        registerImplementation(WriteOp.class, WriteJ2DOp.class);

        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        try
          {
            planarImageClass = contextClassLoader.loadClass("javax.media.jai.PlanarImage");
          }
        catch (Throwable e)
          {
            log.warn("JAI not available: ", e.toString());
          }

        try
          {
            final Class<?> clazz = contextClassLoader.loadClass("it.tidalwave.image.java2d.AdditionalOperations");
            final Method method = clazz.getMethod("register", ImplementationFactoryJ2D.class);
            method.invoke(null, this);
          }
        catch (Throwable e)
          {
            log.warn("Additional Java2D operations not available: {}", e.toString());
          }
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override @Nonnull
    public ImageModel createImageModel (final @Nonnull BufferedImage bufferedImage)
      {
        return new ImageModelJ2D(bufferedImage);
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public boolean canConvertFrom (final @Nonnull Class imageClass)
      {
        return imageClass.equals(BufferedImage.class) ||
        ((planarImageClass != null) && planarImageClass.isAssignableFrom(imageClass));
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnull
    @Override
    public ImageModel convertFrom (final @Nonnull Object image)
      {
//        if ((planarImageClass != null) && planarImageClass.isAssignableFrom(image.getClass())) // image instanceof PlanarImage
        if (canConvertFrom(image.getClass()))
          {
            if (image instanceof BufferedImage)
              {
                return new ImageModelJ2D((BufferedImage)image);
              }

            try
              {
                final Method method = planarImageClass.getMethod("getAsBufferedImage");
                final Object bufferedImage = method.invoke(image);

                return new ImageModelJ2D(bufferedImage);
              }
            catch (Exception e)
              {
                throw new UnsupportedOperationException(e);
              }
          }

        throw new UnsupportedOperationException("convertFrom " + image.getClass());
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public boolean canConvertTo (final @Nonnull Class imageClass)
      {
        return (planarImageClass != null) && planarImageClass.isAssignableFrom(imageClass); // image instanceof PlanarImage
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Nonnull
    @Override
    public Object convertTo (final @Nonnull Object image)
      {
        if (image.getClass().getName().equals("javax.media.jai.PlanarImage"))
          {
            return image; // BufferedImage extends RenderedImage
          }

        throw new UnsupportedOperationException("convertTo " + image.getClass());
      }
  }
