<%--


     Mistral - open source imaging engine
     Copyright (C) 2003-2012 by Tidalwave s.a.s.

    **********************************************************************************************************************

     Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
     the License. You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
     an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
     specific language governing permissions and limitations under the License.

    **********************************************************************************************************************

     WWW: http://mistral.tidalwave.it
     SCM: https://bitbucket.org/tidalwave/mistral-src


--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fax Page</title>
    </head>
    <body>

        <% request.setAttribute("path", request.getRequestURL()); %> 
        <applet width="800" height="600" 
                archive="lib/FaxManager.jar,lib/EditableImage.jar,lib/Operations.jar,lib/Contributions.jar,lib/Renderer.jar,lib/metadata-extractor-2.3.1.jar,lib/swing-layout-1.0.1.jar,lib/jai_imageio.jar,lib/clibwrapper_jiio.jar"
                code="org.imajine.mistral.faxmanager.FaxApplet">
            <param name="getFaxURL" value="${path}/../GetFax?name=${param.name}"/>
            <param name="putFaxURL" value="${path}/../PutFax"/>
            <param name="getStampURL" value="${path}/../Stamp"/>
            <param name="name" value="${param.name}"/>
            <param name="pages" value="${param.pages}"/>
        </applet>
    </body>
</html>
