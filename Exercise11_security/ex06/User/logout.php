<?php
	//start session
	session_start();

	//destroy session data (logout)
	session_destroy();

	//nagivate to user validation
	header("Location: user_validation.php");
	exit;
?>
