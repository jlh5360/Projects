<?php
$page = 'Getting Started';
$css = 'getting_started_styles.css';
$script = 'totop.js';
include 'assets/inc/header_&_nav.php';
?>

<div id="content">

    <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>

    <div id="section1">
        <h1>Getting Started</h1>
        <p>
            Welcome to the first part of your journey to learning Unix. Here you will learn all the
            things you need to know before starting with commands. The topics will include an
            explanation of what Unix is, why we are using it, an introduction to file structure, and
            what the terminal is.
        </p><br><br>
    </div>

    <h2>What is Unix</h2>
    <p>
        Unix is a computer operating system that can handle activities from multiple users at the
        same time. Multitasking can be done by a user. Unix is also the first operating system to
        be written in a higher-level language (C Language). Being written in C allowed the
        operating system to be ported to other machines with minimal adaptations.
    </p>

    <h3>Why use Unix?</h3>
    <p>
        Unix is designed to share! In web development, you usually work in groups and need
        to share information easily with your peers. It is easy to install and more than one
        person can log in at a time to do work. Unix is also more secure than other operating
        systems. This is because you can control all processes in Unix.
    </p><br>
</div>

<?php
include 'assets/inc/footer.php';
?>