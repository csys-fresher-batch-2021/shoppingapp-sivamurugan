<!DOCTYPE html>
<html lang="en">
<head>
<title>Remove Account</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="RemoveAccountServlet" method="post">
		<label for="Username">Username :</label>
		<input type="text" name = "username" placeholder="Enter Username" required>
		
		<button type="submit" class="btn btn-danger">Remove Account</button>
		</form>
		

	</main>
</body>
</html>
