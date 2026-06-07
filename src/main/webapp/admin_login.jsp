<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="login-container">

    <div class="login-card">

        <h2>Admin Login</h2>

        <form action="adminLogin" method="post">

            <input type="text"
                   name="username"
                   placeholder="Username"
                   required>

            <input type="password"
                   name="password"
                   placeholder="Password"ee
                   required>

            <button type="submit">
                Login
            </button>

        </form>

    </div>

</div>

</body>
</html>