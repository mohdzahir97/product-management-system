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
			<h1 class="text-center">${exits}</h1>
			<h1 class="text-center">User Login</h1>
		</div>
		<form action="user-login" method="post">
			<div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label"><b>User
							Name</b></label> <input type="text" class="form-control" name="uname"
						id="uname" placeholder="Enter The User Name" >
				</div>

				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label"><b>Password</b></label>
					<input type="password" class="form-control" name="upassword"
						id="upassword" placeholder="Enter The Password">
				</div>

				<div class="mb-3 text-center">
					<a href="${pageContext.request.contextPath}/register"
						class="btn btn-outline-danger">Register</a> <input type="submit"
						class="btn btn-outline-success" value="SignIn">
				</div>
			</div>
		</form>
	</div>

</body>
</html>