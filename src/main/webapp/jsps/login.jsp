<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<style>
* {
	box-sizing: border-box;
	margin: auto;
	padding:0;
}

.login-container {
	border-radius:25px;
}
</style>
<title>Login</title>
</head>
<body>


	<div class="login-container mt-5 w-50 px-5 py-4" style="background-color:#f7f7f9">
		<h1 class="text-center text-primary">Σύνδεση</h1>
		<form action="${pageContext.request.contextPath}/login" method="POST">
			<div class="mb-3">
			  <label for="email" class="form-label">Email address</label>
			  <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
			  <label for="password" class="form-label">Password</label>
			  <input type="password" name="password" class="form-control" id="exampleInputPassword1">
			</div>
			<div class="center text-danger">
				<c:if test="${error}">
					<p>Error in login</p>
				</c:if>		
			</div>	
			<div class="d-grid gap-2 col-10 p-2 mx-auto">
				<button type="submit" class="btn btn-success btn-md">Log in</button>
			</div>
			
		</form>
	</div>
	<nav class="navbar fixed-bottom navbar-dark" style="background-color: #545e66;">
	  <a class="navbar-brand">Copyright&#169; Teacher App 2022 by Aggeliki</a>
	</nav>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
</body>
</html>