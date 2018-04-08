<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Date" %>
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

<%--Session--%>
<%
    // Get session creation time.
    Date createTime = new Date(session.getCreationTime());

    // Get last access time of this Webpage.
    Date lastAccessTime = new Date(session.getLastAccessedTime());

    String title = "Welcome Back to my website";
    Integer visitCount = new Integer(0);
    String visitCountKey = new String("visitCount");
    String userIDKey = new String("userID");
    String userID = new String("ABCD");

    // Check if this is new comer on your Webpage.
    if (session.isNew() || session.getAttribute(visitCountKey) == null) {
        title = "Welcome to my website";
        session.setAttribute(userIDKey, userID);
        session.setAttribute(visitCountKey, visitCount);
    }
    visitCount = (Integer) session.getAttribute(visitCountKey);
    visitCount = visitCount + 1;
    userID = (String) session.getAttribute(userIDKey);
    session.setAttribute(visitCountKey, visitCount);
%>
<div>
    <h2>Session</h2>
    <table border="1" align="center">
        <tr bgcolor="#949494">
            <th>Session info</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>id</td>
            <td><% out.print(session.getId()); %></td>
        </tr>
        <tr>
            <td>Creation Time</td>
            <td><% out.print(createTime); %></td>
        </tr>
        <tr>
            <td>Time of Last Access</td>
            <td><% out.print(lastAccessTime); %></td>
        </tr>
        <tr>
            <td>User ID</td>
            <td><% out.print(userID); %></td>
        </tr>
        <tr>
            <td>Number of visits</td>
            <td><% out.print(visitCount); %></td>
        </tr>
    </table>
</div>
</body>
</html>
