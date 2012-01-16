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

import java.util.logging.Logger;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.TransposeDescriptor;
import javax.media.jai.operator.TransposeType;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.op.OperationImplementation;
import it.tidalwave.image.op.RotateQuadrantOp;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class RotateQuadrantJAIOp extends OperationImplementation<RotateQuadrantOp, PlanarImage>
  {
    private static final String CLASS = RotateQuadrantJAIOp.class.getName();
    
    private static final Logger logger = Logger.getLogger(CLASS);
            
    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected PlanarImage execute (RotateQuadrantOp operation, final EditableImage image, PlanarImage planarImage)
      {
        int degrees = operation.getDegrees();
        logger.fine("rotateQuadrant(" + degrees + ") - " + planarImage.getSampleModel());

        if (degrees != 0)
          {
            TransposeType transposeType = null;

            if (degrees == 90)
              {
                transposeType = TransposeDescriptor.ROTATE_90;
              }

            else if (degrees == 180)
              {
                transposeType = TransposeDescriptor.ROTATE_180;
              }

            else if (degrees == 270)
              {
                transposeType = TransposeDescriptor.ROTATE_270;
              }

            else
              {
                throw new IllegalArgumentException("degrees: " + degrees);
              }

            planarImage = TransposeDescriptor.create(planarImage, transposeType, null); // FIXME: hints
            JAIUtils.logImage(logger, ">>>>   rotateQuadrant() returning", planarImage);
          }

        return planarImage;
      }
  }
