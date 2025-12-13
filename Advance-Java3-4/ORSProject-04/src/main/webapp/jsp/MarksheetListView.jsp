<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="java.util.Collections"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.controller.MarksheetListCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.bean.MarksheetBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<html>
<head>
    <title>Marksheet List</title>
    <link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16x16" />
</head>
<body>
    <%@include file="Header.jsp"%>
    <div align="center">
        <h1 align="center" style="margin-bottom: -15; color: navy;">Marksheet List</h1>

        <div style="height: 15px; margin-bottom: 12px">
            <h3>
                <font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
            </h3>
            <h3>
                <font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
            </h3>
        </div>

        <form action="<%=ORSView.MARKSHEET_LIST_CTL%>" method="POST">
            <%
                int pageNo = ServletUtility.getPageNo(request);
                int pageSize = ServletUtility.getPageSize(request);
                int index = ((pageNo - 1) * pageSize) + 1;
                int nextListSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());

                List<MarksheetBean> list = (List<MarksheetBean>) ServletUtility.getList(request);
                Iterator<MarksheetBean> it = list.iterator();

                if (list.size() != 0) {
            %>

            <input type="hidden" name="pageNo" value="<%=pageNo%>">
            <input type="hidden" name="pageSize" value="<%=pageSize%>">

            <table style="width: 100%">
                <tr>
                    <td align="center">
                        <label><b>Name :</b></label>
                        <input type="text" name="name" placeholder="Enter Student Name" value="<%=ServletUtility.getParameter("name", request)%>">&emsp;

                        <label><b>Roll No :</b></label>
                        <input type="text" name="rollNo" placeholder="Enter Roll No." value="<%=ServletUtility.getParameter("rollNo", request)%>">&emsp;

                        <input type="submit" name="operation" value="<%=MarksheetListCtl.OP_SEARCH%>">
                        &nbsp;
                        <input type="submit" name="operation" value="<%=MarksheetListCtl.OP_RESET%>">
                    </td>
                </tr>
            </table>
            <br>

            <table border="1" style="width: 100%; border: groove;">
                <tr style="background-color: #e1e6f1e3;">
                    <th width="5%"><input type="checkbox" id="selectall" /></th>
                    <th width="5%">S.No</th>
                    <th width="10%">Roll No</th>
                    <th width="25%">Name</th>
                    <th width="10%">Physics</th>
                    <th width="10%">Chemistry</th>
                    <th width="10%">Maths</th>
                    <th width="10%">Total</th>
                    <th width="10%">Percentage (%)</th>
                    <th width="5%">Edit</th>
                </tr>

                <%
                    while (it.hasNext()) {
                        MarksheetBean bean = it.next();
                        int physics = bean.getPhysics();
                        int chemistry = bean.getChemistry();
                        int maths = bean.getMaths();
                        int total = physics + chemistry + maths;
                        float percentage = (float) total / 3;
                        percentage = Float.parseFloat(new DecimalFormat("##.##").format(percentage));
                %>
                <tr>
                    <td style="text-align: center;">
                        <input type="checkbox" class="case" name="ids" value="<%=bean.getId()%>">
                    </td>
                    <td style="text-align: center;"><%=index++%></td>
                    <td style="text-align: center; text-transform: uppercase;"><%=bean.getRollNo()%></td>
                    <td style="text-align: center; text-transform: capitalize;"><%=bean.getName()%></td>
                    <td style="text-align: center;"><%=bean.getPhysics()%></td>
                    <td style="text-align: center;"><%=bean.getChemistry()%></td>
                    <td style="text-align: center;"><%=bean.getMaths()%></td>
                    <td style="text-align: center;"><%=total%></td>
                    <td style="text-align: center;"><%=percentage%> %</td>
                    <td style="text-align: center;">
                        <a href="MarksheetCtl?id=<%=bean.getId()%>">Edit</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>

            <table style="width: 100%">
                <tr>
                    <td style="width: 25%">
                        <input type="submit" name="operation" value="<%=MarksheetListCtl.OP_PREVIOUS%>" <%=pageNo > 1 ? "" : "disabled"%>>
                    </td>
                    <td align="center" style="width: 25%">
                        <input type="submit" name="operation" value="<%=MarksheetListCtl.OP_NEW%>">
                    </td>
                    <td align="center" style="width: 25%">
                        <input type="submit" name="operation" value="<%=MarksheetListCtl.OP_DELETE%>">
                    </td>
                    <td style="width: 25%" align="right">
                        <input type="submit" name="operation" value="<%=MarksheetListCtl.OP_NEXT%>" <%=nextListSize != 0 ? "" : "disabled"%>>
                    </td>
                </tr>
            </table>

            <%
                }
                if (list.size() == 0) {
            %>
            <table>
                <tr>
                    <td align="right">
                        <input type="submit" name="operation" value="<%=MarksheetListCtl.OP_BACK%>">
                    </td>
                </tr>
            </table>
            <%
                }
            %>
        </form>
    </div>
</body>
</html>