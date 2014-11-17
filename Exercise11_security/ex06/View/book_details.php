<<!doctype html>

<html lang="en">
<head>
	<meta charset="utf-8">

	<title>Book Details</title>
	<meta name="description" content="Student homepage">
	<meta name="author" content="Group 31">

	<link rel="stylesheet" type="text/css" href="../CSS/library.css">
</head>

<body>
	<div class="header">
		<h1>Library Web App</h1>
	</div>
	<div class="user_options">
		<p><?php session_start(); echo $_SESSION['user'];
			if(isset($_SESSION['user_student']))
			{
				echo " (student)";
			}
			else
			{
				echo " (librarian)";
			}?></p>
		<p>
			<a href="../User/logout.php"> Logout </a>
		</p>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="book_details">
	<table border="1">
	<?php
		include("../Model/library.php");
		include("../Model/student.php");
		$library = new library();
		if(isset($_SESSION["user_student"]))
		{
			$student = new student($_SESSION["user"]);
		}
		$book_loc = $_GET;

		if(isset($book_loc['checkout']))
		{
			$library->burrow($book_loc['shelf'], $book_loc['book'],
				$library->shelf[$book_loc['shelf']]->books[$book_loc['book']]->copyID, $student);
		}

		if(isset($book_loc['return']))
		{
			$library->returnbook($book_loc['shelf'], $book_loc['book'],
				$library->shelf[$book_loc['shelf']]->books[$book_loc['book']]->copyID, $student);
		}

		echo "<tr>";

		echo "<td>";
		echo "Book ID";
		echo "</td>";
		echo "<td>";
		echo $library->shelf[$book_loc['shelf']]->books[$book_loc['book']]->bookID;
		echo "</td>";

		echo "</tr>";

		echo "<tr>";

		echo "<td>";
		echo "Copy ID";
		echo "</td>";
		echo "<td>";
		echo $library->shelf[$book_loc['shelf']]->books[$book_loc['book']]->copyID;
		echo "</td>";

		echo "</tr>";

		echo "<tr>";

		echo "<td>";
		echo "Title";
		echo "</td>";
		echo "<td>";
		echo $library->shelf[$book_loc['shelf']]->books[$book_loc['book']]->title;
		echo "</td>";

		echo "</tr>";

		echo "<tr>";

		echo "<td>";
		echo "Author";
		echo "</td>";
		echo "<td>";
		echo $library->shelf[$book_loc['shelf']]->books[$book_loc['book']]->author;
		echo "</td>";

		echo "</tr>";

		echo "</table>";
		echo "<br>";

		if(!$library->shelf[$book_loc['shelf']]->books[$book_loc['book']]->isCheckedOut && isset($student))
		{
			echo "<a href=\"book_details.php?shelf=".$book_loc['shelf']."&book=".$book_loc['book']."&checkout=1\">Checkout Book</a>";
			echo "<br><a href=\"student_home.php\">Back to Library</a>";
			echo "</div></body>";
			exit;
		}
		if(isset($student))
		{
			if($library->shelf[$book_loc['shelf']]->books[$book_loc['book']]->isCheckedOut &&
				$student->hasbook($library->shelf[$book_loc['shelf']]->books[$book_loc['book']]->copyID))
			{
				echo "<a href=\"book_details.php?shelf=".$book_loc['shelf']."&book=".$book_loc['book']."&return=1\">Return Book</a>";
			}
			else
			{
				echo "Sorry, this book is already checked out.";
			}
			echo "<br><a href=\"student_home.php\">Back to Library</a>";
			echo "</div></body>";
			exit;
		}
		if($library->shelf[$book_loc['shelf']]->books[$book_loc['book']]->isCheckedOut && isset($student))
		{
			echo "Sorry, this book is already checked out.";
			echo "<br><a href=\"student_home.php\">Back to Library</a>";
		}
		if(!isset($student))
		{
			echo "<a href=\"../Database/delete_book.php?bookID=".$library->shelf[$book_loc['shelf']]->books[$book_loc['book']]->bookID."\"> Delete Book </a>";
			echo "<br><a href=\"librarian_home.php\">Back to Library</a>";
		}
	?>
	</div>
</body>
