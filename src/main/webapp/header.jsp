<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">


<%
String loggedInUsername = (String)session.getAttribute("LOGGED_IN_USER");
String role = (String) session.getAttribute("ROLE");
%>

<<<<<<< HEAD

=======
>>>>>>> 5e0491d445a6d22ad4315f3db51cb6d6486afab1
<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="#">MyApp</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <% if (loggedInUsername != null && role != null && role.equalsIgnoreCase("ADMIN")){ %>
      <li class="nav-item">
        <a class="nav-link" href="addproducts.jsp">Add Products</a>
      </li>
      <%} %>
<<<<<<< HEAD
      <% if (loggedInUsername != null && role != null){ %>
      <li class="nav-item">
        <a class="nav-link" href="ListProducts.jsp">View Products</a>
      </li>
      <%} %>
=======
      <li class="nav-item">
        <a class="nav-link" href="ListProducts.jsp">View Products</a>
      </li>
>>>>>>> 5e0491d445a6d22ad4315f3db51cb6d6486afab1
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdownId">
          <a class="dropdown-item" href="#">Action 1</a>
          <a class="dropdown-item" href="#">Action 2</a>
        </div>
      </li>
    </ul>
     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
     <% if (loggedInUsername == null){ %>
      <li class="nav-item active">
<<<<<<< HEAD
      <% if (loggedInUsername == null){ %>
        <a class="nav-link" href="#">Login</a>
=======
        <a class="nav-link" href="loginPage.jsp">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="newUserRegistration.jsp">Register</a>
>>>>>>> 5e0491d445a6d22ad4315f3db51cb6d6486afab1
      </li>
      <%} else { %>
      <li class="nav-item">
        <a class="nav-link" href="#">Welcome <%=loggedInUsername %></a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="#">Logout</a>
      </li>
<<<<<<< HEAD
      <%} else { %>
      <li class="nav-item">
        <a class="nav-link" href="#">Welcome <%=loggedInUsername %></a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="#">Logout</a>
        <%} %>
      </li>
      </ul> 
=======
      <%} %>
      </ul>
   
>>>>>>> 5e0491d445a6d22ad4315f3db51cb6d6486afab1
  </div>
</nav>
</header>




<!-- Java Codes common to all pages -->

<%
	// Scriplets (Java Code)
	String infoMessage = request.getParameter("infoMessage");
	if(infoMessage != null){
		out.println("<font color='green'>" + infoMessage + "</font>");
	}
	
	String errorMessage = request.getParameter("errorMessage");
	if(errorMessage != null){
		out.println("<font color='red'>" + errorMessage + "</font>");
	}
%>
