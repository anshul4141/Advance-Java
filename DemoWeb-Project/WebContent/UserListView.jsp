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
	List<UserBean> nextList = (List) request.getAttribute("nextList");
	int pageNo = (int) request.getAttribute("pageNo");
	Iterator<UserBean> it = list.iterator();
	String succesMsg = (String) request.getAttribute("successMsg");
	String erorrMsg = (String) request.getAttribute("erorrMsg");
	%>

	<%@ include file="Header.jsp"%>


	<h1 align="center" style="color: darkblue">
		<u>User List</u>
	</h1>

	<form action="UserListCtl.do" method="post">

		<div align="center">
			<h2 style="color: green"><%=succesMsg != null ? succesMsg : ""%></h2>
			<h2 style="color: red"><%=erorrMsg != null ? erorrMsg : ""%></h2>
		</div>
		<%
		if (list.size() == 0) {
		%>
		<h1 style="color: red">Record Not found</h1>
		<%
		} else {
		%>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">

		<div align="center">

			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName"
						value="<%=request.getParameter("firstName") != null ? request.getParameter("firstName") : ""%>"
						placeholder="search by firstName"></td>
					<th>Last Name</th>
					<td><input type="text" name="lastName"
						value="<%=request.getParameter("lastName") != null ? request.getParameter("lastName") : ""%>"
						placeholder="search by lastName"></td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>

			<table width="100%" border="1px">
				<tr style="background-color: skyblue">
					<th>Select</th>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>Password</th>
					<th>Dob</th>
					<th>Edit</th>
				</tr>

				<%
				while (it.hasNext()) {
					UserBean bean = it.next();
				%>

				<tr align="center" style="background-color: #D3D3D3;">
					<td><input type="checkbox" name="ids" value=<%=bean.getId()%>></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getPassword()%></td>
					<td><%=bean.getDob()%></td>
					<td><a href="UserCtl.do?id=<%=bean.getId()%>">Edit</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
		<div>
			<table width="100%">
				<tr>
					<td><input type="submit" name="operation"
						<%=pageNo == 1 ? "disabled" : ""%> value="previous"></td>
					<td><input type="submit" name="operation" value="delete"></td>
					<td align="right"><input type="submit" name="operation"
						<%=nextList.size() == 0 ? "disabled" : ""%> value="next"></td>
				</tr>
			</table>
		</div>
		<%
		}
		%>
	</form>

	<%@ include file="Footer.jsp"%>
</body>
</html>