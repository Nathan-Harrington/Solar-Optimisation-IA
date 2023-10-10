package DashboardPanelsandAPI;

import javax.swing.*;
import java.awt.*;

public class WeatherTable extends JTable { //Could Use Scroll Panel for Table

    String[] columnNames = {"Hour", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    String[][] sampleData = {{"0:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
                            {"0:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
    };
    JTable table = new JTable(sampleData, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    public WeatherTable(){
        this.add(scrollPane);
    }

}
