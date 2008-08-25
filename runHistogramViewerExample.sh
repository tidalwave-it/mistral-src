#!/bin/sh
#$Id: runHistogramViewerExample.sh 469 2007-02-02 14:31:35Z fabriziogiudici $

java -Xmx512M -cp EditableImage/dist/EditableImage.jar:Operations/dist/Operations.jar:Renderer/dist/Renderer.jar:lib/metadata-extractor/metadata-extractor-2.3.1.jar:lib/swing-layout/swing-layout-1.0.1.jar:lib/jai-1_1_3/lib/jai_core.jar:lib/jai-1_1_3/lib/mlibwrapper_jai.jar:Examples/ViewerExample/dist/ViewerExample.jar:Examples/HistogramViewerExample/dist/HistogramViewerExample.jar it.tidalwave.mistral.example.histogramviewer.Main
