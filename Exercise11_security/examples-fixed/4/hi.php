<?php

$offset = $argv[0]; // beware, no input validation!
$query  = "SELECT id, name FROM products ORDER BY name LIMIT 20 OFFSET ". (int) $offset .";";
$result = pg_query($conn, $query);

?>
