<!DOCTYPE html>
<%@page import="in.siva.model.VegDetail"%>
<%@page import="in.siva.dao.VegDetailDAO"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<title>Select Vegetables</title>
<style type="text/css">
input.checkbox {
	width: 30px;
	height: 30px;
	display: block;
	position: relative;
	padding-left: 45px;
	margin-bottom: 15px;
	cursor: pointer;
	font-size: 20px;
}

input[type=number]::-webkit-outer-spin-button,
input[type=number]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

input[type=number] {
    -moz-appearance:textfield;
}

.selectVeg th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #79A814;
	color: white;
}

.selectVeg {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

.selectVeg td, #selectVeg th {
	border: 2px solid #ddd;
	padding: 8px;
}

.selectVeg tr {
	background-color: #F1EEEE;
}

.selectVeg tr:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="SelectVegetablesServlet" method="post">
			<figure>
				<figcaption>Select Vegetables And Enter Quantity</figcaption><br/>
				<table class="selectVeg">
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Price</th>
						<th scope="col">Availability (Kg)</th>
						<th scope="col">Select</th>
						<th scope="col">Quantity (Kg)</th>
						<th scope="col">Amount (Rs)</th>

					</tr>
					<%
					List<VegDetail> vegetables = VegDetailDAO.findAll();
								int i = 0;
								for (VegDetail veg : vegetables) {
					%>
					<tr>
						<td><%=veg.getName()%></td>
						<td><%=veg.getPrice()%> /-</td>
						<td><%=veg.getQuantity()%></td>
						<td><input type="checkbox" id="select_<%=i%>" name="select"
							class="checkbox" value="<%=veg.getName()%>"
							onclick="isVegChecked(<%=i%>)"></td>
						<td><input type="number" id="quantity_<%=i%>" name="quantity" onkeydown="false"
							onchange="estimateBill(<%=i%>)" placeholder="Enter Quantity"
							value=0 min=0 max=<%=veg.getQuantity()%> disabled required></td>
						<td id="printBill_<%=i%>" ></td>

					</tr>
					<%
					i++;
					}
					%>
				</table>
			</figure>
			<button type="submit" class="btn btn-success">Proceed</button>
		</form>


	</main>
</body>
<script type="text/javascript">

/**
 * This method is used to enable input box if select box is checked
 */
function isVegChecked(i){
	let selected = document.querySelector("#select_"+i);
	let quantity = document.querySelector("#quantity_"+i);
	if(selected.checked){
		quantity.removeAttribute("disabled");
		quantity.focus();
	} else{
		quantity.setAttribute("disabled", true);
	}
}


/**
 * This method is used to calculate bill when user enters quantity
 */
function estimateBill(i){
	let vegQuantity = document.querySelector("#quantity_"+i).value;
	if(vegQuantity > 0){
		let url = "GetVegDetailsServlet";
		fetch(url).then(res=> res.json()).then(res=>{
			let vegDetails = res;
			price = vegDetails[i].price * vegQuantity;
			
			document.querySelector("#printBill_"+i).innerHTML= price;
			
		})	
	}
	
}


</script>
</html>
