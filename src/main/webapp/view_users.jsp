<%@ page import="java.util.*" %>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Users List</h2>

<form action="viewUsers" method="get">
    <input type="text"
           name="keyword"
           placeholder="Search user">

    <button type="submit">
        Search
    </button>
</form>
<br>

<table class="user-table" border="1" cellpadding="10">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Username</th>
</tr>

<%
List<User> users =
(List<User>)request.getAttribute("userList");

for(User u : users){
%>

<tr>

<td><%=u.getId()%></td>
<td><%=u.getFullname()%></td>
<td><%=u.getEmail()%></td>
<td><%=u.getPhone()%></td>
<td><%=u.getUsername()%></td>
<td>
<a class="edit-btn"
href="editUser?id=<%=u.getId()%>">
Edit
</a>
</td>

<td>
<a class="delete-btn"
href="deleteUser?id=<%=u.getId()%>"
onclick="return confirm('Delete User?')">
Delete
</a>
</td>

</tr>

<%
}
%>

</table>
<br><br>

<%
Integer currentPage =
(Integer)request.getAttribute("currentPage");

if(currentPage == null){
    currentPage = 1;
}
%>

<div style="margin-top:20px;">

<% if(currentPage > 1){ %>

<a class="edit-btn"
href="viewUsers?page=<%=currentPage-1%>">
Previous
</a>

<% } %>

<a class="edit-btn"
href="viewUsers?page=<%=currentPage%>">
<%=currentPage%>
</a>

<a class="edit-btn"
href="viewUsers?page=<%=currentPage+1%>">
Next
</a>

</div>

</body>
</html>