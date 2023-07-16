<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Buses</title>
<link rel="stylesheet" href="searchbus.css">
</head>
<script>
        function addbus(){
        	alert("Bus Added Successful!")
        }
        
    </script>
<body>
	<header>
		<h2>ADD BUS</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul id="menu">
					<h2>WELCOME <font color="fick">ADMIN!</font></h2>
					<a class="mybookings-button" href="addschedule"><li><b>ADD SCHEDULE</b></li></a>
					<a class="mybookings-button" href="allbookings"><li><b>BOOKINGS</b></li></a>
				</ul>
			</div>
		</nav>
	</header>
		<form action="addbus" method="post">
			<table>

				<div>
					<p>
						<label>BusName</label> <br> <br> <input type="text" name="busname" required />
					</p>
				</div>

				<div id="div1" class="classic">
					<label>Source</label> <br> <br> 
					<select id="city_2" name="source" class="form-select">
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
				<div id="div2" class="classic">
					<p>
						<label>Destination</label> <br> <br> 
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
					</p>
				</div>
				<div>
					<p>
						<label>Price</label> <br>
						<br> <input type="number" name="price" required />
					</p>
				</div>
				<div>
					<p>
						<button type="submit" onclick="addbus()">Submit</button>
					</p>
				</div>
		</form>
</body>
</html>