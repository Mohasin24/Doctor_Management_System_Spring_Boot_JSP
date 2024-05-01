<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Test Page</title>

</head>
<body>
<%
	String name = (String)request.getAttribute("name");	
%>
<h1><%=name %></h1>
</body>
</html>
