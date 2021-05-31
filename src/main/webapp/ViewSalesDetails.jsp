<!DOCTYPE html>
<html lang="en">
<head>
<title>Sales Details</title>
<style>
#salesDetailsTable th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #000E89;
	color: white;
}

#salesDetailsTable {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#salesDetailsTable td, #salesDetailsTable th {
	border: 1px solid #ddd;
	padding: 8px;
}

#salesDetailsTable tr:nth-child(odd) {
	background-color: #ECECEC;
}

#salesDetailsTable tr:nth-child(even) {
	background-color: #E1F7FF;
}

#salesDetailsTable tr:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1>Get Order Details</h1>
		<label for="username">Type username of user to get order
			details</label><br /> <input type="text" id="username"
			placeholder="Enter username" required>
		<button class="btn btn-info" onclick="searchOrders()">Search</button>
		<br />

		<section id="searchOrders">
			<figure>
				<figcaption>Sales Details</figcaption>
				<table id="salesDetailsTable">
					<tr>
						<th scope="col">Order ID</th>
						<th scope="col">Username</th>
						<th scope="col">Vegetable</th>
						<th scope="col">Quantity (Kg)</th>
						<th scope="col">Amount (Rs)</th>
						<th scope="col">Ordered Date</th>
						<th scope="col">Ordered Time</th>
						<th scope="col">Delivery Date</th>
						<th scope="col">Payment method</th>
						<th scope="col">Status</th>

					</tr>
					<tbody id="searchOrderDetails">
					</tbody>
				</table>
			</figure>
		</section>
		<p id="notFound"></p>

		<label for="date">Get order details of a specific day sales</label><br />
		<input type="date" id="date" required>
		<button class="btn btn-info" onclick="getOrdersByDate()">Submit</button>

		<section id="searchOrdersByDate">
			<figure>
				<figcaption>Sales Details</figcaption>
				<table id="salesDetailsTable">
					<tr>
						<th scope="col">Order ID</th>
						<th scope="col">Username</th>
						<th scope="col">Vegetable</th>
						<th scope="col">Quantity (Kg)</th>
						<th scope="col">Amount (Rs)</th>
						<th scope="col">Ordered Date</th>
						<th scope="col">Ordered Time</th>
						<th scope="col">Delivery Date</th>
						<th scope="col">Payment method</th>
						<th scope="col">Status</th>
					</tr>
					<tbody id="ordersByDateBody">
					</tbody>
				</table>
			</figure>
		</section>
		<p id="notFoundForDate"></p>

		<label for="date">Get order details for a specific delivery
			date</label><br /> <input type="date" id="deliveryDate" required>
		<button class="btn btn-info" onclick="getOrdersByDeliveryDate()">Submit</button>

		<section id="ordersByDeliveryDate">
			<figure>
				<figcaption>Sales Details</figcaption>
				<table id="salesDetailsTable">
					<tr>
						<th scope="col">Order ID</th>
						<th scope="col">Username</th>
						<th scope="col">Vegetable</th>
						<th scope="col">Quantity (Kg)</th>
						<th scope="col">Amount (Rs)</th>
						<th scope="col">Ordered Date</th>
						<th scope="col">Ordered Time</th>
						<th scope="col">Delivery Date</th>
						<th scope="col">Payment method</th>
						<th scope="col">Status</th>
					</tr>
					<tbody id="ordersByDeliveryDateBody">
					</tbody>
				</table>
			</figure>
		</section>
		<p id="notFoundForDelivery"></p>

		<br /> <label for="info">Get all order details here :</label>
		<button class="btn btn-danger" onclick="viewAllFunc()">View
			All</button>
		<section id="viewAll">
			<figure>
				<figcaption>Sales Details</figcaption>
				<table id="salesDetailsTable">
					<tr>
						<th scope="col">Order ID</th>
						<th scope="col">Username</th>
						<th scope="col">Vegetable</th>
						<th scope="col">Quantity (Kg)</th>
						<th scope="col">Amount (Rs)</th>
						<th scope="col">Ordered Date</th>
						<th scope="col">Ordered Time</th>
						<th scope="col">Delivery Date</th>
						<th scope="col">Payment method</th>
						<th scope="col">Status</th>
					</tr>
					<tbody id="allSalesDetails">
					</tbody>

				</table>
			</figure>
		</section>
	</main>
</body>

<script type="text/javascript">

// Calling default function to hide values initially
defaultFunc();

// Calling setDate to set value & max of date field initially
setDate();

/**
 * This method is used to hide table contents initially.
 * It takes section id's and set as display = none
 */
function defaultFunc(){
	let viewAllOrdersTable = document.getElementById("viewAll");
	viewAllOrdersTable.style.display="none";
	
	let searchOrdersByUsernameTable = document.getElementById("searchOrders");
	searchOrdersByUsernameTable.style.display = "none";
	
	let getOrdersByDateTable = document.getElementById("searchOrdersByDate");
	getOrdersByDateTable.style.display = "none";
	
	let getOrdersByDeliveryDate = document.getElementById("ordersByDeliveryDate");
	getOrdersByDeliveryDate.style.display = "none";
}

