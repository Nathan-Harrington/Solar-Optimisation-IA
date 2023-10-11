package DashboardPanelsandAPI;

import javax.swing.*;
import java.awt.*;

public class WeatherTable extends JTable { //Could Use Scroll Panel for Table
    static String[] cloudCoverArray = WeatherAPI.getCloudCoverArray();
    static String[] columnNames = {"Hour", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    static Object[][] sampleData = {{"0:00", cloudCoverArray[0], "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"1:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"2:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"3:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"4:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"5:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"6:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"7:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"8:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"9:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"10:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"11:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"12:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"13:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"14:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"15:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"16:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"17:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"18:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"19:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"20:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"21:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"22:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"23:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"}
    };


    public WeatherTable(){

    }

}
