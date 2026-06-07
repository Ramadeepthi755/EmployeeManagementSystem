<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>

<style>

body{
    margin:0;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
    background:#f4f6f9;
    font-family:Arial,sans-serif;
}

.container{
    text-align:center;
    background:white;
    padding:40px;
    border-radius:15px;
    box-shadow:0 4px 15px rgba(0,0,0,0.1);
}

h1{
    color:#0569ff;
    margin-bottom:30px;
}

a{
    display:block;
    text-decoration:none;
    background:#0569ff;
    color:white;
    padding:12px;
    margin:10px;
    border-radius:8px;
    font-weight:bold;
}

a:hover{
    background:#0453cc;
}

</style>

</head>
<body>

<div class="container">

    <h1>Employee Management System</h1>

    <a href="admin_login.jsp">
        Admin Login
    </a>

    <a href="user_login.jsp">
        User Login
    </a>

</div>

</body>
</html>