<%-- 
    Document   : results
    Created on : Feb 3, 2017, 6:18:12 PM
    Author     : lukasmohs
--%>

<%@page contentType="text/html" 
        pageEncoding="UTF-8"
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EAD</title>
    </head>
    <body>
        <h1> Thanks for submission <h1>
        <% if(request.getParameter("firstname")!=null && request.getParameter("lastname") != null) { %>
            <h1>Input from <i><%= request.getParameter("firstname") %> <%= request.getParameter("lastname") %> </i> :</h1>
        <% } %>
    </body>
</html>
