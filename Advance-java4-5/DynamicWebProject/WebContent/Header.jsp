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
	<a href="UserCtl">Add User</a> |
	<a href="UserListCtl">User List</a> |
	<a href="LoginCtl?operation=logout">logout</a>
	<%
		} else {
	%>
	<a href="UserRegistrationCtl">SignUp</a> |
	<a href="LoginCtl">login</a>
	<%
		}
	%>
	<br>
	<hr>

</body>
</html>