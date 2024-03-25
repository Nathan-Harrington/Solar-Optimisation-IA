import javax.swing.*;
import java.awt.*;

public class ApplianceSettings extends JInternalFrame {
    public ApplianceSettings(String name){
        this.setTitle(name);
        this.setResizable(true);
        this.setClosable(true);
        this.setMaximizable(true);
        displaySettings(this);
        

    }
    public void displaySettings(ApplianceSettings appliance){
        Scheduler.centerContainerPanel.add(appliance, BorderLayout.CENTER);
        appliance.setVisible(true);
    }
}
