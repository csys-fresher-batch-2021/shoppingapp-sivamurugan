<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<style type="text/css">

.login-section {
	border: 5px solid #458809;
	padding: 10px;
	margin: auto;
	margin-top: 4%;
	width: 600px;
	height : 300px;
	background-color: #DEFDC2;
}

input[type=text], [type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}

input {
	padding: 5px 12px;
	margin: 5px 0;
	color: #458809;
	box-sizing: border-box;
	border: 2px solid #458809;
	border-bottom: 2px solid #458809;
}

.head{
	text-align: center;
	color:#167712;
}
</style>
</head>
<body class="login-body">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<section class="login-section">
			<h2 class="head">Login Page</h2>
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