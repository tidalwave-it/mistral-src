/*
 * Main.java
 *
 * Created on November 10, 2006, 9:00 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package it.tidalwave.mistral.faxmanager;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author fritz
 */
public class Main
  {
    /** Creates a new instance of Main */
    public Main()
      {
      }
    
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) 
      throws IOException
      {
        JFrame frame = new JFrame();
        FaxApplet applet = new FaxApplet();
        applet.init();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(applet);
        frame.setSize(800, 600);
        frame.setVisible(true);
        applet.start();
      }
  }
