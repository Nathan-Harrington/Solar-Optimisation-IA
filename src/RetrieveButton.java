import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.Connection;
import java.util.Arrays;

public class RetrieveButton extends JButton{

    public RetrieveButton(String text){
        this.setPreferredSize(new Dimension(200,75));
        this.addActionListener(e -> System.out.println("schedule input received"));
        this.setText(text);
        this.addActionListener(e -> displaySchedule());
        //Styling
        this.setBackground(new Color(0x8FC089));
        this.setForeground(new Color(0xFAF3DD));
        Border border = BorderFactory.createLineBorder(new Color(0x68b0ab), 3);
        this.setBorder(border);
    }
    public static void displaySchedule(){
        ScheduleData sdfunctions = new ScheduleData();
        sdfunctions.retrieveVariables();
        //ScheduleData.data[0][1] = "test";
        //System.out.println(Arrays.deepToString(ScheduleData.data));
        //Scheduler.setTable();
    }
}

