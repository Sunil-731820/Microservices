<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users List</title>
</head>
<body>
    <h1>Users List</h1>
    <ul>
        <c:forEach var="user" items="${users}">
            <li>${user.name} - ${user.email}</li>
        </c:forEach>
       
    </ul>
</body>
</html>
