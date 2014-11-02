<?php

    session_start();
    $username = $_SESSION['username'];

    $db_username = "u319all";
    $db_password = "024IjLaMj4dI";
    $db_host = "mysql.cs.iastate.edu";
    $db_name = "db319all";
    $db_connection = mysqli_connect($db_host, $db_username, $db_password, $db_name);

    $get_following_query = "SELECT username FROM followers WHERE followername = '$username'";
    $following_result = mysqli_query($db_connection, $get_following_query);

    $following_list = array();
    
    while($row = mysqli_fetch_assoc($following_result)) {
        array_push($following_list, $row);
    }

    header('Content-Type: application/json');
    echo json_encode($following_list);

?>
