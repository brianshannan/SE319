<?php
	session_start();

	//connect to mysql
	include("db_connect.php");

	//save variables from post (hash password via md5)
	$username = $_POST["username"];
	$password = md5($_POST["password"]);

	//get rows from database with correct username
	$result = mysqli_query($dbhandle, "SELECT * FROM users WHERE Groupnumber = '31' AND username = '$username'") or die (mysql_error());

	//validate password of found users
	while($row = mysqli_fetch_array($result)) {
		if($row['Password'] == $password)
		{
			$_SESSION["user"] = $username;
			if($row['Librarian'] == TRUE)
			{
				$_SESSION["user_librarian"] = true;
			}
			else
			{
				$_SESSION["user_student"] = true;
			}
		}
	}

	//close mysql
	include("db_close.php");

	//if we didn't find a user error out
	if(!isset($_SESSION["user"]))
	{
		$_SESSION["error"] = "Invalid username and password";
		header("Location: ../View/login_attempt.php");
		exit;
	}

	//init model
	//$_SESSION["library"]->addBook(rand(0, 5000), "Moby Dick", "Author");

	//go to user validation
	header("Location: ../User/user_validation.php");
	exit;
?>
