<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" type="text/css" href="userlogin.css">
</head>
<body>
	<h2>Admin Login</h2>
	<form method="post" action="admin-dashboard">
		<table>
            <tr>
                <td colspan="6"><label for="email">Name</label></td>
                <td colspan="6"><input type="text" name="adminname" id="adminname" required></td>
            </tr>
           
            <tr>
                <td colspan="6"><label for="password">Password</label></td>
                <td colspan="6"><input type="password" name="password" id="password" required></td>
            </tr>
            <tr>
                <td colspan="6"><button type="submit" formaction="admin-dashboard">Login</button></td>
            </tr>
        </table>
		<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
			<% if (errorMessage != null) { %>
			    <div class="error-message" >
			        <p><%= errorMessage %></p>
			    </div>
		<% } %>
					
	</form>
	<p>Not an admin? <a class="login-button" href="login">User Login</a></p>
</body>
</html>
 