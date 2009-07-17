$Id: README.txt 1067 2009-07-17 13:24:38Z fabriziogiudici $
----


COMPILE SOURCES
===============

You can compile Mistral by running:

	mvn -Dmaven.test.skip=true clean install

You need Maven 2.0.10 or later.


RUNNING EXAMPLES
================

A few scripts for U*ix and Windows systems are provided to quickly run examples:

+ runViewerExample.sh
+ runHistogramViewerExample.sh 
+ runViewerExample.bat 
+ runHistogramViewerExample.bat 


DIRECTORY TREE
==============

Core                              sources for the core component
ImageJ-Plugin                     sources for the ImageJ plugin
JAI-Plugin                        sources for the JAI plugin
Metadata                          sources for the Metadata component
Processor                         sources for the imaging processor
Renderer                          sources for the renderer

Examples/ViewerExample            example about the renderer
Examples/HistogramViewerExample   example about histogram computation
Examples/FaxManagerExample        example about a simple editing tool
Examples/CustomOperationExample   example about custom operations
Examples/Miscellaneous            miscellaneous examples

lib				  contains third party libraries needed for compiling
etc				  contains Jalopy settings for formatting sources and other stuff

