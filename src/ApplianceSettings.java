import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class ApplianceSettings extends JInternalFrame { //SHOULD BE MODEL ON HOW TO DO THIS GUI
    //DEFINE DB CONNECTIOn
    DbFunctions db = new DbFunctions();
    Connection conn = db.connect_to_db("solardb", "postgres", "solar");
    //PANELS
    JPanel numTimesPanel = new JPanel(new FlowLayout()); //panel for the input of the number of times needed to be run input
    JPanel basePanel = new JPanel(new GridLayout(3, 1, 10, 10)); //namesake panel
    JPanel boolPanel = new JPanel(new FlowLayout()); //Panel for Boolean toggles
    JPanel saveBoolPanel = new JPanel(new FlowLayout()); //Save Button Panel for Appliances
    //NUMBER OF TIMES COMPONENT
    JTextField numberOfTimes = new JTextField("Enter number of times needed to run appliance"); //NEED TO SANITISE INPUT?
    JButton numTimesButton = new JButton("Save"); //COULD MAKE SAVE

    //Boolean Components
    JToggleButton Monday = new JToggleButton();
    JToggleButton Tuesday = new JToggleButton();
    JLabel tempBoolDisplay = new JLabel(" ");
    JButton saveBool = new JButton("Save Day Preferences");

    //Boolean Array
    JToggleButton[] buttons = {Monday, Tuesday};
    public ApplianceSettings(String name){
        //CONSTRUCT POPUP
        this.setTitle(name);
        this.setResizable(true);
        this.setClosable(true);
        this.setMaximizable(true);
        //DISPLAY
        displaySettings(this);

        //ADD COMPONENTS FOR NUMBER OF TIMES NEEDED TO RUN
        basePanel.add(numTimesPanel);
        this.add(basePanel);
        numTimesPanel.add(numberOfTimes);
        numTimesPanel.add(numTimesButton);


        //BOOLEAN VARIABLES COULD TURN INTO A FUNCTION?
        boolean boolMonday = db.return_bool_day(conn, "appliances", "monday", name);
        Monday.setSelected(boolMonday);
        if(Monday.isSelected()){ //Check on Button Click
            Monday.setText("Run on Monday");
        }
        else{
            Monday.setText("Don't Run on Monday");
        }

        boolean boolTuesday = db.return_bool_day(conn, "appliances", "tuesday", name);
        Tuesday.setSelected(boolTuesday);
        if(Tuesday.isSelected()){ //Check on Button Click
            Tuesday.setText("Run on Tuesday");
        }
        else{
            Tuesday.setText("Don't Run on Tuesday");
        }

        String[] weekNames = {"monday", "tuesday"};
        //INPUT BUTTON
        numTimesButton.addActionListener(e -> storeToDB(name));
        Monday.addActionListener(e -> updateBoolText(Monday));
        Tuesday.addActionListener(e -> updateBoolText(Tuesday));
        saveBool.addActionListener(e -> saveBoolstoDb(weekNames, buttons, name)); //NEeDS TO BE LOOPED AND GENERALISED
        //BOOLEAN COMPONENTS
        boolPanel.add(Monday);
        boolPanel.add(Tuesday);
        saveBoolPanel.add(saveBool);
        //ADD FINAL PANELS
        basePanel.add(saveBoolPanel);
        basePanel.add(boolPanel);
    }

    public void displaySettings(ApplianceSettings appliance){
        Scheduler.centerContainerPanel.add(appliance, BorderLayout.CENTER);
        appliance.setVisible(true);
    }
    public void storeToDB(String name){ //NEEDS TO BE REPEATED AND GENERALISED ERROR MESSAGE AS WELL !!!!!!!!!!
            int temp = Integer.valueOf(numberOfTimes.getText());
            numberOfTimes.setText("Input Recieved");
            db.update_column_int(conn, "appliances", name, temp, "appliance_cycles_num");
    }
    public void updateBoolText(JToggleButton day){ //NEEDS TO BE REPEATED AND GENERALISED
        if(day.isSelected()){ //Check on Button Click
            day.setText("Run on Monday");
        }
        else{
            day.setText("Don't Run on Monday");
        }
    }
    public void saveBoolstoDb(String[] names, JToggleButton[] days, String applianceType){ //NEEDS TO BE REPEATED AND GENERALISED
        for(int i = 0; i < 7; i++) {
            String daystring = String.format("appliance_%s", names[i]);
            boolean newValue = days[i].isSelected();
            System.out.println(applianceType);
            System.out.println(days[i].isSelected());
            if (days[i].isSelected()) { //Check on Button Click
                db.update_column_bool(conn, "appliances", daystring, newValue, applianceType);
            } else {
                db.update_column_bool(conn, "appliances", daystring, newValue, applianceType);
            }
        }
    }
}
