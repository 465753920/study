<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.TimeZone" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/6
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clock</title>
</head>
<body>
<div>
    <%
        response.setIntHeader("Refresh", 5);

        Calendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        String timeStr = hour + ":" + minute + ":" + second;
        out.println("<h2>现在的时间是：" + timeStr + "</h2>");
    %>
</div>
</body>
</html>
