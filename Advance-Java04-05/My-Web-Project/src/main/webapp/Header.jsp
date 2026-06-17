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
	<h3><%="Hii, " + user.getFirstName()%></h3>
	<a href="#">Add User</a> |
	<a href="#">User List</a> |
	<a href="LoginCtl?operation=logout">Logout</a> |
	<%
	} else {
	%>

	<h3>Hii, Guest</h3>
	<a href="LoginCtl">Login</a> |
	<a href="UserRegistrationCtl">SignUp</a> |
	<%
	}
	%>
	<a href="WelcomeCtl">Welcome</a>
	<hr>

</body>
</html>