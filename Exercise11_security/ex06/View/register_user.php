<?php
	session_start();

	//validate username
	if(!ctype_alnum($_POST["username"]) || empty($_POST["username"]))
	{
		$_SESSION["error"] = "Invalid Username Format: must be alphanumeric";
		header("Location: signup.php");
		exit;
	}

	//validate password
	if($_POST["password"] != $_POST["confirm_password"] || empty($_POST["password"]))
	{
		$_SESSION["error"] = "Invalid Password Format: passwords must match";
		header("Location: signup.php");
		exit;
	}

	//validate email
	if(!filter_var($_POST["email"], FILTER_VALIDATE_EMAIL))
	{
		$_SESSION["error"] = "Invalid Email Format: must be XXX@XXX.XXX where X is alphanumeric";
		header("Location: signup.php");
		exit;
	}

	//validate phone number
	if(!preg_match("/^[0-9]{3}-[0-9]{3}-[0-9]{4}$/", $_POST["phone"]) && !preg_match("/^[0-9]{10}$/", $_POST["phone"])) {
  		$_SESSION["error"] = "Invalid Phone Format: must be XXX-XXX-XXXX or XXXXXXXXXX where X is numeric";
		header("Location: signup.php");
		exit;
	}

	//validate librarian flag
	if(!isset($_POST["user_type"]))
	{
		$_SESSION["error"] = "Must select user type (librarian or student)";
		header("Location: signup.php");
		exit;
	}

	//validate first name
	if(!ctype_alpha ($_POST["first_name"]) || empty($_POST["first_name"]))
	{
		$_SESSION["error"] = "Invalid First Name Format";
		header("Location: signup.php");
		exit;
	}

	//validate last name
	if(!ctype_alpha ($_POST["last_name"]) || empty($_POST["last_name"]))
	{
		$_SESSION["error"] = "Invalid Last Name Format";
		header("Location: signup.php");
		exit;
	}

	include("../Database/register_user.php");

	header("Location: login.html");
	exit;
?>
