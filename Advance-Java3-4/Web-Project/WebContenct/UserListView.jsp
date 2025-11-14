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
	List list = (List) request.getAttribute("list");
	String successMsg = (String) request.getAttribute("successMsg");
	String errorMsg = (String) request.getAttribute("errorMsg");
	int pageNo = (int) request.getAttribute("pageNo");
	%>
	<%@ include file="Header.jsp"%>
	<div align="center">
		<h2>User List</h2>
		<%
		if (successMsg != null) {
		%>
		<h3 style="color: green"><%=successMsg%></h3>
		<%
		}
		%>

		<%
		if (errorMsg != null) {
		%>
		<h3 style="color: red"><%=errorMsg%></h3>
		<%
		}
		%>
		<form action="UserListCtl.do" method="post">

			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName" value=""
						placeholder="search by first name">
					<th>Last Name</th>
					<td><input type="text" name="lastName" value=""
						placeholder="search by last name"> <input type="submit"
						name="operation" value="search"></td>
				</tr>
			</table>

			<table border="1px" width="100%">
				<tr style="background-color: skyblue">
					<th>Delete</th>
					<th>S.NO</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>DOB</th>
					<th>Edit</th>
				</tr>

				<%
				Iterator<UserBean> it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = it.next();
				%>
				<tr align="center" style="background-color: #D3D3D3">
					<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getDob()%></td>
					<td><a href="UserCtl.do?id=<%=bean.getId()%>">Edit</a></td>
				</tr>
				<%
				}
				%>
			</table>
			<br>
			<table width="100%">
				<tr>
					<td><input type="submit" name="operation"
						<%=pageNo == 1 ? "disabled" : ""%> value="previous"></td>
					<td align="center"><input type="submit" name="operation"
						value="delete"></td>
					<td align="right"><input type="submit" name="operation"
						<%=list.size() < 5 ? "disabled" : ""%> value="next"></td>
				</tr>
			</table>
			<input type="text" name="pageNo" value="<%=pageNo%>">
		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>