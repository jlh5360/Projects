<?php
    $title = 'Grading';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '../landmarks/';
    $path_colleges = '../colleges/';
    $path_about = '';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'grading_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="about.php" class="breadcrumbs_link">About</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="grading.php" class="breadcrumbs_link" id="breadcrumbs_link_active">Grading</a>
                        </li>
                    </ul>';
    $heading_title = 'Grading';
    include '../assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <!-- <img src="../../../assets/media/midterm/new_york_city.jpg" width="1000" height="600" alt="New York City image" id="NYC"> -->

            <div id="section">
                <h3>At least 10 content pages</h3>
                <p>Home, Landmarks, Statue of Liberty, Time Square, Empire State Building, The National September 11 Memorial Museum, Colleges, New York University, Columbia University, Fordham University, Yeshiva University</p>
                
                <h3>Details</h3>
                <p>All information and images are cited in the references page under the about tab, and although I made the New York State graphic logo, I still stated that it was created by me.</p>
                
                <h3>Design</h3>
                <p>The pages about specific subjects of the city: Landmarks and Colleges.  While Landmarks is focused on: sightseeing, activities, and history, Colleges focus on the educational aspect of the city in the types of communities and the studies focused and taught at the colleges.</p>
                
                <h3>Browsers</h3>
                <p>The website is created on a laptop with the screen resolution being 3840 x 2160 pixels but can most definitely handle anything less than that as attempting to go on the website on a screen of 768 pixels or lower is adequate enough due to the website using media queries to accommodate smaller screens.</p>
                
                <h3>Graphical Design</h3>
                <p>All pages use the same styling format for and to have the same navigation bar; however, individual pages utilized their own specific stylesheets due to their specific id of elements and the various contents.</p>
                <p>The navigation bar is at a position fixed at the top of the screen so that it stays in place as the user scrolls down and can quickly use the navigation bar from any page and any position of the page to quickly go to any other page.</p>
                <p>All pages have titles and the users are able to either see the title no matter where they scroll to know where exactly they are on the website.</p>
                <p>Each page, other than the grading and references pages, have maps which by default show the location that the page is about, but they can still use it to find another location.</p>
                
                <h3>Content</h3>
                <p>Code is intended to make it more readable and appealing with CSS elements and selectors being grouped together. All pages are mostly valid and CSS is commented, structural elements are used for nav.</p>
                
                <h3>Code design</h3>
                <p>My Home page, Landmarks, and Colleges pages all have interactive maps and each individual location page has a map with the location marked on it.  The sources of the photos are in the References page with the title of the pages with embedded links of the website where the photoI used came from.</p>
                
                <h3>CRAP Principles</h3>
                <p>The colors used are not too similar to each other and all text is easy to read. All pages feel similar with the same navigation and font style/content amount on each page.  In addition, since all pages use the same or similar limited css rules, images, and text are aligned at specific locations. All text is kept close to other elements and when an element has to be moved away due to browser size constraints the map is always moved away.</p>
            </div>
        </div>

<?php
    include '../assets/inc/footer.php';
?>