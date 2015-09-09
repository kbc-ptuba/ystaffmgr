<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="classes.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <h1>Chart.jsp</h1>
<jsp:useBean id="classes" class="classes.Graph"/>
<img src="<%= System.getProperty("java.io.tmpdir") + "/" + classes.getName() %>" alt="test image" usemap="#test" border="0"/>
    </body>
</html>