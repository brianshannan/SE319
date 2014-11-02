<?php

session_start();
$username = $_SESSION["username"];

header('Content-Type: application/json');
echo json_encode($username);

?>
