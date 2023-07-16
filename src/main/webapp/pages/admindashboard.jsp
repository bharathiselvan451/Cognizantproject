<%@ page import="com.cognizant.project.model.Bus"%> <%@page
import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="allbuses.css">
</head>
<body>
	<header>
		<h2>AVAILABLE BUSES ON THE PLATFORM</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul id="menu">
					<h2>WELCOME <font color="fick">ADMIN!</font></h2>
					<a class="profile-button" href="addbus"><li><b>ADD BUS</b></li></a>
					<a class="mybookings-button" href="addschedule"><li><b>ADD SCHEDULE</b></li></a>
					<a class="mybookings-button" href="allbookings"><li><b>BOOKINGS</b></li></a>
				</ul>
			</div>
		</nav>
	</header>
	</nav>
	

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Source</th>
			<th>Destination</th>
		</tr>
		<% List
		<Bus> busList = (List<Bus>)
		request.getAttribute("userList");%> <% for(int i = 0; i <
		busList.size(); i++) { Bus bus = busList.get(i); %>
		<tr>
			<td><%= bus.getId() %></td>
			<td><a>
					<%= bus.getName() %> </a></td>
			<td><%= bus.getSource() %></td>
			<td><%= bus.getDestination() %></td>
		</tr>
		<% } %> 
	</table>
</body>
</html>