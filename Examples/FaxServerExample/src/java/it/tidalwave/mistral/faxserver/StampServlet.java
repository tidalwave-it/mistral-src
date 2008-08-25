package it.tidalwave.mistral.faxserver;
/*
 * StampServlet.java
 *
 * Created on April 5, 2007, 10:56 PM
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author fritz
 * @version
 */
public class StampServlet extends HttpServlet
  {
    private static int counter;
    
    protected void processRequest (final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException
      {
        response.setContentType("text/plain");
        final PrintWriter out = response.getWriter();
        String s = "000000" + counter++;
        s = s.substring(s.length() - 4);
        out.println(s);
        out.close();
      }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
      {
        processRequest(request, response);
      }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
      {
        processRequest(request, response);
      }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo ()
      {
        return "Short description";
      }

    // </editor-fold>
  }
