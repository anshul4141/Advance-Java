<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<%
	UserBean userBean = (UserBean) session.getAttribute("user");
%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
    <div class="container-fluid">
        <a target="_blank" class="navbar-brand" href="https://www.raystec.com/">
            <img src="https://www.raystec.com/assets/img/rays/customLogoOuterglow.png" 
                 alt="Logo" 
                 style="width: 120px; height: auto;">
        </a>
        <div class="collapse navbar-collapse" id="demo">
            <ul class="navbar-nav">
                <li class="nav-item"><a href="WelcomeCtl" class="nav-link"><span class="bi bi-house-fill"> Home</span></a></li>
                <%
                    if (userBean != null) {
                %>
                <li class="nav-item"><a href="UserCtl.do" class="nav-link">Add User</a></li>
                <li class="nav-item"><a href="UserListCtl.do" class="nav-link">User List</a></li>
                <li class="nav-item"><a href="MarksheetCtl.do" class="nav-link">Marksheet List</a></li>
                <li class="nav-item"><a href="MarksheetListCtl.do" class="nav-link">Marksheet List</a></li>
                <li class="nav-item"><a href="LoginCtl?operation=logout" class="nav-link">Logout</a></li>
                <% } else { %>
                <li class="nav-item"><a href="UserRegistrationCtl" class="nav-link">Sign Up</a></li>
                <li class="nav-item"><a href="LoginCtl" class="nav-link">Login</a></li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>
<hr>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
</body>
</html>
