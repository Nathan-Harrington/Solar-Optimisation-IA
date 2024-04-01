import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SchedulerButton extends JButton {
    public SchedulerButton(String text){
        this.setPreferredSize(new Dimension(200,75));
        this.addActionListener(e -> System.out.println("input 1 received"));
        this.addActionListener(e -> Main.SchedulerOff());
        this.setText(text);

        //Styling
        this.setBackground(new Color(0x686de0));
        this.setForeground(new Color(0xFAF3DD));
        Border border = BorderFactory.createLineBorder(new Color(0x22a6b3), 2);
        this.setBorder(border);
    }
}
