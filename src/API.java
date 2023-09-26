import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class API {
    private static String ReturnString = "";
    private static String[] ReturnArray = null; //CAN BE MODIFIED TO BE PRIVATE AND SET WITH SETTER METHOD
    public API(){

    }
    public static void QueryAPI(){ //CODE TAKEN FROM https://www.youtube.com/watch?v=zZoboXqsCNw&t=336s <<RANDOM CODE>> Needs to be referenced or changed
        try {
            URL url = new URL("https://www.solaxcloud.com/proxyApp/proxy/api/getRealtimeInfo.do?tokenId=20230214094126383592133&sn=SEP8HB9UUF");

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

                ReturnString = informationString.toString();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ReturnArray = ReturnString.split(",");
    }


    public static String GetBatteryLevel(){
        return ReturnArray[11].substring(6, ReturnArray[11].length());
    }

    public static String GetEnergyProduced(){
        return ReturnArray[5].substring(13, ReturnArray[5].length());
    }
}