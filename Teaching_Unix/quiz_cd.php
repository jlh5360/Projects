<?php
    $page = "Command 'cd' Quiz";
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
    <h1 id="quiz_header">Command 'cd' Quiz</h1>
    <h2>Question 1</h2>
    <p>What is the cd command used for?</p>
    <form>
        <div id="a1">
            <label for="answer1">Changing the permissions of a directory</label>
            <input type="radio" id="answer1" name="q1"/><br>
        </div>
        <div id="a2">
            <label for="answer2">Changing the name of a directory</label>
            <input type="radio" id="answer2" name="q1"/><br>
        </div>
        <div id="a3">
            <label for="answer3">Creating a new directory</label>
            <input type="radio" id="answer3" name="q1"/><br>
        </div>
        <div id="a4">
            <label for="answer4">Changing the current working directory</label>
            <input type="radio" id="answer4" name="q1"/><br>
        </div>
        <input type="button" value="Submit" id="q1b" onclick="radio('q1', 'answer4', 'q1b')">
    </form>

    <h2>Question 2</h2>
    <p>Typing “cd” will tell you the directory you are currently in.</p>
    <form>
        <div id="a1">
            <label for="answer1">True</label>
            <input type="radio" id="answer1" name="q2"/><br>
        </div>
        <div id="a2">
            <label for="answer2">False </label>
            <input type="radio" id="answer2" name="q2"/><br>
        </div>
        <input type="button" value="Submit" id="q2b" onclick="radio('q2', 'answer2', 'q2b')">
    </form>
</div>

<br>
<?php
    include 'assets/inc/footer.php';
?>