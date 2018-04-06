<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/6
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>get提交</h2>
<form action="login" method="get">
    名字：<input type="text" name="name">
    <br/>
    密码：<input type="password" name="passwd">
    <input type="submit" value="提交">
</form>
<h2>post提交</h2>
<form action="login" method="post">
    名字：<input type="text" name="name">
    <br/>
    密码：<input type="password" name="passwd">
    <input type="submit" value="提交">
</form>
</body>
</html>
