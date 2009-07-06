@REM #$Id; runViewerExample.bat 450 2007-02-02 12;02;52Z fabriziogiudici $

mvn -f Examples/ViewerExample/pom.xml -Dmaven.test.skip=true install exec:java -Dexec.mainClass=it.tidalwave.mistral.example.viewer.Main
