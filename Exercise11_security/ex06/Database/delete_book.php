<?php
	include("../Model/library.php");
	$library = new library();
	$library->deleteBook($_GET['bookID']);
	header("Location: ../View/librarian_home.php");
	exit;
?>
