<?php

$alpha_num_regex = "/^[a-zA-Z0-9]+$/";
$email_regex = "/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/";
$phone_regex = "/^[0-9]{10}$|^[0-9]{3}-[0-9]{3}-[0-9]{4}$/";
$librarian_regex = "/^true$|^false$/";
$alpha_regex = "/^[a-zA-Z]+$/";

$errors = false;
if(!preg_match($alpha_num_regex, $_POST["username"])) {
    echo "Username is not alphanumeric<br>";
    $errors = true;
}
if(!$_POST["password"] != $_POST["confirm-password"]) {
    echo "Passwords are not the same<br>";
    $errors = true;
}
if(!preg_match($email_regex, $_POST["email"])) {
    echo "Email is not in the correct format<br>";
    $errors = true;
}
if(!preg_match($phone_regex, $_POST["phone"])) {
    echo "Phone number is not in the correct format<br>";
    $errors = true;
}
if(!preg_match($librarian_regex, $_POST["librarian"])) {
    echo "Librarian should be 'true' or 'false'<br>";
    $errors = true;
}
if(!preg_match($alpha_regex, $_POST["first-name"])) {
    echo "First name must be alpha<br>";
    $errors = true;
}
if(!preg_match($alpha_regex, $_POST["last-name"])) {
    echo "Last name must be alpha<br>";
    $errors = true;
}

if($errors) {
    return;
}

echo "thing";

?>
