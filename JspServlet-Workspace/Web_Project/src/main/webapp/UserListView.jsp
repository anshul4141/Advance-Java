<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
	List<UserBean> list = (List) request.getAttribute("list");
	Iterator<UserBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1>User List</h1>

		<table border="1px" width="100%">

			<tr style="background-color: skyblue">
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Login</th>
				<th>Dob</th>
			</tr>

			<%
			while (it.hasNext()) {
				UserBean bean = it.next();
			%>
			<tr align="center" style="background-color: lightgrey">
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getDob()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>