/**
 * This method is used to set current date as default and max value
 * By this user cannot choose future days
 */
function setDate(){
	let date = new Date();
	let currentDate = date.toJSON().substring(0,10);
	//let currentTime = date.substring(11,19);
	
	let endDate = date.setDate(date.getDate()+5); 
    let maxDate = new Date(endDate);
    let maxDateStr = maxDate.toJSON().substring(0,10);
	
	document.querySelector("#date").setAttribute('value', currentDate);
	document.querySelector("#date").setAttribute('max', currentDate);
	
	document.querySelector("#deliveryDate").setAttribute('value', currentDate);
	document.querySelector("#deliveryDate").setAttribute('min', currentDate);
	document.querySelector("#deliveryDate").setAttribute('max', maxDateStr);
}

/**
 * This method is used to show all sales details in page
 * It will fetch all order details from "SalesDetailsServlet" as JSON and details have been printed
 */
function salesDetails(){
	let url = "SalesDetailsServlet";
	fetch(url).then(res=> res.json()).then(res=>{
		let salesList = res;
		writeAllData(salesList);
	});
}

/**
 * If view All button  clicked then this function is called so details of order hs been printed in page
 * Toggle button method used
 */
function viewAllFunc(){
	event.preventDefault();
	let value = confirm("It's hard to find your required order details from all orders. Do you want to continue?");
	if(value==true){
		var table = document.getElementById("viewAll");
		salesDetails();
	  	if (table.style.display === "none") {
	    	table.style.display = "block";
	  	} else {
	    	table.style.display = "none";
	  	}
	} else{
		window.location.href="ViewSalesDetails.jsp";
	}
}


/**
 * This method used to print all contents of order details
 */
function writeAllData(salesList){
	let content = "";
	let i=0;
	for(let orderDetails of salesList){
		i++;
		let time = orderDetails.createdDate.substring(13,24);
		let date = orderDetails.createdDate.substring(0,12);
		let orderItems = orderDetails.orderItems;
		for(let vegetable of orderItems){
			content += "<tr><td>" + orderDetails.orderId + "</td><td>" + orderDetails.username +
			"</td><td>" + vegetable.vegName + "</td><td>" + vegetable.quantity + 
			"</td><td>" + vegetable.eachVegPrice + "</td><td>"  + date +
			"</td><td>" + time + "</td><td>" + orderDetails.deliveryDate + "</td><td>" +
			orderDetails.paymentMethod + "</td><td>" + orderDetails.status + "</td></tr>";
		}
		
		content+="<br/>"
	} 
	document.querySelector("#allSalesDetails").innerHTML= content;
}


function searchOrderFunc(){
	var table = document.getElementById("searchOrders");
	  if (table.style.display === "none") {
	    table.style.display = "block";
	  } else {
	    table.style.display = "none";
	  }
}

/**
 * This method is called when user enters username and clicked search button
 * This method filtered entered username purchase records and show in page
 */
function searchOrders(){
	event.preventDefault();
	let username = document.querySelector("#username").value;
	if(username.length==0){
		alert("Please enter username");
		window.location.href="ViewSalesDetails.jsp";
	}
	let url = "SalesDetailsServlet";
	fetch(url).then(res=> res.json()).then(res=>{
		let salesList = res;
		let filtered = salesList.filter(s => String(s.username).startsWith(username));
		writeSearchContent(filtered);
	});
	
}

/**
 * This method will print NO DATA FOUND if no records found
 * Else it will print the filtered data by username in page
 */
function writeSearchContent(filtered){
	if(filtered.length == 0){
		let data = "No Data Found";
		document.querySelector("#notFound").innerHTML= data;
	} else{
		searchOrderFunc();
		writeTableData(filtered);
	}
}

/**
 * This method is used to write specific username's purchase records in table
 */
function writeTableData(filtered){
	let content = "";
	let vegTable = ""
	let i=0;
	for(let orderDetails of filtered){
		i++;
		let time = orderDetails.createdDate.substring(13,24);
		let date = orderDetails.createdDate.substring(0,12);
		let orderItems = orderDetails.orderItems;
		for(let vegetable of orderItems){
			content += "<tr><td>" + orderDetails.orderId + "</td><td>" + orderDetails.username +
			"</td><td>" + vegetable.vegName + "</td><td>" + vegetable.quantity + 
			"</td><td>" + vegetable.eachVegPrice + "</td><td>"  + date +
			"</td><td>" + time + "</td><td>" + orderDetails.deliveryDate + "</td><td>" +
			orderDetails.paymentMethod + "</td><td>" + orderDetails.status + "</td></tr>";
		}
		
		content+="<br/>"
	} 
	
	document.querySelector("#searchOrderDetails").innerHTML= content;
}

/**
 * This method is called when user enters date and clicks submit button
 * It will filter the specific date purchase records
 */
