package DashboardPanelsandAPI;

import javax.swing.JLabel;
import java.awt.*;
import javax.swing.border.*;

public class HeaderLabel extends JLabel { //REMEMBER LABELS TAKE UP AS MUCH SPACE AS POSSIBLE
    public HeaderLabel(){
        //Styling
        //this.setForeground(new Color(0xFAF3DD));
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
    }
}
