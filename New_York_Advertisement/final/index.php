<?php
    $title = 'New York City Travel Guide';
    $path = '';
    $path_index = '';
    $path_landmarks = 'landmarks/';
    $path_colleges = 'colleges/';
    $path_about = 'about/';
    $general_css = '';
    $personal_css = 'index_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="index.php" class="breadcrumbs_link" id="breadcrumbs_link_active">Home</a>
                        </li>
                    </ul>';
    $heading_title = 'Come Vist New York City';
    include 'assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <img src="assets/media/new_york_city.jpg" width="1000" height="600" alt="New York City image" id="NYC">

            <div id="section">
                <p>
                    One of the most famous cities in the United States, New York City is covered in fascinating landmarks 
                    and buildings engraved with significant chronicles of the past.  Furthermore, New York City has a 
                    population of over 8 million people and it is one of the most diverse cities; due to the fact that in 
                    this city, there are more than 800 languages spoken and is the birthplace of rights for the LGBTQ+ 
                    community.  There are also numerous fantastic restaurants to dine down in.
                </p>

                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d387193.305935303!2d-74.25986548248684!3d40.69714941932609!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c24fa5d33f083b%3A0xc80b8f06e177fe62!2sNew%20York%2C%20NY!5e0!3m2!1sen!2sus!4v1653881720340!5m2!1sen!2sus" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
        </div>

<?php
    include 'assets/inc/footer.php';
?>