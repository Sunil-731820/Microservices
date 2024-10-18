<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="com.example.SpringFirstProjectWithJSPPagesWithNormalPages.UserMethod"%>
<%@page import="java.io.PrintWriter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>This is The Example of the aboutPage okay </h2>
<c:out value="${'This is the Example of The About page Okay' }"></c:out>
<%
	UserMethod method = new UserMethod();
	String name = method.getName("Hi");
	out.print("The below is the Name is :");
	out.print("The name is Given "+name);
%>
</body>
</html>