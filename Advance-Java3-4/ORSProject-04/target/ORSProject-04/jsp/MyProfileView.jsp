<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.controller.MyProfileCtl"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>

<html>
<head>
    <title>My Profile</title>
    <link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16x16" />
</head>
<body>

    <form action="<%=ORSView.MY_PROFILE_CTL%>" method="post">

        <%@ include file="Header.jsp"%>

        <jsp:useBean id="bean" class="in.co.rays.proj4.bean.UserBean" scope="request"></jsp:useBean>

        <div align="center">
            <h1 align="center" style="margin-bottom: -15; color: navy">My Profile</h1>

            <div style="height: 15px; margin-bottom: 12px">
                <h3>
                    <font color="red">
                        <%=ServletUtility.getErrorMessage(request)%>
                    </font>
                </h3>
                <h3 align="center">
                    <font color="green">
                        <%=ServletUtility.getSuccessMessage(request)%>
                    </font>
                </h3>
            </div>

            <input type="hidden" name="id" value="<%=bean.getId()%>">
            <input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
            <input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>">
            <input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
            <input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

            <table>
                <tr>
                    <th align="left">Login Id<span style="color: red">*</span></th>
                    <td>
                        <input type="text" name="login" placeholder="Enter Email ID"
                            value="<%=DataUtility.getStringData(bean.getLogin())%>" readonly="readonly">
                    </td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%=ServletUtility.getErrorMessage("login", request)%>
                        </font>
                    </td>
                </tr>

                <tr>
                    <th align="left">First Name<span style="color: red">*</span></th>
                    <td>
                        <input type="text" name="firstName" placeholder="Enter First Name"
                            value="<%=DataUtility.getStringData(bean.getFirstName())%>">
                    </td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%=ServletUtility.getErrorMessage("firstName", request)%>
                        </font>
                    </td>
                </tr>

                <tr>
                    <th align="left">Last Name<span style="color: red">*</span></th>
                    <td>
                        <input type="text" name="lastName" placeholder="Enter Last Name"
                            value="<%=DataUtility.getStringData(bean.getLastName())%>">
                    </td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%=ServletUtility.getErrorMessage("lastName", request)%>
                        </font>
                    </td>
                </tr>

                <tr>
                    <th align="left">Date of Birth<span style="color: red">*</span></th>
                    <td><input type="text" id="udate" name="dob"
					    placeholder="Select Date of Birth"
						value="<%=DataUtility.getDateString(bean.getDob())%>"></td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%=ServletUtility.getErrorMessage("dob", request)%>
                        </font>
                    </td>
                </tr>

                <tr>
                    <th align="left">Gender<span style="color: red">*</span></th>
                    <td>
                        <%
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put("Female", "Female");
                            map.put("Male", "Male");
                            String htmlList = HTMLUtility.getList("gender", bean.getGender(), map);
                        %>
                        <%=htmlList%>
                    </td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%=ServletUtility.getErrorMessage("gender", request)%>
                        </font>
                    </td>
                </tr>

                <tr>
                    <th align="left">Mobile No<span style="color: red">*</span></th>
                    <td>
                        <input type="text" name="mobileNo" maxlength="10" placeholder="Enter Mobile No."
                            value="<%=DataUtility.getStringData(bean.getMobileNo())%>">
                    </td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%=ServletUtility.getErrorMessage("mobileNo", request)%>
                        </font>
                    </td>
                </tr>

                <tr>
                    <th></th>
                    <td></td>
                </tr>

                <tr>
                    <th></th>
                    <td align="center" colspan="2">
                        <input type="submit" name="operation" value="<%=MyProfileCtl.OP_SAVE%>"> &nbsp;
                        <input type="submit" name="operation" value="<%=MyProfileCtl.OP_CHANGE_MY_PASSWORD%>">
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>