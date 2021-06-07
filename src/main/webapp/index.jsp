<!DOCTYPE html>
<%@page import="in.siva.dao.VegDetailDAO"%>
<%@page import="in.siva.model.VegDetail"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<title>Vegetable Shopping App</title>
<style type="text/css">
.info {
	border: 2px solid #31760B;
	color: black;
	background-color: #EEFEE5;
	margin: 4px;
	font-size: 15px;
}

.note {
	border: 2px solid #CC152E;
	color: black;
	background-color: #FDEEF0;
	margin: 4px;
	font-size: 15px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid"></main>
	<h3>Welcome to VegShop</h3>
	<section class="info">
		<ul>
			<strong>Announcement :</strong>
			<li>Discounts available for purchase more than Rs. 1000</li>
			<li>You will get a discount coupon according to your bill amount</li>
			<li>You can use this discount coupon on your next order</li>
			<li>Rs.50 worth discount coupon, if your bill amount s between
				Rs.1000 to 2000</li>
			<li>Rs.150 worth discount coupon, if your bill amount is between
				Rs.2000 to 3000</li>
			<li>Rs.300 worth discount coupon, if your bill amount is between
				Rs.3000 to 4000</li>
			<li>Rs.450 worth discount coupon, if your bill amount is between
				Rs.4000 to 5000</li>
			<li>Rs.600 worth discount coupon, if your bill amount is more
				than Rs.5000</li>
		</ul>
	</section>
	<section class="note">
		<ul>
			<strong>Note:</strong>
			<li>This discount coupon will expire after 2 months after order
				confirmed date</li>
			<li>You cannot retrieve your discount coupon if you canceled
				discount applied order</li>
			<li>Bill amount of minimum Rs.100 required after applying
				discount coupon to use that discount coupon</li>
			<li>This discount is only available for short period of time.
				Hurry Up!!</li>
		</ul>
	</section>
</body>
</html>
