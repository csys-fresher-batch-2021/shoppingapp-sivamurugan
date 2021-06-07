<!DOCTYPE html>
<%@page import="in.siva.service.SalesService"%>
<%@page import="in.siva.model.BillDetail"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
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

form {
	border: 5px solid #047A76;
	padding: 10px;
	margin: auto;
	margin-top: 0%;
	width: 600px;
}
.discount{
	border: 5px solid #31760B;
	background-color: #EBFCE2;
	padding: 10px;
	margin: auto;
	margin-top: 0%;
	width: 600px;
}

input[type=date], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}

#couponOptions {
	display: none;
}

#notAvailable {
	display: none;
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
		<section class="discount">
			<label>You can use your discount coupons by clicking here --></label>
			<button onclick="applyCoupon(<%=totalBill%>)" class="btn btn-info">Click
				Here</button>
			<h6 id="notAvailable"></h6>
			<select name="couponOptions" id="couponOptions"
				onchange="findTotalAfterDiscount(<%=totalBill%>)"></select>
			<section id="isDiscountAvailable"></section>
			<h4 id="showFinalBill"></h4>
		</section><br/>
		<form action="OrderConfirmServlet" method="post">
			<input type="hidden" id="totalBill" name="finalBill"
				value="<%=totalBill%>" /> <input type="hidden" id="index"
				name="index" /> <label for="deliveryDate"><strong>Select
					Delivery Date :</strong></label> <input type="date" id="deliveryDate" name="date"
				required> <label for="info">(You can't order
				vegetables in future for more than 5 days)</label><br /> <br /> <label
				for="address"><strong>Address :</strong></label><br />
			<textarea id="address" name="address" rows="4" cols="50"
				minlength="20" maxlength="200" required></textarea>
			<br /> <br /> <label for="paymentMethod"><strong>Select
					Your Payment method:</strong></label> <select name="paymentMethod" required>
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

	/**
	 * This method is used to set current date in html page in default
	 */
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
	
/**
 * This method is used to apply discount coupon if user wants to apply discount
 */
	function applyCoupon(totalBill){
		let url = "GetCouponServlet";
		fetch(url).then(res=> res.json()).then(res=>{
			let couponDetails = res;
			let content ="";
			let value = "";
			document.querySelector("#totalBill").value = totalBill;
			if(couponDetails == null){
				showNotAvailable();
				value += "Sorry! No Discount coupons Available for your account";
				document.querySelector("#notAvailable").innerHTML = value;
			} else{
				showSelectOption();
				let i=0;
				content += "";
				content += "<option value='-1' selected data-default>I don't want discount</option>";
				for(let discount of couponDetails){
					content += "<option value = " + i + ">Code :" +  discount.coupon + ",  Rs - " + discount.amount + "</option>";
					i++;
				}
				
				document.querySelector("#couponOptions").innerHTML = content;
			}
		});
	}
/**
 * This method is used to show available discounts if button clicked
 */
	function showSelectOption(){
		document.getElementById("couponOptions").style.display = "block";
	}
/**
 * This method is used to show no discount available if no discounts available
 */
	function showNotAvailable(){
		document.getElementById("notAvailable").style.display = "block";
	}
/**
 * This method is used to set total bill amount after discount applied\
 * This method also sets value of total bill, index of coupon to servlet
 */
	function findTotalAfterDiscount(totalBill){
		let url = "GetCouponServlet";
		let finalBill = totalBill;
		let value = document.querySelector("#couponOptions").value;
		let billValue = "Your bill amount after considering discount (Rs)  : ";
		let content = "";
		fetch(url).then(res=> res.json()).then(res=>{
			let couponDetails = res;
			if(value==-1){
				billValue += finalBill;
				content += "<p>Discount not selected</p>";
			}else{
				let discount = couponDetails[value].amount;
				if((discount + 100) > (totalBill)){
					content += "<p style='color:white; background-color:red;'>Sorry! You cannot use this discount for this order. Please select other discount</p>";
					billValue += finalBill;
				} else{
					content += "<p style='color:white; background-color:#32C617;'>Congratulations! You can use this discount</p>";
					finalBill = totalBill - discount;
					billValue += finalBill;
				}
			}
			document.querySelector("#index").value = value;
			document.querySelector("#totalBill").value = finalBill;
			document.querySelector("#isDiscountAvailable").innerHTML = content;
			document.querySelector("#showFinalBill").innerHTML = billValue;
		});
	}
</script>
</html>
