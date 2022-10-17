<?php
    $title = 'Statue of Liberty';
    $path = '../';
    $path_index = '../';
    $path_landmarks = '';
    $path_colleges = '../colleges/';
    $path_about = '../about/';
    $general_css = 'landmarks_&_colleges_&_about_styles.css';
    $personal_css = 'statue_of_liberty_styles.css';
    $script = 'final.js';
    $breadcrumbs = '<ul id="breadcrumbs">
                        <li class="breadcrumbs_item">
                            <a href="../index.php" class="breadcrumbs_link">Home</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="landmarks.php" class="breadcrumbs_link">Landmarks</a>
                        </li>
                        <li class="breadcrumbs_item">
                            <a href="statue_of_liberty.php" class="breadcrumbs_link" id="breadcrumbs_link_active">Statue of Liberty</a>
                        </li>
                    </ul>';
    $heading_title = 'Statue of Liberty';
    include '../assets/inc/header_&_nav.php';
?>

        <!-- Content -->
        <div id="content">
            <img src="../assets/media/landmarks/the_statue_of_liberty.jpg" width="800" height="700" alt="The Statue of Liberty image" id="the_statue_of_liberty_image">

            <div id="section_1">
                <div id="history">
                    <h3>History</h3>
                    <p>
                        Although the Statue of Liberty is located on Liberty Island in Upper New York Bay, which is off the coast of 
                        New York City, it was not built in New York, much less than in the United States.  In fact, under the direction 
                        of French sculptor Frédéric-Auguste Bartholdi and his team, the Statue of Liberty was built in France between 
                        1875 and 1884 and was then disassembled and shipped to New York City in 1885; the statue was reassembled on 
                        Liberty Island in 1886.  Due to the statute being situated near Ellis Island, where millions of immigrants were 
                        received until 1943, it stood to represent freedom, hope, and justice.  Fun fact, the Statue of Liberty was 
                        formally named or known as the Liberty Enlightening the World.
                    </p>
                </div>

                <div id="section_2">
                    <div id="suggested_activities">
                        <h3>Suggested Activities</h3>
                        <ul id="list">
                            <li>Statue of Liberty Exhibit</li>
                            <li>Video at the Visitor Information Station</li>
                            <li>Audio Tour of Liberty Island</li>
                            <li>The Torch Exhibit</li>
                            <li>Promenade and Observatory Tour</li>
                        </ul>
                    </div>

                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3025.3062027567944!2d-74.04668908477223!3d40.68925344694415!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c25090129c363d%3A0x40c6a5770d25022b!2sStatue%20of%20Liberty!5e0!3m2!1sen!2sus!4v1653985111677!5m2!1sen!2sus" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
            </div>
        </div>

<?php
    include '../assets/inc/footer.php';
?>