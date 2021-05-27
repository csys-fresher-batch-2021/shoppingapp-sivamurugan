<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Vegetable</title>
<style>
.addVeg th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #047A76;
	color: white;
}

.addVeg {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

.addVeg td, #vegDetails th {
	border: 1px solid #ddd;
	padding: 8px;
}

.addVeg tr:nth-child(even) {
	background-color: #f2f2f2;
}

.addVeg tr:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<form action = "AddVegetableServlet" method = "post">
		<figure>
		<figcaption>Add Vegetable</figcaption>
		<table class="addVeg">
		<tr>
		<th scope = "col">
		</th>
		<th scope = "col">
		</th>
		</tr>
		
			<tr>
				<td>
					Product Name 
				</td>
				<td>
					<input type = "text" name = "vegName" placeholder = "Produt Name"  required autofocus>
				</td>
			</tr>
			<tr>
				<td>
					Price 
				</td>
				<td>
					<input type = "number" name = "vegPrice" min = 1 max = 200 placeholder = "Produt price in Rs" required>
				</td>
			</tr>
			<tr>
				<td>
					Quantity 
				</td>
				<td>
					<input type = "number" name = "vegQuantity" placeholder = "Produt quantity in Kg" min = 1 max = 500 required>
				</td>
			</tr>
		</table>
		</figure>
		<br>
		
		<button type = "submit" class = "btn btn-info">Submit</button>

	</form>
	</main>
	

</body>
</html>