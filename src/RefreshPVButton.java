import DashboardPanelsandAPI.MetricPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RefreshPVButton extends JButton {
    public RefreshPVButton(String text){
        this.setPreferredSize(new Dimension(200,75));
        this.addActionListener(e -> System.out.println("input 2 received"));
        this.addActionListener(e -> displayBatteryButton());

        this.setText(text);

        //Styling
        this.setBackground(new Color(0x8FC089));
        this.setForeground(new Color(0xFAF3DD));
        Border border = BorderFactory.createLineBorder(new Color(0x68b0ab), 3);
        this.setBorder(border);
    }
    public void displayBatteryButton(){
        MetricPanel.displayStatistics();
    }
}
