/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2007 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
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
 * $Id: ImplementationFactoryJ2D.java 924 2008-08-18 20:36:44Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.java2d;

import java.lang.reflect.Method;
import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import it.tidalwave.image.ImageModel;
import it.tidalwave.image.op.CaptureOp;
import it.tidalwave.image.op.ConvertToBufferedImageOp;
import it.tidalwave.image.op.ConvolveOp;
import it.tidalwave.image.op.CreateOp;
import it.tidalwave.image.op.CropOp;
import it.tidalwave.image.op.DrawOp;
import it.tidalwave.image.op.ImplementationFactory;
import it.tidalwave.image.op.ImplementationFactoryRegistry;
import it.tidalwave.image.op.OptimizeOp;
import it.tidalwave.image.op.PaintOp;
import it.tidalwave.image.op.PrintOp;
import it.tidalwave.image.op.RotateOp;
import it.tidalwave.image.op.RotateQuadrantOp;
import it.tidalwave.image.op.ScaleOp;
import it.tidalwave.image.op.WrapOp;
import it.tidalwave.image.op.WriteOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ImplementationFactoryJ2D.java 924 2008-08-18 20:36:44Z fabriziogiudici $
 *
 ******************************************************************************/
public class ImplementationFactoryJ2D extends ImplementationFactory
  {
    private static final String CLASS = ImplementationFactoryJ2D.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);
    private static ImplementationFactoryJ2D instance;
    private Class planarImageClass;

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public synchronized static ImplementationFactoryJ2D getInstance ()
      {
        if (instance == null)
          {
            instance = new ImplementationFactoryJ2D();
            ImplementationFactoryRegistry.getInstance().registerFactory(instance);
          }

        return instance;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public ImplementationFactoryJ2D ()
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

        try
          {
            planarImageClass = Class.forName("javax.media.jai.PlanarImage");
          }
        catch (Throwable e)
          {
            logger.warning("JAI not available: " + e);
          }

        try
          {
            Class clazz = Class.forName("it.tidalwave.image.java2d.AdditionalOperations");
            Method method = clazz.getMethod("register", ImplementationFactoryJ2D.class);
            method.invoke(null, this);
          }
        catch (Throwable e)
          {
            logger.warning("Additional Java2D operations not available: " + e);
          }
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public ImageModel createImageModel (BufferedImage bufferedImage)
      {
        return new ImageModelJ2D(bufferedImage);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public boolean canConvertFrom (Class imageClass)
      {
        return imageClass.equals(BufferedImage.class) ||
        ((planarImageClass != null) && planarImageClass.isAssignableFrom(imageClass));
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public ImageModel convertFrom (Object image)
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
                Method method = planarImageClass.getMethod("getAsBufferedImage");
                Object bufferedImage = method.invoke(image);

                return new ImageModelJ2D(bufferedImage);
              }
            catch (Exception e)
              {
                throw new UnsupportedOperationException(e);
              }
          }

        throw new UnsupportedOperationException("convertFrom " + image.getClass());
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public boolean canConvertTo (Class imageClass)
      {
        return (planarImageClass != null) && planarImageClass.isAssignableFrom(imageClass); // image instanceof PlanarImage
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public Object convertTo (Object image)
      {
        if (image.getClass().getName().equals("javax.media.jai.PlanarImage"))
          {
            return image; // BufferedImage extends RenderedImage
          }

        throw new UnsupportedOperationException("convertTo " + image.getClass());
      }
  }
