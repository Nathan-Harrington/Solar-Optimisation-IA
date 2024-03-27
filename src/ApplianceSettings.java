import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class ApplianceSettings extends JInternalFrame { //SHOULD BE MODEL ON HOW TO DO THIS GUI
    JPanel basePanel = new JPanel(new FlowLayout());
    JTextField numberOfTimes = new JTextField("Enter number of times needed to run appliance"); //NEED TO SANITISE INPUT?
    JButton numTimesButton = new JButton("Submit");
    JLabel tempTimesDisplay = new JLabel(" ");
    DbFunctions db = new DbFunctions();
    Connection conn = db.connect_to_db("solardb", "postgres", "solar");
    //JToggleButton
    public ApplianceSettings(String name){
        //CONSTRUCT POPUP
        this.setTitle(name);
        this.setResizable(true);
        this.setClosable(true);
        this.setMaximizable(true);
        //DISPLAY
        displaySettings(this);
        //ADD COMPONENTS
        this.add(basePanel);
        basePanel.add(numberOfTimes);
        basePanel.add(numTimesButton);
        basePanel.add(tempTimesDisplay);
        //INPUT BUTTON
        numTimesButton.addActionListener(e -> storeToDB(name));
    }

    public void displaySettings(ApplianceSettings appliance){
        Scheduler.centerContainerPanel.add(appliance, BorderLayout.CENTER);
        appliance.setVisible(true);
    }
    public void storeToDB(String name){
            tempTimesDisplay.setText(numberOfTimes.getText());
            int temp = Integer.valueOf(numberOfTimes.getText());
            numberOfTimes.setText("  ");
            DbFunctions.update_appliance_cycles_num(conn, "appliances", name, temp); //NEED TO FIX
    }
}
