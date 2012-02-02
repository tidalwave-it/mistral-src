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
package org.imajine.image.jai;

import javax.annotation.Nonnull;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import javax.media.jai.PlanarImage;
import org.imajine.image.ImageModel;
import org.imajine.image.op.AddOp;
import org.imajine.image.op.ApplyUnsharpMaskOp;
import org.imajine.image.op.AssignColorProfileOp;
import org.imajine.image.op.BandMergeOp;
import org.imajine.image.op.CenterShiftOp;
import org.imajine.image.op.ConvertToBufferedImageOp;
import org.imajine.image.op.CreateFunctionOp;
import org.imajine.image.op.CreateOp;
import org.imajine.image.op.OptimizeOp;
import org.imajine.image.op.ForceRenderingOp;
import org.imajine.image.op.ChangeFormatOp;
import org.imajine.image.op.ConjugateOp;
import org.imajine.image.op.ConvertColorProfileOp;
import org.imajine.image.op.ConvolveOp;
import org.imajine.image.op.CropOp;
import org.imajine.image.op.DFTOp;
import org.imajine.image.op.DivideByConstOp;
import org.imajine.image.op.DivideComplexOp;
import org.imajine.image.op.HistogramOp;
import org.imajine.image.op.IDFTOp;
import org.imajine.image.op.ImplementationFactory;
import org.imajine.image.op.MagnitudeOp;
import org.imajine.image.op.MultiplyComplexOp;
import org.imajine.image.op.MultiplyOp;
import org.imajine.image.op.PadBlackOp;
import org.imajine.image.op.PadPeriodicOp;
import org.imajine.image.op.PadPeriodicPlanarOp;
import org.imajine.image.op.PaintOp;
import org.imajine.image.op.RotateQuadrantOp;
import org.imajine.image.op.ScaleOp;
import org.imajine.image.op.SizeOp;
import org.imajine.image.op.TranslateOp;
import org.openide.util.lookup.ServiceProvider;

/***********************************************************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@ServiceProvider(service=ImplementationFactory.class)
public class ImplementationFactoryJAI extends ImplementationFactory
  {
    /*******************************************************************************************************************
     *
     *
     ******************************************************************************************************************/
    public ImplementationFactoryJAI()
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

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override @Nonnull
    public ImageModel createImageModel (final @Nonnull BufferedImage bufferedImage)
      {
        return new ImageModelJAI(bufferedImage);
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public boolean canConvertFrom (final @Nonnull Class imageClass)
      {
        return RenderedImage.class.isAssignableFrom(imageClass);
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
        if (image instanceof RenderedImage)
          {
            return new ImageModelJAI(PlanarImage.wrapRenderedImage((RenderedImage)image));
          }

        throw new UnsupportedOperationException("");
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public boolean canConvertTo (final @Nonnull Class imageClass)
      {
        return BufferedImage.class.isAssignableFrom(imageClass);
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
        if (image instanceof BufferedImage)
          {
            return image;
          }

        throw new UnsupportedOperationException("Only BufferedImage is supported");
      }
  }
