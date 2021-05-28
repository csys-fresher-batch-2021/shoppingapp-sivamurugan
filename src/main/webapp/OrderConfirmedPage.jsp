<!DOCTYPE html>
<html lang="en">
<head>
<title>Order Confirmed</title>
</head>
<style>
h1 {
	text-align: center;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1>Congratulations!!! Your order confirmed</h1>
		<a href="SelectVegetables.jsp" class="btn btn-success">Buy
			Vegetables</a>
		<form action="LogoutServlet">
			<button type="submit" class="btn btn-danger">Logout</button>
		</form>
	</main>
</body>
</html>