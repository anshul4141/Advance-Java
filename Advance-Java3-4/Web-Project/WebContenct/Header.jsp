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
	<%
	} else {
	%>
	<h3>Hii, Guest</h3>
	<%
	}
	%>
	<%
	if (userBean != null) {
	%>
	<a href="LoginCtl?operation=logout">logout</a> |
	<a href="UserCtl">Add User</a> |
	<a href="UserListCtl">User List</a> |
	<%
	} else {
	%>
	<a href="LoginCtl">login</a> |
	<a href="UserRegistrationCtl">SignUp</a> |
	<%
	}
	%>
	<a href="WelcomeCtl">Welcome</a>
	<hr>
</body>
</html>