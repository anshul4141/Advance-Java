<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.controller.LoginCtl"%>
<%@page import="in.co.rays.proj4.bean.UserBean"%>
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
	<h3>
		Hi,
		<%=user.getFirstName()%>
		(<%=session.getAttribute("role")%>)
	</h3>

	<a href="<%=ORSView.USER_CTL%>"><b>Add User</b></a>
	<b>|</b>
	<a href="<%=ORSView.USER_LIST_CTL%>"><b>User List</b></a>
	<b>|</b>
	<a href="<%=ORSView.ROLE_CTL%>"><b>Add Role</b></a>
	<b>|</b>
	<a href="<%=ORSView.ROLE_LIST_CTL%>"><b>Role List</b></a>
	<b>|</b>
	<a href="LoginCtl?operation=<%=LoginCtl.OP_LOG_OUT%>"><b>Logout</b></a>
	<%
	} else {
	%>
	<h3>Hi, Guest</h3>
	<a href="WelcomeCtl"><b>Welcome</b></a> |
	<a href="LoginCtl"><b>Login</b></a>
	<%
	}
	%>
	<hr>
</body>
</html>