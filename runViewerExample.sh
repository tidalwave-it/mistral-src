#!/bin/sh
#$Id: runViewerExample.sh 1038 2009-07-06 20:21:57Z fabriziogiudici $

mvn -f Examples/ViewerExample/pom.xml -Dmaven.test.skip=true install exec:java -Dexec.mainClass=it.tidalwave.mistral.example.viewer.Main
