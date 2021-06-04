<!DOCTYPE html>
<html lang="en">
<head>
<title>Vegetable Shopping App</title>
</head>
<style>
form {
	border: 5px solid #094C77;
	padding: 10px;
	margin: auto;
	margin-top: 4%;
	width: 600px;
	background-color: #D3EBFB;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<form action="DeliveryManServlet">
		<ul>
			<li>Welcome..</li>
			<li>Hope you are doing well.</li>
			<li>How many deliveries you can deliver today? Let's find out by
				clicking below</li>
		</ul>
		<button type="submit" class="btn btn-success">Let's Go</button>
	</form>
</body>
</html>