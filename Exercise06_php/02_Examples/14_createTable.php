<?php

// THIS IS JUST AN EXAMPLE ON HOW TO CREATE A TABLE.
// HOWEVER, USUALLY YOU DO NOT NEED TO DO THIS BECAUSE USUALLY
// THE TABLES ARE ALREADY CREATED AND YOU USE PHP TO SEARCH OR UPDATE
// EXISTING TABLES.

// CONNECT TO DATABASE
// YOU NEED TO SUPPLY YOUR CREDENTIALS
$dbConnection = mysqli_connect("example.com","peter","abc123","my_db");
if (mysqli_connect_errno()) {
  die("Failed to connect to MySQL: " . mysqli_connect_error());
}

// SQL COMMAND FOR CREATE TABLE
$queryString="CREATE TABLE Persons(FirstName CHAR(30),LastName CHAR(30),Age INT)";

// EXECUTE SQL COMMAND
if (mysqli_query($dbConnection,$queryString)) {
  echo "Table persons created successfully";
} 
else {
  die ("Error creating table: " . mysqli_error($dbConnection));
}
?>
