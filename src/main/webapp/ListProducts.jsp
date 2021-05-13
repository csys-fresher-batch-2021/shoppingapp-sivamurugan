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
			<th scope = "col">
				S.No
			</th>
			<th scope = "col">
				Category
			</th>
			<th scope = "col">
				Name
			</th>
			<th scope = "col">
				Price (Rs)
			</th>
			<th scope = "col">
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
				<%=product.getProductCategory()%>
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

	</main>
</body>
</html>