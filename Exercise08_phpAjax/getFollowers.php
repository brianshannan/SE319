<?php

session_start();
$username = $_SESSION['username'];

$db_username = "u319all";
$db_password = "024IjLaMj4dI";
$db_host = "mysql.cs.iastate.edu";
$db_name = "db319all";
$db_connection = mysqli_connect($db_host, $db_username, $db_password, $db_name);

$get_followers_query = "SELECT followername FROM followers WHERE username = '$username'";
header('Content-Type: application/json');

while(true) {

    $followers_result = mysqli_query($db_connection, $get_followers_query);
    $followers_list = array();

    while($row = mysqli_fetch_assoc($followers_result)) {
        array_push($followers_list, $row);
    }

    echo json_encode($followers_list);

    ob_flush();
    flush();
    sleep(5);
}
?>
