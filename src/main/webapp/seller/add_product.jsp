<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Add Product Page</h1>

<h2>${success}</h2>

<form:form action="${pageContext.request.contextPath}/add_product" method="post" modelAttribute="product">
 
 Enter product name: <br>
<form:input path="name"/><br><br>

Enter product price: <br>
<form:input path="price"/><br><br>

Enter product category: <br>
<form:input path="category"/><br><br>

Enter product description: <br>
<form:input path="description"/><br><br>

Enter product quantity: <br>
<form:input path="stockleft"/><br><br>


<form:hidden path="id"/><br><br>


<form:button>Submit</form:button>
 
 </form:form>

</body>
</html>