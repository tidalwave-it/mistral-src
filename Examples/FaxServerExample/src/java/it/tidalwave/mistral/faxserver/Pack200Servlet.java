/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tidalwave.mistral.faxserver;

import java.io.*;

import java.util.Date;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author bw
 */
public class Pack200Servlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(Pack200Servlet.class.getName());
    private static final String JNLP_MIME_TYPE = "application/x-java-jnlp-file";
    private static final String JAR_MIME_TYPE = "application/x-java-archive";
    private static final String PACK200_MIME_TYPE = "application/x-java-pack200";

    // HTTP Compression RFC 2616 : Standard headers
    public static final String ACCEPT_ENCODING = "accept-encoding";
    public static final String CONTENT_TYPE = "content-type";
    public static final String CONTENT_ENCODING = "content-encoding";

    // HTTP Compression RFC 2616 : Standard header for HTTP/Pack200 Compression
    public static final String GZIP_ENCODING = "gzip";
    public static final String PACK200_GZIP_ENCODING = "pack200-gzip";
    private Date startupTime;

    // Array che contiene i nomi dei jar "pesanti" che non sono stati mai modificati.
    // Questi jar, se sono stati caricati almeno una volta sul client, non vengono reinviati più
    private static final String[] neverModifiedJars = {"spring.jar", "batik-all.jar"};

    @Override
    public void init() throws ServletException {
        super.init();
        startupTime = new Date();
    }

    private void sendHtml(HttpServletResponse response, String s)
            throws IOException {
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>ContentType</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(s);
        out.println("</body>");
        out.println("</html>");
    }

    /* 
     * Copy the inputStream to output ,
     */
    private void sendOut(InputStream in, OutputStream ostream)
            throws IOException {
        byte buf[] = new byte[8192];

        int n = in.read(buf);
        while (n > 0) {
            ostream.write(buf, 0, n);
            n = in.read(buf);
        }
        ostream.close();
        in.close();
    }

    File doFile(String name, HttpServletResponse response) {
        File f = new File(name);
        if (f.exists()) {
            log.info("Found file " + name);

            response.setContentLength(Integer.parseInt(
                    Long.toString(f.length())));

            response.setDateHeader("Last-Modified", startupTime.getTime());
            return f;
        }
        log.info("File not found " + name);
        return f;
    }

    /** Called when someone accesses the servlet. */
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String encoding = request.getHeader(ACCEPT_ENCODING);
        String pathInfo = System.getProperty("catalina.base") + "/webapps/FaxServerExample/lib/" +
                request.getRequestURI().replaceAll(".*/", "");
        String pathInfoEx = pathInfo;
        String contentType = request.getContentType();
        StringBuffer requestURL = request.getRequestURL();
        String requestName = pathInfo;
        String idSession=request.getSession().getId();
        
        log.info("-----------------------------------------------------------");
        log.info("idSession=" + idSession+" pathInfo=" + pathInfo);
        log.info("pathInfoEx=" + pathInfoEx);
        log.info("Accept-Encoding=" + encoding+" requestURL=" + requestURL);
        log.info("Content-Type=" + contentType);
        //log.info("requestURL=" + requestURL);

        long ifModifiedSince = request.getDateHeader("If-Modified-Since");

        if (ifModifiedSince >= 0) {
            final Date date = new Date(ifModifiedSince);
            log.info("If-Modified-Since=" + date + " " + date.getTime());
            log.info("startup time=     " + startupTime + " " + startupTime.getTime());

            log.info("Checking if "+pathInfo+" was never modified...");
            for (int i = 0; i < neverModifiedJars.length; i++) {
                if (pathInfo.endsWith("/" + neverModifiedJars[i])) {
                    log.info("Requested document neverModified, sending HTTP " + HttpServletResponse.SC_NOT_MODIFIED);
                    response.sendError(HttpServletResponse.SC_NOT_MODIFIED);
                    return;
                }
            }

            // E.g. IExplorer tronca il time stamp al secondo, quindi anche noi
            // arretriamo per sicurezza.
            if (startupTime.getTime() - 1000 <= date.getTime()) {
                log.info("Requested document not changed, sending HTTP " + HttpServletResponse.SC_NOT_MODIFIED);
                response.sendError(HttpServletResponse.SC_NOT_MODIFIED);
                return;
            }
        }

        log.info("Sending the requested document");

        if (pathInfoEx == null) {
            response.sendError(response.SC_NOT_FOUND);
            return;
        }
        String outFile = pathInfo;
        boolean found = false;
        String contentEncoding = null;

        File f = null;

        // Pack200 Compression
        if (encoding != null && contentType != null &&
                contentType.compareTo(JAR_MIME_TYPE) == 0 &&
                encoding.toLowerCase().indexOf(PACK200_GZIP_ENCODING) > -1) {

            contentEncoding = PACK200_GZIP_ENCODING;


            f = doFile(pathInfoEx.concat(".pack.gz"), response);

            if (f != null) {
                outFile = pathInfo.concat(".pack.gz");
                found = true;
            } else {
                // Pack/Compress and transmit, not very efficient.
                found = false;
            }
        }

        // HTTP Compression
        if (found == false && encoding != null &&
                contentType != null &&
                contentType.compareTo(JAR_MIME_TYPE) == 0 &&
                encoding.toLowerCase().indexOf("gzip") > -1) {

            contentEncoding = GZIP_ENCODING;

            f = doFile(pathInfoEx.concat(".gz"), response);
            if (f != null) {
                outFile = pathInfo.concat(".gz");
                found = true;
            }
        }

        // No Compression
        if (f == null) { // just send the file

            contentEncoding = null;
            log.info(CONTENT_ENCODING + "=" + "null");
            f = doFile(pathInfoEx, response);
            outFile = pathInfo;
        }

        response.setHeader(CONTENT_ENCODING, contentEncoding);
        log.info(CONTENT_ENCODING + "=" + contentEncoding +
                " : outFile=" + outFile);

        ServletContext sc = getServletContext();

        if (sc.getMimeType(pathInfo) != null) {
            response.setContentType(sc.getMimeType(pathInfo));
        }

        InputStream in=null;
        OutputStream out=null;
        try {
          in = new FileInputStream(f); // sc.getResourceAsStream(outFile);

          out = response.getOutputStream();
        }catch (FileNotFoundException ex){
            log.info("File not found:"+f);            
        }

        if (in != null) {
            try {
                sendOut(in, out);
            } catch (IOException ioe) {
                if ("Broken pipe".equals(ioe.getMessage())) {
//                if (ioe.getMessage().compareTo("Broken pipe") == 0) {
                    log.info("Broken Pipe while writing");
                    return;
                } else {
                    throw ioe;
                }
            }
        } else {
            response.sendError(response.SC_NOT_FOUND);
        }
    }
}