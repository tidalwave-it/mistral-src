/*
 * *********************************************************************************************************************
 *
 * Mistral: open source imaging engine
 * http://tidalwave.it/projects/mistral
 *
 * Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
 *
 * *********************************************************************************************************************
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
 * *********************************************************************************************************************
 *
 * git clone https://bitbucket.org/tidalwave/mistral-src
 * git clone https://github.com/tidalwave-it/mistral-src
 *
 * *********************************************************************************************************************
 */
package it.tidalwave.image.java2d.performance;

import javax.annotation.Nonnull;
import java.time.Duration;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.OptimizeOp;
import it.tidalwave.image.util.Platform;
import lombok.extern.slf4j.Slf4j;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public abstract class BasePerformanceTestSupport extends BaseTestSupport
  {
    private static final String host;
    private static final String os;

    static
      {
        os = Platform.isLinux() ? "Linux Ubuntu" : Platform.isMacOSX() ? "Mac OS X" : "Win XP";
        var h = "???";

        try
          {
            h = InetAddress.getLocalHost().getHostName();
            final var i = h.indexOf('.');

            if (i >= 0)
              {
                h = h.substring(0, i);
              }
          }
        catch (UnknownHostException ex)
          {
            ex.printStackTrace();
          }
        host = h;
      }


    private String getClassName()
      {
        var name = getClass().getName();
        var i = name.lastIndexOf('.');

        if (i >= 0)
          {
            name = name.substring(i + 1);
          }

        i = name.indexOf("PerformanceTest");

        if (i >= 0)
          {
            name = name.substring(0, i);
          }

        return name;
      }

    @Test
    public void testPerformance()
      {
        for (final var quality : Quality.values())
          {
            final var name = getClassName();
            log.info(name + " running");

            AssertJUnit.assertEquals(PixelInterleavedSampleModel.class,
                                     img20030701_0043_jpg.getInnerProperty(SampleModel.class).getClass());
            final var time = runTest(img20030701_0043_jpg);
            log.info(name + img20030701_0043_jpg);
            log.info("STATS: " + "VERSION" + "::" + host + "::" + os + "::" + name + "::" + quality + "::" +
                     file_20030701_0043_jpg.getFileName() + "=" + time);
          }
      }

    @Test
    public void testOptimizedPerformance()
      {
        for (final var quality : Quality.values())
          {
            final var name = getClassName() + " (opt)";
            log.info(name + " running");

            final var optimizedImage = img20030701_0043_jpg.execute(new OptimizeOp());
            AssertJUnit.assertEquals(SinglePixelPackedSampleModel.class,
                                     optimizedImage.getInnerProperty(SampleModel.class).getClass());
            final var time = runTest(optimizedImage);
            log.info(name + optimizedImage);
            log.info("STATS: " + "VERSION" + "::" + host + "::" + os + "::" + name + "::" + quality + "::" +
                     file_20030701_0043_jpg.getFileName() + "=" + time);
          }
      }

    @Nonnull
    protected abstract Duration runTest (@Nonnull EditableImage image);
  }
