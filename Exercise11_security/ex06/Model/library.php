<?php
include("shelf.php");
//include("student.php");

class library
{
    // variable that has reference to all 10 shelves
    public $shelf;
    public $copyid;


    // constructor that initializes shelves
	function __construct()
	{
		$this->shelf = new SplFixedArray(10);

		include("../Database/db_connect.php");

		$shelf_id_results = mysqli_query($dbhandle, "SELECT DISTINCT(Shelfid) FROM shelves WHERE Groupnumber = '31' ORDER BY Shelfid") or die(mysql_error());

		// $i = 0;
		// while($row = mysqli_fetch_array($shelf_id_results) && $i < 10)
		// {
		// 	$this->shelf[$i] = new shelf($row['Shelfid']);
		// 	$i++;
		// }

        for($i = 0; $i < 10; $i++)
        {
       		$this->shelf[$i] = new shelf($i);
        }

        //set copyID to value of highest found copyID

        $result = mysqli_query($dbhandle, "SELECT * FROM bookscopy WHERE Groupnumber = '31'") or die(mysql_error());
        $highest_copyID = 0;

        while($row = mysqli_fetch_array($result))
        {
        	if($row['Copyid'] > $highest_copyID)
        	{
        		$highest_copyID = $row['Copyid'];
        	}
        }

        $this->copyid = $highest_copyID;

        include("../Database/db_close.php");
    }

    public function addBook($bookID, $bookTitle, $author)
    {
    	//check database for bookID
    	include("../Database/db_connect.php");

		$result = mysqli_query($dbhandle, "SELECT * FROM books WHERE Groupnumber = '31' AND Bookid = '$bookID'") or die (mysql_error());

    	//if this book doesn't exist, add it to database
    	if(mysqli_num_rows($result) == 0)
    	{
    		mysqli_query($dbhandle, "INSERT INTO books (Groupnumber, Bookid, Booktitle, Author)
    			VALUES ('31', '$bookID', '$bookTitle', '$author')");
    	}

    	//add this book to first not full shelf with incremented copyID
    	for($i = 0; $i < 10; $i++)
    	{
    		if($this->shelf[$i]->hasSpace())
    		{
    			$this->shelf[$i]->addBook($bookID, ++$this->copyid, $bookTitle, $author);
    			break;
    		}

    		if($i == 10)
    		{
    			$_SESSION["error"] = "Cannot add book, library full";
    		}
    	}

    	include("../Database/db_close.php");

    	return;
    }

    public function deleteBook($bookID)
    {
    	//check database for bookID
    	include("../Database/db_connect.php");

		$result = mysqli_query($dbhandle, "SELECT * FROM books WHERE Groupnumber = '31' AND Bookid='$bookID'") or die (mysql_error());

    	//if this book doesn't exist, error out
    	if(mysqli_num_rows($result) == 0)
    	{
       		$_SESSION["error"] = "cannot delete book, book doesn't exist";
    	}

    	//if it exists get a list of copyID's
    	else
    	{
    		$result2 = mysqli_query($dbhandle, "SELECT * from bookscopy WHERE Groupnumber = '31' AND Bookid = '$bookID'") or die (mysql_error());
    		$copyIDList = array();

    		while($row = mysqli_fetch_array($result2))
    		{
    			$result3 = mysqli_query($dbhandle, "SELECT * FROM shelves WHERE Groupnumber = '31' AND Copyid = '$row[Copyid]'") or die (mysql_error());
    			$shelf_data = mysqli_fetch_array($result3);
    			$copyIDList[$shelf_data['Copyid']] = $shelf_data['Shelfid'];
    		}

    		//remove book from database
            //remove copy id's from shelf
            foreach($copyIDList as $copyIDKey => $shelfIDValue)
            {
                for($i = 0; $i < 10; $i++)
                {
                    if($this->shelf[$i]->index == $shelfIDValue)
                    {
                        $this->shelf[$i]->deleteBook($copyIDKey);
                        mysqli_query($dbhandle, "DELETE FROM loanHistory WHERE Groupnumber = '31' AND Copyid = '$copyIDKey'");
                    }
                }
            }

            mysqli_query($dbhandle, "DELETE FROM bookscopy WHERE Groupnumber = '31' AND Bookid = '$bookID'") or die (mysql_error());
            mysqli_query($dbhandle, "DELETE FROM books WHERE Groupnumber = '31' AND Bookid = '$bookID'") or die (mysql_error());
    	}

    	include("../Database/db_close.php");
    }

    public function burrow($shelfID, $bookNo, $copyID, $student)
    {
    	$student->checkout($copyID);

        $this->shelf[$shelfID]->burrow($bookNo);
    }

    public function returnbook($shelfID, $bookNo, $copyID, $student)
    {
    	$student->returnbook($copyID);

        $this->shelf[$shelfID]->returnbook($bookNo);
    }
}
?>
