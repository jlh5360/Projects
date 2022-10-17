<?php
    $title = 'New York University';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '../landmarks/';
    $path_colleges = '';
    $path_about = '../about/';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'new_york_university_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="colleges.php" class="breadcrumbs_link">Colleges</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="new_york_university.php" class="breadcrumbs_link" id="breadcrumbs_link_active">New York University</a>
                        </li>
                    </ul>';
    $heading_title = 'New York University';
    include '../assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <img src="../assets/media/colleges/new_york_university.jpg" width="1000" height="350" alt="New York University image" id="new_york_university">

            <div id="section_1"></div>
                <h3 id="about_heading">About</h3>
                <p id="about_info">
                    Since NYU’s founding in 1831, it has been open and reaching out to the emerging middle class, all the while for students and people to reach and embrace professional focus 
                    and thinking.  This university has been the innovator in higher education, especially when it has been one of the most prominent and respected research universities and 
                    features top-ranked academic programs.  The diversity of NYU is especially grand as the students come from nearly every state and 133 countries, all the while the staff and 
                    faculty coming from diverse backgrounds to ensure the scholarship, teaching, and education benefits from a wide range of perspectives.  NYU provides a meticulous, demanding 
                    education to over 65,000 students and annually accepts $1 billion in research.  As a result, NYU has a vast network of alumni who have gone to succeed worldwide across 
                    various professions in: sciences, arts, and even the government.
                </p>
            </div>

            <div id="section_2">
                <div id="stats_1">
                    <h3>Rankings</h3>
                    <ul>
                        <li>26th World University Rankings 2022</li>
                        <li>26th US College Rankings 2022</li>
                        <li>201-300th Impact Rankings 2022</li>
                    </ul>

                    <div id="section_3">
                        <div id="stats_2">
                            <h3>Out-of-state Tuition & Fees:</h3>  <p>$53,308</p>
                            <h3>On-campus Room and Board:</h3>  <p>$18,684</p>
                            <h3>Salary after 10 years:</h3>  <p>$60,100</p>
                            <h3>4-year graduation rate:</h3>  <p>79%</p>
                            <h3>Student-faculty ratio:</h3>  <p>8:1</p>
                        </div>
    
                        <div id="section_4">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d24185.5663931836!2d-74.00525090213154!3d40.735716945466!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c2599af55395c1%3A0xda30743171b5f305!2sNew%20York%20University!5e0!3m2!1sen!2sus!4v1653953818130!5m2!1sen!2sus" width="600" height="470" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>

<?php
    include '../assets/inc/footer.php';
?>