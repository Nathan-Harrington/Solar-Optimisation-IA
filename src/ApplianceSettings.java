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
    JPanel maxDailyPanel = new JPanel(new FlowLayout()); //panel for the input of the number of times needed to be run input
    JPanel basePanel = new JPanel(new GridLayout(4, 1, 10, 10)); //namesake panel
    JPanel boolPanel = new JPanel(new FlowLayout()); //Panel for Boolean toggles
    JPanel saveBoolPanel = new JPanel(new FlowLayout()); //Save Button Panel for Appliances
    //NUMBER OF TIMES COMPONENT
    JTextField numberOfTimes = new JTextField("Enter number of times to run appliance"); //NEED TO SANITISE INPUT?
    JButton numTimesButton = new JButton("Save"); //COULD MAKE SAVE
    JLabel errornumTimes = new JLabel("");

    //NUMBER OF TIMES COMPONENT
    JTextField maxDaily = new JTextField("Enter maximum number of cycles per day"); //NEED TO SANITISE INPUT?
    JButton maxDailyButton = new JButton("Save"); //COULD MAKE SAVE
    JLabel errormaxDaily = new JLabel("");

    //Boolean Components
    JToggleButton Monday = new JToggleButton();
    JToggleButton Tuesday = new JToggleButton();
    JToggleButton Wednesday = new JToggleButton();
    JToggleButton Thursday  = new JToggleButton();
    JToggleButton Friday  = new JToggleButton();
    JToggleButton Saturday = new JToggleButton();
    JToggleButton Sunday = new JToggleButton();
    JButton saveBool = new JButton("Save Day Preferences");
    JLabel errorBool = new JLabel("");

    //Boolean Array
    JToggleButton[] buttons = {Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday};
    public ApplianceSettings(String name){
        //CHECK ERROR BETWEEN VALUES IF days and maxDaily cannot produce numberofTimes
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
        numTimesPanel.add(errornumTimes);
        numTimesPanel.add(numberOfTimes);
        numberOfTimes.setColumns(25);
        numTimesPanel.add(numTimesButton);

        //COMPONENTS FOR MAX DAILY
        basePanel.add(maxDailyPanel);
        this.add(basePanel);
        maxDailyPanel.add(errormaxDaily);
        maxDailyPanel.add(maxDaily);
        maxDailyPanel.add(maxDailyButton);
        maxDaily.setColumns(25);


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

        boolean boolWednesday = db.return_bool_day(conn, "appliances", "wednesday", name);
        Wednesday.setSelected(boolWednesday);
        if(Wednesday.isSelected()){ //Check on Button Click
            Wednesday.setText("Run on Wednesday");
        }
        else{
            Wednesday.setText("Don't Run on Wednesday");
        }

        boolean boolThursday = db.return_bool_day(conn, "appliances", "thursday", name);
        Thursday.setSelected(boolThursday);
        if(Thursday.isSelected()){ //Check on Button Click
            Thursday.setText("Run on Thursday");
        }
        else{
            Thursday.setText("Don't Run on Thursday");
        }

        boolean boolFriday = db.return_bool_day(conn, "appliances", "friday", name);
        Friday.setSelected(boolFriday);
        if(Friday.isSelected()){ //Check on Button Click
            Friday.setText("Run on Friday");
        }
        else{
            Friday.setText("Don't Run on Friday");
        }

        boolean boolSaturday = db.return_bool_day(conn, "appliances", "saturday", name);
        Saturday.setSelected(boolSaturday);
        if(Saturday.isSelected()){ //Check on Button Click
            Saturday.setText("Run on Saturday");
        }
        else{
            Saturday.setText("Don't Run on Saturday");
        }

        boolean boolSunday = db.return_bool_day(conn, "appliances", "sunday", name);
        Sunday.setSelected(boolSunday);
        if(Sunday.isSelected()){ //Check on Button Click
            Sunday.setText("Run on Sunday");
        }
        else{
            Sunday.setText("Don't Run on Sunday");
        }
        String[] weekNames = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};

        //INPUT BUTTON
        numTimesButton.addActionListener(e -> storeToDB(name, "appliance_cycles_num", numberOfTimes, errornumTimes));
        maxDailyButton.addActionListener(e -> storeToDB(name, "max_daily", maxDaily,errormaxDaily ));

        Monday.addActionListener(e -> updateBoolText(Monday, "Monday"));
        Tuesday.addActionListener(e -> updateBoolText(Tuesday, "Tuesday"));
        Wednesday.addActionListener(e -> updateBoolText(Wednesday, "Wednesday"));
        Thursday.addActionListener(e -> updateBoolText(Thursday, "Thursday"));
        Friday.addActionListener(e -> updateBoolText(Friday, "Friday"));
        Saturday.addActionListener(e -> updateBoolText(Saturday, "Saturday"));
        Sunday.addActionListener(e -> updateBoolText(Sunday, "Sunday"));
        saveBool.addActionListener(e -> saveBoolstoDb(weekNames, buttons, name)); //NEeDS TO BE LOOPED AND GENERALISED

        //BOOLEAN COMPONENTS
        boolPanel.add(Monday);
        boolPanel.add(Tuesday);
        boolPanel.add(Wednesday);
        boolPanel.add(Thursday);
        boolPanel.add(Friday);
        boolPanel.add(Saturday);
        boolPanel.add(Sunday);
        saveBoolPanel.add(errorBool);
        saveBoolPanel.add(saveBool);

        //ADD FINAL PANELS
        basePanel.add(boolPanel);
        basePanel.add(saveBoolPanel);
    }

    public void displaySettings(ApplianceSettings appliance){
        Scheduler.centerContainerPanel.add(appliance, BorderLayout.CENTER);
        appliance.setVisible(true);
    }
    public void storeToDB(String name, String column_name, JTextField input, JLabel errorDisplay){
        try { //first try the following...
            int temp = Integer.valueOf(input.getText()); //take text field input and convert it into a string
            if((column_name.equals("max_daily") && temp < 7 && temp >0) || (column_name.equals("appliance_cycles_num") && temp < 43)){
                errorDisplay.setText("");//check number is not too large or negative
                input.setText("Input Received"); //Tell user their input was received
                db.update_column_int(conn, "appliances", name, temp, column_name); //update database
                Scheduler.resetTable(); //reset schedule to be regenerated
                if((column_name.equals("appliance_cycles_num") && temp > 30)){ //check number of cycles is not greater than 30
                    errorDisplay.setText("The schedule may not be able to schedule the requisite number of cycles"); //warn excessive scheduling
                }
            }
            else if(column_name.equals("max_daily")){
                errorDisplay.setText("Please enter a number between 1 and 6"); //warn number is not in correct range
            }
            else if(column_name.equals("appliance_cycles_num")){
                errorDisplay.setText("Please enter a number between 1 and 42"); //warn number is not in correct range
            }
        }
        catch(NumberFormatException exception){ //if an exception is thrown try this instead...
            errorDisplay.setText("Please enter a number"); //set error
        }

    }
    public void updateBoolText(JToggleButton day, String dayname){ //NEEDS TO BE REPEATED AND GENERALISED
        if(day.isSelected()){ //Check on Button Click
            day.setText(String.format("Run on %s", dayname));
        }
        else{
            day.setText(String.format("Don't Run on %s", dayname));
        }
    }
    public void saveBoolstoDb(String[] names, JToggleButton[] days, String applianceType) { //NEEDS TO BE REPEATED AND GENERALISED
        int count = 0;
        errorBool.setText("");
        for (int i = 0; i < 7; i++) {
            if (days[i].isSelected() == true) {
                count += 1;
            }
        }
        if (count > 2) {
            for (int i = 0; i < 7; i++) { //Check i < 7 when adding rest of the days
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
            Scheduler.resetTable();
        } else {
            errorBool.setText("At least three days need to be selected to be run");
        }
    }
}
