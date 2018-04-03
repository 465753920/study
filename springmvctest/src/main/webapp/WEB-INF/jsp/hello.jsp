<%@ page contentType="text/html; charset = UTF-8" %>

<html>
<head><title>Hello World</title></head>

<body>
Hello World!<br/>

<%--Declaration--%>
<%! int i = 0;%>
<%--Scriptlet--%>
<%
    out.println("Your IP address is " + request.getRemoteAddr());
    while (i < 10) {
        out.println(i++);
    }
    i = 0;
%>
<%--Expression--%>
<% message %>
</body>
</html>
