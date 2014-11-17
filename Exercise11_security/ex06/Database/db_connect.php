<?php

	//database credentials
	$username = "u319all";
	$password = "024IjLaMj4dI";
	$dbServer = "mysql.cs.iastate.edu";
	$dbName   = "db319all";

	//connection to the database
	$dbhandle = mysqli_connect($dbServer, $username, $password, $dbName)
		or die("Unable to connect to MySQL");

?>

