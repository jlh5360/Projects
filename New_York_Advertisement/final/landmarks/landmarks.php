<?php
    $title = 'New York City Landmarks';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '';
    $path_colleges = '../colleges/';
    $path_about = '../about/';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'landmarks_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="landmarks.php" class="breadcrumbs_link" id="breadcrumbs_link_active">Landmarks</a>
                        </li>
                    </ul>';
    $heading_title = 'New York City Landmarks';
    include '../assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <div id="left_section">
                <h3 id="list_choice_1"><a href="statue_of_liberty.php" class="list">Statue of Liberty</a></h3>
                <img src="../assets/media/landmarks/the_statue_of_liberty.jpg" width="400" height="300" alt="Statue of Liberty image" id="statue_of_liberty_image">

                <h3 id="list_choice_2"><a href="time_square.php" class="list">Time Square</a></h3>
                <img src="../assets/media/landmarks/time_square.jpg" width="400" height="300" alt="Time Square image" id="time_square_image">

                <h3 id="list_choice_3"><a href="empire_state_building.php" class="list">Empire State Building</a></h3>
                <img src="../assets/media/landmarks/empire_state_building.jpg" width="400" height="300" alt="Empire State Building image" id="empire_state_building_image">

                <h3 id="list_choice_4"><a href="the_national_september_11_memorial_museum.php" class="list">The National September 11 Memorial Museum</a></h3>
                <img src="../assets/media/landmarks/the_national_september_11_memorial_museum.jpg" width="400" height="300" alt="The National September 11 Memorial Museum image" id="the_national_september_11_memorial_museum_image">
            </div>
            
            <div id="right_section">
                <p>
                    New York consists of many famous landmarks and attractions.  These landmarks are popular 
                    for locals and tourists who want to go on an adventure in New York city, sightseeing,  
                    taking pictures, have fun, and to learn more about the history in this city.  Here are a 
                    few of these famous landmarks located in the City:
                </p>

                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d387193.305935303!2d-74.25986548248684!3d40.69714941932609!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c24fa5d33f083b%3A0xc80b8f06e177fe62!2sNew%20York%2C%20NY!5e0!3m2!1sen!2sus!4v1653881720340!5m2!1sen!2sus" width="600" height="600" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
        </div>

<?php
    include '../assets/inc/footer.php';
?>