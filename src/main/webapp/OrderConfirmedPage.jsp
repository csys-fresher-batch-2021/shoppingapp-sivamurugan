<!DOCTYPE html>
<html lang="en">
<head>
<title>Order Confirmed</title>
</head>
<style>
h1 {
	text-align: center;
}

form {
	border: 5px solid #094C77;
	padding: 10px;
	margin: auto;
	margin-top: 4%;
	width: 600px;
	height: 200px;
	background-color: #E4F1FA;
}

.buttons{
	margin-left: 29%;
	margin-top: 5%;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="LogoutServlet">
			<h1>Congratulations!!! Your order confirmed</h1>
			<section class="buttons">
				<a href="SelectVegetables.jsp" class="btn btn-success">Buy
					Vegetables</a>
				<button type="submit" class="btn btn-danger">Logout</button>
			</section>
		</form>
	</main>
</body>
</html>