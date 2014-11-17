<!doctype html>

<html lang="en">
<head>
	<meta charset="utf-8">

	<title>Sign up</title>
	<meta name="description" content="sign up form">
	<meta name="author" content="Group 31">

	<link rel="stylesheet" type="text/css" href="../CSS/library.css">
</head>

<body>
	<div class="header">
		<h1>Library Web App Signup</h1>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<?php
		session_start();
		if(isset($_SESSION["error"]))
		{
			echo $_SESSION["error"];
			unset($_SESSION["error"]);
		}
	?>
	<p>
		<form name="sign up" action="register_user.php" method="post">
			Username: <input type="text" name="username"><br>
			Password: <input type="password" name="password"><br>
			Confirm Password: <input type="password" name="confirm_password"><br>
			Email: <input type="text" name="email"><br>
			Phone: <input type="text" name="phone"><br>
			User Type: <input type="radio" name="user_type" value="Student">Student <input type="radio" name="user_type" value="Librarian">Librarian<br>
			First Name: <input type="text" name="first_name"><br>
			Last Name: <input type="text" name="last_name"><br>
			<input type="submit" value="Sign Up">
		</form>
	</p>
</body>
</html>
