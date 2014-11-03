<?php


session_start();
$username = $_SESSION['username'];

$db_username = "u319all";
$db_password = "024IjLaMj4dI";
$db_host = "mysql.cs.iastate.edu";
$db_name = "db319all";
$db_connection = mysqli_connect($db_host, $db_username, $db_password, $db_name);

$get_users_query = "SELECT username, COUNT(*) AS num_followers FROM usernames INNER JOIN followers USING (username) GROUP BY followername";
$users_result = mysqli_query($db_connection, $get_users_query);

$users_list = array();

while($row = mysqli_fetch_assoc($users_result)) {
    array_push($users_list, $row);
}

echo json_encode($users_list);
?>
