<?php

$username = "a username"; // TODO

$db_username = "u319all";
$db_password = "024IjLaMj4dI";
$db_server = "mysql.cs.iastate.edu";
$db_name   = "db319all";
$db_connection = mysqli_connect($db_server, $db_username, $db_password, $db_name);

class Library {
    const GROUP_NUMBER = 32;
    private $shelves;

    function __construct() {
        global $db_connection;
        $this->shelves = array();

        $group_number = self::GROUP_NUMBER;
        $get_shelves_query = "SELECT Shelfid FROM shelves WHERE Groupnumber = $group_number";
        $result = mysqli_query($db_connection, $get_shelves_query);
        echo('thing');
        while($row = mysqli_fetch_assoc($result)) {
            array_push($this->shelves, new Shelf($row['Shelfid']));
        }
    }

    public function addBook($book_name, $author) {
        global $db_connection;

        $group_number = self::GROUP_NUMBER;
        // Add to books table
        $insert_book_query = "INSERT INTO books (Groupnumber, Booktitle, Author) VALUES ('$group_number', '$book_name', '$author')";
        mysqli_query($db_connection, $insert_book_query);
        $result = mysqli_query($db_connection, "SELECT LAST_INSERT_ID() AS book_id");
        $book_id = mysqli_fetch_assoc($result)['book_id'];

        // Add copy of book to BooksCopy table
        $insert_copy_query = "INSERT INTO bookscopy (Groupnumber, Bookid) VALUES ('$group_number', '$book_id');";
        mysqli_query($db_connection, $insert_copy_query);

        // Space in existing shelves
        foreach($this->shelves as $shelf) {
            if(count($shelf) < $shelf->len) {
                $shelf_id = $shelf->shelf_id;
                $copy_shelf_query = "INSERT INTO shelves (Groupnumber, Shelfid, Copyid) VALUES ($group_number, $shelf_id, LAST_INSERT_ID())";
                mysqli_query($db_connection, $copy_shelf_query);
                $book = new Book($book_id, $book_name, $author);
                $shelf->addBook($book);
                return;
            }
        }
        // Need to make a new Shelf
        $copy_shelf_query = "INSERT INTO shelves (Groupnumber, Copyid) VALUES ($group_number, LAST_INSERT_ID())";
        mysqli_query($copy_shelf_query);
        $result = mysqli_query($db_connection, "SELECT LAST_INSERT_ID() AS shelf_id");
        $shelf_id = mysqli_fetch_assoc($result)['shelf_id'];
        $shelf = new Shelf($shelf_id);
        array_push($this->shelves, $shelf);
        $book = new Book($book_id, $book_name, $author);
        $shelf->addBook($book);
    }

    public function deleteBook($book_id, $book_name, $author) {
        global $db_connection;

        $group_number = self::GROUP_NUMBER;

        $remove_book_query = "DELETE FROM books WHERE Groupnumber = $group_number AND Bookid = $book_id";
        mysqli_query($db_connection, $remove_book_query);

        $remove_copies_query = "DELETE FROM bookscopy WHERE Groupnumber = $group_number AND Bookid = $book_id";
        mysqli_query($db_connection, $remove_copies_query);

        foreach($this->shelves as $shelf) {
            foreach($shelf->books as $key => $book) {
                if($book->book_id == $book_id) {
                    unset($shelf->books[$key]);
                }
            }
        }
    }

    public function viewLoanHistory($username) {
        // TODO
    }

    public function borrow($book_id) {
        global $db_connection;

        $group_number = self::GROUP_NUMBER;
        $copy_id_query = "SELECT Copyid FROM bookscopy WHERE Bookid = $book_id LIMIT 1;";
        $copy_id_result = mysqli_query($db_connection, $copy_id_query);
        $copy_id = mysqli_fetch_assoc($copy_id_result)['Copyid'];

        $due_date = date("Y-m-d");  // Really short borrow time
        $query = "INSERT INTO loanHistory (Groupnumber, Username, Copyid, Duedate) VALUES ('$group_number', '$username', '$copy_id', '$due_date');";
        mysqli_query($db_connection, $query);
    }

    public function returnBook($book_id) {
        global $db_connection;

        $group_number = self::GROUP_NUMBER;

        $copy_id_query = "SELECT Copyid FROM bookscopy WHERE Bookid = $book_id LIMIT 1;";
        $copy_id_result = my_query($db_connection, $copy_id_query);
        $copy_id = mysqli_fetch_assoc($copy_id_result)['Copyid'];  // TODO

        $today = date("Y-m-d");
        $query = "UPDATE loanHistory SET Returnedondate = '$today' WHERE Groupnumber = '$group_number' AND Returnedondate IS NULL AND Username = '$username' AND Copyid = $copy_id;";
        mysqli_query($db_connection, $query);
    }
}

class Shelf {
    const GROUP_NUMBER = 32;
    public $shelf_id;
    public $books;
    public $len = 10;

    function __construct($shelf_id) {
        global $db_connection;

        $this->shelf_id = $shelf_id;
        $this->books = array();
        $get_copies_query = "SELECT Booktitle, Author FROM shelves INNER JOIN bookscopy USING (Copyid) INNER JOIN books using (Bookid) WHERE shelves.Groupnumber = $group_number AND Shelfid = $shelf_id";
        $books_result = mysqli_query($db_connection, $get_shelves_query);
        while($row = mysqli_fetch_assoc($result)) {
            array_push($this->books, new BookCopy($row['Booktitle'], $row['Author']));
        }
    }

    public function addBook($book) {
        array_push($this->books, $book);
    }
}

class BookCopy {
    const GROUP_NUMBER = 32;
    public $book_id;
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

    function __constructor() {}
}

$lib = new Library();


?>
