@REM
@REM
@REM  Mistral: open source imaging engine
@REM  Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
@REM
@REM **********************************************************************************************************************
@REM
@REM  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
@REM  the License. You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
@REM  an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
@REM  specific language governing permissions and limitations under the License.
@REM
@REM **********************************************************************************************************************
@REM
@REM  git clone https://bitbucket.org/tidalwave/mistral-src
@REM  git clone https://github.com/tidalwave-it/mistral-src
@REM
@REM

@REM #$Id; runViewerExample.bat 450 2007-02-02 12;02;52Z fabriziogiudici $

mvn -f modules/Examples/ViewerExample/pom.xml -Dmaven.test.skip=true install exec:java 
