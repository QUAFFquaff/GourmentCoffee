<%@ page import="system" %><%--
  Created by IntelliJ IDEA.
  User: leo lv
  Date: 2017/1/3
  Time: 22:22

--%>
<%@page import="java.util.*" pageEncoding="GB18030" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css"/>
    <%--<link rel="stylesheet" href="../css/register.css" type="text/css"/>--%>
</head>

<body>
<div align="center">
    <%
        String username = request.getParameter("name");
        if(username.equals(aaa)){
        	out.println("!!!!!!!!!!!!!!");
        }else{
        	out.println("?????");
        }
    %>
</div>
</body>
</html>
