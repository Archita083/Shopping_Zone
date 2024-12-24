<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../component/allcss.jsp" %>

</head>
<body>

<form:form action="register_user" method="post" modelAttribute="user">
Enter your name: <br>
<form:input path="name"/><br><br>
Enter your mobile: <br>
<form:input path="mobile"/><br><br>
Enter your email: <br>
<form:input path="email"/><br><br>
Enter your password: <br>
<form:password path="password"/><br><br>
Enter your address: <br>
<form:textarea path="address" rows ="5" col="20"/><br><br>
<form:button>Submit</form:button>

</form:form>


</body>
</html>