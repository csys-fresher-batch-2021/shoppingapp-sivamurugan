<!DOCTYPE html>
<html lang="en">
<head>
<title>Remove Account</title>
</head>
<style>
.title{
	text-align: center;
	color: #053A73;
	font-size: 30px; 
}
form {
	border: 5px solid #094C77;
	padding: 10px;
	margin: auto;
	margin-top: 4%;
	width: 600px;
	background-color: #E4F1FA;
}

input[type=text] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="RemoveAccountServlet" method="post">
			<h3 class="title">Remove User</h3>
			<label for="Username"><strong>Username :</strong></label> <input
				type="text" name="username" placeholder="Enter Username" required>

			<button type="submit" class="btn btn-danger">Remove Account</button>
		</form>


	</main>
</body>
</html>
