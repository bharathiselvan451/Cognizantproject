<!DOCTYPE html>
<%@ page import=" com.cognizant.project.model.User"%> 
<%@page import="java.util.*"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profile</title>
<link rel="stylesheet" href="allbuses.css">

<script>
	var x = 0;
	var y = 0;
	var z = 0;
	function onButtonClick_1() {
		document.getElementById('textInput_2').style.display = ''
	}
	function onButtonClick_2() {
		x += 1

		if (x % 2 != 0) {
			document.getElementById('textInput_2').style.display = ''
		} else {
			document.getElementById('textInput_2').style.display = 'none'
		}
	}
	function onButtonClick_3() {
		y += 1

		if (y % 2 != 0) {
			document.getElementById('textInput_3').style.display = ''
		} else {
			document.getElementById('textInput_3').style.display = 'none'
		}
	}
	function onButtonClick_4() {
		z += 1

		if (z % 2 != 0) {
			document.getElementById('textInput_4').style.display = ''
		} else {
			document.getElementById('textInput_4').style.display = 'none'
		}
	}
</script>
</head>
<body>
	<header>
		<h2>PROFILE</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
        <div id="menuToggle">
          <input type="checkbox" />
          
          <span></span>
          <span></span>
          <span></span>
         
          <ul id="menu">
            <a class="mybookings-button" href="mybookings"><li><b>MY BOOKINGS</b></li></a>
            <a class="mybookings-button" href='searchbus'><li><b>SEARCH BUSES</b></li></a>
            <a class="mybookings-button" href='allbuses'><li><b>BACK</b></li></a>
          </ul>
        </div>
      </nav>
	</header>

	<table>

		<% User user =(User)request.getAttribute("user"); if(user!=null) { %>
		<tr>
			<th>Email ID</th>
			<td><% out.println(user.getEmail());%></td>
		</tr>

		<tr>
			<th>Password</th>
			<td><% out.println(user.getPassword());%> 
				<input type="button" name="update" class="logout-button" onclick="onButtonClick_2()" value="Update" />
				<div id="textInput_2" style="display: none">
					<br>
					<form action="updatepassword" method="post">
						<input type="password" name="password" required />
						<button type="submit">Submit</button>
					</form>
				</div>
			</td>
		</tr>

		<tr>
			<th>Name</th>
			<td><% out.println(user.getName()); %> 
			<input type="button" name="update" class="logout-button" onclick="onButtonClick_3()" value="Update" />
				<div id="textInput_3" style="display: none">
					<br>
					<form action="updatename" class="hide" method="post">
						<input type="text" name="name" required />
						<button type="submit">Submit</button>
					</form>
				</div>
			</td>
		</tr>

		<tr>
			<th>Phone Number</th>
			<td><% out.println(user.getPhoneNo());%> 
			<input type="button" name="update" class="logout-button" onclick="onButtonClick_4()" value="Update" />
				<div id="textInput_4" style="display: none">
					<br>
					<form action="updatephoneno" class="hide" method="post">
						<input type="text" name="phoneno" required />
						<button type="submit">Submit</button>
					</form>
				</div></td>
		</tr>
		<% }%>
	</table>


</body>
</html>