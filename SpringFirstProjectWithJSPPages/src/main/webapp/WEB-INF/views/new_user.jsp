<html>
<head>
    <title>Add New User</title>
</head>
<body>
    <h2>Add New User</h2>
    <form action="/saveUser" method="post">
        <label>First Name:</label>
        <input type="text" name="firstName"><br><br>
        <label>Last Name:</label>
        <input type="text" name="lastName"><br><br>
        <label>Email:</label>
        <input type="text" name="email"><br><br>
        <input type="submit" value="Save">
    </form>
</body>
</html>
