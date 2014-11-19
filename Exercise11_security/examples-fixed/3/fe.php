<?php
    $files = array('red', 'blue');
    $color = $_GET['COLOR'];

    if($color == 'red') {
        include('red.php');
    }
    if($color == 'blue') {
        include('blue.php');
    }

?>
