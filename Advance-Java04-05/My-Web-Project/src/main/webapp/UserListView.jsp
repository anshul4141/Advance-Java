<%@page import="java.util.Iterator"%>
<%@page import="com.rays.bean.UserBean"%>
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
	%>
	<%@ include file="Header.jsp"%>
	<div align="center">
		<h1>User List</h1>
		<form action="UserListCtl" method="post">

			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName" value=""
						placeholder="search by firstName"></td>
					<th>Last Name</th>
					<td><input type="text" name="lastName" value=""
						placeholder="search by lastName"></td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>

			<table border="1px" width="100%">
				<tr style="background-color: skyblue">
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>LoginId</th>
					<th>DOB</th>
				</tr>

				<%
				Iterator<UserBean> it = list.iterator();

				while (it.hasNext()) {
					UserBean bean = it.next();
				%>
				<tr align="center">
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

		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>