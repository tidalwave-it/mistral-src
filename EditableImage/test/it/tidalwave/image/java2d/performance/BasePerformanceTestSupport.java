/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2006 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
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
 * $Id: BasePerformanceTestSupport.java 688 2007-06-16 13:38:50Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.image.java2d.performance;

import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.SampleModel;
import java.net.InetAddress;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.OptimizeOp;
import it.tidalwave.image.util.Platform;
import java.net.UnknownHostException;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: BasePerformanceTestSupport.java 688 2007-06-16 13:38:50Z fabriziogiudici $
 *
 ******************************************************************************/
public abstract class BasePerformanceTestSupport extends BaseTestSupport 
  {
    private final static String host;
    private final static String os;
    
    static
      {
        os = Platform.isLinux() ? "Linux Ubuntu" : Platform.isMacOSX() ? "Mac OS X" : "Win XP";
        String h ="???";
        
        try 
          {
            h = InetAddress.getLocalHost().getHostName();
            int i = h.indexOf('.');

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
    
    public BasePerformanceTestSupport (final String name)
      {
        super(name);  
      }
   
    private String getClassName()
      {
        String name = getClass().getName();
        int i = name.lastIndexOf('.');

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
    
    public void testPerformance() 
      {
        for (Quality quality : Quality.values())
          {
            String name = getClassName();
            log(name  + " running");

            assertEquals(PixelInterleavedSampleModel.class, 
                         img20030701_0043_jpg.getInnerProperty(SampleModel.class).getClass());
            long time = runTest(img20030701_0043_jpg);
            log(name + img20030701_0043_jpg);
            log("STATS: " + "VERSION" + "::" + host + "::" + os + "::" + name + "::" + quality + "::" + file_20030701_0043_jpg.getName() + "=" + time);
          }
      }    
    
    public void testOptimizedPerformance() 
      {
        for (Quality quality : Quality.values())
          {
            String name = getClassName() + " (opt)";
            log(name  + " running");

            EditableImage optimizedImage = img20030701_0043_jpg.execute2(new OptimizeOp());
            assertEquals(SinglePixelPackedSampleModel.class, 
                         optimizedImage.getInnerProperty(SampleModel.class).getClass());
            long time = runTest(optimizedImage);
            log(name + optimizedImage);
            log("STATS: " + "VERSION" + "::" + host + "::" + os + "::" + name + "::" + quality + "::" + file_20030701_0043_jpg.getName() + "=" + time);
          }
      }    
    
    protected abstract long runTest (EditableImage image);
  }
