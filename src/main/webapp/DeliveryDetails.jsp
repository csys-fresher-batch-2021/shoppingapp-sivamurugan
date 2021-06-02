<!DOCTYPE html>
<%@page import="in.siva.model.OrderItem"%>
<%@page import="java.util.List"%>
<%@page import="in.siva.model.OrderDetail"%>
<html lang="en">
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<title>Sell Vegetables</title>
<style>
.overview th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #0EAD9D;
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
	<strong>Note :</strong><p>This page only contains today's pending deliveries</p>
		<%
		List<OrderDetail> orderDetails = (List<OrderDetail>) request.getAttribute("orderDetailsForDelivery");
		if(orderDetails.isEmpty()){
		%>
		<h4>No Deliveries Available</h4>	
		<%
		} else{
			int j = 1;
			for (OrderDetail order : orderDetails) {
		%>
		<figure>
		<figcaption>Today's Deliveries</figcaption>
		<table class="overview">
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Username</th>
					<th scope="col">Total Bill (Rs)</th>
					<th scope="col">Address</th>
					<th scope="col">Options</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=j%></td>
					<td><%=order.getUsername()%></td>
					<td><%=order.getTotalBill()%></td>
					<td><%=order.getAddress() %></td>
					<td><button class="btn btn-success"
							onclick="delivered(<%=order.getOrderId()%>)">Deliver</button>
						<button class="btn btn-danger"
							onclick="canceled(<%=order.getOrderId()%>)">Cancel</button>
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
<script>
/**
 * This method is called when salesman clicks deliver button and status of that order is set as delivered
 */
	function delivered(orderId){
		event.preventDefault();
		let value = confirm("Did you delivered vegetables to this destination?");
		if(value){
			let status = "DELIVERED"
			let url = "ChangeStatusServlet?orderId=" + orderId + "&status="+ status;
			axios.get(url).then(res=> {
			
				let result = res.data;
				if(result){
					alert("Successful");
					window.location.reload();
				}
				else{
					alert("Sorry Unable to confirm");
				}
			});
		} else{
			window.location.reload();
		}
	}
	
	/**
	* This method is called when salesman click cancel order if user rejects to buy it
	*/
	function canceled(orderId){
		event.preventDefault();
		let value = confirm("Is this user canceled order?");
		if(value){
			let status = "CANCELED";
			let url = "ChangeStatusServlet?orderId=" + orderId + "&status=" + status;
			axios.get(url).then(res=> {
				let result = res.data;
				if(result){
					alert("Successful");
					window.location.reload();
				}
				else{
					alert("Sorry Unable to confirm");
				}
			});
		} else{
			window.location.reload();
		}
	}
</script>
</html>