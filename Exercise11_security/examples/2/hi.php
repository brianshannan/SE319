<?php
 $to="webmaster@victim.com";
 if (!isset($_POST["send"])){
   ?>
   <form method="POST" action="<?=$_SERVER['PHP_SELF'];?>">
   From: <input type="text" name="sender">
   Subject : <input type="text" name="subject">
   Message :
   <textarea name="message" rows="10" cols="60" lines="20"></textarea>
   <input type="submit" name="send" value="Send">
   </form>
   <?
 }else{
   // the form has been submitted
   $from=$_POST['sender'];
   // send mail :
   if (mail($to,$_POST['subject'],$_POST['message'],"From: $fromn")){
     echo "Your mail has been sent successfully";
 }else{
]
    echo "An error has been occured !";
   }
 }
 ?>