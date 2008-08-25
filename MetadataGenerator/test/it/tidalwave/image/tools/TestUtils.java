package it.tidalwave.image.tools;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestUtils 
  {
    @Test
    public void uncapitalized() 
      {
        assertEquals("tESTO", Utils.uncapitalized("TESTO"));
        assertEquals("testo", Utils.uncapitalized("Testo"));
      }

    @Test
    public void capitalized()  
      {
        assertEquals("TESTO", Utils.capitalized("TESTO"));
        assertEquals("Testo", Utils.capitalized("testo"));
      }

    @Test
    public void strip() 
      {
        assertEquals("TESTODIFUOCO", Utils.strip("TESTO DI FUOCO"));
        assertEquals("testo_Matto", Utils.strip("testo_Matto"));
      }
  }
