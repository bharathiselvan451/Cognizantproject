<%@ page import="com.cognizant.project.model.Bus" %>

<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bus List</title>
    <link rel="stylesheet" type="text/css" href="allbuses.css">
    <script>
        function showPopup(){
        	alert("Booking Successful!")
        }
        
    </script>
</head>
<body>
    <% 
        List<Bus> list = (List<Bus>) request.getAttribute("list");
        List<Integer> seats = (List<Integer>) request.getAttribute("seats");
        String date = (String) request.getAttribute("date");
        int i=0;
    %>
    <header>
		<h2>
			<% if (list.size() == 1) {
           		out.println("<span class='bus-count'>" + list.size() + "</span> bus available on <span class='date-italic'>" + date + "</span>");
	        } else {
	            out.println("<span class='bus-count'>" + list.size() + "</span> buses available on <span class='date-italic'>" + date + "</span>");
	        } %>
		</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
        <div id="menuToggle">
          <input type="checkbox" />
          
          <span></span>
          <span></span>
          <span></span>
         
          <ul id="menu">
            <a class="profile-button" href="profile"><li><b>UPDATE PROFILE</b></li></a>
            <a class="mybookings-button" href="mybookings"><li><b>MY BOOKINGS</b></li></a>
            <a class="mybookings-button" href='allbuses'><li><b>BACK</b></li></a>
          </ul>
        </div>
      </nav>
	</header>
    <form action="buslist" method="post">
        <table>
            <tr>
                <th>Bus ID</th>
                <th>Name</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Price</th>
                <th>Seats Available</th>
                <th>Number of Seats</th>
            </tr>

            <% if (list != null) {
                for (Bus obj : list) { %>
                    <tr>
                        <td><%= obj.getId() %></td>
                        <td><%= obj.getName() %></td>
                        <td><%= obj.getSource() %></td>
                        <td><%= obj.getDestination() %></td>
                        <td><%= obj.getPrice() %></td>
                        <td><%= seats.get(i++) %></td>
                        <td>
                        	<form action="buslist" method="post">
                        		<input type="hidden" name="busId" value="<%= obj.getId()%>">
                        		<input type="number" name="numberOfSeats" value="0">
                        		<button type="submit" class="booktickets" onclick="showPopup()">Book</button>
                        	</form>
                       </td>
                    </tr>
                <% }
            } %>
        </table>
    </form>
</body>
</html>
