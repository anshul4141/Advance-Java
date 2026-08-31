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
	String succ = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="Header.jsp"%>

	<form action="UserListCtl" method="post">
		<div align="center">

			<h1>User List</h1>

			<h3 style="color: red"><%=err != null ? err : ""%></h3>
			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>

			<table>
				<tr>
					<td><input type="text" name="firstName" value=""
						placeholder="search by firstName"></td>
					<td><input type="text" name="lastName" value=""
						placeholder="search by lastName"></td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>

			<table border="1px" width="100%">

				<tr style="background-color: skyblue">
					<th><input type="checkbox"
						onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)"></th>
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
					<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
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
		<table width="100%">
			<tr>
				<td><input type="submit" name="operation" value="previous"></td>
				<td align="center"><input type="submit" name="operation"
					value="delete"></td>
				<td align="right"><input type="submit" name="operation"
					value="next"></td>
			</tr>
		</table>
	</form>

	<%@ include file="Footer.jsp"%>
</body>
</html>