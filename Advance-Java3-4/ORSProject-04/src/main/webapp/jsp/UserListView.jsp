<%@page import="in.co.rays.proj4.bean.RoleBean"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="in.co.rays.proj4.model.RoleModel"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.bean.BaseBean"%>
<%@page import="in.co.rays.proj4.controller.UserListCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<html>
<head>
<title>User List</title>
</head>
<body>

	<%
	List roleList = (List) request.getAttribute("roleList");
	%>

	<%@include file="Header.jsp"%>

	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.UserBean"
		scope="request"></jsp:useBean>

	<div align="center">
		<h1 style="color: navy;">User List</h1>

		<div style="height: 15px; margin-bottom: 12px">
			<h3>
				<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
			</h3>
			<h3>
				<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
			</h3>
		</div>

		<form action="<%=ORSView.USER_LIST_CTL%>" method="post">
			<%
			int pageNo = ServletUtility.getPageNo(request);
			int pageSize = ServletUtility.getPageSize(request);
			int index = ((pageNo - 1) * pageSize) + 1;
			int nextListSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());

			List<UserBean> list = (List<UserBean>) ServletUtility.getList(request);
			Iterator<UserBean> it = list.iterator();

			if (list.size() != 0) {
			%>

			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">

			<table style="width: 100%">
				<tr>
					<td align="center"><label><b>First Name :</b></label> <input
						type="text" name="firstName" placeholder="Enter First Name"
						value="<%=ServletUtility.getParameter("firstName", request)%>">&emsp;

						<label><b>Login Id:</b></label> <input type="text" name="login"
						placeholder="Enter Email ID"
						value="<%=ServletUtility.getParameter("login", request)%>">&emsp;

						<label><b>Mobile No:</b></label> <input type="text"
						name="mobileNo" placeholder="Enter MobileNo"
						value="<%=ServletUtility.getParameter("mobileNo", request)%>">&emsp;

						<label><b>Dob:</b></label> <input type="date" name="dob"
						value="<%=ServletUtility.getParameter("dob", request)%>">&emsp;


						<label><b>Role:</b></label> <%=HTMLUtility.getList("roleId", String.valueOf(bean.getRoleId()), roleList)%>

						<input type="submit" name="operation"
						value="<%=UserListCtl.OP_SEARCH%>"> &nbsp; <input
						type="submit" name="operation" value="<%=UserListCtl.OP_RESET%>">
					</td>
				</tr>
			</table>
			<br>

			<table border="1" style="width: 100%; border: groove;">
				<tr style="background-color: #e1e6f1e3;">
					<th><input type="checkbox" id="selectall" /></th>
					<th>S.No</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login Id</th>
					<th>Mobile No</th>
					<th>Gender</th>
					<th>Date of Birth</th>
					<th>Role</th>
					<th>Edit</th>
				</tr>

				<%
				while (it.hasNext()) {
					bean = (UserBean) it.next();
					RoleModel model = new RoleModel();
					RoleBean roleBean = model.findByPk(bean.getRoleId());

					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String date = sdf.format(bean.getDob());
				%>

				<tr align="center">
					<td style="text-align: center;"><input type="checkbox"
						name="ids" value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getMobileNo()%></td>
					<td><%=bean.getGender()%></td>
					<td><%=date%></td>
					<td><%=roleBean.getName()%></td>
					<td><a href="#">Edit</a></td>
				</tr>

				<%
				}
				%>
			</table>

			<table style="width: 100%">
				<tr>
					<td style="width: 25%"><input type="submit" name="operation"
						value="<%=UserListCtl.OP_PREVIOUS%>"
						<%=pageNo > 1 ? "" : "disabled"%>></td>
					<td align="center" style="width: 25%"><input type="submit"
						name="operation" value="<%=UserListCtl.OP_NEW%>"></td>
					<td align="center" style="width: 25%"><input type="submit"
						name="operation" value="<%=UserListCtl.OP_DELETE%>"></td>
					<td style="width: 25%" align="right"><input type="submit"
						name="operation" value="<%=UserListCtl.OP_NEXT%>"
						<%=nextListSize != 0 ? "" : "disabled"%>></td>
				</tr>
			</table>

			<%
			} else {
			%>

			<table>
				<tr>
					<td align="right"><input type="submit" name="operation"
						value="<%=UserListCtl.OP_BACK%>"></td>
				</tr>
			</table>

			<%
			}
			%>
		</form>
	</div>
</body>
</html>