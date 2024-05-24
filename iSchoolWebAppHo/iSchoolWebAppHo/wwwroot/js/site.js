// Please see documentation at https://learn.microsoft.com/aspnet/core/client-side/bundling-and-minification
// for details on configuring this project to bundle and minify static web assets.

// Write your JavaScript code.

//Let's make sure the document is ready!
/*$(function () {*/
/* ================================================================================= */
/* CodePen jQuery - Scrolling Progress Bar from https://codepen.io/mgrech/pen/RMJgaM */
$(document).on("scroll", function () {
    var pixels = $(document).scrollTop();
    var pageHeight = $(document).height() - $(window).height();
    var progress = 100 * pixels / pageHeight;

    $("div.progress").css("width", progress + "%");
})
/* ================================================================================= */
$(document).ready(function () {
    //===================== DEGREES =====================
    $(".degreesAccordion").accordion({
        collapsible: true,
        heightStyle: "content",
        active: false,
    });

    //===================== MINORS =====================
    $(".minorsAccordion").accordion({
        collapsible: true,
        heightStyle: "content",
        active: false,
    });

    $(".dialog-course-button").click(function () {
        var courseID = $(this).attr("id");   //Get the courseID from the button ID
        //Show the course description in the corresponding div with ID as the "dialog-courseID""
        $("#dialog-" + courseID).dialog("open");
    });

    //===================== MINORS & PEOPLE =====================
    $(".dialog").dialog({
        autoOpen: false,
        show: {
            effect: "blind",
            /*duration: 1000   *//* 1 second */
            duration: 500   /* 0.5 second */
        },
        hide: {
            /*effect: "blind",*/
            /*effect: "explode",*/
            effect: "fade",
            /*duration: 1000   *//* 1 second */
            duration: 500   /* 0.5 second */
        }
    })

    //===================== PEOPLE =====================
    $("#peopleTabs").tabs();

    $(".dialog-people-button").click(function () {
        var peopleUsername = $(this).attr("id");   //Get the people username from the button ID
        //Show the people description in the corresponding div with ID as the "dialog-peopleUsername"
        $("#dialog-" + peopleUsername).dialog("open");
    });

    //===================== EMPLOYMENT =====================
    new DataTable('#coopTable');
    new DataTable('#employmentTable');

    //===================== GENERAL =====================
    //Now, turn it on...
    //Show the hidden content (fade-in effect)
    $("#hideMe").fadeIn(1200);
})