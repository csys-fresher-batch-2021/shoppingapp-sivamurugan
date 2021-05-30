<!DOCTYPE html>
<html lang="en">
<head>
<title>Vegetable Shopping App</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<ul>
		<li>Welcome..</li>
		<li>Hope you are doing well.</li>
		<li>How many deliveries you can deliver today? Let's find out by clicking below</li>
	</ul>
	<form action="DeliveryManServlet">
		<button type="submit" class="btn btn-success">Let's Go</button>
	</form>
</body>
</html>