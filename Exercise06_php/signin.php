<!-- If errors or get, display form -->
<html>
<body>

<?php

session_start();

// If posting, get values and try to sign in user
if($_SERVER["REQUEST_METHOD"] == "POST") {

    $username = $_POST["username"];
    $password = $_POST["password"];

    $password = md5($password);

    $db_username = "u319all";
    $db_password = "024IjLaMj4dI";
    $db_server = "mysql.cs.iastate.edu";
    $db_name   = "db319all";
    $db_connection = mysqli_connect($db_server, $db_username, $db_password, $db_name);

    $query = "SELECT * FROM users WHERE Groupnumber = '32' AND Username = '$username' AND Password = '$password'";
    if(!$query) {
        echo "Username or password wasn't correct";
        return;
    }

    $result = mysqli_query($db_connection, $query);
    $count = mysqli_num_rows($result);

    // Login
    if($count != 0) {
        $row = mysqli_fetch_assoc($result);
        if($row["Librarian"] == 1) {
            $librarian = true;
        } else {
            $librarian = false;
        }

        $_SESSION["username"] = $row["Username"];
        $_SESSION["librarian"] = $librarian;
        header("Location: mainpage.php");
        exit;
    }

    echo "Username or password wasn't correct";
}

?>

<h1>User Registration</h1>

<form name="input" action="signin.php" method="post">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" name="submit">
</form>

</body>
</html>
