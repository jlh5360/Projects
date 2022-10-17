<?php
    $title = 'New York City Colleges';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '../landmarks/';
    $path_colleges = '';
    $path_about = '../about/';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'colleges_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="colleges.php" class="breadcrumbs_link" id="breadcrumbs_link_active">Colleges</a>
                        </li>
                    </ul>';
    $heading_title = 'New York City Colleges';
    include '../assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <div id="top_section">
                <p>
                    New York consists of many well known great colleges.  Colleges in New York are diverse and welcome many 
                    people from different backgrounds, and their well loved, compassionate communities of students become 
                    successful in their studies and professions.  Here are a few of these colleges located in New York City:
                </p>

                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d387193.305935303!2d-74.25986548248684!3d40.69714941932609!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c24fa5d33f083b%3A0xc80b8f06e177fe62!2sNew%20York%2C%20NY!5e0!3m2!1sen!2sus!4v1653881720340!5m2!1sen!2sus" width="1200" height="600" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>

            <div id="bottom_section">
                <h3><a href="new_york_university.php" class="list" id="list_choice_1">New York University</a></h3>
                <img src="../assets/media/colleges/new_york_university_logo.png" width="500" height="500" alt="New York University logo" id="new_york_university_logo">

                <h3><a href="columbia_university.php" class="list" id="list_choice_2">Columbia University</a></h3>
                <img src="../assets/media/colleges/columbia_university_logo.jpg" width="800" height="400" alt="Columbia University logo" id="columbia_university_logo">

                <h3><a href="fordham_university.php" class="list" id="list_choice_3">Fordham University</a></h3>
                <img src="../assets/media/colleges/fordham_university_seal.jpg" width="800" height="400" alt="Fordham University seal" id="fordham_university_seal">

                <h3><a href="yeshiva_university.php" class="list" id="list_choice_4">Yeshiva University</a></h3>
                <img src="../assets/media/colleges/yeshiva_university_logo.jpg" width="800" height="350" alt="Yeshiva University logo" id="yeshiva_university_logo">
            </div>
        </div>

<?php
    include '../assets/inc/footer.php';
?>