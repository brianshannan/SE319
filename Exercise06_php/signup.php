<?php

// If posting, get values and try to make user
if($_SERVER["REQUEST_METHOD"] == "POST") {
    $alpha_num_regex = "/^[a-zA-Z0-9]+$/";
    $email_regex = "/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/";
    $phone_regex = "/^[0-9]{10}$|^[0-9]{3}-[0-9]{3}-[0-9]{4}$/";
    $librarian_regex = "/^true$|^false$/";
    $alpha_regex = "/^[a-zA-Z]+$/";

    $username = $_POST["username"];
    $password = $_POST["password"];
    $email = $_POST["email"];
    $phone = $_POST["phone"];
    $librarian = $_POST["librarian"];
    $first = $_POST["first-name"];
    $second = $_POST["last-name"];

    $errors = false;
    if(!preg_match($alpha_num_regex, $username)) {
        echo "Username is not alphanumeric<br>";
        $errors = true;
    }
    if($password != $_POST["confirm-password"] || $password == "") {
        echo "Passwords are not the same<br>";
        $errors = true;
    }
    if(!preg_match($email_regex, $email)) {
        echo "Email is not in the correct format<br>";
        $errors = true;
    }
    if(!preg_match($phone_regex, $phone)) {
        echo "Phone number is not in the correct format<br>";
        $errors = true;
    }
    if(!preg_match($librarian_regex, $librarian)) {
        echo "Librarian should be 'true' or 'false'<br>";
        $errors = true;
    }
    if(!preg_match($alpha_regex, $first)) {
        echo "First name must be alpha<br>";
        $errors = true;
    }
    if(!preg_match($alpha_regex, $second)) {
        echo "Last name must be alpha<br>";
        $errors = true;
    }

    if(!$errors) {
        if($librarian == "true") {
            $librarian = 1;
        } else {
            $librarian = 0;
        }
        $password = md5($password);

        $db_username = "u319all";
        $db_password = "024IjLaMj4dI";
        $db_server = "mysql.cs.iastate.edu";
        $db_name   = "db319all";
        $db_connection = mysqli_connect($db_server, $db_username, $db_password, $db_name);

        $query = "INSERT INTO users (Groupnumber, Username, Password, Email, Phone, Librarian, Firstname, Lastname) VALUES ('32', '$username', '$password', '$email', '$phone', '$librarian', '$first', '$second')";
        mysqli_query($db_connection, $query);

        // Redirect to login page
        header("Location: signin.php");
        exit;
    }
}

?>

<!-- If errors or get, display form -->
<html>
<body>

<h1>User Registration</h1>

<form name="input" action="signup.php" method="post">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    Confirm Password: <input type="password" name="confirm-password"><br>
    Email: <input type="text" name="email"><br>
    Phone: <input type="text" name="phone"><br>
    Librarian: <input type="text" name="librarian"><br>
    First name: <input type="text" name="first-name"><br>
    Last name: <input type="text" name="last-name"><br>
    <input type="submit" name="submit">
</form>

</body>
</html>
