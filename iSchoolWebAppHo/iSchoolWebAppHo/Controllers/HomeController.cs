using iSchoolWebAppHo.Models;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using iSchoolWebAppHo.Services;
using Newtonsoft.Json;
using System.Dynamic;

namespace iSchoolWebAppHo.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        //Action method for rendering the index page
        public IActionResult Index()
        {
            return View();
        }

        //Action method for rendering the About page
        public async Task<IActionResult> About()
        {
            /*
             * go get the data...
             * put the data in the model
             * send the result to the view
             */
            //Fetch data about the iSchool
            DataRetrieval dr = new DataRetrieval();
            var loadedAbout = await dr.GetData("about/");

            //We now have a string!  Need to cast it to JSON
            //Deserialize the JSON data into AboutModel
            var rtnResult = JsonConvert.DeserializeObject<AboutModel>(loadedAbout);
            //Add in our pageTitle
            rtnResult.pageTitle = "About Our iSchool";

            //Send the data to the view
            return View(rtnResult);
        }

        //Action method for rendering the Degrees page
        public async Task<IActionResult> Degrees()
        {
            /*
             * go get the data...
             * put the data in the model
             * send the result to the view
             */
            //Fetch data about iSchool degrees
            DataRetrieval dr = new DataRetrieval();
            var loadedDegrees = await dr.GetData("degrees/");

            //We now have a string!  Need to cast it to JSON
            //Deserialize the JSON data into DegreesModel
            var jsonResult = JsonConvert.DeserializeObject<DegreesModel>(loadedDegrees);
            //Add in our pageTitle
            jsonResult.pageTitle = "Our iSchool Degrees";

            //Send the data to the view
            return View(jsonResult);
        }

        //Action method for rendering the Minors page
        public async Task<IActionResult> Minors()
        {
            //Load the data...
            //Fetch data about iSchool minors
            DataRetrieval dataR = new DataRetrieval();
            //Tell the instance to go get the data...
            var loadedMinors = await dataR.GetData("minors/");
            //Cast it to JSON and the object we want
            //Deserialize the JSON data into MinorsModel
            var rtnResults = JsonConvert.DeserializeObject<MinorsModel>(loadedMinors);

            //Second get
            //Fetch data about iSchool courses
            var loadedCourses = await dataR.GetData("course/");
            var coursesRtnResult = JsonConvert.DeserializeObject<List<CourseModel>>(loadedCourses);

            //Using System.dynamic;
            //Create an ExpandoObject to combine data
            dynamic expando = new ExpandoObject();
            var comboModel = expando as IDictionary<string, object>;

            //Add data to the combined model
            comboModel.Add("Minors", rtnResults);
            comboModel.Add("Course", coursesRtnResult);
            comboModel.Add("pageTitle", "Our iSchool Minors");

            //Send the data to the view
            return View(comboModel);
        }

        //Action method for rendering the People page
        public async Task<IActionResult> People()
        {
            /*
             * go get the data...
             * put the data in the model
             * send the result to the view
             */
            //Fetch data about iSchool people (faculty & staff)
            DataRetrieval dr = new DataRetrieval();
            var loadedPeople = await dr.GetData("people/");

            //We now have a string!  Need to cast it to JSON
            //Deserialize the JSON data into PeopleModel
            var jsonResult = JsonConvert.DeserializeObject<PeopleModel>(loadedPeople);
            //Add in our pageTitle
            jsonResult.pageTitle = "Our iSchool Faculty & Staff";

            //Send the data to the view
            return View(jsonResult);
        }

        //Action method for rendering the Employment page
        public async Task<IActionResult> Employment()
        {
            /*
             * go get the data...
             * put the data in the model
             * send the result to the view
             */
            //Fetch data about iSchool employment
            DataRetrieval dr = new DataRetrieval();
            var loadedEmployment = await dr.GetData("employment/");

            //We now have a string!  Need to cast it to JSON
            //Deserialize the JSON data into EmploymentModel
            var jsonResult = JsonConvert.DeserializeObject<EmploymentModel>(loadedEmployment);
            //Add in our pageTitle
            jsonResult.pageTitle = "Our iSchool Employment";

            //Send the data to the view
            return View(jsonResult);
        }

        //Action method for testing dynamic objects
        public async Task<IActionResult> DynTest()
        {
            //Load the data...
            //Fetch data about the iSchool
            DataRetrieval dataR = new DataRetrieval();
            //Tell the instance to go get the data...
            var loadedAbout = await dataR.GetData("about/");
            //Cast it to JSON and the object we want
            //Deserialize the JSON data into AboutModel
            var rtnResults = JsonConvert.DeserializeObject<AboutModel>(loadedAbout);

            //Second get
            //Fetch data about a specific course
            var loadedCourse = await dataR.GetData("course/courseID=ISTE-340");
            var courseRtnResult = JsonConvert.DeserializeObject<CourseModel>(loadedCourse);

            //Using System.dynamic;
            //Create an ExpandoObject to combine data
            dynamic expando = new ExpandoObject();
            var comboModel = expando as IDictionary<string, object>;

            //Add data to the combined model
            comboModel.Add("About", rtnResults);
            comboModel.Add("Course", courseRtnResult);
            comboModel.Add("pageTitle", "Test with a Dynamic Object");

            //Send the data to the view
            return View(comboModel);
        }

        //Error handling action method
        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
