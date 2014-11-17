<!doctype html>

<html lang="en">
<head>
	<meta charset="utf-8">

	<title>Student Home</title>
	<meta name="description" content="Student homepage">
	<meta name="author" content="Group 31">

	<link rel="stylesheet" type="text/css" href="../CSS/library.css">
</head>

<body>
	<div class="header">
		<h1>Library Web App</h1>
	</div>
	<div class="user_options">
		<p><?php session_start(); echo $_SESSION['user'];?> (student)</p>
		<p>
			<a href="../User/logout.php"> Logout </a>
		</p>
	</div>
	<br>
	<table border="1">
	<?php
		include("../Model/library.php");
		echo "<br>";
		echo "<br>";
		echo "<br>";
		echo "<br>";
		echo "<br>";
		$library = new library();
		$i = 0;
		$j = 0;

		echo "<tr>";
		for($i = 0; $i < 10; $i++)
		{
			echo "<td>";
			echo "Shelf ".$i;
			echo "</td>";
		}
		echo "</tr>";

		for($i = 0; $i < 10; $i++)
		{
			echo "<tr>";
			for($j = 0; $j < 10; $j++)
			{
				echo "<td>";
				if(isset($library) && isset($library->shelf[$j]) && isset($library->shelf[$j]->books[$i]))
				{
					echo "<a href=\"book_details.php?shelf=".$j."&book=".$i."\">";
					echo $library->shelf[$j]->books[$i]->title;
					echo "</a>";
				}
				else
				{
					echo "...";
				}
				echo "</td>";
			}
			echo "</tr>";
		}
	?>
	</table>
</body>
</html>
