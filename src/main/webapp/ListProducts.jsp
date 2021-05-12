<%@page import="in.siva.model.ProductDetail"%>
<%@page import="java.util.List"%>
<%@page import="in.siva.service.ProductService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Products</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<figure>
		<figcaption>List Of Products</figcaption>
		<table class = "table table-bordered">
		<tr>
			<th>
				S.No
			</th>
			<th>
				Category
			</th>
			<th>
				Name
			</th>
			<th>
				Price (Rs)
			</th>
			<th>
				Quantity (Kg)
			</th>
		</tr>
			<%
			int i = 0;
				List<ProductDetail> products = ProductService.getProducts();
				for(ProductDetail product : products){
					i++;
			%>
		<tr>
			<td>
				<%= i %>
			</td>
			<td>
				<%= product.getProductcategory() %>
			</td>
			<td>
				<%=product.getProductName() %>
			</td>
			<td>
				<%=product.getProductPrice() %> /-
			</td>
			<td>
				<%=product.getProductQuantity() %>
			</td>
		</tr>
			<% 
			}
			%>
				
				
		</table>
		</figure>
		<a class = "btn btn-secondary" href = "addproducts.jsp">Add Product</a>

	</main>
</body>
</html>