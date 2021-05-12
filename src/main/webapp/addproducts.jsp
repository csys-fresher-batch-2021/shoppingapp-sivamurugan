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
	
	
	<%
	// Scriplets (Java Code)
	String infoMessage = request.getParameter("infoMessage");
	if(infoMessage != null){
		out.println("<font color='green'>" + infoMessage + "</font>");
	}
	
	String errorMessage = request.getParameter("errorMessage");
	if(errorMessage != null){
		out.println("<font color='red'>" + errorMessage + "</font>");
	}
	%>
	<form action = "AddProductsServlet" method = "post">
		<h3>Add Products</h3>
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
					<option value = "vegetables">Vegetables</option>
					<option value = "fruits"> Fruits </option>
					</select>
				</td>
			</tr>
		</table><br>
		
		<button type = "submit" class = "btn btn-info">Submit</button>

	</form>
	</main>
	

</body>
</html>