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
		<input type="text" name="newName" pattern="[a-zA-Z\s]+" placeholder="Enter New Name" required>
			<button type="submit" class="btn btn-success">Update Name</button><br/>
		</form>
		<form action="SelfRemoveAccountServlet" method="post">
			<button type="submit" class="btn btn-danger">Remove Account</button>
		</form>
		

	</main>
</body>
</html>
