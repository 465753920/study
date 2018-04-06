<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/6
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Successed!</title>
</head>
<body>
<%
    out.println("<h2>Welcome," + request.getParameter("name") + "!</h2>");
%>
</body>
</html>
