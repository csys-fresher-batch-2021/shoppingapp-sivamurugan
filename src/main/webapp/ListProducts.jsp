<%@page import="in.siva.dao.ProductDetailDao"%>
<%@page import="in.siva.model.ProductDetail"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Products</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<figure>
			<figcaption>List Of Products (Vegetables)</figcaption>
			<table class="table table-bordered">
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Name</th>
					<th scope="col">Price (Rs)</th>
					<th scope="col">Quantity (Kg)</th>
				</tr>
				<%
				int i = 0;
				List<ProductDetail> products = ProductDetailDao.getProductDetails();
				for (ProductDetail product : products) {
					if (product.getCategory().equals("V")) {
						i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=product.getName()%></td>
					<td><%=product.getPrice()%> /-</td>
					<td><%=product.getQuantity()%></td>
				</tr>
				<%
				}
				}
				%>


			</table>
		</figure>
		
		<figure>
			<figcaption>List Of Products (Fruits)</figcaption>
			<table class="table table-bordered">
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Name</th>
					<th scope="col">Price (Rs)</th>
					<th scope="col">Quantity (Kg)</th>
				</tr>
				<%
				int j = 0;
				for (ProductDetail product : products) {
					if (product.getCategory().equals("F")) {
						j++;
				%>
				<tr>
					<td><%=j%></td>
					<td><%=product.getName()%></td>
					<td><%=product.getPrice()%> /-</td>
					<td><%=product.getQuantity()%></td>
				</tr>
				<%
				}
				}
				%>


			</table>
		</figure>

	</main>
</body>
</html>