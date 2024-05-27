<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head> -->
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
	<a href="UserListCtl.do">UserList</a> |
	<a href="UserCtl.do">Add User</a>
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