namespace iSchoolWebAppHo.Services
{
    public class DataRetrieval
    {
        //Build a method to go get my data from my api...
        //We are going to send in the endpoint of the url ("about/" or "people/"...)
        public async Task<string> GetData(string endpoint)
        {
            //Task vs Thread -
            //Task has async/await and a return value, can cancel a task
            //Thread - no direct way to return from a thread, threadcan do multiple things at once


            //using statement - at the end of it, it is automagically disposed...
            using (var client = new HttpClient())
            {
                //We need to set up our http client!
                //request/response
                client.BaseAddress = new Uri("https://ischool.gccis.rit.edu/api/");
                client.DefaultRequestHeaders.Accept.Clear();
                //Tell the server the type of file I am looking for to come back
                client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));

                try
                {
                    HttpResponseMessage response = await client.GetAsync(endpoint, HttpCompletionOption.ResponseHeadersRead);
                    response.EnsureSuccessStatusCode();
                    //Go get it...
                    var data = await response.Content.ReadAsStringAsync();
                    //Data is a big string...
                    return data;
                }
                catch (HttpRequestException hre)
                {
                    var msg = hre.Message;
                    return ("httpRequest" + msg);
                }
                catch (Exception e)
                {
                    var msg = e.Message;
                    return ("Ex: " + msg);
                }
            }
        }
    }
}
