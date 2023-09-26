import DashboardPanelsandAPI.*;

import javax.swing.*;
import java.awt.*;

public class Scheduler {
    static JPanel schedulerwindow = new JPanel(new BorderLayout());
    public Scheduler(){
        //Instantiates Panels
        HeaderPanel headerPanel1 = new HeaderPanel();

        //Instantiates Header
        HeaderLabel header1 = new HeaderLabel();
        header1.setText("Scheduler");

        //Adds Components to Panels
        headerPanel1.add(header1);

        //Adds Components to Window
        schedulerwindow.add(headerPanel1, BorderLayout.NORTH);
        Main.window1.add(schedulerwindow);
    }
}
