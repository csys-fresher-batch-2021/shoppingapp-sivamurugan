<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<html>
<head>
<title>New User Registration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Enter your details</h3>
		<form>
		<table>
		<tr>
			<td>
				Name 
			</td>
			<td>
				<input type = "text" name = "name" placeholder = "Enter your name" required>
			</td>
		</tr>
		<tr>
			<td>
				Age 
			</td>
			<td>
				<input type = "number" name = "age" placeholder = "Enter your age" min = 18 max = 90 required>
			</td>
		</tr>
		<tr>
			<td>
				Gender 
			</td>
			<td>
				Male<input type = "radio" id = "genderMale" >
				Female<input type = "radio" id = "genderFemale">
				Other<input type = "radio" id = "genderOther">
			</td>
		</tr>
		<tr>
			<td>
				Mobile Number  
			</td>
			<td>
				<input type = "number" name = "mobileNo" placeholder = " Enter mobile no" min = 6000000000 max = 9999999999 required>
			</td>
		</tr>
		<tr>
			<td>
				Email   
			</td>
			<td>
				<input type = "email" name = "email" placeholder = " Enter Email" required>
			</td>
		</tr>
		<tr>
			<td>
				Adhaar ID   
			</td>
			<td>
				<input type = "number" name = "adhaar" placeholder = " Enter Adhaar no" min = 100000000000 max = 999999999999 required>
			</td>
		</tr>
		<tr>
			<td>
				PAN No   
			</td>
			<td>
				<input type = "text" name = "panNo" placeholder = " Enter PAN no" required>
			</td>
		</tr>
		<tr>
			<td>
				Username  
			</td>
			<td>
				<input type = "text" name = "username" placeholder = " Enter username" required>
			</td>
		</tr>
		<tr>
			<td>
				Password  
			</td>
			<td>
				<input type = "text" name = "password" placeholder = " Enter password" required>
			</td>
		</tr>
		</table>
		
		<button type = "submit" class = "btn btn-primary">Submit</button>
		<button type = "reset" class = "btn btn-danger">Reset</button>
		</form>

	</main>
</body>
</html>
