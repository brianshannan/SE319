<?php
    session_start();
    $username = $_SESSION['username'];
    $message = $_POST['message'];
    $posttime = date("Y-m-d H:i:s");

    $db_username = "u319all";
    $db_password = "024IjLaMj4dI";
    $db_host = "mysql.cs.iastate.edu";
    $db_name = "db319all";
    $db_connection = mysqli_connect($db_host, $db_username, $db_password, $db_name);

    $post_message = "INSERT INTO message (username, msg, posttime) VALUES ('$username', '$message', '$posttime')";

    mysqli_query($db_connection, $post_message);
?>
