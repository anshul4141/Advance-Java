<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>404 - Page Not Found</title>

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
	width: 450px;
	margin: auto;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

h1 {
	color: red;
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
		<h1>404</h1>
		<h2>Page Not Found</h2>
		<p>Sorry! The page you are looking for does not exist.</p>

		<a href="WelcomeCtl">Go to Home</a>
	</div>

</body>
</html>