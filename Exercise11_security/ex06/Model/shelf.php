<?php
include("book.php");
class shelf
{
    // properties
    public $books;
    public $index;

	function __construct($givenIndex)
	{
		$this->index = $givenIndex;
		$this->books = new SplFixedArray(10);
    	include("../Database/db_connect.php");

        $anIndex = $this->index + 1;

		$result = mysqli_query($dbhandle, "SELECT * FROM shelves WHERE Groupnumber = '31' AND Shelfid = '$anIndex'") or die (mysql_error());

		$i = 0;
		while($row = mysqli_fetch_array($result))
		{
			$result2 = mysqli_query($dbhandle, "SELECT * FROM bookscopy WHERE Copyid = '$row[Copyid]' AND Groupnumber = '31'") or die (mysql_error());
			$bookID = mysqli_fetch_array($result2);
			$result3 = mysqli_query($dbhandle, "SELECT * FROM books WHERE Bookid = '$bookID[Bookid]' AND Groupnumber = '31'") or die (mysql_error());
			$book = mysqli_fetch_array($result3);
			$this->books[$i] = new book($bookID['Bookid'], $row['Copyid'], $book['Booktitle'], $book['Author']);

            $curcopy = $row['Copyid'];

            $loanhistory = mysqli_query($dbhandle, "SELECT * FROM loanHistory WHERE Groupnumber = '31' AND Copyid = '$curcopy' AND Returnedondate is null");

            while($row = mysqli_fetch_array($loanhistory))
            {
               $this->books[$i]->isCheckedOut = TRUE;
            }

            $i++;
		}
   	}

    public function addBook($givenBookID, $givenCopyID, $givenTitle, $givenAuthor)
    {
    	for($i = 0; $i < 10; $i++)
    	{
    		if(!isset($this->books[$i]))
    		{

    			$this->books[$i] = new book($givenBookID, $givenCopyID, $givenTitle, $givenAuthor);
    			//insert into database
    			include("../Database/db_connect.php");

                //$loanhistory = mysqli_query($dbhandle, "SELECT * FROM loanHistory WHERE Groupnumber = '31' AND Copyid = '$givenCopyID' AND Returnedondate is null");

                //while($row = mysqli_fetch_array($loanhistory))
                //{
                //    $this->books[$i]->isCheckedOut = TRUE;
                //}

    			$anIndex = $this->index;

    			//database writes
    			mysqli_query($dbhandle, "INSERT INTO bookscopy (Groupnumber, Copyid, Bookid)
    				VALUES ('31', '$givenCopyID', '$givenBookID')") or die(mysql_error());

                if($anIndex == 0)
                {
                    mysqli_query($dbhandle, "INSERT INTO shelves (Groupnumber, Shelfid, Copyid)
                        VALUES('31', 1, '$givenCopyID')") or die(mysql_error());
                }
                if($anIndex == 1)
                {
                    mysqli_query($dbhandle, "INSERT INTO shelves (Groupnumber, Shelfid, Copyid)
                        VALUES('31', 2, '$givenCopyID')") or die(mysql_error());
                }
                if($anIndex == 2)
                {
                    mysqli_query($dbhandle, "INSERT INTO shelves (Groupnumber, Shelfid, Copyid)
                        VALUES('31', 3, '$givenCopyID')") or die(mysql_error());
                }
                if($anIndex == 3)
                {
                    mysqli_query($dbhandle, "INSERT INTO shelves (Groupnumber, Shelfid, Copyid)
                        VALUES('31', 4, '$givenCopyID')") or die(mysql_error());
                }

                if($anIndex == 4)
                {
                    mysqli_query($dbhandle, "INSERT INTO shelves (Groupnumber, Shelfid, Copyid)
                        VALUES('31', 5, '$givenCopyID')") or die(mysql_error());
                }

                if($anIndex == 5)
                {
                    mysqli_query($dbhandle, "INSERT INTO shelves (Groupnumber, Shelfid, Copyid)
                        VALUES('31', 6, '$givenCopyID')") or die(mysql_error());
                }
                if($anIndex == 6)
                {
                    mysqli_query($dbhandle, "INSERT INTO shelves (Groupnumber, Shelfid, Copyid)
                        VALUES('31', 7, '$givenCopyID')") or die(mysql_error());
                }
                if($anIndex == 7)
                {
                    mysqli_query($dbhandle, "INSERT INTO shelves (Groupnumber, Shelfid, Copyid)
                        VALUES('31', 8, '$givenCopyID')") or die(mysql_error());
                }
                if($anIndex == 8)
                {
                    mysqli_query($dbhandle, "INSERT INTO shelves (Groupnumber, Shelfid, Copyid)
                        VALUES('31', 9, '$givenCopyID')") or die(mysql_error());
                }
                if($anIndex == 9)
                {
                    mysqli_query($dbhandle, "INSERT INTO shelves (Groupnumber, Shelfid, Copyid)
                        VALUES('31', 10, '$givenCopyID')") or die(mysql_error());
                }

    			include("../Database/db_close.php");

    			return;
    		}
    	}
    }

    public function deleteBook($copyID)
    {
        include("../Database/db_connect.php");
    	mysqli_query($dbhandle, "DELETE FROM shelves WHERE Groupnumber = '31' AND Copyid = '$copyID'");
        include("../Database/db_close.php");
    }

    public function burrow($bookNo)
    {
    	$this->books[$bookNo]->isCheckedOut = TRUE;
    }

    public function returnbook($bookNo)
    {
    	$this->books[$bookNo]->isCheckedOut = FALSE;
    }

    public function hasSpace()
    {
    	for($i = 0; $i < 10; $i++)
    	{
    		if(!isset($this->books[$i]))
    		{
    			return TRUE;
    		}
    	}
    	return FALSE;
    }
}
?>
