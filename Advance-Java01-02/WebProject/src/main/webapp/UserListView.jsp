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
	List<UserBean> list = (List<UserBean>) request.getAttribute("list");
	String smsg = (String) request.getAttribute("successMsg");
	String emsg = (String) request.getAttribute("errorMsg");
	int pageNo = (int) request.getAttribute("pageNo");
	int index = (pageNo - 1) * 5 + 1;
	%>

	<%@ include file="Header.jsp"%>

	<%
	if (list.size() != 0) {
	%>
	<div align="center">
		<h1>User List</h1>
		<h3 style="color: green;"><%=smsg != null ? smsg : ""%></h3>
		<h3 style="color: red;"><%=emsg != null ? emsg : ""%></h3>
		<form action="UserListCtl.do" method="post">

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
					<th>Select</th>
					<th>S No.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>Password</th>
					<th>Dob</th>
					<th>Edit</th>
				</tr>


				<%
				Iterator<UserBean> it = list.iterator();

				while (it.hasNext()) {
					UserBean bean = it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
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
			<br>
			<table width="100%">
				<tr>
					<td><input type="submit" name="operation" value="previous"
						<%=pageNo == 1 ? "disabled" : ""%>></td>
					<td align="center"><input type="submit" name="operation"
						value="delete"></td>
					<td align="right"><input type="submit" name="operation"
						value="next" <%=list.size() < 5 ? "disabled" : ""%>></td>
				</tr>
			</table>
			<input type="hidden" name="pageNo" value="<%=pageNo%>">
		</form>
	</div>
	<%
	} else {
	%>
	<div align="center">
		<h2 style="color: red">record not found</h2>
		<h3>
			<a href="UserListCtl.do">back to the list</a>
		</h3>
	</div>
	<%
	}
	%>
</body>
</html>