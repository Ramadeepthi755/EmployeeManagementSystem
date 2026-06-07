<%@ page import="model.User" %>

<%
response.setHeader("Cache-Control",
                   "no-cache, no-store, must-revalidate");

response.setHeader("Pragma",
                   "no-cache");

response.setDateHeader("Expires", 0);

User user =
(User)session.getAttribute("user");

if(user == null){

    response.sendRedirect(
            request.getContextPath()
            + "/user_login.jsp");

    return;
}
%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="container">

    <div class="sidebar">

        <h2>EMS</h2>

        <a href="user_dashboard.jsp">Dashboard</a>
        <a href="logout">Logout</a>

    </div>

    <div class="content">
    
<div style="text-align:center;">

    <img src="uploads/<%= user.getImage() %>"
         style="width:200px;height:250px;border-radius:50%;object-fit:cover;border:none;">

    <h1>Welcome, <%= user.getFullname() %></h1>

</div>
       
<div class="cards">

    <div class="card">
        <h3>Username</h3>
        <p><%= user.getUsername() %></p>
    </div>

    <div class="card">
        <h3>Email</h3>
        <p><%= user.getEmail() %></p>
    </div>

</div>

</div>
</div>
</body>
</html>