<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		UserBean user = (UserBean) session.getAttribute("user");
	%>

	<%
		if (user != null) {
	%>
	<h1><%="Hi, " + user.getFirstName()%></h1>
	<a href="UserCtl">Add User</a> |
	<a href="UserListCtl">User List</a> |
	<a href="LoginCtl?operation=logout">Logout</a>
	<%
		} else {
	%>
	<h1>Hi, Guest</h1>
	<a href="UserRegistrationCtl">SignUp</a> |
	<a href="LoginCtl">Login</a>
	<%
		}
	%>

	<hr>
</body>
</html>