<!DOCTYPE html>
<%@page import="in.siva.util.DateTimeUtil"%>
<%@page import="in.siva.model.OrderItem"%>
<%@page import="in.siva.model.OrderDetail"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<title>My Orders</title>
<style>
.body{
	background-color: #F4FCFD;
}
.title{
	text-align: center;
	color: #053A73;
	font-size: 30px; 
}
.overview th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #053A73;
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
.table-design{
	margin-left:50px;
	margin-right:50px;
}
.table-bordered, thead, th, td{
	border: 1px solid black !important;
}

</style>
</head>
<body class="body">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<%
	List<OrderDetail> orderDetails = (List<OrderDetail>) request.getAttribute("myOrders");
	if (orderDetails == null || orderDetails.isEmpty()) {
	%>
	<h4>Sorry! Your orders is empty.</h4>
	<%
	} else {
	int j = 1;
	%>

	<h4 class="title">Your Orders</h4>

	<%
	for (OrderDetail order : orderDetails) {
	%>
	<div class="table-design">
		<table class="overview">
			<caption></caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Name</th>
					<th scope="col">Total Bill (Rs)</th>
					<th scope="col">Status</th>
					<th scope="col">Cancellation</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=j%></td>
					<td><%=order.getUsername()%></td>
					<td><%=order.getTotalBill()%></td>
					<td><%=order.getStatus()%></td>
					<%
					if (order.getStatus().equals("PENDING")) {
					%>
					<td><button class="btn btn-danger"
							onclick="cancelOrder(<%=order.getOrderId()%>)">Cancel</button> 
					<%
 					} else if (order.getStatus().equals("CANCELED") &&

 						DateTimeUtil.isDeliveryIsAfterTodayDate(order.getDeliveryDate())) {
 					%>
					<td><button class="btn btn-success"
							onclick="reOrder(<%=order.getOrderId()%>)">Re-Order</button> 
					<%
 					} else {
 					%>
					<td>---</td>
					<%
					}
					%>
				</tr>
				<table class="table table-bordered">
					<thead id="vegHead">
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
	</div>
</body>
<script type="text/javascript">
/**
 * This method is called when user clicks cancel order and it will set order status as canceled
 */
function cancelOrder(orderId){
	event.preventDefault();
	let value = confirm("Do You want to cancel this order ?");
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

/**
 * This method is called when user wants to buy canceled orders. Status of order is set as pending
 */
function reOrder(orderId){
	event.preventDefault();
	let value = confirm("Do You want to re-order this order ?");
	if(value){
		let status = "PENDING"
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
