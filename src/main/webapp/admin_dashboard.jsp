<%
response.setHeader(
        "Cache-Control",
        "no-cache, no-store, must-revalidate");

response.setHeader(
        "Pragma",
        "no-cache");

response.setDateHeader(
        "Expires",
        0);

if(session.getAttribute("admin") == null){

    response.sendRedirect(
            "admin_login.jsp");

    return;
}
%>
<%@ page import="model.User" %>



<%@ page import="dao.UserDAO" %>

<%
UserDAO dao = new UserDAO();

int totalUsers =
dao.getTotalUsers();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<link rel="stylesheet" href="css/style.css">


</head>


<body>

<div class="sidebar">

    <h2>EMS</h2>

    <a href="admin_dashboard.jsp">
        Dashboard
    </a>

    <a href="add_user.jsp">
        Add User
    </a>

    <a href="viewUsers">
        View Users
    </a>

    <a href="logout">
        Logout
    </a>

</div>

<div class="main-content">

    <h1>Dashboard</h1>

   <div class="cards">

    <div class="card">
        <h3>Total Users</h3>
        <h1><%=totalUsers%></h1>
    </div>

    <div class="card">
        <h3>Admin Status</h3>
        <h1>Active</h1>
    </div>

    <div class="card">
        <h3>System</h3>
        <h1>Running</h1>
    </div>

</div>

</div>

</body>

</body>
</html>