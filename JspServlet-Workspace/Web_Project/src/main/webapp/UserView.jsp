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
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	UserBean bean = (UserBean) request.getAttribute("bean");
	%>

	<%@ include file="Header.jsp"%>
	<form action="UserCtl.do" method="post">

		<div align="center">

			<h1 style="color: darkblue;"><%=bean != null ? "Update User" : "Add User"%></h1>

			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
			<h3 style="color: red"><%=err != null ? err : ""%></h3>
			<input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">
			<table>

				<tr>
					<th>First Name:<font color="red">*</font></th>
					<td><input type="text" name="firstName"
						value="<%=bean != null ? bean.getFirstName() : ""%>"
						placeholder="enter firstName"></td>
				</tr>

				<tr>
					<th>Last Name:<font color="red">*</font></th>
					<td><input type="text" name="lastName"
						value="<%=bean != null ? bean.getLastName() : ""%>"
						placeholder="enter lastName"></td>
				</tr>

				<tr>
					<th>Login:<font color="red">*</font></th>
					<td><input type="email" name="login"
						value="<%=bean != null ? bean.getLoginId() : ""%>"
						placeholder="enter you email"></td>
				</tr>

				<tr>
					<th>Password:<font color="red">*</font></th>
					<td><input type="password" name="password"
						value="<%=bean != null ? bean.getPassword() : ""%>"
						placeholder="enter you password"></td>
				</tr>

				<tr>
					<th>Dob:<font color="red">*</font></th>
					<td><input type="date" name="dob"
						value="<%=bean != null ? bean.getDob() : ""%>"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=bean != null ? "update" : "save"%>"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>