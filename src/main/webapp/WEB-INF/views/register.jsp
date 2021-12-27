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

	<div class="container mt-5 w-50">
		<div>
		<h1 class="text-center">${exits }</h1>
			<h1 class="text-center">User Registration</h1>
		</div>
		<form action="user-register" method="post">
			<div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label"><b>User Name</b></label> 
							<input type="text" class="form-control" name="uname"
						id="uname" placeholder="Enter The User Name">
				</div>
				
					<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label"><b>Password</b></label> 
							<input type="password" class="form-control" name="upassword"
						id="upassword" placeholder="Enter The Password">
				</div>
				
					<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label"><b>Confirm Password</b></label> 
							<input type="password" class="form-control" name="ucpassword"
						id="ucpassword" placeholder="Enter The Confrim Password">
				</div>

			

				<div class="mb-3 text-center">
					<a href="${pageContext.request.contextPath}/"
						class="btn btn-outline-danger">Login</a> <input type="submit"
						class="btn btn-outline-success" value="SignUp">
				</div>
			</div>
		</form>
	</div>

</body>
</html>