<%@ page import="java.util.List" %>
<%@ page import="com.cognizant.project.model.Bookings" %>
</html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Bookings</title>
    <link rel="stylesheet" href="allbuses.css">
    
</head>
<body>
	<header>
		<h2>ALL BOOKINGS</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul id="menu">
					<h2>WELCOME <font color="fick">ADMIN!</font></h2>
					<a class="mybookings-button" href="addbus"><li><b>ADD BUS</b></li></a>
					<a class="mybookings-button" href="addschedule"><li><b>ADD SCHEDULE</b></li></a>
				</ul>
			</div>
		</nav>
	</header>

    <%
    	List<Bookings> list = (List<Bookings>) request.getAttribute("bookingsList");
    	int i=0;
    %>

    <table>
        <tr>
            <th>Booking ID</th>
            <th>Ticket ID</th>
            <th>Email ID</th>
            <th>Bus ID</th>
            <th>Date</th>
            <th>Seats Booked</th>
            <th>Cost</th>
          
        </tr>
        <% for (Bookings booking : list) { %>
            <tr>
                <td><%= booking.getBookingId() %></td>
                <td><%= booking.getTicketId() %></td>
                <td><%= booking.getEmail() %></td>
                <td><%= booking.getBusId() %></td>
                <td><%= booking.getDate() %></td>
                <td><%= booking.getSeatsbooked() %></td>
                <td><%= booking.getCost() %></td>
               
            </tr>
        <% } %>
    </table>

</body>
</html>