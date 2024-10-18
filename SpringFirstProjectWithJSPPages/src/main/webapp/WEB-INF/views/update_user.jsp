<html>
<head>
    <title>Update User</title>
</head>
<body>
    <h2>Update User</h2>
    <form action="/saveUser" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <label>First Name:</label>
        <input type="text" name="firstName" value="${user.firstName}"><br><br>
        <label>Last Name:</label>
        <input type="text" name="lastName" value="${user.lastName}"><br><br>
        <label>Email:</label>
        <input type="text" name="email" value="${user.email}"><br><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
