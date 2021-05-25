<!DOCTYPE html>
<%@page import="in.siva.model.VegDetail"%>
<%@page import="in.siva.dao.VegDetailDao"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<title>Select Vegetables</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="SelectVegetablesServlet" method="post">
			<figure>
				<figcaption>Select Vegetables And Enter Quantity</figcaption>
				<table class="table table-bordered">
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Price</th>
						<th scope="col">Select</th>
						<th scope="col">Quantity</th>
						<th scope="col">Availability</th>
					</tr>
					<%
					List<VegDetail> vegetables = VegDetailDao.findAll();
					int i = 0;
					for (VegDetail veg : vegetables) {
					%>
					<tr>
						<td><%=veg.getName()%></td>
						<td><%=veg.getPrice()%> /-</td>
						<td><input type="checkbox" id="select_<%=i%>" name="select"
							value="<%=veg.getName()%>" onclick="isVegChecked(<%=i%>)"></td>
						<td><input type="number" id="quantity_<%=i%>" name="quantity"
							placeholder="Enter Quantity" value=0 min=0
							max=<%=veg.getQuantity()%> disabled required>Kg</td>
						<td><%=veg.getQuantity()%></td>
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
function isVegChecked(i){
	let selected = document.querySelector("#select_"+i);
	let quantity = document.querySelector("#quantity_"+i);
	if(selected.checked){
		quantity.removeAttribute("disabled");
	} else{
		quantity.setAttribute("disabled", true);
	}
}
</script>
</html>
