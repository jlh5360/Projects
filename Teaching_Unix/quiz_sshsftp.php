<?php
    $page = 'SSH/SFTP Quiz';
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
    <h1 id="quiz_header">SSH/SFTP Quiz</h1>
    <h2>Question 1</h2>
    <p>What does SFTP stand for?</p>
    <form>
        <div id="a1">
            <label for="answer1">Standard File Transfer Path</label>
            <input type="radio" id="answer1" name="q1"/><br>
        </div>
        <div id="a2">
            <label for="answer2">Secure Folder Transferring Protocol</label>
            <input type="radio" id="answer2" name="q1"/><br>
        </div>
        <div id="a3">
            <label for="answer3">Secure File Transfer Protocol</label>
            <input type="radio" id="answer3" name="q1"/><br>
        </div>
        <div id="a4">
            <label for="answer4">Secured File Transferring Path</label>
            <input type="radio" id="answer4" name="q1"/><br>
        </div>
        <input type="button" value="Submit" id="q1b" onclick="radio('q1', 'answer3', 'q1b')">
    </form>

    <h2>Question 2</h2>
    <p>SSH provides a secure way to access a computer over an unsecured network.</p>
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
    <p>Which is <strong>NOT</strong> true about SSH?</p>
    <form>
        <div id="a1">
            <label for="answer1">SSH enables a secure remote connection between two systems</label>
            <input type="radio" id="answer1" name="q3"/><br>
        </div>
        <div id="a2">
            <label for="answer2">SFTP is a part of SSH</label>
            <input type="radio" id="answer2" name="q3"/><br>
        </div>
        <div id="a3">
            <label for="answer3">SSH protocol works in the client-server model</label>
            <input type="radio" id="answer3" name="q3"/><br>
        </div>
        <div id="a4">
            <label for="answer4">The SSH server uses a public key cryptography to verify the identity of the SSH client</label>
            <input type="radio" id="answer4" name="q3"/><br>
        </div>
        <input type="button" value="Submit" id="q3b" onclick="radio('q3', 'answer4', 'q3b')">
    </form>

    <h2>Question 4</h2>
    <p>What is an advantage of using a key-based authentication system?</p>
    <form>
        <div id="a1">
            <label for="answer1">The user has a very complicated password that is hard to remember and difficult to guess</label>
            <input type="radio" id="answer1" name="q4"/><br>
        </div>
        <div id="a2">
            <label for="answer2">Keys add another layer of safety by using an asymmetric encryption algorithm</label>
            <input type="radio" id="answer2" name="q4"/><br>
        </div>
        <div id="a3">
            <label for="answer3">Many users can have the same key</label>
            <input type="radio" id="answer3" name="q4"/><br>
        </div>
        <div id="a4">
            <label for="answer4">There are no advantages to using a key-based authentication system</label>
            <input type="radio" id="answer4" name="q4"/><br>
        </div>
        <input type="button" value="Submit" id="q4b" onclick="radio('q4', 'answer2', 'q4b')">
    </form>

    <h2>Question 5</h2>
    <p>Ports make it difficult for computers to differentiate between different kinds of traffic.</p>
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

<?php
    include 'assets/inc/footer.php';
?>