<%@page import="in.siva.model.ProductDetail"%>
<%@page import="in.siva.service.ProductServiceManagement"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>MyApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Shop Management</h3>
		

	</main>
	

<%
// To get values from input box
String productName = request.getParameter("productName");
Integer productPrice = Integer.parseInt(request.getParameter("productPrice"));
Integer productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
String productCategory = request.getParameter("category");

ProductDetail product1 = new ProductDetail(productName, productPrice, productQuantity, productCategory);
	
// To add products to ArrayList
	try {
		ProductServiceManagement.addProduct(product1);
		String infoMessage = "Product Added Successfully";
		response.sendRedirect("addproducts.jsp?infoMessage=" + infoMessage);
		//out.println(infoMessage);
		
		
	}

// Exception message if product details didn't met requirements
	catch(RuntimeException e) {
		String errorMessage = e.getMessage();
		response.sendRedirect("addproducts.jsp?errorMessage=" + errorMessage);
		//out.println(errorMessage);
		
	}
	
	%>
</body>
</html>












