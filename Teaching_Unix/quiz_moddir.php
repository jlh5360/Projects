<?php
    $page = "Modifying Directories Quiz";
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
    function checkbox(q, a, b, n){
                let options = document.getElementsByName(q);
                let sum = 0;
                for(i=0; i<options.length;i++){
                        if(options[i].parentElement.style.backgroundColor == "lightgreen"){
                            options[i].parentElement.style.backgroundColor = "white";
                        }
                    }
                for(i=0; i<options.length;i++){
                    if(options[i].checked){
                        for(j=0; j<a.length;j++){
                            if(options[i].id == a[j]){
                                options[i].parentElement.style.backgroundColor = "lightgreen";
                                sum += 1;
                            } else if(options[i].parentElement.style.backgroundColor != "lightgreen"){
                                options[i].parentElement.style.backgroundColor = "#ff726f";
                            }
                        }
                    }
                }
                if(sum >= parseInt(n)){
                    document.getElementById(b).style.display = "none";
                }
                sum = 0;
            }
</script>

<div id="quiz_content">
    <h1 id="quiz_header">Modifying Directories Quiz</h1>
    <h2>Question 1</h2>
    <p>What permissions are given to the owner in the numeric code 644?</p>
    <form>
        <div>
            <label for="perm1">Read </label>
            <input type="checkbox" id="perm1" name="q2"/><br>
        </div>
        <div>
            <label for="perm2">Write </label>
            <input type="checkbox" id="perm2" name="q2"/><br>
        </div>
        <div>
        <label for="perm3">Execute </label>
        <input type="checkbox" id="perm3" name="q2"/><br>
        </div>
            <input type="button" value="Submit" id="q2b" onclick="checkbox('q2', ['perm1', 'perm2'], 'q2b', '2')">
        </form>

    <h2>Question 2</h2>
    <p>What does the following command do? <br> <em>chmod u+x filename</em></p>
    <form>
        <div>
            <label for="answer1">Allows all users permission to execute the file</label>
            <input type="radio" id="answer1" name="q1"/><br>
        </div>
        <div>
            <label for="answer2">Gives the owner of the file permission to read, write, and execute it </label>
            <input type="radio" id="answer2" name="q1"/><br>
        </div>
        <div>
            <label for="answer3">Sets the file permission to read only for all users besides the owner</label>
            <input type="radio" id="answer3" name="q1"/><br>
        </div>
        <div>
            <label for="answer4">Adds the execute permission for the owner of the file</label>
            <input type="radio" id="answer4" name="q1"/><br>
        </div>
        <input type="button" value="Submit" id="q1b" onclick="radio('q1', 'answer4', 'q1b')">
    </form>

    <h2>Question 3</h2>
    <p>Directories with content in them can be deleted with the rmdir command</p>
    <form>
        <div>
            <label for="answer1">True</label>
            <input type="radio" id="answer1" name="q2"/><br>
        </div>
        <div>
            <label for="answer2">False </label>
            <input type="radio" id="answer2" name="q2"/><br>
        </div>
        <input type="button" value="Submit" id="q2b" onclick="radio('q2', 'answer2', 'q2b')">
    </form>

    <h2>Question 4</h2>
    <p>What numeric value is assigned to the “write” permission?</p>
    <form>
        <div>
            <label for="answer1">0</label>
            <input type="radio" id="answer1" name="q3"/><br>
        </div>
        <div>
            <label for="answer2">1 </label>
            <input type="radio" id="answer2" name="q3"/><br>
        </div>
        <div>
            <label for="answer3">2</label>
            <input type="radio" id="answer3" name="q3"/><br>
        </div>
        <div>
            <label for="answer4">4</label>
            <input type="radio" id="answer4" name="q3"/><br>
        </div>
        <input type="button" value="Submit" id="q3b" onclick="radio('q3', 'answer3', 'q3b')">
    </form>

    <h2>Question 5</h2>
    <p>What is the purpose of the command mkdir?</p>
    <form>
        <div>
            <label for="answer1">To create a new directory</label>
            <input type="radio" id="answer1" name="q4"/><br>
        </div>
        <div>
            <label for="answer2">To make changes to an existing directory </label>
            <input type="radio" id="answer2" name="q4"/><br>
        </div>
        <div>
            <label for="answer3">To rename a directory</label>
            <input type="radio" id="answer3" name="q4"/><br>
        </div>
        <div>
            <label for="answer4">To delete the content of a directory</label>
            <input type="radio" id="answer4" name="q4"/><br>
        </div>
        <input type="button" value="Submit" id="q4b" onclick="radio('q4', 'answer1', 'q4b')">
    </form>
</div>

<?php
    include 'assets/inc/footer.php';
?>