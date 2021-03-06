<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">


<%
String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
String role = (String) session.getAttribute("ROLE");
%>
<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#">MyApp</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="ViewVegetables.jsp">View Vegetables</a></li>
				<%
				if (loggedInUsername != null && role != null && role.equalsIgnoreCase("C")) {
				%>
				<li class="nav-item"><a class="nav-link"
					href="DeliveryManIndex.jsp">Sell Vegetables</a></li>
				<%
				}
				%>
				<%
				if (loggedInUsername != null && role != null && role.equalsIgnoreCase("A")) {
				%>
				<li class="nav-item"><a class="nav-link"
					href="ViewSalesDetails.jsp">Order Details</a></li>

				<li class="nav-item"><a class="nav-link"
					href="addVegetable.jsp">Add Vegetables</a></li>
				<li class="nav-item"><a class="nav-link"
					href="removeVegetable.jsp">Remove Vegetable</a></li>
				<li class="nav-item"><a class="nav-link"
					href="removeAccount.jsp">Remove User</a></li>
				<li class="nav-item"><a class="nav-link" href="viewUsers.jsp">View
						Users</a></li>
				<%
				}
				%>
				<%
				if (loggedInUsername != null && role != null && role.equalsIgnoreCase("U")) {
				%>
				<li class="nav-item"><a class="nav-link" href="editProfile.jsp">Edit
						Profile</a></li>
				<li class="nav-item"><a class="nav-link"
					href="SelectVegetables.jsp">Buy Vegetables</a></li>
				<li class="nav-item"><a class="nav-link" href="MyOrdersServlet">My
						Orders</a></li>
				<%
				}
				%>
			</ul>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<%
				if (loggedInUsername == null) {
				%>
				<li class="nav-item active"><a class="nav-link"
					href="loginPage.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link"
					href="newUserRegistration.jsp">Register</a></li>
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link" href="#">Welcome <%=loggedInUsername%></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
				</li>
				<%
				}
				%>
			</ul>
		</div>
	</nav>
</header>




<!-- Java Codes common to all pages -->

<%
// Scriplets (Java Code)
String infoMessage = request.getParameter("infoMessage");
if (infoMessage != null) {
	out.println("<h6 style='color:white; background-color:#32C617;'>" + infoMessage + "</h6>");
}

String errorMessage = request.getParameter("errorMessage");
if (errorMessage != null) {
	out.println("<h6 style='color:white; background-color:red;'>" + errorMessage + "</h6>");
}
%>
