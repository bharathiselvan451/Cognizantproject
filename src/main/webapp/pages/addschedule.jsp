<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Schedule</title>
<link rel="stylesheet" href="searchbus.css">
</head>
<script>
        function showPopup(){
        	alert("Schedule Added Successful!")
        }
        
    </script>
<body>

	<header>
		<h2>ADD SCHEDULE</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul id="menu">
					<h2>WELCOME <font color="fick">ADMIN!</font></h2>
					<a class="mybookings-button" href="addbus"><li><b>ADD
								BUS</b></li></a>
					<a class="mybookings-button" href="allbookings"><li><b>BOOKINGS</b></li></a>
				</ul>
			</div>
		</nav>
	</header>

	<form action="addschedule" method="post">
		<div>
			<p>
				<label><b>Bus ID</b></label> <br> <br>
				<input type="number" name="Bus_Id" required />
			</p>
		</div>
		<div>
			<p>
				<label><b>Date</b></label> <br> <br>
				<input type="date" name="date" required />
			</p>
		</div>
		<div>
			<p>
				<label><b>Seats</b></label> <br> <br>
				<input type="number" name="seats" required />
			</p>
		</div>
		<div>
			<button type="submit" onclick="showPopup()">Submit</button>
		</div>
	</form>

</body>
</html>