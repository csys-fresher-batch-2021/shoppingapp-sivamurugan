<!DOCTYPE html>
<%@page import="in.siva.model.UserDetail"%>
<%@page import="java.util.List"%>
<%@page import="in.siva.service.UserService"%>
<html lang="en">
<head>
<title>View Users</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<figure>
		<figcaption>List Of Users</figcaption>
		<table class = "table table-bordered">
		<tr>
			<th scope = "col">
				S.No
			</th>
			<th scope = "col">
				Name
			</th>
			<th scope="col">
				Age
			</th>
			<th scope = "col">
				Username
			</th>
			<th scope = "col">
				Mobile Number
			</th>
			<th scope = "col">
				Email
			</th>
		</tr>
			<%
			int i = 0;
				List<UserDetail> users = UserService.getUserDetails();
				for(UserDetail user : users){
					i++;
			%>
		<tr>
			<td>
				<%= i %>
			</td>
			<td>
				<%=user.getName()%>
			</td>
			<td>
				<%=user.getAge() %>
			</td>
			<td>
				<%=user.getUsername()%>
			</td>
			<td>
				<%=user.getMobileNumber()%>
			</td>
			<td>
				<%=user.getEmail()%>
			</td>
		</tr>
			<% 
			}
			%>
				
				
		</table>
		</figure>
		
		

	</main>
</body>
</html>
