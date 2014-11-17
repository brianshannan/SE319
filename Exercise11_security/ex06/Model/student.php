<?php
class Student
{
    // properties
    public $username;
    public $books = array();
    public $index;

    // methods
    public function __construct($username) {
        $this->username = $username;

        include("../Database/db_connect.php");

        $result = mysqli_query($dbhandle, "SELECT * FROM loanHistory WHERE Groupnumber = '31' AND Username = '$this->username' AND Returnedondate is null") or die(mysql_error());

        $this->index = 0;
        while($row = mysqli_fetch_array($result))
        {
        	$this->books[$this->index] = $row['Copyid'];
        	$this->index++;
        }

        include("../Database/db_close.php");
    }

    public function checkout($copyID)
    {
    	include("../Database/db_connect.php");

    	$this->books[$this->index++] = $copyID;

    	$date = date("Y-m-d");
        $duedate = strtotime("+7 day", strtotime($date));
        $duedatestring = date("Y-m-d", $duedate);

        $result = mysqli_query($dbhandle, "SELECT * FROM loanHistory WHERE Groupnumber = 31 AND Copyid = '$copyID'");

        if($row = mysqli_fetch_array($result))
        {
        	mysqli_query($dbhandle, "DELETE FROM loanHistory WHERE Groupnumber = '31' and Copyid = '$copyID'");
			mysqli_query($dbhandle, "INSERT INTO loanHistory (Groupnumber, Username, Copyid, Duedate)
    			VALUES ('31', '$this->username', '$copyID', '$duedatestring')");
    		mysqli_query($dbhandle, "UPDATE loanHistory SET Returnedondate is null");
        }
        else
        {
        	mysqli_query($dbhandle, "INSERT INTO loanHistory (Groupnumber, Username, Copyid, Duedate)
    			VALUES ('31', '$this->username', '$copyID', '$duedatestring')");
        }

    	include("../Database/db_close.php");
    }

    public function returnbook($copyID)
    {
		include("../Database/db_connect.php");

    	$this->books[$this->index--] = null;

    	$date = date("Y-m-d");

    	mysqli_query($dbhandle, "UPDATE loanHistory SET Returnedondate = '$date' WHERE
    		Groupnumber = '31' AND Copyid = '$copyID' AND Returnedondate is NULL");

    	include("../Database/db_close.php");
    }

    public function hasbook($copyID)
    {
    	foreach($this->books as $aBook)
    	{
    		if($aBook == $copyID)
    		{
    			return TRUE;
    		}
    	}
    	return FALSE;
    }
}
?>
