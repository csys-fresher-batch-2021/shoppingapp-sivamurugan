<!DOCTYPE html>
<html lang="en">
<head>
<title>Sales Details</title>
<style>
#left {
	float: left;
	width: 40%;
	background: #ddd;
	padding: 20px;
}

#right {
	float: right;
	width: 30%;
	background: #C5E7E3;
	padding: 20px;
}

#table {
	float: right;
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#table td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#table tr:nth-child(even) {
	background-color: #f2f2f2;
}

#table tr:hover {
	background-color: #ddd;
}

#table th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<section id="left">
			<label for="username">Enter Username :</label> <input type="text"
				id="username" placeholder="Enter Username" required>
			<button onclick="searchOrders(<%=1%>)" class="btn btn-info">Search</button>
			<br /> <label for="orderDate">Order Date :</label> <input
				type="date" id="date" required>
			<button class="btn btn-info" onclick="searchOrders(<%=2%>)">Search</button>
			<br /> <label for="deliveryDate">Delivery Date :</label> <input
				type="date" id="deliveryDate" required>
			<button class="btn btn-info" onclick="searchOrders(<%=3%>)">Search</button>
			<br /> <label for="sort">Sort By :</label><br /> <input
				type="radio" id="sort" name="sort" value="delivered"> <label
				for="delivered">Delivered</label><br /> <input type="radio"
				id="sort" name="sort" value="pending"> <label for="pending">Pending</label><br />
			<input type="radio" id="sort" name="sort" value="canceled"> <label
				for="canceled">Canceled</label><br /> <input type="radio" id="sort"
				name="sort" value="expired"> <label for="expired">Expired</label><br />
			<button class="btn btn-success" onclick="sortByStatus()">Search</button>
			<br />
			<button class="btn btn-danger" onclick="searchOrders(<%=4%>)">View
				All</button>
		</section>
		<section id="right">
			<p>All details are sorted according to latest orders</p>
		</section>
		<section>
			<figure id="table">
				<figcaption>List Of Orders :</figcaption>
				<table id="table">
					<thead>
						<tr>
							<th scope="col">Order ID</th>
							<th scope="col">Username</th>
							<th scope="col">Vegetable Name</th>
							<th scope="col">Quantity (Rs)</th>
							<th scope="col">Bill (Rs)</th>
							<th scope="col">Ordered Date</th>
							<th scope="col">Ordered Time</th>
							<th scope="col">Delivery Date</th>
							<th scope="col">Payment Method</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody id="tableBody"></tbody>
				</table>
			</figure>
		</section>
	</main>
</body>

<script type="text/javascript">
	// Calling setDate to set value & max of date field initially
	setDate();
	
	/**
	* This method is used to set date  values in page in default
	*/
	function setDate() {
		let date = new Date();
		let currentDate = date.toJSON().substring(0, 10);
		//let currentTime = date.substring(11,19);

		let endDate = date.setDate(date.getDate() + 5);
		let maxDate = new Date(endDate);
		let maxDateStr = maxDate.toJSON().substring(0, 10);

		document.querySelector("#date").setAttribute('value', currentDate);
		document.querySelector("#date").setAttribute('max', currentDate);

		document.querySelector("#deliveryDate").setAttribute('value',
				currentDate);
		document.querySelector("#deliveryDate")
				.setAttribute('min', currentDate);
		document.querySelector("#deliveryDate").setAttribute('max', maxDateStr);
	}
	
	/**
	* This method is called when user clicks search button It will filter records according to their selection
	*/
	function searchOrders(i){
		let url = "SalesDetailsServlet";
		fetch(url).then(res=> res.json()).then(res=>{
			let salesList = res;
			let filtered;
			let value;
			if(i==1){
				value = document.querySelector("#username").value;
				if(value.length == 0){
					alert("Please enter username");
					window.location.reload();
				} else{
					filtered = salesList.filter(s => String(s.username).startsWith(value));
					writeTableContent(filtered);
				}
			} else if(i==2){
				value = document.querySelector("#date").value;
				filtered = salesList.filter(s => String(convertToDate(s.createdDate)).startsWith(value));
				writeTableContent(filtered);
			} else if(i==3){
				value = document.querySelector("#deliveryDate").value;
				filtered = salesList.filter(s => String(convertDate(s.deliveryDate)).startsWith(value));
				writeTableContent(filtered);
			} else if(i==4){
				writeTableContent(salesList);
			}
			
		});
	}
	
	/**
	* This method is used to write content in table according to filtered orders
	*/
	function writeTableContent(filtered){
		let content = "";
		for(let orderDetails of filtered){
			if(filtered.length != 0){
				let time = orderDetails.createdDate.substring(12,24);
				let date = orderDetails.createdDate.substring(0,12);
				let orderItems = orderDetails.orderItems;
				for(let vegetable of orderItems){
					content += "<tr><td>" + orderDetails.orderId + "</td><td>" + orderDetails.username +
					"</td><td>" + vegetable.vegName + "</td><td>" + vegetable.quantity + 
					"</td><td>" + vegetable.eachVegPrice + "</td><td>"  + date +
					"</td><td>" + time + "</td><td>" + orderDetails.deliveryDate + "</td><td>" +
					orderDetails.paymentMethod + "</td><td>" + orderDetails.status + "</td></tr>";
				}
				content += "<br/>";
			} else{
				content += "<tr><td>No Records Found</td></tr>";
			}
		} 
		document.querySelector("#tableBody").innerHTML = content;
	}
	
	/**
	* This method is used to convert java date with time into javascript date with time
	*/
	function convertToDate(dateTime){
		let parseDate = Date.parse(dateTime);
		let jsDateTime = new Date(parseDate);
		let jsDate = jsDateTime.toJSON().substring(0,10);
		return jsDate;
	}
	
	/**
	* This method is used to convert java date into javascript date
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
	* This method is used to filter orders by status
	*/
	function sortByStatus(){
		let url = "SalesDetailsServlet";
		fetch(url).then(res=> res.json()).then(res=>{
			let salesList = res;
			let filtered;
			let value;
			var radio = document.getElementsByName('sort');
        	for(i = 0; i < radio.length; i++) {
            	if(radio[i].checked){
            		val = radio[i].value;
            		value = val.toLocaleUpperCase();
            		filtered = salesList.filter(s => String(s.status).startsWith(value));
            		writeTableContent(filtered);
            	}
        	}
		});
	}
</script>
</html>