<!DOCTYPE html>
<html lang="en">
<head>
<title>New User Registration</title>
</head>
<style>
form {
	border: 5px solid #458809;
	padding: 10px;
	margin: auto;
	margin-top: 4%;
	width: 600px;
	background-color: #DEFDC2;
}
.head{
	text-align: center;
	color:#167712;
}
input[type=text], [type=number], [type=email], [type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}

input {
	padding: 5px 12px;
	margin: 5px 0;
	color: #212529;
	box-sizing: border-box;
	border: 2px solid #458809;
	border-bottom: 2px solid #458809;
}

select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="UserRegistrationServlet" method="post">
			<h3 class="head">New User Registration</h3>
			<label for="name"><strong>Name: </strong></label> <input type="text" name="name"
				pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" placeholder="Enter Name" autofocus
				required><br /> <label for="age"><strong>Age :</strong> </label> <input
				type="number" name="age" min=15 max=90 placeholder="Enter Age"
				required><br /> <label for="gender"> <strong>Gender :</strong></label> <select
				name="gender" required>
				<option value="M">Male</option>
				<option value="F">Female</option>
				<option value="O">Other</option>
			</select><br /> <label for="mobileNumber"> <strong>Mobile No (+91):</strong></label> <input
				type="number" name="mobileNumber" min=6000000000 max=9999999999
				placeholder="Enter Mobile Number" required><br /> <label
				for="email"><strong>Email :</strong></label> <input type="email" name="email"
				placeholder="Enter Email" required><br /> <label
				for="username"> <strong>Username :</strong></label> <input type="text" pattern="(?=.*[a-z]).{6,}"
				name="username" placeholder="Enter Unique Username" required>(Minimum 6 characters required)<br />

			<label for="password"><strong>Password :</strong></label> <input type="password"
				name="password"
				pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$"
				placeholder="Enter Password" required> <label>Must
				Contain ([a-z,A-Z,0-9][@#$%] Length should be more than 8)</label><br /> <label
				for="role"><strong>Role :</strong></label> <select name="role" required>
				<option value="U">Customer</option>
				<option value="A">Admin</option>
				<option value="C">Sales Man</option>
			</select><br />
			<button type="submit" class="btn btn-info">Submit</button>
			<button type="reset" class="btn btn-danger">Clear</button>
		</form>
	</main>
</body>
</html>
