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

	<h3><%="Hi, " + userBean.getFirstName()%></h3>

	<%
		} else {
	%>
	<h3><%="Hi, Guest"%></h3>
	<%
		}
	%>

	<a href="WelcomeCtl">welcome</a> |

	<%
		if (userBean != null) {
	%>
	<a href="UserCtl">Add User</a> |
	<a href="UserListCtl">User List</a> |
	<a href="LoginCtl?operation=logout">logout</a>
	<%
		} else {
	%>
	<a href="LoginCtl">Login</a> |
	<a href="UserRegistrationCtl">SignUp</a>
	<%
		}
	%>

	<hr>

</body>
</html>