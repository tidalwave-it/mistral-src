$Id: README.txt 454 2007-02-02 12:12:42Z fabriziogiudici $
----


RUNNING THE EXAMPLES
====================

If you downloaded the sources, first compile everything by running 

	ant jar

from the command line (you need Apache Ant 1.6.5 or later). See "Compiling the sources" below.

At this point you can just run:

	runViewerExample.sh                for Un*x based systems
	runHistogramViewerExample.sh       for Un*x based systems
	runViewerExample.bat               for Windows
	runHistogramViewerExample.bat      for Windows

If you have compiled the application with NetBeans, to run the examples you can also
use the following commands:

java -Xmx512M -jar Examples/ViewerExample/dist/ViewerExample.jar
java -Xmx512M -jar Examples/HistogramViewerExample/dist/HistogramViewerExample.jar
java -jar Examples/FaxManagerExample/dist/FaxManager.jar


The former two examples load a large test image from the Internet, so you need to
be connected (the images are not included in the distribution since they are several
megabytes in size).



COMPILING THE SOURCES
=====================

Mistral can be compiled by the command line (with ant) or opening the projects with
NetBeans 5.5 or later.

Top-level tasks (to be run from the main directory):

ant jar                 compiles everything and create jar files
ant test                runs automated test
ant test-coverage       runs automated test with coverage report
ant javadoc             creates the javadocs
ant clean               cleans up everything



DIRECTORY TREE
==============

EditableImage                     sources for the core component
ImageJ-Adapter                    sources for the ImageJ plugin
JAI-Adapter                       sources for the JAI plugin
Metadata                          sources for the Metadata component
Processor                         sources for the imaging processor
Renderer                          sources for the renderer

Examples/ViewerExample            example about the renderer
Examples/HistogramViewerExample   example about histogram computation
Examples/FaxManagerExample        example about a simple editing tool
Examples/CustomOperationExample   example about custom operations
Examples/Miscellaneous            miscellaneous examples

lib				  contains third party libraries needed for compiling
tools				  contains tools for managing the project
settings			  contains Jalopy settings for formatting sources

