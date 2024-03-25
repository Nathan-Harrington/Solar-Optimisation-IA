import DashboardPanelsandAPI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class Scheduler {
    static JPanel schedulerwindow = new JPanel(new BorderLayout());
    static ApplianceButton appliancebutton = new ApplianceButton("Modify Appliances");
    static JPanel centerContainerPanel = new JPanel(); //Border Layout seems to force component to take up entire panel

    public Scheduler(){
        //Instantiates Panels
        HeaderPanel headerPanel1 = new HeaderPanel();
        JPanel buttonContainerPanel = new JPanel(new FlowLayout());

        //centerContainerPanel styling
        centerContainerPanel.setLayout(new BoxLayout(centerContainerPanel, BoxLayout.Y_AXIS));

        //Instantiates Header
        HeaderLabel header1 = new HeaderLabel();
        header1.setText("Scheduler");
        RetrieveButton retrievebutton = new RetrieveButton("Get Schedule");

        //Adds Components to Panels
        headerPanel1.add(header1);
        buttonContainerPanel.add(appliancebutton);
        buttonContainerPanel.add(retrievebutton);

        //Add button panel to central panel
        centerContainerPanel.add(buttonContainerPanel, BorderLayout.NORTH);


        //Adds Components to Window
        schedulerwindow.add(headerPanel1, BorderLayout.NORTH);
        schedulerwindow.add(centerContainerPanel, BorderLayout.CENTER);
        Main.window1.add(schedulerwindow);
    }
}
