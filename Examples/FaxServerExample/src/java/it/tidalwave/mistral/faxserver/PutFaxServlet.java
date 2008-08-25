/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 * 
 *******************************************************************************
 *
 * Copyright (C) 2003-2007 by Fabrizio Giudici (Fabrizio.Giudici@tidalwave.it)
 *                        and Emmanuele Sordini (Emmanuele@Sordini.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 *******************************************************************************
 * 
 * $Id: PutFaxServlet.java 530 2007-03-29 23:02:03Z fabriziogiudici $
 * 
 ******************************************************************************/
package it.tidalwave.mistral.faxserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id: PutFaxServlet.java 530 2007-03-29 23:02:03Z fabriziogiudici $
 *
 ******************************************************************************/
public class PutFaxServlet extends HttpServlet
  {
    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
      {
        final DataInputStream dis = new DataInputStream(request.getInputStream());
        final String name = dis.readUTF();
        final OutputStream os = FaxManager.getInstance().getOutputStream(name);
        final byte[] buffer = new byte[256 * 1024];

        for (;;)
          {
            final int n = dis.read(buffer);

            if (n <= 0)
              {
                break;
              }

            os.write(buffer, 0, n);
          }

        dis.close();
        os.close();
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
