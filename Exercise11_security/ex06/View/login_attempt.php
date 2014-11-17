<!doctype html>

<html lang="en">
<head>
	<meta charset="utf-8">

	<title>Login</title>
	<meta name="description" content="login form">
	<meta name="author" content="Group 31">

	<link rel="stylesheet" type="text/css" href="../CSS/library.css">
</head>

<body>
	<div class="header">
	<h1>Library Web App Login</h1>
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
		<form name="login_attempt" action="../Database/login_val.php" method="post">
			Username: <input type="text" name="username"><br>
			Password: <input type="password" name="password"><br>
			<input type="submit" value="Login">
		</form>
	</p>
</body>
</html>
