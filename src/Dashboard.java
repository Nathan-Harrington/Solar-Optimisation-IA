import DashboardPanelsandAPI.*;

import javax.swing.*;
import java.awt.*;
public class Dashboard {
    //COULD MAKE THIS MAIN CLASS ITS OWN DASHBOARD CLASS WHICH IS THEN CALLED IN THE MAIN CLASS WHICH WOULD HAVE TO BE MADE AGAIN
    //Instantiates Button
    static SchedulerButton takeToScheduler = new SchedulerButton("Press to go to Scheduler"); //Declare Button Publicly
    static RefreshPVButton refreshPVMetrics = new RefreshPVButton("Press to refresh PV Metrics"); //Declare Button Publicly
    static JPanel dashboardwindow = new JPanel(new BorderLayout());
    public Dashboard() {
        //Instantiates Window
        API.QueryAPI();
        WeatherAPI.QueryAPI();


        //Instantiates Panels
        HeaderPanel headerPanel1 = new HeaderPanel();
        CenterContainerPanel centerContainerPanel1 = new CenterContainerPanel();
        ToolBarPanel toolBarPanel1 = new ToolBarPanel();
        MetricPanel metricPanel = new MetricPanel();
        DecorativePanel decorativePanel1 = new DecorativePanel();
        DecorativePanel decorativePanel2 = new DecorativePanel();
        DecorativePanel decorativePanel3 = new DecorativePanel();


        //Instantiates Header
        HeaderLabel header1 = new HeaderLabel();
        header1.setText("Dashboard");


        //Adds Components to Panel
        headerPanel1.add(header1, BorderLayout.CENTER);
        toolBarPanel1.add(takeToScheduler, BorderLayout.CENTER);
        toolBarPanel1.add(refreshPVMetrics, BorderLayout.CENTER);
        centerContainerPanel1.add(toolBarPanel1, BorderLayout.NORTH);
        centerContainerPanel1.add(metricPanel, BorderLayout.CENTER);


        //Adds Panel to Window
        dashboardwindow.add(headerPanel1, BorderLayout.NORTH); //Formatted to top
        dashboardwindow.add(centerContainerPanel1, BorderLayout.CENTER);
        dashboardwindow.add(decorativePanel1, BorderLayout.WEST);
        dashboardwindow.add(decorativePanel2, BorderLayout.EAST);
        dashboardwindow.add(decorativePanel3, BorderLayout.SOUTH);

        //Initialises Dashboard
        Main.window1.add(dashboardwindow);
        Main.window1.setVisible(true);


    }
}