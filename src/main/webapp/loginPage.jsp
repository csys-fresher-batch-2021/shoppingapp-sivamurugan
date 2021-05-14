<!DOCTYPE html>
<html lang="en">
<head>
<title>MyApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Login Page</h3>
		<form action="LoginValidationServlet" method = "post">
			<label for="username"> Username :</label>
			<input type="text" name = "username" placeholder="Enter Username" autofocus required><br/>
		
			<label for="password">Password :</label>
			<input type="password" name="password" placeholder="Enter Password" required><br/>
			
			<label for = "role">Role :</label>
			<select name = "role">
			<option value = "User">USER</option>
			<option value = "Admin">ADMIN</option>
			</select>
		
			<button type="submit" class = "btn btn-primary">Submit</button>
			<button type="reset" class = "btn btn-danger">Clear</button>
			<a href = "newUserRegistration.jsp" class = "btn btn-info">New User? Register here</a>
		</form>

	</main>
</body>
</html>