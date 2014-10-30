<html>
    <head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    </head>
    <body>
        <?php
            session_start();
            $username = $_SESSION['username'];

            $db_username = "u319all";
            $db_password = "024IjLaMj4dI";
            $db_host = "mysql.cs.iastate.edu";
            $db_name = "db319all";
            $db_connection = mysqli_connect($db_host, $db_username, $db_password, $db_name);

            $get_followers_query = "SELECT followername FROM followers WHERE username = '$username'";
            $followers_result = mysqli_query($db_connection, $get_followers_query);

            $followers_list = "<ul style='list-style-type: none;'>";
            while($row = mysqli_fetch_assoc($followers_result)) {
                $follower = $row['followername'];
                $li = "<li>$follower</li>";
                $followers_list = $followers_list . $li;
            }
            $followers_list = $followers_list . "</ul>";

            $get_following_query = "SELECT username FROM followers WHERE followername = '$username'";
            $following_result = mysqli_query($db_connection, $get_following_query);
            $following_list = "<ul style='list-style-type: none;'>";
            while($row = mysqli_fetch_assoc($following_result)) {
                $following = $row['username'];
                $li = "<li>$following</li>";
                $following_list = $following_list . $li;
            }
            $following_list = $following_list . "</ul>";


            $get_messages_query = "SELECT * FROM message WHERE username IN (SELECT username FROM followers WHERE followername = '$username')";
            $messages_result = mysqli_query($db_connection, $get_messages_query);
            $messages_list = "<ul style='list-style-type: none;'>";
            while($row = mysqli_fetch_assoc($messages_result)) {
                $message = $row['msg'];
                $li = "<li>$message</li>";
                $messages_list = $messages_list . $li;
            }
            $messages_list = $messages_list . "</ul>";
        ?>
        <h3>Welcome <?php echo $username ?></h3>
        <div style="border-style: solid; border-width: 2px; height: 600px; width: 200px; float: left; margin-right: 5px;">
            <h4 style="text-align: center;">Following</h4>
            <?php echo $following_list ?>
        </div>

        <div style="border-style: solid; border-width: 2px; height: 600px; width: 200px; float: left; margin-right: 5px;">
            <h4 style="text-align: center;">Followers</h4>
            <?php echo $followers_list ?>
        </div>
        <div style="margin-left: 5px; float: left;">
            <h4>Post Text: </h4>
            <form method="post" id="post-message">
                <textarea id="post-message-text" style="width: 300px; height: 100px;"></textarea>
                </br>
                <input type="submit"></input>
            </form>
        </div>

        <div style="border-style: solid; border-width: 2px; height: 600px; width: 450px; float: left; text-align: center; margin-left: 5px;">
            <h4>Messages</h4>
            <?php echo $messages_list ?>
        </div>
    <script type="text/javascript">
        $('#post-message').submit(function (event) {
            event.preventDefault();
            var text = $('#post-message-text').val();
            $.post('postMessage.php', {"message": text}, function(){
                console.log();
            });
        });
    </script>
    </body>
</html>
