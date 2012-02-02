====

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

     WWW: http://mistral.imajine.org
     SCM: https://bitbucket.org/tidalwave/mistral-src

====

$Id$
----


COMPILE SOURCES
===============

You can compile Mistral by running:

	mvn -DskipTests=true clean install

You need Maven 3.0.3 or later.


RUNNING EXAMPLES
================

A few scripts for U*ix and Windows systems are provided to quickly run examples:

+ runViewerExample.sh
+ runHistogramViewerExample.sh 
+ runViewerExample.bat 
+ runHistogramViewerExample.bat 


DIRECTORY TREE
==============

modules/Core                              sources for the core component
modules/ImageJ-Plugin                     sources for the ImageJ plugin
modules/JAI-Plugin                        sources for the JAI plugin
modules/Metadata                          sources for the Metadata component
modules/Processor                         sources for the imaging processor
modules/Renderer                          sources for the renderer

modules/Examples/ViewerExample            example about the renderer
modules/Examples/HistogramViewerExample   example about histogram computation
modules/Examples/FaxManagerExample        example about a simple editing tool
modules/Examples/CustomOperationExample   example about custom operations
modules/Examples/Miscellaneous            miscellaneous examples
