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

public class TIFFEnumValueName
  {
    private String value;
    private String name;

    public TIFFEnumValueName (final String value, String name)
      {
        this.value = value;
        this.name = name;
      }

    public String getValue()
      {
        return value;
      }

    public String getName()
      {
        return name;
      }

    public String getIdentifierName()
      {
        if (name != null)
          {
            return name.replace(' ', ' ').
                       replace('-', ' ').
                       replace('(', ' ').
                       replace(')', ' ').
                       replace('/', ' ').
                       trim().replace(' ', '_').toUpperCase();
          }

        return "";
      }

    @Override
    public String toString()
      {
        return value + "=" + name;
      }
  }
