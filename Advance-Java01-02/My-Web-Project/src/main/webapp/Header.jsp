<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	UserBean user = (UserBean) session.getAttribute("bean");
	%>

	<%
	if (user != null) {
	%>
	<h2><%="Hii, " + user.getFirstName()%></h2>
	<a href="LoginCtl?operation=logout">Logout</a> |
	<%
	} else {
	%>

	<h2>Hii, Guest</h2>
	<a href="LoginCtl">Login</a> |
	<a href="UserRegistrationCtl">SingUp</a> |

	<%
	}
	%>

	<a href="WelcomeCtl">Welcome</a>

	<hr>
</body>
</html>