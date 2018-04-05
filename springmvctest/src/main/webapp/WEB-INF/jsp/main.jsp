<%--
  Created by IntelliJ IDEA.
  User: ShenQiuS
  Date: 2018/4/4
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The include Action Example</title>
</head>

<body>
<%--Actions--%>
<center>
    <h2>The include action Example</h2>
    <jsp:include page="date.jsp" flush="true"/>
</center>
<center>
    <h2>Using JavaBeans in JSP</h2>
    <jsp:useBean id="bean1" class="org.xiaomao.entity.TestBean"></jsp:useBean>
    <jsp:setProperty name="bean1" property="message" value="你好"></jsp:setProperty>
    <p>你设置的信息是：</p>
    <jsp:getProperty name="bean1" property="message"></jsp:getProperty>
</center>
</body>
</html>
