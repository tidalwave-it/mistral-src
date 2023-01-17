/*
 * *********************************************************************************************************************
 *
 * Mistral: open source imaging engine
 * http://tidalwave.it/projects/mistral
 *
 * Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
 *
 * *********************************************************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * *********************************************************************************************************************
 *
 * git clone https://bitbucket.org/tidalwave/mistral-src
 * git clone https://github.com/tidalwave-it/mistral-src
 *
 * *********************************************************************************************************************
 */
package it.tidalwave.image.codegenerator;

import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import it.tidalwave.image.codegenerator.grammar.TIFFLexer;
import it.tidalwave.image.codegenerator.grammar.TIFFParser;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MetadataGenerator
  {
    private List<TIFFRecord> records;

    public static void main (final String... args)
            throws Exception
      {
        System.out.println("METADATAGENERATOR" );
        final String className = args[0];
        final String source = args[1];
        final String template = args[2];
        final String output = args[3];
        final Path outputFile = new File(String.format("%s/%s.java", output, className)).toPath();
        Files.createDirectories(outputFile.getParent());

        System.out.println("    CLASS NAME: " + className);
        System.out.println("    SOURCE:     " + source);
        System.out.println("    TEMPLATE:   " + template);
        System.out.println("    OUTPUT      " + outputFile);

        try (final Reader r = Files.newBufferedReader(Paths.get(source));
             final PrintWriter pw = new PrintWriter(Files.newBufferedWriter(outputFile)))
          {
            new MetadataGenerator(r).generate(pw, className, template);
          }
      }

    public MetadataGenerator (final Reader input)
            throws IOException, RecognitionException
      {
        final ANTLRInputStream reader = new ANTLRInputStream(input);
        final TIFFLexer lexer = new TIFFLexer(reader);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final TIFFParser parser = new TIFFParser(tokens);
        System.out.println("    PARSING ...");
        records = parser.prog().result;
      }

    public void generate (final Writer output, final String className, final String template)
            throws IOException
      {
        System.out.println("    GENERATING CODE...");
        final STGroup group = new STGroupFile(Paths.get(template).toAbsolutePath().toString(), '$' ,'$');
        final ST st = group.getInstanceOf("generator");
        st.add("creation_date", new Date());
        st.add("class_name", className);
        st.add("records", records);
        output.write(st.render());
      }
  }
