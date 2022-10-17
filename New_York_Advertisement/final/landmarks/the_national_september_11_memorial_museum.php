<?php
    $title = 'The National September 11 Memorial Museum';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '';
    $path_colleges = '../colleges/';
    $path_about = '../about/';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'the_national_september_11_memorial_museum_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="landmarks.php" class="breadcrumbs_link">Landmarks</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="the_national_september_11_memorial_museum.php" class="breadcrumbs_link" id="breadcrumbs_link_active">The National September 11 Memorial Museum</a>
                        </li>
                    </ul>';
    $heading_title = 'The National September 11 Memorial Museum';
    include '../assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <img src="../assets/media/landmarks/the_national_september_11_memorial_museum.jpg" width="800" height="700" alt="The National September 11 Memorial Museum image" id="the_national_september_11_memorial_museum_image">

            <div id="section_1">
                <div id="history">
                    <h3>History</h3>
                    <p>
                        The National September 11 Memorial Museum is a museum for visitors to learn about the history of the tragedy of 
                        September 11, also known as 9/11, from the terrorist attack and the 1993 World Trade Center bombing at where the 
                        Twin Towers once stood before being destroyed from the terrorist attacks which took too many lives.  The museum 
                        educates and informs the visitors with exhibits and stories of the attacks, the aftermath, and the people who 
                        experienced these events.  Additionally, there is the 9/11 Memorial tributing the remembrance and honoring the 
                        2,977 people killed by having their names inscribed into the Memorial’s bronze parapets.
                    </p>
                </div>

                <div id="section_2">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3024.299690945002!2d-74.01696327165622!3d40.71141867949388!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c25a1b6d68f149%3A0xe89c6b40ebde4e7c!2sThe%20National%20September%2011%20Memorial%20Museum!5e0!3m2!1sen!2sus!4v1653988149188!5m2!1sen!2sus" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
            </div>
        </div>

<?php
    include '../assets/inc/footer.php';
?>