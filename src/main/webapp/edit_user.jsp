<%@ page import="model.User" %>

<%
User user =
(User)request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Edit User</h2>

<form action="updateUser" method="post">

<input type="hidden"
       name="id"
       value="<%=user.getId()%>">

Name:

<input type="text"
       name="fullname"
       value="<%=user.getFullname()%>">

<br><br>

Email:

<input type="email"
       name="email"
       value="<%=user.getEmail()%>">

<br><br>

Phone:

<input type="text"
       name="phone"
       value="<%=user.getPhone()%>">

<br><br>

Username:

<input type="text"
       name="username"
       value="<%=user.getUsername()%>">

<br><br>

Password:

<input type="text"
       name="password"
       value="<%=user.getPassword()%>">

<br><br>

<button type="submit">
Update User
</button>

</form>

</body>
</html>