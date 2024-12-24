<%@page import="com.org.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.org.daoImpl.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../component/allcss.jsp" %>
<%@ include file="../component/user_navbar.jsp" %>
</head>
<body>
<h1 class="text-center">Welcome To The User Home Page</h1>

<% 

 ProductDaoImpl dao= new ProductDaoImpl();
 List<Product> products =dao.fetchAllProduct();
 request.setAttribute("products", products);
%>
 <h1>${success}</h1>

  <table border="2">

		<tr>

			<th>Name</th>
			<th>Price</th>
			<th>Category</th>
			<th>Description</th>
			<th>StockLeft</th>
			<th>Action</th>
			<th>Action</th>

		</tr>

		<c:forEach var="p" items="${products}">

			<tr>

				<td>${p.getName()}</td>
				<td>${p.getPrice()}</td>
				<td>${p.getCategory()}</td>
				<td>${p.getDescription()}</td>
				<td>${p.getStockleft()}</td>
				<td><a href="${pageContext.request.contextPath}/add_item?productId=${p.getId()}">Add To Cart</a></td>
				<td><a href="#">Buy Now</a></td>

			</tr>

		</c:forEach>


	</table>

</body>
</html>