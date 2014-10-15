<?php
session_start(); // Note that this must be the first thing you do.

echo " <h1> This is the next page</h1> <hr><br>";

// STORE SOME VALUE
$_SESSION["myShoppingCart"] = array("Rocket"=> 3, "Oxygen" => 100);

// TODO: CHECK IF THE favcolor has been stored from the LAST HTTP
// request
echo "<h2>Do check if favcolor has been stored</h2><br>"
var_dump($_SESSION);

// HERE WE CLICK AGAIN AND MAKE ANOTHER HTTP REQUEST!
// HOWEVER SESSION WILL BE STORED
echo "<a href=\"2_superGlobals.php\">Click here to go to next page</a>";
echo "<hr><br>";

?>

