<?php
	//start session
	session_start();

	if(isset($_SESSION['user_student']))
	{
		//student is logged in. show their page
		header("Location: ../View/student_home.php");
		exit;
	}

	else if(isset($_SESSION['user_librarian']))
	{
		//librarian is logged in. show their page
		header("Location: ../View/librarian_home.php");
		exit;
	}

	else
	{
		//no user logged in. direct to login form
		header("Location: ../View/login.html");
		exit;
	}
?>
