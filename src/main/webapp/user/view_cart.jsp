<%@page import="com.org.daoImpl.UserDaoImpl"%>
<%@page import="com.org.dto.Item"%>
<%@page import="java.util.List"%>
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

 <% 

 int userId=(int) session.getAttribute("userId");
 List<Item> items =new UserDaoImpl().fetchUserById(userId).getItems();
 request.setAttribute("items", items);
 
 %>

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

		<c:forEach var="p" items="${items}">

			<tr>

				<td>${p.getName()}</td>
				<td>${p.getPrice()}</td>
				<td>${p.getCategory()}</td>
				<td>${p.getDescription()}</td>
				<td>${p.getStocksleft()}</td>
				<td><a href="${pageContext.request.contextPath}/remove_item?itemId=${p.getId()}">Remove From Cart</a></td>
				<td><a href="#">Buy Now</a></td>

			</tr>

		</c:forEach>

	</table>

</body>
</html>