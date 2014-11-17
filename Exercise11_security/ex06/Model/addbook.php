<?php
	include("library.php");
	$library = new library();
	for($i = 0; $i < $_POST['numcopies']; $i++)
	{
		$library->addBook($_POST['bookid'], $_POST['name'], $_POST['author']);
	}

	header("Location: ../View/librarian_home.php");
?>
