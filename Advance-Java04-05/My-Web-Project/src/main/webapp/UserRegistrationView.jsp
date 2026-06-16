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
	String _suc = (String) request.getAttribute("successMsg");
	String _err = (String) request.getAttribute("errorMsg");
	UserBean bean = (UserBean) request.getAttribute("bean");
	%>

	<%@ include file="Header.jsp"%>

	<div align="center">
		<h1>User Registeration</h1>

		<h3 style="color: green"><%=_suc != null ? _suc : ""%></h3>
		<h3 style="color: red"><%=_err != null ? _err : ""%></h3>

		<form action="UserRegistrationCtl" method="post">

			<table>
				<tr>
					<th>FirstName<span style="color: red">*</span></th>
					<td><input type="text" name="firstName"
						value="<%=bean != null ? bean.getFirstName() : ""%>"
						placeholder="enter you firstName"></td>
				</tr>
				<tr>
					<th>LastName<span style="color: red">*</span></th>
					<td><input type="text" name="lastName"
						value="<%=bean != null ? bean.getLastName() : ""%>"
						placeholder="enter you lastName"></td>
				</tr>
				<tr>
					<th>LoginId<span style="color: red">*</span></th>
					<td><input type="email" name="loginId"
						value="<%=bean != null ? bean.getLoginId() : ""%>"
						placeholder="enter you email"></td>
				</tr>
				<tr>
					<th>Password<span style="color: red">*</span></th>
					<td><input type="password" name="password"
						value="<%=bean != null ? bean.getPassword() : ""%>"
						placeholder="enter you password"></td>
				</tr>
				<tr>
					<th>Dob<span style="color: red">*</span></th>
					<td><input type="date" name="dob"
						value="<%=bean != null ? bean.getDob() : ""%>"
						style="width: 165px"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signUp"></td>
				</tr>
			</table>

		</form>


	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>