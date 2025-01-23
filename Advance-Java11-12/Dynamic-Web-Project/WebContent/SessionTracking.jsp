<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="track" method="post">
		<input type="text" name="jsessionid" value="<%=session.getId()%>">
		<input type="submit" value="Submit">
	</form>
</body>
</html>