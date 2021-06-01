<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<style type="text/css">
.login {
	width: 100%;
	background-color: #E8E8E8;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid white;
	border-radius: 4px;
}

::placeholder {
	font-family: Parkavenue, sans-serif;
	opacity: 1;
}

h2 {
	text-align: center;
	font-family: Parkavenue, cursive;
}

.login-section {
	width: 800px;
	border-radius : 5px;
	margin: 0 auto;
	background-color: white;
}

.login-body{
	background-color: #C6C3C3;
}
</style>
</head>
<body class="login-body">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<section class="login-section">
			<h2>Login Page</h2>
			<form action="LoginValidationServlet" method="post">
				<input type="text" class="login" name="username"
					placeholder="Enter Username" autofocus required><br /> <input
					type="password" class="login" name="password"
					placeholder="Enter Password" required><br />

				<button type="submit" class="btn btn-success">Submit</button>
				<button type="reset" class="btn btn-danger">Clear</button>
				<a href="newUserRegistration.jsp" class="btn btn-secondary">New
					User? Register here</a>
			</form>
		</section>
	</main>
</body>
</html>