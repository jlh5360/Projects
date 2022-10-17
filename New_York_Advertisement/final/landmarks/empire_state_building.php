<?php
    $title = 'Empire State Building';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '';
    $path_colleges = '../colleges/';
    $path_about = '../about/';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'empire_state_building_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="landmarks.php" class="breadcrumbs_link">Landmarks</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="empire_state_building.php" class="breadcrumbs_link" id="breadcrumbs_link_active">Empire State Building</a>
                        </li>
                    </ul>';
    $heading_title = 'Empire State Building';
    include '../assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <img src="../assets/media/landmarks/empire_state_building.jpg" width="800" height="700" alt="Empire State Building image" id="empire_state_building_image">

            <div id="section_1">
                <div id="history">
                    <h3>History</h3>
                    <p>
                        The Empire State Building is a 102-story building that was designed by Shreve, Lamb & Harmon Associates and was 
                        completed in 1931.  It was officially built to host corporate business offices.  Less officially, the building 
                        was also built to be the tallest building in the world; in fact, the building has a height of 1,250 feet which 
                        equals to 381 meters.  In 1931, the building seized the title of being the highest structure in the world as it 
                        surpassed the height of the Chrysler Building, until the year 1954.  This building is located in Midtown 
                        Manhattan in New York City, New York, on Fifth Avenue at 34th Street.  The building got its name as it derives 
                        from a nickname for New York state.  The oldest documented source is a letter written by George Washington in 
                        1785; Washington’s letter expressed his admiration and appreciation for New York’s strength during the American 
                        Revolution and deems the state “the Seat of the Empire.”
                    </p>
                </div>
                
                <div id="section_2">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3022.183948656461!2d-73.98773128477025!3d40.75797874273867!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c25855c6480299%3A0x55194ec5a1ae072e!2sTimes%20Square!5e0!3m2!1sen!2sus!4v1653986851208!5m2!1sen!2sus" width="525" height="525" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
            </div>
        </div>

<?php
    include '../assets/inc/footer.php'
?>