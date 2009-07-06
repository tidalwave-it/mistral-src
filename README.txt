$Id: README.txt 1039 2009-07-06 20:24:23Z fabriziogiudici $
----


COMPILE SOURCES
===============

The first operation you have to perform is to install some files in your local Maven repository.
Unfortunately this operation is needed because the files are not available in any public Maven
repository. You need to do this only once:

	mvn install:install-file -DgroupId=com.sun.media -DartifactId=jai_imageio -Dversion=1.1 -Dpackaging=jar -Dfile=lib/jai_imageio-1_1/lib/jai_imageio.jar
	mvn install:install-file -DgroupId=javax.media -DartifactId=jai_core -Dversion=1.1.3 -Dpackaging=jar -Dfile=lib/jai-1_1_3/lib/jai_core.jar
	mvn install:install-file -DgroupId=ij -DartifactId=ij -Dversion=1.37 -Dpackaging=jar -Dfile=lib/ImageJ-1.37/ij.jar


At this point you can compile Mistral by running:

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

