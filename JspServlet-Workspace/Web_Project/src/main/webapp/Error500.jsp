<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>500 - Internal Server Error</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	text-align: center;
	margin: 0;
	padding: 50px;
}

.container {
	background: white;
	width: 500px;
	margin: auto;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

h1 {
	color: #e67e22;
	font-size: 60px;
	margin-bottom: 10px;
}

h2 {
	color: #333;
}

p {
	color: #666;
	font-size: 16px;
}

.error {
	margin-top: 20px;
	padding: 10px;
	background-color: #ffe6e6;
	color: #b30000;
	border: 1px solid #ff9999;
	border-radius: 5px;
	word-wrap: break-word;
}

a {
	display: inline-block;
	margin-top: 20px;
	text-decoration: none;
	background-color: #007BFF;
	color: white;
	padding: 10px 20px;
	border-radius: 5px;
}

a:hover {
	background-color: #0056b3;
}
</style>

</head>
<body>

	<div class="container">
		<h1>500</h1>
		<h2>Internal Server Error</h2>

		<p>Sorry! Something went wrong on our server.</p>
		<p>Please try again later or contact the administrator.</p>

		<%-- <%
		if (exception != null) {
		%>
		<div class="error">
			<strong>Error Message:</strong><br>
			<%=exception.getMessage()%>
		</div>
		<%
		}
		%> --%>

		<a href="index.jsp">Go to Home</a>
	</div>

</body>
</html>