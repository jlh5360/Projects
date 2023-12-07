<?php
$page = "Command 'ls' Quiz";
$css = 'index_styles.css';
// $css = 'subpage.css';
$script = '';
include 'assets/inc/header_&_nav.php';
?>
<script>
    function radio(q, a, b) {
        let question = document.getElementsByName(q);
        for (i = 0; i < question.length; i++) {
            if (question[i].checked) {
                if (question[i].id == a) {
                    question[i].parentElement.style.backgroundColor = "lightgreen";
                    document.getElementById(b).style.display = "none";
                } else {
                    question[i].parentElement.style.backgroundColor = "#ff726f";
                }
            }
        }
    }
</script>

<div id="quiz_content">
    <h1 id="quiz_header">Command 'ls' Quiz</h1>
    <h2>Question 1</h2>
    <p>What command is used to show information about files in a columnar format?</p>
    <form>
        <div id="a1">
            <label for="answer1">ls</label>
            <input type="radio" id="answer1" name="q1" /><br>
        </div>
        <div id="a2">
            <label for="answer2">ls -R</label>
            <input type="radio" id="answer2" name="q1" /><br>
        </div>
        <div id="a3">
            <label for="answer3">ls -a</label>
            <input type="radio" id="answer3" name="q1" /><br>
        </div>
        <div id="a4">
            <label for="answer4">ls -al</label>
            <input type="radio" id="answer4" name="q1" /><br>
        </div>
        <input type="button" value="Submit" id="q1b" onclick="radio('q1', 'answer4', 'q1b')">
    </form>

    <h2>Question 2</h2>
    <p>What command is used to list all items (including hidden items) within a directory?</p>
    <form>
        <div id="a1">
            <label for="answer1">ls</label>
            <input type="radio" id="answer1" name="q2" /><br>
        </div>
        <div id="a2">
            <label for="answer2">ls -R</label>
            <input type="radio" id="answer2" name="q2" /><br>
        </div>
        <div id="a3">
            <label for="answer3">ls -a</label>
            <input type="radio" id="answer3" name="q2" /><br>
        </div>
        <div id="a4">
            <label for="answer4">ls -al</label>
            <input type="radio" id="answer4" name="q2" /><br>
        </div>
        <input type="button" value="Submit" id="q2b" onclick="radio('q2', 'answer3', 'q2b')">
    </form>

    <h2>Question 3</h2>
    <p>What command will list all the files and directories in your current directory?</p>
    <form>
        <div id="a1">
            <label for="answer1">ls</label>
            <input type="radio" id="answer1" name="q3" /><br>
        </div>
        <div id="a2">
            <label for="answer2">ls -R</label>
            <input type="radio" id="answer2" name="q3" /><br>
        </div>
        <div id="a3">
            <label for="answer3">ls -a</label>
            <input type="radio" id="answer3" name="q3" /><br>
        </div>
        <div id="a4">
            <label for="answer4">ls -al</label>
            <input type="radio" id="answer4" name="q3" /><br>
        </div>
        <input type="button" value="Submit" id="q3b" onclick="radio('q3', 'answer1', 'q3b')">
    </form>

    <h2>Question 4</h2>
    <p>What command shows all the files in both directories and subdirectories?</p>
    <form>
        <div id="a1">
            <label for="answer1">ls</label>
            <input type="radio" id="answer1" name="q4" /><br>
        </div>
        <div id="a2">
            <label for="answer2">ls -R</label>
            <input type="radio" id="answer2" name="q4" /><br>
        </div>
        <div id="a3">
            <label for="answer3">ls -a</label>
            <input type="radio" id="answer3" name="q4" /><br>
        </div>
        <div id="a4">
            <label for="answer4">ls -al</label>
            <input type="radio" id="answer4" name="q4" /><br>
        </div>
        <input type="button" value="Submit" id="q4b" onclick="radio('q4', 'answer2', 'q4b')">
    </form>
</div>

<?php
include 'assets/inc/footer.php';
?>