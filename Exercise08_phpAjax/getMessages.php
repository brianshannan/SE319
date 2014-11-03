<?php


session_start();
$username = $_SESSION['username'];

$db_username = "u319all";
$db_password = "024IjLaMj4dI";
$db_host = "mysql.cs.iastate.edu";
$db_name = "db319all";
$db_connection = mysqli_connect($db_host, $db_username, $db_password, $db_name);

header('Content-Type: application/json');
while(true) {


    $get_messages_query = "SELECT * FROM message WHERE message.username IN (SELECT followername FROM followers WHERE followers.username = '$username') ORDER BY posttime DESC";
    $messages_result = mysqli_query($db_connection, $get_messages_query);

    $messages_list = array();

    while($row = mysqli_fetch_assoc($messages_result)) {
        array_push($messages_list, $row);
    }

    echo json_encode($messages_list);

    ob_flush();
    flush();
    unset($message_list);
    sleep(5);
}

?>
