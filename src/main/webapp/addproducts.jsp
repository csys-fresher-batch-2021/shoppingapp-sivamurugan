<%@page import="in.siva.service.ProductServiceManagement"%>
<%@page import="in.siva.model.ProductDetail"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>MyApp</title>
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
	<form action = "addProducts-action.jsp" method = "post">
		<h3>Add Products</h3>
		<table summary = "product details">
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
					<select name = "category">
					<option value = "vegetables">Vegetables</option>
					<option value = "fruits"> Fruits </option>
					</select>
				</td>
			</tr>
		</table><br>
		
		<button type = "submit" class = "btn btn-info">Add Products</button>

	</form>
	</main>
	

</body>
</html>