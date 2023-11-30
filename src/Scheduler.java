import DashboardPanelsandAPI.*;

import javax.swing.*;
import java.awt.*;

public class Scheduler {
    static JPanel schedulerwindow = new JPanel(new BorderLayout());
    public Scheduler(){
        //Instantiates Panels
        HeaderPanel headerPanel1 = new HeaderPanel();
        CenterContainerPanel centerContainerPanel = new CenterContainerPanel();

        //Instantiates Header
        HeaderLabel header1 = new HeaderLabel();
        header1.setText("Scheduler");
        ApplianceButton appliancebutton = new ApplianceButton("Modify Appliances");

        //Adds Components to Panels
        headerPanel1.add(header1);
        centerContainerPanel.add(appliancebutton, BorderLayout.NORTH);

        //Adds Components to Window
        schedulerwindow.add(headerPanel1, BorderLayout.NORTH);
        schedulerwindow.add(centerContainerPanel);
        Main.window1.add(schedulerwindow);
    }
}
