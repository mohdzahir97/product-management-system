<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container mt-5">

		<div class="col-md-12">

			<h1 class="text-center">All Product Details</h1>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Product Name</th>
						<th scope="col">Product Price</th>
						<th scope="col">Product Description</th>
						<th scope="col">Action</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${products}" var="p">
					
					<tr>
						<th>${p.id}</th>
						<td>${p.product_name}</td>
						<td>&#X20B9; ${p.price}</td>
						<td>${p.description}</td>
						<td>
							<a href="delete/${p.id}"><li class="fas fa-trash text-danger"></li></a>			
							<a href="update/${p.id}"><li class="fas fa-edit text-outline-success"></li></a>					
						</td>

					</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="container">
				<div class="text-center">
					<a href="addproduct" class="btn btn-outline-success ml-10">Add
						Product </a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>