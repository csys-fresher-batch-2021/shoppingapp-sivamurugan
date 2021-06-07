<!DOCTYPE html>
<%@page import="in.siva.dao.VegDetailDAO"%>
<%@page import="in.siva.model.VegDetail"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<title>Vegetable Shopping App</title>
<style>
.vegDetails th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #047A76;
	color: white;
}

.vegDetails {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

.vegDetails td, #vegDetails th {
	border: 1px solid #ddd;
	padding: 8px;
}

.vegDetails tr:nth-child(even) {
	background-color: #f2f2f2;
}

.vegDetails tr:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Welcome to VegShop</h3>
		<figure>
			<figcaption>List Of Vegetables</figcaption>
			<table class="vegDetails">
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Name</th>
					<th scope="col">Price (Rs)</th>
					<th scope="col">Available Quantity (Kg)</th>
				</tr>
				<%
				int i = 0;
				List<VegDetail> vegetables = VegDetailDAO.findAll();
				for (VegDetail veg : vegetables) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=veg.getName()%></td>
					<td><%=veg.getPrice()%> /-</td>
					<td><%=veg.getQuantity()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</figure>
	</main>
</body>
</html>
