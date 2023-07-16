<%@ page import="java.util.List" %>
<%@ page import="com.cognizant.project.model.Bookings" %>
</html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Bookings</title>
    <link rel="stylesheet" href="allbuses.css">
    
</head>
<body>
	<header>
		<h2>MY BOOKINGS</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
        <div id="menuToggle">
          <input type="checkbox" />
          
          <span></span>
          <span></span>
          <span></span>
         
          <ul id="menu">
            <a class="profile-button" href="profile"><li><b>UPDATE PROFILE</b></li></a>
            <a class="mybookings-button" href='searchbus'><li><b>SEARCH BUSES</b></li></a>
            <a class="mybookings-button" href='allbuses'><li><b>BACK</b></li></a>
          </ul>
        </div>
      </nav>
	</header>
    <%
    	List<Bookings> list = (List<Bookings>) request.getAttribute("bookingsList");
    	List<String> sourceList = (List<String>) request.getAttribute("sourceList");
    	List<String> destinationList = (List<String>) request.getAttribute("destinationList");
    	int i=0;
    %>

    <table>
        <tr>
            <th>Booking ID</th>
            <th>Ticket ID</th>
            <th>Bus ID</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Date</th>
            <th>Seats Booked</th>
            <th>Cost</th>
            <th>Action</th>
        </tr>
        <%	if(!list.isEmpty()) {
        	for (Bookings booking : list) { %>
            <tr>
                <td><%= booking.getBookingId() %></td>
                <td><%= booking.getTicketId() %></td>
                <td><%= booking.getBusId() %></td>
                <td><%= sourceList.get(i) %></td>
                <td><%= destinationList.get(i++) %></td>
                <td><%= booking.getDate() %></td>
                <td><%= booking.getSeatsbooked() %></td>
                <td><%= booking.getCost() %></td>
                <td>
                    <form action="deletebooking" method="post" onsubmit="return confirm('Are you sure you want to delete this booking?');">
                        <input type="hidden" name="bookingId" value="<%= booking.getBookingId() %>">
                        <input type="hidden" name="busId" value="<%= booking.getBusId() %>">
                        <input type="hidden" name="date" value="<%= booking.getDate() %>">
                        <input type="hidden" name="seatsBooked" value="<%= booking.getSeatsbooked() %>">
                        <button type="submit" class="delete-button">Delete</button>
                    </form>
                </td>
            </tr>
            <% } %>
		<% } else {%>
    </table>
        	<p class="error">No Bookings Yet!</p>
        	<% } %>
        	 <p class="error"><%
         Object message = request.getAttribute("Message");
                		if(message!=null)
                			out.println(message);
    %></p>
</body>
</html>