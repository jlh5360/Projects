<?php
    $title = 'Contact Form';
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
                            <a href="contact.php" class="breadcrumbs_link" id="breadcrumbs_link_active">Contact Form</a>
                        </li>
                    </ul>';
    $heading_title = 'Contact Form';
    include '../assets/inc/header_&_nav.php';


    /*
        Connect to the database.
    */

    include "../../../../dbConn.php";
        if ($mysqli) {
            //IF we are adding a new user
            if (!empty($_POST['fname']) && !empty($_POST['lname']) && !empty($_POST['email'])) {
                /*
                    We are using client entered data - therefore we HAVE TO USE a prepared statement
                    1)  Prepare my query
                    2)  Bind
                    3)  Execute
                    4)  Close
                */
                
                $stmt=$mysqli->prepare("insert into final_project_contact (fname, lname, email, last_modified) values (?, ?, ?, NOW())");
                $stmt->bind_param("sss",$_POST['fname'],$_POST['lname'],$_POST['email']);
                $stmt->execute();
                $stmt->close();

                // header("Location: contact.php");
                // exit;
            }
            //Get contents of table and send back...
            $res=$mysqli->query('select fname, lname, email, last_modified from final_project_contact');
            if ($res) {
                while ($rowHolder = mysqli_fetch_array($res,MYSQLI_ASSOC)) {
                    $records[] = $rowHolder;
                }
            }
        }
?>

        <div id="content">
            <h3>Fill in Your Information Below</h3>
            <form action="contact.php" method="post" onsubmit="return validateForm()" name="finalProjectContactForm">
                First Name: <input type="text" id="fname" name="fname"><br>
                Last Name: <input type="text" id="lname" name="lname"><br>
                Email Address: <input type="text" id="email" name="email"><br>

                <br><br>

                <input type="submit" value="Add to the List">
                <button onclick='window.location.reload(true)';>Refresh Page</button>
            </form><br>

            <hr>

            <h3>Submitted Forms</h3>
            <div id="list">
                <ul>
                    <?php
                        //Will use for output
                        $result = $mysqli->query("select * from final_project_contact");
                        if ($result) {
                            while ($row = $result->fetch_assoc()) {
                                echo ('<p><a style="color: green">'.$row['fname'] . "</a> " . $row['lname'] . " --> " . $row['email'] . " @ " . $row['last_modified'].'</p>');
                            }
                        }
                    ?>
                </ul>
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