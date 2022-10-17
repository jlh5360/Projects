<?php
    $title = 'Submission Form';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '../landmarks/';
    $path_colleges = '../colleges/';
    $path_about = '';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'comments_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="about.php" class="breadcrumbs_link">About</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="comments.php" class="breadcrumbs_link" id="breadcrumbs_link_active">Submission Form</a>
                        </li>
                    </ul>';
    $heading_title = 'Submission Form';
    include '../assets/inc/header_&_nav.php';
    

    /*
        Connect to the database.
    */

    include "../../../../dbConn.php";
        if ($mysqli) {
            //IF we are adding a new user
            if (!empty($_POST['name']) && !empty($_POST['response']) && !empty($_POST['comment'])) {
                /*
                    We are using client entered data - therefore we HAVE TO USE a prepared statement
                    1)  Prepare my query
                    2)  Bind
                    3)  Execute
                    4)  Close
                */
                
                $stmt=$mysqli->prepare("insert into final_project_comments (name, response, comment, last_modified) values (?, ?, ?, NOW())");
                $stmt->bind_param("sss",$_POST['name'],$_POST['response'],$_POST['comment']);
                $stmt->execute();
                $stmt->close();

                // header("Location: comments.php");
                // exit;
            }
            //Get contents of table and send back...
            $res=$mysqli->query('select name, response, comment, last_modified from final_project_comments');
            if ($res) {
                while ($rowHolder = mysqli_fetch_array($res,MYSQLI_ASSOC)) {
                    $records[] = $rowHolder;
                }
            }
        }
?>

        <div id="content">
            <h3>What do you have to say?</h3>
            <form action="comments.php" method="post" onsubmit="return validateForm()" name="finalProjectCommentsForm">
                First Name: <input type="text" id="name" name="name"><br><br>
                
                <div id="response" name="response">
                    <label>Did/Will you visit New York City?  For what/When?</label><br>
                    <textarea id="response" name="response" rows="3" cols="40" placeholder=""></textarea><br><br>
                </div><br>
                
                <textarea id="comment" name="comment" rows="2" cols="24" placeholder="Any other comments?"></textarea><br><br>
                <input type="submit" value="Submit">
                <button onclick='window.location.reload(true)';>Refresh Page</button>
            </form><br>

            <hr>

            <h3>Previous Submissions</h3>
            <div id="list">
                <?php
                    //Will use for output
                    $result = $mysqli->query("select * from final_project_comments");
                    if ($result) {
                        while ($row = $result->fetch_assoc()) {
                            if ($row['comment'] == "") {
                                echo ('<p><a style="color: green">'.$row['name'] . ":</a>  " . $row['response'] . " @ " . $row['last_modified'].'</p>');
                            }
                            else {
                                echo ('<p><a style="color: green">'.$row['name'] . ":</a>  " . $row['response'] . " | " . $row['comment'] . " @ " . $row['last_modified'].'</p>');
                            }

                            // echo ('<p><a style="color: green">'.$row['name'] . ":</a>  " . $row['response'] . " | " . $row['comment'] . " @ " . $row['last_modified'].'</p>');
                        }
                    }
                ?>
            </div>
        </div>

        <script>
            if (window.history.replaceState) {
                window.history.replaceState(null, null, window.location.href);
            }
        </script>

<?php
    include '../assets/inc/footer.php';
?>