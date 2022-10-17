<?php
    $title = 'About';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '../landmarks/';
    $path_colleges = '../colleges/';
    $path_about = '';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'about_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="about.php" class="breadcrumbs_link" id="breadcrumbs_link_active">About</a>
                        </li>
                    </ul>';
    $heading_title = 'About';
    include '../assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <div id="section">
                <div id="submission_form_group">
                    <h3><a href="comments.php" id="submission_form" class="about_option">Submission Form</a></h3>
                    <img src="../assets/media/about/submission_form_cartoon.jpg" width="600" height="600" alt="Submission form cartoon" id="submission_form_cartoon">
                </div><br><br>

                <div id="grading_group">
                    <h3><a href="grading.php" id="grading" class="about_option">Grading</a></h3>
                    <img src="../assets/media/about/grading_cartoon.png" width="500" height="500" alt="Grading cartoon" id="grading_cartoon">
                </div><br><br>
                

                <div id="references_group">
                    <h3><a href="references.php" id="references" class="about_option">References</a></h3>
                    <img src="../assets/media/about/references_cartoon.jpg" width="700" height="450" alt="References cartoon" id="references_cartoon">
                </div><br><br>

                <div id="contact_form_group">
                    <h3><a href="contact.php" id="contact_form" class="about_option">Contact Form</a></h3>
                    <img src="../assets/media/about/contact_form_cartoon.jpg" width="700" height="450" alt="Contact form cartoon" id="contact_form_cartoon">
                </div><br><br>

                <div id="validators_group">
                    <h3><a href="validators.php" id="validators" class="about_option">Validators</a></h3>
                    <img src="../assets/media/about/code_validator_cartoon.jpg" width="600" height="600" alt="Code validator cartoon" id="code_validator_cartoon">
                </div><br><br>

                <div id="javascript_group">
                    <p>
                        My JavaScript give funcitons such as when you click on the "Top" button 
                        on the bottom right of the screen, makes your screen go all the way to 
                        the top.  Additionally, on the bottom right of the screen there is a "D/L" 
                        button that changes the background of the screen to dark or light mode 
                        [depending on the mode you are currently in (it is in light mode by 
                        default)].  Furthermore, there is a validate form function to each the 
                        important/required user inputs the user must input, and stops the user from 
                        submitting by sending an alert message about a missing input.
                    </p>
                </div>

                <div id="DHTML_group">
                    <p>
                        My DTHML are using two JavaScript functions when clicking on (onclick="") a 
                        button.  I have a button, the "Top" button, on the bottom right of the 
                        screen, makes your screen go all the way to the top when clicked on.  
                        Additionally, on the bottom right of the screen there is a "D/L" 
                        button that when clicked on, it changes the background of the screen to dark 
                        or light mode [depending on the mode you are currently in (it is in light 
                        mode by default)].
                    </p>
                </div>
            </div>
        </div>

<?php
    include '../assets/inc/footer.php';
?>