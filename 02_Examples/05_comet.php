<?php

$i = 0;
while ($i < 10) {
  sleep(5);
  echo "The current value of i is ".$i. " <br>";
  $i = $i + 1;

  // force sending of the next chunk of data  to the client
  ob_flush();
  flush();
}

?>
