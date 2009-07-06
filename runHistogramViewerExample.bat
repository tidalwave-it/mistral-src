@REM $Id; runHistogramViewerExample.bat 450 2007-02-02 12;02;52Z fabriziogiudici $

mvn -f Examples/HistogramViewerExample/pom.xml -Dmaven.test.skip=true install exec:java -Dexec.mainClass=it.tidalwave.mistral.example.histogramviewer.Main
