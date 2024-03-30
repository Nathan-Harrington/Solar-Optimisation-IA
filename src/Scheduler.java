import DashboardPanelsandAPI.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;

public class Scheduler {
    static JPanel schedulerwindow = new JPanel(new BorderLayout());
    static ApplianceButton appliancebutton = new ApplianceButton("Modify Appliances");
    static JPanel centerContainerPanel = new JPanel(); //Border Layout seems to force component to take up entire panel
    static DefaultTableModel scheduleModel = new DefaultTableModel(ScheduleData.data, new String[]{"Hour", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"});
    static JTable scheduleTable = new JTable(scheduleModel);
    static JScrollPane tableContainerPanel = new JScrollPane(scheduleTable);
    public static void setTable(){
        //scheduleTable.repaint();
        DefaultTableModel scheduleModel = new DefaultTableModel(ScheduleData.data, new String[]{"Hour", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"});
        scheduleTable.setModel(scheduleModel);
        //tableContainerPanel.add(scheduleTable);
        //centerContainerPanel.add(tableContainerPanel);
    }
    public static void resetTable(){
        ScheduleData.data = new Object[][]{{"0:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"1:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"2:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"3:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"4:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"5:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"6:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"7:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"8:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"9:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"10:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"11:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"12:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"13:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"14:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"15:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"16:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"17:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"18:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"19:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"20:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"21:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"22:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
                {"23:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"}
        };
        DefaultTableModel scheduleModel = new DefaultTableModel(ScheduleData.data, new String[]{"Hour", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"});
        scheduleTable.setModel(scheduleModel);
    }
    //public static void resetTable(){
        //scheduleTable.repaint();
        //for(int i = 0; i < ScheduleData.data.length; i++){
            //Arrays.fill(ScheduleData.data[i], "No Device");
       // }
       // DefaultTableModel scheduleModel = new DefaultTableModel(ScheduleData.data, new String[]{"Hour", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"});
        //scheduleTable.setModel(scheduleModel);
       // tableContainerPanel.add(scheduleTable);
        //centerContainerPanel.add(tableContainerPanel);
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
