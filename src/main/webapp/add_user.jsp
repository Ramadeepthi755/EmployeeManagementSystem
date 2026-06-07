<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="container">

<div class="sidebar">

<h2>EMS</h2>

<a href="admin_dashboard.jsp">Dashboard</a>
<a href="add_user.jsp">Add User</a>
<a href="viewUsers">View Users</a>
<a href="logout">Logout</a>

</div>

<div class="content">

<h1>Add New User</h1>

<div class="form-card">

<form action="addUser"
      method="post"
      enctype="multipart/form-data">

<input type="text"
name="fullname"
placeholder="Full Name"
required>

<input type="email"
name="email"
placeholder="Email"
required>

<input type="text"
name="phone"
placeholder="Phone Number"
required>

<input type="text"
name="username"
placeholder="Username"
required>

<input type="password"
name="password"
placeholder="Password"
required>

<input type="file"
       name="image"
       accept="image/*"
       required>

<button type="submit">
Add User
</button>

</form>

</div>

</div>

</div>

</body>
</html>