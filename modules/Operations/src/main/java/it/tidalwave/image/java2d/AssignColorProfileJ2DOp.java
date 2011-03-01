/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2011 by Tidalwave s.a.s.
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
 * SCM: https://kenai.com/hg/mistral~src
 *
 **********************************************************************************************************************/
package it.tidalwave.image.java2d;

import java.util.logging.Logger;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.ImageUtils;
import it.tidalwave.image.op.AssignColorProfileOp;
import it.tidalwave.image.op.OperationImplementation;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class AssignColorProfileJ2DOp extends OperationImplementation<AssignColorProfileOp, BufferedImage>
  {
    private static final String CLASS = AssignColorProfileJ2DOp.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS);

    /*******************************************************************************
     *
     * @inheritDoc
     *
     ******************************************************************************/
    protected BufferedImage execute (AssignColorProfileOp operation, final EditableImage image, BufferedImage bufferedImage)
      {
        ICC_Profile colorProfile = operation.getICCProfile();
        logger.fine("assignColorProfile(" + ImageUtils.getICCProfileName(colorProfile) + ")");
        Java2DUtils.logImage(logger, ">>>> source bufferedImage", bufferedImage);

        ColorSpace colorSpace = new ICC_ColorSpace(colorProfile);
        ColorModel colorModel = new ComponentColorModel(colorSpace, false, false, ColorModel.OPAQUE,
                bufferedImage.getRaster().getDataBuffer().getDataType());
        bufferedImage = new BufferedImage(colorModel, bufferedImage.getRaster(), false,
                Java2DUtils.getProperties(bufferedImage));
        Java2DUtils.logImage(logger, ">>>> assignColorProfile() returning ", bufferedImage);

        return bufferedImage;
      }
  }
