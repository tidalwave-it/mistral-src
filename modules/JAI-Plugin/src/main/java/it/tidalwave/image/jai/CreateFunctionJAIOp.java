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
package it.tidalwave.image.jai;

import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.PlanarImage;
import javax.media.jai.JAI;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.ImageFunction;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.CreateFunctionOp;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * @author  Emmanuele Sordini
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 **********************************************************************************************************************/
@Slf4j
public class CreateFunctionJAIOp extends OperationImplementation<CreateFunctionOp, PlanarImage>
  {
    class JAIImageFunctionAdapter implements javax.media.jai.ImageFunction
      {
        private ImageFunction imageFunction;
        
        public JAIImageFunctionAdapter (ImageFunction imageFunction)
          {
            this.imageFunction = imageFunction;
          }
        
        public boolean isComplex() 
          {
            return imageFunction.isComplex(); 
          } 

        public int getNumElements()
          {
            return imageFunction.getNumElements();
          } 

        public void getElements(float f, float f0, float f1, float f2, int i, int i0, int i1, float[] f3, float[] f4) 
          {
            imageFunction.getElements(f, f0, f1, f2, i, i0, i1, f3, f4);
          }

        public void getElements(double d, double d0, double d1, double d2, int i, int i0, int i1, double[] d3, double[] d4) 
          {
            imageFunction.getElements(d, d0, d1, d2, i, i0, i1, d3, d4);
          }
      }
    
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected PlanarImage execute (CreateFunctionOp operation, final EditableImage image, PlanarImage planarImage)
      {
        assert operation.getDataType() == EditableImage.DataType.FLOAT;
        
        ParameterBlock pb = new ParameterBlock();
        pb.add(new JAIImageFunctionAdapter(operation.getImageFunction()));
        pb.add(operation.getWidth());
        pb.add(operation.getHeight());
        pb.add(1.0f);
        pb.add(1.0f);
        pb.add(0.0f);
        pb.add(0.0f);

        planarImage = JAI.create("imagefunction", pb);
        JAIUtils.logImage(log, ">>>> CreateFunctionJAIOp returning", planarImage);    
        
        return planarImage;
      }
  }
