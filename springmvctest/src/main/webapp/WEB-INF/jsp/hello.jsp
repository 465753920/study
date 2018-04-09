<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/9
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello JSP</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    if (name != null) {
        request.setAttribute("name", name);
        session.setAttribute("name", name);
        application.setAttribute("name", name);
        pageContext.setAttribute("name", name);
    }
%>
<h2>Request Name: <%= request.getAttribute("name")%>
</h2>
<h2>Session Name: <%= session.getAttribute("name")%>
</h2>
<h2>Application Name: <%= application.getAttribute("name")%>
</h2>
<h2>Page Name: <%= pageContext.getAttribute("name")%>
</h2>
</body>
</html>
