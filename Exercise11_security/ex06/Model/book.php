<?php
class book
{
    // properties
    public $bookID;
    public $copyID;
    public $title;
    public $author;
    public $isCheckedOut;

    // methods
    function __construct($givenBookID, $givenCopyID, $givenTitle, $givenAuthor)
    {
    	$this->bookID = $givenBookID;
    	$this->copyID = $givenCopyID;
    	$this->title = $givenTitle;
    	$this->author = $givenAuthor;
    	$this->isCheckedOut = FALSE;
    }
}
?>
