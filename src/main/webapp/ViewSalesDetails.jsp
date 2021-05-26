<!DOCTYPE html>
<html lang="en">
<head>
<title>Sales Details</title>
<style>
#salesDetailsTable th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #047A76;
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

#salesDetailsTable tr:nth-child(even){background-color: #f2f2f2;}

#salesDetailsTable tr:hover {background-color: #ddd;}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<figure>
			<figcaption>Sales Details</figcaption>
			<table id="salesDetailsTable">
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Username</th>
					<th scope="col">Vegetable</th>
					<th scope="col">quantity</th>
					<th scope="col">Amount</th>
					<th scope="col">Date</th>
					<th scope="col">Time</th>
				</tr>
				<tbody id="salesDetails">
				</tbody>


			</table>
		</figure>


	</main>
</body>
<script type="text/javascript">
function details(){
	let url = "SalesDetailsServlet";
	fetch(url).then(res=> res.json()).then(res=>{
		console.log(res);
		let salesList = res;
		
		let content = "";
		let i=0;
		for(let orderDetails of salesList){
			i++;
			let time = orderDetails.dateTime.substring(13,24);
			let date = orderDetails.dateTime.substring(0,12);
			content += "<tr><td>" + i + "</td><td>" + orderDetails.username +
			"</td><td>" + orderDetails.vegName + "</td><td>" + orderDetails.quantity + 
			"</td><td>" + orderDetails.eachPrice + "</td><td>"  + date +
			"</td><td>" + time + "</td></tr>";
		} 
		document.querySelector("#salesDetails").innerHTML= content;
		
	});
}
details();
</script>
</html>
