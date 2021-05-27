<!DOCTYPE html>
<%@page import="in.siva.service.SalesService"%>
<%@page import="in.siva.model.BillDetail"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
<title>Confirm Order</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<figure>
			<figcaption>Confirm Your Order</figcaption>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Name</th>
						<th scope="col">Price (Rs)</th>
						<th scope="col">Quantity (Kg)</th>
						<th scope="col">Amount</th>
					</tr>
				</thead>
				<%
				List<BillDetail> billDetails = (List<BillDetail>)request.getAttribute("billDetails");
				Double totalBill = (Double)request.getAttribute("totalBill");
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
			</table>
			<h5>Your Total Bill Amount (Rs) =  <%=totalBill %></h5>
		</figure>
		<br />
		<form action="OrderConfirmServlet" method="post">
			<label for="deliveryDate">Select Delivery Date :</label>
			<input type="date" id="deliveryDate" name="date" required><br/><br/>
			<button type="submit" class="btn btn-success">Order Now</button>
			<a href="SelectVegetables.jsp" class="btn btn-danger">Back</a>
		</form>
	</main>
</body>
<script>
setDate();
function setDate(){
	let date = new Date();
	let currentDate = date.toJSON().substring(0,10);                           
    let endDate = date.setDate(date.getDate()+5); 
    let maxDate = new Date(endDate);
    let maxDateStr = maxDate.toJSON().substring(0,10);
	//let currentTime = date.substring(11,19);
	
	document.querySelector("#deliveryDate").setAttribute('value', currentDate);
	document.querySelector("#deliveryDate").setAttribute('min', currentDate);
	document.querySelector("#deliveryDate").setAttribute('max', maxDateStr);
}
</script>
</html>
