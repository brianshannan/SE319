<?php

    session_start();

    $db_username = "u319all";
    $db_password = "024IjLaMj4dI";
    $db_host = "mysql.cs.iastate.edu";
    $db_name = "db319all";
    $db_connection = "";

    $username = $_POST["username"];
    $_SESSION["username"] = $username;

    $user_exists_query = "SELECT username FROM usernames WHERE username = '$username'";
    $user_exists_result = mysqli_query($db_connection, $user_exists_query);
    $user_num_rows = mysqli_num_rows($user_exists_result);

    if($user_num_rows > 0) {
        $insert_user = "INSERT INTO usernames (username) VALUES ($username)";
        mysqli_query($db_connection, $insert_user);

        $insert_follower = "INSERT INTO followers (username, followername) VALUES ('$username', '$username')";
        mysqli_query($db_connection, $insert_follower);
    }

    header("Location: mainpage.html");
    exit;

?>
