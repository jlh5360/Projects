function validateForm() {
    let name = document.forms["finalProjectCommentsForm"]["name"].value;
    let response = document.forms["finalProjectCommentsForm"]["response"].value;
    // let comment = document.forms["finalProjectForm"]["comment"].value;

    let fname = document.forms["finalProjectContactForm"]["fname"].value;
    let lname = document.forms["finalProjectContactForm"]["lname"].value;
    let email = document.forms["finalProjectContactForm"]["email"].value;

    if (name == "") {
        alert("Name must be filled out");
        return false;
    }
    else if (response == "") {
        alert("Response must be filled out");
        return false;
    }
    // else if (comment == "") {
    //     alert("Comment must be filled out");
    //     return false;
    // }
    else if (fname == "") {
        alert("First Name must be filled out");
        return false;
    }
    else if (lname == "") {
        alert("Last Name must be filled out");
        return false;
    }
    else if (email == "") {
        alert("Email must be filled out");
        return false;
    }
}


//Get the button
var mybutton = document.getElementById("myBtn");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function () {
    scrollFunction()
};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        mybutton.style.display = "block";
    } else {
        mybutton.style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}


function darkModeFunction() {
    var element = document.body;
    element.classList.toggle("dark-mode");
 }