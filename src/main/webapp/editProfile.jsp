<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit Profile</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="UpdateNameServlet" method="post">
			<label for="newName">New Name:</label>
			 <input type="text"	name="newName" pattern="[a-zA-Z\s]+" placeholder="Enter New Name"
				required>
			<button type="submit" class="btn btn-success">Update</button>
			<br />
		</form>
		<form action="UpdateMobileServlet" method="post">
			<label for="newMobileNumber">New Mobile Number :</label>
			<input type="number" name="newMobileNumber" pattern="[6789][0-9]{9}" placeholder="Enter New Number" required>
			<button type="submit" class="btn btn-success">Update</button>
		</form>
		<form action="UpdateEmailServlet" method="post">
			<label for="newEmail"> New Email ID:</label>
			<input type="email" name="newEmail" placeholder="Enter new Email" required>
			<button type="submit" class="btn btn-success">Update</button>
		</form>
		<form action="SelfRemoveAccountServlet" method="post">
			<button type="submit" class="btn btn-danger">Remove Account</button>
		</form>


	</main>
</body>
</html>
