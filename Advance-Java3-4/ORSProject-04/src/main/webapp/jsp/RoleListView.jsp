<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.controller.RoleListCtl"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.bean.RoleBean"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<html>
<head>
<title>Role List</title>
<link rel="icon" type="image/png"
	href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16x16" />
</head>
<body>
	<%@include file="Header.jsp"%>

	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.RoleBean"
		scope="request"></jsp:useBean>

	<div align="center">
		<h1 style="color: navy;">Role List</h1>

		<div style="height: 15px; margin-bottom: 12px">
			<h3>
				<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
			</h3>
			<h3>
				<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
			</h3>
		</div>

		<form action="<%=ORSView.ROLE_LIST_CTL%>" method="post">
			<%
			int pageNo = ServletUtility.getPageNo(request);
			int pageSize = ServletUtility.getPageSize(request);
			int index = ((pageNo - 1) * pageSize) + 1;
			int nextListSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());

			List<RoleBean> list = (List<RoleBean>) ServletUtility.getList(request);
			Iterator<RoleBean> it = list.iterator();

			if (list.size() != 0) {
			%>

			<table>
				<tr>
					<th>Role:</th>
					<td><input type="text" name="name"
						value="<%=DataUtility.getStringData(bean.getName())%>"
						placeholder="search by roleName"></td>
					<td><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_SEARCH%>"></td>
				</tr>
			</table>

			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>"> <br>
			<table border="1" style="width: 100%; border: groove;">
				<tr style="background-color: #e1e6f1e3;">
					<th>select</th>
					<th>S.No</th>
					<th>Role</th>
					<th>Description</th>
					<th>Edit</th>
				</tr>

				<%
				while (it.hasNext()) {
					bean = (RoleBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" class="case" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getDescription()%></td>
					<td><a href="#">Edit</a></td>
				</tr>
				<%
				}
				%>
			</table>

			<table style="width: 100%">
				<tr>
					<td style="width: 25%"><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_PREVIOUS%>"
						<%=pageNo > 1 ? "" : "disabled"%>></td>
					<td align="center" style="width: 25%"><input type="submit"
						name="operation" value="<%=RoleListCtl.OP_NEW%>"></td>
					<td align="center" style="width: 25%"><input type="submit"
						name="operation" value="<%=RoleListCtl.OP_DELETE%>"></td>
					<td style="width: 25%" align="right"><input type="submit"
						name="operation" value="<%=RoleListCtl.OP_NEXT%>"
						<%=nextListSize != 0 ? "" : "disabled"%>></td>
				</tr>
			</table>

			<%
			}
			if (list.size() == 0) {
			%>
			<table>
				<tr>
					<td align="right"><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_BACK%>"></td>
				</tr>
			</table>
			<%
			}
			%>
		</form>
	</div>
</body>
</html>