<!DOCTYPE html>
<%@page import="in.siva.model.OrderItem"%>
<%@page import="in.siva.model.OrderDetail"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<title>Vegetable Shopping App</title>
<style>
.overview th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #F2AE4D;
	color: white;
}

.overview {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

.overview td, #overview th {
	border: 3px solid #ddd;
	padding: 8px;
}

.overview tr:nth-child(even) {
	background-color: #E8E8E8;
}

.overview tr:hover {
	background-color: #ddd;
}

.vegDetails table, th, td {
	border: 1px solid black;
	margin-left: auto;
	margin-right: auto;
	width: 200px;
	text-align: center;
}

.vegDetails th, td {
	padding: 5px;
}

.vegDetails th {
	text-align: left;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<%
	List<OrderDetail> orderDetails = (List<OrderDetail>) request.getAttribute("myOrders");
	if (orderDetails == null) {
	%>
	<h4>Sorry! Your orders is empty.</h4>
	<%
	} else {
		int j=1;
		for (OrderDetail order : orderDetails) {
	%>
	<figure>
		<figcaption>Your Orders</figcaption>
		<table class="overview">
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Username</th>
					<th scope="col">Total Bill (Rs)</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=j%></td>
					<td><%=order.getUsername()%></td>
					<td><%=order.getTotalBill()%></td>
					<td><%=order.getStatus()%></td>
				</tr>
				<br />
				<br />
				<table class="vegDetails">
					<thead>
						<tr>
							<th scope="col">S.No</th>
							<th scope="col">vegetable Name</th>
							<th scope="col">Vegetable Price (Rs)</th>
							<th scope="col">Quantity (Kg)</th>
							<th scope="col">Amount (Rs)</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<OrderItem> orderItems = order.getOrderItems();
						int i = 1;
						for (OrderItem vegetable : orderItems) {
						%>
						<tr>
							<td><%=i%></td>
							<td><%=vegetable.getVegName()%></td>
							<td><%=vegetable.getPrice()%></td>
							<td><%=vegetable.getQuantity()%></td>
							<td><%=vegetable.getEachVegPrice()%></td>
						</tr>
						<%
						i++;
						}
						j++;
						}
						}
						%>
					</tbody>
				</table>
			</tbody>
		</table>
	</figure>
</body>
</html>
