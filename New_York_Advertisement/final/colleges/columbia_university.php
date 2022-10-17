<?php
    $title = 'Columbia University';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '../landmarks/';
    $path_colleges = '';
    $path_about = '../about/';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'columbia_university_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="colleges.php" class="breadcrumbs_link">Colleges</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="columbia_university.php" class="breadcrumbs_link" id="breadcrumbs_link_active">Columbia University</a>
                        </li>
                    </ul>';
    $heading_title = 'Columbia University';
    include '../assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <img src="../assets/media/colleges/columbia_university.jpg" width="1000" height="500" alt="Columbia University image" id="columbia_university">

            <div id="section_1">
                <h3 id="about_heading">About</h3>
                <p id="about_info">
                    Columbia University takes advantage of its location in New York City by linking its research and education to the 
                    vast resources of the metropolis.  This university seeks to attract diverse and international faculty and student 
                    body to help research and resolve global issues through its high academic levels and resources.
                </p>
            </div>

            <div id="section_2">
                <div id="stats_1">
                    <h3>Rankings:</h3>
                    <ul>
                        <li>11th World University Rankings 2022</li>
                        <li>16th US College Rankings 2022</li>
                        <li>12th World Reputation Rankings 2021</li>
                    </ul>
                
                    <div id="section_3">
                        <div id="stats_2">
                            <h3>Out-of-state Tuition & Fees:</h3>  <p>$60,578</p>
                            <h3>On-campus Room and Board:</h3>  <p>$14,490</p>
                            <h3>Salary after 10 years:</h3>  <p>$78,900</p>
                            <h3>4-year graduation rate:</h3>  <p>86%</p>
                            <h3>Student-faculty ratio:</h3>  <p>6:1</p>
                        </div>
                            
                        <div id="section_4">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3019.929656831299!2d-73.96476138476886!3d40.807539539702304!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c2f63e96d30dc9%3A0x577933f947e52750!2sColumbia%20University!5e0!3m2!1sen!2sus!4v1653991599883!5m2!1sen!2sus" width="600" height="470" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>

<?php
    include '../assets/inc/footer.php';
?>
