<!DOCTYPE html>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<title>View Users</title>
<style>
.userDetails th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #8A0A1F;
	color: white;
}

.userDetails {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

.userDetails td, #userDetails th {
	border: 1px solid #ddd;
	padding: 8px;
}

.userDetails tr:nth-child(even) {
	background-color: #f2f2f2;
}

.userDetails tr:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<figure>
			<figcaption>List Of Users</figcaption>
			<table class="userDetails">
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Username</th>
					<th scope="col">Mobile Number</th>
					<th scope="col">Email</th>
				</tr>
				<tbody id="allUsers">
				</tbody>


			</table>
		</figure>


		<figure>
			<figcaption>List Of Admins</figcaption>
			<table class="userDetails">
				<thead>
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Name</th>
						<th scope="col">Age</th>
						<th scope="col">Username</th>
						<th scope="col">Mobile Number</th>
						<th scope="col">Email</th>
					</tr>
				</thead>
				<tbody id="allAdmins">
				</tbody>


			</table>
		</figure>



	</main>
</body>

<script>
/**
 * This method is used to get all users details
 */
function getAllUsers(){
	let url = "ViewUsersServlet";
	fetch(url).then(res=> res.json()).then(res=>{
		console.log(res);
		let userList = res;
		
		let content = "";
		let i=0;
		for(let user of userList){
			if(user.role=="U"){
				i++;
				content += "<tr><td>" + i + "</td><td>" + user.name +
				"</td><td>" + user.age + "</td><td>" + user.username + 
				"</td><td>" + user.mobileNumber + "</td><td>" + user.email +
				"</td></tr>";
			}
		} 
		document.querySelector("#allUsers").innerHTML= content;
		
	});
}

/**
 * This method is used to get all admin details
 */
function getAllAdmins(){
	let url = "ViewUsersServlet";
	fetch(url).then(res=> res.json()).then(res=>{
		let userList = res;
		
		let content = "";
		let i=0;
		for(let admin of userList){
			if(admin.role=="A"){
				i++;
				content += "<tr><td>" + i + "</td><td>" + admin.name +
				"</td><td>" + admin.age + "</td><td>" + admin.username + 
				"</td><td>" + admin.mobileNumber + "</td><td>" + admin.email +
				"</td></tr>";
			}
		}
		document.querySelector("#allAdmins").innerHTML= content;
		
	});
}

getAllUsers();
getAllAdmins();
</script>
</html>