function getOrdersByDate(){
	event.preventDefault();
	let date = document.querySelector("#date").value;
	let url = "SalesDetailsServlet";
	fetch(url).then(res=> res.json()).then(res=>{
		let salesList = res;
		let filtered = salesList.filter(s => String(convertDateTime(s.createdDate)).startsWith(date));
		writeContent(filtered);
	});
}

/**
 * This method is used to convert Database time format to JSON time format
 */
function convertDateTime(dateTime){
	let parseDate = Date.parse(dateTime);
	let jsDateTime = new Date(parseDate);
	let jsDate = jsDateTime.toJSON().substring(0,10);
	return jsDate;
}

/**
 * This method is used to write contents in a specific day in page
 */
function writeOrdersByDate(filtered){
	let content = "";
	let vegTable = ""
	let i=0;
	for(let orderDetails of filtered){
		i++;
		let time = orderDetails.createdDate.substring(13,24);
		let date = orderDetails.createdDate.substring(0,12);
		let orderItems = orderDetails.orderItems;
		for(let vegetable of orderItems){
			content += "<tr><td>" + orderDetails.orderId + "</td><td>" + orderDetails.username +
			"</td><td>" + vegetable.vegName + "</td><td>" + vegetable.quantity + 
			"</td><td>" + vegetable.eachVegPrice + "</td><td>"  + date +
			"</td><td>" + time + "</td><td>" + orderDetails.deliveryDate + "</td><td>" +
			orderDetails.paymentMethod + "</td><td>" + orderDetails.status + "</td></tr>";
		}
		
		content+="<br/>"
	} 
	
	document.querySelector("#ordersByDateBody").innerHTML= content;
}

/**
 * This method will print NO DATA FOUND if no records found in page
 * Else it will print filtered date records in page
 */
function writeContent(filtered){
	if(filtered.length == 0){
		let data = "No Data Found";
		document.querySelector("#notFoundForDate").innerHTML= data;
		
	//	let getOrdersByDateTable = document.getElementById("searchOrdersByDate");
		//getOrdersByDateTable.display="none";

	} else{
		searchOrdersByDateFunc();
		writeOrdersByDate(filtered);
	}
}

/**
 * This method is used to toggle button of date records field
 */
function searchOrdersByDateFunc(){
	var table = document.getElementById("searchOrdersByDate");
	  if (table.style.display === "none") {
	    table.style.display = "block";
	  } else {
	    table.style.display = "none";
	  }
}

/**
 * This method is executed when user wants order details by delivery date
 * It will write order details of a delivery date
 */
function getOrdersByDeliveryDate(){
	event.preventDefault();
	let date = document.querySelector("#deliveryDate").value;
	console.log(date);
	let url = "SalesDetailsServlet";
	fetch(url).then(res=> res.json()).then(res=>{
		let salesList = res;
		let filtered = salesList.filter(s => String(convertDate(s.deliveryDate)).startsWith(date));
		console.log(filtered.length);
		writeForDeliveryDay(filtered);
	});
}

/**
 * This method is used to convert java date to javascipt date
 */
function convertDate(deliveryDate){
	
	let parseDate = Date.parse(deliveryDate);
	let jsDateTime = new Date(parseDate);
	let endDate = jsDateTime.setDate(jsDateTime.getDate()+1);
	let date = new Date(endDate);
	let jsDate = date.toJSON().substring(0,10);
	return jsDate;
}

/**
 * This method will no data found if no records found in specific delivery day
 * Else it will write order details
 */
function writeForDeliveryDay(filtered){
	if(filtered.length == 0){
		let data = "No Data Found";
		document.querySelector("#notFoundForDelivery").innerHTML= data;

	} else{
		searchOrdersByDelieryDate();
		writeOrdersByDeliveryDate(filtered);
	}
}

/**
 * This method is used to toggle button
 */
function searchOrdersByDelieryDate(){
	var table = document.getElementById("ordersByDeliveryDate");
	  if (table.style.display === "none") {
	    table.style.display = "block";
	  } else {
	    table.style.display = "none";
	  }
}

/**
 * This method will write content if "writeForDeliveryDay()" function tells
 */
function writeOrdersByDeliveryDate(filtered){
	let content = "";
	let vegTable = ""
	let i=0;
	for(let orderDetails of filtered){
		i++;
		let time = orderDetails.createdDate.substring(13,24);
		let date = orderDetails.createdDate.substring(0,12);
		let orderItems = orderDetails.orderItems;
		for(let vegetable of orderItems){
			content += "<tr><td>" + orderDetails.orderId + "</td><td>" + orderDetails.username +
			"</td><td>" + vegetable.vegName + "</td><td>" + vegetable.quantity + 
			"</td><td>" + vegetable.eachVegPrice + "</td><td>"  + date +
			"</td><td>" + time + "</td><td>" + orderDetails.deliveryDate + "</td><td>" +
			orderDetails.paymentMethod + "</td><td>" + orderDetails.status + "</td></tr>";
		}
		
		content+="<br/>"
	} 
		
		document.querySelector("#ordersByDeliveryDateBody").innerHTML= content;
}

</script>
</html>