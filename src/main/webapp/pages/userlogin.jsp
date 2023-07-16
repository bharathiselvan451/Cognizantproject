<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="userlogin.css" rel="stylesheet">

</head>
<body>
    <h2>USER LOGIN</h2>
    <form method="post">
        <table>
            <tr>
                <td colspan="6"><label for="email">Email id</label></td>
                <td colspan="6"><input type="text" name="email" id="email" required></td>
            </tr>
           
            <tr>
                <td colspan="6"><label for="password">Password</label></td>
                <td colspan="6"><input type="password" name="password" id="password" required></td>
            </tr>
            <tr>
                <td colspan="6"><button type="submit" formaction="login_into">Login</button></td>
            </tr>
        </table>
    </form>
    <a class="login-button"  href ='signup'><b>New User</b></a>
    <a class="login-button" href="admin-login"><b>Admin</b></a>
    <p class="error"><%
         Object message = request.getAttribute("Message");
                		if(message!=null)
                			out.println(message);
    %></p>
    
</body>
</html>