<!DOCTYPE html>
<html lang="en">
<head>
<title>Remove Product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Remove Product</h3>
		<form action="RemoveProductServlet" method ="post">
			<label for = "productName"> Product Name :</label>
			<input type = "text" name="productName" pattern = "[A-Za-z]{3,10}" 
				placeholder="Enter Product Name" autofocus required><br/>
			
			<button type="submit" class="btn btn-danger">Remove Product</button>
		</form>

	</main>
</body>
</html>
