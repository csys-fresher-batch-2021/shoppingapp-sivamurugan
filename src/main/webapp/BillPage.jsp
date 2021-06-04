<!DOCTYPE html>
<%@page import="in.siva.service.SalesService"%>
<%@page import="in.siva.model.BillDetail"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
<title>Confirm Order</title>
<style type="text/css">
.bill th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #79A814;
	color: white;
}

.bill {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

.bill td, .bill th {
	border: 2px solid #ddd;
	padding: 8px;
}

.bill tr:nth-child(even) {
	background-color: #F1EEEE;
}

.bill tr:hover {
	background-color: #ddd;
}

form{
	border: 5px solid #047A76;
	padding: 10px;
	margin: auto;
	margin-top: 0%;
	width: 600px;
}

input[type=date] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<figure>
			<figcaption>Confirm Your Order</figcaption>
			<table class="bill">
				<thead>
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Name</th>
						<th scope="col">Price (Rs)</th>
						<th scope="col">Quantity (Kg)</th>
						<th scope="col">Amount (Rs)</th>
					</tr>
				</thead>
				<%
				List<BillDetail> billDetails = (List<BillDetail>) request.getAttribute("billDetails");
				Double totalBill = (Double) request.getAttribute("totalBill");
				int i = 0;
				for (BillDetail vegDetail : billDetails) {
					i++;
				%>
				<tbody>
					<tr>
						<td><%=i%>
						<td><%=vegDetail.getVegName()%></td>
						<td><%=vegDetail.getPrice()%></td>
						<td><%=vegDetail.getQuantity()%></td>
						<td><%=vegDetail.getEachVegBill()%></td>
					</tr>
				</tbody>
				<%
				}
				%>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><strong>Total Bill Amount (Rs) :</strong></td>
					<td><strong><%=totalBill%></strong></td>
				</tr>
			</table>
		</figure>
		<br />
		<form action="OrderConfirmServlet" method="post">
			<label for="deliveryDate"><strong>Select Delivery Date :</strong></label> <input
				type="date" id="deliveryDate" name="date" required> <label
				for="info">(You can't order vegetables in future for more
				than 5 days)</label><br /> <br /> <label for="address"><strong>Address :</strong></label><br />
			<textarea id="address" name="address" rows="4" cols="50"
				minlength="20" maxlength="200" required></textarea>
			<br /> <br /> <label for="paymentMethod"><strong>Select Your
				Payment method:</strong></label> <select name="paymentMethod" required>
				<option disabled>---SELECT---</option>
				<option value="Net Banking">NET BANKING</option>
				<option value="UPI ID">UPI ID</option>
				<option value="Credit Card">CREDIT CARD</option>
				<option value="Debit Card">DEBIT CARD</option>
				<option value="Cash On Delivery">CASH ON DELIVERY</option>
			</select><br />
			<button type="submit" class="btn btn-success">Order Now</button>
			<a href="SelectVegetables.jsp" class="btn btn-danger">Back</a>
		</form>
	</main>
</body>
<script>
	setDate();
	function setDate() {
		let date = new Date();
		let currentDate = date.toJSON().substring(0, 10);
		let endDate = date.setDate(date.getDate() + 5);
		let maxDate = new Date(endDate);
		let maxDateStr = maxDate.toJSON().substring(0, 10);
		//let currentTime = date.substring(11,19);

		document.querySelector("#deliveryDate").setAttribute('value',
				currentDate);
		document.querySelector("#deliveryDate")
				.setAttribute('min', currentDate);
		document.querySelector("#deliveryDate").setAttribute('max', maxDateStr);
	}
</script>
</html>
