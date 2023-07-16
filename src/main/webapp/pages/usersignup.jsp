<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup</title>
    <link href="userlogin.css" rel="stylesheet">
</head>
<body>
    <h2>Signup</h2>
    <form method="post">
        <table>
            <tr>
                <td colspan="6"><label for="email">EmailId</label></td>
                <td colspan="6"><input type="text" name="email" id="email" required></td>
            </tr>
            <tr>
                <td colspan="6"><label for="name">Name</label></td>
                <td colspan="6"><input type="text" name="name" id="name" required></td>
            </tr>
            <tr>
                <td colspan="6"><label for="password">Password</label></td>
                <td colspan="6"><input type="password" name="password" id="password" required></td>
            </tr>
            <tr>
                <td colspan="6"><label for="phoneno">Phoneno</label></td>
                <td colspan="6"><input type="text" name="phoneno" id="phoneno" required></td>
            </tr>
            <tr>
                <td colspan="6">
                    <button type="submit" formaction="signup_into">Signup</button>
                </td>
            </tr>
        </table>
    </form>
   	<a class="login-button" href="login">Login</a>
    <p>
        <% Object message = request.getAttribute("Message");
            if(message != null)
                out.println(message);
        %>
    </p>
</body>
</html>
