package DashboardPanelsandAPI;

import javax.swing.*;
import java.awt.*;

public class WeatherTable extends JTable { //Could Use Scroll Panel for Table
    static String[] columnNames = {"Hour", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    static Object[][] sampleData = {{"0:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"1:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
    };


    public WeatherTable(){

    }

}
