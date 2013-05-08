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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.image.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TIFFRecord 
  {
    private String id;
    private String tagName;
    private String type;
    private List<TIFFEnumValueName> enums = new ArrayList<TIFFEnumValueName>();
    private static ResourceBundle javaTypeDict = ResourceBundle.getBundle("resources/TIFFRecord_JavaType");
    private static final String UNDEFINED = "undefined";

    public TIFFRecord (final String id, final String tagName, final String type, final List<TIFFEnumValueName> enums) 
      {
        this.id = id;
        this.tagName = tagName;
        this.type = type.toLowerCase();
        
        if (enums != null && !enums.isEmpty()) 
          {
            this.enums.addAll(enums);
          }  
      }

    public int getId() 
      {
        try 
          {
            return Integer.parseInt(id);
          }
        catch (NumberFormatException e) 
          {
            return -1;
          }
      }

    public String getTagName() 
      {
        return tagName;
      }

    public String getType() 
      {
        if (type.equals(UNDEFINED)) 
          {
            return "byte";
          }
        
        return type;
      }

    public String getJavaType() 
      {
        if (this.isHasEnums()) 
          {
            return this.getCapitalizedTagName();
          }

        String type = getType();
        
        try 
          {
            return javaTypeDict.getString(type);
          } 
        catch (MissingResourceException e) 
          {
            return type;
          }
      }

    public String getJavaTypeToString() 
      {
        String result = "get" + this.getCapitalizedTagName() + "()";
        
        if (this.getJavaType().endsWith("[]")) 
          {
            result = "toString(" + result + ")";
          }
        
        return result;
      }

    public String getUncapitalizedTagName() 
      {
        return Utils.uncapitalized(getStrippedTagName());
      }

    public String getCapitalizedTagName() 
      {
        return Utils.capitalized(getStrippedTagName());
      }  

    public String getConstTagName() 
      {
        return Utils.strip(tagName.toUpperCase().replace(' ', '_'));
      }

    public boolean isHasEnums() 
      {
        return !enums.isEmpty();
      }

    public List<TIFFEnumValueName> getEnums() 
      {
        return new ArrayList<TIFFEnumValueName>(enums);
      }

    private String getStrippedTagName() 
      {
        return Utils.strip(tagName).replace('/', '_').replace('(', '_').replace(')', '_');
      }
  }