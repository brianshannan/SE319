<html>
<body>

<?php
    session_start();
    $username = $_SESSION["username"];
    $librarian = $_SESSION["librarian"];
    echo "Username: ".$username."<br>";

    include 'lab.php';
    $lib = new Library();

    if(isset($_POST["add-book-submit"])) {
        $book_id = $_POST["book-id"];
        $book_name = $_POST["book-name"];
        $author = $_POST["author"];
        $lib->addBook($book_id, $book_name, $author);
        echo "Book added";
    }

    if(isset($_POST["delete-book-submit"])) {
        $book_id = $_POST["book-id"];
        $lib->deleteBook($book_id);
        echo "Book deleted";
    }

    if(isset($_POST["borrow-book-submit"])) {
        $book_id = $_POST["book-id"];
        $lib->borrowBook($book_id);
        echo "Book borrowed";
    }

    if(isset($_POST["return-book-submit"])) {
        $book_id = $_POST["book-id"];
        $lib->returnBook($book_id);
        echo "Book returned";
    }
?>

<html>
<body>

<?php if($librarian) { ?>

    <h3>Add Book</h3>
    <form name="add-book" action="mainpage.php" method="post">
        Book Id: <input type="text" name="book-id"><br>
        Book Name: <input type="text" name="book-name"><br>
        Author: <input type="text" name="author"><br>
        <input type="submit" name="add-book-submit">
    </form>

    <h3>Delete Book</h3>
    <form name="delete-book" action="mainpage.php" method="post">
        Book Id: <input type="text" name="book-id"><br>
        <input type="submit" name="delete-book-submit">
    </form>

    <h3>View Loan History</h3>
    <form name="view-loan-history" action="mainpage.php" method="post">
        Username: <input type="text" name="username"><br>
        <input type="submit" name="view-loan-history-submit">
    </form>

<?php } else { ?>

    <h3>Borrow Book</h3>
    <form name="borrow-book" action="mainpage.php" method="post">
        Book Id: <input type="text" name="book-id"><br>
        <input type="submit" name="borrow-book-submit">
    </form>

    <h3>Return Book</h3>
    <form name="return-book" action="mainpage.php" method="post">
        Book Id: <input type="text" name="book-id"><br>
        <input type="submit" name="return-book-submit">
    </form>

<?php } ?>

<h3>View Shelves</h3>
<form name="view-shelves" action="mainpage.php" method="post">
    <input type="submit" name="view-shelves-submit">
</form>

<?php

    if(isset($_POST["view-loan-history-submit"])) {
        $loan_history = $lib->viewLoanHistory($username);
        echo $loan_history;
    }

    if(isset($_POST["view-shelves"])) {
        $shelves = $lib->getShelves();
        echo $shelves;
    }
?>

</body>
</html>
