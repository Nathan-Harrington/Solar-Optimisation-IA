import DashboardPanelsandAPI.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Scheduler {
    static JPanel schedulerwindow = new JPanel(new BorderLayout());
    static ApplianceButton appliancebutton = new ApplianceButton("Modify Appliances");
    static JPanel centerContainerPanel = new JPanel(); //Border Layout seems to force component to take up entire panel
    static DefaultTableModel scheduleModel = new DefaultTableModel(ScheduleData.data, new String[]{"Hour", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"});
    static JTable scheduleTable = new JTable(scheduleModel);
    static JScrollPane tableContainerPanel = new JScrollPane(scheduleTable);
    public static void setTable(){
        DefaultTableModel scheduleModel = new DefaultTableModel(ScheduleData.data, new String[]{"Hour", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"});
        scheduleTable.setModel(scheduleModel);
        tableContainerPanel.add(scheduleTable);
        centerContainerPanel.add(tableContainerPanel);
    }
        //JTable scheduleTable = new JTable(data, new String[]{"Hour", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"});
        //JScrollPane tableContainerPanel = new JScrollPane(scheduleTable);
        //return tableContainerPanel;
    //}
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
        centerContainerPanel.add(buttonContainerPanel);
        //Add table panel to central panel
        centerContainerPanel.add(tableContainerPanel);

        //Adds Components to Window
        schedulerwindow.add(headerPanel1, BorderLayout.NORTH);
        schedulerwindow.add(centerContainerPanel, BorderLayout.CENTER);
        Main.window1.add(schedulerwindow);
    }
}
