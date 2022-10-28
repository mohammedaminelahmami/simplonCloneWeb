<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 10/27/2022
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test DB Queries</title>
</head>
<body>
    <h1>Hello Queries !</h1>
    <%
        out.print("hello1");
        List list = (List)request.getAttribute("testGet");
        out.print(list);
        out.print("hello2");
    %>
</body>
</html>