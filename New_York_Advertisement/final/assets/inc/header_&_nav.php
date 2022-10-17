<!-- Name:  Jonathan Ho -->
<!-- Date:  June 22, 2022 (6/22/2022) -->
<!-- ISTE 240 - Final Project  -->


<!DOCTYPE html>
<html lang="en">
    <head>
        <title><?php echo $title;?></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<?php echo $path;?>assets/css/general_styles.css">
        <link rel="stylesheet" href="<?php echo $path;?>assets/css/<?php echo $general_css;?>">
        <link rel="stylesheet" href="<?php echo $path;?>assets/css/<?php echo $personal_css;?>">
        <!-- <script type="text/javascript" src="<?php echo $path;?>assets/js/final.js"></script> -->
        <script type="text/javascript" src="<?php echo $path;?>assets/js/<?php echo $script;?>"></script>
    </head>
    <body>
        <!-- Logo and navigation bar -->
        <div id="navigation_bar">
            <nav>
                <img src="<?php echo $path;?>assets/media/custom_new_york_graphic.png" width="120" height="100" alt="New York graphic logo" id="logo">

                <ul>
                    <li><a href="<?php echo $path_index?>index.php" id="home_choice">Home</a></li>
                    
                    <div id="landmarks" class="tag">
                        <li><a href="<?php echo $path_landmarks;?>landmarks.php" id="landmarks_choice">Landmarks</a></li>
                        <div class="options">
                            <li><a href="<?php echo $path_landmarks;?>statue_of_liberty.php" id="landmarks_1">Statue of Liberty</a></li>
                            <li><a href="<?php echo $path_landmarks;?>time_square.php" id="landmarks_2">Time Square</a></li>
                            <li><a href="<?php echo $path_landmarks;?>empire_state_building.php" id="landmarks_3">Empire State Building</a></li>
                            <li><a href="<?php echo $path_landmarks;?>the_national_september_11_memorial_museum.php" id="landmarks_4">The National September 11 Memorial Museum</a></li>
                        </div>
                    </div>
                    
                    <div id="colleges" class="tag">
                        <li><a href="<?php echo $path_colleges;?>colleges.php" id="colleges_choice">Colleges</a></li>
                        <div class="options">
                            <li><a href="<?php echo $path_colleges;?>new_york_university.php" id="colleges_1">New York University</a></li>
                            <li><a href="<?php echo $path_colleges;?>columbia_university.php" id="colleges_2">Columbia University</a></li>
                            <li><a href="<?php echo $path_colleges;?>fordham_university.php" id="colleges_3">Fordham University</a></li>
                            <li><a href="<?php echo $path_colleges;?>yeshiva_university.php" id="colleges_4">Yeshiva Univeristy</a></li>
                        </div>
                    </div>

                    <div id="about" class="tag">
                        <li><a href="<?php echo $path_about;?>about.php" id="about_choice">About</a></li>
                        <div class="options">
                            <li><a href="<?php echo $path_about;?>comments.php" id="about_1">Submission Form</a></li>
                            <li><a href="<?php echo $path_about;?>grading.php" id="about_2">Grading</a></li>
                            <li><a href="<?php echo $path_about;?>references.php" id="about_3">References</a></li>
                            <li><a href="<?php echo $path_about;?>contact.php" id="about_4">Contact Form</a></li>
                            <li><a href="<?php echo $path_about;?>validators.php" id="about_5">Validators</a></li>
                        </div>
                    </div>
                </ul>
            </nav>
        </div>

        <div id="breadcrumb_bar"><?php echo $breadcrumbs;?></div>

        <!-- Heading -->
        <div id="heading">
            <div class="line"></div>
            <h2 id="heading_title"><?php echo $heading_title;?></h2>
            <div class="line"></div>
        </div>