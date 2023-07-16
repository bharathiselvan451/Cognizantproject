<!DOCTYPE html>
<%@ page import="com.cognizant.project.model.Bus"%>
<%@ page import="com.cognizant.project.model.User"%>  
<%@page import="java.util.*"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BusList</title>
<link rel="stylesheet" href="allbuses.css">
</head>
<body>
	<header>
		<h2>ALL AVAILABLE BUSES</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
        <div id="menuToggle">
          <input type="checkbox" />
          
          <span></span>
          <span></span>
          <span></span>
         
          <ul id="menu">
          	<%	User user = (User) request.getAttribute("user"); %>
          	<h2>Welcome <font color="fick"><%= user.getName()%></font>!</h2>
            <a class="profile-button" href="profile"><li><b>UPDATE PROFILE</b></li></a>
            <a class="mybookings-button" href="mybookings"><li><b>MY BOOKINGS</b></li></a>
            <a class="mybookings-button" href='searchbus'><li><b>SEARCH BUSES</b></li></a>
          </ul>
        </div>
      </nav>
	</header>
	
	<table>
		<tr>
			<th>Bus ID</th>
			<th>Name</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Price</th>
		</tr>

		<% List<Bus> message =(List) request.getAttribute("list");
		if(message!=null) for(Bus obj : message){ %>
		<tr>
			<td><% out.println(obj.getId());%></td>
			<td><% out.println(obj.getName());%></td>
			<td><% out.println(obj.getSource()); %></td>
			<td><% out.println(obj.getDestination());%></td>
			<td><% out.println(obj.getPrice());%></td>
		<tr><% }%>
	</table>

</body>
</html>