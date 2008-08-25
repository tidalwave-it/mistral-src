#!/bin/sh
#$Id: runViewerExample.sh 453 2007-02-02 12:12:22Z fabriziogiudici $

java -Xmx512M -cp EditableImage/dist/EditableImage.jar:Metadata/dist/Metadata.jar:Renderer/dist/Renderer.jar:Examples/ViewerExample/dist/ViewerExample.jar:lib/metadata-extractor/metadata-extractor-2.3.1.jar:lib/swing-layout/swing-layout-1.0.1.jar it.tidalwave.mistral.example.viewer.Main
