<?php

$username = "a username"; // TODO

$db_username = "u319all";
$db_password = "024IjLaMj4dI";
$db_server = "mysql.cs.iastate.edu";
$db_name   = "db319all";
$db_connection = mysqli_connect($db_server, $db_username, $db_password, $db_name)

class Library {
    const GROUP_NUMBER = 32;
    private $shelves;

    function __construct() {
        $shelves = array();
    }

    public function addBook($book_id, $book_name, $author) {
        $group_number = self::GROUP_NUMBER;
        // Add to books table
        $insert_book_query = "INSERT INTO books (Groupnumber, Bookid, Booktitle, Author) VALUES ('$group_number', '$book_id', '$book_name', '$author')";
        mysqli_query($db_connection, $insert_book_query);

        // Add copy of book to BooksCopy table
        $insert_copy_query = "INSERT INTO bookscopy (Groupnumber, Bookid) VALUES ('$group_number', '$book_id');";
        mysqli_query($db_connection, $insert_copy_query);

    }

    public function deleteBook($book_id, $book_name, $author) {
        $group_number = self::GROUP_NUMBER;
        // Remove from books Countable
        $remove_book_query = "DELETE FROM books WHERE Groupnumber = $group_number AND Bookid = $book_id";
        mysqli_query($db_connection, $remove_book_query);

        $remove_copies_query = "DELETE FROM bookscopy WHERE Groupnumber = $group_number AND Bookid = $book_id";
        mysqli_query($db_connection, $remove_copies_query);
    }

    public function viewLoanHistory($username) {
        // TODO
    }

    public function borrow($book_id) {
        $group_number = self::GROUP_NUMBER;
        $copy_id_query = "SELECT Copyid from bookscopy WHERE Bookid = $book_id LIMIT 1;";
        $copy_id_result = mysqli_query($db_connection, $copy_id_query);
        $copy_id = mysqli_fetch_assoc($copy_id_result)['Copyid'];

        $due_date = date("Y-m-d");  // Really short borrow time
        $query = "INSERT INTO loanHistory (Groupnumber, Username, Copyid, Duedate) VALUES ('$group_number', '$username', '$copy_id', '$due_date');";
        mysqli_query($db_connection, $query);
    }

    public function return($book_id) {
        $group_number = self::GROUP_NUMBER;

        $copy_id = "";  // TODO

        $today = date("Y-m-d");
        $query = "UPDATE loanHistory SET Returnedondate = '$today' WHERE Groupnumber = '$group_number' AND Returnedondate IS NULL AND Username = '$username' AND Copyid = $copy_id;";
        mysqli_query($db_connection, $query);
    }
}

class Shelf {
    const GROUP_NUMBER = 32;
    private $books;

    function __construct() {
        $books = array();
    }
}

class Book {
    const GROUP_NUMBER = 32;
    private $book_id;
    private $book_name;
    private $author;

    function __construct($book_id, $book_name, $author) {
        $this->book_id = $book_id;
        $this->book_name = $book_name;
        $this->author = $author;
    }
}

class User {
    const GROUP_NUMBER = 32;
}


?>
