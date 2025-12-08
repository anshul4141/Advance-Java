<%@page import="in.co.rays.proj4.controller.UserCtl"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.UserRegistrationCtl"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="<%=ORSView.USER_CTL%>" method="post">

		<jsp:useBean id="bean" class="in.co.rays.proj4.bean.UserBean"
			scope="request"></jsp:useBean>

		<div align="center">
			<h1 style="color: navy">Add User</h1>

			<div style="height: 15px; margin-bottom: 12px">
				<H3 align="center">
					<font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
					</font>
				</H3>
				<H3 align="center">
					<font color="red"> <%=ServletUtility.getErrorMessage(request)%>
					</font>
				</H3>
			</div>

			<table>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName"
						value="<%=DataUtility.getStringData(bean.getFirstName())%>"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("firstName", request)%></font></td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lastName"
						value="<%=DataUtility.getStringData(bean.getLastName())%>"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("lastName", request)%></font></td>
				</tr>
				<tr>
					<th>Login ID:</th>
					<td><input type="text" name="login"
						value="<%=DataUtility.getStringData(bean.getLogin())%>"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("login", request)%></font></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" name="password"
						value="<%=DataUtility.getStringData(bean.getPassword())%>"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("password", request)%></font></td>
				</tr>
				<tr>
					<th>Confirm:</th>
					<td><input type="text" name="confirmPassword"
						value="<%=DataUtility.getStringData(bean.getConfirmPassword())%>"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></td>
				</tr>
				<tr>
					<th>DOB:</th>
					<td><input type="date" name="dob"
						value="<%=DataUtility.getDateString(bean.getDob())%>"
						style="width: 98%"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("dob", request)%></font></td>
				</tr>
				<tr>
					<th>Gender:</th>
					<td>
						<%
						HashMap map = new HashMap();
						map.put("male", "male");
						map.put("female", "female");
						%> <%=HTMLUtility.getList("gender", DataUtility.getStringData(bean.getGender()), map)%>
					</td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("gender", request)%></font></td>
				</tr>
				<tr>
					<th>Mobile:</th>
					<td><input type="text" name="mobileNo"
						value="<%=DataUtility.getStringData(bean.getMobileNo())%>"></td>
					<td><font color="red"><%=ServletUtility.getErrorMessage("mobileNo", request)%></font></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="operation"
						value="<%=UserCtl.OP_SAVE%>"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>