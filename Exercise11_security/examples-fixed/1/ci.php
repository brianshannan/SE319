<?php
print("Please specify the name of the file to delete");
print("<p>");
$file=$_GET['filename'];
$file = escapeshellarg($file);
system("rm $file");
?>
