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
	<br>
	<%
		UserBean user = (UserBean) session.getAttribute("user");
		String welcome = "Hii' ";
	%>
	<%
		if (user != null) {
	%>
	<%=welcome + user.getFirstName()%>
	|

	<a href="LoginCtl?operation=logout"><b>Logout</b></a> |
	<a href="UserListCtl">UserList</a> |
	<a href="UserCtl">Add User</a>
	<%
		} else {
	%>
	<%=welcome + "Guest"%>
	|
	<a href="LoginCtl">Login</a> |
	<a href="UserRegistrationCtl">signUp</a>
	<%
		}
	%>
	<br>
	<br>
	<hr>
</body>
</html>