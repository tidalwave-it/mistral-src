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
 * $Id$
 *
 ******************************************************************************/
package it.tidalwave.image.jai;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import javax.media.jai.PlanarImage;
import it.tidalwave.image.ImageModel;
import it.tidalwave.image.op.AddOp;
import it.tidalwave.image.op.ApplyUnsharpMaskOp;
import it.tidalwave.image.op.AssignColorProfileOp;
import it.tidalwave.image.op.BandMergeOp;
import it.tidalwave.image.op.CenterShiftOp;
import it.tidalwave.image.op.ConvertToBufferedImageOp;
import it.tidalwave.image.op.CreateFunctionOp;
import it.tidalwave.image.op.CreateOp;
import it.tidalwave.image.op.OptimizeOp;
import it.tidalwave.image.op.ForceRenderingOp;
import it.tidalwave.image.op.ChangeFormatOp;
import it.tidalwave.image.op.ConjugateOp;
import it.tidalwave.image.op.ConvertColorProfileOp;
import it.tidalwave.image.op.ConvolveOp;
import it.tidalwave.image.op.CropOp;
import it.tidalwave.image.op.DFTOp;
import it.tidalwave.image.op.DivideByConstOp;
import it.tidalwave.image.op.DivideComplexOp;
import it.tidalwave.image.op.HistogramOp;
import it.tidalwave.image.op.IDFTOp;
import it.tidalwave.image.op.ImplementationFactory;
import it.tidalwave.image.op.ImplementationFactoryRegistry;
import it.tidalwave.image.op.MagnitudeOp;
import it.tidalwave.image.op.MultiplyComplexOp;
import it.tidalwave.image.op.MultiplyOp;
import it.tidalwave.image.op.PadBlackOp;
import it.tidalwave.image.op.PadPeriodicOp;
import it.tidalwave.image.op.PadPeriodicPlanarOp;
import it.tidalwave.image.op.PaintOp;
import it.tidalwave.image.op.RotateQuadrantOp;
import it.tidalwave.image.op.WriteOp;
import it.tidalwave.image.op.ScaleOp;
import it.tidalwave.image.op.SizeOp;
import it.tidalwave.image.op.TranslateOp;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class ImplementationFactoryJAI extends ImplementationFactory
  {
    private static ImplementationFactoryJAI instance;

    static
      {
        getInstance();
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public synchronized static ImplementationFactoryJAI getInstance ()
      {
        if (instance == null)
          {
            instance = new ImplementationFactoryJAI();
            ImplementationFactoryRegistry.getInstance().registerFactory(instance);
          }

        return instance;
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public ImplementationFactoryJAI ()
      {
        super(PlanarImage.class);
        registerImplementation(AddOp.class, AddJAIOp.class);
        registerImplementation(ApplyUnsharpMaskOp.class, ApplyUnsharpMaskJAIOp.class);
        registerImplementation(AssignColorProfileOp.class, AssignColorProfileJAIOp.class);
        registerImplementation(BandMergeOp.class, BandMergeJAIOp.class);
        registerImplementation(CenterShiftOp.class, CenterShiftJAIOp.class);
        registerImplementation(CreateOp.class, CreateJAIOp.class);
        registerImplementation(CreateFunctionOp.class, CreateFunctionJAIOp.class);
        registerImplementation(ConjugateOp.class, ConjugateJAIOp.class);
        registerImplementation(ConvertColorProfileOp.class, ConvertColorProfileJAIOp.class);
        registerImplementation(ConvertToBufferedImageOp.class, ConvertToBufferedImageJAIOp.class);
        registerImplementation(ConvolveOp.class, ConvolveJAIOp.class);
        registerImplementation(OptimizeOp.class, OptimizeJAIOp.class);
        registerImplementation(CropOp.class, CropJAIOp.class);
        registerImplementation(DFTOp.class, DFTJAIOp.class);
        registerImplementation(DivideByConstOp.class, DivideByConstJAIOp.class);
        registerImplementation(DivideComplexOp.class, DivideComplexJAIOp.class);
        registerImplementation(ForceRenderingOp.class, ForceRenderingJAIOp.class);
        registerImplementation(ChangeFormatOp.class, ChangeFormatJAIOp.class);
        registerImplementation(HistogramOp.class, HistogramJAIOp.class);
        registerImplementation(IDFTOp.class, IDFTJAIOp.class);
        registerImplementation(MagnitudeOp.class, MagnitudeJAIOp.class);
        registerImplementation(MultiplyComplexOp.class, MultiplyComplexJAIOp.class);
        registerImplementation(MultiplyOp.class, MultiplyJAIOp.class);
        registerImplementation(PadBlackOp.class, PadBlackJAIOp.class);
        registerImplementation(PadPeriodicOp.class, PadPeriodicJAIOp.class);
        registerImplementation(PadPeriodicPlanarOp.class, PadPeriodicPlanarJAIOp.class);
        registerImplementation(PaintOp.class, PaintJAIOp.class);
        registerImplementation(RotateQuadrantOp.class, RotateQuadrantJAIOp.class);
        registerImplementation(ScaleOp.class, ScaleJAIOp.class);
        registerImplementation(SizeOp.class, SizeJAIOp.class);
        registerImplementation(TranslateOp.class, TranslateJAIOp.class);
//        registerImplementation(WriteOp.class, WriteJAIOp.class);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public ImageModel createImageModel (BufferedImage bufferedImage)
      {
        return new ImageModelJAI(bufferedImage);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public boolean canConvertFrom (Class imageClass)
      {
        return RenderedImage.class.isAssignableFrom(imageClass);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public ImageModel convertFrom (Object image)
      {
        if (image instanceof RenderedImage)
          {
            return new ImageModelJAI(PlanarImage.wrapRenderedImage((RenderedImage)image));
          }

        throw new UnsupportedOperationException("");
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public boolean canConvertTo (Class imageClass)
      {
        return BufferedImage.class.isAssignableFrom(imageClass);
      }

    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public Object convertTo (Object image)
      {
        if (image instanceof BufferedImage)
          {
            return image;
          }

        throw new UnsupportedOperationException("");
      }
  }
