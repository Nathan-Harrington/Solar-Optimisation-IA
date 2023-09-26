import java.awt.*;

public class Main {
    //COULD MAKE THIS MAIN CLASS ITS OWN DASHBOARD CLASS WHICH IS THEN CALLED IN THE MAIN CLASS WHICH WOULD HAVE TO BE MADE AGAIN
    //Instantiates Button
    static SchedulerButton takeToScheduler = new SchedulerButton("Scheduler"); //Declare Button Publicly
    static RefreshPVButton refreshPVMetrics = new RefreshPVButton("Refresh PV Metrics"); //Declare Button Publicly
    public static void main(String[] args) {
        //Instantiates Window
        MyFrame window1 = new MyFrame();

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
        window1.add(headerPanel1, BorderLayout.NORTH); //Formatted to top
        window1.add(centerContainerPanel1);
        window1.add(decorativePanel1, BorderLayout.WEST);
        window1.add(decorativePanel2, BorderLayout.EAST);
        window1.add(decorativePanel3, BorderLayout.SOUTH);

        window1.setVisible(true);
    }
}