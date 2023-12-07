<?php
    $page = "Modifying Files Quiz";
    $css = 'index_styles.css';
    // $css = 'subpage.css';
    $script = '';
    include 'assets/inc/header_&_nav.php';
?>
<script>
    function radio(q, a, b){
        let question = document.getElementsByName(q);
        for(i=0; i<question.length;i++){
            if(question[i].checked){
                if(question[i].id == a){
                    question[i].parentElement.style.backgroundColor = "lightgreen";
                    document.getElementById(b).style.display = "none";
                } else{
                    question[i].parentElement.style.backgroundColor = "#ff726f";
                }
            }
        }
    }
</script>

<div id="quiz_content">
    <h1 id="quiz_header">Modifying Files Quiz</h1>
    <h2>Question 1</h2>
    <p>What is the correct format for the cp command?</p>
    <form>
        <div id="a1">
            <label for="answer1">cp source destination</label>
            <input type="radio" id="answer1" name="q1"/><br>
        </div>
        <div id="a2">
            <label for="answer2">cp source-destination</label>
            <input type="radio" id="answer2" name="q1"/><br>
        </div>
        <div id="a3">
            <label for="answer3">cp source</label>
            <input type="radio" id="answer3" name="q1"/><br>
        </div>
        <div id="a4">
            <label for="answer4">source sp destination</label>
            <input type="radio" id="answer4" name="q1"/><br>
        </div>
        <input type="button" value="Submit" id="q1b" onclick="radio('q1', 'answer1', 'q1b')">
    </form>

    <h2>Question 2</h2>
    <p>It is possible to copy multiple sources in one destination.</p>
    <form>
        <div id="a1">
            <label for="answer1">True</label>
            <input type="radio" id="answer1" name="q2"/><br>
        </div>
        <div id="a2">
            <label for="answer2">False </label>
            <input type="radio" id="answer2" name="q2"/><br>
        </div>
        <input type="button" value="Submit" id="q2b" onclick="radio('q2', 'answer1', 'q2b')">
    </form>

    <h2>Question 3</h2>
    <p>What permissions are required when using the cp command?</p>
    <form>
        <div id="a1">
            <label for="answer1">The source and destination both need all permissions on</label>
            <input type="radio" id="answer1" name="q3"/><br>
        </div>
        <div id="a2">
            <label for="answer2">Permissions do not matter when using the cp command</label>
            <input type="radio" id="answer2" name="q3"/><br>
        </div>
        <div id="a3">
            <label for="answer3">There must be read permissions on the source, and write permissions on the destination</label>
            <input type="radio" id="answer3" name="q3"/><br>
        </div>
        <div id="a4">
            <label for="answer4">The source does not need specific permissions, but the destination must have execute permissions on</label>
            <input type="radio" id="answer4" name="q3"/><br>
        </div>
        <input type="button" value="Submit" id="q3b" onclick="radio('q3', 'answer3', 'q3b')">
    </form>
</div>

<?php
    include 'assets/inc/footer.php';
?>