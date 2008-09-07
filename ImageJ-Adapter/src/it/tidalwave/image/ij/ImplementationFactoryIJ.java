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
 * $Id: ImplementationFactoryIJ.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.ij;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import ij.ImagePlus;
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
import it.tidalwave.image.op.TranslateOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: ImplementationFactoryIJ.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public class ImplementationFactoryIJ extends ImplementationFactory
  {
    private static ImplementationFactoryIJ instance;
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public static ImplementationFactoryIJ getInstance()
      {
        if (instance == null)
          {
            instance = new ImplementationFactoryIJ();    
            ImplementationFactoryRegistry.getInstance().registerFactory(instance);
          }
        
        return instance;  
      }
    
    /*******************************************************************************
     *
     *
     ******************************************************************************/
    public ImplementationFactoryIJ()
      {
        super(ImagePlus.class);
        registerImplementation(AddOp.class, AddIJOp.class);
        registerImplementation(ApplyUnsharpMaskOp.class, ApplyUnsharpMaskIJOp.class);
        registerImplementation(AssignColorProfileOp.class, AssignColorProfileIJOp.class);
        registerImplementation(BandMergeOp.class, BandMergeIJOp.class);
        registerImplementation(CenterShiftOp.class, CenterShiftIJOp.class);
        registerImplementation(CreateOp.class, CreateIJOp.class);
        registerImplementation(CreateFunctionOp.class, CreateFunctionIJOp.class);
        registerImplementation(ConjugateOp.class, ConjugateIJOp.class);
        registerImplementation(ConvertColorProfileOp.class, ConvertColorProfileIJOp.class);
        registerImplementation(ConvertToBufferedImageOp.class, ConvertToBufferedImageIJOp.class);
        registerImplementation(ConvolveOp.class, ConvolveIJOp.class);
        registerImplementation(OptimizeOp.class, OptimizeIJOp.class);
        registerImplementation(CropOp.class, CropIJOp.class);
        registerImplementation(DFTOp.class, DFTIJOp.class);
        registerImplementation(DivideByConstOp.class, DivideByConstIJOp.class);
        registerImplementation(DivideComplexOp.class, DivideComplexIJOp.class);
        registerImplementation(ForceRenderingOp.class, ForceRenderingIJOp.class);
        registerImplementation(ChangeFormatOp.class, ChangeFormatIJOp.class);
        registerImplementation(HistogramOp.class, HistogramIJOp.class);
        registerImplementation(IDFTOp.class, IDFTIJOp.class);
        registerImplementation(MagnitudeOp.class, MagnitudeIJOp.class);
        registerImplementation(MultiplyComplexOp.class, MultiplyComplexIJOp.class);
        registerImplementation(MultiplyOp.class, MultiplyIJOp.class);
        registerImplementation(PadBlackOp.class, PadBlackIJOp.class);
        registerImplementation(PadPeriodicOp.class, PadPeriodicIJOp.class);
        registerImplementation(PadPeriodicPlanarOp.class, PadPeriodicPlanarIJOp.class);
        registerImplementation(PaintOp.class, PaintIJOp.class);
        registerImplementation(RotateQuadrantOp.class, RotateQuadrantIJOp.class);
        registerImplementation(WriteOp.class, WriteIJOp.class);
        registerImplementation(ScaleOp.class, ScaleIJOp.class);
        registerImplementation(TranslateOp.class, TranslateIJOp.class);
      }

    /***************************************************************************
     *
     *
     **************************************************************************/
    public ImageModel createImageModel (BufferedImage bufferedImage)
      {
        return new ImageModelIJ(bufferedImage);
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
        throw new RuntimeException("Not implemented");
//        if (image instanceof RenderedImage)
//          {
//            return new ImageModelIJ(ImagePlus.wrapRenderedImage((RenderedImage)image));
//          }
        
//        throw new UnsupportedOperationException("");
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
