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
	<strong>Note :</strong>
	<p>This page only contains today's pending deliveries</p>
	<%
	List<OrderDetail> orderDetails = (List<OrderDetail>) request.getAttribute("orderDetailsForDelivery");
	if (orderDetails.isEmpty()) {
	%>
	<h4>No Deliveries Available</h4>
	<%
	} else {
		%>
		<section class="table-design">
		<h4 class="title">Today's Deliveries</h4>
	<%
	int j = 1;
	for (OrderDetail order : orderDetails) {
	%>
		<figure>
			<figcaption></figcaption>
			<table class="overview">
				<thead>
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Username</th>
						<th scope="col">Total Bill (Rs)</th>
						<th scope="col">Address</th>
						<th scope="col">Status</th>
						<th scope="col">Options</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=j%></td>
						<td><%=order.getUsername()%></td>
						<td><%=order.getTotalBill()%></td>
						<td><%=order.getAddress()%></td>
						<td><%=order.getStatus() %>
						<td><button class="btn btn-success"
								onclick="delivered(<%=order.getOrderId()%>, '<%=order.getUsername()%>')">Deliver</button>
								<%
								if(!order.getStatus().equals("HOLD")){
								%>
							<button class="btn btn-danger"
								onclick="setHold(<%=order.getOrderId()%>)">Hold</button>
								<%
								}
								%>
					</tr>
					<br />
					<br />
					<table class="table table-bordered">
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
	</section>
</body>
<script>
/**
 * This method is called when salesman clicks deliver button and status of that order is set as delivered
 */
	function delivered(orderId, username){
		event.preventDefault();
		let value = confirm("Did you delivered vegetables to this destination?");
		if(value){
			let status = "DELIVERED"
			let url = "ChangeStatusServlet?orderId=" + orderId + "&status="+ status;
			axios.get(url).then(res=> {
			
				let result = res.data;
				if(result){
					alert("Successful");
					generateCoupon(username, orderId)
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
	function setHold(orderId){
		event.preventDefault();
		let value = confirm("This option is used when customer not available in given location. Are you sure to hold this order?");
		if(value){
			let status = "HOLD";
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
	* This method is used to generate coupon for a order
	*/
	function generateCoupon(username, orderId){
		let url2 = "GenerateCouponServlet?orderId=" + orderId + "&username=" + username ;
		axios.get(url2).then(res=>{
			let result = res.data;
			console.log(result);
			if(result==true){
				alert("Discount coupon generated for this order");
			}
		})
	}

</script>
</html>