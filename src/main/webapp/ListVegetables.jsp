<%@page import="in.siva.dao.VegDetailDao"%>
<%@page import="in.siva.model.VegDetail"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Vegetables</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<figure>
			<figcaption>List Of Vegetables</figcaption>
			<table class="table table-bordered">
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Name</th>
					<th scope="col">Price (Rs)</th>
					<th scope="col">Quantity (Kg)</th>
				</tr>
				<%
				int i = 0;
				List<VegDetail> vegetables = VegDetailDao.findAll();
				for (VegDetail veg : vegetables) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=veg.getName()%></td>
					<td><%=veg.getPrice()%> /-</td>
					<td><%=veg.getQuantity()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</figure>
	</main>
</body>
</html>