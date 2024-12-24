<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>User Login Page</h1>

<h2>${fail}</h2>
<form action="${pageContext.request.contextPath}/login_user" method="post">
Enter your email: <br>
<input type="text" name="email"><br><br>
Enter your password: <br>
<input type="text" name="password"><br><br>

<input type="submit" value="Login">
</body>
</html>