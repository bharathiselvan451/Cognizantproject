<%@ page import="java.time.LocalDate" %>
<%@ page import="com.cognizant.project.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Buses</title>
    <link rel="stylesheet" href="searchbus.css">
</head>
<body>
    <header>
		<h2>SEARCH BUS</h2>
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
    <form action="searchbus" method="post" style="background-color:#E6E6FA" >

    <div id="div1" class="classic">
    <label for="city_1">From</label>
    <br>
    <br>
    <select id="city_1" name="source" class="form-select">
    <option value="">Select City</option>
    <option value="Ahemedabad">Ahemedabad</option>
    <option value="Bengaluru">Bengaluru</option>
    <option value="Chennai">Chennai</option>
    <option value="Hyderabad">Hyderabad</option>
    <option value="Jaipur">Jaipur</option>
    <option value="Kolkata">Kolkata</option>
    <option value="Mumbai">Mumbai</option>
    <option value="New Delhi">New Delhi</option>
    <option value="Pune">Pune</option>
    <option value="Surat">Surat</option>
    
    </select>
    </div>
    <br>
    <br>
    
    <div id="div2" class="classic">
    <label for="city_2">To</label>
    <br>
    <select id="city_2" name="destination" class="form-select">
    <option value="">Select City</option>
    <option value="Ahemedabad">Ahemedabad</option>
    <option value="Bengaluru">Bengaluru</option>
    <option value="Chennai">Chennai</option>
    <option value="Hyderabad">Hyderabad</option>
    <option value="Jaipur">Jaipur</option>
    <option value="Kolkata">Kolkata</option>
    <option value="Mumbai">Mumbai</option>
    <option value="New Delhi">New Delhi</option>
    <option value="Pune">Pune</option>
    <option value="Surat">Surat</option>
       </select>
    </div>
    <br><br>
	    <div id="div3" class="classic">
		    <label for="date">Date</label>
		    <br>
		    <br>
		    <input type="date" id="date" name="date" class="form-control" min="<%= java.time.LocalDate.now() %>"/>
    	</div>
    <br><br>
    <button type="submit" class="search-button">Search</button>

    </form>

     <p><%
         Object message = request.getAttribute("message");
                		if(message!=null)
                			out.println(message);
    %></p>
</body>
</html>