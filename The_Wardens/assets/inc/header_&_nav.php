<!DOCTYPE html>
<html lang="en">
    <head>
        <title><?php echo $page;?></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="assets/css/general_styles.css">
        <link rel="stylesheet" href="assets/css/<?php echo $css;?>">
        <script type="text/javascript" defer src="assets/js/<?php echo $script;?>"></script>

        <link rel="icon" type="image/x-icon" href="/assets/img/wardens_icon.ico">

        <style>
            @import url('https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@300&family=Roboto:wght@300&display=swap');
        </style>
    </head>
    <body>
        <nav id="nav_bar">
            <img src="assets/img/wardens_logo.png" id="logo" width="85" height="70" alt="Wardens logo">

            <ul>
                <hr id="horizontal_line_1">

                <li id="home"><a href="index.php">Home</a></li>
                
                <hr id="horizontal_line_2">

                <div class="tag">
                    <li id="getting_started" class="tag_option"><a href="getting_started.php">Getting Started</a></li>
                    <div class="options">
                        <!-- in the quotes (href) add link to the page on solace this added the "is current" color change in php -->
                        <li><a href="getting_started.php">What is Unix?</a></li>
                        <li><a href="filestructure.php">File Structure</a></li>
                        <li><a href="terminal.php">Terminal</a></li>
                        <li><a href="sshsftp.php">SSH and SFTP</a></li>
                    </div>
                </div>

                <hr id="horizontal_line_3">

                <div class="tag">
                    <li id="tutorials" class="tag_option">Tutorials</li>
                    <div class="options">
                        <li><a href="basic_commands.php">Basic</a></li>
                        <li><a href="permissions.php">Permissions</a></li>
                        
                    </div>
                </div>

                <hr id="horizontal_line_4">

                <div class="tag">
                    <li id="quizzes" class="tag_option">Quizzes</li>
                    <div class="options">
                        <li><a href="quiz_ls.php">ls</a></li>
                        <li><a href="quiz_cd.php">cd</a></li>
                        <li><a href="quiz_moddir.php">moddir</a></li>
                        <li><a href="quiz_modfiles.php">modfiles</a></li>
                        <li><a href="quiz_sshsftp.php">SSH & SFTP</a></li>
                    </div>
                </div>

                <hr id="horizontal_line_5">
                
                <li id="references" class="tag_option"><a href="references.php">References</a></li>

                <hr id="horizontal_line_6">
            </ul>
        </nav>