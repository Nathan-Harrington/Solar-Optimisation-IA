package DashboardPanelsandAPI;

import javax.swing.*;
import java.awt.*;

public class MetricPanel extends JPanel {
    //OTHER METRICS SIMPLY NOT PROVIDED BY DashboardPanels.API PERHAPS PROVIDE ALTERNATE METRICS
    //JLabel testRaw = new JLabel(DashboardPanels.API.GetRawReturn()); Test Returns entire response
    static JLabel batteryLevel = new JLabel("Battery Percentage (%) : " + API.GetBatteryLevel() + "%");
    static JLabel energyProduced = new JLabel("Energy Produced (kwh) : " + API.GetEnergyProduced() + "kwh");
    static WeatherTable weatherTable = new WeatherTable();

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
        this.add(weatherTable);
    }

    public static void displayStatistics(){
        API.QueryAPI();
        batteryLevel.setText("Battery Percentage (%) : " + API.GetBatteryLevel() + "%");
        System.out.println("Battery Percentage (%) : " + API.GetBatteryLevel() + "%");

        energyProduced.setText("Energy Produced (kwh) : " + API.GetEnergyProduced() + "kwh");
        System.out.println("Energy Produced (kwh) : " + API.GetEnergyProduced() + "kwh");
    }
}
