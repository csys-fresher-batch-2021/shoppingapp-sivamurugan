<!DOCTYPE html>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<title>View Users</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<figure>
			<figcaption>List Of Users</figcaption>
			<table class="table table-bordered">
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
			<table class="table table-bordered">
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
