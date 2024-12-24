<%@page import="com.org.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.Seller"%>
<%@page import="com.org.daoImpl.SellerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	int sellerId = (int) session.getAttribute("sellerId");
	Seller seller = new SellerDaoImpl().fetchSellerById(sellerId);
	List<Product> products = seller.getProducts();
	request.setAttribute("products", products);
	
	%>

	<table border="2">

		<tr>

			<th>Name</th>
			<th>Price</th>
			<th>Category</th>
			<th>Description</th>
			<th>StockLeft</th>
			<th>Update</th>
			<th>Delete</th>

		</tr>

		<c:forEach var="p" items="${products}">

			<tr>

				<td>${p.getName()}</td>
				<td>${p.getPrice()}</td>
				<td>${p.getCategory()}</td>
				<td>${p.getDescription()}</td>
				<td>${p.getStockleft()}</td>
				<td><a href="${pageContext.request.contextPath}/update_product?productId=${p.getId()}">Update</a></td>
				<td><a href="${pageContext.request.contextPath}/delete_product?productId=${p.getId()}">Delete</a></td>

			</tr>

		</c:forEach>


	</table>

</body>
</html>