<?php
    $title = 'Yeshiva University';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '../landmarks/';
    $path_colleges = '';
    $path_about = '../about/';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'yeshiva_university_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="colleges.php" class="breadcrumbs_link">Colleges</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="yeshiva_university.php" class="breadcrumbs_link" id="breadcrumbs_link_active">Yeshiva University</a>
                        </li>
                    </ul>';
    $heading_title = 'Yeshiva University';
    include '../assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <img src="../assets/media/colleges/yeshiva_university.jpg" width="800" height="500" alt="Yeshiva University image" id="yeshiva_university">

            <div id="section_1">
                <h3 id="about_heading">About</h3>
                <p id="about_info">
                    Yeshiva University is composed of undergraduate schools that offer a unique dual curriculum incorporating 
                    business, liberal arts, Jewish studies, and various sciences courses.  Furthermore, the graduate and 
                    affiliate schools offer tremendous opportunities for graduate and professional studies that further dives 
                    into numerous science, health, law, and Jewish studies.
                </p>                
            </div>

            <div id="section_2">
                <div id="stats_1">
                    <h3>Rankings:</h3>
                    <ul>
                        <li>164th World University Rankings 2016</li>
                        <li>138th US College Rankings 2022</li>
                    </ul>
                </div>

                <div id="section_3">
                    <div id="stats_2">
                        <h3>Out-of-state Tuition & Fees:</h3>  <p>$44,900</p>
                        <h3>On-campus Room and Board:</h3>  <p>$12,500</p>
                        <h3>Salary after 10 years:</h3>  <p>$56,800</p>
                        <h3>4-year graduation rate:</h3>  <p>69%</p>
                        <h3>Student-faculty ratio:</h3>  <p>7:1</p>
                    </div>
    
                    <div id="section_4">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3018.0074065219446!2d-73.93167258476775!3d40.84976118711333!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c2f41bc904735b%3A0xb576bc6e742137fb!2sYeshiva%20University!5e0!3m2!1sen!2sus!4v1653993980431!5m2!1sen!2sus" width="600" height="470" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                </div>
            </div>
        </div>

<?php
    include '../assets/inc/footer.php';
?>