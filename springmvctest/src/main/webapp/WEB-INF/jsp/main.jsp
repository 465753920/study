<%@ page import="java.util.Enumeration" %>
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
    <title>JSP Actions</title>
</head>

<body>

<%--Actions--%>

<%--jsp:include--%>
<div>
    <h2>The include action Example</h2>
    <jsp:include page="date.jsp" flush="true"/>
</div>

<%--jsp:useBean--%>
<div>
    <h2>Using JavaBeans in JSP</h2>
    <jsp:useBean id="bean1" class="org.xiaomao.entity.TestBean"></jsp:useBean>
    <jsp:setProperty name="bean1" property="message" value="你好"></jsp:setProperty>
    <p>你设置的信息是：</p>
    <jsp:getProperty name="bean1" property="message"></jsp:getProperty>
</div>

<jsp:useBean id="abc" class="org.xiaomao.entity.TestBean" scope="application"></jsp:useBean>
<jsp:getProperty name="abc" property="message"></jsp:getProperty>

<%--jsp:element--%>
<jsp:element name="div">
    <jsp:element name="h2">
        <jsp:attribute name="style">color:blue</jsp:attribute>
        <jsp:body>jsp:element test</jsp:body>
    </jsp:element>
</jsp:element>

<%--jsp:text--%>
<div>
    <jsp:text>jsp:text Test</jsp:text>
</div>

<%--Implicit Objects--%>
<div>
    <h2>Request Object</h2>
    <table border="1">
        <tr>
            <th>Headers</th>
            <th>Values</th>
        </tr>
        <%
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String name = (String) headerNames.nextElement();
                String value = request.getHeader(name);
                out.print("<tr>\n\t\t\t<td>" + name + "</td>\n\t\t\t<td>" + value + "</td>\n\t\t</tr>\n\t\t");
            }
        %>
    </table>
</div>
</body>
</html>
