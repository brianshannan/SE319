<?php
// WE ARE ON THE SERVER SIDE.
// HERE WE ARE CREATING A MULTIPART RESPONSE TO BE SENT BACK TO THE
// CLIENT.
header( "MIME-Version: 1.0 ");
header('Content-type: Multipart/mixed; type="text/html" boundary=END');
echo "what we have here should not matter";
echo "\n--END\n";

echo "Content-Type: text/plain\n";
echo 'Content-location: "n.txt"\n\n';
echo "PART-1 End\n\n";
echo "\n--END\n";

echo "Content-Type: text/html\n\n";
echo "<b>Hi this is a test<b><br>";
echo '<script>alert("hi")</script>';
echo "PART-2 End\n\n";
echo "\n--END\n";

echo "Content-Type: text/plain\n";
echo "Content-disposition: inline\n\n";
echo "PART-3 End\n\n";
echo "\n--END\n";

echo "Content-Type: text/html\n\n";
echo "<b>Hi this is a test<b><br>";
echo '<script>alert("hi-2")</script>';
echo '<a href="n.txt">Click Here</a>';
echo "PART-4 End\n\n";
echo "--END--\n\n";

?>
