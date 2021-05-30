<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<style>
section {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<section>
			<h3>Login Page</h3>
			<form action="LoginValidationServlet" method="post">
				<label for="username"> Username :</label> <input type="text"
					name="username" placeholder="Enter Username" autofocus required><br />

				<label for="password">Password :</label> <input type="password"
					name="password" placeholder="Enter Password" required><br />

				<button type="submit" class="btn btn-success">Submit</button>
				<button type="reset" class="btn btn-danger">Clear</button>
				<a href="newUserRegistration.jsp" class="btn btn-info">New User?
					Register here</a>
			</form>
		</section>
	</main>
</body>
</html>