﻿namespace iSchoolWebAppHo.Models
{
    // Root myDeserializedClass = JsonConvert.DeserializeObject<Root>(myJsonResponse);
    public class MinorsModel
    {
        public List<UgMinor> UgMinors { get; set; }

        //Our own piece of data
        public string pageTitle { get; set; }
    }

    public class UgMinor
    {
        public string name { get; set; }
        public string title { get; set; }
        public string description { get; set; }
        public List<string> courses { get; set; }
        public string note { get; set; }
    }
}
