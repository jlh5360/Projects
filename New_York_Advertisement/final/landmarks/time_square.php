<?php
    $title = 'Time Square';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '';
    $path_colleges = '../colleges/';
    $path_about = '../about/';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'time_square_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="landmarks.php" class="breadcrumbs_link">Landmarks</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="time_square.php" class="breadcrumbs_link" id="breadcrumbs_link_active">Time Square</a>
                        </li>
                    </ul>';
    $heading_title = 'Time Square';
    include '../assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <img src="../assets/media/landmarks/time_square.jpg" width="800" height="700" alt="Time Square image" id="time_square_image">

            <div id="section_1">
                <div id="history">
                    <h3>History</h3>
                    <p>
                        Time Square is the square in Midtown Manhattan, New York City, and formed by the intersection of Seventh Avenue, 
                        42nd Street, and Broadway.  It was originally known as Long Acre (also Longacre) Square after London’s carriage 
                        district.  Time Square served as the early side for William H. Vanderbilt’s American Horse Exchange.  Currently, 
                        Time Square is the liveliest area in New York City due to numerous neon lights and billboards.  Time Square is 
                        the center of the Theater District, and is surrounded by many restaurants, theaters, and museums.
                    </p>
                </div>
                
                <div id="section_2">
                    <div id="suggested_activities">  
                        <h3>Suggested Activities</h3>
                        <ul id="list">
                            <li>Watch a Broadway show</li>
                            <li>Eat at City Kitchen located in the Row Hotel in the heart of Time Square</li>
                            <li>Checking the main attractions on a bus tour</li>
                            <li>Participate in New York City’s escape room call The Escape Game</li>
                            <li>Attend the LoL Times Square Comedy Club</li>
                        </ul>
                    </div>

                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d387193.305935303!2d-74.25986548248684!3d40.69714941932609!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c24fa5d33f083b%3A0xc80b8f06e177fe62!2sNew%20York%2C%20NY!5e0!3m2!1sen!2sus!4v1653881720340!5m2!1sen!2sus" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
            </div>
        </div>

<?php
    include '../assets/inc/footer.php';
?>