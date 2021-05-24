<!DOCTYPE html>
<html lang="en">
<head>
<title>Order Confirmed</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1>Congratulations!!! Your order has been placed Successfully.</h1>
		<a href="SelectProducts.jsp" class="btn btn-success">Buy Vegetables</a>
		<form action="LogoutServlet">
		<button type="submit" class="btn btn-danger">Logout</button>
	</form>
	</main>
</body>
</html>