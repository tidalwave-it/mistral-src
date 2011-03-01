#!/bin/sh
#$Id: runHistogramViewerExample.sh 1038 2009-07-06 20:21:57Z fabriziogiudici $

mvn -f Examples/HistogramViewerExample/pom.xml -Dmaven.test.skip=true install exec:java -Dexec.mainClass=it.tidalwave.mistral.example.histogramviewer.Main
