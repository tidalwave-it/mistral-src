package it.tidalwave.image.tools;

import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import it.tidalwave.image.tools.grammar.TIFFLexer;
import it.tidalwave.image.tools.grammar.TIFFParser;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MetadataGenerator 
  {
    private List<TIFFRecord> records;
    
    public static void main (final String ... args) 
      throws Exception
      {
        final ClassLoader loader = MetadataGenerator.class.getClassLoader();
        final InputStreamReader input = new InputStreamReader(loader.getResourceAsStream("resources/" + args[0]));
        final MetadataGenerator exifGenerator = new MetadataGenerator(input);
        final String className = args[1];
        final String path = args[2];
        final PrintWriter output = new PrintWriter(new FileWriter(String.format("%s/%s.java", path, className)));
        exifGenerator.generate(output, className);
        output.close();
      }

    public MetadataGenerator (final Reader input) 
      throws IOException, RecognitionException
      {
        final ANTLRReaderStream reader = new ANTLRReaderStream(input);
        final TIFFLexer lexer = new TIFFLexer(reader);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final TIFFParser parser = new TIFFParser(tokens);
        records = parser.prog();
      }

    private StringTemplateGroup getGroup() 
      {
        InputStream templateStream = this.getClass().getClassLoader().getResourceAsStream("resources/MetadataGenerator.stg");
        Reader templateReader = new InputStreamReader(templateStream);
        return new StringTemplateGroup(templateReader);
      }  

    public void generate (final Writer output, final String className) 
      throws IOException
      {
        final StringTemplateGroup group = getGroup();
        final StringTemplate template = group.getInstanceOf("generator");
        template.setAttribute("creation_date", new Date(0));
        template.setAttribute("class_name", className);
        template.setAttribute("records", records);
        output.write(template.toString());
      }
  }
