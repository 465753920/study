<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head><title>Hello World</title></head>

<body>
Hello World!<br/>

<%--Expression Language--%>
${message}

<%--Declaration--%>
<%! int i = 0;%>
<%--Scriptlet--%>
<%
    out.println("你的IP地址是：" + request.getRemoteAddr());
    while (i < 10) {
        out.println(i++);
    }
    i = 0;
%>
</body>
</html>
