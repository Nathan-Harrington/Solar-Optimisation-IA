package DashboardPanelsandAPI;

import javax.swing.*;
import java.awt.*;

public class MetricPanel extends JPanel {
    //OTHER METRICS SIMPLY NOT PROVIDED BY DashboardPanels.API PERHAPS PROVIDE ALTERNATE METRICS
    //JLabel testRaw = new JLabel(DashboardPanels.API.GetRawReturn()); Test Returns entire response
    static String[] cloudCoverArray = WeatherAPI.getCloudCoverArray();
    static Object[][] WeatherData = {{"0:00", "22%", "35%", "56%", "23%", "12%", "52%", "98%"},
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

    static JLabel batteryLevel = new JLabel("Battery Percentage (%) : " + API.GetBatteryLevel() + "%");
    static JLabel energyProduced = new JLabel("Energy Produced (kwh) : " + API.GetEnergyProduced() + "kwh");
    static JTable weatherTable = new JTable(WeatherData, WeatherTable.columnNames);

    public MetricPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        batteryLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
        energyProduced.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Adds Components
        //this.add(testRaw);
        this.add(Box.createRigidArea(new Dimension(0, 50))); //Spacer Components
        this.add(batteryLevel);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(energyProduced);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(new JScrollPane(weatherTable));
        WeatherData = setWeatherData(WeatherData);
    }

    public static void displayStatistics(){
        API.QueryAPI();
        batteryLevel.setText("Battery Percentage (%) : " + API.GetBatteryLevel() + "%");
        System.out.println("Battery Percentage (%) : " + API.GetBatteryLevel() + "%");

        energyProduced.setText("Energy Produced (kwh) : " + API.GetEnergyProduced() + "kwh");
        System.out.println("Energy Produced (kwh) : " + API.GetEnergyProduced() + "kwh");
    }
    public Object[][] setWeatherData(Object[][] sampleData) {
        int count = 0;
        for(int i = 1; i < 24; i ++){
            for(int j = 1; j < 8; j++){
                count = count + 1;
                sampleData[i][j] = cloudCoverArray[count];
            }
        }
        return sampleData;
    }
}
