import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.Connection;
import java.util.Arrays;

public class RetrieveButton extends JButton{

    public RetrieveButton(String text){
        this.setPreferredSize(new Dimension(200,75));
        this.addActionListener(e -> System.out.println("schedule input received")); //call function to retrieve database values
        this.setText(text);
        this.addActionListener(e -> displaySchedule()); //call function to display the schedule
        //Styling
        this.setBackground(new Color(0x686de0));
        this.setForeground(new Color(0xFAF3DD));
        Border border = BorderFactory.createLineBorder(new Color(0x22a6b3), 2);
        this.setBorder(border);
    }
    public static void displaySchedule(){
        ScheduleData sdfunctions = new ScheduleData();
        sdfunctions.retrieveVariables();
    }
}

