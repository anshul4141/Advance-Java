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
	UserBean userBean = (UserBean) session.getAttribute("user");
	%>

	<%
	if (userBean != null) {
	%>
	<h2><%="Hii, " + userBean.getFirstName()%></h2>
	<a href="UserCtl">Add User</a> |
	<a href="UserListCtl">User List</a> |
	<a href="LoginCtl?operation=logout">Logout</a> |
	<%
	} else {
	%>

	<h2>Hii, Guest</h2>
	<a href="LoginCtl">Login</a> |
	<a href="UserRegistrationCtl">SignUp</a> |

	<%
	}
	%>
	<a href="WelcomeCtl">Welcome</a>
	<hr>
</body>
</html>