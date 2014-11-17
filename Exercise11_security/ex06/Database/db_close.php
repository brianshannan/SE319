<?php
	//if db connection exists, close it
	if(isset($db_handle))
	{
		$db_handle->close();
	}
?>
