<?php
session_start();
?>
<html>
<body>

<?php
  // remove all session variables
  session_unset(); 

  // destroy the session 
  session_destroy(); 

  // TODO: Check the results now!
  var_dump($_SESSION);
?>

</body>
</html>
