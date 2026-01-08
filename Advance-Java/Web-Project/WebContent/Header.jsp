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
	UserBean userBean = (UserBean) session.getAttribute("user");
	%>

	<%
	if (userBean != null) {
	%>
	<h3><%="Hii, " + userBean.getFirstName()%></h3>
	<a href="#">Logout</a> |
	<a href="#">Add User</a> |
	<a href="#">User List</a>
	<%
	} else {
	%>
	<h3>Hii, Guest</h3>
	<a href="LoginCtl">Login</a> |
	<a href="WelcomeCtl">Welcome</a>
	<%
	}
	%>

	<hr>
</body>
</html>