<!DOCTYPE html>
<html lang="en">
<head>
<title>New User Registration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>New User Registration</h3>
		<form action = "UserRegistrationServlet" method = "post">
			<label for = "name"> Name: </label> 
			<input type = "text" name = "name" pattern = "[a-zA-Z\s]+" placeholder = "Enter Name" autofocus required><br />

			<label for = "age"> Age : </label>
			<input type = "number" name = "age" min=1 max=90 placeholder = "Enter Age" required><br />
			
			<label for = "gender"> Gender :</label>
			<select name = "gender" required>
				<option value = "M">Male</option>
				<option value = "F">Female</option>
				<option value = "O">Other</option>
			</select><br />
			
			<label for = "mobileNumber"> Mobile No (+91):</label>
			<input type = "number" name = "mobileNumber" min = 6000000000 max = 9999999999 placeholder="Enter Mobile Number" required><br />
				
			<label for = "email">Email :</label>
			<input type = "email" name = "email" placeholder = "Enter Email" required><br/>
			
			<label for = "username"> User-name :</label>	
			<input type = "text" name = "username" placeholder = "Enter Unique User-Name" required><br/>
			
			<label for = "password">Password :</label>
			<input type = "password" name = "password" pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$" placeholder = "Enter Password" required><br/>

			<label for = "role">Role :</label>
			<select name = "role" required>
				<option value = "U"> Customer </option>
				<option value = "A"> Admin </option>
				<option value = "C">Sales Man</option>
			</select><br/>
			<button type = "submit" class = "btn btn-info">Submit</button>
		</form>
	</main>
</body>
</html>
