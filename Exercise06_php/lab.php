<?php

$username = "u319all";
$password = "024IjLaMj4dI";
$dbServer = "mysql.cs.iastate.edu";
$dbName   = "db319all";
$dbConnection = mysqli_connect($dbServer, $username, $password, $dbName)


class Library {
    const GROUP_NUMBER = 32;
    private $shelves;

    function __construct() {
        $shelves = array();
    }

    public function addBook($bookId, $bookName, $author) {
        // TODO
    }

    public function deleteBook($bookId, $bookName, $author) {
        // TODO
    }

    public function viewLoanHistory($username) {
        // TODO
    }

    public function borrow($bookId) {
        // TODO
    }

    public function return($bookId) {
        // TODO
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
    private $bookId;
    private $bookName;
    private $author;

    function __construct($bookId, $bookName, $author) {
        $this->bookId = $bookId;
        $this->bookName = $bookName;
        $this->author = $author;
    }
}

class User {
    const GROUP_NUMBER = 32;
}


?>
