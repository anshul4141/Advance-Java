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
	UserBean userBean = (UserBean) request.getAttribute("user");
	%>

	<%
	if (userBean != null) {
	%>
	<h1><%="Hii, " + userBean.getFirstName()%></h1>
	<%
	} else {
	%>

	<h3>Hii, Guest</h3>
	<a href="LoginCtl">Login</a> |
	<a href="UserRegistrationCtl">Sign Up</a> |
	<%
	}
	%>
	<a href="WelcomeCtl">Welcome</a>
	<hr>

</body>
</html>