<!DOCTYPE html>
<%@page import="in.siva.service.ProductService"%>
<%@page import="in.siva.model.ProductDetail"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<title>Buy Products</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Buy Products</h3>
		<form action="BuyProductsServlet" method="get">
			<figure>
				<figcaption>List Of Products</figcaption>
				<table class="table table-bordered">
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Category</th>
						<th scope="col">Name</th>
						<th scope="col">Price (Rs)</th>
						<th scope="col">Quantity (Kg)</th>
					</tr>

					<%
		int i = 0;
		List<ProductDetail> products = ProductService.getProducts();
		for(ProductDetail product : products){
			i++;
		%>
					<tr>
						<td><%=i %></td>
						<td><%=product.getCategory()%></td>
						<td><%=product.getName()%></td>
						<td><%=product.getPrice()%> /-</td>
						<td><input type="number"
							name="<%="quantity"+i %>" value=0></td>
						<%} %>
					
				</table>
			</figure>
			<button type="submit" class="btn btn-info">Buy</button>
		</form>

	</main>
</body>
</html>
