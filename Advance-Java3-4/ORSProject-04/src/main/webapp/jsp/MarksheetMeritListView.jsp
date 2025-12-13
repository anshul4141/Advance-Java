<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.controller.MarksheetMeritListCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.bean.MarksheetBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<html>
<head>
    <title>Marksheet Merit List</title>
    <link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16x16" />
</head>
<body>
    <%@include file="Header.jsp"%>
    <div align="center">
        <h1 align="center" style="margin-bottom: -15; color: navy;">Marksheet Merit List</h1>

        <div style="height: 30px;">
            <h3>
                <font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
            </h3>
        </div>

        <form action="<%=ORSView.MARKSHEET_MERIT_LIST_CTL%>" method="POST">
            <%
                int pageNo = ServletUtility.getPageNo(request);
                int pageSize = ServletUtility.getPageSize(request);
                int index = ((pageNo - 1) * pageSize) + 1;

                List<MarksheetBean> list = (List<MarksheetBean>) ServletUtility.getList(request);
                Iterator<MarksheetBean> it = list.iterator();

                if (list.size() != 0) {
            %>
            <table border="1"
                   style="width: 100%; border: groove; padding: 1px; border-color: #e1e6f1e3;">
                <thead>
                    <tr style="background-color: #e1e6f1e3;">
                        <th width="5%">S.No</th>
                        <th width="10%">Roll No</th>
                        <th width="30%">Name</th>
                        <th width="10%">Physics</th>
                        <th width="10%">Chemistry</th>
                        <th width="10%">Maths</th>
                        <th width="10%">Total</th>
                        <th width="15%">Percentage (%)</th>
                    </tr>
                </thead>
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
                <tbody>
                    <tr>
                        <td style="text-align: center;"><%=index++%></td>
                        <td style="text-align: center; text-transform: uppercase;"><%=bean.getRollNo()%></td>
                        <td style="text-transform: capitalize; text-align: center;"><%=bean.getName()%></td>
                        <td style="text-align: center;"><%=bean.getPhysics()%></td>
                        <td style="text-align: center;"><%=bean.getChemistry()%></td>
                        <td style="text-align: center;"><%=bean.getMaths()%></td>
                        <td style="text-align: center;"><%=total%></td>
                        <td style="text-align: center;"><%=percentage%> %</td>
                    </tr>
                </tbody>
                <%
                    }
                %>
            </table>
            <%
                }
            %>
            <table>
                <tr>
                    <td align="right">
                        <input type="submit" name="operation" value="<%=MarksheetMeritListCtl.OP_BACK%>">
                    </td>
                </tr>
            </table>
            <input type="hidden" name="pageNo" value="<%=pageNo%>">
            <input type="hidden" name="pageSize" value="<%=pageSize%>">
        </form>
    </div>
</body>
</html>