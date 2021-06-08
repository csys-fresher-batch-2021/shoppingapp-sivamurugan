<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit Profile</title>
</head>
<style>
form {
	border: 5px solid #094C77;
	padding: 10px;
	margin: auto;
	margin-top: 4%;
	width: 600px;
	background-color: #E4F1FA;
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
	color: #094C77;
	box-sizing: border-box;
	border: 2px solid #094C77;
	border-bottom: 2px solid #094C77;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="UpdateNameServlet" method="post">
			<label for="newName"><strong>New Name:</strong></label>
			 <input type="text"	name="newName" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" placeholder="Enter New Name"
				required>
			<button type="submit" class="btn btn-success">Update</button>
			<br />
		</form>
		<form action="UpdateMobileServlet" method="post">
			<label for="newMobileNumber"><strong>New Mobile Number :</strong></label>
			<input type="number" name="newMobileNumber" pattern="[6789][0-9]{9}" placeholder="Enter New Number" required>
			<button type="submit" class="btn btn-success">Update</button>
		</form>
		<form action="UpdateEmailServlet" method="post">
			<label for="newEmail"><strong>New Email ID:</strong></label>
			<input type="email" name="newEmail" placeholder="Enter new Email" required>
			<button type="submit" class="btn btn-success">Update</button>
		</form>
		<form action="SelfRemoveAccountServlet" method="post">
			<button type="submit" class="btn btn-danger">Remove Account</button>
		</form>
	</main>
</body>
</html>
