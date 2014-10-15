<?php
// THIS IS JUST A SIMPLE EXAMPLE TO SHOW CONNECTION TO A DATABASE
// YOU WILL NEED TO FILL THE PROPER CREDENTIALS FOR THE
// USERNAME, PASSWORD, AND DATABASESERVER names
// TODO: TRY USING THE CREDENTIALS SUPPLIED LATER IN THE EXERCISE

$username = "your_name";
$password = "your_password";
$dbServer = "localhost"; 
$dbName   = "myDB";

//connection to the database
$dbhandle = mysqli_connect($dbServer, $username, $password, $dbName) 
  or die("Unable to connect to MySQL");

echo "Connected to MySQL<br>";
?>
