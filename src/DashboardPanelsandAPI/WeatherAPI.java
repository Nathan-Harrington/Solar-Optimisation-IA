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
    public WeatherAPI(){ //Could make one API Class

    }
    public static void QueryAPI(){ //CODE TAKEN FROM https://www.youtube.com/watch?v=zZoboXqsCNw&t=336s <<RANDOM CODE>> Needs to be referenced or changed
        try {
            //URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=-35.42&longitude=149.24&hourly=cloudcover&timezone=auto"); //https://open-meteo.com/ to go to find a weather API
            URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=-35.42&longitude=149.24&hourly=cloud_cover&timezone=Australia%2FSydney&forecast_days=14");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                returnString = informationString.toString();
                System.out.println("Return String" + returnString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Sanitising Output
        cloudCoverStart = returnString.lastIndexOf("cloud_cover") + 14; //stores index of cloud_coverage percentages
        //System.out.println(cloudCoverStart);
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