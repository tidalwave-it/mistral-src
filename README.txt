$Id: README.txt 1018 2009-06-29 16:59:49Z fabriziogiudici $
----


COMPILE SOURCES
===============

If you downloaded the sources, first compile everything by running 

	mvn install

from the command line (you need Apache Ant 1.6.5 or later). See "Compiling the sources" below.



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
settings			  contains Jalopy settings for formatting sources and other stuff

