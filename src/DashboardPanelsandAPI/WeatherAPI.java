package DashboardPanelsandAPI;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class WeatherAPI {
    private static String returnString = "";
    private static String returnCloudCover = null; //CAN BE MODIFIED TO BE PRIVATE AND SET WITH SETTER METHOD
    private static String[] cloudCoverArray = null;
    private static Integer cloudCoverStart = 0;
    private static Integer cloudCoverEnd = 0;
    public static void QueryAPI(){
        try {
            URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=-35.42&longitude=149.24&hourly=cloud_cover&timezone=Australia%2FSydney&forecast_days=14");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect(); //establishes a connection with the API

            //Check if connect is made
            int responseCode = conn.getResponseCode(); //response code by the connection

            // 200 OK
            if (responseCode != 200) { //if the response is good 200 is returned thus this occurs if the code is not working
                throw new RuntimeException("HttpResponseCode: " + responseCode); //returns to the catch block through "throw"
            } else {

                StringBuilder informationString = new StringBuilder(); //used to return a string from an API
                Scanner scanner = new Scanner(url.openStream()); //Scanner reads from the string returned by the API

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine()); // values are continually added whilst the API is returning information
                }
                //Close the scanner
                scanner.close();

                //returns the API information as parseable string
                returnString = informationString.toString();
                System.out.println("Return String" + returnString);
            }
        } catch (Exception e) { //Given any error
            e.printStackTrace(); //Print error to console
        }

        //Sanitising Output
        cloudCoverStart = returnString.lastIndexOf("cloud_cover") + 14; //stores index of cloud_coverage percentages
        cloudCoverEnd = returnString.length() - 3; //removes end of string
        returnCloudCover = returnString.substring(cloudCoverStart, cloudCoverEnd);
        cloudCoverArray = returnCloudCover.split(",");
    }

    public static String[] getCloudCoverArray() {
        //System.out.println(Arrays.toString(cloudCoverArray));
        //System.out.println(cloudCoverArray.length);
        return cloudCoverArray;
    }
}


//CODE TAKEN FROM https://www.youtube.com/watch?v=zZoboXqsCNw&t=336s <<RANDOM CODE>> Needs to be referenced or changed