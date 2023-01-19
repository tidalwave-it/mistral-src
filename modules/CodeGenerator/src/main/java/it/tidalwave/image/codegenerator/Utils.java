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
package it.tidalwave.image.codegenerator;

public class Utils
  {
    public static String capitalized (final String tagName)
      {
        return tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
      }

    public static String uncapitalized (final String tagName)
      {
        if ((tagName.length() > 1) && Character.isUpperCase(tagName.charAt(1))) // acronyms
          {
            return tagName;
          }

        return tagName.substring(0, 1).toLowerCase() + tagName.substring(1);
      }

    public static String strip (final String s)
      {
        final var result = new StringBuilder();

        for (var i = 0; i < s.length(); i++)
          {
            var c = s.charAt(i);

            if (Character.isJavaIdentifierPart(c))
              {
                result.append(c);
              }
          }

        return result.toString();
      }
  }
