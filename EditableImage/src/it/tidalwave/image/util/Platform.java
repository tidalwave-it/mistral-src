/*/*******************************************************************************
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
 * $Id: Platform.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.util;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: Platform.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public final class Platform
  {
    private final static boolean macOSX = System.getProperty("os.name").toLowerCase().indexOf("mac os") >= 0;
    private final static boolean linux = System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0;

    private Platform ()
      {
      }

    public static boolean isMacOSX ()
      {
        return macOSX;
      }

    public static boolean isLinux ()
      {
        return linux;
      }
  }
