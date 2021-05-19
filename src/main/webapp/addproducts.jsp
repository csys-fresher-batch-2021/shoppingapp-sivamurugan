<%@page import="in.siva.service.ProductService"%>
<%@page import="in.siva.model.ProductDetail"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<form action = "AddProductServlet" method = "post">
		<figure>
		<figcaption>Add Product</figcaption>
		<table>
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
					<input type = "text" name = "productName" placeholder = "Produt Name"  required autofocus>
				</td>
			</tr>
			<tr>
				<td>
					Price 
				</td>
				<td>
					<input type = "number" name = "productPrice" min = 1 max = 200 placeholder = "Produt price in Rs" required>
				</td>
			</tr>
			<tr>
				<td>
					Quantity 
				</td>
				<td>
					<input type = "number" name = "productQuantity" placeholder = "Produt quantity in Kg" min = 1 max = 500 required>
				</td>
			</tr>
			<tr>
				<td>
					Category 
				</td>
				<td>
					<select name = "category" required>
					<option value = "V">Vegetables</option>
					<option value = "F"> Fruits </option>
					</select>
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