<!DOCTYPE html>
<html lang="en">
<head>
<title>Remove Vegetable</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Remove Vegetable</h3>
		<form action="RemoveVegetableServlet" method ="post">
			<label for = "vegName"> Vegetable Name :</label>
			<input type = "text" name="vegName" pattern = "[A-Za-z]{3,10}" 
				placeholder="Enter Vegetable Name" autofocus required><br/>
			
			<button type="submit" class="btn btn-danger">Remove Vegetable</button>
		</form>

	</main>
</body>
</html>
