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

<h1>Users</h1>
<c:out value="${'I am Going use the for Each loop in JSTL'}"></c:out>
    <!-- Using JSTL to loop through a list of users -->
    <ul>
        <c:forEach var="user" items="${users}">
        	<c:out value="${'The value of Each user Name is ' }"></c:out>
            <li>${user}</li>
        </c:forEach>
    </ul>

</body>
</html>