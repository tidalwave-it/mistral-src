<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="it.tidalwave.mistral.faxserver.FaxManager" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fax List</title>
    </head>
    <body>
        
        Seleziona il fax:
        
        <% request.setAttribute("faxes", FaxManager.getInstance().getFaxes()); %>
        
        <ol>
            <c:forEach items="${faxes}" var="i">
                <li><a href="fax.jsp?name=${i.name}&pages=${i.pages}">${i.name} (pagine ${i.pages})</a></li>
            </c:forEach>
        </ol>

        ---
        
        <ol>
            <c:forEach items="${faxes}" var="i">
                <li><a href="fax.jsp?name=${i.name}">${i.name} (tutte le pagine)</a></li>
            </c:forEach>
        </ol>
    </body>
</html>
