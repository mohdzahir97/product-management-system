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
		<div>
			<h1 class="text-center">Update Product Details</h1>
		</div>
		<form action="${pageContext.request.contextPath}/update-product-data"
			method="post">
			<div>

				<div class="mb-3">
					<input type="hidden" class="form-control" name="id" 
						value="${product.id}">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label"><b>Product
							Name</b></label> <input type="text" class="form-control" name="product_name"
						id="produjct_name" placeholder="Enter The Product Name"
						value="${product.product_name}">
				</div>

				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label"><b>Product
							Price</b></label> <input type="number" class="form-control" name="price"
						id="price" placeholder="Enter The Product Price"
						value="${product.price}" min="0">
				</div>


				<div class="mb-3">
					<label for="description" class="form-label"><b>Product
							Description</b></label>
					<textarea class="form-control" id="description" name="description"
						rows="3" placeholder="Enter Product Description">${product.description}</textarea>
				</div>

				<div class="mb-3 text-center">


					<a href="${pageContext.request.contextPath}/index"
						class="btn btn-outline-danger">Back</a> <input type="submit"
						class="btn btn-outline-success" value="Update Product">
				</div>
			</div>
		</form>
	</div>

</body>
</html>