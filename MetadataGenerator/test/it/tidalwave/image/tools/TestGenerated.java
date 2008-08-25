package it.tidalwave.image.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestGenerated 
  {
    @Test
    public void generateAntlr() 
      throws Exception 
      {
        final ClassLoader loader = this.getClass().getClassLoader();
        final InputStreamReader input = new InputStreamReader(loader.getResourceAsStream("resources/TIFF.properties"));
        MetadataGenerator exifGenerator = new MetadataGenerator(input);
        final StringWriter output = new StringWriter();
        exifGenerator.generate(output);

        final String expected = readAll(loader.getResourceAsStream("resources/EXIFDirectoryGenerated.txt"));
        assertTrue(expected.equals(output.toString()));
      }

    private String readAll (final InputStream inStream) 
      {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        final StringWriter writer = new StringWriter();
        final PrintWriter pw = new PrintWriter(writer);
        
        try 
          {
            String line;
            while ((line = reader.readLine()) != null) 
              {
                pw.println(line);
              }
          }
        catch (IOException e) 
          {
            System.out.println(e);
          }
        
        pw.flush();
        pw.close();
        
        return writer.toString();
      }
  }
